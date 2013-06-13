package System.IO;

/**
 * Defines constants for read, write, or read/write access to a file.
 * 
 * @author Halofreak1990
 */
public enum FileAccess
{
	/**
	 * Read access to the file. Data can be read from the file. Combine with Write for read/write access.
	 */
	Read, // (1)
	/**
	 * Read and write access to the file. Data can be written to and read from the file.
	 */
	ReadWrite, // (3)
	/**
	 * Write access to the file. Data can be written to the file. Combine with Read for read/write access.
	 */
	Write // (2)
}
