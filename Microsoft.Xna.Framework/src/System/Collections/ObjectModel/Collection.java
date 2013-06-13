package System.Collections.ObjectModel;

import java.util.*;

import System.*;

/**
 * Provides the base class for a generic collection.
 *
 * @author Halofreak1990
 */
public class Collection<T> implements Iterable<T>
{
	private List<T> items;
	
	/**
	 * Gets the number of elements actually contained in the System.Collections.ObjectModel.Collection<T>.
	 * 
	 * @return
	 * The number of elements actually contained in the System.Collections.ObjectModel.Collection<T>.
	 */
	public int Count()
	{
		return items.size();
	}
	
	/**
	 * Gets a java.util.List<T> wrapper around the System.Collections.ObjectModel.Collection<T>.
	 * 
	 * @return
	 * A java.util.List<T> wrapper around the System.Collections.ObjectModel.Collection<T>.
	 */
	protected List<T> getItems()
	{
		return items;
	}
	
	/**
	 * Gets the element at the specified index.
	 * 
	 * @param index
	 * The zero-based index of the element to get.
	 * 
	 * @return
	 * The element at the specified index.
	 */
	public T get(int index)
	{
		return this.items.get(index);
	}
	
	/**
	 * Sets the element at the specified index.
	 * 
	 * @param index
	 * The zero-based index of the element to set.
	 * 
	 * @param item
	 * The new value for the element at the specified index. The value can be null for reference types.
	 */
	public void set(int index, T item)
	{
		this.items.set(index, item);
	}
	
	/**
	 * Initializes a new instance of the Collection<> class that is empty.
	 */
	public Collection()
	{
		items = new ArrayList<T>();
	}
	
	/**
	 * Initializes a new instance of the Collection<> class as a wrapper for the specified list.
	 * 
	 * @param list
	 * The list that is wrapped by the new collection.
	 */
	public Collection(List<T> list)
	{
		if (list == null)
		{
			throw new ArgumentNullException("list");
		}
		this.items = list;
	}
	
	/**
	 * Adds an object to the end of the Collection<>.
	 * 
	 * @param item
	 * The object to be added to the end of the Collection<>. The value can be null for reference types.
	 */
	public void Add(T item)
    {
        int count = this.items.size();
        items.add(count, item);
    }
	
	@Override
	public Iterator<T> iterator()
	{
		return this.items.iterator();
	}
	
	/**
	 * Removes all elements from the Collection<>.
	 */
	public void Clear()
	{
		this.ClearItems();
	}

	/**
	 * Removes all elements from the Collection<>.
	 */
	protected void ClearItems()
	{
		this.items.clear();
	}
	
	/**
	 * Searches for the specified object and returns the zero-based index of the first occurrence within the entire Collection<>.
	 * 
	 * @param item
	 * The object to locate in the List<>. The value can be null for reference types.
	 * 
	 * @return
	 * The zero-based index of the first occurrence of item within the entire Collection<>, if found; otherwise, -1.
	 */
	public int IndexOf(T item)
	{
		return this.items.indexOf(item);
	}
	
	/**
	 * Inserts an element into the Collection<> at the specified index.
	 * 
	 * @param index
	 * The object to insert. The value can be null for reference types.
	 * 
	 * @param item
	 * The zero-based index at which item should be inserted.
	 */
	public void Insert(int index, T item)
	{
		if ((index < 0) || (index > this.items.size()))
	    {
	        throw new ArgumentOutOfRangeException("index", "");
	    }
	    this.InsertItem(index, item);
	}

	/**
	 * Inserts an element into the Collection<> at the specified index.
	 * 
	 * @param index
	 * The object to insert. The value can be null for reference types.
	 * 
	 * @param item
	 * The zero-based index at which item should be inserted.
	 */
	protected void InsertItem(int index, T item)
	{
		this.items.add(index, item);
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	public boolean Remove(T item)
	{
		int index = this.getItems().indexOf(item);
		if (index < 0)
		{
			return false;
		}
		this.RemoveItem(index);
		return true;
	}

	/**
	 * Removes the element at the specified index of the Collection<>.
	 * 
	 * @param index
	 * The zero-based index of the element to remove.
	 */
	protected void RemoveItem(int index)
	{
		this.items.remove(index);
	}

	/**
	 * Replaces the element at the specified index.
	 * 
	 * @param index
	 * The zero-based index of the element to replace.
	 * 
	 * @param item
	 * The new value for the element at the specified index. The value can be null for reference types.
	 */
	protected void SetItem(int index, T item)
	{
		if (index < 0)
			throw new ArgumentOutOfRangeException("index");
		
		this.items.set(index, item);
	}
}
