package Microsoft.Xna.Framework.Input;

import java.util.*;

import System.*;

/**
 * Identifies whether the buttons on an Xbox 360 Controller are pressed or released.
 *
 * @author Halofreak1990
 */
public final class GamePadButtons extends ValueType implements IEquatable<GamePadButtons>
{
	/**
     * Identifies whether the A button on the Xbox 360 Controller is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
	public final ButtonState A;
	/**
     * Identifies whether the B button on the Xbox 360 Controller is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState B;
    /**
     * Identifies whether the X button on the Xbox 360 Controller is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState X;
    /**
     * Identifies whether the Y button on the Xbox 360 Controller is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState Y;
    /**
     * Identifies whether the left stick button on the Xbox 360 Controller is pressed (the stick is "clicked" in).
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState LeftStick;
    /**
     * Identifies whether the right stick button on the Xbox 360 Controller is pressed (the stick is "clicked" in).
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState RightStick;
    /**
     * Identifies whether the left shoulder (bumper) button on the Xbox 360 Controller is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState LeftShoulder;
    /**
     * Identifies whether the right shoulder (bumper) button on the Xbox 360 Controller is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState RightShoulder;
    /**
     * Identifies whether the BACK button on the Xbox 360 Controller is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState Back;
    /**
     * Identifies whether the START button on the Xbox 360 Controller is pressed.
     * 
     * @return
     * ButtonState.Pressed if the button is pressed; ButtonState.Released otherwise.
     */
    public final ButtonState Start;
    
    /**
     * Initializes a new instance of the GamePadButtons class, setting the specified buttons to pressed.
     * 
     * @param buttons
     * Buttons to initialize as pressed. Specify a single button, or combine multiple buttons using an EnumSet.
     */
    public GamePadButtons(EnumSet<Buttons> buttons)
    {
    	this.A = (buttons.contains(Buttons.A)) ? ButtonState.Pressed : ButtonState.Released;
    	this.B = (buttons.contains(Buttons.B)) ? ButtonState.Pressed : ButtonState.Released;
    	this.X = (buttons.contains(Buttons.X)) ? ButtonState.Pressed : ButtonState.Released;
    	this.Y = (buttons.contains(Buttons.Y)) ? ButtonState.Pressed : ButtonState.Released;
    	this.Start = (buttons.contains(Buttons.Start)) ? ButtonState.Pressed : ButtonState.Released;
    	this.Back = (buttons.contains(Buttons.Back)) ? ButtonState.Pressed : ButtonState.Released;
    	this.LeftStick = (buttons.contains(Buttons.LeftStick)) ? ButtonState.Pressed : ButtonState.Released;
    	this.RightStick = (buttons.contains(Buttons.RightStick)) ? ButtonState.Pressed : ButtonState.Released;
    	this.LeftShoulder = (buttons.contains(Buttons.LeftShoulder)) ? ButtonState.Pressed : ButtonState.Released;
    	this.RightShoulder = (buttons.contains(Buttons.RightShoulder)) ? ButtonState.Pressed : ButtonState.Released;
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
    	return (obj != null && obj instanceof GamePadButtons) ? this.Equals((GamePadButtons)obj) : false;
    }
    
    public boolean Equals(GamePadButtons other)
    {
    	return ((A == other.A) && (B == other.B) && (Back == other.Back) && (LeftShoulder == other.LeftShoulder) &&
    			(LeftStick == other.LeftStick) && (RightShoulder == other.RightShoulder) && (RightStick == other.RightStick) &&
    			(Start == other.Start) && (X == other.X) && (Y == other.Y));
    }
    
    /**
     * Gets the hash code for this instance.
     * 
     * #return
     * Hash code for this object.
     */
    @Override
    public int hashCode()
    {
    	return (A.ordinal() + B.ordinal() + X.ordinal() + Y.ordinal() + Start.ordinal() + LeftStick.ordinal() ^ RightStick.ordinal() + LeftShoulder.ordinal() + RightShoulder.ordinal() + Back.ordinal()); 
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
        if (this.A == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "A";
        }
        if (this.B == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "B";
        }
        if (this.X == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "X";
        }
        if (this.Y == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "Y";
        }
        if (this.LeftShoulder == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "LeftShoulder";
        }
        if (this.RightShoulder == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "RightShoulder";
        }
        if (this.LeftStick == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "LeftStick";
        }
        if (this.RightStick == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "RightStick";
        }
        if (this.Start == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "Start";
        }
        if (this.Back == ButtonState.Pressed)
        {
            str = str + ((str.length() != 0) ? " " : "") + "Back";
        }
        if (str.length() == 0)
        {
            str = "None";
        }
        return String.format(Locale.getDefault(), "{Buttons:%s}", str);
    }
}
