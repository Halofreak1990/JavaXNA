package System;

/**
 * The exception that is thrown when an arithmetic, casting, or conversion operation in a checked context results in an overflow.
 *
 * @author Halofreak1990
 */
public class OverflowException extends ArithmeticException
{
	private static final long serialVersionUID = -5005391265507630402L;
	
	/**
	 * Initializes a new instance of the OverflowException class.
	 */
	public OverflowException()
	{
		super("Arithmetic operation resulted in an overflow.");
	}

	/**
	 * Initializes a new instance of the OverflowException class with a specified error message.
	 * 
	 * @param message
	 * The message that describes the error.
	 */
	public OverflowException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of the OverflowException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not a null reference (Nothing in Visual Basic), the current exception is raised in a catch block that handles the inner exception.
	 */
	public OverflowException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}
