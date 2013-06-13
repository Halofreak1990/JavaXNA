package Microsoft.Xna.Framework.Input;

import java.util.*;

import System.*;

/**
 * Identifies which directions on the directional pad of an Xbox 360 Controller are being pressed.
 *
 * @author Halofreak1990
 */
public final class GamePadDPad extends ValueType implements IEquatable<GamePadDPad>
{
	/**
     * Identifies whether the Up direction on the Xbox 360 Controller directional pad is pressed.
     *  
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
	public final ButtonState Up;
	/**
     * Identifies whether the Right direction on the Xbox 360 Controller directional pad is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState Right;
    /**
     * Identifies whether the Down direction on the Xbox 360 Controller directional pad is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState Down;
    /**
     * Identifies whether the Left direction on the Xbox 360 Controller directional pad is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState Left;
    
    /**
     * Initializes a new instance of the GamePadDPad class.
     * 
     * @param upValue
     * Directional pad up button state.
     * 
     * @param downValue
     * Directional pad down button state.
     * 
     * @param leftValue
     * Directional pad left button state.
     * 
     * @param rightValue
     * Directional pad right button state.
     */
    public GamePadDPad(ButtonState upValue, ButtonState downValue, ButtonState leftValue, ButtonState rightValue)
    {
        this.Up = upValue;
        this.Right = rightValue;
        this.Down = downValue;
        this.Left = leftValue;
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
    	return (obj != null && obj instanceof GamePadDPad) ? this.Equals((GamePadDPad)obj) : false;
    }
    
    public boolean Equals(GamePadDPad other)
    {
    	return ((this.Down == other.Down) && (this.Left == other.Left) && (this.Right == other.Right) && (this.Up == other.Up));
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
    	return (Up.ordinal() << 3 * Down.ordinal() << 2 * Right.ordinal() << 1 * Left.ordinal() << 4);
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
    	String str = "";
        if (this.Up == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "Up";
        }
        if (this.Down == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "Down";
        }
        if (this.Left == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "Left";
        }
        if (this.Right == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "Right";
        }
        if (str.length() == 0)
        {
            str = "None";
        }
        return String.format(Locale.getDefault(), "{DPad:%s}", str); 
    }
}
