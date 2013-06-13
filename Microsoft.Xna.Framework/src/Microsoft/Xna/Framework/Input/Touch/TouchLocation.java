package Microsoft.Xna.Framework.Input.Touch;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Provides methods and properties for interacting with a touch location on a touch screen device. Reference page contains links to related code samples.
 *
 * @author Halofreak1990
 */
public class TouchLocation implements IEquatable<TouchLocation>
{
	/**
	 * Gets the ID of the touch location.
	 */
	public final int Id;
	/**
	 * Gets the position of the touch location.
	 */
	public final Vector2 Position;
	/**
	 * Gets the state of the touch location.
	 */
	public final TouchLocationState State;
	
	private TouchLocationState prevState;
    private float prevX;
    private float prevY;
	
    /**
     * Initializes a new TouchLocation with an ID, state, position, and pressure.
     * 
     * @param id
     * ID of the new touch location.
     * 
     * @param state
     * State of the new touch location.
     * 
     * @param position
     * Position, in screen coordinates, of the new touch location.
     */
	public TouchLocation(int id, TouchLocationState state, Vector2 position)
	{
		this.Id = id;
		this.Position = position;
		this.State = state;
		this.prevState = TouchLocationState.Invalid;
	    this.prevX = 0f;
	    this.prevY = 0f;
	}
	
	/**
	 * Initializes a new TouchLocation with an ID, and a set of both current and previous state, position, and pressure values.
	 * 
	 * @param id
     * ID of the new touch location.
     * 
     * @param state
     * State of the new touch location.
     * 
     * @param position
     * Position, in screen coordinates, of the new touch location.
     * 
	 * @param previousState
	 * Previous state for the new touch location.
	 * 
	 * @param previousPosition
	 * Previous position for the new touch location.
	 */
	public TouchLocation(int id, TouchLocationState state, Vector2 position, TouchLocationState previousState, Vector2 previousPosition)
	{
	    this.Id = id;
	    this.State = state;
	    this.Position = position;
	    this.prevState = previousState;
	    this.prevX = previousPosition.X;
	    this.prevY = previousPosition.Y;
	}
	
	TouchLocation(int id, TouchLocationState state, float x, float y, TouchLocationState prevState, float prevX, float prevY)
	{
		this.Id = id;
		this.Position = new Vector2(x, y);
		this.State = state;
		this.prevState = prevState;
		this.prevX = prevX;
		this.prevY = prevY;
	}
	
	/**
	 * Creates an empty instance of TouchLocation.
	 */
	public TouchLocation()
	{
		this.Id = -1;
		this.Position = Vector2.Zero;
		this.State = TouchLocationState.Invalid;
		this.prevState = TouchLocationState.Invalid;
		this.prevX = 0f;
		this.prevY = 0f;
	}

	/**
	 * Determines whether the current TouchLocation is equal to the specified object.
	 * 
	 * @param obj
	 * The Object to compare with the touch location.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof TouchLocation) ? (this.Equals((TouchLocation)obj)) : false;
	}
	
	/**
	 * Determines whether the current TouchLocation is equal to the specified TouchLocation.
	 * 
	 * @param other
	 * The TouchLocation to compare with this instance.
	 */
	@Override
	public boolean Equals(TouchLocation other)
	{
		return ((((this.Id == other.Id) && (this.Position.X == other.Position.X)) && ((this.Position.Y == other.Position.Y) && (this.prevX == other.prevX))) && (this.prevY == other.prevY));
	}
	
	/**
	 * Gets the hash code for this TouchLocation.
	 */
	@Override
	public int hashCode()
	{
		return (this.Id + this.Position.hashCode());
	}
	
	/**
	 * Gets a string representation of the TouchLocation.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{{Position:%s}}", Position.toString());
	}
	
	/**
	 * Attempts to get the previous location of this touch location object.
	 * 
	 * @param previousLocation
	 * [OutAttribute] Previous location data, as a TouchLocation.
	 */
	public boolean TryGetPreviousLocation(TouchLocation previousLocation)
	{
	    if (this.prevState == TouchLocationState.Invalid)
	    {
	    	previousLocation = new TouchLocation(-1, TouchLocationState.Invalid, 0f, 0f, TouchLocationState.Invalid, 0f, 0f);
	        return false;
	    }
	    previousLocation = new TouchLocation(this.Id, this.prevState, this.prevX, this.prevY, TouchLocationState.Invalid, 0f, 0f);
	    return true;
	}
}
