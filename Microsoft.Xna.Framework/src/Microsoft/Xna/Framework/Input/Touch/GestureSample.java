package Microsoft.Xna.Framework.Input.Touch;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * A representation of data from a multitouch gesture over a span of time.
 *
 * @author Halofreak1990
 */
public class GestureSample
{
	/**
	 * Holds delta information about the first touchpoint in a multitouch gesture.
	 */
	public final Vector2 Delta;
	/**
	 * Holds delta information about the second touchpoint in a multitouch gesture.
	 */
	public final Vector2 Delta2;
	/**
	 * The type of gesture in a multitouch gesture sample.
	 */
	public final GestureType GestureType;
	/**
	 * Holds the current position of the first touchpoint in this gesture sample.
	 */
	public final Vector2 Position;
	/**
	 * Holds the current position of the the second touchpoint in this gesture sample.
	 */
	public final Vector2 Position2;
	/**
	 * Holds the starting time for this touch gesture sample.
	 */
	public final TimeSpan Timestamp;
	
	public GestureSample(GestureType gestureType, TimeSpan timestamp, Vector2 position, Vector2 position2, Vector2 delta, Vector2 delta2)
    {
        this.GestureType = gestureType;
        this.Timestamp = timestamp;
        this.Position = position;
        this.Position2 = position2;
        this.Delta = delta;
        this.Delta2 = delta2;
    }
}
