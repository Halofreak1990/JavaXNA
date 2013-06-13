package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

import System.*;

/**
 * Defines input vertex data to the pipeline.
 * 
 * @author Halofreak1990
 */
public final class VertexElement extends ValueType
{
	int _offset;
	VertexElementFormat _format;
    VertexElementUsage _usage;
    int _usageIndex;
	
	/**
	 * Retrieves the offset (if any) from the beginning of the stream to the beginning of the vertex data.
	 */
	public int getOffset()
	{
		return this._offset;
	}
	
	/**
	 * Sets the offset (if any) from the beginning of the stream to the beginning of the vertex data.
	 */
	public void setOffset(int value)
	{
		this._offset = value;
	}
	
	/**
	 * Modifies the usage data to allow the user to specify multiple usage types.
	 */
	public int getUsageIndex()
	{
		return this._usageIndex;
	}
	
	/**
	 * Modifies the usage data to allow the user to specify multiple usage types.
	 */
	public void setUsageIndex(int value)
	{
		this._usageIndex = value;
	}
	
	/**
	 * Gets the format of this vertex element.
	 */
	public VertexElementFormat getVertexElementFormat()
	{
		return this._format;
	}
	
	/**
	 * Sets the format of this vertex element.
	 */
	public void setVertexElementFormat(VertexElementFormat value)
	{
		this._format = value;
	}
	
	/**
	 * Gets a value describing how the vertex element is to be used.
	 */
	public VertexElementUsage getVertexElementUsage()
	{
		return this._usage;
	}
	
	/**
	 * Sets a value describing how the vertex element is to be used.
	 */
	public void setVertexElementUsage(VertexElementUsage value)
	{
		this._usage = value;
	}
	
	/**
	 * Initializes a new instance of the VertexElement class.
	 * 
	 * @param offset
	 * Offset (if any) from the beginning of the stream to the beginning of the vertex data.
	 * 
	 * @param elementFormat
	 * One of several predefined types that define the vertex data size.
	 * 
	 * @param elementUsage
	 * The intended use of the vertex data.
	 * 
	 * @param usageIndex
	 * Modifies the usage data to allow the user to specify multiple usage types.
	 */
	public VertexElement(int offset, VertexElementFormat elementFormat, VertexElementUsage elementUsage, int usageIndex)
    {
        this._offset = offset;
        this._usageIndex = usageIndex;
        this._format = elementFormat;
        this._usage = elementUsage;
    }
	
	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * The Object to compare with the current VertexElement.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		return (obj instanceof VertexElement) ? this == (VertexElement)obj : false;
	}
	
	@Override
	public int hashCode()
	{
		return _offset ^ _format.ordinal() + _usageIndex ^ _usage.ordinal();
	}
	
	/**
	 * Retrieves a string representation of this object.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{{Offset:%i Format:%s Usage:%s UsageIndex:%i}}", this._offset, this._format.toString(), this._usage.toString(), this._usageIndex);
	}
}
