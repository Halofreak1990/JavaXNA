package Microsoft.Xna.Framework.Audio;

import System.*;
import System.Collections.ObjectModel.*;

/**
 * Provides properties, methods, and fields and events for capturing audio data with microphones.
 * 
 * @author Halofreak1990
 */
public final class Microphone
{
	/**
	 * Returns the collection of all currently-available microphones.
	 */
	public static ReadOnlyCollection<Microphone> getAll()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets audio capture buffer duration of the microphone.
	 */
	public TimeSpan getBufferDuration()
	{
		throw new NotImplementedException();
	}

	/**
	 * Sets audio capture buffer duration of the microphone.
	 * 
	 * @param value
	 */
	public void setBufferDuration(TimeSpan value)
	{
		throw new NotImplementedException();
	}

	/**
	 * Returns the default attached microphone.
	 */
	public static Microphone getDefault()
	{
		throw new NotImplementedException();
	}

	/**
	 * Determines if the microphone is a wired headset or a Bluetooth device.
	 */
	public boolean IsHeadset()
	{
		throw new NotImplementedException();
	}

	/**
	 * Returns the friendly name of the microphone.
	 */
	public final String Name = ""; // TODO: use constructor to get this at run-time.

	/**
	 * Returns the sample rate at which the microphone is capturing audio data.
	 */
	public int getSampleRate()
	{
		throw new NotImplementedException();
	}

	/**
	 * Returns the recording state of the Microphone object.
	 */
	public MicrophoneState getState()
	{
		throw new NotImplementedException();
	}

	/**
	 * The event that occurs when the audio capture buffer is ready to processed.
	 */
	public final Event<EventArgs> BufferReady = new Event<EventArgs>();

	protected void finalize()
	{
	}

	/**
	 * Gets the latest recorded data from the microphone based on the audio capture buffer.
	 * 
	 * @param buffer
	 * Buffer, in bytes, containing the captured audio data. The audio format must be PCM wave data.
	 */
	public int GetData(byte[] buffer)
	{
		return this.GetData(buffer, 0, buffer.length);
	}

	/**
	 * Gets the latest captured audio data from the microphone based on the specified offset and byte count.
	 * 
	 * @param buffer
	 * Buffer, in bytes, containing the captured audio data. The audio format must be PCM wave data.
	 * 
	 * @param offset
	 * Offset, in bytes, to the starting position of the data.
	 * 
	 * @param count
	 * Amount, in bytes, of desired audio data.
	 */
	public int GetData(byte[ ] buffer, int offset, int count)
	{
		throw new NotImplementedException();
	}

	/**
	 * Returns the duration of audio playback based on the size of the buffer.
	 * 
	 * @param sizeInBytes
	 * Size, in bytes, of the audio data.
	 */
	public TimeSpan GetSampleDuration(int sizeInBytes)
	{
		throw new NotImplementedException();
	}

	/**
	 * Returns the size of the byte array required to hold the specified duration of audio for this microphone object.
	 * 
	 * @param duration
	 * TimeSpan object that contains the duration of the audio sample.
	 */
	public int GetSampleSizeInBytes(TimeSpan duration)
	{
		throw new NotImplementedException();
	}

	/**
	 * Starts microphone audio capture.
	 */
	public void Start()
	{
		throw new NotImplementedException();
	}

	/**
	 * Stops microphone audio capture.
	 */
	public void Stop()
	{
		throw new NotImplementedException();
	}
}
