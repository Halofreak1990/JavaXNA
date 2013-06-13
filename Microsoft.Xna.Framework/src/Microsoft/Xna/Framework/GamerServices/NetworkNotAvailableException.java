package Microsoft.Xna.Framework.GamerServices;

/**
 * Thrown if a network connection is unavailable.
 *
 * @author Halofreak1990
 */
public class NetworkNotAvailableException extends NetworkException
{
	private static final long serialVersionUID = 8161131599089372881L;

	/**
	 * Initializes a new NetworkNotAvailableException.
	 */
	public NetworkNotAvailableException()
	{
	}
	
	/**
	 * Initializes a new NetworkNotAvailableException with a specified error message.
	 * 
	 * @param message
	 * Text that describes the error.
	 */
	public NetworkNotAvailableException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new NetworkNotAvailableException with a specified error message and a reference to the inner exception that caused the error.
	 * 
	 * @param message
	 * Text that describes the error.
	 * 
	 * @param innerException
	 * The exception that caused the GameUpdateRequiredException. If this parameter is not null, this exception is raised in a catch block that handles the inner exception.
	 */
	public NetworkNotAvailableException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}
