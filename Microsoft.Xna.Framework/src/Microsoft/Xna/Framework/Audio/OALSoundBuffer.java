package Microsoft.Xna.Framework.Audio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.openal.*;

import System.*;

/**
 * 
 * @author The MonoGame Team
 * @author Halofreak1990
 */
class OALSoundBuffer implements IDisposable
{
	private IntBuffer openALDataBuffer; 
	private int openALFormat; 
	private int dataSize; 
	private int sampleRate; 
	private int _sourceId; 
	private boolean _isDisposed; 
	int _pauseCount;
	
	public double Duration;
	
	public int getOpenALDataBuffer()
	{
		return openALDataBuffer.get(0);
	}
	
	public int getSourceId()
	{
		return _sourceId;
	}
	
	public void setSourceId(int value)
	{
		_sourceId = value;
		
		if (Reserved.hasHandlers())
		{
			Reserved.raise(this, EventArgs.Empty);
		}
	}
	
	public final Event<EventArgs> Reserved = new Event<EventArgs>();
	public final Event<EventArgs> Recycled = new Event<EventArgs>();
	
	public OALSoundBuffer() 
	{ 
		//try 
		//{ 
			openALDataBuffer = IntBuffer.allocate(1);
			
			int alError = AL10.alGetError(); 
			AL10.alGenBuffers(openALDataBuffer); 
			alError = AL10.alGetError(); 

			if (alError != AL10.AL_NO_ERROR) 
			{
				System.out.println("Failed to generate OpenAL data buffer: " + AL10.alGetString(alError)); 
			} 
		/*} 
		catch (DllNotFoundException e) 
		{ 
			throw new NoAudioHardwareException("OpenAL drivers could not be found.", e); 
		}*/
	}
	
	public void BindDataBuffer(byte[] dataBuffer, int format, int size, int sampleRate)
    {
        openALFormat = format;
        dataSize = size;
        this.sampleRate = sampleRate;
        ByteBuffer buf = ByteBuffer.wrap(dataBuffer);
        AL10.alBufferData(openALDataBuffer.get(0), openALFormat, buf, this.sampleRate);

        int bits, channels;

        bits = AL10.alGetBufferi(openALDataBuffer.get(0), AL10.AL_BITS);
        int alError = AL10.alGetError();
        
        if (alError != AL10.AL_NO_ERROR)
        {
            System.out.printf("Failed to get buffer bits: %s, format=%d, size=%d, sampleRate=%d", AL10.alGetString(alError), format, size, sampleRate);
            System.out.println();
            Duration = -1;
        }
        else
        {
            channels = AL10.alGetBufferi(openALDataBuffer.get(0), AL10.AL_CHANNELS);

            alError = AL10.alGetError();
            if (alError != AL10.AL_NO_ERROR)
            {
                System.out.printf("Failed to get buffer bits: %s, format=%d, size=%d, sampleRate=%d", AL10.alGetString(alError), format, size, sampleRate);
                System.out.println();
                Duration = -1;
            }
            else
            {
                Duration = (float)(size / ((bits / 8) * channels)) / (float)sampleRate;
            }
        }
        
        //Console.WriteLine("Duration: " + Duration + " / size: " + size + " bits: " + bits + " channels: " + channels + " rate: " + sampleRate);
    }
	 
	protected void finalize() 
	{ 
		Dispose(false); 
	}
	
	protected void Dispose(boolean disposing)
	{
		if (!_isDisposed)
		{
			AL10.alDeleteBuffers(openALDataBuffer);
			
			_isDisposed = true;
		}
	}
	
	@Override
	public void Dispose()
	{
		Dispose(true);
	}
	
	public void Pause()
    {
        if (_pauseCount == 0)
        {
            AL10.alSourcePause(_sourceId);
        }
        
        ++_pauseCount;
    }

	public void RecycleSoundBuffer()
	{
		if (Recycled.hasHandlers())
		{
			Recycled.raise(this, EventArgs.Empty);
		}
	}
	
	public void Resume()
    {
        --_pauseCount;
        
        if (_pauseCount == 0)
        {
            AL10.alSourcePlay(_sourceId);
        }
    }
}
