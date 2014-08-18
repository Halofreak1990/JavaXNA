package Microsoft.Xna.Framework.Audio;

import org.lwjgl.openal.AL10;

import resources.Resources;

import System.*;

/**
 * Provides properties, methods, and events for play back of the audio buffer.
 * 
 * @author Halofreak1990
 */
public final class DynamicSoundEffectInstance extends SoundEffectInstance
{
	private AudioChannels channels;
	private int format;
	private int sampleRate;

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

		this.sampleRate = sampleRate; 
		this.channels = channels; 

		switch (channels) 
		{ 
		case Mono: 
			this.format = AL10.AL_FORMAT_MONO16; 
			break; 
		case Stereo: 
			this.format = AL10.AL_FORMAT_STEREO16; 
			break; 
		default: 
			break; 
		}
	}
	
	void OnBufferNeeded()
	{
		if (BufferNeeded.hasHandlers())
		{
			BufferNeeded.raise(this, EventArgs.Empty);
		}
	}

	/**
	 * 
	 */
	@Override
	protected synchronized void Dispose(boolean disposing)
	{
		if (!super.IsDisposed())
		{
			// TODO: implement
		}
		
		super.Dispose(disposing);
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
	public synchronized TimeSpan GetSampleDuration(int sizeInBytes)
	{
		if (super.IsDisposed())
		{
			throw new ObjectDisposedException(super.getClass().getName(), Resources.GetString("Resources.ObjectDisposedException"));
		}

		if (sizeInBytes < 0)
		{
			throw new ArgumentException("Buffer size cannot be negative.");
		}

		if (sizeInBytes == 0)
		{
			return TimeSpan.Zero;
		}

		return TimeSpan.FromSeconds(sizeInBytes / (sampleRate * channels.getValue()));
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
	public synchronized int GetSampleSizeInBytes(TimeSpan duration)
	{
		int num = 0;
		
		if (super.IsDisposed())
		{
			throw new ObjectDisposedException(super.getClass().getName(), Resources.GetString("Resources.ObjectDisposedException"));
		}
			
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
			throw new ArgumentOutOfRangeException("duration", ex);
		}

		return num;
	}

	/**
	 * Begins or resumes audio playback.
	 * 
	 * @throws System.ObjectDisposedException
	 */
	@Override
	public synchronized void Play()
	{
		if (super.IsDisposed())
		{
			throw new ObjectDisposedException(super.getClass().getName(), Resources.GetString("Resources.ObjectDisposedException"));
		}

		// TODO: implement
		throw new NotImplementedException();
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
	public synchronized void SubmitBuffer(byte[] buffer, int offset, int count)
	{
		BindDataBuffer(buffer, format, count, sampleRate);
	}
}
