package System;

/**
 * Defines a generalized method that a value type or class implements to create a type-specific method for determining equality of instances.
 *
 * @author Halofreak1990
 * @param <T>
 */
public interface IEquatable<T>
{
	/**
	 * Indicates whether the current object is equal to another object of the same type.
	 * 
	 * @param other
	 * An object to compare with this object.
	 * 
	 * @return
	 * true if the current object is equal to the other parameter; otherwise, false.
	 */
	public boolean Equals(T other);
}
