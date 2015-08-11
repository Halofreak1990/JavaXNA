package System.IO;

/**
 * The exception that is thrown when part of a file or directory cannot be found.
 * 
 * @author Halofreak1990
 */
public class DirectoryNotFoundException extends IOException
{
	private static final long serialVersionUID = -5299787258048951929L;

	/**
	 * Initializes a new instance of the {@link System.IO.DirectoryNotFoundException} class with its message string set to a system-supplied message.
	 */
	public DirectoryNotFoundException()
	{
	}

	/**
	 * Initializes a new instance of the {@link System.IO.DirectoryNotFoundException} class with its message string set to message.
	 * 
	 * @param message
	 * A {@link java.lang.String} that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 */
	public DirectoryNotFoundException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the {@link System.IO.DirectoryNotFoundException} class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public DirectoryNotFoundException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}
