package Microsoft.Xna.Framework.Audio;

import java.nio.FloatBuffer;

import org.lwjgl.openal.*;

import resources.Resources;

import Microsoft.Xna.Framework.*;

import System.*;

/**
 * Provides a single playing, paused, or stopped instance of a SoundEffect sound.
 * 
 * @author Halofreak1990
 */
public class SoundEffectInstance implements IDisposable
{
	private boolean _isDisposed = false;
    boolean _isPooled = true;
    SoundEffect _effect;
    private float _pan;
    private float _volume;
    private float _pitch;
	private SoundState soundState = SoundState.Stopped;
	private boolean _looped = false;
	private float _alVolume = 1;

	int sourceId;

    private OALSoundBuffer soundBuffer;
    private OpenALSoundController controller;
    
    boolean hasSourceId = false;
    
    private final SoundBufferRecycled HandleSoundBufferRecycled = new SoundBufferRecycled();
    private final SoundBufferReserved HandleSoundBufferReserved = new SoundBufferReserved();

	/**
	 * Gets a value that indicates whether looping is enabled for the SoundEffectInstance.
	 */
	public boolean IsLooped()
	{
		return _looped;
	}
	
	public synchronized void IsLooped(boolean value)
	{
		if (hasSourceId)
		{
            AL10.alSourcei(sourceId, AL10.AL_LOOPING, value ? 1 : 0);
		}
		
		_looped = value;
	}

	/**
	 * Gets a value that indicates whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		return _isDisposed;
	}

	/**
	 * Gets the panning for the SoundEffectInstance.
	 */
	public float getPan()
	{
		return this._pan;
	}

	/**
	 * Sets the panning for the SoundEffectInstance.
	 */
	public synchronized void setPan(float value)
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
		}

		if (value < -1f || value > 1f)
		{
			throw new ArgumentOutOfRangeException("value");
		}

		if (hasSourceId) 
		{
			AL10.alSource3f(sourceId, AL10.AL_POSITION, value, 0.0f, 0.1f);
		}

		this._pan = value;
	}

	/**
	 * Gets the pitch adjustment for the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public float getPitch()
	{
		return this._pitch;
	}

	/**
	 * Sets the pitch adjustment for the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public synchronized void setPitch(float value)
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
		}

		if (value < -1f || value > 1f)
		{
			throw new ArgumentOutOfRangeException("value");
		}

		if (hasSourceId)
		{
            AL10.alSourcef(sourceId, AL10.AL_PITCH, XnaPitchToAlPitch(value));
		}

		this._pitch = value;
	}

	SoundEffect getSoundEffect()
	{
		return this._effect;
	}

	/**
	 * Gets the current state (playing, paused, or stopped) of the SoundEffectInstance.
	 */
	public synchronized SoundState getState()
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
		}

		if (!hasSourceId)
		{
            return SoundState.Stopped;
		}
        
        int alState = AL10.alGetSourcei(sourceId, AL10.AL_SOURCE_STATE);

        switch (alState)
        {
        case AL10.AL_INITIAL:
        case AL10.AL_STOPPED:
            soundState = SoundState.Stopped;
            break;

        case AL10.AL_PAUSED:
            soundState = SoundState.Paused;
            break;

        case AL10.AL_PLAYING:
            soundState = SoundState.Playing;
            break;
        }

        return soundState;
	}

	/**
	 * Gets the volume of the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public float getVolume()
	{
		return this._volume;
	}

	/**
	 * Sets the volume of the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public synchronized void setVolume(float value)
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
		}

		if (value < -1f || value > 1f)
		{
			throw new ArgumentOutOfRangeException("value");
		}

		if (hasSourceId)
		{
			AL10.alSourcef(sourceId, AL10.AL_GAIN, value * SoundEffect.getMasterVolume());
		}

		this._volume = value;
		this._alVolume = value * SoundEffect.getMasterVolume();
	}

	SoundEffectInstance()
	{
		_pan = 0.0f;
        _volume = 1.0f;
        _pitch = 0.0f;     
	}

	SoundEffectInstance(byte[] buffer, int sampleRate, int channels)
	{
		this();
		
		InitializeSound();
        BindDataBuffer(
            buffer,
            (channels == 2) ? AL10.AL_FORMAT_STEREO16 : AL10.AL_FORMAT_MONO16,
            buffer.length,
            sampleRate
		    );
	}
	
	/**
	 * Preserves the given data buffer by reference and binds its contents to the OALSoundBuffer
     * that is created in the InitializeSound method.
     * 
	 * @param data
	 * The sound data buffer
	 * 
	 * @param format
	 * The sound buffer data format, e.g. Mono, Mono16 bit, Stereo, etc.
	 * 
	 * @param size
	 * The size of the data buffer.
	 * 
	 * @param rate
	 * The sampling rate of the sound effect, e.g. 44 khz, 22 khz.
	 */
	void BindDataBuffer(byte[] data, int format, int size, int rate)
    {
        soundBuffer.BindDataBuffer(data, format, size, rate);
    }
	
	/**
	 * Gets the OpenAL sound controller, constructs the sound buffer, and sets up the event delegates for
     * the reserved and recycled events.
	 */
	void InitializeSound()
    {
        controller = OpenALSoundController.GetInstance();
        soundBuffer = new OALSoundBuffer();
        soundBuffer.Reserved.addHandler(HandleSoundBufferReserved);
        soundBuffer.Recycled.addHandler(HandleSoundBufferRecycled);
    }
	
	private static float XnaPitchToAlPitch(float xnaPitch)
    {
        /*XNA sets pitch bounds to [-1.0f, 1.0f], each end being one octave.
        •OpenAL's AL_PITCH boundaries are (0.0f, INF). *
        •Consider the function f(x) = 2 ^ x
        •The domain is (-INF, INF) and the range is (0, INF). *
        •0.0f is the original pitch for XNA, 1.0f is the original pitch for OpenAL.
        •Note that f(0) = 1, f(1) = 2, f(-1) = 0.5, and so on.
        •XNA's pitch values are on the domain, OpenAL's are on the range.
        •Remember: the XNA limit is arbitrarily between two octaves on the domain. *
        •To convert, we just plug XNA pitch into f(x).*/

        if (xnaPitch < -1.0f || xnaPitch > 1.0f)
        {
            throw new ArgumentOutOfRangeException("XNA PITCH MUST BE WITHIN [-1.0f, 1.0f]!");
        }

        return (float)Math.pow(2, xnaPitch);
    }

	/**
	 * Applies 3D positioning to the sound using a single listener.
	 * 
	 * @param listener
	 * Position of the listener.
	 * 
	 * @param emitter
	 * Position of the emitter.
	 */
	public synchronized void Apply3D(AudioListener listener, AudioEmitter emitter)
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), Resources.GetString("Resources.ObjectDisposedException"));
		}
		
		// get AL's listener position
		FloatBuffer fb = FloatBuffer.allocate(3);
		AL10.alGetListener(AL10.AL_POSITION, fb);
		
		// get the emitter offset from origin 
		Vector3 posOffset = Vector3.Subtract(emitter.getPosition(), listener.getPosition()); 

		// set up orientation matrix 
		Matrix orientation = Matrix.CreateWorld(Vector3.Zero, listener.getForward(), listener.getUp());
		
		// set up our final position and velocity according to orientation of listener 
		Vector3 finalPos = new Vector3(fb.get(0) + posOffset.X, fb.get(1) + posOffset.Y, fb.get(2) + posOffset.Z); 
		finalPos = Vector3.Transform(finalPos, orientation); 
		Vector3 finalVel = emitter.getVelocity(); 
		finalVel = Vector3.Transform(finalVel, orientation);

		// set the position based on relative position 
		AL10.alSource3f(sourceId, AL10.AL_POSITION, finalPos.X, finalPos.Y, finalPos.Z); 
		AL10.alSource3f(sourceId, AL10.AL_VELOCITY, finalVel.X, finalVel.Y, finalVel.Z);
	}

	/**
	 * Applies 3D position to the sound using multiple listeners. Reference page contains links to related code samples.
	 *  
	 * @param listeners
	 * Positions of each listener.
	 * 
	 * @param emitter
	 * Position of the emitter.
	 */
	public void Apply3D(AudioListener[] listeners, AudioEmitter emitter)
	{
		for (AudioListener listener : listeners)
		{
			Apply3D(listener, emitter);
		}
	}

	/**
	 * Releases unmanaged resources held by this SoundEffectInstance.
	 */
	public void Dispose()
	{
		this.Dispose(true);
	}

	/**
	 * Releases the unmanaged resources held by this SoundEffectInstance, and optionally releases the managed resources.
	 * 
	 * @param disposing
	 * Pass true to release both the managed and unmanaged resources for this SoundEffectInstance. Passing false releases only the unmanaged resources.
	 */
	protected synchronized void Dispose(boolean disposing)
	{
		if (!this._isDisposed)
		{				
			if (this._effect != null)
			{
				this._effect.ChildDestroyed(this);
			}
			
			this._isDisposed = true;
		}
	}

	/**
	 * Releases unmanaged resources and performs other cleanup operations before the SoundEffectInstance is reclaimed by garbage collection.
	 */
	protected void finalize()
	{
		this.Dispose(false);
	}

	/**
	 * Pauses a SoundEffectInstance.
	 */
	public synchronized void Pause()
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
		}

		if (!hasSourceId || soundState != SoundState.Playing)
		{
            return;
		}

        controller.PauseSound(soundBuffer);
        soundState = SoundState.Paused;
	}

	/**
	 * Plays or resumes a SoundEffectInstance.
	 */
	public synchronized void Play()
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
		}

		if (getState() == SoundState.Playing)
		{
            return;
		}

        // We don't need to check if we're at the instance play limit
        // if we're resuming from a paused state.
        if (getState() != SoundState.Paused)
        {
            SoundEffectInstancePool.Remove(this);

            if (!SoundEffectInstancePool.SoundsAvailable())
            {
                throw new InstancePlayLimitException();
            }
        }
        
        // We need to be sure the latest master volume level is applied before playback.
        if (hasSourceId)
        {
            AL10.alSourcef(sourceId, AL10.AL_GAIN, _volume * SoundEffect.getMasterVolume());
        }

        if (hasSourceId)
        {
            return;
        }
        
        boolean isSourceAvailable = controller.ReserveSource(soundBuffer);
        
        if (!isSourceAvailable)
        {
            throw new InstancePlayLimitException();
        }

        int bufferId = soundBuffer.getOpenALDataBuffer();
        AL10.alSourcei(soundBuffer.getSourceId(), AL10.AL_BUFFER, bufferId);

        // Send the position, gain, looping, pitch, and distance model to the OpenAL driver.
        if (!hasSourceId)
        {
			return;
        }

		// Distance Model
		//AL10.alDistanceModel(ALDistanceModel.InverseDistanceClamped);
        AL10.alDistanceModel(AL11.AL_LINEAR_DISTANCE_CLAMPED); // TODO: verify
		// Pan
		AL10.alSource3f(sourceId, AL10.AL_POSITION, _pan, 0, 0.1f);
		// Volume
		AL10.alSourcef(sourceId, AL10.AL_GAIN, _alVolume);
		// Looping
		AL10.alSourcei(sourceId, AL10.AL_LOOPING, _looped ? 1 : 0);
		// Pitch
		AL10.alSourcef(sourceId, AL10.AL_PITCH, XnaPitchToAlPitch(_pitch));

        controller.PlaySound(soundBuffer);
        //Console.WriteLine ("playing: " + sourceId + " : " + soundEffect.Name);
        soundState = SoundState.Playing;
	}

	/**
	 * Resumes playback for a SoundEffectInstance.
	 */
	public synchronized void Resume()
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
		}

		if (!hasSourceId)
        {
            Play();
            return;
        }
        
        if (soundState == SoundState.Paused)
        {
            controller.ResumeSound(soundBuffer);
        }
        
        soundState = SoundState.Playing;
	}

	/**
	 * Immediately stops playing a SoundEffectInstance.
	 */
	public void Stop()
	{
		this.Stop(true);
	}

	/**
	 * Stops playing a SoundEffectInstance, either immediately or as authored.
	 * 
	 * @param immediate
	 * Whether to stop playing immediately, or to break out of the loop region and play the release. Specify true to stop playing immediately, or false to break out of the loop region and play the release phase (the remainder of the sound).
	 */
	public synchronized void Stop(boolean immediate)
	{
		if (this._isDisposed)
		{
			throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
		}

		if (hasSourceId)
        {
            //Console.WriteLine ("stop " + sourceId + " : " + soundEffect.Name);
            controller.StopSound(soundBuffer);
        }
		
        soundState = SoundState.Stopped;
	}
	
	private class SoundBufferRecycled implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
	        sourceId = 0;
	        hasSourceId = false;
	        soundState = SoundState.Stopped;
	        //Console.WriteLine ("recycled: " + soundEffect.Name);
		}
	}
	
	private class SoundBufferReserved implements EventHandler<EventArgs>
	{
		public void Invoke(Object sender, EventArgs e)
		{
			sourceId = soundBuffer.getSourceId();
            hasSourceId = true;
		}
	}
}
