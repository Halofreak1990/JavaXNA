package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Describes a custom vertex format structure that contains position and one set of texture coordinates.
 * 
 * @author Halofreak1990
 */
public final class VertexPositionTexture extends ValueType implements IEquatable<VertexPositionTexture>, IVertexType
{
	private static final VertexDeclaration VertexDeclaration = new VertexDeclaration(
			new VertexElement(0, VertexElementFormat.Vector3, VertexElementUsage.Position, 0),
			new VertexElement(12, VertexElementFormat.Vector2, VertexElementUsage.TextureCoordinate, 0));
	
	/**
	 * XYZ position.
	 */
	Vector3 Position;
	
	/**
	 * UV texture coordinates.
	 */
	Vector2 TextureCoordinate;

	/**
	 * Vertex declaration, which defines per-vertex data.
	 */
	@Override
	public VertexDeclaration getVertexDeclaration()
	{
		return VertexDeclaration;
	}
	
	/**
	 * Initializes a new instance of the VertexPositionTexture class.
	 * 
	 * @param position
	 * Position of the vertex.
	 * 
	 * @param textureCoordinate
	 * Texture coordinate of the vertex.
	 */
	public VertexPositionTexture(Vector3 position, Vector2 textureCoordinate)
	{
		this.Position = position;
		this.TextureCoordinate = textureCoordinate;
	}
	
	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * The Object to compare with the current VertexPositionTexture.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if ((obj != null) && (obj instanceof VertexPositionTexture))
		{
			return this.Equals((VertexPositionTexture)obj);
		}
		return false;
	}

	/**
	 * Returns a value that indicates whether the current instance is equal to a specified VertexPositionTexture.
	 * 
	 * @param other
	 * The VertexPositionTexture to compare with the current VertexPositionTexture.
	 */
	@Override
	public boolean Equals(VertexPositionTexture other)
	{
		return (Position.Equals(other.Position) && TextureCoordinate.Equals(other.TextureCoordinate));
	}

	/**
	 * Gets the hash code for this instance.
	 */
	@Override
	public int hashCode()
	{
		return Position.hashCode() + TextureCoordinate.hashCode();
	}
	
	/**
	 * Retrieves a string representation of this object.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "Position:%s TextureCoordinate:%s", Position, TextureCoordinate);
	}
}
