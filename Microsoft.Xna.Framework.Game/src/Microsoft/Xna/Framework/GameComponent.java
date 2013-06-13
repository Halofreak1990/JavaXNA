package Microsoft.Xna.Framework;

import System.*;

/**
 * Base class for all XNA Framework game components.
 * 
 * @author Halofreak1990
 */
public class GameComponent implements IGameComponent, IUpdateable, IDisposable
{
	final Game _game;
	boolean _disposed;
	boolean _enabled;
	int _updateOrder;
	
	/**
	 * Raised when the GameComponent is disposed.
	 */
	public final Event<EventArgs> Disposed = new Event<EventArgs>();
	
	/**
	 * Raised when the Enabled property changes.
	 */
	public final Event<EventArgs> EnabledChanged = new Event<EventArgs>();
	
	/**
	 * Raised when the UpdateOrder property changes.
	 */
	public final Event<EventArgs> UpdateOrderChanged = new Event<EventArgs>();
	
	/**
	 * Initializes a new instance of this class.
	 * 
	 * @param game
	 * Game that the game component should be attached to.
	 */
	public GameComponent(Game game)
	{
		_game = game;
		_enabled = true;
	}

	/**
	 * Indicates whether GameComponent.Update should be called when Game.Update is called.
	 */
	@Override
	public boolean getEnabled()
	{
		return _enabled;
	}
	
	public void setEnabled(boolean value)
	{
		if (_enabled != value)
		{
			_enabled = value;
			
			OnEnabledChanged(this, EventArgs.Empty);
		}
	}
	
	/**
	 * Gets the Game associated with this GameComponent.
	 */
	public Game getGame()
	{
		return _game;
	}

	/**
	 * Indicates the order in which the GameComponent should be updated relative to other GameComponent instances. Lower values are updated first.
	 */
	@Override
	public int getUpdateOrder()
	{
		return _updateOrder;
	}
	
	public void setUpdateOrder(int value)
	{
		if (_updateOrder != value)
		{
			_updateOrder = value;
			
			OnUpdateOrderChanged(this, EventArgs.Empty);
		}
	}

	/**
	 * Immediately releases the unmanaged resources used by this object.
	 */
	@Override
	public void Dispose()
	{
		Dispose(true);
	}
	
	/**
	 * Releases the unmanaged resources used by the GameComponent and optionally releases the managed resources.
	 * 
	 * @param disposing
	 * true to release both managed and unmanaged resources; false to release only unmanaged resources.
	 */
	protected void Dispose(boolean disposing)
	{
		if (!_disposed)
		{
			_disposed = true;
			
			if (Disposed.hasHandlers())
				Disposed.raise(this, EventArgs.Empty);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public void Initialize()
	{
	}
	
	/**
	 * Called when the Enabled property changes. Raises the EnabledChanged event.
	 * 
	 * @param sender
	 * The GameComponent.
	 * 
	 * @param e
	 * Arguments to the EnabledChanged event.
	 */
	protected void OnEnabledChanged(Object sender, EventArgs e)
	{
		if (EnabledChanged.hasHandlers())
			EnabledChanged.raise(sender, e);
	}
	
	/**
	 * Called when the UpdateOrder property changes. Raises the UpdateOrderChanged event.
	 * 
	 * @param sender
	 * The GameComponent.
	 * 
	 * @param e
	 * Arguments to the UpdateOrderChanged event.
	 */
	protected void OnUpdateOrderChanged(Object sender, EventArgs e)
	{
		if (UpdateOrderChanged.hasHandlers())
			UpdateOrderChanged.raise(sender, e);
	}

	/**
	 * Called when the GameComponent needs to be updated. Override this method with component-specific update code.
	 * 
	 * @param gameTime
	 * Time elapsed since the last call to Update
	 */
	@Override
	public void Update(GameTime gameTime)
	{
	}
}
