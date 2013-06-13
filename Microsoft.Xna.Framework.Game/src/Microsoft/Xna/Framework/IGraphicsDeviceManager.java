package Microsoft.Xna.Framework;

/**
 * Defines the interface for an object that manages a GraphicsDevice.
 * 
 * @author Halofreak1990
 */
public interface IGraphicsDeviceManager
{
	boolean BeginDraw();
	void CreateDevice();
	void EndDraw();
}
