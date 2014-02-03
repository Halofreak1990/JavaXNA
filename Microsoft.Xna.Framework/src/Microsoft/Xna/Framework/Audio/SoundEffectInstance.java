package Microsoft.Xna.Framework.Audio;

import System.*;

/**
 * Provides a single playing, paused, or stopped instance of a SoundEffect sound.
 * 
 * @author Halofreak1990
 */
public class SoundEffectInstance implements IDisposable
{
	private float currentPan;
	private float currentPitch;
	private float currentVolume;
	private boolean isDisposed;
	private boolean isFireAndForget;
	private SoundEffect parent;
	Object VoiceHandleLock;

	/**
	 * Gets a value that indicates whether looping is enabled for the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public boolean IsLooped;

	/**
	 * Gets a value that indicates whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		return isDisposed;
	}

	boolean IsFireAndForget()
	{
		return this.isFireAndForget;
	}

	/**
	 * Gets the panning for the SoundEffectInstance.
	 */
	public float getPan()
	{
		return this.currentPan;
	}

	/**
	 * Sets the panning for the SoundEffectInstance.
	 */
	public void setPan(float value)
	{
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			if (value < -1f || value > 1f)
			{
				throw new ArgumentOutOfRangeException("value");
			}

			//Helpers.ThrowExceptionFromErrorCode(SoundEffectUnsafeNativeMethods.SetPan(this.voiceHandle, value));
			this.currentPan = value;
		}
	}

	/**
	 * Gets the pitch adjustment for the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public float getPitch()
	{
		return this.currentPitch;
	}

	/**
	 * Sets the pitch adjustment for the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public void setPitch(float value)
	{
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			if (value < -1f || value > 1f)
			{
				throw new ArgumentOutOfRangeException("value");
			}

			//Helpers.ThrowExceptionFromErrorCode(SoundEffectUnsafeNativeMethods.SetPitch(this.voiceHandle, value));
			this.currentPitch = value;
		}
	}

	SoundEffect getSoundEffect()
	{
		return this.parent;
	}

	/**
	 * Gets the current state (playing, paused, or stopped) of the SoundEffectInstance.
	 */
	public SoundState getState()
	{
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			// TODO: implement
			throw new NotImplementedException();
		}
	}

	/**
	 * Gets the volume of the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public float getVolume()
	{
		return this.currentVolume;
	}

	/**
	 * Sets the volume of the SoundEffectInstance. Reference page contains links to related code samples.
	 */
	public void setVolume(float value)
	{
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			if (value < -1f || value > 1f)
			{
				throw new ArgumentOutOfRangeException("value");
			}

			//Helpers.ThrowExceptionFromErrorCode(SoundEffectUnsafeNativeMethods.SetVolume(this.voiceHandle, value));
			this.currentVolume = value;
		}
	}

	SoundEffectInstance()
	{
		this.currentVolume = 1f;
		// TODO: implement
		this.VoiceHandleLock = new Object();
	}

	SoundEffectInstance(SoundEffect parentEffect, boolean fireAndForget)
	{
		this.currentVolume = 1f;
		this.VoiceHandleLock = new Object();
		if (parentEffect.IsDisposed())
		{
			throw new ObjectDisposedException(SoundEffect.class.getName(), "This object has already been disposed.");
		}

		this.parent = parentEffect;
		this.setVolume(1f);
		this.setPitch(0f);
		this.setPan(0f);
		this.IsLooped = false;
		this.isFireAndForget = fireAndForget;
	}

	/**
	 * Applies 3D positioning to the sound using a single listener. Reference page contains links to related code samples.
	 * 
	 * @param listener
	 * Position of the listener.
	 * 
	 * @param emitter
	 * Position of the emitter.
	 */
	public void Apply3D(AudioListener listener, AudioEmitter emitter)
	{
		this.Apply3D(new AudioListener[] { listener }, emitter);
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
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			// TODO: implement
			throw new NotImplementedException();
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
	protected void Dispose(boolean disposing)
	{
		synchronized(this)
		{
			if (!this.isDisposed)
			{
				this.isDisposed = true;
				if (this.parent != null)
				{
					this.parent.ChildDestroyed(this);
				}
			}
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
	public void Pause()
	{
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			// TODO: implement
			throw new NotImplementedException();
		}
	}

	/**
	 * Plays or resumes a SoundEffectInstance.
	 */
	public void Play()
	{
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			// TODO: implement
			throw new NotImplementedException();
		}
	}

	/**
	 * Resumes playback for a SoundEffectInstance.
	 */
	public void Resume()
	{
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			// TODO: implement
			throw new NotImplementedException();
		}
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
	public void Stop(boolean immediate)
	{
		synchronized(this)
		{
			if (this.isDisposed)
			{
				throw new ObjectDisposedException(super.getClass().toString(), "FrameworkResources.ObjectDisposedException");
			}

			// TODO: implement
			throw new NotImplementedException();
		}
	}
}
