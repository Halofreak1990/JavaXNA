package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Describes a custom vertex format structure that contains position, color, and one set of texture coordinates.
 * 
 * @author Halofreak1990
 */
public final class VertexPositionColorTexture extends ValueType implements IEquatable<VertexPositionColorTexture>, IVertexType
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
	 * UV texture coordinates.
	 */
	public Vector2 TextureCoordinate;
	
	private static final VertexDeclaration vertexDeclaration = new VertexDeclaration(
			new VertexElement(0, VertexElementFormat.Vector3, VertexElementUsage.Position, 0),
			new VertexElement(12, VertexElementFormat.Color, VertexElementUsage.Color, 0),
			new VertexElement(16, VertexElementFormat.Vector2, VertexElementUsage.TextureCoordinate, 0));
	
	/**
	 * Vertex declaration, which defines per-vertex data.
	 */
	@Override
	public VertexDeclaration getVertexDeclaration()
	{
		return vertexDeclaration;
	}
	
	/**
	 * Initializes a new instance of the VertexPositionColorTexture class.
	 * 
	 * @param position
	 * Position of the vertex.
	 * 
	 * @param color
	 * Color of the vertex.
	 * 
	 * @param textureCoordinate
	 * Texture coordinate of the vertex.
	 */
	public VertexPositionColorTexture(Vector3 position, Color color, Vector2 textureCoordinate)
	{
		this.Color = color;
		this.Position = position;
		this.TextureCoordinate = textureCoordinate;
	}
	
	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * The Object to compare with the current VertexPositionColorTexture.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof VertexPositionColorTexture && obj != null) ? this.Equals((VertexPositionColorTexture)obj) : false;
	}
	
	/**
	 * 
	 */
	public boolean Equals(VertexPositionColorTexture other)
	{
		return ((this.Color.equals(other.Color)) && (this.Position.Equals(other.Position)) &&
				(this.TextureCoordinate.Equals(other.TextureCoordinate)));
	}
	
	/**
	 * Gets the hash code for this instance.
	 */
	@Override
	public int hashCode()
	{
		return Position.hashCode() + Color.hashCode() + TextureCoordinate.hashCode();
	}
	
	/**
	 * Retrieves a string representation of this object.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{Position:%s Color:%s TextureCoordinate:%s}", Position, Color, TextureCoordinate);
	}
}
