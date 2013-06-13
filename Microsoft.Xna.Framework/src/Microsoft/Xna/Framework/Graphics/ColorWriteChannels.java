package Microsoft.Xna.Framework.Graphics;

/**
 * Defines the color channels that can be chosen for a per-channel write to a render target color buffer.
 *
 * @author Halofreak1990
 */
public enum ColorWriteChannels
{
	/**
	 * All buffer channels.
	 */
	All (15),
	/**
	 * Alpha channel of a buffer.
	 */
	Alpha (8),
	/**
	 * Blue channel of a buffer.
	 */
	Blue (4),
	/**
	 * Green channel of a buffer.
	 */
	Green (2),
	/**
	 * No channel selected.
	 */
	None (0),
	/**
	 * Red channel of a buffer.
	 */
	Red (1);
	
	private final int value;
	private ColorWriteChannels(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
