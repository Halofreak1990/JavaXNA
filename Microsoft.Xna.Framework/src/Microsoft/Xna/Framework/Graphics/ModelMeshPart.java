package Microsoft.Xna.Framework.Graphics;

/**
 * Represents a batch of geometry information to submit to the graphics device during rendering. Each ModelMeshPart is a subdivision of a ModelMesh object. The ModelMesh class is split into multiple ModelMeshPart objects, typically based on material information.
 * 
 * @author Halofreak1990
 */
public final class ModelMeshPart
{
	private Effect effect;
	IndexBuffer indexBuffer;
	private int numVertices;
	ModelMesh parent;
	private int primitiveCount;
	private int startIndex;
	VertexBuffer vertexBuffer;
	private int vertexOffset;
	
	/**
	 * 
	 * @return
	 */
	public Effect getEffect()
	{
		return this.effect;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setEffect(Effect value)
	{
		if (value != this.effect)
        {
            boolean flag2 = false;
            boolean flag = false;
            int count = this.parent.MeshParts().Count();
            for (int i = 0; i < count; i++)
            {
                ModelMeshPart objA = this.parent.MeshParts().get(i);
                if (!(objA == this))
                {
                    Effect effect = objA.getEffect();
                    if (effect == this.effect)
                    {
                        flag2 = true;
                    }
                    else if (effect == value)
                    {
                        flag = true;
                    }
                }
            }
            if (!flag2 && (this.effect != null))
            {
                this.parent.getEffects().Remove(this.effect);
            }
            if (!flag && (value != null))
            {
                this.parent.getEffects().Add(value);
            }
            this.effect = value;
        }
	}
	
	/**
	 * Gets the index buffer for this mesh part.
	 */
	public IndexBuffer getIndexBuffer()
	{
		return indexBuffer;
	}
	
	/**
	 * Gets the number of vertices used during a draw call.
	 */
	public int getNumVertices()
	{
		return numVertices;
	}
	
	/**
	 * Gets the number of primitives to render.
	 */
	public int getPrimitiveCount()
	{
		return primitiveCount;
	}
	
	/**
	 * Gets the location in the index array at which to start reading vertices.
	 */
	public int getStartIndex()
	{
		return this.startIndex;
	}
	
	/**
	 * Gets or sets an object identifying this model mesh part.
	 */
	public Object Tag;
	
	/**
	 * Gets the vertex buffer for this mesh part.
	 */
	public VertexBuffer getVertexBuffer()
	{
		return this.vertexBuffer;
	}
	
	/**
	 * Gets the offset (in vertices) from the top of vertex buffer.
	 */
	public int getVertexOffset()
	{
		return this.vertexOffset;
	}
	
	ModelMeshPart(int vertexOffset, int numVertices, int startIndex, int primitiveCount, Object tag)
	{
	    this.vertexOffset = vertexOffset;
	    this.numVertices = numVertices;
	    this.startIndex = startIndex;
	    this.primitiveCount = primitiveCount;
	    this.Tag = tag;
	}
	
	void Draw()
	{
	    if (this.getNumVertices() > 0)
	    {
	        GraphicsDevice graphicsDevice = this.vertexBuffer.getGraphicsDevice();
	        graphicsDevice.SetVertexBuffer(this.vertexBuffer, this.vertexOffset);
	        graphicsDevice.setIndices(this.indexBuffer);
	        graphicsDevice.DrawIndexedPrimitives(PrimitiveType.TriangleList, 0, 0, this.numVertices, this.startIndex, this.primitiveCount);
	    }
	}
}
