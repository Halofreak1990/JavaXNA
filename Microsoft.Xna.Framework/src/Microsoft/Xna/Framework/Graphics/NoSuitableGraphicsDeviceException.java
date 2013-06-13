package Microsoft.Xna.Framework.Graphics;

/**
 * Thrown when no available graphics device fits the given device preferences.
 * 
 * @author Halofreak1990
 */
public final class NoSuitableGraphicsDeviceException extends RuntimeException
{
	private static final long serialVersionUID = 7307861092681909385L;

	/**
	 * Creates a new instance of this object.
	 */
	public NoSuitableGraphicsDeviceException()
	{
		
	}
	
	/**
	 * Creates a new instance of this object.
	 * 
	 * @param message
	 * A message that describes the error.
	 */
	public NoSuitableGraphicsDeviceException(String message)
	{
		super(message);
	}
	
	/**
	 * Creates a new instance of this object.
	 * 
	 * @param message
	 * A message that describes the error.
	 * 
	 * The exception that is the cause of the current exception. If the inner parameter is not a null reference, the current exception is raised in a catch block that handles the inner exception.
	 */
	public NoSuitableGraphicsDeviceException(String message, RuntimeException inner)
	{
		super(message, inner);
	}
}
