package Microsoft.Xna.Framework.Graphics;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Represents a set of six 2D textures, one for each face of a cube.
 *
 * @author Halofreak1990
 */
public class TextureCube extends Texture
{
	private int _size;
	
	/**
	 * 
	 */
	public int getSize()
	{
		return _size;
	}
	
	/**
	 * Creates a new instance of this Object.
	 * 
	 * @param graphicsDevice
	 * The device.
	 * 
	 * @param size
	 * The size (in pixels) of the top-level faces of the cube texture. Subsequent levels of each face will be the truncated value of half of the previous level's pixel dimension (independently). Each dimension is clamped to a minimum of 1 pixel.
	 * 
	 * @param mipMap
	 * True to generate a full mipmap chain, false otherwise.
	 * 
	 * @param format
	 * Surface data format.
	 * 
	 * @throws NotSupportedException
	 * 
	 */
	public TextureCube(GraphicsDevice graphicsDevice, int size, boolean mipMap, SurfaceFormat format)
	{
		super._parent = graphicsDevice;
		_size = size;
	}
	
	@Override
	protected void Dispose(boolean disposing)
	{
		
	}
	
	protected void finalize()
	{
		
	}
	
	/**
	 * 
	 * @param <T>
	 * @param cubeMapFace
	 * @param data
	 * 
	 * @throws ArgumentNullException
	 * data is null.
	 */
	public <T extends Number> void GetData(CubeMapFace cubeMapFace, T[] data)
	{
		this.GetData(cubeMapFace, 0, null, data, 0, data.length);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param cubeMapFace
	 * @param data
	 * @param startIndex
	 * @param elementCount
	 * 
	 * @throws ArgumentNullException
	 * data is null.
	 */
	public <T extends Number> void GetData(CubeMapFace cubeMapFace, T[] data, int startIndex, int elementCount)
	{
		this.GetData(cubeMapFace, 0, null, data, startIndex, elementCount);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param cubeMapFace
	 * @param level
	 * @param rect
	 * @param data
	 * @param startIndex
	 * @param elementCount
	 * 
	 * @throws ArgumentNullException
	 * data is null.
	 */
	public <T extends Number> void GetData(CubeMapFace cubeMapFace, int level, Rectangle rect, T[] data, int startIndex, int elementCount)
	{
		if (data == null)
		{
			throw new ArgumentNullException("data", "Buffer cannot be null.");
		}
		
		throw new NotImplementedException();
	}
	
	/**
	 * Sets cube texture data, specifying a cubemap face. 
	 * 
	 * @param <T>
	 * @param cubeMapFace
	 * @param data
	 * 
	 * @throws ArgumentNullException
	 */
	public <T extends Number> void SetData(CubeMapFace cubeMapFace, T[] data)
	{
		this.SetData(cubeMapFace, 0, null, data, 0, data.length);
	}
	
	/**
	 * Sets cube texture data, specifying a cubemap face, start index, and number of elements.
	 * 
	 * @param <T>
	 * @param cubeMapFace
	 * @param data
	 * @param startIndex
	 * @param elementCount
	 * 
	 * @throws ArgumentNullException
	 * data is null
	 */
	public <T extends Number> void SetData(CubeMapFace cubeMapFace, T[] data, int startIndex, int elementCount)
	{
		this.SetData(cubeMapFace, 0, null, data, 0, data.length);
	}
	
	/**
	 * Sets cube texture data, specifying a cubemap face, mipmap level, source rectangle, start index, and number of elements. 
	 * 
	 * @param <T>
	 * @param cubeMapFace
	 * @param level
	 * @param rect
	 * @param data
	 * @param startIndex
	 * @param elementCount
	 * 
	 * @throws ArgumentNullException
	 * data is null
	 */
	public <T extends Number> void SetData(CubeMapFace cubeMapFace, int level, Rectangle rect, T[] data, int startIndex, int elementCount)
	{
		if (data == null)
		{
			throw new ArgumentNullException("data", "Buffer cannot be null.");
		}
		
		throw new NotImplementedException();
	}
}
