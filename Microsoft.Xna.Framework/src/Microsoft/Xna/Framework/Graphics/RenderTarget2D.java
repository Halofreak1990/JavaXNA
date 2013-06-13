package Microsoft.Xna.Framework.Graphics;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.opengl.*;

import System.*;

/**
 * Contains a 2D texture that can be used as a render target.
 *
 * @author Halofreak1990
 */
public class RenderTarget2D extends Texture2D
{
	private boolean _contentLost;
	private Texture2D texture;
	private int renderBufferObjectIdentifier;
	private RenderTargetUsage usage;
	
	/**
	 * Occurs when resources are lost due to a lost device event.
	 */
	public final Event<EventArgs> ContentLost = new Event<EventArgs>();
	
	/**
	 * Gets the data format for the depth stencil data.
	 */
	public DepthFormat getDepthStencilFormat()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Determines if the index buffer data has been lost due to a lost device event.
	 */
	public boolean IsContentLost()
	{
		if (!this._contentLost)
		{
			this._contentLost = super._parent.IsDeviceLost();
		}
		return this._contentLost;
	}
	
	/**
	 * Gets the number of sample locations during multisampling.
	 */
	public int getMultiSampleCount()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets or sets the render target usage.
	 */
	public RenderTargetUsage getRenderTargetUsage()
	{
		return usage;
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param graphicsDevice
	 * The graphics device to associate with this render target resource.
	 * 
	 * @param width
	 * Width, in pixels, of the render target. You can use graphicsDevice.PresentationParameters.BackBufferWidth to get the current screen width.
	 * 
	 * @param height
	 * Height, in pixels, of the render target. You can use graphicsDevice.PresentationParameters.BackBufferHeight to get the current screen height.
	 */
	public RenderTarget2D(GraphicsDevice graphicsDevice, int width, int height)
	{
		this(graphicsDevice, width, height, false, SurfaceFormat.Color, DepthFormat.Depth24, 0, RenderTargetUsage.DiscardContents);
	}
	
	/**
	 * 
	 * @param graphicsDevice
	 * @param width
	 * @param height
	 * @param mipMap
	 * @param preferredFormat
	 * @param preferredDepthFormat
	 */
	public RenderTarget2D(GraphicsDevice graphicsDevice, int width, int height, boolean mipMap, SurfaceFormat preferredFormat, DepthFormat preferredDepthFormat)
	{
		this(graphicsDevice, width, height, false, preferredFormat, preferredDepthFormat, 0, RenderTargetUsage.DiscardContents);
	}
	
	/**
	 * 
	 * @param graphicsDevice
	 * @param width
	 * @param height
	 * @param mipMap
	 * @param preferredFormat
	 * @param preferredDepthFormat
	 * @param preferredMultiSampleCount
	 * @param usage
	 */
	public RenderTarget2D(GraphicsDevice graphicsDevice, int width, int height, boolean mipMap, SurfaceFormat preferredFormat, DepthFormat preferredDepthFormat, int preferredMultiSampleCount, RenderTargetUsage usage)
	{
		this._parent = graphicsDevice;
		this.width = width;
		this.height = height;
		this.usage = usage;
		
		texture = new Texture2D(graphicsDevice, width, height, mipMap, preferredFormat);
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture.textureId);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, width, height, 0, GL12.GL_BGRA, GL11.GL_UNSIGNED_BYTE, ByteBuffer.allocate(0));
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		
		IntBuffer buffer = IntBuffer.allocate(1);
		EXTFramebufferObject.glGenRenderbuffersEXT(buffer);
		renderBufferObjectIdentifier = buffer.get(0);
		EXTFramebufferObject.glBindRenderbufferEXT(EXTFramebufferObject.GL_RENDERBUFFER_EXT, renderBufferObjectIdentifier);
		EXTFramebufferObject.glRenderbufferStorageEXT(EXTFramebufferObject.GL_RENDERBUFFER_EXT, GL11.GL_DEPTH_COMPONENT, width, height);
		EXTFramebufferObject.glBindRenderbufferEXT(EXTFramebufferObject.GL_RENDERBUFFER_EXT, 0);
	}
	
	@Override
	protected void Dispose(boolean disposing)
	{
		if (!disposing)
			EXTFramebufferObject.glDeleteRenderbuffersEXT(renderBufferObjectIdentifier);
		
		super.Dispose(disposing);
	}
}
