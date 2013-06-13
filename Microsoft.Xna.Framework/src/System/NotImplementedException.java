/**
 * 
 */
package System;

/**
 * The exception that is thrown when a requested method or operation is not implemented.
 * 
 * @author Halofreak1990
 */
public class NotImplementedException extends SystemException
{
	private static final long serialVersionUID = -1526409439397001047L;

	/**
	 * Initializes a new instance of the NotImplementedException class with default properties.
	 */
	public NotImplementedException()
	{
		super("The method or operation is not implemented.");
	}

	/**
	 * Initializes a new instance of the NotImplementedException class with a specified error message.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 */
	public NotImplementedException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the NotImplementedException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the inner parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public NotImplementedException(String message, Exception innerException)
	{
		super(message, innerException);
	}
}
