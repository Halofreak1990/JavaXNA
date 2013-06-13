package Microsoft.Xna.Framework.Net;

import Microsoft.Xna.Framework.GamerServices.*;

/**
 * Thrown if an error was encountered while joining a session.
 *
 * @author Halofreak1990
 */
public class NetworkSessionJoinException extends NetworkException
{
	private static final long serialVersionUID = 257936337074730508L;
	
	private NetworkSessionJoinError joinError;

	/**
	 * Gets or sets a more detailed description of the session join failure.
	 */
	public NetworkSessionJoinError getJoinError()
	{
		return this.joinError;
	}
	
	/**
	 * Creates an empty instance of NetworkSessionJoinException.
	 */
	public NetworkSessionJoinException()
	{
	}
	
	/**
	 * Creates an instance of NetworkSessionJoinException with the specified error message.
	 * 
	 * @param message
	 * A message that describes the error.
	 */
	public NetworkSessionJoinException(String message)
	{
		super(message);
	}
	
	/**
	 * Creates an instance of NetworkSessionJoinException with the specified error and additional information on the exception.
	 * 
	 * @param message
	 * A message that describes the error.
	 * 
	 * @param joinError
	 * Reason for the exception.
	 */
	public NetworkSessionJoinException(String message, NetworkSessionJoinError joinError)
    {
		super(message);
        this.joinError = joinError;
    }
	
	/**
	 * Creates an instance of NetworkSessionJoinException with the specified error message and inner exception.
	 * 
	 * @param message
	 * A message that describes the error.
	 * 
	 * @param innerException
	 * The inner exception related to this exception.
	 */
	public NetworkSessionJoinException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}
