package Microsoft.Xna.Framework.Graphics;

import System.*;

/**
 * Binding structure that specifies a vertex buffer and other per-vertex parameters (such as offset and instancing) for a graphics device.
 * 
 * @author Halofreak1990
 */
public final class VertexBufferBinding extends ValueType
{
	private int instanceFrequency;
	private VertexBuffer vertexBuffer;
	private int vertexOffset;
	
	/**
	 * Gets the instancing frequency.
	 * 
	 * @return
	 * The instancing frequency.
	 */
	public int getInstanceFrequency()
	{
		return instanceFrequency;
	}
	
	/**
	 * Gets the associated vertex buffer.
	 * 
	 * @return
	 * The associated vertex buffer.
	 */
	public VertexBuffer getVertexBuffer()
	{
		return vertexBuffer;
	}
	
	/**
	 * Gets the offset between the beginning of the buffer and the vertex data to use.
	 * 
	 * @return
	 * The offset between the beginning of the buffer and the vertex data to use.
	 */
	public int getVertexOffset()
	{
		return vertexOffset;
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param vertexBuffer
	 * The vertex buffer.
	 */
	public VertexBufferBinding(VertexBuffer vertexBuffer)
	{
		this(vertexBuffer, 0, 0);
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param vertexBuffer
	 * The vertex buffer.
	 * 
	 * @param vertexOffset
	 * Offset (in vertices) from the beginning of the buffer to the first vertex to use.
	 */
	public VertexBufferBinding(VertexBuffer vertexBuffer, int vertexOffset)
	{
		this(vertexBuffer, vertexOffset, 0);
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param vertexBuffer
	 * The vertex buffer.
	 * 
	 * @param vertexOffset
	 * Offset (in vertices) from the beginning of the buffer to the first vertex to use.
	 * 
	 * @param instanceFrequency
	 * Number (or frequency) of instances to draw for each draw call; 1 means draw one instance, 2 means draw 2 instances, etc. Use 0 if you are not instancing.
	 */
	public VertexBufferBinding(VertexBuffer vertexBuffer, int vertexOffset, int instanceFrequency)
	{
		this.vertexBuffer = vertexBuffer;
		this.vertexOffset = vertexOffset;
		this.instanceFrequency = instanceFrequency;
	}
}
