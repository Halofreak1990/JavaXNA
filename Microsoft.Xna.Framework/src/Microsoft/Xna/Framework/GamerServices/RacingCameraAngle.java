package Microsoft.Xna.Framework.GamerServices;

/**
 * Indicates which camera angle this gamer prefers to use in racing games.
 *
 * @author Halofreak1990
 */
public enum RacingCameraAngle
{
	/**
	 * Traditional third-person camera view from behind the car.
	 */
    Back,
    /**
     * Camera view from in front of the car. The car itself is not visible.
     */
    Front,
    /**
     * Camera view from inside the car, looking through the windscreen.
     */
    Inside
}

