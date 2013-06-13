package Microsoft.Xna.Framework.Audio;

import System.*;

/**
 * Provides properties, methods, and events for play back of the audio buffer.
 * 
 * @author Halofreak1990
 */
public final class DynamicSoundEffectInstance extends SoundEffectInstance
{
	private AudioFormat format;
	
	/**
	 * Event that occurs when the number of audio capture buffers awaiting playback is less than or equal to two.
	 */
	public final Event<EventArgs> BufferNeeded = new Event<EventArgs>();
	
	/**
	 * Initializes a new instance of this class, which creates a dynamic sound effect based on the specified sample rate and audio channel.
	 * 
	 * @param sampleRate
	 * Sample rate, in Hertz (Hz), of audio content.
	 * 
	 * @param channels
	 * Number of channels in the audio data.
	 * 
	 * @throws System.ArgumentOutOfRangeException
	 * 
	 */
	public DynamicSoundEffectInstance(int sampleRate, AudioChannels channels)
	{
		if ((sampleRate < 8000) || (sampleRate > 48000))
		{
			throw new ArgumentOutOfRangeException("sampleRate");
		}
		if ((channels.getValue() < AudioChannels.Mono.getValue()) || (channels.getValue() > AudioChannels.Stereo.getValue()))
		{
			throw new ArgumentOutOfRangeException("channels");
		}
	    
	    // TODO: implement
	}
	
	/**
	 * 
	 */
	@Override
	protected void Dispose(boolean disposing)
	{
		synchronized (super.VoiceHandleLock)
		{
			if (!super.IsDisposed())
			{
				// TODO: implement
			}
			super.Dispose(disposing);
		}
	}
	
	/**
	 * Returns the sample duration based on the specified size of the audio buffer.
	 * 
	 * @param sizeInBytes
	 * Size, in bytes, of the audio data.
	 * 
	 * @throws System.ObjectDisposedException
	 * 
	 * @throws System.ArgumentException
	 * 
	 */
	public TimeSpan GetSampleDuration(int sizeInBytes)
	{
		synchronized (super.VoiceHandleLock)
		{
			if (super.IsDisposed())
				throw new ObjectDisposedException(super.getClass().getName(), "This object has already been disposed.");
			
			if (sizeInBytes < 0)
				throw new ArgumentException("Buffer size cannot be negative.");
			
			if (sizeInBytes == 0)
				return TimeSpan.Zero;
			
			// TODO: get this from AudioFormat
			throw new NotImplementedException();
		}
	}
	
	/**
	 * Returns the size of the audio buffer required to contain audio samples based on the specified duration.
	 * 
	 * @param duration
	 * TimeSpan object that contains the duration of the audio sample.
	 * 
	 * @throws System.ObjectDisposedException
	 * 
	 * @throws System.ArgumentOutOfException
	 *  
	 */
	public int GetSampleSizeInBytes(TimeSpan duration)
	{
		int num = 0;
		synchronized(super.VoiceHandleLock)
		{
			if (super.IsDisposed())
				throw new ObjectDisposedException(super.getClass().getName(), "This object has already been disposed.");
			
			if ((duration.getTotalMilliseconds() < 0.0) || (duration.getTotalMilliseconds() > 2147483647.0))
	        {
	            throw new ArgumentOutOfRangeException("duration");
	        }
	        if (duration == TimeSpan.Zero)
	        {
	            return 0;
	        }

	        try
	        {
	        	// TODO: implement
	        }
	        catch(OverflowException ex)
	        {
	        	throw new ArgumentOutOfRangeException("duration");
	        }
		}
		return num;
	}
	
	/**
	 * Begins or resumes audio playback.
	 * 
	 * @throws System.ObjectDisposedException
	 */
	@Override
	public void Play()
	{
		synchronized(super.VoiceHandleLock)
		{
			if (super.IsDisposed())
				throw new ObjectDisposedException(super.getClass().getName(), "This object has already been disposed.");
			
			// TODO: implement
			throw new NotImplementedException();
		}
	}
	
	/**
	 * Submits an audio buffer for playback. Playback starts at the beginning, and the buffer is played in its entirety.
	 * 
	 * @param buffer
	 * Buffer that contains the audio data. The audio format must be PCM wave data.
	 */
	public void SubmitBuffer(byte[] buffer)
	{
	    this.SubmitBuffer(buffer, 0, buffer.length);
	}
	
	/**
	 * Submits an audio buffer for playback. Playback begins at the specified offset, and the byte count determines the size of the sample played.
	 * 
	 * @param buffer
	 * Buffer that contains the audio data. The audio format must be PCM wave data.
	 * 
	 * @param offset
	 * Offset, in bytes, to the starting position of the data.
	 * 
	 * @param count
	 * Amount, in bytes, of data sent.
	 * 
	 * @throws System.ObjectDisposedException
	 * 
	 * @throws System.ArgumentException
	 * 
	 */
	public void SubmitBuffer(byte[] buffer, int offset, int count)
	{
		synchronized(super.VoiceHandleLock)
		{
			int num = 0;
			if (super.IsDisposed())
				throw new ObjectDisposedException(super.getClass().getName(), "This object has already been disposed.");
			
			if (((buffer == null) || (buffer.length == 0)) || !this.format.IsAligned(buffer.length))
			{
				throw new ArgumentException("Ensure that the buffer length is non-zero and meets the block alignment requirements for the audio format.");
			}
			if (((offset < 0) || ( offset >= buffer.length)) || !this.format.IsAligned(offset))
			{
				throw new ArgumentException("Offset must be within the buffer boundaries and meet the block alignment requirements for the audio format.");
			}
			try
			{
				num = offset + count;
			}
			catch(OverflowException ex)
			{
				throw new ArgumentException("Ensure that count is valid and meets the block alignment requirements for the audio format. Offset and count must define a valid region within the buffer boundaries.");
			}
			if (((count <= 0) || (num > buffer.length)) |!this.format.IsAligned(count))
			{
				throw new ArgumentException("Ensure that count is valid and meets the block alignment requirements for the audio format. Offset and count must define a valid region within the buffer boundaries.");
			}
			
			// TODO: implement
			throw new NotImplementedException();
		}
	}
}
