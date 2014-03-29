package Microsoft.Xna.Framework.Storage;

import java.io.*;

import System.*;

/**
 * Represents a logical collection of storage files.
 * 
 * @author Halofreak1990
 */
public class StorageContainer implements IDisposable
{
	String displayName;
	private boolean isDisposed;
	StorageDevice parent;

	/**
	 * Occurs when Dispose is called or when this object is finalized and collected by the garbage collector of the Microsoft .NET common language runtime.
	 */
	public final Event<EventArgs> Disposing = new Event<EventArgs>();

	/**
	 * Gets the name of the title.
	 */
	public String getDisplayName()
	{
		return displayName;
	}

	/**
	 * Gets a value that indicates whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		return isDisposed;
	}

	/**
	 * Gets the StorageDevice that holds the files in this container.
	 */
	public StorageDevice getStorageDevice()
	{
		return parent;
	}

	/**
	 * Allows this object to attempt to free resources and perform other cleanup operations before garbage collection reclaims the object.
	 */
	protected void finalize()
	{
		if (!this.isDisposed)
		{
			// TODO: implement
		}
	}

	/**
	 * Creates a new directory in the StorageContainer scope.
	 * 
	 * @param directory
	 * The relative path of the directory to create within the StorageContainer scope.
	 */
	public void CreateDirectory(String directory)
	{
		// TODO: implement
	}

	/**
	 * Creates a file at a specified path in the StorageContainer.
	 * 
	 * @param file
	 * The relative path of the file to be created in the StorageContainer.
	 */
	public FileOutputStream CreateFile(String file)
	{
		throw new NotImplementedException();
	}

	/**
	 * Deletes a directory in the StorageContainer scope.
	 * 
	 * @param directory
	 * The relative path of the directory to delete within the StorageContainer scope.
	 */
	public void DeleteDirectory(String directory)
	{
		// TODO: implement
	}

	/**
	 * Deletes a file in the StorageContainer.
	 * 
	 * @param file
	 * The relative path of the file to delete within the StorageContainer.
	 */
	public void DeleteFile(String file)
	{
		// TODO: implement
	}

	/**
	 * Determines whether the specified path refers to an existing directory in the StorageContainer.
	 * 
	 * @param directory
	 * The path to test.
	 */
	public boolean DirectoryExists(String directory)
	{
		throw new NotImplementedException();
	}

	/**
	 * Immediately releases the unmanaged resources used by this object.
	 */
	public void Dispose()
	{
		// TODO: implement
		
		this.isDisposed = true;
	}

	/**
	 * Determines whether the specified path refers to an existing file in the StorageContainer.
	 * 
	 * @param file
	 * The path and file name to test.
	 */
	public boolean FileExists(String file)
	{
		throw new NotImplementedException();
	}

	/**
	 * Enumerates the directories in the root of a StorageContainer that conform to a search pattern.
	 * 
	 * @param searchPattern
	 * A search pattern. Both single-character ("?") and multicharacter ("*") wildcards are supported.
	 */
	public String[] GetDirectoryNames(String searchPattern)
	{
		throw new NotImplementedException();
	}

	/**
	 * Enumerates the directories in the root of a StorageContainer.
	 */
	public String[] GetDirectoryNames()
	{
		return this.GetDirectoryNames("*");
	}

	/**
	 * Enumerates files in the root directory of a StorageContainer that match a given pattern.
	 * 
	 * @param searchPattern
	 * A search pattern. Both single-character ("?") and multicharacter ("*") wildcards are supported.
	 */
	public String[] GetFileNames(String searchPattern)
	{
		throw new NotImplementedException();
	}

	/**
	 * Enumerates files in the root directory of a StorageContainer.
	 */
	public String[] GetFileNames()
	{
		return this.GetFileNames("*");
	}
}
