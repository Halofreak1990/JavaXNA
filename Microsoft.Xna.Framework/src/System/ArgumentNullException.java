package System;

import resources.Resources;

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
		super(Resources.GetString("ArgumentNull_Generic"), paramName);
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

	/**
	 * Initializes a new instance of the {@link System.ArgumentNullException} class with a specified error message and the exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for this exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception, or a null reference if no inner exception is specified.
	 */
	public ArgumentNullException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}
