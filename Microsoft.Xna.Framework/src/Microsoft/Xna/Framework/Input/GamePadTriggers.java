package Microsoft.Xna.Framework.Input;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Structure that defines the position of the left and right triggers on an Xbox 360 Controller.
 *
 * @author Halofreak1990
 */
public final class GamePadTriggers extends ValueType
{
	/**
     * Identifies the position of the left trigger on the Xbox 360 Controller.
     * 
     * @return
     * Position of the left trigger, as a value between 0.0 and 1.0.
     */
	public final float Left;
	/**
     * Identifies the position of the right trigger on the Xbox 360 Controller.
     * 
     * @return
     * Position of the right trigger, as a value between 0.0 and 1.0.
     */
    public final float Right;
    
    /**
     * Initializes a new instance of the GamePadTriggers class.
     * 
     * @param leftTrigger
     * Left trigger value. This value is clamped between 0.0 and 1.0.
     * 
     * @param rightTrigger
     * Right trigger value. This value is clamped between 0.0 and 1.0.
     */
    public GamePadTriggers(float leftTrigger, float rightTrigger)
    {
        this.Left = MathHelper.Clamp(leftTrigger, 0, 1);
        this.Right = MathHelper.Clamp(rightTrigger, 0, 1);
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
    	if ((obj != null) && (obj instanceof GamePadTriggers))
    	{
    		GamePadTriggers other = (GamePadTriggers)obj;
    		return ((this.Left == other.Left) && (this.Right == other.Right));
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
    	return ((int)Left * (int)Right);
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
    	return String.format(Locale.getDefault(), "{{Left:%f Right %f}}", this.Left, this.Right);
    }
}
