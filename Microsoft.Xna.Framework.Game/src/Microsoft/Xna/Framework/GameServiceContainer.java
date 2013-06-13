package Microsoft.Xna.Framework;

import java.util.HashMap;

import System.*;

/**
 * A collection of game services.
 * 
 * @author Halofreak1990
 */
@SuppressWarnings("rawtypes")
public class GameServiceContainer implements IServiceProvider
{
	HashMap<Class, Object> services; 
	
	/**
	 * Initializes a new instance of this class, which represents a collection of game services.
	 */
	public GameServiceContainer()
	{
		services = new HashMap<Class, Object>();
	}
	
	/**
	 * Adds a service to the GameServiceContainer.
	 * 
	 * @param type
	 * The type of service to add.
	 * 
	 * @param provider
	 * The service provider to add.
	 */
	public void AddService(Class type, Object provider)
	{
		services.put(type, provider);
	}
	
	/**
	 * Gets the object providing a specified service.
	 * 
	 * @param type
	 * The type of service.
	 */
	public Object GetService(Class type)
	{
		return services.get(type); 
	}
	
	/**
	 * Removes the object providing a specified service.
	 * 
	 * @param type
	 * The type of service.
	 */
	public void RemoveService(Class type)
	{
		services.remove(type);
	}  
}
