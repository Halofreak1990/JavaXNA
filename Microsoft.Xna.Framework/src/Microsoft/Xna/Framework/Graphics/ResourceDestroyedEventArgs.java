package Microsoft.Xna.Framework.Graphics;

import System.EventArgs;

/**
 * Contains event data.
 * 
 * @author Halofreak1990
 */
public final class ResourceDestroyedEventArgs extends EventArgs
{
	private Object resource;
	
	ResourceDestroyedEventArgs(Object resource)
	{
		this.resource = resource;
	}
	
	/**
	 * Gets the object raising the event. 
	 * 
	 * @return
	 * The object raising the event.
	 */
	public Object getResource()
	{
		return resource;
	}
}
