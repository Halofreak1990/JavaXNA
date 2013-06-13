package System.IO.IsolatedStorage;

import java.io.*;
import java.util.EnumSet;

import System.*;
import System.IO.*;

/**
 * 
 * 
 * @author Halofreak1990
 */
public class IsolatedStorageFileStream extends FileStream
{
	private FileStream m_fileStream;
	private IsolatedStorageFile m_isf;
	
	/**
	 * 
	 * @param path
	 * @param mode
	 * @param access
	 * @param share
	 * @param isf
	 */
	public IsolatedStorageFileStream(String path, FileMode mode, EnumSet<FileAccess> access, EnumSet<FileShare> share, IsolatedStorageFile isf)
	{
		if (path == null)
			throw new IsolatedStorageException();
		
		if (isf == null)
			throw new IsolatedStorageException();
		
		// strip all leading ../ or ..\ from path to prevent programmers from being clever and going outside the IsolatedStorage area.
		path.replaceAll("", "");
		
		// TODO: implement
	}
	
	/**
	 * 
	 * @param path
	 * @param mode
	 * @param access
	 * @param isf
	 */
	public IsolatedStorageFileStream(String path, FileMode mode, EnumSet<FileAccess> access, IsolatedStorageFile isf)
	{
		this(path, mode, access, EnumSet.of(FileShare.None), isf);
	}
	
	/**
	 * Initializes a new instance of the System.IO.IsolatedStorage.IsolatedStorageFileStream class giving access to the file designated by path, in the specified mode, and in the context of the System.IO.IsolatedStorage.IsolatedStorageFile specified by isf.
	 * 
	 * @param path
	 * The relative path of the file within isolated storage.
	 * 
	 * @param mode
	 * One of the System.IO.FileMode values.
	 * 
	 * @param isf
	 * The System.IO.IsolatedStorage.IsolatedStorageFile in which to open the System.IO.IsolatedStorage.IsolatedStorageFileStream.
	 * 
	 * @exception System.IO.IsolatedStorage.IsolatedStorageException
	 * isf has been disposed. -or-path is badly formed.-or-path is null. -or-isf is null.-orThe directory in path does not exist.-or-No file was found and the mode is set to System.IO.FileMode.Open.
	 */
	public IsolatedStorageFileStream(String path, FileMode mode, IsolatedStorageFile isf)
	{
		this(path, mode, EnumSet.of((mode == FileMode.Append) ? FileAccess.Write : FileAccess.ReadWrite), EnumSet.of(FileShare.None), isf);
	}
	
	/**
	 * Begins an asynchronous read.
	 * 
	 * @param buffer
	 * The buffer to read data into.
	 * 
	 * @param offset
	 * The byte offset in buffer at which to begin reading.
	 * 
	 * @param numBytes
	 * The maximum number of bytes to read.
	 * 
	 * @param userCallback
	 * The method to call when the asynchronous read operation is completed. This parameter is optional.
	 * 
	 * @param stateObject
	 * The status of the asynchronous read.
	 * 
	 * @return
	 * An IAsyncResult object that represents the asynchronous read, which is possibly still pending. This IAsyncResult must be passed to this stream's EndRead method to determine how many bytes were read. This can be done either by the same code that called BeginRead or in a callback passed to BeginRead.
	 * 
	 * @exception System.IO.IOException
	 * An asynchronous read was attempted past the end of the file.
	 */
	@Override
	public IAsyncResult BeginRead(byte[] buffer, int offset, int numBytes, AsyncCallback userCallback, Object stateObject)
	{
	    return this.m_fileStream.BeginRead(buffer, offset, numBytes, userCallback, stateObject);
	}
	
	/**
	 * Begins an asynchronous write.
	 * 
	 * @param buffer
	 * The buffer to write data to.
	 * 
	 * @param offset
	 * The byte offset in buffer at which to begin writing.
	 * 
	 * @param numBytes
	 * The maximum number of bytes to write.
	 * 
	 * @param userCallback
	 * The method to call when the asynchronous write operation is completed. This parameter is optional.
	 * 
	 * @param stateObject
	 * The status of the asynchronous write.
	 * 
	 * @return
	 * An IAsyncResult that represents the asynchronous write, which is possibly still pending. This IAsyncResult must be passed to this stream's EndWrite method to ensure that the write is complete, then frees resources appropriately. This can be done either by the same code that called BeginWrite or in a callback passed to BeginWrite.
	 * 
	 * @exception System.IO.IOException
	 * An asynchronous read was attempted past the end of the file.
	 */
	public IAsyncResult BeginWrite(byte[] buffer, int offset, int numBytes, AsyncCallback userCallback, Object stateObject)
	{
		IAsyncResult result;
		try
		{
			try
			{
				result = this.m_fileStream.BeginWrite(buffer, offset, numBytes, userCallback, stateObject);
			}
			catch (RuntimeException ex)
			{
				throw ex;
			}
			return result;
		}
		finally
		{
			
		}
	}
	
	/**
	 * Ends a pending asynchronous read request.
	 * 
	 * @param asyncResult
	 * The pending asynchronous request.
	 * 
	 * @return
	 * The number of bytes read from the stream, between zero and the number of requested bytes. Streams will only return zero at the end of the stream. Otherwise, they will block until at least one byte is available.
	 * 
	 * @exception System.ArgumentNullException
	 * The asyncResult is null.
	 */
	@Override
	public int EndRead(IAsyncResult asyncResult)
	{
	    return this.m_fileStream.EndRead(asyncResult);
	}
	
	/**
	 * Ends an asynchronous write.
	 * 
	 * @param asyncResult
	 * The pending asynchronous I/O request to end.
	 * 
	 * @exception System.ArgumentNullException
	 * The asyncResult parameter is null.
	 */
	@Override
	public void EndWrite(IAsyncResult asyncResult)
	{
	    this.m_fileStream.EndWrite(asyncResult);
	}
	
	/**
	 * Updates the file with the current state of the buffer then clears the buffer.
	 */
	@Override
	public void Flush()
	{
	    this.m_fileStream.Flush();
	}
	
	/**
	 * Copies bytes from the current buffered IsolatedStorageFileStream object to an array.
	 * 
	 * @param buffer
	 * The buffer to read.
	 * 
	 * @param offset
	 * The offset in the buffer at which to begin writing. 
	 * 
	 * @param count
	 * The maximum number of bytes to read.
	 * 
	 * @return
	 * The total number of bytes read into the buffer. This can be less than the number of bytes requested if that many bytes are not currently available, or zero if the end of the stream is reached.
	 */
	@Override
	public int Read(byte[] buffer, int offset, int count)
	{
	    return this.m_fileStream.Read(buffer, offset, count);
	}
	
	/**
	 * Reads a single byte from the IsolatedStorageFileStream object in isolated storage.
	 * 
	 * @return
	 * The 8-bit unsigned integer value read from the isolated storage file.
	 */
	@Override
	public int ReadByte()
	{
	    return this.m_fileStream.ReadByte();
	}
	
	/**
	 * @param offset
	 * @param origin
	 * 
	 * @return
	 * 
	 */
	@Override
	public long Seek(long offset, SeekOrigin origin)
	{
		return this.m_fileStream.Seek(offset, origin);
	}
	
	/**
	 * Sets the length of this IsolatedStorageFileStream object to the specified value.
	 * 
	 * @param value
	 * The new length of the IsolatedStorageFileStream object.
	 */
	@Override
	public void SetLength(long value)
	{
	    if (value < 0L)
	    {
	        throw new ArgumentOutOfRangeException("value", "Non-negative number required.");
	    }

	    throw new NotImplementedException();
	}
	
	/**
	 * Writes a block of bytes to the IsolatedStorageFileStream object using data read from a byte array.
	 * 
	 * @param buffer
	 * The buffer to write. 
	 * 
	 * @param offset
	 * The byte offset in buffer from which to begin.
	 * 
	 * @param count
	 * The maximum number of bytes to write.
	 * 
	 * @exception System.ArgumentNullException
	 * buffer is null.
	 * 
	 * @exception System.IO.IsolatedStorage.IsolatedStorageException
	 * The write attempt exceeds the quota for the IsolatedStorageFileStream object.
	 */
	public void Write(byte[] buffer, int offset, int count)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Writes a single byte to the IsolatedStorageFileStream object.
	 * 
	 * @param value
	 * The byte value to write to the isolated storage file.
	 * 
	 * @exception System.IO.IsolatedStorage.IsolatedStorageException
	 * The write attempt exceeds the quota for the IsolatedStorageFileStream object.
	 */
	@Override
	public void WriteByte(byte value)
	{
		byte[] buf = new byte[] { value };
		
		Write(buf, 0, 1);
	}
}
