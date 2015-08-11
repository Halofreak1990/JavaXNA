package System;

/**
 * The exception that is thrown when one of the arguments provided to a method is not valid.
 * 
 * @author Halofreak1990
 */
public class ArgumentException extends SystemException
{
	private static final long serialVersionUID = 6204193730117063228L;

	private String paramName;

	/**
	 * 
	 * @return
	 */
	public String getParamName()
	{
		return paramName;
	}

	/**
	 * Initializes a new instance of the ArgumentException class.
	 */
	public ArgumentException()
	{	
	}

	/**
	 * Initializes a new instance of the ArgumentException class with a specified error message.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 */
	public ArgumentException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the {@link System.ArgumentException} class with a specified error message and the name of the parameter that causes this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param paramName
	 * The name of the parameter that caused the current exception.
	 */
	public ArgumentException(String message, String paramName)
	{
		super(message);

		this.paramName = paramName;
	}

	/**
	 * Initializes a new instance of the {@link System.ArgumentException} class with a specified error message, the parameter name, and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param paramName
	 * The name of the parameter that caused the current exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not a null reference, the current exception is raised in a catch block that handles the inner exception.
	 */
	public ArgumentException(String message, String paramName, Throwable innerException)
	{
		super(message, innerException);

		this.paramName = paramName;
	}

	/**
	 * Initializes a new instance of the {@link System.ArgumentException} class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not a null reference, the current exception is raised in a catch block that handles the inner exception.
	 */
	public ArgumentException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}
