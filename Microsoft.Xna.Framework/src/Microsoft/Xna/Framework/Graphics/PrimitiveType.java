package Microsoft.Xna.Framework.Graphics;

/**
 * Defines how vertex data is ordered.
 *
 * @author Halofreak1990
 */
public enum PrimitiveType
{
	/**
	 * The data is ordered as a sequence of line segments; each line segment is described by two new vertices. The count may be any positive integer.
	 */
	LineList (2),
	/**
	 * The data is ordered as a sequence of line segments; each line segment is described by one new vertex and the last vertex from the previous line segment. The count may be any positive integer.
	 */
	LineStrip (3),
	/**
	 * The data is ordered as a sequence of triangles; each triangle is described by three new vertices. Back-face culling is affected by the current winding-order render state.
	 */
	TriangleList (0),
	/**
	 * The data is ordered as a sequence of triangles; each triangle is described by two new vertices and one vertex from the previous triangle. The back-face culling flag is flipped automatically on even-numbered triangles.
	 */
	TriangleStrip (1);
	
	private final int value;
	private PrimitiveType(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
