/**
 * 
 */
package Microsoft.Xna.Framework.Graphics;

import java.nio.*;
import java.util.Locale;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import System.*;

/**
 * Represents a list of 3D vertices to be streamed to the graphics device.
 * 
 * @author Halofreak1990
 */
public class VertexBuffer extends GraphicsResource
{
	int _vertexCount;
	VertexDeclaration _vertexDeclaration;
	protected BufferUsage _usage;
	int sizeInBytes;
	int bufferId;
	
	/**
	 * 
	 * @return
	 */
	public BufferUsage getBufferUsage()
	{
		return _usage;
	}
	
    boolean IsWriteOnly()
    {
    	return (_usage == BufferUsage.WriteOnly);
    }
    
    /**
     * 
     * @return
     */
    public int VertexCount()
    {
    	return _vertexCount;
    }
    
    /**
     * 
     * @return
     */
    public VertexDeclaration getVertexDeclaration()
    {
    	return _vertexDeclaration;
    }
    
    /**
     * Creates an instance of this object.
     * 
     * @param graphicsDevice
     * The graphics device.
     * 
     * @param vertexDeclaration
     * 
     * @param vertexCount
     * 
     * @param usage
     * 
     */
	public VertexBuffer(GraphicsDevice graphicsDevice, VertexDeclaration vertexDeclaration, int vertexCount, BufferUsage usage)
	{
		this._parent = graphicsDevice;
		this._vertexDeclaration = vertexDeclaration;
		this._vertexCount = vertexCount;
		this._usage = usage;
		
		CreateHostBuffer();
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param graphicsDevice
	 * The graphics device.
	 * 
	 * @param vertexType
	 * 
	 * @param vertexCount
	 * 
	 * @param usage
	 * 
	 */
	@SuppressWarnings("rawtypes")
    public VertexBuffer(GraphicsDevice graphicsDevice, Class vertexType, int vertexCount, BufferUsage usage)
    {
		try
		{
			this._vertexDeclaration = VertexDeclaration.FromType(vertexType);
			this._parent = graphicsDevice;
	    	this._vertexCount = vertexCount;
	    	this._usage = usage;
	    	
	    	CreateHostBuffer();
		}
		catch (RuntimeException ex)
		{
			super.Dispose(true);
		}
    }
	
	private void CreateHostBuffer()
	{
		IntBuffer tmp = BufferUtils.createIntBuffer(1);
		GL15.glGenBuffers(tmp);
		tmp.reset();
		bufferId = tmp.get(1);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, bufferId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, sizeInBytes, GL15.GL_DYNAMIC_DRAW);
	}
    
    public <T> void GetData(T[] data)
    {
    	throw new NotImplementedException();
    }
    
    public <T> void GetData(T[] data, int startIndex, int elementCount)
    {
    	throw new NotImplementedException();
    }
    
    public <T> void GetData(int offsetInBytes, T[] data, int startIndex, int elementCount, int vertexStride)
    {
    	throw new NotImplementedException();
    }
    
    public <T> void SetData(T[] data)
    {
    	throw new NotImplementedException();
    }
    
    public <T> void SetData(T[] data, int startIndex, int elementCount)
    {
    	throw new NotImplementedException();
    }
    
    public <T> void SetData(int offsetInBytes, T[] data, int startIndex, int elementCount, int vertexStride)
    {
    	throw new NotImplementedException();
    }
    
    @Override
    public String toString()
    {
    	return String.format(Locale.getDefault(), "[VertexBuffer: BufferUsage=%s, SizeInBytes=%d]", this._usage.toString(), this.sizeInBytes);
    }
}
