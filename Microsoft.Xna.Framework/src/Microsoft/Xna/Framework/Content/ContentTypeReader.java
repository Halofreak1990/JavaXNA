package Microsoft.Xna.Framework.Content;

/**
 * Worker for reading a specific managed type from a binary format. Derive from this class to add new data types to the content pipeline system.
 * 
 * @author Halofreak1990
 */
public abstract class ContentTypeReader<T>
{
	/**
	 * Creates a new instance of ContentTypeReader.
	 */
	protected ContentTypeReader()
	{
		
	}
	
	/**
	 * Reads a strongly typed object from the current stream.
	 * 
	 * @param input
	 * The ContentReader used to read the object.
	 * 
	 * @param existingInstance
	 * An existing object to read into.
	 */
	protected abstract T Read(ContentReader input, T existingInstance);
}
