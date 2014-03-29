package Microsoft.Xna.Framework;

import java.util.*;

import System.*;
import System.Collections.Generic.*;

/**
 * Contains the CurveKeys making up a Curve.
 * 
 * @author Halofreak1990
 */
public class CurveKeyCollection implements ICollection<CurveKey>, Iterable<CurveKey>
{
	private boolean isReadOnly = false;
	private List<CurveKey> innerlist;

	/**
	 * Gets the number of elements contained in the CurveKeyCollection.
	 */
	@Override
	public int Count()
	{
		return innerlist.size();
	}

	/**
	 * Returns a value indicating whether the CurveKeyCollection is read-only.
	 */
	public boolean IsReadOnly()
	{
		return this.isReadOnly;
	}

	/**
	 * Gets the element at the specified index.
	 * 
	 * @param index
	 * The array index of the element.
	 * 
	 * @return
	 * The element at the specified index.
	 */
	public CurveKey get(int index)
	{
		return innerlist.get(index);
	}

	/**
	 * Sets the element at the specified index.
	 * 
	 * @param index
	 * The array index of the element.
	 * 
	 * @param value
	 */
	public void set(int index, CurveKey value)
	{
		if (value == null)
		{
			throw new ArgumentNullException();
		}

		if (index >= innerlist.size())
		{
			throw new ArgumentOutOfRangeException("index");
		}

		if (innerlist.get(index).getPosition() == value.getPosition())
		{
			innerlist.set(index, value);
		}
		else
		{
			innerlist.remove(index);
			innerlist.add(value);
		}
	}

	/**
	 * Initializes a new instance of the CurveKeyCollection class.
	 */
	public CurveKeyCollection()
	{
		innerlist = new ArrayList<CurveKey>();
	}

	/**
	 * Adds a CurveKey to the CurveKeyCollection.
	 * 
	 * @param item
	 * The CurveKey to add.
	 */
	@Override
	public void Add(CurveKey item)
	{
		if (item == null)
		{
			throw new ArgumentNullException();
		}

		if (innerlist.size() == 0)
		{
			this.innerlist.add(item);
			return;
		}

		for (int i = 0; i < this.innerlist.size(); i++)
		{
			if (item.getPosition() < this.innerlist.get(i).getPosition())
			{
				this.innerlist.add(i, item);
				return;
			}
		}

		this.innerlist.add(item);
	}

	/**
	 * Removes all CurveKeys from the CurveKeyCollection.
	 */
	@Override
	public void Clear()
	{
		innerlist.clear();
	}

	/**
	 * Creates a copy of the CurveKeyCollection.
	 * 
	 * @return
	 * A copy of the CurveKeyCollection.
	 */
	public CurveKeyCollection Clone()
	{
		CurveKeyCollection clone = new CurveKeyCollection();

		clone.innerlist.addAll(innerlist);

		return clone;
	}

	/**
	 * Determines whether the CurveKeyCollection contains a specific CurveKey.
	 * 
	 * @param item
	 * 
	 * 
	 * @return
	 * true if the CurveKey is found in the CurveKeyCollection; otherwise, false.
	 */
	@Override
	public boolean Contains(CurveKey item)
	{
		return innerlist.contains(item);
	}

	/**
	 * Copies the CurveKeys of the CurveKeyCollection to an array, starting at the array index provided.
	 * 
	 * @param array
	 * The destination of the CurveKeys copied from CurveKeyCollection. The array must have zero-based indexing.
	 * 
	 * @param arrayIndex
	 * The zero-based index in the array to start copying from.
	 */
	@Override
	public void CopyTo(CurveKey[] array, int arrayIndex)
	{
		CurveKey[] tmp = (CurveKey[])innerlist.toArray();

		// TODO: verify
		System.arraycopy(tmp, arrayIndex, array, 0, tmp.length);
	}

	/**
	 * Determines the index of a CurveKey in the CurveKeyCollection.
	 * 
	 * @param item
	 * The CurveKey to locate in the CurveKeyCollection.
	 * 
	 * @return
	 * The zero-based index of the specified item, or -1 if the item could not be found.
	 */
	public int IndexOf(CurveKey item)
	{
		return innerlist.indexOf(item);
	}

	/**
	 * Returns an Iterator that iterates through the CurveKeyCollection.
	 */
	@Override
	public Iterator<CurveKey> iterator()
	{
		return innerlist.iterator();
	}

	/**
	 * Removes the first occurrence of a specific CurveKey from the CurveKeyCollection.
	 * 
	 * @param item
	 * The CurveKey to remove from the CurveKeyCollection.
	 * 
	 * @return
	 * true if the item was successfully removed; otherwise, false. 
	 */
	@Override
	public boolean Remove(CurveKey item)
	{
		int index = this.IndexOf(item);

		if (index != -1)
		{
			this.RemoveAt(index);
			return true;
		}

		return false;
	}

	/**
	 * Removes the CurveKey at the specified index.
	 * 
	 * @param index
	 * The zero-based index of the item to remove.
	 */
	public void RemoveAt(int index)
	{
		innerlist.remove(index);
	}
}
