package Microsoft.Xna.Framework;

import System.*;
import Microsoft.Xna.Framework.Graphics.*;

/**
 * A game component that is notified when it needs to draw itself.
 * 
 * @author Halofreak1990
 */
public class DrawableGameComponent extends GameComponent implements IDrawable
{
	int _drawOrder;
	boolean _visible;          
	IGraphicsDeviceService _graphicsService;
	
	/**
	 * Raised when the DrawOrder property changes.
	 */
	public final Event<EventArgs> DrawOrderChanged = new Event<EventArgs>();
	
	/**
	 * Raised when the Visible property changes.
	 */
	public final Event<EventArgs> VisibleChanged = new Event<EventArgs>();
	
	/**
	 * Order in which the component should be drawn, relative to other components that are in the same GameComponentCollection.
	 */
	public int getDrawOrder()
	{
		return _drawOrder;
	}
	
	public void setDrawOrder(int value)
	{
		if (_drawOrder != value)
		{
			_drawOrder = value;
			
			OnDrawOrderChanged(this, EventArgs.Empty);
		}
	}
	
	/**
	 * The GraphicsDevice the DrawableGameComponent is associated with.
	 */
	public GraphicsDevice getGraphicsDevice()
	{
		return _graphicsService.getGraphicsDevice();
	}
	
	/**
	 * Indicates whether Draw should be called.
	 */
	public boolean getVisible()
	{
		return _visible;
	}
	
	public void setVisible(boolean value)
	{
		if (_visible != value)
		{
			_visible = value;
			
			OnVisibleChanged(this, EventArgs.Empty);
		}
	}
	
	/**
	 * Creates a new instance of DrawableGameComponent.
	 * 
	 * @param game
	 * The Game that the game component should be attached to.
	 */
	public DrawableGameComponent(Game game)
	{
		super(game);
		_visible = true;
	}
	
	/**
	 * Releases the unmanaged resources used by the DrawableGameComponent and optionally releases the managed resources.
	 * 
	 * @param disposing
	 * true to release both managed and unmanaged resources; false to release only unmanaged resources.
	 */
	@Override
	protected void Dispose(boolean disposing)
	{
		if (disposing)
		{
			this.UnloadContent();
		}
		super.Dispose(disposing);
	}
	
	/**
	 * Initializes the component. Override this method to load any non-graphics resources and query for any required services.
	 */
	@Override
	public void Initialize()
	{
		_graphicsService = (IGraphicsDeviceService)getGame().getServices().GetService(IGraphicsDeviceService.class);

		if (_graphicsService == null)
			throw new InvalidOperationException("Drawable components require an IGraphicsDeviceService in the Services collection.");

		LoadContent();
	}
	
	/**
	 * Called when graphics resources need to be loaded. Override this method to load any component-specific graphics resources.
	 */
	protected void LoadContent()
	{	
	}
	
	/**
	 * Called when the DrawOrder property changes. Raises the DrawOrderChanged event.
	 * 
	 * @param sender
	 * The DrawableGameComponent.
	 * 
	 * @param e
	 * Arguments to the DrawOrderChanged event.
	 */
	protected void OnDrawOrderChanged(Object sender, EventArgs e)
	{
		if (DrawOrderChanged.hasHandlers())
			DrawOrderChanged.raise(sender, e);
	}
	
	/**
	 * Called when the Visible property changes. Raises the VisibleChanged event.
	 * 
	 * @param sender
	 * The DrawableGameComponent.
	 * 
	 * @param e
	 * Arguments to the DrawOrderChanged event.
	 */
	protected void OnVisibleChanged(Object sender, EventArgs e)
	{
		if (VisibleChanged.hasHandlers())
			VisibleChanged.raise(sender, e);
	}
	
	/**
	 * Called when graphics resources need to be unloaded. Override this method to unload any component-specific graphics resources.
	 */
	protected void UnloadContent()
	{
	}

	/**
	 * Called when the DrawableGameComponent needs to be drawn. Override this method with component-specific drawing code.
	 * 
	 * @param gameTime
	 * Time passed since the last call to Draw.
	 */
	@Override
	public void Draw(GameTime gameTime)
	{
	}
}
