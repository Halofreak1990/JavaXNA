package Microsoft.Xna.Framework.Audio;

import System.Runtime.InteropServices.*;

/**
 * The exception that is thrown when no audio hardware is present, or when audio hardware is installed, but the device drivers for the audio hardware are not present or enabled.
 * 
 * @author Halofreak1990
 */
public class NoAudioHardwareException extends ExternalException
{
	private static final long serialVersionUID = -6932617806066311072L;

	/**
	 * Initializes a new instance of this class.
	 */
	public NoAudioHardwareException()
	{
	}
	
	/**
	 * Initializes a new instance of this class with a specified error message.
	 * 
	 * @param message
	 * A message that describes the error.
	 */
	public NoAudioHardwareException(String message)
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
	public NoAudioHardwareException(String message, RuntimeException innerException)
	{
		super(message, innerException);
	}
}
