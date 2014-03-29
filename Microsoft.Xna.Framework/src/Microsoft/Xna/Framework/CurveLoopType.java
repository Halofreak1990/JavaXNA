package Microsoft.Xna.Framework;

/**
 * Defines how the value of a Curve will be determined for positions before the first point on the Curve or after the last point on the Curve.
 * 
 * @author Halofreak1990
 */
public enum CurveLoopType
{
	/**
	 * The Curve will evaluate to its first key for positions before the first point in the Curve and to the last key for positions after the last point.
	 */
	Constant,
	/**
	 * Positions specified past the ends of the curve will wrap around to the opposite side of the Curve.
	 */
	Cycle,
	/**
	 * Positions specified past the ends of the curve will wrap around to the opposite side of the Curve. The value will be offset by the difference between the values of the first and last CurveKey multiplied by the number of times the position wraps around. If the position is before the first point in the Curve, the difference will be subtracted from its value; otherwise, the difference will be added.
	 */
	CycleOffset,
	/**
	 * Linear interpolation will be performed to determine the value.
	 */
	Linear,
	/**
	 * Positions specified past the ends of the Curve act as an offset from the same side of the Curve toward the opposite side.
	 */
	Oscillate
}
