package System.IO.IsolatedStorage;

/**
 * The exception that is thrown when an operation in isolated storage fails.
 * 
 * @author Halofreak1990
 */
public class IsolatedStorageException extends RuntimeException
{
	private static final long serialVersionUID = -7156141805423784525L;

	/**
	 * Initializes a new instance of the {@link System.IO.IsolatedStorage.IsolatedStorageException} class with default properties.
	 */
	public IsolatedStorageException()
	{
		
	}

	/**
	 * Initializes a new instance of the {@link System.IO.IsolatedStorage.IsolatedStorageException} class with a specified error message.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 */
	public IsolatedStorageException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the {@link System.IO.IsolatedStorage.IsolatedStorageException} class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * The error message that explains the reason for the exception.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the inner parameter is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public IsolatedStorageException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}
