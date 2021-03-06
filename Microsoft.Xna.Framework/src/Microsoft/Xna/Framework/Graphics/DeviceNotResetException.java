package Microsoft.Xna.Framework.Graphics;

/**
 * The exception that is thrown when the device has been lost, but can be reset at this time. 
 * 
 * @author Halofreak1990
 */
public final class DeviceNotResetException extends RuntimeException
{
	private static final long serialVersionUID = 8880792622387355699L;

	/**
	 * Initializes a new instance of this class.
	 */
	public DeviceNotResetException()
	{
	}

	/**
	 * Initializes a new instance of this class with the specified error message.
	 * 
	 * @param message
	 * A message that describes the error.
	 */
	public DeviceNotResetException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of this class with the specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * A message that describes the error.
	 * 
	 * @param inner
	 * The exception that is the cause of the current exception. If the inner parameter is not a null reference, the current exception is raised in a catch block that handles the inner exception.
	 */
	public DeviceNotResetException(String message, RuntimeException inner)
	{
		super(message, inner);
	}
}
