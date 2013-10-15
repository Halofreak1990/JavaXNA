package System.Collections.ObjectModel;

import java.util.*;

import System.*;

/**
 * Provides the base class for a generic read-only collection.
 * 
 * @author Halofreak1990
 *
 * @param <T>
 * The type of elements in the collection.
 */
public class ReadOnlyCollection<T> implements Iterable<T>
{
	private List<T> collection;
	
	/**
	 * Initializes a new instance of the System.Collections.ObjectModel.ReadOnlyCollection<T> class that is a read-only wrapper around the specified list.
	 * 
	 * @param list
	 * The list to wrap.
	 * 
	 * @exception System.ArgumentNullException
	 * list is null.
	 */
	public ReadOnlyCollection(List<T> list)
	{
		if (list == null)
		{
			throw new ArgumentNullException("list");
		}
		
		collection = list;
	}
	
	/**
	 * Gets the number of elements contained in the System.Collections.ObjectModel.ReadOnlyCollection<T> instance.
	 */
	public int Count()
	{
		return collection.size();
	}
	
	/**
	 * Returns the System.Collections.Generic.IList<T> that the System.Collections.ObjectModel.ReadOnlyCollection<T> wraps.
	 * 
	 * @return
	 * The System.Collections.Generic.IList<T> that the System.Collections.ObjectModel.ReadOnlyCollection<T> wraps.
	 */
	protected List<T> getItems()
	{
		return collection;
	}
	
	/**
	 * Gets the element at the specified index.
	 * 
	 * @param index
	 * The zero-based index of the element to get.
	 * 
	 * @return
	 * The element at the specified index.
	 * 
	 * @exception System.ArgumentOutOfRangeException
	 * index is less than zero.-or-index is equal to or greater than System.Collections.ObjectModel.ReadOnlyCollection<T>.count.
	 */
	public T get(int index)
	{
		if (index < 0 || index > collection.size())
		{
			throw new ArgumentOutOfRangeException("index");
		}
		
		return collection.get(index);
	}
	
	/**
	 * Determines whether an element is in the System.Collections.ObjectModel.ReadOnlyCollection<T>.
	 * 
	 * @param value
	 * The object to locate in the System.Collections.ObjectModel.ReadOnlyCollection<T>. The value can be null for reference types.
	 * 
	 * @return
	 * true if value is found in the System.Collections.ObjectModel.ReadOnlyCollection<T>; otherwise, false.
	 */
	public boolean Contains(T value)
	{
		return (IndexOf(value) != -1);
	}
	
	/**
	 * Copies the entire System.Collections.ObjectModel.ReadOnlyCollection<T> to a compatible one-dimensional System.Array, starting at the specified index of the target array.
	 * 
	 * @param array
	 * The one-dimensional array that is the destination of the elements copied from System.Collections.ObjectModel.ReadOnlyCollection<T>. The System.Array must have zero-based indexing.
	 * 
	 * @param index
	 * The zero-based index in array at which copying begins.
	 */
	public void CopyTo(T[] array, int index)
	{
		if (array == null)
		{
			throw new ArgumentNullException();
		}
		
		// TODO: verify
		if ((index + collection.size()) > array.length)
		{
			throw new ArgumentException("");
		}
		
		System.arraycopy(collection, 0, array, index, collection.size());
	}

	/**
	 * Returns an iterator that iterates through the System.Collections.ObjectModel.ReadOnlyCollection<T>.
	 */
	@Override
	public Iterator<T> iterator()
	{
		return collection.iterator();
	}
	
	/**
	 * Searches for the specified object and returns the zero-based index of the first occurrence within the entire System.Collections.ObjectModel.ReadOnlyCollection<T>.
	 * 
	 * @param value
	 * The object to locate in the System.Collections.Generic.List<T>. The value can be null for reference types.
	 * 
	 * @return
	 * The zero-based index of the first occurrence of item within the entire System.Collections.ObjectModel.ReadOnlyCollection<T>, if found; otherwise, -1.
	 */
	public int IndexOf(T value)
	{
		return collection.indexOf(value);
	}
}
