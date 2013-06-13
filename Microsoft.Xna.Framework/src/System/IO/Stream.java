package System.IO;

import System.*;

/**
 * Provides a generic view of a sequence of bytes.
 * 
 * @author Halofreak1990
 */
public abstract class Stream implements IDisposable
{
	/**
	 * When overridden in a derived class, gets a value indicating whether the current stream supports reading.
	 * 
	 * @return
	 * true if the stream supports reading; otherwise, false.
	 */
	public abstract boolean CanRead();
	
	/**
	 * When overridden in a derived class, gets a value indicating whether the current stream supports seeking.
	 * 
	 * @return
	 * true if the stream supports seeking; otherwise, false.
	 */
    public abstract boolean CanSeek();
    
    /**
     * Gets a value that determines whether the current stream can time out.
     * 
     * @return
     * A value that determines whether the current stream can time out.
     */
    public boolean CanTimeout()
    {
    	return false;
    }
    
    /**
     * When overridden in a derived class, gets a value indicating whether the current stream supports writing.
     * 
     * @return
     * true if the stream supports writing; otherwise, false.
     */
    public abstract boolean CanWrite();
    
    /**
     * When overridden in a derived class, gets the length in bytes of the stream.
     * 
     * @return
     * A long value representing the length of the stream in bytes.
     * 
     * @throws System.NotSupportedException
     * A class derived from Stream does not support seeking.
     * 
     * @throws System.ObjectDisposedException
     * Methods were called after the stream was closed.
     */
    public abstract long Length();
    
    /**
     * A Stream with no backing store.
     */
    public static final NullStream Null = new NullStream();
    
    /**
     * When overridden in a derived class, gets the position within the current stream.
     * 
     * @return
     * The current position within the stream.
     */
    public abstract long getPosition();
    
    /**
     * When overridden in a derived class, sets the position within the current stream.
     * 
     * @param value
     * The new position within the stream.
     */
    public abstract void setPosition(long value);

    /**
     * Initializes a new instance of the System.IO.Stream class.
     */
    protected Stream()
    {
    }
    
    /**
     * Begins an asynchronous read operation.
     * 
     * @param buffer
     * The buffer to read the data into.
     * 
     * @param offset
     * The byte offset in buffer at which to begin writing data read from the stream.
     * 
     * @param count
     * The maximum number of bytes to read.
     * 
     * @param callback
     * An optional asynchronous callback, to be called when the read is complete.
     * 
     * @param state
     * A user-provided object that distinguishes this particular asynchronous read request from other requests.
     * 
     * @return
     * An System.IAsyncResult that represents the asynchronous read, which could still be pending.
     * 
     * @throws System.IO.IOException
     * Attempted an asynchronous read past the end of the stream, or a disk error occurs.
     * 
     * @throws System.ArgumentException
     * One or more of the arguments is invalid.
     * 
     * @throws System.ObjectDisposedException
     * Methods were called after the stream was closed.
     * 
     * @throws System.NotSupportedException
     * The current Stream implementation does not support the read operation.
     */
    public IAsyncResult BeginRead(byte[] buffer, int offset, int count, AsyncCallback callback, Object state)
    {
    	if (offset + count > buffer.length)
    		throw new ArgumentException();
    	
    	throw new NotImplementedException();
    }
    
    /**
     * Begins an asynchronous write operation.
     * 
     * @param buffer
     * The buffer to write data from.
     * 
     * @param offset
     * The byte offset in buffer from which to begin writing.
     * 
     * @param count
     * The maximum number of bytes to write.
     * 
     * @param callback
     * An optional asynchronous callback, to be called when the write is complete.
     * 
     * @param state
     * A user-provided object that distinguishes this particular asynchronous write request from other requests.
     * 
     * @return
     * An IAsyncResult that represents the asynchronous write, which could still be pending.
     * 
     * @throws System.IO.IOException
     * Attempted an asynchronous write past the end of the stream, or a disk error occurs.
     * 
     * @throws System.ArgumentException
     * One or more of the arguments is invalid.
     * 
     * @throws System.ObjectDisposedException
     * Methods were called after the stream was closed.
     * 
     * @throws System.NotSupportedException
     * The current Stream implementation does not support the write operation.
     */
    public IAsyncResult BeginWrite(byte[] buffer, int offset, int count, AsyncCallback callback, Object state)
    {
    	if (!this.CanWrite())
    		throw new NotSupportedException("Stream does not support writing.");
    	
    	throw new NotImplementedException();
    }
    
    /**
     * Closes the current stream and releases any resources (such as sockets and file handles) associated with the current stream.
     */
    public void Close()
    {
    	this.Dispose(true);
    }
    
    /**
     * Releases all resources used by the System.IO.Stream.
     */
	@Override
	public void Dispose()
	{
		Dispose(true);
	}
	
	/**
	 * Releases the unmanaged resources used by the System.IO.Stream and optionally releases the managed resources.
	 * 
	 * @param disposing
	 * true to release both managed and unmanaged resources; false to release only unmanaged resources.
	 */
	protected void Dispose(boolean disposing)
	{
		
	}
	
	/**
	 * Waits for the pending asynchronous read to complete.
	 * 
	 * @param asyncResult
	 * The reference to the pending asynchronous request to finish.
	 * 
	 * @return
	 * The number of bytes read from the stream, between zero (0) and the number of bytes you requested.
	 * Streams return zero (0) only at the end of the stream, otherwise, they should block until at least one byte is
	 * available.
	 */
    public int EndRead(IAsyncResult asyncResult)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * Ends an asynchronous write operation.
     * 
     * @param asyncResult
     * The reference to the pending asynchronous request to finish.
     * 
     * @throws System.ArgumentNullException
     * asyncResult is null.
     * 
     * @throws System.ArgumentException
     * asyncResult did not originate from a System.IO.Stream.BeginWrite(System.Byte[],System.Int32,System.Int32,System.AsyncCallback,System.Object) method on the current stream.
     * 
     * @throws System.IO.IOException
     * The stream is closed or an internal error has occurred.
     */
    public void EndWrite(IAsyncResult asyncResult)
    {
    	if (asyncResult == null)
    		throw new ArgumentNullException("asyncResult");
    	
    	throw new NotImplementedException();
    }
    
    /**
     * When overridden in a derived class, clears all buffers for this stream and causes any buffered data to be written to the underlying device.
     * 
     * @throws System.IO.IOException
     * An I/O error occurs.
     */
    public abstract void Flush();
    
    /**
     * When overridden in a derived class, reads a sequence of bytes from the current stream and advances the position within the stream by the number of bytes read.
     * 
     * @param buffer
     * An array of bytes. When this method returns, the buffer contains the specified byte array with the values between offset and (offset + count - 1) replaced by the bytes read from the current source.
     * 
     * @param offset
     * The zero-based byte offset in buffer at which to begin storing the data read from the current stream.
     * 
     * @param count
     * The maximum number of bytes to be read from the current stream.
     * 
     * @return
     * The total number of bytes read into the buffer. This can be less than the number of bytes requested if that many bytes are not currently available, or zero (0) if the end of the stream has been reached.
     * 
     * @throws System.ArgumentException
     * The sum of offset and count is larger than the buffer length.
     * 
     * @throws System.ArgumentNullException
     * buffer is null.
     * 
     * @throws System.ArgumentOutOfRangeException
     * offset or count is negative.
     * 
     * @throws System.IO.IOException
     * An I/O error occurs.
     * 
     * @throws System.NotSupportedException
     * The stream does not support reading.
     * 
     * @throws System.ObjectDisposedException
     * Methods were called after the stream was closed.
     */
    public abstract int Read(byte[] buffer, int offset, int count);
    
    /**
     * Reads a byte from the stream and advances the position within the stream by one byte, or returns -1 if at the end of the stream.
     * 
     * @return
     * The unsigned byte cast to an Int32, or -1 if at the end of the stream.
     * 
     * @throws System.NotSupportedException
     * The stream does not support reading.
     * 
     * @throws System.ObjectDisposedException
     * Methods were called after the stream was closed.
     */
    public int ReadByte()
    {
    	byte[] buffer = new byte[1];
        if (this.Read(buffer, 0, 1) == 0)
        {
            return -1;
        }
        return buffer[0];
    }
    
    /**
     * When overridden in a derived class, sets the position within the current stream.
     * 
     * @param offset
     * A byte offset relative to the origin parameter.
     * 
     * @param origin
     * A value of type System.IO.SeekOrigin indicating the reference point used to obtain the new position.
     * 
     * @return
     * The new position within the current stream.
     * 
     * @throws System.IO.IOException
     * An I/O error occurs.
     * 
     * @throws System.NotSupportedException
     * The stream does not support seeking, such as if the stream is constructed from a pipe or console output.
     * 
     * @throws System.ObjectDisposedException
     * Methods were called after the stream was closed.
     */
    public abstract long Seek(long offset, SeekOrigin origin);
    
    /**
     * When overridden in a derived class, sets the length of the current stream.
     * 
     * @param value
     * The desired length of the current stream in bytes.
     * 
     * @throws System.IO.IOException
     * An I/O error occurs.
     * 
     * @throws System.NotSupportedException
     * The stream does not support both writing and seeking, such as if the stream is constructed from a pipe or console output.
     * 
     * @throws System.ObjectDisposedException
     * Methods were called after the stream was closed.
     */
    public abstract void SetLength(long value);
    
    /**
     * When overridden in a derived class, writes a sequence of bytes to the current stream and advances the current position within this stream by the number of bytes written.
     * 
     * @param buffer
     * An array of bytes. This method copies count bytes from buffer to the current stream.
     * 
     * @param offset
     * The zero-based byte offset in buffer at which to begin copying bytes to the current stream.
     * 
     * @param count
     * The number of bytes to be written to the current stream.
     */
    public abstract void Write(byte[] buffer, int offset, int count);
    
    /**
     * Writes a byte to the current position in the stream and advances the position within the stream by one byte.
     * 
     * @param value
     * The byte to write to the stream.
     * 
     * @throws System.IO.IOException
     * An I/O error occurs.
     * 
     * @throws System.NotSupportedException
     * The stream does not support writing, or the stream is already closed.
     */
    public void WriteByte(byte value)
    {
    	byte[] buffer = new byte[] { value };
        this.Write(buffer, 0, 1);
    }
}

final class NullStream extends Stream
{
    NullStream()
    {
    }

    @Override
    public void Flush()
    {
    }

    @Override
    public int Read(byte[] buffer, int offset, int count)
    {
        return 0;
    }

    @Override
    public int ReadByte()
    {
        return -1;
    }

    @Override
    public long Seek(long offset, SeekOrigin origin)
    {
        return 0L;
    }

    @Override
    public void SetLength(long length)
    {
    }

    @Override
    public void Write(byte[] buffer, int offset, int count)
    {
    }

    @Override
    public void WriteByte(byte value)
    {
    }

    @Override
    public boolean CanRead()
    {
        return true;
    }

    @Override
    public boolean CanSeek()
    {
        return true;
    }

    @Override
    public boolean CanWrite()
    {
        return true;
    }

    @Override
    public long Length()
    {
        return 0L;
    }

    @Override
    public long getPosition()
    {
        return 0L;
    }
    
    @Override
    public void setPosition(long value)
    {
    }
}
