package Microsoft.Xna.Framework;

import System.*;

/**
 * Represents a point in a multi-point curve.
 * 
 * @author Halofreak1990
 */
public class CurveKey implements Comparable<CurveKey>, IEquatable<CurveKey>
{
	private final float position;

	/**
	 * Describes whether the segment between this point and the next point in the curve is discrete or continuous.
	 */
	public CurveContinuity Continuity;

	/**
	 * Gets the position of the CurveKey in the curve.
	 * 
	 * @return
	 * The position of the CurveKey in the curve.
	 */
	public float getPosition()
	{
		return position;
	}

	/**
	 * Describes the tangent when approaching this point from the previous point in the curve.
	 */
	public float TangentIn;

	/**
	 * Describes the tangent when leaving this point to the next point in the curve.
	 */
	public float TangentOut;

	/**
	 * Describes the value of this point.
	 */
	public float Value;

	/**
	 * Initializes a new instance of the CurveKey class.
	 * 
	 * @param position
	 * The position in the curve.
	 * 
	 * @param value
	 * The value of the control point.
	 */
	public CurveKey(float position, float value)
	{
		this(position, value, 0, 0, CurveContinuity.Smooth);
	}

	/**
	 * Initializes a new instance of the CurveKey class.
	 * 
	 * @param position
	 * The position in the curve.
	 * 
	 * @param value
	 * The value of the control point.
	 * 
	 * @param tangentIn
	 * The tangent approaching point from the previous point in the curve.
	 * 
	 * @param tangentOut
	 * The tangent leaving point toward next point in the curve.
	 */
	public CurveKey(float position, float value, float tangentIn, float tangentOut)
	{
		this(position, value, tangentIn, tangentOut, CurveContinuity.Smooth);
	}

	/**
	 * Initializes a new instance of the CurveKey class.
	 * 
	 * @param position
	 * The position in the curve.
	 * 
	 * @param value
	 * The value of the control point.
	 * 
	 * @param tangentIn
	 * The tangent approaching point from the previous point in the curve.
	 * 
	 * @param tangentOut
	 * The tangent leaving point toward next point in the curve.
	 * 
	 * @param continuity
	 * Enum indicating whether the curve is discrete or continuous.
	 */
	public CurveKey(float position, float value, float tangentIn, float tangentOut, CurveContinuity continuity)
	{
		this.Continuity = continuity;
		this.position = position;
		this.TangentIn = tangentIn;
		this.TangentOut = tangentOut;
		this.Value = value;
	}

	/**
	 * Creates a copy of the CurveKey.
	 */
	public CurveKey Clone()
	{
		return new CurveKey(this.position, this.Value, this.TangentIn, this.TangentOut, this.Continuity);
	}

	/**
	 * Compares this instance to another CurveKey and returns an indication of their relative values.
	 * 
	 * @param other
	 * CurveKey to compare to.
	 */
	@Override
	public int compareTo(CurveKey other)
	{
		if (position > other.position)
		{
			return 1;
		}
		else if (position < other.position)
		{
			return -1;
		}

		return 0;
	}

	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * Object with which to make the comparison.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof CurveKey) ? this.Equals((CurveKey)obj) : false;
	}

	/**
	 * Determines whether the specified Object is equal to the CurveKey.
	 * 
	 * @param other
	 * The Object to compare with the current CurveKey.
	 */
	@Override
	public boolean Equals(CurveKey other)
	{
		return ((this.position == other.position) &&
				(this.Value == other.Value) &&
				(this.TangentIn == other.TangentIn) &&
				(this.TangentOut == other.TangentOut) &&
				(this.Continuity == other.Continuity));
	}

	/**
	 * Returns the hash code for this instance.
	 */
	public int hashCode()
	{
		return (int)this.position ^ (int)this.Value ^ (int)this.TangentIn ^
				(int)this.TangentOut ^ this.Continuity.hashCode();
	}
}
