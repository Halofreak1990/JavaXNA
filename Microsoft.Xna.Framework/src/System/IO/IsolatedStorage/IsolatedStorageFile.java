package System.IO.IsolatedStorage;

import java.io.*;

import System.*;
import System.IO.*;

/**
 * 
 * @author Halofreak190
 */
public final class IsolatedStorageFile
{
	/**
	 * 
	 */
	protected void finalize()
	{
		
	}
	
	/**
	 * Closes a store previously opened with System.IO.IsolatedStorage.IsolatedStorageFile.GetStore(System.IO.IsolatedStorage.IsolatedStorageScope,System.Type,System.Type), System.IO.IsolatedStorage.IsolatedStorageFile.GetUserStoreForAssembly(), or System.IO.IsolatedStorage.IsolatedStorageFile.GetUserStoreForDomain().
	 */
	public void Close()
	{
		
	}
	
	/**
	 * 
	 * @param dir
	 */
	public void CreateDirectory(String dir)
	{
		// TODO: strip all leading ../ or ..\ from path to prevent programmers from being clever and going outside the IsolatedStorage area.
		
		File f = new File(dir);
		f.mkdirs();
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public IsolatedStorageFileStream CreateFile(String path)
	{
		// TODO: strip all leading ../ or ..\ from path to prevent programmers from being clever and going outside the IsolatedStorage area.
		
		return new IsolatedStorageFileStream(path, FileMode.Create, this);
	}
	
	/**
	 * Deletes a file in the isolated store.
	 * 
	 * @param file
	 * The relative path of the file to delete within the isolated store.
	 * 
	 * @exception System.IO.IsolatedStorage.IsolatedStorageException
	 * The store has been removed.-or-Unable to delete the file. -or-Isolated storage is disabled.
	 * 
	 * @exception System.ArgumentException
	 * file is badly formed.
	 * 
	 * @exception System.ArgumentNullException
	 * file is null.
	 * 
	 * @exception System.ObjectDisposedException
	 * The store has been disposed.
	 */
	public void DeleteFile(String file)
	{
		if (file == null)
			throw new ArgumentNullException("file");
		
		// TODO: implement the remaining checks
		
		// TODO: strip all leading ../ or ..\ from path to prevent programmers from being clever and going outside the IsolatedStorage area.
		
		File f = new File(file);
		
		if (!f.delete())
			throw new IsolatedStorageException();
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public boolean FileExists(String path)
	{
		// TODO: strip all leading ../ or ..\ from path to prevent programmers from being clever and going outside the IsolatedStorage area.
		File f = new File(path);
		return f.exists();
	}
	
	/**
	 * Copies an existing file to a new file, and optionally overwrites an existing file.
	 * 
	 * @param sourceFileName
	 * The name of the file to copy.
	 * 
	 * @param destinationFileName
	 * The name of the destination file. This cannot be a directory.
	 * 
	 * @param overwrite
	 * true if the destination file can be overwritten; otherwise, false.
	 * 
	 * @exception System.ArgumentException
	 * sourceFileName or destinationFileName is a zero-length string, contains only white space, or contains one or more invalid characters defined by the System.IO.Path.GetInvalidPathChars() method.
	 * 
	 * @exception System.ArgumentNullException
	 * sourceFileName or destinationFileName is null.
	 * 
	 * @exception System.InvalidOperationException
	 * The isolated store has been closed.
	 */
	public void CopyFile(String sourceFileName, String destinationFileName, boolean overwrite)
	{
		if (sourceFileName == null)
			throw new ArgumentNullException("sourceFileName");
		
		if (destinationFileName == null)
			throw new ArgumentNullException("destinationFileName");
		
		throw new NotImplementedException();
	}
	
	/**
	 * Obtains user-scoped isolated storage corresponding to the calling code's application identity.
	 * 
	 * @return
	 * An System.IO.IsolatedStorage.IsolatedStorageFile object corresponding to the isolated storage scope based on the calling code's assembly identity.
	 */
	public static IsolatedStorageFile GetUserStoreForApplication()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Moves a specified directory and its contents to a new location.
	 * 
	 * @param sourceDirectoryName
	 * The name of the directory to move.
	 * 
	 * @param destinationDirectoryName
	 * The path to the new location for sourceDirectoryName. This cannot be the path to an existing directory.
	 * 
	 * @exception System.ArgumentException
	 * sourceFileName or destinationFileName is a zero-length string, contains only white space, or contains one or more invalid characters defined by the System.IO.Path.GetInvalidPathChars() method.
	 * 
	 * @exception System.ArgumentNullException
	 * sourceFileName or destinationFileName is null.
	 * 
	 * @exception System.InvalidOperationException
	 * The isolated store has been closed.
	 * 
	 * @exception System.ObjectDisposedException
	 * The isolated store has been disposed.
	 * 
	 * @exception System.DirectoryNotFoundException
	 * sourceDirectoryName does not exist.
	 */
	public void MoveDirectory(String sourceDirectoryName, String destinationDirectoryName)
	{
		if (sourceDirectoryName == null)
			throw new ArgumentNullException("sourceDirectoryName");
		
		if (destinationDirectoryName == null)
			throw new ArgumentNullException("destinationDirectoryName");
		
		throw new NotImplementedException();
	}
	
	/**
	 * Moves a specified file to a new location, and optionally lets you specify a new file name.
	 * 
	 * @param sourceFileName
	 * The name of the file to move.
	 * 
	 * @param destinationFileName
	 * The path to the new location for the file. If a file name is included, the moved file will have that name.
	 */
	public void MoveFile(String sourceFileName, String destinationFileName)
	{
	}
	
	/**
	 * 
	 * @param path
	 * @param mode
	 * @return
	 */
	public IsolatedStorageFileStream OpenFile(String path, FileMode mode)
	{
		return new IsolatedStorageFileStream(path, mode, this);
	}

	/**
	 * Removes the isolated storage scope and all its contents.
	 * 
	 * @exception System.IO.IsolatedStorage.IsolatedStorageException
	 * The isolated store cannot be deleted.
	 */
	public void Remove()
	{
		// TODO Auto-generated method stub	
	}
}
