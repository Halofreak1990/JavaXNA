/**
 * 
 */
package System.Runtime.InteropServices;

import System.SystemException;

/**
 * The base exception type for all COM interop exceptions and structured exception handling (SEH) exceptions.
 * 
 * @author Halofreak1990
 */
public class ExternalException extends SystemException
{
	private static final long serialVersionUID = -6713950041119098655L;
	private int errorCode;

	/**
	 * Gets the HRESULT of the error.
	 */
	public int getErrorCode()
	{
		return this.errorCode;
	}
	
	/**
	 * Initializes a new instance of the ExternalException class with default properties.
	 */
	public ExternalException()
	{
		super("External component has thrown an exception.");
	}

	/**
	 * Initializes a new instance of the ExternalException class with a specified error message.
	 * 
	 * @param message
	 * The error message that specifies the reason for the exception.
	 */
	public ExternalException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the ExternalException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the inner parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public ExternalException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
	
	/**
	 * Initializes a new instance of the ExternalException class with a specified error message and the HRESULT of the error.
	 *  
	 * @param message
	 * The error message that specifies the reason for the exception.
	 * 
	 * @param errorCode
	 * The HRESULT of the error.
	 */
	public ExternalException(String message, int errorCode)
	{
		super(message);
		this.errorCode = errorCode;
	}
}
