package System;

/**
 * The exception that is thrown when a null reference (Nothing in Visual Basic) is passed to a method that does not accept it as a valid argument.
 * 
 * @author Halofreak1990
 */
public class ArgumentNullException extends ArgumentException
{
	private static final long serialVersionUID = 800252147418531824L;

	/**
	 * Initializes a new instance of the ArgumentNullException class.
	 */
	public ArgumentNullException()
	{
	}
	
	/**
	 * Initializes a new instance of the ArgumentNullException class with the name of the parameter that causes this exception.
	 * 
	 * @param paramName
	 * The name of the parameter that caused the exception.
	 */
	public ArgumentNullException(String paramName)
	{
		super("", paramName);
	}
	
	/**
	 * Initializes an instance of the ArgumentNullException class with a specified error message and the name of the parameter that causes this exception.
	 * 
	 * @param paramName
	 * The name of the parameter that caused the exception.
	 * 
	 * @param message
	 * A message that describes the error.
	 */
	public ArgumentNullException(String paramName, String message)
	{
		super(message, paramName);
	}
}
