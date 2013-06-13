package System.IO;

import System.*;

/**
 * Reads primitive data types as binary values in a specific encoding.
 * 
 * @author Halofreak1990
 */
public class BinaryReader implements IDisposable
{
	private byte[] m_buffer;
	private Stream m_stream;
	
	public Stream getBaseStream()
	{
		return m_stream;
	}
	
	/**
	 * Initializes a new instance of the BinaryReader class based on the supplied stream and using UTF-8 encoding.
	 * 
	 * @param input
	 * A stream.
	 * 
	 * @throws ArgumentException
	 * The stream does not support reading, the stream is null, or the stream is already closed.
	 */
	public BinaryReader(Stream input)
	{
		this(input, "UTF-8");
	}
	
	/**
	 * Initializes a new instance of the BinaryReader class based on the supplied stream and a specific character encoding.
	 * 
	 * @param input
	 * The supplied stream.
	 * 
	 * @param encoding
	 * The character encoding.
	 * 
	 * @throws ArgumentNullException
	 * input, or encoding is null.
	 * 
	 * @throws ArgumentException
	 * The stream does not support reading, or the stream is already closed.
	 */
	public BinaryReader(Stream input, String encoding)
	{
		if (input == null)
	        throw new ArgumentNullException("input");

		m_stream = input;
	}
	
	/**
	 * Closes the current reader and the underlying stream.
	 */
	public void Close()
	{
		Dispose(true);
	}
	
	/**
	 * 
	 */
	@Override
	public void Dispose()
	{
		this.Dispose(true);
	}
	
	/**
	 * Releases the unmanaged resources used by the BinaryReader and optionally releases the managed resources.
	 * 
	 * @param disposing
	 * true to release both managed and unmanaged resources; false to release only unmanaged resources.
	 */
	protected void Dispose(boolean disposing)
	{
		if (disposing)
		{
			Stream stream = m_stream;
			m_stream = null;
			if (stream != null)
			{
				stream.Close();
			}
		}
		m_stream = null;
		this.m_buffer = null;
	}
	
	/**
	 * Fills the internal buffer with the specified number of bytes read from the stream.
	 * 
	 * @param numBytes
	 * The number of bytes to be read.
	 * 
	 * @throws System.IO.EndOfStreamException
	 * The end of the stream is reached before numBytes could be read.
	 * 
	 * @throws System.IO.IOException
	 * An I/O error occurs.
	 * 
	 * @throws System.ObjectDisposedException
	 */
    protected void FillBuffer(int numBytes)
    {
    	int offset = 0;
	    int num2 = 0;
	    if (this.m_stream == null)
	    {
	        throw new ObjectDisposedException(this.getClass().getName(), "");
	    }
	    if (numBytes == 1)
	    {
			num2 = this.m_stream.ReadByte();
			
	        if (num2 == -1)
	        {
	        	throw new EndOfStreamException("Attempted to read past the end of the stream.");
	        }
	        this.m_buffer[0] = (byte) num2;
	    }
	    else
	    {
	        do
	        {
				num2 = this.m_stream.Read(this.m_buffer, offset, numBytes - offset);
				
	            if (num2 == 0)
	            {
	            	throw new EndOfStreamException("Attempted to read past the end of the stream.");
	            }
	            offset += num2;
	        }
	        while (offset < numBytes);
	    }
    }
    
    private int InternalReadChars(char[] buffer, int index, int count)
    {
    	// TODO: either implement or remove this
    	return 0;
    }
    
    /**
     * Reads characters from the underlying stream and advances the current position of the stream in accordance with the Encoding used and the specific character being read from the stream.
     * 
     * @return
     * The next character from the input stream, or -1 if no characters are currently available.
     * 
     * @throws System.ObjectDisposedException
     * The stream is closed.
     * 
     * @throws System.IO.IOException
     * An I/O error occurs.
     */
    public int Read()
    {
    	if (m_stream == null)
    		throw new ObjectDisposedException("m_stream");
    	
		return m_stream.ReadByte();
    }
    
    /**
     * Reads count bytes from the stream with index as the starting point in the byte array.
     * 
     * @param buffer
     * The buffer to read data into.
     * 
     * @param index
     * The starting point in the buffer at which to begin reading into the buffer.
     * 
     * @param count
     * The number of characters to read.
     * 
     * @return
     * The number of characters read into buffer. This might be less than the number of bytes requested if that many bytes are not available, or it might be zero if the end of the stream is reached.
     * 
     * @exception System.ArgumentNullException
     * buffer is null.
     * 
     * @exception System.ArgumentOutOfRangeException
     * index or count is less than zero.
     * 
     * @exception System.ArgumentException
     * The buffer length minus index is less than count.
     *
     * @exception System.ObjectDisposedException
     * The stream is closed.
     * 
     * @exception System.IO.IOException
     * An I/O error occurs.
     */
    public int Read(byte[] buffer, int index, int count)
    {
    	if (buffer == null)
    		throw new ArgumentNullException("buffer", "Buffer cannot be null.");
    	
    	if (count < 0)
    		throw new ArgumentOutOfRangeException("count", "Non-negative number required.");
    	
    	if (index < 0)
    		throw new ArgumentOutOfRangeException("index", "Non-negative number required.");
    	
    	if (buffer.length - index < count)
    		throw new ArgumentException("Offset and length were out of bounds for the array or count is greater than the number of elements from index to the end of the source collection.");
    	
    	if (m_stream == null)
    		throw new ObjectDisposedException(null, "");
    	
    	return m_stream.Read(buffer, index, count);
    }
    
    /**
     * Reads count characters from the stream with index as the starting point in the character array.
     * 
     * @param buffer
     * The buffer to read data into.
     * 
     * @param index
     * The starting point in the buffer at which to begin reading into the buffer.
     * 
     * @param count
     * The number of characters to read.
     * 
     * @return
     * The total number of characters read into the buffer. This might be less than the number of characters
     * requested if that many characters are not currently available, or it might be zero if the end of the stream is reached.
     * 
     * @throws System.ArgumentException
     * The buffer length minus index is less than count.
     * 
     * @throws System.ArgumentNullException
     * buffer is null.
     * 
     * @throws System.ArgumentOutOfRangeException
     * index or count is negative.
     * 
     * @throws System.ObjectDisposedException
     * The stream is closed.
     * 
     * @throws System.IO.IOException
     * An I/O error occurs.
     */
    public int Read(char[] buffer, int index, int count)
    {
    	if (buffer == null)
    		throw new ArgumentNullException("buffer", "Buffer cannot be null.");
    	
    	if (count < 0)
    		throw new ArgumentOutOfRangeException("count", "Non-negative number required.");
    	
    	if (index < 0)
    		throw new ArgumentOutOfRangeException("index", "Non-negative number required.");
    	
    	if (buffer.length - index < count)
    		throw new ArgumentException("Offset and length were out of bounds for the array or count is greater than the number of elements from index to the end of the source collection.");
    	
    	char res = 0;
    	int readChars = 0;
    	
    	for (int i = index; i < index + count; i++)
    	{
    		res = ReadChar();
    		if (res == -1) // check for EndOfStream
    			break;
    		
    		buffer[i] = res;
    		readChars++;
    	}
    	return readChars;
    }
    
    protected int Read7BitEncodedInt()
    {
    	// TODO: implement
    	return 0;
    }
    
    /**
     * Reads a Boolean value from the current stream and advances the current position of the stream by one byte.
     * 
     * @return
     * true if the byte is nonzero; otherwise, false.
     * 
     * @throws ObjectDisposedException
     * The stream is closed.
     * 
     * @throws IOException
     * An I/O error occurs.
     * 
     * @throws EndOfStreamException
     * The end of the stream is reached.
     */
    public boolean ReadBoolean()
    {
    	this.FillBuffer(1);
        return (this.m_buffer[0] != 0);
    }
    
    /**
     * 
     * @return
     */
    public byte ReadByte()
    {
    	return (byte)this.Read();
    }
    
    /**
     * Reads count bytes from the current stream into a byte array and advances the current position by count bytes.
     * 
     * @param count
     * The number of bytes to read.
     * 
     * @return
     * A byte array containing data read from the underlying stream. This might be less than the number of bytes requested if the end of the stream is reached.
     * 
     * @exception System.ArgumentOutOfRangeException
     * count is less than zero.
     * 
     * @exception System.ObjectDisposedException
     * The stream is closed.
     * 
     * @exception System.IO.IOException
     * An I/O error occurs.
     */
    public byte[] ReadBytes(int count)
    {
    	if (count < 0)
    		throw new ArgumentOutOfRangeException("count", "Non-negative number required.");
    	
    	if (m_stream == null)
    		throw new ObjectDisposedException("m_stream");
    	
    	byte[] buffer = new byte[count];
        int offset = 0;
        do
        {
            int num2 = 0;
			num2 = this.m_stream.Read(buffer, offset, count);
			
            if (num2 == 0)
            {
                break;
            }
            offset += num2;
            count -= num2;
        }
        while (count > 0);
        if (offset != buffer.length)
        {
            byte[] dst = new byte[offset];
            java.lang.System.arraycopy(buffer, 0, dst, 0, offset);
            buffer = dst;
        }
        return buffer;
    }
    
    /**
     * 
     * @return
     * 
     * @throws System.ObjectDisposedException
     * 
     */
    public char ReadChar()
    {
    	int num = this.Read();
	    if (num == -1)
		    throw new ObjectDisposedException(null, "");
	    
	    return (char) num;
    }
    
    /**
     * 
     * @param count
     * @return
     * 
     * @throws System.ObjectDisposedException
     * 
     * @throws System.ArgumentOutOfRangeException
     * count is less than zero.
     */
    public char[] ReadChars(int count)
    {
    	if (m_stream == null)
    		throw new ObjectDisposedException("m_stream");
    	
    	if (count < 0)
            throw new ArgumentOutOfRangeException("count", "Non-negative number required.");
    	
    	char[] buffer = new char[count];
        int num = this.InternalReadChars(buffer, 0, count);
        if (num != count)
        {
            char[] dst = new char[num];
            java.lang.System.arraycopy(buffer, 0, dst, 0, 2 * num);
            buffer = dst;
        }
        return buffer;
    }
    
    /**
     * 
     * @return
     */
    public double ReadDouble()
    {
    	return Double.longBitsToDouble(this.ReadInt64());
    }
    
    /**
     * 
     * @return
     */
    public short ReadInt16()
    {
    	this.FillBuffer(2);
        return (short) (this.m_buffer[0] | (this.m_buffer[1] << 8));
    }
    
    /**
     * 
     * @return
     */
    public int ReadInt32()
    {
    	this.FillBuffer(4);
        return (((this.m_buffer[0] | (this.m_buffer[1] << 8)) | (this.m_buffer[2] << 0x10)) | (this.m_buffer[3] << 0x18));
    }
    
    /**
     * 
     * @return
     */
    public long ReadInt64()
    {
    	this.FillBuffer(8);
        int num = (int) (((this.m_buffer[0] | (this.m_buffer[1] << 8)) | (this.m_buffer[2] << 0x10)) | (this.m_buffer[3] << 0x18));
        int num2 = (int) (((this.m_buffer[4] | (this.m_buffer[5] << 8)) | (this.m_buffer[6] << 0x10)) | (this.m_buffer[7] << 0x18));
        return (long) ((num2 << 0x20) | num);
    }
    
    /**
     * 
     * @return
     */
    public float ReadSingle()
    {
    	return Float.intBitsToFloat(this.ReadInt32());
    }
    
    /**
     * 
     * @return
     */
    public String ReadString()
    {
    	short strlen = this.ReadInt16();
    	
    	return new String(this.ReadChars(strlen));
    }
}
