package Microsoft.Xna.Framework.Graphics;

import org.lwjgl.opengl.*;

/**
 * Defines stencil buffer operations.
 * 
 * @author Halofreak1990
 */
public enum StencilOperation
{
	/**
	 * Does not update the stencil-buffer entry. This is the default value.
	 */
	Keep (GL11.GL_KEEP),
	/**
	 * Sets the stencil-buffer entry to 0.
	 */
	Zero (GL11.GL_ZERO),
	/**
	 * Replaces the stencil-buffer entry with a reference value.
	 */
	Replace (GL11.GL_REPLACE),
	/**
	 * Increments the stencil-buffer entry, wrapping to 0 if the new value exceeds the maximum value.
	 */
	Increment (GL11.GL_INCR),
	/**
	 * Decrements the stencil-buffer entry, wrapping to the maximum value if the new value is less than 0.
	 */
	Decrement (GL11.GL_DECR),
	/**
	 * Increments the stencil-buffer entry, clamping to the maximum value.
	 */
	IncrementSaturation (-1),
	/**
	 * Decrements the stencil-buffer entry, clamping to 0.
	 */
	DecrementSaturation (-1),
	/**
	 * Inverts the bits in the stencil-buffer entry.
	 */
	Invert (GL11.GL_INVERT);
	
	private final int value;
	private StencilOperation(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}
