package Microsoft.Xna.Framework.Audio;

import System.*;
import System.IO.*;

class AudioFormat
{
	public final int AvgBytesPerSec;
	public final short BitsPerSample;
	public final short BlockAlign;
	public final short Channels;
	public final short FormatTag;
	public final byte[] RawBuffer;
	public final int SampleRate;
	
	/**
	 * 
	 * @param buffer
	 */
	public AudioFormat(byte[] buffer)
	{
		BinaryReader reader = new BinaryReader(new MemoryStream(buffer));
		this.FormatTag = reader.ReadInt16();
		this.Channels = reader.ReadInt16();
		this.SampleRate = reader.ReadInt32();
		this.AvgBytesPerSec = reader.ReadInt32();
		this.BlockAlign = reader.ReadInt16();
		this.BitsPerSample = reader.ReadInt16();
		reader.Close();
		this.RawBuffer = buffer;
	}
	
	/**
	 * 
	 * @param SampleRate
	 * @param channels
	 * @param BitDepth
	 * @return
	 */
	public static AudioFormat Create(int SampleRate, AudioChannels channels, short BitDepth)
	{
		// TODO: implement
		
		return null;
	}
	
	public TimeSpan DurationFromSize(int sizeInBytes)
	{
		int num = sizeInBytes / this.BlockAlign;
		return TimeSpan.FromMilliseconds((double)((num * 1000f) / ((float)this.SampleRate)));
	}
	
	public boolean IsAligned(int value)
	{
		return ((value % this.BlockAlign) == 0);
	}
	
	public int SizeFromDuration(TimeSpan duration)
	{
		int num = (int)(duration.getTotalMilliseconds() * (((float)this.SampleRate) / 1000f));
		return ((num + (num % this.Channels)) * this.BlockAlign);
	}
}
