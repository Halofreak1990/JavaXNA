package Microsoft.Xna.Framework;

import java.util.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.DisplayMode;

import System.*;
import Microsoft.Xna.Framework.Graphics.*;

/**
 * Handles the configuration and management of the graphics device.
 * 
 * @author Halofreak1990
 */
public class GraphicsDeviceManager implements IGraphicsDeviceService, IDisposable, IGraphicsDeviceManager
{
	/**
	 * Specifies the default minimum back-buffer width.
	 */
	public static final int DefaultBackBufferWidth = 800;
	
	/**
	 * Specifies the default minimum back-buffer height.
	 */
	public static final int DefaultBackBufferHeight = 600;
	
	/**
	 * 
	 */
	public static final SurfaceFormat[] ValidAdapterFormats = new SurfaceFormat[] { SurfaceFormat.Bgra5551, SurfaceFormat.Rgba64, SurfaceFormat.Rgba1010102, SurfaceFormat.Bgra4444 };
	
	/**
	 * 
	 */
	public static final SurfaceFormat[] ValidBackBufferFormats = new SurfaceFormat[] { SurfaceFormat.Rgba1010102, SurfaceFormat.Rgba64, SurfaceFormat.Rg32, SurfaceFormat.Bgra5551, SurfaceFormat.Bgr565, SurfaceFormat.Bgra4444 };
	
	/**
	 * 
	 */
	public static final DeviceType[] ValidDeviceTypes = new DeviceType[] { DeviceType.Hardware };
	
	private GraphicsDevice device;
	private GraphicsProfile graphicsProfile;
	boolean isDisposed;
	
	/**
	 * 
	 */
	public ShaderProfile MinimumPixelShaderProfile;
	
	/**
	 * 
	 */
	public ShaderProfile MinimumVertexShaderProfile;
	
	/**
	 * 
	 */
	public boolean PreferMultiSampling;
	
	/**
	 * 
	 */
	public SurfaceFormat PreferredBackBufferFormat;
	
	/**
	 * 
	 */
	public int BackBufferHeight;
	
	/**
	 * 
	 */
	public int BackBufferWidth;
	
	/**
	 * 
	 */
	public boolean SynchronizeWithVerticalRetrace;
	
	private Game game;
	private boolean isDeviceDirty;
	
	/**
	 * 
	 */
	public boolean IsFullScreen;
	
	/**
	 * 
	 */
	public DepthFormat DepthStencilFormat;
	
	private boolean inDeviceTransition;
	
	public final Event<EventArgs> DeviceCreated = new Event<EventArgs>();
	public final Event<EventArgs> DeviceDisposing = new Event<EventArgs>();
	public final Event<EventArgs> DeviceReset = new Event<EventArgs>();
	public final Event<EventArgs> DeviceResetting = new Event<EventArgs>();
	public final Event<EventArgs> Disposed = new Event<EventArgs>();
	public final Event<PreparingDeviceSettingsEventArgs> PreparingDeviceSettings = new Event<PreparingDeviceSettingsEventArgs>();
	
	/**
	 * 
	 */
	public GraphicsDevice getGraphicsDevice()
	{
		return device;
	}
	
	/**
	 * 
	 * @return
	 */
	public GraphicsProfile getGraphicsProfile()
	{
		return this.graphicsProfile;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setGraphicsProfile(GraphicsProfile value)
	{
		this.graphicsProfile = value;
		this.isDeviceDirty = true;
	}
	
	/**
	 * Creates a new GraphicsDeviceManager and registers it to handle the configuration and management of the graphics device for the specified Game.
	 * 
	 * @param game
	 * Game the GraphicsDeviceManager should be associated with.
	 */
	public GraphicsDeviceManager(Game game)
	{
		SynchronizeWithVerticalRetrace = true;
		this.DepthStencilFormat = DepthFormat.Depth24;
		BackBufferWidth = DefaultBackBufferWidth;
		BackBufferHeight = DefaultBackBufferHeight;
		
		if (game == null)
		{
			throw new ArgumentNullException("game", "Game cannot be null.");
		}
		this.game = game;
		if (game.getServices().GetService(IGraphicsDeviceManager.class) != null)
		{
			throw new ArgumentException("A GraphicsDeviceManager is already registered. The graphics device manager cannot be changed once it is set.");
		}
		game.getServices().AddService(IGraphicsDeviceManager.class, this);
		game.getServices().AddService(IGraphicsDeviceService.class, this);
		
		device = null;

		PreferredBackBufferFormat = SurfaceFormat.Color;

		IsFullScreen = false;

		MinimumPixelShaderProfile = ShaderProfile.PS_1_1;
		MinimumVertexShaderProfile = ShaderProfile.VS_1_1;

		PreferMultiSampling = false;
	}
	
	/**
	 * Applies any changes to device-related properties, changing the graphics device as necessary.
	 */
	public void ApplyChanges()
	{
		if ((this.device != null) || this.isDeviceDirty)
		{
			this.ChangeDevice(false);
		}
		
		Display.setVSyncEnabled(SynchronizeWithVerticalRetrace);
	}
	
	private void ChangeDevice(boolean forceCreate)
	{
	    if (this.game == null)
	    {
	        throw new InvalidOperationException("Cannot commit or change device settings if the graphics component has not been added to a game's component list.");
	    }
	    this.inDeviceTransition = true;
	    String screenDeviceName = this.game.getWindow().getScreenDeviceName();
	    int width = this.game.getWindow().getClientBounds().Width;
	    int height = this.game.getWindow().getClientBounds().Height;
	    boolean flag = false;
	    try
	    {
	    	
	    	GraphicsDeviceInformation graphicsDeviceInformation = this.FindBestDevice(forceCreate);
	    	this.game.getWindow().BeginScreenDeviceChange(graphicsDeviceInformation.PresentationParameters.IsFullScreen);
	    	flag = true;
	    	boolean flag2 = true;
	    	if (!forceCreate && (this.device != null))
	    	{
	    		this.OnPreparingDeviceSettings(this, new PreparingDeviceSettingsEventArgs(graphicsDeviceInformation));
	    		if (this.CanResetDevice(graphicsDeviceInformation))
	    		{
	    			try
	    			{
	    				GraphicsDeviceInformation information2 = graphicsDeviceInformation.Clone();
	    				this.device.Reset(information2.PresentationParameters, information2.getAdapter());
	    				flag2 = false;
	    			}
	    			catch(SystemException ex)
	    			{
	    			}
	    		}
	    	}
	    	if (flag2)
	    	{
	    		this.CreateDevice(graphicsDeviceInformation);
	    	}
	    	PresentationParameters presentationParameters = this.device.getPresentationParameters();
	    	screenDeviceName = this.device.getAdapter().getDeviceName();
	    	this.IsFullScreen = presentationParameters.IsFullScreen;
	    	if (presentationParameters.BackBufferWidth != 0)
	    	{
	    		width = presentationParameters.BackBufferWidth;
	    	}
	    	if (presentationParameters.BackBufferHeight != 0)
	    	{
	    		height = presentationParameters.BackBufferHeight;
	    	}
	    	this.isDeviceDirty = false;
	    }
	    finally
	    {
	    	if (flag)
	    	{
	    		this.game.getWindow().EndScreenDeviceChange(screenDeviceName, width, height);
	    	}
	    	this.inDeviceTransition = false;
	    }
	}

	/**
	 * 
	 */
	public boolean BeginDraw()
	{
		return true;
	}
	
	/**
	 * 
	 * @param newInfo
	 * @return
	 */
	protected boolean CanResetDevice(GraphicsDeviceInformation newInfo)
	{
		return (this.device.getGraphicsProfile() == newInfo.GraphicsProfile);
	}

	/**
	 * Called to ensure that the device manager has created a valid device.
	 */
	@Override
	public void CreateDevice()
	{
		this.ChangeDevice(true);
	}
	
	private void CreateDevice(GraphicsDeviceInformation newInfo)
	{
		if(this.device != null)
		{
			this.device.Dispose();
			this.device = null;
		}
		OnPreparingDeviceSettings(this, new PreparingDeviceSettingsEventArgs(newInfo));
		
		try
		{
			GraphicsDevice device = new GraphicsDevice(newInfo.getAdapter(), newInfo.GraphicsProfile, newInfo.PresentationParameters);
			this.device = device;
			device.Disposing.addHandler(new OnDeviceDisposing());
			device.DeviceResetting.addHandler(new OnDeviceResetting());
			device.DeviceReset.addHandler(new OnDeviceReset());
		}
		catch(NoSuitableGraphicsDeviceException ex)
		{
			throw ex;
		}
		catch(ArgumentException exception)
		{
			throw new NoSuitableGraphicsDeviceException("The device creation parameters contain invalid configuration options.", exception);
		}
		catch(RuntimeException exception2)
		{
			throw new NoSuitableGraphicsDeviceException("Unable to create the graphics device.", exception2);
		}
		
		OnDeviceCreated(this, EventArgs.Empty);
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
		if (disposing)
		{
			if (this.game != null)
			{
				if (this.game.getServices().GetService(IGraphicsDeviceService.class) == this)
				{
					this.game.getServices().RemoveService(IGraphicsDeviceService.class);
				}
				// unlink window event handlers
			}
			if (this.device != null)
			{
				this.device.Dispose();
				this.device = null;
			}
			
			if (this.Disposed.hasHandlers())
				this.Disposed.raise(this, EventArgs.Empty);
		}
	}

	/**
	 * 
	 */
	@Override
	public void EndDraw()
	{
		if (this.device != null)
		{
			this.device.Present();
		}
	}
	
	/**
	 * 
	 * @param anySuitableDevice
	 * @return
	 */
	protected GraphicsDeviceInformation FindBestDevice(boolean anySuitableDevice)
	{
		return this.FindBestPlatformDevice(anySuitableDevice);
	}
	
	private GraphicsDeviceInformation FindBestPlatformDevice(boolean anySuitableDevice)
	{
		List<GraphicsDeviceInformation> graphicsDeviceInfoList = new ArrayList<GraphicsDeviceInformation>();

		try
		{
			DisplayMode[] modes = Display.getAvailableDisplayModes();
			
			if (modes.length > 0)
			{
				for (DisplayMode mode : modes)
				{
					if ((mode.getWidth() == BackBufferWidth) && (mode.getHeight() == BackBufferHeight))
						continue;
					
					GraphicsDeviceInformation gdi = new GraphicsDeviceInformation();
					gdi.setAdapter(GraphicsAdapter.getDefaultAdapter());
					gdi.GraphicsProfile = GraphicsProfile.HiDef;
					gdi.PresentationParameters.BackBufferWidth = BackBufferWidth;
					gdi.PresentationParameters.BackBufferHeight = BackBufferHeight;
					gdi.PresentationParameters.IsFullScreen = IsFullScreen;
					graphicsDeviceInfoList.add(gdi);
				}
			}
			else
			{
				GraphicsDeviceInformation info = new GraphicsDeviceInformation();
				info.setAdapter(GraphicsAdapter.getDefaultAdapter());
				info.PresentationParameters.BackBufferWidth = BackBufferWidth;
				info.PresentationParameters.BackBufferHeight = BackBufferHeight;
				info.PresentationParameters.BackBufferFormat = PreferredBackBufferFormat;
				info.PresentationParameters.IsFullScreen = IsFullScreen;
				graphicsDeviceInfoList.add(info);
			}
		}
		catch (LWJGLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RankDevices(graphicsDeviceInfoList);
		
		if (graphicsDeviceInfoList.size() == 0)
			throw new NoSuitableGraphicsDeviceException("The process of ranking devices removed all compatible devices.");
		
		return graphicsDeviceInfoList.get(0);
	}
	
	/**
	 * Raises the DeviceCreated event.
	 * 
	 * @param sender
	 * @param e
	 */
	protected void OnDeviceCreated(Object sender, EventArgs e)
	{
		if (DeviceCreated.hasHandlers())
			DeviceCreated.raise(sender, e);
	}
	
	/**
	 * Raises the PreparingDeviceSettings event.
	 * 
	 * @param sender
	 * @param args
	 */
	protected void OnPreparingDeviceSettings(Object sender, PreparingDeviceSettingsEventArgs args)
	{
		if (PreparingDeviceSettings.hasHandlers())
			PreparingDeviceSettings.raise(sender, args);
	}
	
	protected void RankDevices(List<GraphicsDeviceInformation> foundDevices)
	{
	}

	/**
	 * Toggles between full screen and windowed mode.
	 */
	public void ToggleFullScreen()
	{
		IsFullScreen = !IsFullScreen;

		getGraphicsDevice().getPresentationParameters().IsFullScreen = IsFullScreen;

		game.getWindow().BeginScreenDeviceChange(IsFullScreen);

		game.getWindow().EndScreenDeviceChange("", BackBufferWidth, BackBufferHeight);

		getGraphicsDevice().Reset();
	}
	
	private class OnDeviceDisposing implements EventHandler<EventArgs>
	{
		@Override
		public void Invoke(Object sender, EventArgs e)
		{
			if (DeviceDisposing.hasHandlers())
				DeviceDisposing.raise(sender, e);
		}
	}
	
	private class OnDeviceResetting implements EventHandler<EventArgs>
	{
		@Override
		public void Invoke(Object sender, EventArgs e)
		{
			if (DeviceResetting.hasHandlers())
				DeviceResetting.raise(sender, e);
		}
	}
	
	private class OnDeviceReset implements EventHandler<EventArgs>
	{
		@Override
		public void Invoke(Object sender, EventArgs e)
		{
			if (DeviceReset.hasHandlers())
				DeviceReset.raise(sender, e);
		}
	}
}
