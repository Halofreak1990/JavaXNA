package Microsoft.Xna.Framework.Graphics;

/**
 * Represents a 3D volume of texels.
 * 
 * @author Halofreak1990
 */
public class Texture3D extends Texture
{
	private int _depth;
    private int _height;
    private int _width;

    public int Depth()
    {
    	return this._depth;
    }
    
    public int Height()
    {
    	return this._height;
    }
    
    public int Width()
    {
    	return this._width;
    }
    
    public Texture3D(GraphicsDevice graphicsDevice, int width, int height, int depth, boolean mipMap, SurfaceFormat format)
    {
    	this._width = width;
    	this._height = height;
    	this._depth = depth;
    }
    
    public <T> void GetData(T[] data)
    {
    	
    }
    
    public <T> void GetData(T[] data, int startIndex, int elementCount)
    {
    	
    }
    
    public <T> void GetData(int level, int left, int top, int right, int bottom, int front, int back, T[] data, int startIndex, int elementCount)
    {
    	
    }
}
