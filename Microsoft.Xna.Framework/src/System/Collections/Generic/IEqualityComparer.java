package System.Collections.Generic;

/**
 * Defines methods to support the comparison of objects for equality.
 *
 * @author Halofreak1990
 */
public interface IEqualityComparer<T>
{
	/**
	 * Determines whether the specified objects are equal.
	 * 
	 * @param x
	 * The first object of type T to compare.
	 * 
	 * @param y
	 * The second object of type T to compare.
	 * 
	 * @return
	 * <code>true</code> if the specified objects are equal; otherwise, <code>false</code>.
	 */
	public boolean equals(T x, T y);
	
	/**
	 * Returns a hash code for the specified object.
	 * 
	 * @param obj
	 * The Object for which a hash code is to be returned.
	 * 
	 * @return
	 * A hash code for the specified object.
	 */
	public int hashCode(T obj);
}
