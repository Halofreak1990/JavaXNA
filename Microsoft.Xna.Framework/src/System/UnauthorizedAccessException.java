package System;

/**
 * The exception that is thrown when the operating system denies access because of an I/O error or a specific type of security error.
 * 
 * @author Halofreak1990
 */
public class UnauthorizedAccessException extends SystemException
{
	private static final long serialVersionUID = -7225709467068722975L;

	/**
	 * Initializes a new instance of the UnauthorizedAccessException class.
	 */
	public UnauthorizedAccessException()
	{
		super("Attempted to perform an unauthorized operation.");
	}

	/**
	 * Initializes a new instance of the UnauthorizedAccessException class with a specified error message.
	 * 
	 * @param message
	 * The message that describes the error.
	 */
	public UnauthorizedAccessException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the UnauthorizedAccessException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the inner parameter is not a null reference (Nothing in Visual Basic), the current exception is raised in a catch block that handles the inner exception.
	 */
	public UnauthorizedAccessException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}
