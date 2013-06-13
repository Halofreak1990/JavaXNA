package Microsoft.Xna.Framework.Input;

import java.util.*;

import System.*;

/**
 * Represents a state of keystrokes recorded by a keyboard input device.
 *
 * @author Halofreak1990
 */
public final class KeyboardState extends ValueType implements IEquatable<KeyboardState>
{
    private Keys[] pressedKeys;

    /**
     * Initializes a new instance of the KeyboardState class.
     * 
     * @param keys
     * Array or parameter list of Keys to initialize as pressed.
     */
	public KeyboardState(Keys ...keys)
	{
		pressedKeys = keys;
	}
	
	/**
	 * Returns the state of a particular key.
	 * 
	 * @param key
	 * Enumerated value representing the key to query.
	 * 
	 * @return
	 * The state of the key specified by key.
	 */
	public KeyState get(Keys key)
	{
		if (pressedKeys != null)
		{
			for (Keys k : pressedKeys)
			{
				if (k == key)
					return KeyState.Down;
			}
		}
		return KeyState.Up;
    }
	
	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * Object to compare this object to.
	 * 
	 * @return
	 * true if the objects are the same; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return ((obj != null) && (obj instanceof KeyboardState)) ? this.Equals((KeyboardState)obj) : false;
	}

	public boolean Equals(KeyboardState other)
	{
		if (pressedKeys.length == other.pressedKeys.length)
		{
			List<Keys> thisList = Arrays.asList(pressedKeys);
			List<Keys> otherList = Arrays.asList(pressedKeys);
			
			for (int i = 0; i < thisList.size(); i++)
			{
				if (thisList.get(i) != otherList.get(i))
					return false;
			}
			
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the hash code for this instance.
	 * 
	 * @return
	 * Hash code for this object.
	 */
	@Override
	public int hashCode()
	{
		 return Arrays.deepHashCode(pressedKeys);
	}
	
	/**
	 * Gets an array of values that correspond to the keyboard keys that are currently being pressed.
	 * 
	 * @return
	 * The keys that are currently pressed.
	 */
	public Keys[] GetPressedKeys()
	{
	    return pressedKeys;
	}
	
	/**
	 * Returns whether a specified key is currently being pressed.
	 * 
	 * @param key
	 * Enumerated value that specifies the key to query.
	 * 
	 * @return
	 * true if the key specified by key is being held down; false otherwise.
	 */
	public boolean IsKeyDown(Keys key)
	{
	    return (get(key) == KeyState.Down);
	}
	
	/**
	 * Returns whether a specified key is currently not pressed.
	 * 
	 * @param key
	 * Enumerated value that specifies the key to query.
	 * 
	 * @return
	 * true if the key specified by key is not pressed; false otherwise.
	 */
	public boolean IsKeyUp(Keys key)
	{
	    return (get(key) == KeyState.Up);
	}
}
