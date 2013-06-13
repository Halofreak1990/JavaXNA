package Microsoft.Xna.Framework.Audio;

/**
 * Defines the number of channels in the audio data.
 * 
 * @author Halofreak1990
 */
public enum AudioChannels
{
	/**
	 * Indicates audio data is contained in one channel.
	 */
	Mono(1),
	/**
	 * Indicates audio data contains two channels.
	 */
    Stereo(2);
    
    private final int value;
    private AudioChannels(int value)
	{
		this.value = value;
	}
    
    public int getValue()
    {
    	return this.value;
    }
}
