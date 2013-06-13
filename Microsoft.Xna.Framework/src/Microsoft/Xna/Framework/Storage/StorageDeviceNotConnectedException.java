package Microsoft.Xna.Framework.Storage;

import System.Runtime.InteropServices.ExternalException;

/**
 * The exception that is thrown when the requested StorageDevice is not connected.
 * 
 * @author Halofreak1990
 */
public class StorageDeviceNotConnectedException extends ExternalException
{
	private static final long serialVersionUID = 4681405856688169339L;

	/**
	 * Initializes a new instance of this class.
	 */
	public StorageDeviceNotConnectedException()
	{
		
	}
	
	/**
	 * Initializes a new instance of this class with a specified error message.
	 * 
	 * @param message
	 * A message that describes the error.
	 */
	public StorageDeviceNotConnectedException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of this class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * A message that describes the error.
	 * 
	 * @param innerException
	 * The exception that is the cause of the current exception. If the innerException parameter is not a null reference, the current exception is raised in a catch block that handles the inner exception.
	 */
	public StorageDeviceNotConnectedException(String message, Throwable innerException)
	{
		super(message, innerException);
	}
}
