package System;

/**
 * Defines the base class for predefined exceptions in the System namespace.
 *
 * @author Halofreak1990
 */
public class SystemException extends RuntimeException
{
	private static final long serialVersionUID = -3710001825928098597L;

	/**
	 * Initializes a new instance of the SystemException class.
	 */
	public SystemException()
	{
	}
	
	/**
	 * Initializes a new instance of the SystemException class with a specified error message.
	 * 
	 * @param message
	 * The message that describes the error.
	 */
	public SystemException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of the SystemException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not a null reference (Nothing in Visual Basic), the current exception is raised in a catch block that handles the inner exception.
	 * 
	 */
	public SystemException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}
