package System.Collections.ObjectModel;

import java.util.*;

import System.*;
import System.Collections.Generic.*;

/**
 * Provides the abstract base class for a collection whose keys are embedded in the values.
 * 
 * @author Halofreak1990
 * 
 * @param <TKey>
 * The type of keys in the collection.
 * 
 * @param <TItem>
 * The type of items in the collection.
 */
public abstract class KeyedCollection<TKey, TItem> extends Collection<TItem>
{
	private IEqualityComparer<TKey> comparer;
	private HashMap<TKey, TItem> dict;
	private int keyCount;
	private int threshold;
	
	private static final int defaultThreshold = 0;
	
	public IEqualityComparer<TKey> getComparer()
	{
		return comparer;
	}
	
	protected Map<TKey, TItem> getDictionary()
	{
		return this.dict;
	}
	
	/**
	 * Gets the element with the specified key.
	 * 
	 * @param key
	 * The key of the element to get.
	 * 
	 * @return
	 * The element with the specified key. If an element with the specified key is not found, an exception is thrown.
	 * 
	 * @exception System.ArgumentNullException
	 * key is null.
	 * 
	 * @exception System.Collections.Generic.KeyNotFoundException
	 * An element with the specified key does not exist in the collection.
	 */
	public TItem get(TKey key)
	{
		if (key == null)
		{
			throw new ArgumentNullException("key");
		}
		
		if (this.dict != null)
		{
			return this.dict.get(key);
		}
		for (TItem item : super.getItems())
		{
			if (this.comparer.equals(this.GetKeyForItem(item), key))
			{
				return item;
			}
		}
		throw new KeyNotFoundException();
	}
	
	protected KeyedCollection()
	{
		this(null, defaultThreshold);	
	}
	
	protected KeyedCollection(IEqualityComparer<TKey> comparer)
	{
		this(comparer, defaultThreshold);
	}
	
	protected KeyedCollection(IEqualityComparer<TKey> comparer, int dictionaryCreationThreshold)
	{
		if (comparer == null)
		{
			
		}
		if (dictionaryCreationThreshold == -1)
		{
			dictionaryCreationThreshold = 0x7FFFFFFF;
		}
		if (dictionaryCreationThreshold < -1)
		{
			
		}
		this.comparer = comparer;
		threshold = dictionaryCreationThreshold;
	}
	
	/**
	 * Changes the key associated with the specified element in the lookup dictionary.
	 * 
	 * @param item
	 * The element to change the key of.
	 * 
	 * @param newKey
	 * The new key for item.
	 * 
	 * @exception System.ArgumentNullException
	 * item is null.-or-newKey is null.
	 * 
	 * @exception System.ArgumentException
	 * item is not found.-or-newKey already exists in the System.Collections.ObjectModel.KeyedCollection<T1,T2>.
	 */
	protected void ChangeItemKey(TItem item, TKey newKey)
	{
		if (!this.ContainsItem(item))
		{
			throw new ArgumentException("The specified item does not exist in this KeyedCollection.", "item");
		}
		TKey keyForItem = this.GetKeyForItem(item);
		if (!this.comparer.equals(keyForItem, newKey))
		{
			if (newKey != null)
			{
				this.AddKey(newKey, item);
			}
			if (keyForItem != null)
			{
				this.RemoveKey(keyForItem);
			}
		}
	}
	
	private void AddKey(TKey key, TItem item)
	{
		if (this.dict != null)
		{
			this.dict.put(key, item);
		}
		else if (this.keyCount == this.threshold)
		{
			this.CreateDictionary();
			this.dict.put(key, item);
		}
		else
		{
			if (this.Contains(key))
			{
				throw new ArgumentException("An item with the same key has already been added.");
			}
			this.keyCount++;
		}
	}
	
	@Override
	protected void ClearItems()
	{
		super.ClearItems();
		if (this.dict != null)
		{
			this.dict.clear();
		}
		this.keyCount = 0;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean Contains(TKey key)
	{
		if (key == null)
		{
			throw new ArgumentNullException("key");
		}
		if (this.dict != null)
		{
			return this.dict.containsKey(key);
		}
		if (key != null)
		{
			for (TItem local : super.getItems())
			{
				if (this.comparer.equals(this.GetKeyForItem(local), key))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean ContainsItem(TItem item)
	{
		TKey local;
		TItem local2;
		if ((this.dict != null) || ((local = this.GetKeyForItem(item)) != null))
		{
			return super.getItems().contains(item);
		}
		throw new NotImplementedException();
	}
	
	private void CreateDictionary()
	{
		this.dict = new HashMap<TKey, TItem>();
	}
	
	protected abstract TKey GetKeyForItem(TItem item);
	
	@Override
	protected void InsertItem(int index, TItem item)
	{
		TKey keyForItem = this.GetKeyForItem(item);
		if (keyForItem != null)
		{
			this.AddKey(keyForItem, item);
		}
		super.InsertItem(index, item);
	}
	
	public boolean Remove(TKey key)
	{
		if (key == null)
		{
			throw new ArgumentNullException("key");
		}
		if (this.dict != null)
		{
			return (this.dict.containsKey(key) && super.Remove(this.dict.get(key)));
		}
		if (key != null)
		{
			for (int i = 0; i < super.getItems().size(); i++)
			{
				if (this.comparer.equals(this.GetKeyForItem(super.getItems().get(i)), key))
				{
					this.RemoveItem(i);
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	protected void RemoveItem(int index)
	{
		TKey keyForItem = this.GetKeyForItem(super.getItems().get(index));
		if (keyForItem != null)
		{
			this.RemoveKey(keyForItem);
		}
		super.RemoveItem(index);
	}
	
	private void RemoveKey(TKey key)
	{
		if (this.dict != null)
		{
			this.dict.remove(key);
		}
		else
		{
			this.keyCount--;
		}
	}
	
	@Override
	protected void SetItem(int index, TItem item)
	{
		TKey keyForItem = this.GetKeyForItem(item);
		TKey x = this.GetKeyForItem(super.getItems().get(index));
		if (this.comparer.equals(x, keyForItem))
		{
			if ((keyForItem != null) && (this.dict != null))
			{
				this.dict.put(keyForItem, item);
			}
		}
		else
		{
			if (keyForItem != null)
			{
				this.AddKey(keyForItem, item);
			}
			if (x != null)
			{
				this.RemoveKey(x);
			}
		}
		super.SetItem(index, item);
	}
}
