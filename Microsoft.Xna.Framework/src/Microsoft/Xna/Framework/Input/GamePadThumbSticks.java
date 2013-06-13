package Microsoft.Xna.Framework.Input;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Structure that represents the position of left and right sticks (thumbsticks) on an Xbox 360 Controller.
 *
 * @author Halofreak1990
 */
public final class GamePadThumbSticks extends ValueType
{
	/**
	 * Returns the position of the left Xbox 360 Controller stick (thumbstick) as a 2D vector.
	 * 
	 * @return
	 * Two-dimensional vector that identifies the position of the left stick. Each axis is represented as a floating-point value from −1.0 to 1.0.
	 */
	public final Vector2 Left;
	
	/**
	 * Returns the position of the right Xbox 360 Controller stick (thumbstick) as a 2D vector.
	 * 
	 * @return
	 * Two-dimensional vector that identifies the position of the right stick. Each axis is represented as a floating-point value from −1.0 to 1.0.
	 */
	public final Vector2 Right;
	
	/**
	 * Initializes a new instance of the GamePadThumbSticks class.
	 * 
	 * @param leftThumbstick
	 * Left stick value. Each axis is clamped between -1.0 and 1.0.
	 * 
	 * @param rightThumbstick
	 * Right stick value. Each axis is clamped between -1.0 and 1.0.
	 */
	public GamePadThumbSticks(Vector2 leftThumbstick, Vector2 rightThumbstick)
	{
	        this.Left = Vector2.Clamp(leftThumbstick, Vector2.Negate(Vector2.One), Vector2.One);
	        this.Right = Vector2.Clamp(rightThumbstick, Vector2.Negate(Vector2.One), Vector2.One);
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
		if ((obj != null) && (obj instanceof GamePadThumbSticks))
		{
			GamePadThumbSticks other = (GamePadThumbSticks)obj;
			return ((this.Left.Equals(other.Left)) && (this.Right.Equals(other.Right)));
		}
		return false;
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
		return this.Left.hashCode() * this.Right.hashCode();
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
		return String.format(Locale.getDefault(), "{Left:%s Right:%s}", this.Left, this.Right);
	}
}
