package Microsoft.Xna.Framework.Graphics;

/**
 * Represents a cubic texture resource that will be written to at the end of a render pass. 
 * 
 * @author Halofreak1990
 */
public class RenderTargetCube extends TextureCube
{
	/**
	 * 
	 * @param graphicsDevice
	 * @param size
	 * @param mipMap
	 * @param preferredFormat
	 * @param preferredDepthFormat
	 */
	public RenderTargetCube(GraphicsDevice graphicsDevice, int size, boolean mipMap, SurfaceFormat preferredFormat, DepthFormat preferredDepthFormat)
	{
		super(graphicsDevice, size, mipMap, preferredFormat);
	}
	
	/**
	 * 
	 * @param graphicsDevice
	 * @param size
	 * @param mipMap
	 * @param preferredFormat
	 * @param preferredDepthFormat
	 * @param preferredMultiSampleCount
	 * @param usage
	 */
	public RenderTargetCube(GraphicsDevice graphicsDevice, int size, boolean mipMap, SurfaceFormat preferredFormat, DepthFormat preferredDepthFormat, int preferredMultiSampleCount, RenderTargetUsage usage)
	{
		super(graphicsDevice, size, mipMap, preferredFormat);
	}
}
