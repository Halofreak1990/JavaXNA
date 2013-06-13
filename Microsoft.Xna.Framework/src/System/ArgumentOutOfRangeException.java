package System;

/**
 * The exception that is thrown when the value of an argument is outside the allowable range of values as defined by the invoked method.
 * 
 * @author Halofreak1990
 */
public class ArgumentOutOfRangeException extends ArgumentException
{
	private static final long serialVersionUID = 1936158280585747234L;
	private Object m_actualValue;
	private static String _rangeMessage;
	
	/**
	 * Gets the argument value that causes this exception.
	 * 
	 * @return
	 * An Object that contains the value of the parameter that caused the current Exception.
	 */
	public Object getActualValue()
	{
		return m_actualValue;
	}
	
	private static String getRangeMessage()
	{
        if (_rangeMessage == null)
        {
            _rangeMessage = "Specified argument was out of the range of valid values.";
        }
        return _rangeMessage;
	}
	
	/**
	 * Initializes a new instance of the ArgumentOutOfRangeException class.
	 */
	public ArgumentOutOfRangeException()
	{
		super(getRangeMessage());
	}
	
	/**
	 * Initializes a new instance of the ArgumentOutOfRangeException class with the name of the parameter that causes this exception.
	 * 
	 * @param paramName
	 * The name of the parameter that causes this exception.
	 */
	public ArgumentOutOfRangeException(String paramName)
	{
		super(getRangeMessage(), paramName);
	}

	/**
	 * Initializes a new instance of the ArgumentOutOfRangeException class with a specified error message and the exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for this exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception, or a null reference (Nothing in Visual Basic) if no inner exception is specified.
	 */
	public ArgumentOutOfRangeException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
	
	/**
	 * Initializes a new instance of the ArgumentOutOfRangeException class with a specified error message and the name of the parameter that causes this exception.
	 * 
	 * @param paramName
	 * The name of the parameter that caused the exception.
	 * 
	 * @param message
	 * The message that describes the error.
	 */
	public ArgumentOutOfRangeException(String paramName, String message)
	{
		super(message, paramName);
	}
	
	/**
	 * Initializes a new instance of the ArgumentOutOfRangeException class with a specified error message, the parameter name, and the value of the argument.
	 * 
	 * @param paramName
	 * The name of the parameter that caused the exception.
	 * 
	 * @param actualValue
	 * The value of the argument that causes this exception.
	 * 
	 * @param message
	 * The message that describes the error.
	 */
	public ArgumentOutOfRangeException(String paramName, Object actualValue, String message)
	{
		super(message, paramName);
	    this.m_actualValue = actualValue;
	}
}
