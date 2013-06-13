package Microsoft.Xna.Framework.Input;

import java.util.*;
import org.lwjgl.input.*;

import Microsoft.Xna.Framework.*;

/**
 * Allows retrieval of user interaction with an Xbox 360 Controller and setting of controller vibration motors.
 * 
 * @author Halofreak1990
 */
public class GamePad
{
	/**
	 * Retrieves the capabilities of an Xbox 360 Controller.
	 * 
	 * @param playerIndex
	 * Index of the controller to query.
	 * 
	 * @return
	 * The capabilities of the controller.
	 */
	public static GamePadCapabilities GetCapabilities(PlayerIndex playerIndex)
	{
		return new GamePadCapabilities(Controllers.getController(playerIndex.ordinal()));
	}
	
	/**
	 * Gets the current state of an Xbox 360 Controller.
	 * 
	 * @param playerIndex
	 * Player index for the controller you want to query.
	 * 
	 * @return
	 * The current state of the controller.
	 */
	public static GamePadState GetState(PlayerIndex playerIndex)
	{
		return GetState(playerIndex, GamePadDeadZone.IndependantAxes);
	}
	
	/**
	 * Gets the current state of an Xbox 360 Controller, using a specified dead zone on analog stick positions.
	 * 
	 * @param playerIndex
	 * Player index for the controller you want to query.
	 * 
	 * @param deadZoneMode
	 * Enumerated value that specifies what dead zone type to use.
	 * 
	 * @return
	 * The current state of the controller.
	 */
	public static GamePadState GetState(PlayerIndex playerIndex, GamePadDeadZone deadZoneMode)
	{
		Controller ctrl = Controllers.getController(playerIndex.ordinal());
		
		List<Buttons> buttons = new ArrayList<Buttons>();
		
		if (ctrl.isButtonPressed(1)) buttons.add(Buttons.A);
		if (ctrl.isButtonPressed(2)) buttons.add(Buttons.B);
		if (ctrl.isButtonPressed(3)) buttons.add(Buttons.X);
		if (ctrl.isButtonPressed(4)) buttons.add(Buttons.Y);
		if (ctrl.isButtonPressed(5)) buttons.add(Buttons.RightShoulder);
		if (ctrl.isButtonPressed(6)) buttons.add(Buttons.LeftShoulder);
		if (ctrl.isButtonPressed(7)) buttons.add(Buttons.Start);
		if (ctrl.isButtonPressed(8)) buttons.add(Buttons.Back);
		if (ctrl.isButtonPressed(9)) buttons.add(Buttons.LeftStick);
		if (ctrl.isButtonPressed(10)) buttons.add(Buttons.RightStick);
		
		return new GamePadState(
				new Vector2(ctrl.getXAxisValue(), ctrl.getYAxisValue()), 
				new Vector2(ctrl.getRXAxisValue(), ctrl.getRYAxisValue()),
				ctrl.getZAxisValue(),
				-ctrl.getZAxisValue(),
				(Buttons[])buttons.toArray());
	}
	
	/**
	 * Sets the vibration motor speeds on an Xbox 360 Controller. Reference page contains links to related code samples.
	 * 
	 * @param playerIndex
	 * Player index that identifies the controller to set.
	 * 
	 * @param leftMotor
	 * The speed of the left motor, between 0.0 and 1.0. This motor is a low-frequency motor.
	 * 
	 * @param rightMotor
	 * The speed of the right motor, between 0.0 and 1.0. This motor is a high-frequency motor.
	 * 
	 * @return
	 * true if successful, false otherwise.
	 */
	public static boolean SetVibration(PlayerIndex playerIndex, float leftMotor, float rightMotor)
	{
		Controller ctrl = Controllers.getController(playerIndex.ordinal());
		
		//TODO: Implement
		
		return true;
	}
}
