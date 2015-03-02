package Microsoft.Xna.Framework.Graphics;

import java.nio.IntBuffer;

import org.lwjgl.opengl.*;

/**
 * Used to perform an occlusion query against the latest drawn objects.
 * 
 * @author Halofreak1990
 */
public class OcclusionQuery extends GraphicsResource
{
	private int glQueryId;
	
	/**
	 * Gets a value that indicates if the occlusion query has completed.
	 */
	public boolean IsComplete()
	{
		IntBuffer ib = IntBuffer.allocate(1);
		
		GL15.glGetQueryObject(glQueryId, GL15.GL_QUERY_RESULT_AVAILABLE, ib);
		//GraphicsExtensions.CheckGLError();
		
		return ib.get(0) != 0;
	}
	
	/**
	 * Gets the number of visible pixels.
	 */
	public int getPixelCount()
	{
		IntBuffer ib = IntBuffer.allocate(1);
		
		GL15.glGetQueryObjectu(glQueryId, GL15.GL_QUERY_RESULT_AVAILABLE, ib);
		//GraphicsExtensions.CheckGLError();
		
		return ib.get(0);
	}
	
	/**
	 * Initializes a new instance of OcclusionQuery with the specified device.
	 * 
	 * @param graphicsDevice
	 * The graphics device to associate with this query.
	 */
	public OcclusionQuery(GraphicsDevice graphicsDevice)
	{
		this.setGraphicsDevice(graphicsDevice);
		
		IntBuffer ib = IntBuffer.allocate(1);
		GL15.glGenQueries(ib);
		glQueryId = ib.get(0);
		
		//GraphicsExtensions.CheckGLError();
	}
	
	/**
	 * Releases the unmanaged resources used by Dispose and optionally releases the managed resources.
	 * 
	 * @param disposing
	 * true to release both managed and unmanaged resources; false to release only unmanaged resources.
	 */
	protected void Dispose(boolean disposing)
	{
		if (!IsDisposed())
		{
			GL15.glDeleteQueries(glQueryId);
		}
	}
	
	/**
	 * Begins application of the query.
	 */
	public void Begin()
	{
		GL15.glBeginQuery(GL15.GL_SAMPLES_PASSED, glQueryId);
		
		//GraphicsExtensions.CheckGLError();
	}
	
	/**
	 * Ends the application of the query.
	 */
	public void End()
	{
		GL15.glEndQuery(GL15.GL_SAMPLES_PASSED);
		
		//GraphicsExtensions.CheckGLError();
	}
}
