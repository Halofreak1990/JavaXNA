package Microsoft.Xna.Framework.GamerServices;

/**
 * Thrown if there is a network communication failure.
 *
 * @author Halofreak1990
 */
public class NetworkException extends RuntimeException
{
	private static final long serialVersionUID = 1295060120272087109L;

	/**
	 * Creates an empty instance of NetworkException.
	 */
	public NetworkException()
	{
	}
	
	/**
	 * Initializes a new instance of NetworkException with the specified error message.
	 * 
	 * @param message
	 * A message that describes the error.
	 */
	public NetworkException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of NetworkException with the specified error message and the inner exception.
	 * 
	 * @param message
	 * A message that describes the error.
	 * 
	 * @param innerException
	 * The inner exception related to this exception.
	 */
	public NetworkException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}
