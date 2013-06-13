package Microsoft.Xna.Framework.Input;

/**
 * Specifies a type of dead zone processing to apply to Xbox 360 controller analog sticks when calling GamePad.GetState.
 *
 * @author Halofreak1990
 */
public enum GamePadDeadZone
{
	/**
	 * The values of each stick are not processed and are returned by GamePad.GetState as "raw" values. This is best if you intend to implement your own dead zone processing.
	 */
	None,
	/**
	 * The X and Y positions of each stick are compared against the dead zone independently. This setting is the default when calling GamePad.GetState.
	 */
	IndependantAxes,
	/**
	 * The combined X and Y position of each stick is compared against the dead zone. This provides better control than IndependentAxes when the stick is used as a two-dimensional control surface, such as when controlling a character's view in a first-person game.
	 */
	Circular
}
