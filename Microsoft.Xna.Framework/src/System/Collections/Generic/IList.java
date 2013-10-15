package System.Collections.Generic;

/**
 * Represents a collection of objects that can be individually accessed by index.
 * 
 * @author Halofreak1990
 */
public interface IList<T> extends ICollection<T>, Iterable<T>
{
	int IndexOf(T item);
	void Insert(int index, T item);
	void RemoveAt(int index);

	T get(int index);
	void set(int index, T item);
}
