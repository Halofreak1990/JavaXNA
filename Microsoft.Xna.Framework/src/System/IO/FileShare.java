package System.IO;

/**
 * Contains constants for controlling the kind of access other System.IO.IsolatedStorage.IsolatedStorageFileStream objects can have to the same file.
 * 
 * @author Halofreak1990
 */
public enum FileShare
{
	/**
	 * Allows subsequent deleting of a file.
	 */
	Delete, // (4)
	/**
	 * Makes the file handle inheritable by child processes.
	 */
	Inheritable, // (16)
	/**
	 * Declines sharing of the current file. Any request to open the file (by this process or another process) will fail until the file is closed.
	 */
	None, // (0)
	/**
	 * Allows subsequent opening of the file for reading. If this flag is not specified, any request to open the file for reading (by this process or another process) will fail until the file is closed.
	 */
	Read, // (1)
	/**
	 * Allows subsequent opening of the file for reading or writing. If this flag is not specified, any request to open the file for reading or writing (by this process or another process) will fail until the file is closed.
	 */
	ReadWrite, // (3)
	/**
	 * Allows subsequent opening of the file for writing. If this flag is not specified, any request to open the file for writing (by this process or another process) will fail until the file is closed.
	 */
	Write // (2)
}
