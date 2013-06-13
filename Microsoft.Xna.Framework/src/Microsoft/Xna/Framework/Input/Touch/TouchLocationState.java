package Microsoft.Xna.Framework.Input.Touch;

/**
 * Defines the possible states of a touch location. Reference page contains links to related code samples.
 *
 * @author Halofreak1990
 */
public enum TouchLocationState
{
	/**
	 * This touch location position is invalid. Typically, you will encounter this state when a new touch location attempts to get the previous state of itself.
	 */
	Invalid,
	/**
	 * This touch location position was released.
	 */
    Released,
    /**
     * This touch location position is new.
     */
    Pressed,
    /**
     * This touch location position was updated or pressed at the same position.
     */
    Moved
}
