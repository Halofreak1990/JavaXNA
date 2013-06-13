package Microsoft.Xna.Framework.Graphics;

import System.*;

/**
 * Queries and prepares resources.
 *
 * @author Halofreak1990
 */
public abstract class GraphicsResource implements IDisposable
{
	protected GraphicsDevice _parent;
	boolean isDisposed;
	
	/**
	 * Gets the name of the Resource.
	 */
	public String Name;
	/**
	 * Gets the resource tags for this resource.
	 */
	public Object Tag;
	
	/**
	 * Occurs when Dispose is called or when this object is finalized and collected by the garbage collector of the Microsoft .NET common language runtime.
	 */
	public final Event<EventArgs> Disposing = new Event<EventArgs>();
	
	/**
	 * Gets the GraphicsDevice associated with this GraphicsResource.
	 */
	public GraphicsDevice getGraphicsDevice()
	{
		return _parent;
	}
	
	/**
	 * Gets a value that indicates whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		return isDisposed;
	}
	
	GraphicsResource()
	{
	}
	
	/**
	 * Immediately releases the unmanaged resources used by this Object.
	 */
	@Override
	public void Dispose()
	{
		Dispose(true);
	}
	
	/**
	 * Immediately releases the unmanaged resources used by this Object.
	 * 
	 * @param disposing
	 */
	protected void Dispose(boolean disposing)
	{
		raise_disposing(this, EventArgs.Empty);
		
		if (disposing)
		{
			this.finalize();
		}
		isDisposed = true;
	}
	
	/**
	 * Allows this Object to attempt to free resources and perform other cleanup operations before garbage collection reclaims the object.
	 */
	protected void finalize()
	{
		Dispose(false);
	}
	
	protected void raise_disposing(Object sender, EventArgs e)
	{
		if (Disposing.hasHandlers())
		{
			Disposing.raise(sender, e);
		}
	}
	
	/**
	 * Gets a string representation of the current instance.
	 */
	public String toString()
	{
		if (Name != null || Name != "")
			return Name;
		return super.toString();
	}
}
