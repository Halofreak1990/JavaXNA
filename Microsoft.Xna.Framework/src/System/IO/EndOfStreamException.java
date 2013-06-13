package System.IO;

/**
 * The exception that is thrown when reading is attempted past the end of a stream.
 * 
 * @author Halofreak1990
 */
public class EndOfStreamException extends IOException
{
	private static final long serialVersionUID = -6660553153663114383L;

	/**
	 * Initializes a new instance of the EndOfStreamException class with its message string set to a system-supplied message.
	 */
	public EndOfStreamException()
	{
		super("Attempted to read past the end of the stream.");
	}

	/**
	 * Initializes a new instance of the EndOfStreamException class with its message string set to message.
	 * 
	 * @param message
	 * A string that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 */
	public EndOfStreamException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of the EndOfStreamException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * A string that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not null, the current exception is raised in a catch block that handles the inner exception. 
	 */
	public EndOfStreamException(String message, Exception innerException)
	{
		super(message, innerException);
	}
}
