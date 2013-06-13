package Microsoft.Xna.Framework;

import System.*;
import Microsoft.Xna.Framework.Graphics.*;

/**
 * Defines a mechanism for retrieving GraphicsDevice objects.
 * 
 * @author Halofreak1990
 */
public interface IGraphicsDeviceService
{
	/**
	 * Retrieves a GraphicsDevice.
	 */
	GraphicsDevice getGraphicsDevice();
	
	/**
	 * The event that occurs when a graphics device is created.
	 */
	Event<EventArgs> DeviceCreated = new Event<EventArgs>();
	
	/**
	 * The event that occurs when a graphics device is disposing.
	 */
	Event<EventArgs> DeviceDisposing = new Event<EventArgs>();
	
	/**
	 * The event that occurs when a graphics device is reset.
	 */
	Event<EventArgs> DeviceReset = new Event<EventArgs>();
	
	/**
	 * The event that occurs when a graphics device is in the process of resetting.
	 */
	Event<EventArgs> DeviceResetting = new Event<EventArgs>();
}
