package System;

/**
 * The exception that is thrown when an operation is performed on a disposed object.
 * 
 * @author Halofreak1990
 */
public class ObjectDisposedException extends InvalidOperationException
{
	private static final long serialVersionUID = -3376817279497008053L;

	/**
	 * Initializes a new instance of the ObjectDisposedException class with a string containing the name of the disposed object.
	 * 
	 * @param objectName
	 * A string containing the name of the disposed object. 
	 */
	public ObjectDisposedException(String objectName)
	{
		
	}

	/**
	 * Initializes a new instance of the ObjectDisposedException class with the specified object name and message.
	 * 
	 * @param objectName
	 * The name of the disposed object.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 */
	public ObjectDisposedException(String objectName, String message)
	{
		
	}
}
