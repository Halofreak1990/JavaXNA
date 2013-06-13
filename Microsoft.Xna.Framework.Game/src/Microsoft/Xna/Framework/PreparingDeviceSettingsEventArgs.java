package Microsoft.Xna.Framework;

import System.*;

/**
 * Arguments for the GraphicsDeviceManager.PreparingDeviceSettings event.
 * 
 * @author Halofreak1990
 */
public class PreparingDeviceSettingsEventArgs extends EventArgs
{
	private GraphicsDeviceInformation graphicsDeviceInformation;
	
	/**
	 * Gets information about the GraphicsDevice.
	 */
	public GraphicsDeviceInformation getGraphicsDeviceInformation()
	{
		return graphicsDeviceInformation;
	}
	
	/**
	 * Creates a new instance of PreparingDeviceSettingsEventArgs.
	 * 
	 * @param graphicsDeviceInformation
	 * Information about the GraphicsDevice.
	 */
	public PreparingDeviceSettingsEventArgs(GraphicsDeviceInformation graphicsDeviceInformation)
	{
		this.graphicsDeviceInformation = graphicsDeviceInformation;
	}
}
