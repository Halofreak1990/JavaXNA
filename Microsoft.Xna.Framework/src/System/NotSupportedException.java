package System;

/**
 * The exception that is thrown when an invoked method is not supported, or when there is an attempt to read, seek, or write to a stream that does not support the invoked
 * functionality.
 * 
 * @author Halofreak1990
 */
public class NotSupportedException extends SystemException
{
	private static final long serialVersionUID = -6759585358499417028L;

	/**
	 * 
	 */
	public NotSupportedException()
	{
		
	}
	
	/**
	 * Initializes a new instance of the NotSupportedException class with a specified error message.
	 * 
	 * @param message
	 * A String that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has
	 * been localized for the current system culture.
	 */
	public NotSupportedException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of the NotSupportedException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not a null reference, the current exception is raised in a catch block that
	 * handles the inner exception.
	 */
	public NotSupportedException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}
