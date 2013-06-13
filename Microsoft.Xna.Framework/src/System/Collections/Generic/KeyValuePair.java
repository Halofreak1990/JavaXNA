package System.Collections.Generic;

/**
 * Defines a key/value pair that can be set or retrieved.
 * 
 * @author Halofreak1990
 */
public class KeyValuePair<TKey, TValue>
{
	private TKey key;
	private TValue value;
	
	/**
	 * Gets the key in the key/value pair.
	 * 
	 * @return
	 * A TKey that is the key of the KeyValuePair<,>
	 */
	public TKey getKey()
	{
		return key;
	}
	
	/**
	 * Gets the value in the key/value pair.
	 * 
	 * @return
	 * A TValue that is the value of the KeyValuePair<,>
	 */
	public TValue getValue()
	{
		return value;
	}
	
	/**
	 * Initializes a new instance of the KeyValuePair<,> structure with the specified key and value.
	 * 
	 * @param key
	 * The definition associated with key.
	 * 
	 * @param value
	 * The definition associated with value.
	 */
	public KeyValuePair(TKey key, TValue value)
	{
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Returns a string representation of the KeyValuePair<,>, using the string representations of the key and value.
	 *  
	 * @return
	 * A string representation of the KeyValuePair<,>, which includes the string representations of the key and value.
	 */
	public String ToString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		if (this.key != null)
		{
			builder.append(this.key.toString());
		}
		builder.append(',');
		if (this.value != null)
		{
			builder.append(this.value.toString());
		}
		builder.append(']');
		return builder.toString();
	}
}
