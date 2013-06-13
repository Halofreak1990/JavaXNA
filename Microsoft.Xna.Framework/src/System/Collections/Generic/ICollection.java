package System.Collections.Generic;

/**
 * Defines methods to manipulate generic collections.
 * 
 * @author Halofreak1990
 */
public interface ICollection<T> extends Iterable<T>
{
	void Add(T item);
	void Clear();
	boolean Contains(T item);
	void CopyTo(T[] array, int arrayIndex);
	boolean Remove(T item);
	
	int Count();
	boolean IsReadOnly();
}
