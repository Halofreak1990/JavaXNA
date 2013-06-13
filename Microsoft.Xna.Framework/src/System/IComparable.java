package System;

/**
 * Defines a generalized comparison method that a value type or class implements to create a type-specific comparison method for ordering instances.
 *
 * @author Halofreak1990
 * @param <T>
 */
public interface IComparable<T>
{
	/**
	 * Compares the current object with an object of the same type.
	 * 
	 * @param other
	 * An object to compare with this object.
	 * 
	 * @return
	 * A 32-bit signed integer that indicates the relative order of the objects being compared. The return value has the following meanings: Value Meaning Less than zero This object is less than the other parameter. Zero This object is equal to other. Greater than zero This object is greater than other.
	 */
	public int CompareTo(T other);
}
