package Microsoft.Xna.Framework.Audio;

import java.nio.IntBuffer;
import java.util.*;

import org.lwjgl.openal.*;

import System.*;

final class OpenALSoundController implements IDisposable
{
	private ALCcontext _context;
	private ALCdevice _device;
	private static OpenALSoundController _instance = null;
	private boolean _isDisposed = false;
	private int _lastOpenALError;
	private boolean _soundAvailable = false;
	private Throwable _soundInitException;
	private List<Integer> availableSourcesCollection; 
	private List<OALSoundBuffer> inUseSourcesCollection; 
	private List<OALSoundBuffer> playingSourcesCollection; 
	private List<OALSoundBuffer> purgeMe; 

	private IntBuffer allSourcesArray;
	private final int MAX_NUMBER_OF_SOURCES = 32;
	
	private OpenALSoundController() 
	{ 
		if (!OpenSoundController()) 
		{ 
			return; 
		}
		
		// We have hardware here and it is ready 
		_soundAvailable = true; 
	 
		allSourcesArray = IntBuffer.allocate(MAX_NUMBER_OF_SOURCES); 
		AL10.alGenSources(allSourcesArray); 
	 
		availableSourcesCollection = new ArrayList<Integer>();
		
		for (int i = 0; i < MAX_NUMBER_OF_SOURCES; i++)
		{
			availableSourcesCollection.add(allSourcesArray.get(i));
		}
		
		inUseSourcesCollection = new ArrayList<OALSoundBuffer>(); 
		playingSourcesCollection = new ArrayList<OALSoundBuffer>(); 
		purgeMe = new ArrayList<OALSoundBuffer>(); 
	}
	
	/**
	 * Checks if the AL controller was initialized properly. If there was an
     * exception thrown during the OpenAL init, then that exception is thrown
     * inside of NoAudioHardwareException.
     * 
	 * @return
	 * True if the controller was initialized, false if not.
	 */
	private boolean CheckInitState()
    {
        if (!_soundAvailable)
        {
            if (_soundInitException != null)
            {
                Throwable e = _soundInitException;
                _soundInitException = null;
                
                throw new NoAudioHardwareException("No audio hardware available.", e);
            }
            
            return (false);
        }
        
        return (true);
    }
	
	/**
	 * Destroys the AL context and closes the device, when they exist.
	 */
	private void CleanUpOpenAL() 
	{ 
		ALC10.alcMakeContextCurrent(null);
		
		if (_context != null)
		{ 
			ALC10.alcDestroyContext(_context); 
			_context = null; 
		}
	
		if (_device != null)
		{ 
			ALC10.alcCloseDevice(_device); 
			_device = null; 
		}
	
		_soundAvailable = false; 
	} 
	
	private boolean OpenSoundController()
	{
		_device = ALC10.alcOpenDevice("");
		
		if (CheckALError("Could not open AL device")) 
		{ 
			return(false); 
		} 
		
		if (_device != null)
		{
			IntBuffer attribute = IntBuffer.allocate(0);
			
			_context = ALC10.alcCreateContext(_device, attribute);
			
			if (CheckALError("Could not create AL context")) 
			{ 
				CleanUpOpenAL(); 
				return(false); 
			} 
				 
			if (_context != null) 
			{ 
				ALC10.alcMakeContextCurrent(_context); 

				if (CheckALError("Could not make AL context current")) 
				{ 
					CleanUpOpenAL(); 
					return(false); 
				}
				
				return (true); 
			} 
		}
		
		return false;
	}
	
	/**
	 * Checks the error state of the OpenAL driver. If a value that is not {@link ALC10.ALC_NO_ERROR} 
	 * is returned, then the operation message and the error code is output to the console.
	 * 
	 * @param operation
	 * the operation message
	 * 
	 * @return
	 * true if an error occurs, and false if not.
	 */
	public boolean CheckALError(String operation) 
	{ 
		_lastOpenALError = ALC10.alcGetError(_device); 
	
		if (_lastOpenALError == ALC10.ALC_NO_ERROR)
		{ 
			return(false); 
		} 
	 
		String errorFmt = "OpenAL Error: %s"; 
		System.out.println(String.format("%s - %s", 
				operation, 
				//String.format(errorFmt, ALC10.alGetString(_device, _lastOpenALError)))); 
				String.format(errorFmt, _lastOpenALError))); 
		return (true); 
	} 
	
	public static void DestroyInstance() 
	{ 
		if (_instance != null) 
		{ 
			_instance.Dispose(); 
			_instance = null; 
		} 
	} 
	
	/**
	 * Dispose of the OpenALSoundCOntroller.
	 */
	@Override
	public void Dispose()
	{
		if (!_isDisposed)
		{
			if (_soundAvailable)
			{
                CleanUpOpenAL();
			}
			
			_isDisposed = true;
		}
	}
	
	public static OpenALSoundController GetInstance()
	{
		if (_instance == null)
		{
				_instance = new OpenALSoundController();
		}
		
		return _instance;
	}
	
	public boolean IsState(OALSoundBuffer soundBuffer, int state)
	{
        if (!CheckInitState())
        {
            return (false);
        }
        
        int sourceState = AL10.alGetSourcei(soundBuffer.getSourceId(), AL10.AL_SOURCE_STATE);

		if (state == sourceState)
		{
			return true;
		}

		return false;
	}
	
	public void PauseSound(OALSoundBuffer soundBuffer)
	{
        if (!CheckInitState())
        {
            return;
        }
        
        soundBuffer.Pause();
	}
	
	public void PlaySound(OALSoundBuffer soundBuffer)
    {
        if (!CheckInitState())
        {
            return;
        }
        
        synchronized (playingSourcesCollection)
        {
            playingSourcesCollection.add(soundBuffer);
        }
        
		AL10.alSourcePlay(soundBuffer.getSourceId());
	}
	
	public void RecycleSource(OALSoundBuffer soundBuffer)
	{
        if (!CheckInitState())
        {
            return;
        }
        
        inUseSourcesCollection.remove(soundBuffer);
		availableSourcesCollection.add(soundBuffer.getSourceId());
		soundBuffer.RecycleSoundBuffer();
	}
	
	/**
	 * Reserves the given sound buffer. If there are no available sources then false is
     * returned, otherwise true will be returned and the sound buffer can be played. If
     * the controller was not able to setup the hardware, then false will be returned.
     * 
	 * @param soundBuffer
	 * The sound buffer you want to play
	 * 
	 * @return
	 * True if the buffer can be played, and false if not.
	 */
	public boolean ReserveSource(OALSoundBuffer soundBuffer)
	{
        if (!CheckInitState())
        {
            return(false);
        }
        
        int sourceNumber;
        
		if (availableSourcesCollection.size() == 0)
		{
			soundBuffer.setSourceId(0);
			return false;
		}		

		sourceNumber = availableSourcesCollection.get(0);
		soundBuffer.setSourceId(sourceNumber);
		inUseSourcesCollection.add(soundBuffer);

		availableSourcesCollection.remove(sourceNumber);

		//sourceId = sourceNumber;
		return true;
	}
	
	public void ResumeSound(OALSoundBuffer soundBuffer)
    {
        if (!CheckInitState())
        {
            return;
        }
        
        soundBuffer.Resume();
    }
	
	public double SourceCurrentPosition(int sourceId)
	{
        if (!CheckInitState())
        {
            return(0.0);
        }
        
		return AL10.alGetSourcei(sourceId, AL11.AL_SAMPLE_OFFSET);
	}
	
	public void StopSound(OALSoundBuffer soundBuffer)
    {
        if (!CheckInitState())
        {
            return;
        }
        
        AL10.alSourceStop(soundBuffer.getSourceId());

        AL10.alSourcei(soundBuffer.getSourceId(), AL10.AL_BUFFER, 0);
        
        synchronized (playingSourcesCollection)
        {
            playingSourcesCollection.remove(soundBuffer);
        }
        
        RecycleSource(soundBuffer);
	}
	
	/**
	 * Called repeatedly, this method cleans up the state of the management lists. This method
     * will also lock on the playingSourcesCollection. Sources that are stopped will be recycled
     * using the RecycleSource method.
	 */
	public void Update()
    {
        if (!_soundAvailable)
        {
            //OK to ignore this here because the game can run without sound.
             return;
        }

        int state;
        synchronized (playingSourcesCollection)
        {
            for (int i = playingSourcesCollection.size() - 1; i >= 0; --i)
            {
                OALSoundBuffer soundBuffer = playingSourcesCollection.get(i);
                
                state = AL10.alGetSourcei(AL10.AL_SOURCE_STATE, soundBuffer.getSourceId());
                
                if (state == AL10.AL_STOPPED)
                {
                    purgeMe.add(soundBuffer);
                    playingSourcesCollection.remove(i);
                }
            }
        }
        
        for (OALSoundBuffer soundBuffer : purgeMe)
        {
            AL10.alSourcei(soundBuffer.getSourceId(), AL10.AL_BUFFER, 0);
            RecycleSource(soundBuffer);
        }
        
        purgeMe.clear();
    }
}
