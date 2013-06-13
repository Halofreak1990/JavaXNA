package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Describes a custom vertex format structure that contains position and color information.
 * 
 * @author Halofreak1990
 */
public final class VertexPositionColor extends ValueType implements IEquatable<VertexPositionColor>, IVertexType
{
	/**
	 * The vertex color.
	 */
	public Color Color;
	
	/**
	 * XYZ position.
	 */
	public Vector3 Position;
	
	/**
	 * Vertex declaration, which defines per-vertex data.
	 */
	private static final VertexDeclaration VertexDeclaration = new VertexDeclaration(
			new VertexElement(0, VertexElementFormat.Vector3, VertexElementUsage.Position, 0),
			new VertexElement(12, VertexElementFormat.Color, VertexElementUsage.Color, 0));
	// TODO: Verify
	
	@Override
	public VertexDeclaration getVertexDeclaration()
	{
		return VertexDeclaration;
	}
	
	/**
	 * Initializes a new instance of the VertexPositionColor class.
	 * 
	 * @param position
	 * The position of the vertex.
	 * 
	 * @param color
	 * The color of the vertex.
	 */
	public VertexPositionColor(Vector3 position, Color color)
	{
		this.Color = color;
		this.Position = position;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && (obj instanceof VertexPositionColor)) ? this.Equals((VertexPositionColor)obj) : false;
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public boolean Equals(VertexPositionColor other)
	{
		return (this.Color.Equals(other.Color) && this.Position.Equals(other.Position));
	}
	
	/**
	 * Gets the hash code for this instance.
	 */
	@Override
	public int hashCode()
	{
		return Color.hashCode() + Position.hashCode();
	}
	
	/**
	 * Retrieves a string representation of this object.
	 */
	public String toString()
	{
		return String.format(Locale.getDefault(), "{Position:%s Color:%s}", Position, Color);
	}
}
