package Microsoft.Xna.Framework.Graphics;

import System.*;

import Microsoft.Xna.Framework.*;

/**
 * Describes a custom vertex format structure that contains position, normal data, and one set of texture coordinates.
 * 
 * @author Halofreak1990
 */
public final class VertexPositionNormalTexture extends ValueType implements IVertexType
{
	private static final VertexDeclaration vertexDeclaration = new VertexDeclaration(
		new VertexElement(0, VertexElementFormat.Vector3, VertexElementUsage.Position, 0),
		new VertexElement(12, VertexElementFormat.Vector3, VertexElementUsage.Normal, 0),
		new VertexElement(24, VertexElementFormat.Vector2, VertexElementUsage.TextureCoordinate, 0)
	);
	
	/**
	 * XYZ surface normal.
	 */
	public Vector3 Normal;
	
	/**
	 * XYZ position.
	 */
	public Vector3 Position;
	
	/**
	 * UV texture coordinates.
	 */
	public Vector2 TextureCoordinate;

	/**
	 * Gets the Vertex declaration, which defines per-vertex data.
	 */
	@Override
	public VertexDeclaration getVertexDeclaration()
	{
		return vertexDeclaration;
	}

	/**
	 * Initializes a new instance of the VertexPositionNormalTexture class.
	 * 
	 * @param position
	 * Position of the vertex.
	 * 
	 * @param normal
	 * The vertex normal.
	 * 
	 * @param textureCoordinate
	 * The texture coordinate.
	 */
	public VertexPositionNormalTexture(Vector3 position, Vector3 normal, Vector2 textureCoordinate)
	{
		this.Position = position;
		this.Normal = normal;
		this.TextureCoordinate = textureCoordinate;
	}
}
