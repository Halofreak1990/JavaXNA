package Microsoft.Xna.Framework.Input;

import java.util.*;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Represents specific information about the state of an Xbox 360 Controller, including the current state of buttons and sticks.
 *
 * @author Halofreak1990
 */
public final class GamePadState extends ValueType
{
	/**
	 * Returns a structure that identifies what buttons on the Xbox 360 controller are pressed. Reference page contains links to related code samples.
	 */
	public final GamePadButtons Buttons;
	/**
	 * Indicates whether the Xbox 360 Controller is connected. Reference page contains links to related code samples.
	 */
	public final boolean IsConnected;
	/**
	 * Returns a structure that identifies what directions of the directional pad on the Xbox 360 Controller are pressed.
	 */
	public final GamePadDPad DPad;
	/**
	 * Returns a structure that indicates the position of the Xbox 360 Controller sticks (thumbsticks).
	 */
	public final GamePadThumbSticks ThumbSticks;
	/**
	 * Returns a structure that identifies the position of triggers on the Xbox 360 controller.
	 */
	public final GamePadTriggers Triggers;
	
	/**
	 * Initializes a new instance of the GamePadState class using the specified GamePadThumbSticks, GamePadTriggers, GamePadButtons, and GamePadDPad.
	 * 
	 * @param thumbSticks
	 * Initial stick state.
	 * 
	 * @param triggers
	 * Initial trigger state.
	 * 
	 * @param buttons
	 * Initial button state.
	 * 
	 * @param dPad
	 * Initial directional pad state.
	 */
	public GamePadState(GamePadThumbSticks thumbSticks, GamePadTriggers triggers, GamePadButtons buttons, GamePadDPad dPad)
	{
	    this.IsConnected = true;
	    this.ThumbSticks = thumbSticks;
	    this.Triggers = triggers;
	    this.Buttons = buttons;
	    this.DPad = dPad;
	}
	
	/**
	 * Initializes a new instance of the GamePadState class with the specified stick, trigger, and button values.
	 * 
	 * @param leftThumbStick
	 * Left stick value. Each axis is clamped between -1.0 and 1.0.
	 * 
	 * @param rightThumbStick
	 * Right stick value. Each axis is clamped between -1.0 and 1.0.
	 * 
	 * @param leftTrigger
	 * Left trigger value. This value is clamped between 0.0 and 1.0.
	 * 
	 * @param rightTrigger
	 * Right trigger value. This value is clamped between 0.0 and 1.0.
	 * 
	 * @param buttons
	 * Array or parameter list of Buttons to initialize as pressed.
	 */
	public GamePadState(Vector2 leftThumbStick, Vector2 rightThumbStick, float leftTrigger, float rightTrigger, Buttons...buttons)
	{
		EnumSet<Buttons> Buttons2 = EnumSet.noneOf(Buttons.class);
		
		this.IsConnected = true;
		this.ThumbSticks = new GamePadThumbSticks(leftThumbStick, rightThumbStick);
		this.Triggers = new GamePadTriggers(leftTrigger, rightTrigger);
		for (int i = 0; i < buttons.length; i++)
		{
			Buttons2.add(buttons[i]);
		}
		this.Buttons = new GamePadButtons(Buttons2);
		this.DPad = new GamePadDPad(
				(Buttons2.contains(Microsoft.Xna.Framework.Input.Buttons.DPadUp)) ? ButtonState.Pressed : ButtonState.Released,
				(Buttons2.contains(Microsoft.Xna.Framework.Input.Buttons.DPadDown)) ? ButtonState.Pressed : ButtonState.Released,
				(Buttons2.contains(Microsoft.Xna.Framework.Input.Buttons.DPadLeft)) ? ButtonState.Pressed : ButtonState.Released,
				(Buttons2.contains(Microsoft.Xna.Framework.Input.Buttons.DPadRight)) ? ButtonState.Pressed : ButtonState.Released);
	}
	
	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * Object with which to make the comparison.
	 * 
	 * @return
	 * true if the current instance is equal to the specified object; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof GamePadState) ? this == (GamePadState)obj : false;
	}
	
	/**
	 * Gets the hash code for this instance.
	 * 
	 * @return
	 * Hash code for this object.
	 */
	@Override
    public int hashCode()
    {
    	return (this.DPad.hashCode() + this.Triggers.hashCode() + this.ThumbSticks.hashCode() + this.Buttons.hashCode()); 
    }
    
	/**
	 * Retrieves a string representation of this object.
	 * 
	 * @return
	 * String representation of this object.
	 */
    @Override
    public String toString()
    {
    	return String.format(Locale.getDefault(), "{{IsConnected:%s}}", IsConnected);
    }
}
