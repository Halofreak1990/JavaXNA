package Microsoft.Xna.Framework.Graphics;

/**
 * Defines a mechanism for retrieving GraphicsDevice objects.
 * 
 * @author Halofreak1990
 */
public interface IGraphicsDeviceService
{
	//event EventHandler<EventArgs> DeviceCreated;
    //event EventHandler<EventArgs> DeviceDisposing;
    //event EventHandler<EventArgs> DeviceReset;
    //event EventHandler<EventArgs> DeviceResetting;
	
	public GraphicsDevice GraphicsDevice();
}
