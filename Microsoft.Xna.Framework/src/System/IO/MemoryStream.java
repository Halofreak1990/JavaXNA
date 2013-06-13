package System.IO;

import java.io.*;
import java.util.Arrays;

import System.*;

/**
 * Defines a stream whose backing store is memory.
 * 
 * @author Halofreak1990
 */
public class MemoryStream extends Stream
{
	private byte[] m_buffer;
	private int length;
	private int _capacity;
	private boolean _expandable;
	private boolean _writable;
	private boolean _exposable;
	private int _origin;
	private boolean _isOpen;
	private int _position;
	
	/**
	 * 
	 */
	@Override
	public boolean CanRead()
	{
		return _isOpen;
	}

	/**
	 * 
	 */
	@Override
	public boolean CanSeek()
	{
		return _isOpen;
	}

	/**
	 * 
	 */
	@Override
	public boolean CanWrite()
	{
		return _writable;
	}
	
	/**
	 * Gets the number of bytes allocated for this stream.
	 * 
	 * @return
	 * The length of the usable portion of the buffer for the stream.
	 * 
	 * @throws ObjectDisposedException
	 * The current stream is closed.
	 */
	public int getCapacity()
	{
		if (!this._isOpen)
            throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
        return (this._capacity - this._origin);
	}
	
	/**
	 * Sets the number of bytes allocated for this stream.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * A capacity is set that is negative or less than the current length of the stream.
	 * 
	 * @throws ObjectDisposedException
	 * The current stream is closed.
	 * 
	 * @throws NotSupportedException
	 * set is invoked on a stream whose capacity cannot be modified.
	 */
	public void setCapacity(int value)
	{
		if (!this._isOpen)
            throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
        if (value != this._capacity)
        {
            if (!this._expandable)
                throw new NotSupportedException("Memory stream is not expandable.");
            
            if (value < this.length)
                throw new ArgumentOutOfRangeException("value", "capacity was less than the current size.");
            
            if (value > 0)
            {
                byte[] dst = new byte[value];
                if (this.length > 0)
                {
                    System.arraycopy(this.m_buffer, 0, dst, 0, this.length);
                }
                this.m_buffer = dst;
            }
            else
            {
                this.m_buffer = null;
            }
            this._capacity = value;
        }
	}
	
	/**
	 * 
	 */
	@Override
	public long Length()
	{
		return this.length;
	}
	
	/**
	 * Gets the current position within the stream.
	 * 
	 * @return
	 * The current position within the stream.
	 * 
	 * @throws ObjectDisposedException
	 * The stream is closed.
	 */
	@Override
	public long getPosition()
	{
		if (!this._isOpen)
            throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
        return (long) (this._position - this._origin);
	}

	/**
	 * Sets the current position within the stream.
	 * 
	 * @throws ObjectDisposedException
	 * The stream is closed.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * The position is set to a negative value or a value greater than MaxValue.
	 */
	@Override
	public void setPosition(long value)
	{
		if (!this._isOpen)
            throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
		if (value < 0L)
        {
            throw new ArgumentOutOfRangeException("value", "Non-negative number required.");
        }
        if (value > 0x7fffffffL)
        {
            throw new ArgumentOutOfRangeException("value", "MemoryStream length must be non-negative and less than 2^31 - 1 - origin.");
        }
        this._position = this._origin + ((int) value);
	}
	
	/**
	 * Initializes a new instance of the MemoryStream class with an expandable capacity initialized to zero.
	 */
	public MemoryStream()
	{
		this(0);
	}
	
	/**
	 * Initializes a new instance of the MemoryStream class with an expandable capacity initialized as specified.
	 * 
	 * @param capacity
	 * The initial size of the internal array in bytes.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * capacity is negative.
	 */
	public MemoryStream(int capacity)
	{
		if (capacity < 0)
			throw new ArgumentOutOfRangeException("capacity", "Non-negative number required.");
		
		m_buffer = new byte[capacity];
		this._capacity = capacity;
		this._expandable = true;
        this._writable = true;
        this._exposable = true;
        this._origin = 0;
        this._isOpen = true;
	}
	
	/**
	 * Initializes a new non-resizable instance of the MemoryStream class based on the specified byte array.
	 * 
	 * @param buffer
	 * The array of unsigned bytes from which to create the current stream.
	 * 
	 * @throws ArgumentNullException
	 * buffer is null.
	 */
	public MemoryStream(byte[] buffer)
	{
		this(buffer, true);
	}
	
	/**
	 * Initializes a new non-resizable instance of the MemoryStream class based on the specified byte array with the CanWrite property set as specified.
	 * 
	 * @param buffer
	 * The array of unsigned bytes from which to create this stream. 
	 * 
	 * @param writable
	 * The setting of the CanWrite property, which determines whether the stream supports writing.
	 * 
	 * @throws ArgumentNullException
	 * buffer is null.
	 */
	public MemoryStream(byte[] buffer, boolean writable)
	{
		if (buffer == null)
            throw new ArgumentNullException("buffer", "Buffer cannot be null.");
		
        m_buffer = buffer;
        this.length = this._capacity = buffer.length;
        this._writable = writable;
        this._exposable = false;
        this._origin = 0;
        this._isOpen = true;
	}
	
	/**
	 * Initializes a new non-resizable instance of the MemoryStream class based on the specified region (index) of a byte array.
	 * 
	 * @param buffer
	 * The array of unsigned bytes from which to create this stream.
	 * 
	 * @param index
	 * The index into buffer at which the stream begins.
	 * 
	 * @param count
	 * The length of the stream in bytes.
	 * 
	 * @throws ArgumentNullException
	 * buffer is null.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * index or count is less than zero.
	 * 
	 * @throws ArgumentException
	 * The sum of index and count is greater than the length of buffer.
	 */
	public MemoryStream(byte[] buffer, int index, int count)
	{
		this(buffer, index, count, true, false);
	}
	
	/**
	 * Initializes a new non-resizable instance of the MemoryStream class based on the specified region of a byte array, with the CanWrite property set as specified.
	 * 
	 * @param buffer
	 * The array of bytes from which to create this stream.
	 * 
	 * @param index
	 * The index into buffer at which the stream begins.
	 * 
	 * @param count
	 * The length of the stream in bytes. 
	 * 
	 * @param writable
	 * The setting of the CanWrite property, which determines whether the stream supports writing.
	 * 
	 * @throws ArgumentNullException
	 * buffer is null.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * index or count is less than zero.
	 * 
	 * @throws ArgumentException
	 * The sum of index and count is greater than the length of buffer.
	 */
	public MemoryStream(byte[] buffer, int index, int count, boolean writable)
	{
		this(buffer, index, count, writable, false);
	}
	
	/**
	 * Initializes a new non-resizable instance of the MemoryStream class based on the specified region of a byte array, with the CanWrite property set as specified, and the ability to call GetBuffer set as specified.
	 * 
	 * @param buffer
	 * The array of bytes from which to create this stream.
	 * 
	 * @param index
	 * The index into buffer at which the stream begins.
	 * 
	 * @param count
	 * The length of the stream in bytes. 
	 * 
	 * @param writable
	 * The setting of the CanWrite property, which determines whether the stream supports writing.
	 * 
	 * @param publiclyVisible
	 * true to enable GetBuffer, which returns the byte array from which the stream was created; otherwise, false.
	 * 
	 * @throws ArgumentNullException
	 * buffer is null.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * index or count is less than zero.
	 * 
	 * @throws ArgumentException
	 * The sum of index and count is greater than the length of buffer.
	 */
	public MemoryStream(byte[] buffer, int index, int count, boolean writable, boolean publiclyVisible)
	{
		if (buffer == null)
			throw new ArgumentNullException("buffer", "Buffer cannot be null.");
		
		if (index < 0)
			throw new ArgumentOutOfRangeException("index", "Non-negative number required.");
		
		if (count < 0)
			throw new ArgumentOutOfRangeException("count", "Non-negative number required.");
		
		if ((buffer.length - index) < count)
			throw new ArgumentException("Offset and length were out of bounds for the array or count is greater than the number of elements from index to the end of the source collection.");
		
		this.m_buffer = buffer;
		this._origin = this._position = index;
		this.length = this._capacity = index + count;
		this._writable = writable;
		this._exposable = publiclyVisible;
		this._expandable = false;
		this._isOpen = true;
	}

	/**
	 * Releases the unmanaged resources used by the MemoryStream and optionally releases the managed resources.
	 * 
	 * @param disposing
	 * true to release both managed and unmanaged resources; false to release only unmanaged resources.
	 */
	protected void Dispose(boolean disposing)
	{
		try
		{
			if (disposing)
            {
                this._isOpen = false;
                this._writable = false;
                this._expandable = false;
            }
		}
		finally
		{
			super.Dispose(disposing);
		}
	}
	
	private boolean EnsureCapacity(int num)
	{
		if (num < 0)
			throw new IOException("Stream was too long");
		
		if (num <= this._capacity)
			return false;
		
		int value = num;
		if (value < 0x100)
			value = 0x100;
		
		if (value < (this._capacity * 2))
			value = this._capacity * 2;
		
		this.setCapacity(value);
		return true;
	}

	/**
	 * Overrides Flush so that no action is performed.
	 */
	@Override
	public void Flush()
	{
	}
	
	/**
	 * Returns the array of unsigned bytes from which this stream was created.
	 * 
	 * @return
	 * The byte array from which this stream was created, or the underlying array if a byte array was not provided to the MemoryStream constructor during construction of the current instance.
	 * 
	 * @throws UnauthorizedAccessException
	 * The MemoryStream instance was not created with a publicly visible buffer.
	 */
	public byte[] GetBuffer()
	{
	    if (!_exposable)
	        throw new UnauthorizedAccessException("MemoryStream's internal buffer cannot be accessed.");
	    
	    return this.m_buffer;
	}
	
	/**
	 * Reads a byte from the current stream.
	 * 
	 * @return
	 * The byte cast to a Int32, or -1 if the end of the stream has been reached.
	 * 
	 * @throws ObjectDisposedException
	 * The current stream instance is closed.
	 */
	@Override
	public int ReadByte()
	{
		if (!this._isOpen)
			throw new ObjectDisposedException(null, "Cannot access a closed Stream.");

	    if (this._position >= this.length)
	    {
	        return -1;
	    }
	    return m_buffer[this._position++];
	}

	/**
	 * Reads a block of bytes from the current stream and writes the data to buffer.
	 * 
	 * @param buffer
	 * When this method returns, contains the specified byte array with the values between offset and (offset + count - 1) replaced by the characters read from the current stream.
	 * 
	 * @param offset
	 * The byte offset in buffer at which to begin reading.
	 * 
	 * @param count
	 * The maximum number of bytes to read.
	 * 
	 * @return
	 * The total number of bytes written into the buffer. This can be less than the number of bytes requested if that number of bytes are not currently available, or zero if the end of the stream is reached before any bytes are read.
	 * 
	 * @throws ObjectDisposedException
	 * The current stream instance is closed.
	 * 
	 * @throws ArgumentNullException
	 * buffer is null.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * offset or count is negative.
	 * 
	 * @throws ArgumentException
	 * offset subtracted from the buffer length is less than count.
	 */
	@Override
	public int Read(byte[] buffer, int offset, int count)
	{
		if (!this._isOpen)
			throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
		if (buffer == null)
			throw new ArgumentNullException("buffer", "Buffer cannot be null.");
		
		if (offset < 0)
			throw new ArgumentOutOfRangeException("offset", "Non-negative number required.");
		
		if (count < 0)
			throw new ArgumentOutOfRangeException("count", "Non-negative number required.");
		
		if ((buffer.length - offset) < count)
	        throw new ArgumentException("Offset and length were out of bounds for the array or count is greater than the number of elements from index to the end of the source collection.");
	        
	    int num = this.length - this._position;
	    if (num > count)
	    {
	        num = count;
	    }
	    if (num <= 0)
	    {
	        return 0;
	    }
	    if (num <= 8)
	    {
	        int num2 = num;
	        while (--num2 >= 0)
	        {
	            buffer[offset + num2] = this.m_buffer[this._position + num2];
	        }
	    }
	    else
	    {
	        System.arraycopy(this.m_buffer, this._position, buffer, offset, num);
	    }
	    this._position += num;
	    return num;
	}

	/**
	 * Sets the position within the current stream to the specified value.
	 * 
	 * @param offset
	 * The new position within the stream. This is relative to the origin parameter, and can be positive or negative.
	 * 
	 * @param origin
	 * A value of type SeekOrigin, which acts as the seek reference point.
	 * 
	 * @return
	 * The new position within the stream, calculated by combining the initial reference point and the offset.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * offset is greater than MaxValue.
	 * 
	 * @throws ObjectDisposedException
	 * The current stream instance is closed.
	 * 
	 * @throws IOException
	 * Seeking is attempted before the beginning of the stream.
	 * 
	 * @throws ArgumentException
	 * 
	 */
	@Override
	public long Seek(long offset, SeekOrigin origin)
	{
		if (!this._isOpen)
			throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
		if (offset > 0x7fffffffL)
	        throw new ArgumentOutOfRangeException("offset", "MemoryStream length must be non-negative and less than 2^31 - 1 - origin.");
		
		switch (origin)
	    {
        case Begin:
            if (offset < 0L)
            {
                throw new IOException("An attempt was made to move the position before the beginning of the stream.");
            }
            this._position = this._origin + ((int) offset);
            break;

        case Current:
            if ((offset + this._position) < this._origin)
            {
                throw new IOException("An attempt was made to move the position before the beginning of the stream.");
            }
            this._position += (int) offset;
            break;

        case End:
            if ((this.length + offset) < this._origin)
            {
                throw new IOException("An attempt was made to move the position before the beginning of the stream.");
            }
            this._position = this.length + ((int) offset);
            break;

        default:
            throw new ArgumentException("Invalid seek origin.");
	    }
	    return (long) this._position;
	}

	/**
	 * Sets the length of the current stream to the specified value.
	 * 
	 * @param value
	 * The value at which to set the length.
	 * 
	 * @throws ArgumentOutOfRangeException
	 * value is negative or is greater than the maximum length of the MemoryStream, where the maximum length is (MaxValue - origin), and origin is the index into the underlying buffer at which the stream starts.
	 * 
	 * @throws NotSupportedException
	 * The current stream is not resizable and value is larger than the current capacity.-or- The current stream does not support writing.
	 */
	@Override
	public void SetLength(long value)
	{
		if (!this._writable)
			throw new NotSupportedException("Stream does not support writing.");
		
		if (value > 0x7fffffffL)
			throw new ArgumentOutOfRangeException("value", "MemoryStream length must be non-negative and less than 2^31 - 1 - origin.");
		
		if ((value < 0L) || (value > (0x7fffffff - this._origin)))
			throw new ArgumentOutOfRangeException("value", "MemoryStream length must be non-negative and less than 2^31 - 1 - origin.");
		
		int num = this._origin + ((int)value);
		if (!this.EnsureCapacity(num) && num > this.length)
		{
			Arrays.fill(m_buffer, length, num - this.length, (byte)0);
		}
		this.length = num;
		if (this._position > num)
		{
			this._position = num;
		}
	}
	
	/**
	 * Writes the entire stream contents to a byte array, regardless of the Position property.
	 * 
	 * @return
	 * A new byte array.
	 */
	public byte[] ToArray()
	{
		byte[] dst = new byte[length - _origin];
		System.arraycopy(m_buffer, _origin, dst, 0, length - _origin);
		return dst;
	}
	
	/**
	 * Writes a byte to the current stream at the current position.
	 * 
	 * @param value
	 * The byte to write.
	 * 
	 * @throws NotSupportedException
	 * The stream does not support writing. For additional information see CanWrite.-or- The current position is at the end of the stream, and the capacity cannot be modified.
	 * 
	 * @throws ObjectDisposedException
	 * The current stream is closed.
	 */
	public void WriteByte(byte value)
	{
		if (!this._isOpen)
			throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
		if (!this._writable)
			throw new NotSupportedException("Stream does not support writing.");
		
		if (this._position >= this.length)
		{
			int num = this._position + 1;
			boolean flag = this._position > this.length;
			if ((num > this._capacity) && this.EnsureCapacity(num))
			{
				flag = false;
			}
			if (flag)
			{
				Arrays.fill(m_buffer, this.length, this._position - this.length, (byte)0);
			}
			this.length = num;
		}
		this.m_buffer[this._position++] = value;
	}

	/**
	 * Writes a block of bytes to the current stream using data read from buffer.
	 * 
	 * @param buffer
	 * The buffer to write data from.
	 * 
	 * @param offset
	 * The byte offset in buffer at which to begin writing from.
	 * 
	 * @param count
	 * The maximum number of bytes to write.
	 * 
	 * @throws ObjectDisposedException
	 * The current stream is closed.
	 * 
	 * @throws NotSupportedException
	 * The stream does not support writing. For additional information see CanWrite.-or- The current position is closer than count bytes to the end of the stream, and the capacity cannot be modified.
	 * 
	 * @throws ArgumentNullException
	 * buffer is null.
	 * 
	 * @throws IOException
	 * An I/O error occurs.
	 */
	@Override
	public void Write(byte[] buffer, int offset, int count)
	{
		if (!this._isOpen)
			throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
		if (!this._writable)
			throw new NotSupportedException("Stream does not support writing.");
		
		if (buffer == null)
			throw new ArgumentNullException("buffer", "Buffer cannot be null.");
		
		if (offset < 0)
			throw new ArgumentOutOfRangeException("offset", "Non-negative niumber required.");
		
		if (count < 0)
			throw new ArgumentOutOfRangeException("count", "Non-negative number required.");
		
		if ((buffer.length - offset) < count)
	    {
	        throw new ArgumentException("Offset and length were out of bounds for the array or count is greater than the number of elements from index to the end of the source collection.");
	    }
	    int num = this._position + count;
	    if (num < 0)
	    {
	        throw new IOException("Stream was too long");
	    }
	    if (num > this.length)
	    {
	        boolean flag = this._position > this.length;
	        if ((num > this._capacity) && this.EnsureCapacity(num))
	        {
	            flag = false;
	        }
	        if (flag)
	        {
	            Arrays.fill(this.m_buffer, this.length, num - this.length, (byte)0);
	        }
	        this.length = num;
	    }
	    if (count <= 8)
	    {
	        int num2 = count;
	        while (--num2 >= 0)
	        {
	            this.m_buffer[this._position + num2] = buffer[offset + num2];
	        }
	    }
	    else
	    {
	        System.arraycopy(buffer, offset, this.m_buffer, this._position, count);
	    }
	    this._position = num;
	}

	/**
	 * Writes the entire contents of this memory stream to another stream.
	 * 
	 * @param stream
	 * The stream to write this memory stream to.
	 * 
	 * @throws ArgumentNullException
	 * stream is null.
	 * 
	 * @throws ObjectDisposedException
	 * The current or target stream is closed.
	 */
	public void WriteTo(Stream stream)
	{
		if (!this._isOpen)
			throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
		if (stream == null)
			throw new ArgumentNullException("stream", "Stream cannot be null");
		
		stream.Write(m_buffer, _origin, length - _origin);
	}
	
	/**
	 * Writes the entire contents of this memory stream to a java.io.OutputStream.
	 * 
	 * @param stream
	 * The stream to write this memory stream to.
	 * 
	 * @throws ArgumentNullException
	 * stream is null.
	 * 
	 * @throws ObjectDisposedException
	 * The current or target stream is closed.
	 */
	public void WriteTo(OutputStream stream)
	{
		if (!this._isOpen)
			throw new ObjectDisposedException(null, "Cannot access a closed Stream.");
		
		if (stream == null)
			throw new ArgumentNullException("stream", "Stream cannot be null.");
		
		try
		{
			stream.write(m_buffer, _origin, length - _origin);
		}
		catch (java.io.IOException e)
		{
			// silently catch Java's IOException- C# doesn't throw any either.
		}
	}
}
