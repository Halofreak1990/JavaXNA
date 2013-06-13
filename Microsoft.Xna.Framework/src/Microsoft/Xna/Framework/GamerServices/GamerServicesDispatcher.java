package Microsoft.Xna.Framework.GamerServices;

import System.*;

/**
 * Implements the Windows-specific portion of a GamerServicesDispatcher class. Reference page contains links to related code samples.
 *
 * @author Halofreak1990
 */
public class GamerServicesDispatcher
{
	private static byte[] packetBuffer;
	static IServiceProvider serviceProvider;
	
	/**
	 * Notifies the game when a Games for Windows - LIVE title update is being installed
	 */
	public static final Event<EventArgs> InstallingTitleUpdate = new Event<EventArgs>();
	
	/**
	 * 
	 * @return
	 */
	public static boolean IsInitialized()
	{
		return (packetBuffer != null);
	}
	
	/**
	 * Initializes gamer services functionality for the game, automatically choosing the most appropriate gamer service type for the platform. Reference page contains links to related code samples.
	 * 
	 * @param serviceProvider
	 * The service provider to be used when locating additional services services. For example, IGraphicsDeviceService.
	 */
	public static void Initialize(IServiceProvider serviceProvider)
	{
		if (IsInitialized())
			throw new InvalidOperationException("");
		
		if (serviceProvider == null)
	    {
	        throw new ArgumentNullException("serviceProvider");
	    }
		GamerServicesDispatcher.serviceProvider = serviceProvider;
		packetBuffer = new byte[0x440c];
		
		// TODO: implement;
	}
	
	/**
	 * 
	 */
	public static void Update()
	{
		
	}
}
