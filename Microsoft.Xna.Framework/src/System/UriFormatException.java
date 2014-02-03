package System;

/**
 * The exception that is thrown when an invalid Uniform Resource Identifier (URI) is detected.
 * 
 * @author Halofreak1990
 */
public class UriFormatException extends FormatException
{
	private static final long serialVersionUID = 3724278989095091838L;

	/**
	 * Initializes a new instance of the System.UriFormatException class.
	 */
	public UriFormatException()
	{
	}

	/**
	 * Initializes a new instance of the System.UriFormatException class with the specified message.
	 * 
	 * @param textString
	 * The error message string.
	 */
	public UriFormatException(String textString)
	{
		super(textString);
	}

	/**
	 * Initializes a new instance of the System.UriFormatException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param textString
	 * The message that describes the exception. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 * 
	 * @param e
	 * The exception that is the cause of the current exception. If the innerException parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public UriFormatException(String textString, RuntimeException e)
	{
		super(textString, e);
	}
}
