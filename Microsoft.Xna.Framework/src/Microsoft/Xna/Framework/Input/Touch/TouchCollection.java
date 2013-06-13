package Microsoft.Xna.Framework.Input.Touch;

import java.util.*;

import System.*;
import System.Collections.Generic.*;
import Microsoft.Xna.Framework.*;

/**
 * Provides methods and properties for accessing state information for the touch screen of a touch-enabled device. Reference page contains links to related code samples.
 *
 * @author Halofreak1990
 */
public class TouchCollection implements IList<TouchLocation>
{
	/**
	 * Indicates if the touch screen is available for use.
	 */
	public final boolean IsConnected;
    private int locationCount;
    private TouchLocation location0;
    private TouchLocation location1;
    private TouchLocation location2;
    private TouchLocation location3;
    private TouchLocation location4;
    private TouchLocation location5;
    private TouchLocation location6;
    private TouchLocation location7;
    private static TouchLocation[] prevLocations;

	/**
	 * Gets the current number of touch locations for the touch screen.
	 */
	@Override
	public int Count()
	{
		return this.locationCount;
	}
    
    /**
     * Determines if the touch location array is read-only.
     */
	@Override
	public boolean IsReadOnly()
	{
		return true;
	}
    
    /**
     * Initializes a new instance of the TouchCollection structure with a set of touch locations. Reference page contains links to related code samples.
     * 
     * @param touches
     * Array of touch locations.
     */
    @SuppressWarnings("null")
	public TouchCollection(TouchLocation[] touches)
    {
        if (touches == null)
        {
            throw new ArgumentNullException("touches");
        }
        if (touches.length > 8)
        {
            throw new ArgumentOutOfRangeException("touches");
        }
        this.IsConnected = true;
        this.locationCount = 0;
        this.location0 = new TouchLocation();
        this.location1 = new TouchLocation();
        this.location2 = new TouchLocation();
        this.location3 = new TouchLocation();
        this.location4 = new TouchLocation();
        this.location5 = new TouchLocation();
        this.location6 = new TouchLocation();
        this.location7 = new TouchLocation();
        for (TouchLocation location : touches)
        {
            TouchLocation location2 = null;
            if (location.TryGetPreviousLocation(location2))
            {
                this.AddTouchLocation(location.Id, location.State, location.Position.X, location.Position.Y, location2.State, location2.Position.X, location2.Position.Y);
            }
            else
            {
                this.AddTouchLocation(location.Id, location.State, location.Position.X, location.Position.Y, TouchLocationState.Invalid, 0f, 0f);
            }
        }
    }
    
    /**
     * Adds a TouchLocation to the collection.
     * 
     * @param item
     * TouchLocation to add.
     */
	@Override
	public void Add(TouchLocation item)
	{
		throw new NotSupportedException();
	}
	
	private void AddTouchLocation(int id, TouchLocationState state, float x, float y, TouchLocationState prevState, float prevX, float prevY)
	{
	    switch (this.locationCount++)
	    {
	        case 0:
	            this.location0 = new TouchLocation(id, state, x, y, prevState, prevX, prevY);
	            return;

	        case 1:
	            this.location1 = new TouchLocation(id, state, x, y, prevState, prevX, prevY);
	            return;

	        case 2:
	            this.location2 = new TouchLocation(id, state, x, y, prevState, prevX, prevY);
	            return;

	        case 3:
	            this.location3 = new TouchLocation(id, state, x, y, prevState, prevX, prevY);
	            return;

	        case 4:
	            this.location4 = new TouchLocation(id, state, x, y, prevState, prevX, prevY);
	            return;

	        case 5:
	            this.location5 = new TouchLocation(id, state, x, y, prevState, prevX, prevY);
	            return;

	        case 6:
	            this.location6 = new TouchLocation(id, state, x, y, prevState, prevX, prevY);
	            return;

	        case 7:
	            this.location7 = new TouchLocation(id, state, x, y, prevState, prevX, prevY);
	            return;
	    }
	}

	/**
	 * Removes all TouchLocation objects from the collection.
	 */
	@Override
	public void Clear()
	{
		throw new NotSupportedException();
	}

	/**
	 * Checks if the current touch collection contains the specified touch location.
	 * 
	 * @param item
	 * Touch location to be checked against the current collection.
	 */
	@Override
	public boolean Contains(TouchLocation item)
	{
		return (this.IndexOf(item) >= 0);
	}

	/**
	 * Copies the touch location to the collection at the specified index.
	 * 
	 * @param array
	 * Array receiving the copied touch location.
	 * 
	 * @param arrayIndex
	 * Target index of the collection.
	 */
	@Override
	public void CopyTo(TouchLocation[] array, int arrayIndex)
	{
		if (array == null)
	    {
	        throw new ArgumentNullException("array");
	    }
	    if (arrayIndex < 0)
	    {
	        throw new ArgumentOutOfRangeException("arrayIndex");
	    }
	    long num = arrayIndex + this.Count();
	    if (array.length < num)
	    {
	        throw new ArgumentOutOfRangeException("arrayIndex");
	    }
	    for (int i = 0; i < this.Count(); i++)
	    {
	        array[arrayIndex + i] = this.get(i);
	    }
	}
	
	/**
	 * Retrieves the touch location matching the specified ID.
	 * 
	 * @param id
	 * ID of touch location sought.
	 * 
	 * @param touchLocation
	 * [OutAttribute] Touch location item matching the specified ID.
	 */
	public boolean FindById(int id, TouchLocation touchLocation)
	{
		for (int i = 0; i < this.Count(); i++)
	    {
	        TouchLocation location = this.get(i);
	        if (location.Id == id)
	        {
	            touchLocation = this.get(i);
	            return true;
	        }
	    }
	    touchLocation = new TouchLocation();
	    return false;
	}
	
	@SuppressWarnings("unused")
	private boolean GetPreviousLocation(int id, int prevLocationCount, TouchLocation location)
	{
	    for (int i = 0; i < prevLocationCount; i++)
	    {
	        if (prevLocations[i].Id == id)
	        {
	            location = prevLocations[i];
	            return true;
	        }
	    }
	    location = new TouchLocation(-1, TouchLocationState.Invalid, Vector2.Zero);
	    return false;
	}

	/**
	 * Returns an iterator that iterates through the TouchCollection.
	 */
	@Override
	public Iterator<TouchLocation> iterator()
	{
		return new TouchCollectionIterator(this);
	}

	/**
	 * Determines the index of a TouchLocation in the TouchCollection.
	 * 
	 * @param item
	 * TouchLocation to locate in the collection.
	 */
	@Override
	public int IndexOf(TouchLocation item)
	{
		for (int i = 0; i < this.Count(); i++)
	    {
	        if (this.get(i) == item)
	        {
	            return i;
	        }
	    }
	    return -1;
	}

	/**
	 * Inserts a new TouchLocation into the TouchCollection at a specified index.
	 * 
	 * @param index
	 * Index in the touch collection for the new item.
	 * 
	 * @param item
	 * TouchLocation to be inserted.
	 */
	@Override
	public void Insert(int index, TouchLocation item)
	{
		throw new NotSupportedException();
	}

	/**
	 * Removes the specified TouchLocation from the TouchCollection.
	 * 
	 * @param item
	 * TouchLocation to be removed.
	 */
	@Override
	public boolean Remove(TouchLocation item)
	{
		throw new NotSupportedException();
	}
	
	/**
	 * Removes a TouchLocation at the specified index in the TouchCollection.
	 * 
	 * @param index
	 * Index of the TouchLocation to remove.
	 */
	@Override
	public void RemoveAt(int index)
	{
		throw new NotSupportedException();
	}

	/**
	 * Gets the information of the specified touch location.
	 * 
	 * @param index
	 * Index of the touch location to return.
	 */
	@Override
	public TouchLocation get(int index)
	{
		if ((index < 0) || (index >= this.Count()))
        {
            throw new ArgumentOutOfRangeException("index");
        }
        switch (index)
        {
            case 0:
                return this.location0;

            case 1:
                return this.location1;

            case 2:
                return this.location2;

            case 3:
                return this.location3;

            case 4:
                return this.location4;

            case 5:
                return this.location5;

            case 6:
                return this.location6;

            case 7:
                return this.location7;
        }
        return this.location7;
	}

	/**
	 * Sets the information of the specified touch location.
	 * 
	 * @param index
	 * Index of the touch location to set.
	 */
	@Override
	public void set(int index, TouchLocation item)
	{
		throw new NotSupportedException();
	}
	
	static 
	{
		prevLocations = new TouchLocation[8];
	}
	
	private final class TouchCollectionIterator implements Iterator<TouchLocation>
	{
		private TouchCollection t;
		private int position;
		
		public TouchCollectionIterator(TouchCollection t)
		{
			this.t = t;
			position = -1;
		}
		
		@Override
		public boolean hasNext()
		{
			return position < (t.Count() - 1);
		}

		@Override
		public TouchLocation next()
		{
			return t.get(++position);
		}

		@Override
		public void remove()
		{
			// TODO Auto-generated method stub
		}
	}
}
