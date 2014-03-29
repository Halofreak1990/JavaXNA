package Microsoft.Xna.Framework;

/**
 * Defines the continuity of CurveKeys on a Curve.
 * 
 * @author Halofreak1990
 */
public enum CurveContinuity
{
	/**
	 * Interpolation can be used between this CurveKey and the next.
	 */
	Smooth,
	/**
	 * Interpolation cannot be used between this CurveKey and the next. Specifying a position between the two points returns this point.
	 */
	Step
}
