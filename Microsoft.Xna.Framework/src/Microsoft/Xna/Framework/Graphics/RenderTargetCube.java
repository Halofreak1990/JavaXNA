package Microsoft.Xna.Framework.Graphics;

import System.*;

/**
 * Represents a cubic texture resource that will be written to at the end of a render pass. 
 * 
 * @author Halofreak1990
 */
public class RenderTargetCube extends TextureCube
{
	/**
	 * Occurs when a resource is lost due to a device being lost.
	 */
	public final Event<EventArgs> ContentLost = new Event<EventArgs>();

	/**
	 * Determines if the data has been lost due to a lost device event.
	 * 
	 * @return
	 */
	public boolean IsContentLost()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the depth format of this rendertarget.
	 * 
	 * @return
	 * The depth format of this rendertarget
	 */
	public DepthFormat getDepthStencilFormat()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the number of multisample locations.
	 * 
	 * @return
	 * The number of multisample locations.
	 */
	public int getMultiSampleCount()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the usage mode of this rendertarget.
	 * 
	 * @return
	 * The usage mode of this rendertarget.
	 */
	public RenderTargetUsage getRenderTargetUsage()
	{
		throw new NotImplementedException();
	}

	/**
	 * Creates an instance of this object.
	 * 
	 * @param graphicsDevice
	 * The graphics device to associate with this render target resource.
	 * 
	 * @param size
	 * The width and height of this cube texture resource, in pixels.
	 * 
	 * @param mipMap
	 * @param preferredFormat
	 * @param preferredDepthFormat
	 */
	public RenderTargetCube(GraphicsDevice graphicsDevice, int size, boolean mipMap, SurfaceFormat preferredFormat, DepthFormat preferredDepthFormat)
	{
		super(graphicsDevice, size, mipMap, preferredFormat);
	}

	/**
	 * Creates an instance of this object.
	 * 
	 * @param graphicsDevice
	 * The graphics device to associate with this render target resource.
	 * 
	 * @param size
	 * The width and height of this cube texture resource, in pixels.
	 * 
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

	@Override
	protected void Dispose(boolean disposing)
	{
		
	}
}
