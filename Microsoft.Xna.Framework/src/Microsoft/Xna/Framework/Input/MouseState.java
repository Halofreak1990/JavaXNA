package Microsoft.Xna.Framework.Input;

import System.*;

/**
 * Represents the state of a mouse input device, including mouse cursor position and buttons pressed.
 *
 * @author Halofreak1990
 */
public final class MouseState extends ValueType implements IEquatable<MouseState>
{
	/**
	 * Specifies the horizontal position of the mouse cursor.
	 * 
	 * @return
	 * Horizontal position of the mouse cursor in relation to the upper-left corner of the game window.
	 */
	public final int X;
	/**
	 * Specifies the vertical position of the mouse cursor.
	 * 
	 * @return
	 * Vertical position of the mouse cursor in relation to the upper-left corner of the game window.
	 */
	public final int Y;
	/**
	 * Gets the cumulative mouse scroll wheel value since the game was started.
	 * 
	 * @return
	 * The scroll wheel value.
	 */
	public final int ScrollWheelValue;
	/**
	 * Returns the state of the left mouse button.
	 */
	public final ButtonState LeftButton;
	/**
	 * Returns the state of the right mouse button.
	 */
	public final ButtonState RightButton;
	/**
	 * Returns the state of the middle mouse button.
	 */
	public final ButtonState MiddleButton;
	/**
	 * Returns the state of XBUTTON1.
	 */
	public final ButtonState XButton1;
	/**
	 * Returns the state of XBUTTON2.
	 */
	public final ButtonState XButton2;
	
	/**
	 * Initializes a new instance of the MouseState class.
	 * 
	 * @param x
	 * Horizontal mouse position.
	 * 
	 * @param y
	 * Vertical mouse position.
	 * 
	 * @param scrollWheel
	 * Mouse scroll wheel value.
	 * 
	 * @param leftButton
	 * Left mouse button state.
	 * 
	 * @param middleButton
	 * Middle mouse button state.
	 * 
	 * @param rightButton
	 * Right mouse button state.
	 * 
	 * @param xButton1
	 * XBUTTON1 state.
	 * 
	 * @param xButton2
	 * XBUTTON2 state.
	 */
	public MouseState(int x, int y, int scrollWheel, ButtonState leftButton, ButtonState middleButton, ButtonState rightButton, ButtonState xButton1, ButtonState xButton2)
	{
		this.X = x;
		this.Y = y;
		this.ScrollWheelValue = scrollWheel;
		this.LeftButton = leftButton;
		this.RightButton = rightButton;
		this.MiddleButton = middleButton;
		this.XButton1 = xButton1;
		this.XButton2 = xButton2;
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
		return (obj != null && obj instanceof MouseState) ? this.Equals((MouseState)obj) : false;
	}
	
	public boolean Equals(MouseState other)
	{
		return ((this.LeftButton == other.LeftButton) && (this.MiddleButton == other.MiddleButton) &&
				(this.RightButton == other.RightButton) && (this.ScrollWheelValue == other.ScrollWheelValue) &&
				(this.X == other.X) && (this.XButton1 == other.XButton1) &&
				(this.XButton2 == other.XButton2) && (this.Y == other.Y));
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
		return this.ScrollWheelValue + X ^ Y + this.LeftButton.ordinal() + this.RightButton.ordinal() + this.MiddleButton.ordinal() + this.XButton1.ordinal() + this.XButton2.ordinal();
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
		StringBuilder output = new StringBuilder(32);

		if (this.LeftButton == ButtonState.Pressed)
			output.append((output.length() == 0) ? "Left" : " Left");
		if (this.RightButton == ButtonState.Pressed)
			output.append((output.length() == 0) ? "Right" : " Right");
		if (this.MiddleButton == ButtonState.Pressed)
			output.append((output.length() == 0) ? "Middle" : " Middle");
		if (this.XButton1 == ButtonState.Pressed)
			output.append((output.length() == 0) ? "XButton1" : " XButton1");
		if (this.XButton2 == ButtonState.Pressed)
			output.append((output.length() == 0) ? "XButton2" : " XButton2");

		if (output.length() == 0)
			output.append("None");

		return String.format("{X:%d Y:%d Buttons:%s Wheel:%d}", this.X, this.Y, output.toString(), this.ScrollWheelValue);
	}
}
