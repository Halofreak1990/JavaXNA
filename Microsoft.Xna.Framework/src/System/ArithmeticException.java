package System;

/**
 * The exception that is thrown for errors in an arithmetic, casting, or conversion operation.
 *
 * @author Halofreak1990
 */
public class ArithmeticException extends SystemException
{
	private static final long serialVersionUID = -6516069990192472566L;

	/**
	 * Initializes a new instance of the ArithmeticException class.
	 */
	public ArithmeticException()
	{
		super("Overflow or underflow in the arithmetic operation.");
	}

	/**
	 * Initializes a new instance of the ArithmeticException class with a specified error message.
	 * 
	 * @param message
	 * A String that describes the error.
	 */
	public ArithmeticException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of the ArithmeticException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not a null reference, the current exception is raised in a catch block that handles the inner exception.
	 */
	public ArithmeticException(String message, Exception innerException)
	{
		super(message, innerException);
	}
}
