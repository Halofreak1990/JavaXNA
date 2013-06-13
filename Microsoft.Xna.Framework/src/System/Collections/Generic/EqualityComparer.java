package System.Collections.Generic;

/**
 * 
 * @author Halofreak1990
 *
 * @param <T>
 */
public abstract class EqualityComparer<T> implements IEqualityComparer<T>
{
	protected EqualityComparer()
	{
	}
	
	public abstract boolean equals(T x, T y);
	
	public abstract int hashCode(T obj);
}
