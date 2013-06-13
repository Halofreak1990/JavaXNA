package Microsoft.Xna.Framework.Graphics;

import org.lwjgl.opengl.*;

/**
 * Defines comparison functions that can be chosen for alpha, stencil, or depth-buffer tests.
 * 
 * @author Halofreak1990
 */
public enum CompareFunction
{
	/**
	 * Always pass the test.
	 */
	Always (GL11.GL_ALWAYS),
	/**
	 * Always fail the test.
	 */
	Never (GL11.GL_NEVER),
	/**
	 * Accept the new pixel if its value is less than the value of the current pixel.
	 */
	Less (GL11.GL_LESS),
	/**
	 * Accept the new pixel if its value is less than or equal to the value of the current pixel.
	 */
	LessEqual (GL11.GL_LEQUAL),
	/**
	 * Accept the new pixel if its value is equal to the value of the current pixel.
	 */
	Equal (GL11.GL_EQUAL),
	/**
	 * Accept the new pixel if its value is greater than or equal to the value of the current pixel.
	 */
	GreaterEqual (GL11.GL_LEQUAL),
	/**
	 * Accept the new pixel if its value is greater than the value of the current pixel.
	 */
	Greater (GL11.GL_GREATER),
	/**
	 * Accept the new pixel if its value is not equal to the value of the current pixel.
	 */
	NotEqual (GL11.GL_NOTEQUAL);
	
	private final int value;
	private CompareFunction(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}
