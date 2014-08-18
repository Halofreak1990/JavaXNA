package Microsoft.Xna.Framework.Audio;

import java.io.*;
import java.util.Locale;

import org.lwjgl.openal.*;

import System.*;

/**
 * 
 * @author The MonoGame Team
 */
class AudioLoader
{
	private AudioLoader()
	{
	}
	
	private static int GetSoundFormat(int channels, int bits)
	{
		switch (channels) 
		{ 
		case 1:
			return bits == 8 ? AL10.AL_FORMAT_MONO8 : AL10.AL_FORMAT_MONO16; 
		case 2:
			return bits == 8 ? AL10.AL_FORMAT_STEREO8 : AL10.AL_FORMAT_STEREO16; 
		default: throw new NotSupportedException("The specified sound format is not supported."); 
		} 
	}
	
	public static byte[] Load(InputStream data, Integer format, Integer size, Integer frequency)
    {
        byte[] audioData = null;
        format = AL10.AL_FORMAT_MONO8;
        size = 0;
        frequency = 0;

        DataInputStream reader = null;
        
        try
        {
        	reader = new DataInputStream(data);
        	
        	// decide which data type is this

            // for now we'll only support wave files
            audioData = LoadWave(reader, format, size, frequency);
        }
        finally
        {
        	if (reader != null)
        	{
        		try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }

        return audioData;
    }

    private static byte[] LoadWave(DataInputStream reader, Integer format, Integer size, Integer frequency)
    {
        // code based on opentk exemple

        byte[] audioData = null;

        try {
	        //header
	        String signature = new String(ReadChars(reader, 4));
	        
	        if (signature != "RIFF")
	        {
	            throw new NotSupportedException("Specified stream is not a wave file.");
	        }
	
			reader.readInt(); // riff_chunck_size
	
	        String wformat = new String(ReadChars(reader,4));
	        
	        if (wformat != "WAVE")
	        {
	            throw new NotSupportedException("Specified stream is not a wave file.");
	        }
	
	        // WAVE header
	        String format_signature = new String(ReadChars(reader, 4));
	        
	        while (format_signature != "fmt ")
	        {
	            reader.skipBytes(reader.readInt());
	            format_signature = new String(ReadChars(reader, 4));
	        }
	
	        int format_chunk_size = reader.readInt();
	
	        // total bytes read: tbp
	        int audio_format = reader.readShort(); // 2
	        int num_channels = reader.readShort(); // 4
	        int sample_rate = reader.readInt();    // 8
			reader.readInt();    // 12, byte_rate
			reader.readShort();  // 14, block_align
	        int bits_per_sample = reader.readShort(); // 16
	
	        if (audio_format != 1)
	        {
	            throw new NotSupportedException("Wave compression is not supported.");
	        }
	
	        // reads residual bytes
	        if (format_chunk_size > 16)
	        {
	            reader.skipBytes(format_chunk_size - 16);
	        }
	        
	        String data_signature = new String(ReadChars(reader, 4));
	
	        while (data_signature.toLowerCase(Locale.ENGLISH) != "data")
	        {
	            reader.skipBytes(reader.readInt());
	            data_signature = new String(ReadChars(reader, 4));
	        }
	
	        if (data_signature != "data")
	        {
	            throw new NotSupportedException("Specified wave file is not supported.");
	        }
	
	        int data_chunk_size = reader.readInt();
	
	        frequency = sample_rate;
	        format = GetSoundFormat(num_channels, bits_per_sample);
	        // TODO: allocate audioData
	        //audioData = reader.readBytes((int)reader.BaseStream.Length);
	        reader.readFully(audioData);
	        size = data_chunk_size;
        }
        catch (IOException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return audioData;
    }
    
    private static char[] ReadChars(DataInputStream stream, int count)
    {
    	char[] chars = new char[count];
    	
    	try
    	{
	    	for (int i = 0; i < count; i++)
	    	{
	    		chars[i] = (char)stream.readByte();
	    	}
    	}
    	catch (IOException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return chars;
    }
}
