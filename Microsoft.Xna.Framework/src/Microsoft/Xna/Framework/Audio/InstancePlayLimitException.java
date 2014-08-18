package Microsoft.Xna.Framework.Audio;

import System.Runtime.InteropServices.ExternalException;

/**
 * The exception that is thrown when there is an attempt to play more than the platform specific maximum SoundEffectInstance sounds concurrently.
 * 
 * @author Halofreak1990
 */
public class InstancePlayLimitException extends ExternalException
{
	private static final long serialVersionUID = 5795485118619112644L;

	/**
	 * Initializes a new instance of the InstancePlayLimitException class.
	 */
	public InstancePlayLimitException()
	{
	}
	
	/**
	 * Initializes a new instance of the InstancePlayLimitException class with a specified error message.
	 * 
	 * @param message
	 * A String that describes the error. The content of message is intended to be understood by humans. The caller of this constructor is required to ensure that this string has been localized for the current system culture.
	 */
	public InstancePlayLimitException(String message)
	{
		super(message);
	}
	
	/**
	 * Initializes a new instance of the InstancePlayLimitException class with a specified error message and a reference to the inner exception that is the cause of this exception.
	 * 
	 * @param message
	 * Error message that explains the reason for the exception.
	 * 
	 * @param inner
	 * Exception that is the cause of the current exception. If innerException is not null, the current exception is raised in a catch block that handles the inner exception.
	 */
	public InstancePlayLimitException(String message, Throwable inner)
	{
		super(message, inner);
	}
}
