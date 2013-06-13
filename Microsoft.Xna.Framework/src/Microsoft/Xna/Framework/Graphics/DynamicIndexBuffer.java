package Microsoft.Xna.Framework.Graphics;

import java.util.EnumSet;

import System.*;

/**
 * 
 * 
 * @author Halofreak1990
 */
public class DynamicIndexBuffer extends IndexBuffer
{
	boolean _contentLost;
	
	/**
	 * Determines if the index buffer data has been lost due to a lost device event.
	 */
	public boolean IsContentLost()
	{
		return _contentLost;
	}
	
	/**
	 * Occurs when resources are lost due to a lost device event.
	 */
	public final Event<EventArgs> ContentLost = new Event<EventArgs>();
	
	/**
	 * Create a new instance of this class.
	 * 
	 * @param graphicsDevice
	 * The associated graphics device.
	 * 
	 * @param indexElementSize
	 * Size of each index element.
	 * 
	 * @param indexCount
	 * The number of indices in the buffer.
	 * 
	 * @param usage
	 * Behavior options.
	 */
	public DynamicIndexBuffer(GraphicsDevice graphicsDevice, IndexElementSize indexElementSize, int indexCount, BufferUsage usage)
	{
		super(graphicsDevice, indexElementSize, indexCount, usage);
	}
	
	/**
	 * Create a new instance of this class.
	 * 
	 * @param graphicsDevice
	 * The associated graphics device.
	 * 
	 * @param indexType
	 * The index type.
	 * 
	 * @param indexCount
	 * The number of indices in the buffer.
	 * 
	 * @param usage
	 * Behavior options.
	 */
	@SuppressWarnings("rawtypes")
	public DynamicIndexBuffer(GraphicsDevice graphicsDevice, Class indexType, int indexCount, BufferUsage usage)
	{
		super(graphicsDevice, indexType, indexCount, usage);
	}
	
	void SetContentLost(boolean isContentLost)
	{
		this._contentLost = isContentLost;
		if (isContentLost)
		{
			if (this.ContentLost.hasHandlers())
				this.ContentLost.raise(this, EventArgs.Empty);
		}
	}
	
	/**
	 * Sets dynamic index buffer data, specifying the start index, number of elements and options.
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
	 * Specifies whether existing data in the buffer will be kept after this operation. Dynamic geometry may be rendered on the Xbox 360 by using DrawUserIndexedPrimitives instead of setting the data for the index buffer.
	 */
	public <T> void SetData(T[] data, int startIndex, int elementCount, EnumSet<SetDataOptions> options)
	{
		SetData(0, data, startIndex, startIndex, options);
	}
	
	/**
	 * Sets dynamic index buffer data, specifying the offset, start index, number of elements and options.
	 * 
	 * @param offsetInBytes
	 * Offset in bytes from the beginning of the buffer to the data.
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
	 * Specifies whether existing data in the buffer will be kept after this operation. Dynamic geometry may be rendered on the Xbox 360 by using DrawUserIndexedPrimitives instead of setting the data for the index buffer.
	 */
	public <T> void SetData(int offsetInBytes, T[] data, int startIndex, int elementCount, EnumSet<SetDataOptions> options)
	{
		super.CopyData(offsetInBytes, data, startIndex, elementCount, options, true);
	}
}
