package System.IO;

/**
 * The exception that is thrown when a path or file name is longer than the system-defined maximum length.
 * 
 * @author Halofreak1990
 */
public class PathTooLongException extends IOException
{
	private static final long serialVersionUID = 7517606303129798672L;

	/**
	 * Initializes a new instance of the {@link System.IO.PathTooLongException} class.
	 */
	public PathTooLongException()
	{
		// TODO: add default message
		super("");
	}

	/**
	 * Initializes a new instance of the {@link System.IO.PathTooLongException} class with its message string set to message.
	 * 
	 * @param message
	 * A {@link java.lang.String} that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 */
	public PathTooLongException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the {@link System.IO.PathTooLongException} class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * A {@link java.lang.String} that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public PathTooLongException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}
