package Microsoft.Xna.Framework.Storage;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Represents a storage device for user data, such as a memory unit or hard drive.
 * 
 * @author Halofreak1990
 */
public final class StorageDevice
{
	public static final Event<EventArgs> DeviceChanged = new Event<EventArgs>();
	
	/**
	 * Gets the amount of free space on the device.
	 */
	public long getFreeSpace()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets whether the device is connected.
	 */
	public boolean IsConnected()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the total amount of space on the device.
	 */
	public long getTotalSpace()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Begins the process for opening a StorageContainer containing any files for the specified title.
	 * 
	 * @param displayName
	 * A constant human-readable string that names the file.
	 * 
	 * @param callback
	 * An AsyncCallback that represents the method called when the operation is complete.
	 * 
	 * @param state
	 * A user-created object used to uniquely identify the request, or null.
	 */
	public IAsyncResult BeginOpenContainer(String displayName, AsyncCallback callback, Object state)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Begins the process for displaying the storage device selector user interface, and for specifying the size of the data to be written to the storage device and the callback implemented when the player chooses a device.
	 * 
	 * @param sizeInBytes
	 * The size, in bytes, of data to write to the storage device.
	 * 
	 * @param directoryCount
	 * The number of directories to write to the storage device.
	 * 
	 * @param callback
	 * An AsyncCallback that represents the method called when the player chooses a device.
	 * 
	 * @param state
	 * A user-created object used to uniquely identify the request, or null.
	 */
	public static IAsyncResult BeginShowSelector(int sizeInBytes, int directoryCount, AsyncCallback callback, Object state)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Begins the process for displaying the storage device selector user interface, and for specifying a callback implemented when the player chooses a device.
	 * 
	 * @param callback
	 * An AsyncCallback that represents the method called when the player chooses a device.
	 * 
	 * @param state
	 * A user-created object used to uniquely identify the request, or null.
	 */
	public static IAsyncResult BeginShowSelector(AsyncCallback callback, Object state)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Begins the process for displaying the storage device selector user interface, for specifying the player who requested the save operation, for setting the size of data to be written to the storage device, and for naming the callback implemented when the player chooses a device.
	 * 
	 * @param player
	 * The PlayerIndex that represents the player who requested the save operation. On Windows, the only valid option is PlayerIndex.One.
	 * 
	 * @param sizeInBytes
	 * The size, in bytes, of the data to write to the storage device.
	 * 
	 * @param directoryCount
	 * The number of directories to write to the storage device.
	 * 
	 * @param callback
	 * An AsyncCallback that represents the method called when the player chooses a device.
	 * 
	 * @param state
	 * A user-created object used to uniquely identify the request, or null.
	 */
	public static IAsyncResult BeginShowSelector(PlayerIndex player, int sizeInBytes, int directoryCount, AsyncCallback callback, Object state)
	{
		if (player.ordinal() > PlayerIndex.One.ordinal())
			throw new InvalidOperationException();
		
		throw new NotImplementedException();
	}
	
	/**
	 * Begins the process for displaying the storage device selector user interface; specifies the callback implemented when the player chooses a device.
	 * 
	 * @param player
	 * The PlayerIndex that represents the player who requested the save operation. On Windows, the only valid option is PlayerIndex.One.
	 * 
	 * @param callback
	 * An AsyncCallback that represents the method called when the player chooses a device.
	 * 
	 * @param state
	 * A user-created object used to uniquely identify the request, or null.
	 */
	public static IAsyncResult BeginShowSelector(PlayerIndex player, AsyncCallback callback, Object state)
	{
		if (player.ordinal() > PlayerIndex.One.ordinal())
			throw new InvalidOperationException();
		
		throw new NotImplementedException();
	}
	
	/**
	 * 
	 * @param titleName
	 * The name of the storage container to delete.
	 */
	public void DeleteContainer(String titleName)
	{
		// TODO: implement
	}
	
	/**
	 * Ends the process for opening a StorageContainer.
	 * 
	 * @param result
	 * The IAsyncResult returned from BeginOpenContainer.
	 */
	public StorageContainer EndOpenContainer(IAsyncResult result)
	{
		if (result == null)
			throw new ArgumentNullException("result");
		
		throw new NotImplementedException();
	}
	
	/**
	 * Ends the display of the storage selector user interface.
	 * 
	 * @param result
	 * The IAsyncResult returned from BeginShowSelector.
	 */
	public static StorageDevice EndShowSelector(IAsyncResult result)
	{
		if (result == null)
			throw new ArgumentNullException("result");
		
		throw new NotImplementedException();
	}
}
