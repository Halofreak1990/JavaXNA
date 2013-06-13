package System.IO;

import java.io.*;
import java.io.IOException;
import java.util.EnumSet;

import System.*;

/**
 * When it is called by an elevated-trust application, exposes a System.IO.Stream around a file, supporting both synchronous and asynchronous read and write operations.
 * 
 * @author Halofreak1990
 */
public class FileStream extends Stream
{
	private String _fileName;
	private FileInputStream _inputStream;
	private FileOutputStream _outputStream;
	
	@Override
	public boolean CanRead()
	{
		return _inputStream != null;
	}

	@Override
	public boolean CanSeek()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CanWrite()
	{
		return _outputStream != null;
	}

	@Override
	public long Length()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getName()
	{
		return _fileName;
	}

	@Override
	public long getPosition()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosition(long value)
	{
		// TODO Auto-generated method stub

	}
	
	protected FileStream()
	{
		
	}
	
	/**
	 * When it is called by trusted applications, initializes a new instance of the System.IO.FileStream class with the specified path and creation mode.
	 * 
	 * @param path
	 * A relative or absolute path for the file that the current FileStream object will encapsulate.
	 * 
	 * @param mode
	 * A System.IO.FileMode constant that determines how to open or create the file.
	 * 
	 * @exception System.ArgumentException
	 * path is an empty string (""), contains only white space, or contains one or more invalid characters. -or-path refers to a non-file device, such as "con:", "com1:", "lpt1:", etc. in an NTFS environment.
	 * 
	 * @exception System.NotSupportedException
	 * path refers to a non-file device, such as "con:", "com1:", "lpt1:", etc. in a non-NTFS environment.
	 * 
	 * @exception System.ArgumentNullException
	 * path is null.
	 * 
	 * @exception System.Security.SecurityException
	 * The caller does not have the required permission.
	 * 
	 * @exception System.IO.FileNotFoundException
	 * The file cannot be found, such as when mode is FileMode.Truncate or FileMode.Open, and the file specified by path does not exist. The file must already exist in these modes.
	 * 
	 * @exception System.IO.IOException
	 * An I/O error occurs, such as specifying FileMode.CreateNew and the file specified by path already exists.-or-The stream has been closed.
	 * 
	 * @exception System.IO.PathTooLongException
	 * The specified path, file name, or both exceed the system-defined maximum length. For example, on Windows-based platforms, paths must be less than 248 characters, and file names must be less than 260 characters.
	 */
	public FileStream(String path, FileMode mode)
	{
		this(path,
			 mode,
			 (mode == FileMode.Append) ? EnumSet.of(FileAccess.Write) : EnumSet.of(FileAccess.ReadWrite),
			 EnumSet.of(FileShare.Read),
			 0x1000);
	}
	
	/**
	 * When it is called by trusted applications, initializes a new instance of the System.IO.FileStream class with the specified path, creation mode, and read/write permission.
	 * 
	 * @param path
	 * @param mode
	 * @param access
	 */
	public FileStream(String path, FileMode mode, EnumSet<FileAccess> access)
	{
		this(path, mode, access, EnumSet.of(FileShare.Read), 0x1000);
	}
	
	/**
	 * 
	 * @param path
	 * @param mode
	 * @param access
	 * @param share
	 */
	public FileStream(String path, FileMode mode, EnumSet<FileAccess> access, EnumSet<FileShare> share)
	{
		this(path, mode, access, share, 0x1000);
	}
	
	/**
	 * 
	 * @param path
	 * @param mode
	 * @param access
	 * @param share
	 * @param bufferSize
	 */
	public FileStream(String path, FileMode mode, EnumSet<FileAccess> access, EnumSet<FileShare> share, int bufferSize)
	{
		switch (mode)
		{
		case Append:
			try
			{
				_outputStream = new FileOutputStream(path, true);
			}
			catch (Exception ex)
			{
				if (ex instanceof java.io.FileNotFoundException)
					throw new FileNotFoundException("", path, ex);
			}
			break;
		case Create:
			
			break;
		case CreateNew:
			try
			{
				_outputStream = new FileOutputStream(path, false);
			}
			catch (java.io.FileNotFoundException ex)
			{
				throw new FileNotFoundException("", path, ex);
			}
			break;
		case Open:
			break;
		case OpenOrCreate:
			break;
		case Truncate:
			try
			{
				_outputStream = new FileOutputStream(path, false);
			}
			catch (java.io.FileNotFoundException ex)
			{
				throw new FileNotFoundException("", path, ex);
			}
			break;
		}
	}
	
	/**
	 * Ensures that resources are freed and other cleanup operations are performed when the garbage collector reclaims the FileStream.
	 */
	protected void finalize()
	{
		
	}

	@Override
	public void Flush()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public int Read(byte[] buffer, int offset, int count)
	{
		try
		{
			return _inputStream.read(buffer, offset, count);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public long Seek(long offset, SeekOrigin origin)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void SetLength(long value)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param buffer
	 * 
	 * @param offset
	 * 
	 * @param count
	 * 
	 * @throws System.ArgumentNullException
	 * buffer is null.
	 * 
	 * @throws System.ArgumentOutOfRangeException
	 * 
	 */
	@Override
	public void Write(byte[] buffer, int offset, int count)
	{
		if (buffer == null)
			throw new ArgumentNullException("buffer", "Buffer cannot be null.");
		
		if (offset < 0)
			throw new ArgumentOutOfRangeException("offset", "Non-negative number required.");
		
		if (count < 0)
			throw new ArgumentOutOfRangeException("count", "Non-negative number required.");
		
		if (!CanWrite())
		{
			throw new InvalidOperationException("Stream is not writable.");
		}
		
		// TODO Auto-generated method stub
		try
		{
			_outputStream.write(buffer, offset, count);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
