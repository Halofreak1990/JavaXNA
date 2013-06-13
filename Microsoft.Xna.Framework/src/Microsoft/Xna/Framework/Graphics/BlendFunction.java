package Microsoft.Xna.Framework.Graphics;

/**
 * Defines how to combine a source color with the destination color already on the render target for color blending.
 * 
 * @author Halofreak1990
 */
public enum BlendFunction
{
	/**
	 * The result is the destination added to the source. Result = (Source Color * Source Blend) + (Destination Color * Destination Blend)
	 */
	Add,
	/**
	 * The result is the destination subtracted from the source. Result = (Source Color * Source Blend) - (Destination Color * Destination Blend)
	 */
	Subtract,
	/**
	 * The result is the source subtracted from the destination. Result = (Destination Color * Destination Blend) - (Source Color * Source Blend)
	 */
	ReverseSubtract,
	/**
	 * The result is the minimum of the source and destination. Result = min((Source Color * Source Blend), (Destination Color * Destination Blend))
	 */
	Min,
	/**
	 * The result is the maximum of the source and destination. Result = max((Source Color * Source Blend), (Destination Color * Destination Blend)) 
	 */
	Max
}
