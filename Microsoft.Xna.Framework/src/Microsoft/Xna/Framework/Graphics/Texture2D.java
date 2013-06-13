package Microsoft.Xna.Framework.Graphics;

import java.io.*;
import java.nio.*;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Represents a 2D grid of texels.
 * 
 * @author Halofreak1990
 */
public class Texture2D extends Texture
{
	private GraphicsDevice device;
	protected int height;
	protected int width;
	
	int textureId = -1;
	int imageId;
	
	/**
	 * Gets the size of this resource.
	 */
	public Rectangle Bounds()
	{
		return new Rectangle(0, 0, width, height);
	}
	
	/**
	 * Gets the width of this texture resource, in pixels.
	 */
	public int Width()
	{
		return width;
	}
	
	/**
	 * Gets the height of this texture resource, in pixels.
	 */
	public int Height()
	{
		return height;
	}
	
	protected Texture2D()
	{
		
	}
	
	/**
	 * Creates a new instance of this object.
	 * 
	 * @param graphicsDevice
	 * The device.
	 * 
	 * @param width
	 * Texture width.
	 * 
	 * @param height
	 * Texture height.
	 */
	public Texture2D(GraphicsDevice graphicsDevice, int width, int height)
	{
		this(graphicsDevice, width, height, false, SurfaceFormat.Color);
	}
	
	/**
	 * Creates a new instance of this object.
	 * 
	 * @param graphicsDevice
	 * The device.
	 * 
	 * @param width
	 * Texture width.
	 * 
	 * @param height
	 * Texture height.
	 * 
	 * @param mipMap
	 * True to generate a full mipmap chain; false otherwise.
	 * 
	 * @param format
	 * Texture data format.
	 */
    public Texture2D(GraphicsDevice graphicsDevice, int width, int height, boolean mipMap, SurfaceFormat format)
    {
    	if (graphicsDevice == null)
    		throw new ArgumentNullException("graphicsDevice");
    	
    	ValidateCreationParameters(graphicsDevice._graphicsProfile, width, height, mipMap, format);
    	
    	this.device = graphicsDevice;
    	this.width = width;
    	this.height = height;
    	this._format = format;
    	
    	IntBuffer tmp = BufferUtils.createIntBuffer(1);
    	GL11.glGenTextures(tmp);
    	textureId = tmp.get(0);
    	GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);
    	GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
    	GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
    	GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
    }
    
    static void ValidateCreationParameters(GraphicsProfile graphicsProfile, int width, int height, boolean mipMap, SurfaceFormat format)
	{
    	if (width <= 0)
            throw new ArgumentOutOfRangeException("width", "FrameworkResources.ResourcesMustBeGreaterThanZeroSize");
        
        if (height <= 0)
            throw new ArgumentOutOfRangeException("height", "FrameworkResources.ResourcesMustBeGreaterThanZeroSize");
        
        ProfileCapabilities pc = ProfileCapabilities.GetInstance(graphicsProfile);
        
        if (width > pc.MaxTextureSize)
        	throw new ArgumentOutOfRangeException("width", "");
        
        if (height > pc.MaxTextureSize)
        	throw new ArgumentOutOfRangeException("height", "");
        
        if (!pc.ValidTextureFormats.contains(format))
        	throw new ArgumentException("", "format");
	}

	protected void Dispose(boolean disposing)
    {
		if (!this.isDisposed)
		{
	    	if (disposing)
	    	{
	    		
	    	}
	    	try
	    	{
	    		GL11.glDeleteTextures(textureId);
	    	}
	    	finally
	    	{
	    		super.Dispose(false);
	    		
	    		if (device != null)
	    		{
	    			if (device.getTextures().textures.contains(this))
	    			{
	    				device.getTextures().textures.remove(this);
	    			}
	    		}
	    	}
		}
    	this.isDisposed = true;
    }
    
	/**
	 * Loads texture data from a stream.
	 * 
	 * @param graphicsDevice
	 * A graphics device.
	 * 
	 * @param stream
	 * Data stream from one of the following file types: .gif, .jpg or .png.
	 * 
	 * @return
     * The created texture.
	 */
    public static Texture2D FromStream(GraphicsDevice graphicsDevice, InputStream stream)
    {
    	int maxTextureSize = graphicsDevice._profileCapabilities.MaxTextureSize;
    	return FromStream(graphicsDevice, stream, maxTextureSize, maxTextureSize, false);
    }
    
    /**
     * Loads texture data from a stream.
     * 
     * @param graphicsDevice
     * A graphics device.
     * 
     * @param stream
     * Data stream from one of the following file types: .gif, .jpg or .png.
     * 
     * @param width
     * The requested image width.
     * 
     * @param height
     * The requested image height.
     * 
     * @param zoom
     * Control the aspect ratio when zooming (scaling); set to false to maintain a constant aspect ratio, true otherwise. See remarks.
     * 
     * @return
     * The created texture.
     * 
     * @throws System.ArgumentNullException
     * graphicsDevice or stream is null.
     */
    public static Texture2D FromStream(GraphicsDevice graphicsDevice, InputStream stream, int width, int height, boolean zoom)
    {
    	if (graphicsDevice == null)
    	{
    		throw new ArgumentNullException("graphicsDevice");
    	}
    	
    	ValidateCreationParameters(graphicsDevice._graphicsProfile, width, height, false, SurfaceFormat.Color);
    	
    	Texture2D result = new Texture2D(graphicsDevice, width, height);
    	
    	// TODO: write image to texture memory
    	
    	return result;
    }
    
    /**
     * Gets a copy of 2D texture data. Reference page contains code sample.
     * 
     * @param data
     * Array of data.
     */
    public <T> void GetData(T[] data)
    {
    	int length;
    	if (data != null)
    	{
    		length = data.length;
    	}
    	else
    	{
    		length = 0;
    	}
    	this.GetData(0, null, data, 0, length);
    }
    
    /**
     * Gets a copy of 2D texture data, specifying a start index and number of elements. Reference page contains code sample.
     * 
     * @param data
     * Array of data.
     * 
     * @param startIndex
     * Index of the first element to get.
     * 
     * @param elementCount
     * Number of elements to get.
     */
    public <T> void GetData(T[] data, int startIndex, int elementCount)
    {
    	this.GetData(0, null, data, startIndex, elementCount);
    }
    
    /**
     * Gets a copy of 2D texture data, specifying a mipmap level, source rectangle, start index, and number of elements.
     * 
     * @param level
     * Mipmap level.
     * 
     * @param rect
     * The section of the texture to copy. null indicates the data will be copied from the entire texture.
     * 
     * @param data
     * Array of data.
     * 
     * @param startIndex
     * Index of the first element to get.
     * 
     * @param elementCount
     * Number of elements to get.
     */
    public <T> void GetData(int level, Rectangle rect, T[] data, int startIndex, int elementCount)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * Saves texture data as a .jpg.
     * 
     * @param stream
     * Data stream number.
     * 
     * @param width
     * Image width.
     * 
     * @param height
     * Image height.
     * 
     * @throws System.ArgumentNullException
     * stream is null.
     */
    public void SaveAsJpeg(OutputStream stream, int width, int height)
    {
    	if (stream == null)
    		throw new ArgumentNullException("stream");
    	
    	throw new NotImplementedException();
    }
    
    /**
     * Saves texture data as a .png.
     * 
     * @param stream
     * Data stream number.
     * 
     * @param width
     * Image width.
     * 
     * @param height
     * Image height.
     * 
     * @throws System.ArgumentNullException
     * stream is null.
     */
    public void SaveAsPng(OutputStream stream, int width, int height)
    {
    	if (stream == null)
    		throw new ArgumentNullException("stream");
    	
    	throw new NotImplementedException();
    }
    
    /**
     * Sets 2D texture data. Reference page contains links to related conceptual articles.
	 *
     * @param data
     * Array of data.
     */
    public <T> void SetData(T[] data)
    {
    	int length;
    	if (data != null)
    	{
    		length = data.length;
    	}
    	else
    	{
    		length = 0;
    	}
    	this.SetData(0, null, data, 0, length);
    }
    
    /**
     * Sets 2D texture data, specifying a start index, and number of elements.
     * 
     * @param data
     * Array of data.
     * 
     * @param startIndex
     * Index of the first element to set.
     * 
     * @param elementCount
     * Number of elements to set.
     */
    public <T> void SetData(T[] data, int startIndex, int elementCount)
    {
    	this.SetData(0, null, data, startIndex, elementCount);
    }
    
    /**
     * Sets 2D texture data, specifying a mipmap level, source rectangle, start index, and number of elements.
     * 
     * @param level
     * Mipmap level.
     * 
     * @param rect
     * A bounding box that defines the position and location (in pixels) of the data.
     * 
     * @param data
     * Array of data.
     * 
     * @param startIndex
     * Index of the first element to set.
     * 
     * @param elementCount
     * Number of elements to set.
     */
    public <T> void SetData(int level, Rectangle rect, T[] data, int startIndex, int elementCount)
    {
    	GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);
    	
    	/*switch(this._format)
    	{
    	case Color:
    		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, level, GL11.GL_RGBA8, this.width, this.height, 0, GL12.GL_BGRA, GL11.GL_UNSIGNED_BYTE, data);
    		break;
    	case Dxt1:
    		GL13.glCompressedTexImage2D(GL11.GL_TEXTURE_2D, level, EXTTextureCompressionS3TC.GL_COMPRESSED_RGBA_S3TC_DXT1_EXT, this.width, this.height, 0, elementCount, data);
    		break;
    	case Dxt3:
    		GL13.glCompressedTexImage2D(GL11.GL_TEXTURE_2D, level, EXTTextureCompressionS3TC.GL_COMPRESSED_RGBA_S3TC_DXT3_EXT, this.width, this.height, 0, elementCount, data);
    		break;
    	case Dxt5:
    		GL13.glCompressedTexImage2D(GL11.GL_TEXTURE_2D, level, EXTTextureCompressionS3TC.GL_COMPRESSED_RGBA_S3TC_DXT5_EXT, this.width, this.height, 0, elementCount, data);
    		break;
    	}*/
    }
}
