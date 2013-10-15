package Microsoft.Xna.Framework.Graphics;

/**
 * Represents a texture resource
 *
 * @author Halofreak1990
 */
public abstract class Texture extends GraphicsResource
{
	SurfaceFormat _format;
	int _levelCount;
	boolean alreadyCreated;
	boolean _isActiveRenderTarget;
	
	/**
	 * Gets the format of the texture data.
	 */
	public SurfaceFormat getFormat()
	{
		return _format;
	}
	
	/**
	 * Gets the number of texture levels in a multilevel texture.
	 */
	public int getLevelCount()
	{
		return _levelCount;
	}

	boolean IsActiveRenderTarget()
	{
		// TODO Auto-generated method stub
		return false;
	}
}
