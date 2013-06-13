package System.IO;

import System.SystemException;

/**
 * The exception that is thrown when an I/O error occurs.
 *
 * @author Halofreak1990
 */
public class IOException extends SystemException
{
	private static final long serialVersionUID = 4173497671292982923L;

	/**
	 * Initializes a new instance of the {@link IOException} class with its message string set to the empty string ("").
	 */
	public IOException()
	{
		super("I/O error occurred.");
	}
	
	/**
	 * Initializes a new instance of the {@link IOException} class with its message string set to message.
	 * 
	 * @param message
	 * A {@link String} that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 */
	public IOException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the {@link IOException} class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public IOException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}