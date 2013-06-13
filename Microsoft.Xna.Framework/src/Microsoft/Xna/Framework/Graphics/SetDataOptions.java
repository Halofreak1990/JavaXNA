package Microsoft.Xna.Framework.Graphics;

/**
 * Describes whether existing vertex or index buffer data will be overwritten or discarded during a SetData operation.
 * 
 * @author Halofreak1990
 */
public enum SetDataOptions
{
	/**
	 * The SetData operation will discard the entire buffer. A pointer to a new memory area is returned so that the direct memory access (DMA) and rendering from the previous area do not stall.
	 */
	Discard (1),
	/**
	 * Portions of existing data in the buffer may be overwritten during this operation.
	 */
	None (0),
	/**
	 * The SetData operation will not overwrite existing data in the vertex and index buffers. Specifying this option allows the driver to return immediately from a SetData operation and continue rendering.
	 */
	NoOverwrite (2);
	
	private final int value;
	private SetDataOptions(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
