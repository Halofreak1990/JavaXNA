package System.IO;

/**
 * The exception that is thrown when an attempt to access a file that does not exist fails.
 * 
 * @author Halofreak1990
 */
public class FileNotFoundException extends IOException
{
	private static final long serialVersionUID = -1765777697187273864L;
	
	private String fileName;
	
	/**
	 * 
	 * @return
	 */
	public String getFileName()
	{
		return fileName;
	}
	
	/**
	 * Initializes a new instance of the System.IO.FileNotFoundException class with its message string set to a system-supplied message.
	 */
	public FileNotFoundException()
	{
		
	}
	
	/**
	 * Initializes a new instance of the System.IO.FileNotFoundException class with its message string set to message.
	 * 
	 * @param message
	 * A description of the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 */
	public FileNotFoundException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of the System.IO.FileNotFoundException class with its message string set to message, specifying the file name that cannot be found.
	 * 
	 * @param message
	 * A String that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 * 
	 * @param fileName
	 * A String containing the full name of the file with the invalid image.
	 */
	public FileNotFoundException(String message, String fileName)
	{
		super(message);
		
		this.fileName = fileName;
	}
	
	/**
	 * 
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param fileName
	 * A String containing the full name of the file with the invalid image.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public FileNotFoundException(String message, String fileName, Throwable innerException)
	{
		super(message, innerException);
		
		this.fileName = fileName;
	}
	
	/**
	 * Initializes a new instance of the System.IO.FileNotFoundException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * A String that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public FileNotFoundException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}
