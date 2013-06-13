package Microsoft.Xna.Framework.Graphics;

/**
 * Defines the format of data in a depth-stencil buffer.
 * 
 * @author Halofreak1990
 */
public enum DepthFormat
{
	/**
	 * Do not create a depth buffer.
	 */
	None,
	/**
	 * A buffer that contains 16-bits of depth data.
	 */
	Depth16,
	/**
	 * A buffer that contains 24-bits of depth data.
	 */
	Depth24,
	/**
	 * A 32-bit buffer that contains 24-bits of depth data and 8-bits of stencil data.
	 */
	Depth24Stencil8
}
