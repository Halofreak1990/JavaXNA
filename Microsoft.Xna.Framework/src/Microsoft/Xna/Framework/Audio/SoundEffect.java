package Microsoft.Xna.Framework.Audio;

import java.io.*;
import java.util.*;

import org.lwjgl.openal.*;

import System.*;

/**
 * Reference page contains links to related code samples.
 * 
 * @author Halofreak1990
 */
public final class SoundEffect implements IDisposable
{
	byte[] _data;
	float Rate;
	int Size;
	int Format;
	private static float currentVolume;
	private static float distanceScale;
	private static float dopplerScale;
	private TimeSpan duration;
	private String effectName;
	private boolean isDisposed;
	private static float maxVelocityComponent;
	private static float speedOfSound;
	private List<SoundEffectInstance> children = new ArrayList<SoundEffectInstance>();
	
	void ChildDestroyed(SoundEffectInstance instance)
	{
		if (children.contains(instance))
		{
			children.remove(instance);
		}
	}
	
	/**
	 * Gets a value that adjusts the effect of distance calculations on the sound (emitter).
	 */
	public static float getDistanceScale()
	{
		return distanceScale;
	}
	
	/**
	 * Sets a value that adjusts the effect of distance calculations on the sound (emitter).
	 */
	public static void setDistanceScale(float value)
	{
		if (value < 0)
		{
			throw new ArgumentOutOfRangeException("value");
		}
		
		value = (value <= Float.MIN_NORMAL) ? Float.MIN_NORMAL : value;
		distanceScale = value;
		// SoundEffectUnsafeNativeMethods.SetDistanceScale(distanceScale);
	}
	
	/**
	 * Gets a value that adjusts the effect of doppler calculations on the sound (emitter).
	 */
	public static float getDopplerScale()
	{
		return dopplerScale;
	}
	
	/**
	 * Sets a value that adjusts the effect of doppler calculations on the sound (emitter).
	 */
	public synchronized static void setDopplerScale(float value)
	{
		if (value < 0f)
		{
			throw new ArgumentOutOfRangeException("value");
		}
		
		dopplerScale = value;
		AL10.alDopplerFactor(dopplerScale);
	}
	
	/**
	 * Gets the duration of the SoundEffect.
	 */
	public TimeSpan getDuration()
	{
		return this.duration;
	}
	
	/**
	 * Gets a value that indicates whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		return isDisposed;
	}
	
	/**
	 * Gets the master volume that affects all SoundEffectInstance sounds.
	 */
	public static float getMasterVolume()
	{
		return currentVolume;
	}
	
	/**
	 * Sets the master volume that affects all SoundEffectInstance sounds.
	 */
	public static void setMasterVolume(float value)
	{
		if (value < 0f || value > 1f)
		{
			throw new ArgumentOutOfRangeException("value");
		}
		
		currentVolume = value;
		
		SoundEffectInstancePool.UpdateMasterVolume();
	}
	
	static float getMaxVelocityComponent()
	{
		return maxVelocityComponent;
	}
	
	/**
	 * Gets the asset name of the SoundEffect.
	 */
	public String getName()
	{
		return this.effectName;
	}
	
	/**
	 * Sets the asset name of the SoundEffect to the specified value.
	 */
	public void setName(String value)
	{
		if (isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "");
		}
		
		if (value == null || value == "")
		{
			throw new ArgumentNullException("value");
		}
		
		this.effectName = value;
	}
	
	/**
	 * Returns the speed of sound. 343.5 meters per second.
	 */
	public static float getSpeedOfSound()
	{
		return speedOfSound;
	}
	
	/**
	 * Sets the speed of sound.
	 */
	public synchronized static void setSpeedOfSound(float value)
	{
		if (value <= 0f)
		{
			throw new ArgumentOutOfRangeException("value");
		}
		
		speedOfSound = value;
		maxVelocityComponent = speedOfSound - (speedOfSound / 1000f);
		AL11.alSpeedOfSound(speedOfSound);
	}
	
	private SoundEffect(InputStream stream)
	{
		Integer format = null;
		Integer size = null;
		Integer freq = null;
		
        _data = AudioLoader.Load(stream, format, size, freq);
        
        Format = format;
        Size = size;
        Rate = freq;
	}
	
	/**
	 * Initializes a new instance of SoundEffect based on an audio buffer, sample rate, and number of audio channels. Reference page contains links to related conceptual articles.
	 * 
	 * @param buffer
	 * Buffer that contains the audio data. The audio format must be PCM wave data.
	 * 
	 * @param sampleRate
	 * Sample rate, in Hertz (Hz), of audio data.
	 * 
	 * @param channels
	 * Number of channels (mono or stereo) of audio data.
	 */
	public SoundEffect(byte[] buffer, int sampleRate, AudioChannels channels)
	{
		if (buffer == null || buffer.length == 0)
		{
			throw new ArgumentException("Buffer is invalid. Ensure that the buffer length is non-zero and meets the block alignment requirements for the audio format.");
		}
		
		duration = GetSampleDuration(buffer.length, sampleRate, channels);
		
		// TODO: implement
	}
	
	/**
	 * Initializes a new instance of SoundEffect with specified parameters such as audio sample rate, channels, looping criteria, and a buffer to hold the audio. Reference page contains links to related conceptual articles.
	 * 
	 * @param buffer
	 * Buffer that contains the audio data. The audio format must be PCM wave data.
	 * 
	 * @param offset
	 * Offset, in bytes, to the starting position of the audio data.
	 * 
	 * @param count
	 * Amount, in bytes, of audio data.
	 * 
	 * @param sampleRate
	 * Sample rate, in Hertz (Hz), of audio data.
	 * 
	 * @param channels
	 * Number of channels (mono or stereo) of audio data.
	 * 
	 * @param loopStart
	 * Loop start in samples.
	 * 
	 * @param loopLength
	 * Loop length in samples.
	 */
	public SoundEffect(byte[] buffer, int offset, int count, int sampleRate, AudioChannels channels, int loopStart, int loopLength)
	{
		duration = GetSampleDuration(count, sampleRate, channels);
		
		// TODO: implement
	}
	
	SoundEffectInstance GetPooledInstance()
	{
		 if (!SoundEffectInstancePool.SoundsAvailable())
		 {
			 return null;
		 }
		 
		 SoundEffectInstance inst = SoundEffectInstancePool.GetInstance();
		 inst._effect = this;
		 
		 inst.InitializeSound();
         inst.BindDataBuffer(_data, Format, Size, (int)Rate);
		 
		 return inst;
	}
	
	/**
	 * Creates a new SoundEffectInstance for this SoundEffect. Reference page contains links to related code samples.
	 */
	public synchronized SoundEffectInstance CreateInstance()
	{
		SoundEffectInstance inst = new SoundEffectInstance();

		inst.InitializeSound();
        inst.BindDataBuffer(_data, Format, Size, (int)Rate);

        inst._isPooled = false;
        inst._effect = this;

        return inst;
	}
	
	/**
	 * Releases the resources used by the SoundEffect. 
	 */
	@Override
	public void Dispose()
	{
		Dispose(true);
	}

	/**
	 * 
	 * @param disposing
	 */
	protected synchronized void Dispose(boolean disposing)
	{
		if (!this.isDisposed)
		{				
			for (SoundEffectInstance sei : children)
			{
				sei.Dispose();
			}
			
			// TODO: implement cleanup
			
			isDisposed = true;
		}
	}
	
	@Override
	protected void finalize()
	{
		Dispose(false);
	}
	
	/**
	 * Creates a SoundEffect object based on the specified data stream.
	 * 
	 * @param stream
	 * Stream object that contains the data for this SoundEffect object.
	 * 
	 * @throws System.ArgumentNullException
	 * stream is null.
	 */
	public static SoundEffect FromStream(InputStream stream)
	{
		if (stream == null)
		{
			throw new ArgumentNullException("stream");
		}
	
		// TODO: maybe wrap the InputStream, or FileInputStream into a MemoryStream
		return new SoundEffect(stream);
	}
	
	/**
	 * Returns the sample duration based on the specified sample size and sample rate.
	 * 
	 * @param sizeInBytes
	 * Size, in bytes, of audio data.
	 * 
	 * @param sampleRate
	 * Sample rate, in Hertz (Hz), of audio content. The sampleRate must be between 8000 Hz and 48000 Hz.
	 * 
	 * @param channels
	 * Number of channels in the audio data.
	 */
	public static TimeSpan GetSampleDuration(int sizeInBytes, int sampleRate, AudioChannels channels)
	{
	    if (sizeInBytes < 0)
	    {
	    	// TODO: error message
	        throw new ArgumentException("", "sizeInBytes");
	    }
	    
	    if ((sampleRate < 8000) || (sampleRate > 48000))
	    {
	        throw new ArgumentOutOfRangeException("sampleRate");
	    }
	    
	    if (sizeInBytes == 0)
	    {
	        return TimeSpan.Zero;
	    }
	    
	    return TimeSpan.FromSeconds(sizeInBytes / (sampleRate * channels.getValue()));
	}
	
	/**
	 * Returns the size of the audio sample based on duration, sample rate, and audio channels.
	 * 
	 * @param duration
	 * TimeSpan object that contains the sample duration.
	 * 
	 * @param sampleRate
	 * Sample rate, in Hertz (Hz), of audio content. The sampleRate parameter must be between 8,000 Hz and 48,000 Hz.
	 * 
	 * @param channels
	 * Number of channels in the audio data.
	 */
	public static int GetSampleSizeInBytes(TimeSpan duration, int sampleRate, AudioChannels channels)
	{
	    int num = 0;
	    
	    if ((duration.getTotalMilliseconds() < 0.0) || (duration.getTotalMilliseconds() > 2147483647.0))
	    {
	        throw new ArgumentOutOfRangeException("duration");
	    }
	    
	    if ((sampleRate < 8000) || (sampleRate > 48000))
	    {
	        throw new ArgumentOutOfRangeException("sampleRate");
	    }
	    
	    if (duration == TimeSpan.Zero)
	    {
	        return 0;
	    }
	    
	    num = duration.getSeconds() * sampleRate * channels.getValue();

	    return num;
	}
	
	/**
	 * Plays a sound. Reference page contains links to related code samples.
	 * 
	 * @return
	 * True if successful, false otherwise.
	 */
	public boolean Play()
	{
		SoundEffectInstance inst = GetPooledInstance();
    	
        if (inst == null)
        {
            return false;
        }

        inst.Play();

        return true;
	}
	
	/**
	 * Plays a sound based on specified volume, pitch, and panning. Reference page contains links to related code samples.
	 * 
	 * @param volume
	 * Volume, ranging from 0.0f (silence) to 1.0f (full volume). 1.0f is full volume relative to SoundEffect.MasterVolume.
	 * 
	 * @param pitch
	 * Pitch adjustment, ranging from -1.0f (down one octave) to 1.0f (up one octave). 0.0f is unity (normal) pitch.
	 * 
	 * @param pan
	 * Panning, ranging from -1.0f (full left) to 1.0f (full right). 0.0f is centered.
	 * 
	 * @return
	 * True if successful, false otherwise.
	 */
    public boolean Play(float volume, float pitch, float pan)
    {
    	SoundEffectInstance inst = GetPooledInstance();
    	
        if (inst == null)
        {
            return false;
        }

        inst.setVolume(volume);
        inst.setPitch(pitch);
        inst.setPan(pan);

        inst.Play();

        return true;
    }
}
