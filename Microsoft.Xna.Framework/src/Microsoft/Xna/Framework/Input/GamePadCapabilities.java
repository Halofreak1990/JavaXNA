package Microsoft.Xna.Framework.Input;

import org.lwjgl.input.*;

import System.*;

/**
 * Describes the capabilities of an Xbox 360 Controller, including controller type and whether the controller supports voice.
 *
 * @author Halofreak1990
 */
public final class GamePadCapabilities extends ValueType
{
	/**
	 * Indicates whether the Xbox 360 Controller is connected.
	 */
	public final boolean IsConnected;
	
	GamePadCapabilities(Controller controller)
	{
		// TODO: implement
		this.IsConnected = true;
	}
}
