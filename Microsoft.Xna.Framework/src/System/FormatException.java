package System;

/**
 * The exception that is thrown when the format of an argument does not meet the parameter specifications of the invoked method.
 *
 * @author Halofreak1990
 */
public class FormatException extends SystemException
{
	private static final long serialVersionUID = -5358133767600256214L;
	
	/**
	 * Initializes a new instance of the FormatException class.
	 */
	public FormatException()
	{
		super("One of the identified items was in an invalid format.");
	}

	/**
	 * Initializes a new instance of the FormatException class with a specified error message.
	 * 
	 * @param message
	 * The message that describes the error.
	 */
	public FormatException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the FormatException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not a null reference (Nothing in Visual Basic), the current exception is raised in a catch block that handles the inner exception.
	 */
	public FormatException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}
