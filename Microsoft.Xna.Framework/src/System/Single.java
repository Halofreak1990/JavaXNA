package System;

/**
 * Represents a single-precision floating-point number.
 * 
 * @author Halofreak1990
 */
public final class Single extends Number implements Comparable<Single>, IEquatable<Single>
{
	private static final long serialVersionUID = -6474377828799507953L;

	private float value;

	/**
	 * Represents the smallest positive System.Single value that is greater than zero. This field is constant.
	 */
	public static final float Epsilon = 1.401298E-45f;

	/**
	 * Initializes a new instance of the System.Single class with the specified value.
	 * 
	 * @param value
	 * 
	 */
	public Single(float value)
	{
		this.value = value;
	}

	/**
	 * Compares this instance to a specified single-precision floating-point number and returns an integer that indicates whether the value of this instance is less than, equal to, or greater than the value of the specified single-precision floating-point number.
	 * 
	 * @param other
	 * A single-precision floating-point number to compare.
	 * 
	 * @return
	 * A signed number indicating the relative values of this instance and value.Return Value Description Less than zero This instance is less than value.-or- This instance is not a number (System.Single.NaN) and value is a number. Zero This instance is equal to value.-or- Both this instance and value are not a number (System.Single.NaN), System.Single.PositiveInfinity, or System.Single.NegativeInfinity. Greater than zero This instance is greater than value.-or- This instance is a number and value is not a number (System.Single.NaN).
	 */
	public int compareTo(Single other)
	{
		// TODO: implement NaN
		
		if (value < other.value)
		{
			return -1;
		}
		else if (value > other.value)
		{
			return 1;
		}

		return 0;
	}

	/**
	 * Returns a value indicating whether this instance is equal to a specified object.
	 * 
	 * @param obj
	 * An object to compare with this instance.
	 * 
	 * @return
	 * true if obj is an instance of System.Single and equals the value of this instance; otherwise, false.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Single) ? this.Equals((Single)obj) : false;
	}

	/**
	 * Returns a value indicating whether this instance and a specified System.Single object represent the same value.
	 * 
	 * @param other
	 * A System.Single object to compare to this instance.
	 * 
	 * @return
	 * true if obj is equal to this instance; otherwise, false.
	 */
	@Override
	public boolean Equals(Single other)
	{
		return value == other.value;
	}

	/**
	 * Returns the hash code for this instance.
	 * 
	 * @return
	 * A 32-bit signed integer hash code.
	 */
	@Override
	public int hashCode()
	{
		return (int)value;
	}

	@Override
	public double doubleValue()
	{
		return (double)value;
	}

	@Override
	public float floatValue()
	{
		return value;
	}

	@Override
	public int intValue()
	{
		return (int)value;
	}

	@Override
	public long longValue()
	{
		return (long)value;
	}

	/**
	 * Converts the numeric value of this instance to its equivalent string representation.
	 * 
	 * @return
	 * The string representation of the value of this instance.
	 */
	@Override
	public String toString()
	{
		return Float.toString(value);
	}
}
