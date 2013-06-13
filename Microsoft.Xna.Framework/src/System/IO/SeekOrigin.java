package System.IO;

/**
 * Provides the fields that represent reference points in streams for seeking.
 * 
 * @author Halofreak1990
 */
public enum SeekOrigin
{
	/**
	 * Specifies the beginning of a stream.
	 */
	Begin,
	/**
	 * Specifies the current position within a stream.
	 */
	Current,
	/**
	 * Specifies the end of a stream.
	 */
	End
}
