package Microsoft.Xna.Framework.Graphics;

import java.util.EnumSet;

import System.*;

/**
 * Describes the rendering order of the vertices in a vertex buffer.
 * 
 * @author Halofreak1990
 */
public class IndexBuffer extends GraphicsResource
{
	private BufferUsage bufferUsage;
	private int indexCount;
	private IndexElementSize indexElementSize;
	
	/**
	 * Gets the state of the related BufferUsage enumeration.
	 */
	public BufferUsage getBufferUsage()
	{
		return bufferUsage;
	}
	
	/**
	 * Gets the number of indices in this buffer.
	 */
	public int getIndexCount()
	{
		return indexCount;
	}
	
	/**
	 * Gets a value indicating the size of this index element.
	 */
	public IndexElementSize getIndexElementSize()
	{
		return indexElementSize;
	}
	
	/**
	 * Initializes a new instance of the IndexBuffer class.
	 * 
	 * @param graphicsDevice
	 * The GraphicsDevice object to associate with the index buffer.
	 * 
	 * @param indexElementSize
	 * The size (in bits) of each index.
	 * 
	 * @param indexCount
	 * The number of indices.
	 * 
	 * @param usage
	 * Behavior options.
	 */
	public IndexBuffer(GraphicsDevice graphicsDevice, IndexElementSize indexElementSize, int indexCount, BufferUsage usage)
	{
		super._parent = graphicsDevice;
		this.indexElementSize = indexElementSize;
		this.indexCount = indexCount;
		this.bufferUsage = usage;
		
		// TODO: implement remainder
	}
	
	/**
	 * Initializes a new instance of the IndexBuffer class.
	 * 
	 * @param graphicsDevice
	 * The GraphicsDevice object to associate with the index buffer.
	 * 
	 * @param indexType
	 * The index value type.
	 * 
	 * @param indexCount
	 * The number of indices.
	 * 
	 * @param usage
	 * Behavior options.
	 */
	@SuppressWarnings("rawtypes")
	public IndexBuffer(GraphicsDevice graphicsDevice, Class indexType, int indexCount, BufferUsage usage)
	{
		super._parent = graphicsDevice;
		this.indexCount = indexCount;
		this.bufferUsage = usage;
		
		// TODO: implement remainder
	}
	
	/**
	 * Immediately releases the unmanaged resources used by this object.
	 * 
	 * @param disposing
	 * true to release both managed and unmanaged resources; false to release only unmanaged resources.
	 */
	@Override
	protected void Dispose(boolean disposing)
	{
		
	}
	
	<T> void CopyData(int offsetInBytes, T[] data, int startIndex, int elementCount, EnumSet<SetDataOptions> options, boolean isSetting)
	{
		if (data == null || data.length == 0)
			throw new ArgumentNullException("data", "This method does not allow null for this parameter.");
		
		throw new NotImplementedException();
	}
	
	/**
	 * Gets a copy of the index buffer data, specifying the start index, starting offset, number of elements, and size of the elements.
	 * 
	 * @param offsetInBytes
	 * Offset in bytes from the beginning of the buffer to the data.
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
	public <T> void GetData(int offsetInBytes, T[] data, int startIndex, int elementCount)
	{
		
	}
	
	/**
	 * Gets a copy of the index buffer data.
	 * 
	 * @param data
	 * Array of data.
	 */
	public <T> void GetData(T[] data)
	{
		
	}
	
	/**
	 * Gets a copy of the index buffer data, specifying the start index and number of elements.
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
		GetData(0, data, startIndex, elementCount);
	}
	
	/**
	 * Sets index buffer data, specifying the offset, start index and number of elements.
	 * 
	 * @param offsetInBytes
	 * Offset in bytes from the beginning of the buffer to the data.
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
	public <T> void SetData(int offsetInBytes, T[] data, int startIndex, int elementCount)
	{
		// TODO: implement
	}
	
	/**
	 * Sets index buffer data.
	 * 
	 * @param data
	 * Array of data.
	 */
	public <T> void SetData(T[] data)
	{
		SetData(0, data, 0, data.length);
	}
	
	/**
	 * Sets index buffer data, specifying the start index and number of elements.
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
		SetData(0, data, startIndex, elementCount);
	}
}
