package Microsoft.Xna.Framework.Graphics;

import System.*;

/**
 * 
 * 
 * @author Halofreak1990
 */
public class DynamicVertexBuffer extends VertexBuffer
{
	boolean _contentLost;
	
	/**
	 * Occurs when resources are lost due to a lost device event.
	 */
	public final Event<EventArgs> ContentLost = new Event<EventArgs>();
	
	/**
	 * Creates a new instance of this object.
	 * 
	 * @param graphicsDevice
	 * The graphics device.
	 * 
	 * @param vertexDeclaration
	 * The vertex declaration, which describes per-vertex data.
	 * 
	 * @param vertexCount
	 * The number of vertices.
	 * 
	 * @param usage
	 * Behavior options; it is good practice for this to match the createOptions parameter in the GraphicsDevice constructor.
	 */
	public DynamicVertexBuffer(GraphicsDevice graphicsDevice, VertexDeclaration vertexDeclaration, int vertexCount, BufferUsage usage)
	{
		super(graphicsDevice, vertexDeclaration, vertexCount, usage);
	}
	
	/**
	 * Creates a new instance of this object.
	 * 
	 * @param graphicsDevice
	 * The graphics device.
	 * 
	 * @param vertexType
	 * The data type.
	 * 
	 * @param vertexCount
	 * The number of vertices.
	 * 
	 * @param usage
	 * Behavior options; it is good practice for this to match the createOptions parameter in the GraphicsDevice constructor.
	 */
	@SuppressWarnings("rawtypes")
    public DynamicVertexBuffer(GraphicsDevice graphicsDevice, Class vertexType, int vertexCount, BufferUsage usage)
    {
    	super(graphicsDevice, vertexType, vertexCount, usage);
    }
	
	/**
	 * Sets dynamic vertex buffer data, specifying the start index, number of elements and options.
	 * 
	 * @param data
	 * Array of data.
	 * 
	 * @param startIndex
	 * The first element to use.
	 * 
	 * @param elementCount
	 * The number of elements to use.
	 * 
	 * @param options
	 * Specifies whether existing data in the buffer will be kept after this operation. Dynamic geometry may be rendered on the Xbox 360 by using DrawUserIndexedPrimitives instead of setting the data for the vertex buffer.
	 */
	public <T extends ValueType> void SetData(T[] data, int startIndex, int elementCount, SetDataOptions options)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Sets dynamic vertex buffer data, specifying the offset, start index, number of elements and vertex stride.
	 * Offset in bytes from the beginning of the buffer to the data.
	 * 
	 * @param offsetInBytes
	 * @param data
	 * Array of data.
	 * 
	 * @param startIndex
	 * The first element to use.
	 * 
	 * @param elementCount
	 * The number of elements to use.
	 * 
	 * @param vertexStride
	 * The size, in bytes, of the elements in the vertex buffer.
	 * 
	 * @param options
	 * Specifies whether existing data in the buffer will be kept after this operation. Dynamic geometry may be rendered on the Xbox 360 by using DrawUserIndexedPrimitives instead of setting the data for the vertex buffer.
	 */
    public <T extends ValueType> void SetData(int offsetInBytes, T[] data, int startIndex, int elementCount, int vertexStride, SetDataOptions options)
    {
    	throw new NotImplementedException();
    }
}
