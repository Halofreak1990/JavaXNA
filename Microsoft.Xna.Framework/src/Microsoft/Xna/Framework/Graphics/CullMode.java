package Microsoft.Xna.Framework.Graphics;

/**
 * Defines winding orders that may be used to identify back faces for culling.
 * 
 * @author Halofreak1990
 */
public enum CullMode
{
	/**
	 * Do not cull back faces.
	 */
	None (0),
	/**
	 * Cull back faces with clockwise vertices.
	 */
	CullClockwiseFace (1),
	/**
	 * Cull back faces with counterclockwise vertices.
	 */
	CullCounterClockwiseFace (2);
	
	private final int value;
	private CullMode(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}
