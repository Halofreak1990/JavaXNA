package Microsoft.Xna.Framework;

import java.util.*;

import System.*;
import Microsoft.Xna.Framework.Content.*;
import Microsoft.Xna.Framework.GamerServices.*;
import Microsoft.Xna.Framework.Graphics.*;

/**
 * Provides basic graphics device initialization, game logic, and rendering code.
 * 
 * @author Halofreak1990
 */
public class Game implements IDisposable
{
	private final long DefaultTargetElapsedTicks = 10000000L / 60L;
	private boolean inRun;
	private boolean isFixedTimeStep;
	private boolean isMouseVisible;
	private boolean isActive;
	long StartTime;

	private GameTime gameTime;

	GameComponentCollection components;
	ArrayList<IDrawable> visibleDrawable;
	ArrayList<IUpdateable> enabledUpdateable;
	
	GameServiceContainer services;
	boolean disposed;  

	TimeSpan inactiveSleepTime;
	
	
	/**
	 * Gets or sets the target time between calls to Update when IsFixedTimeStep is true.
	 */
	public TimeSpan TargetElapsedTime;
	
	/**
	 * Gets or sets the current ContentManager.
	 */
	public ContentManager Content;
	IGraphicsDeviceManager graphicsManager;
	IGraphicsDeviceService graphicsService;
	IGameHost gameHost;
	
	/**
	 * Raised when the game gains focus.
	 */
	public final Event<EventArgs> Activated = new Event<EventArgs>();
	
	/**
	 * Raised when the game loses focus.
	 */
	public final Event<EventArgs> Deactivated = new Event<EventArgs>();
	
	/**
	 * Raised when the game is being disposed.
	 */
	public final Event<EventArgs> Disposed = new Event<EventArgs>();
	
	/**
	 * Raised when the game is exiting.
	 */
	public final Event<EventArgs> Exiting = new Event<EventArgs>();
	
	/**
	 * Gets the current GraphicsDevice.
	 */
	public GraphicsDevice getGraphicsDevice()
	{
		if (graphicsService == null)
		{
			graphicsService = (IGraphicsDeviceService)this.getServices().GetService(IGraphicsDeviceService.class);

			if (graphicsService == null)
			{
				throw new InvalidOperationException();
			}
		}

		return graphicsService.getGraphicsDevice();
	}
	
	/**
	 * Indicates whether the game is currently the active application.
	 */
	public boolean getIsActive()
	{
		boolean isVisible = false;
		
		if (GamerServicesDispatcher.IsInitialized())
		{
			isVisible = Guide.IsVisible();
		}
		
		return isActive;
	}
	
	/**
	 * 
	 */
	public boolean getIsMouseVisible()
	{
		return isMouseVisible;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setIsMouseVisible(boolean value)
	{
		if (isMouseVisible == value)
		{
			return;
		}
		
		isMouseVisible = value;
		//Sdl.SDL_ShowCursor(isMouseVisible ? Sdl.SDL_ENABLE : Sdl.SDL_DISABLE);   
	}
	
	/**
	 * Gets the underlying operating system window.
	 */
	public GameWindow getWindow()
	{
		return (gameHost != null) ? gameHost.getWindow() : null;
	}
	
	/**
	 * Gets the GameServiceContainer holding all the service providers attached to the Game.
	 */
	public GameServiceContainer getServices()
	{
		return services;
	}
	
	/**
	 * Initializes a new instance of this class, which provides basic graphics device initialization, game logic, rendering code, and a game loop.
	 */
	public Game()
	{
		this.gameTime = new GameTime();
		this.isFixedTimeStep = true;
		
		inRun = false;
		
		visibleDrawable = new ArrayList<IDrawable>();
		enabledUpdateable = new ArrayList<IUpdateable>();
		
		components = new GameComponentCollection();
		components.ComponentAdded.addHandler(new GameComponentAdded());
		components.ComponentRemoved.addHandler(new GameComponentRemoved());
		
		services = new GameServiceContainer();
		
		Content = new ContentManager(services);
		
		inactiveSleepTime = TimeSpan.FromMilliseconds(20.0);
		TargetElapsedTime = TimeSpan.FromTicks(DefaultTargetElapsedTicks);
		
		gameHost = new GameHost(this);
		gameHost.EnsureHost();
		
		isActive = true;
	}
	
	/**
	 * 
	 */
	protected void BeginRun()
	{
	}
	
	/**
	 * 
	 * @return
	 */
	protected boolean BeginDraw()
	{
		if (isFixedTimeStep && gameTime.getIsRunningSlowly())
		{
			return false;
		}
		
		return graphicsManager.BeginDraw();
	}
	
	/**
	 * 
	 */
	public void Dispose()
	{
		Dispose(true);
	}
	
	/**
	 * 
	 * @param disposing
	 */
	protected void Dispose(boolean disposing)
	{
		if (disposed)
		{
			return;
		}
		
		// Dispose managed
		if (disposing)
		{
			for (IGameComponent component : components)
			{
				IDisposable disposable = (IDisposable)component;

				if (disposable != null)
				{
					disposable.Dispose();
				}
			}
		}
		
		// Dispose unmanaged
		//Sdl.SDL_Quit();
		
		disposed  = true;
		
		if (Disposed.hasHandlers())
		{
			Disposed.raise(this, EventArgs.Empty);
		}
	}
	
	/**
	 * 
	 * @param gameTime
	 */
	protected void Draw(GameTime gameTime)
	{
		for(IDrawable drawable : visibleDrawable)
		{
			drawable.Draw(gameTime);
		}
	}
	
	/**
	 * 
	 */
	protected void EndDraw()
	{
		graphicsManager.EndDraw();
	}
	
	/**
	 * Exits the game.
	 */
	public void Exit()
	{
		gameHost.Exit();
	}
	
	/**
	 * 
	 */
	protected void finalize()
	{
		Dispose(false);
	}
	
	private long getTicks()
	{
		return ((System.nanoTime() - StartTime) / 1000000);
	}
	
	/**
	 * Called after the Game and GraphicsDevice are created, but before LoadContent.
	 */
	@SuppressWarnings("static-access")
	protected void Initialize()
	{
		graphicsService = (IGraphicsDeviceService)getServices().GetService(IGraphicsDeviceService.class);
		
		if (graphicsService != null)
		{
			graphicsService.DeviceCreated.addHandler(DeviceCreated);
			graphicsService.DeviceResetting.addHandler(DeviceResetting);
			graphicsService.DeviceReset.addHandler(DeviceReset);
			graphicsService.DeviceDisposing.addHandler(DeviceDisposing);
		}
		
		for(IGameComponent gameComponent : components)
		{
			gameComponent.Initialize();
		}
		
		if ((this.graphicsService != null) && (this.graphicsService.getGraphicsDevice() != null))
		{
			LoadContent();
		}
	}
	
	/**
	 * 
	 */
	protected void LoadContent()
	{
		
	}
	
	/**
	 * Resets the elapsed time counter.
	 */
	public void ResetElapsedTime()
	{
		
	}
	
	/**
	 * Call this method to initialize the game, begin running the game loop, and start processing events for the game.
	 */
	public void Run()
	{
		if (inRun)
		{
			throw new InvalidOperationException("Run Method called more than once.");
		}
		
		inRun = true;
		
		BeginRun();
		
		gameHost.Initialize();
		
		graphicsManager = (IGraphicsDeviceManager)getServices().GetService(IGraphicsDeviceManager.class);
		
		if (graphicsManager != null)
		{
			graphicsManager.CreateDevice();
		}
		
		Initialize();

		isActive = true;

		gameHost.Run();

		EndRun();

		inRun = false;
	}

	private void EndRun()
	{
	}
	
	/**
	 * Run the game through what would happen in a single tick of the game clock; this method is designed for debugging only.
	 */
	public void RunOneFrame()
	{
		// TODO: implement
	}
	
	/**
	 * 
	 */
	public void Tick()
	{
		if (!this.isActive)
		{
			try { Thread.sleep(inactiveSleepTime.getMilliseconds()); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}
				
		TimeSpan elapsedUpdateTime = TimeSpan.FromMilliseconds(getTicks() - gameTime.getTotalGameTime().getTotalMilliseconds());
		
		if (isFixedTimeStep)
		{
			while (elapsedUpdateTime.CompareTo(TargetElapsedTime) == -1)
			{
				try
				{
					Thread.sleep(TargetElapsedTime.getMilliseconds() - elapsedUpdateTime.getMilliseconds());
					elapsedUpdateTime = TimeSpan.FromMilliseconds(getTicks() - gameTime.getTotalGameTime().getTotalMilliseconds());
				}
				catch (InterruptedException e) { e.printStackTrace(); }
			}
			
			gameTime.setElapsedGameTime(TargetElapsedTime);
			gameTime.setTotalGameTime(gameTime.getTotalGameTime().Add(TargetElapsedTime));
		}
		else
		{
			gameTime.setElapsedGameTime(elapsedUpdateTime);
			gameTime.setTotalGameTime(gameTime.getTotalGameTime().Add(elapsedUpdateTime));
		}
		
		Update(gameTime);
		
		elapsedUpdateTime = TimeSpan.FromMilliseconds(getTicks() - gameTime.getTotalGameTime().getTotalMilliseconds());
		
		if (isFixedTimeStep && elapsedUpdateTime.CompareTo(TargetElapsedTime) == 1)
		{
			gameTime.setIsRunningSlowly(true);
		}
		else
		{
			gameTime.setIsRunningSlowly(false);
		}
		
		if (!BeginDraw())
		{
			return;
		}
		
		Draw(gameTime);
		EndDraw();
	}

	/**
	 * 
	 */
	protected void UnloadContent()
	{	
	}
	
	/**
	 * 
	 * @param gameTime
	 */
	protected void Update(GameTime gameTime)
	{
		for (IUpdateable updateable : enabledUpdateable)
		{
			updateable.Update(gameTime);
		}
	}
	
	private class GameComponentAdded implements EventHandler<GameComponentCollectionEventArgs>
	{
		@SuppressWarnings("static-access")
		public void Invoke(Object sender, GameComponentCollectionEventArgs e)
		{
			if (inRun)
			{
				e.getGameComponent().Initialize();
			}
			else
			{
				
			}
			
			IDrawable d = (IDrawable)e.getGameComponent();
			
			if (d != null)
			{
				d.DrawOrderChanged.addHandler(DrawableDrawOrderChanged);
				d.VisibleChanged.addHandler(DrawableVisibleChanged);
				
				if (d.getVisible())
				{
					visibleDrawable.add(d);
				}
			}
			
			IUpdateable u = (IUpdateable)e.getGameComponent();
			
			if (u != null)
			{
				u.UpdateOrderChanged.addHandler(UpdateableUpdateOrderChanged);
				u.EnabledChanged.addHandler(UpdateableEnabledChanged);
				
				if (u.getEnabled())
					enabledUpdateable.add(u);
			}
		}
	}
	
	private class GameComponentRemoved implements EventHandler<GameComponentCollectionEventArgs>
	{
		@SuppressWarnings("static-access")
		public void Invoke(Object sender, GameComponentCollectionEventArgs e)
		{
			IDrawable d = (IDrawable)e.getGameComponent();

			if (d != null)
			{
				d.DrawOrderChanged.removeHandler(DrawableDrawOrderChanged);
				d.VisibleChanged.removeHandler(DrawableVisibleChanged);
				
				if (d.getVisible())
				{
					visibleDrawable.remove(d);
				}
			}
			
			IUpdateable u = (IUpdateable)e.getGameComponent();
			
			if (u != null)
			{
				u.UpdateOrderChanged.removeHandler(UpdateableUpdateOrderChanged);
				u.EnabledChanged.removeHandler(UpdateableEnabledChanged);
				
				if (u.getEnabled())
				{
					enabledUpdateable.remove(u);
				}
			}
		}
	}
	
	drawableDrawOrderChanged DrawableDrawOrderChanged = new drawableDrawOrderChanged();
	private class drawableDrawOrderChanged implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
			Collections.sort(visibleDrawable, DrawOrderComparer.Default); 
		}
	}
	
	drawableVisibleChanged DrawableVisibleChanged = new drawableVisibleChanged();
	private class drawableVisibleChanged implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
			IDrawable d = (IDrawable)sender;
			if (d.getVisible())
			{
				visibleDrawable.add(d);
				Collections.sort(visibleDrawable, DrawOrderComparer.Default);
			}
			else
				visibleDrawable.remove(d);
		}
	}
	
	updateableEnabledChanged UpdateableEnabledChanged = new updateableEnabledChanged();
	private class updateableEnabledChanged implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
			IUpdateable u = (IUpdateable)sender;
			if (u.getEnabled())
			{
				enabledUpdateable.add(u);
				Collections.sort(enabledUpdateable, UpdateOrderComparer.Default);
			}
			else
				enabledUpdateable.remove(u);
		}
	}
	
	updateableUpdateOrderChanged UpdateableUpdateOrderChanged = new updateableUpdateOrderChanged();
	private class updateableUpdateOrderChanged implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
			Collections.sort(enabledUpdateable, UpdateOrderComparer.Default);
		}
	}
	
	private class deviceCreated implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
			LoadContent();
		}
	}
	
	private class deviceResetting implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
			
		}
	}
	
	private class deviceReset implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
		}
	}
	
	private class deviceDisposing implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
			Content.Unload();
			UnloadContent();
		}
	}
	
	private final deviceCreated DeviceCreated = new deviceCreated();
	private final deviceResetting DeviceResetting = new deviceResetting();
	private final deviceReset DeviceReset = new deviceReset();
	private final deviceDisposing DeviceDisposing = new deviceDisposing();
}
