package System.IO;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import System.*;

/**
 * Writes primitive types in binary to a stream and supports writing strings in a specific encoding.
 * 
 * @author Halofreak1990
 */
public class BinaryWriter implements IDisposable
{
	private byte[] _buffer;
	private Stream m_stream;
	public static final BinaryWriter Null = new BinaryWriter();
	protected Stream OutStream;
	private Charset encoding;
	
	/**
	 * Gets the underlying stream of the System.IO.BinaryWriter.
	 * 
	 * @return
	 * The underlying stream associated with the BinaryWriter.
	 */
	public Stream getBaseStream()
	{
		return m_stream;
	}
	
	/**
	 * Initializes a new instance of the System.IO.BinaryWriter class that writes to a stream.
	 */
	protected BinaryWriter()
	{
		this.OutStream = Stream.Null;
		this._buffer = new byte[0x10];
	}
	
	/**
	 * Initializes a new instance of the System.IO.BinaryWriter class based on the supplied stream and using UTF-8 as the encoding for strings.
	 * 
	 * @param output
	 * The output stream.
	 */
	public BinaryWriter(Stream output)
	{
		this(output, "UTF-8");
	}
	
	/**
	 * Initializes a new instance of the System.IO.BinaryWriter class based on the supplied stream and a specific character encoding.
	 * 
	 * @param output
	 * The output stream.
	 * 
	 * @param encoding
	 * The character encoding to use.
	 */
	public BinaryWriter(Stream output, String encoding)
	{
		m_stream = output;
		this.encoding = Charset.forName(encoding);
	}
	
	/**
	 * Closes the current System.IO.BinaryWriter and the underlying stream.
	 */
	public void Close()
	{
		this.Dispose(true);
	}
	
	/**
	 * Releases the resources used by the current instance of the System.IO.BinaryWriter class.
	 */
	@Override
	public void Dispose()
	{
		this.Dispose(true);
	}
	
	/**
	 * Called by the System.IO.BinaryWriter.Dispose method and finalizer to release the managed and unmanaged resources used by the current instance of the System.IO.BinaryWriter class.
	 * 
	 * @param disposing
	 * true to release managed and unmanaged resources; false to release only unmanaged resources.
	 */
	protected void Dispose(boolean disposing)
	{
		if (disposing)
		{
			this.OutStream.Flush();
		}
	}
	
	/**
	 * Clears all buffers for the current writer and causes any buffered data to be written to the underlying device.
	 */
	public void Flush()
	{
		this.OutStream.Flush();
	}
	
	/**
	 * Writes a one-byte Boolean value to the current stream, with 0 representing false and 1 representing true.
	 * 
	 * @param value
	 * The Boolean value to write (0 or 1).
	 */
	public void Write(boolean value)
	{
		this._buffer[0] = value ? ((byte)1) : ((byte)0);
		this.OutStream.Write(_buffer, 0, 1);
	}
	
	/**
	 * Writes a signed byte to the current stream and advances the stream position by one byte.
	 * 
	 * @param value
	 * The signed byte to write.
	 */
	public void Write(byte value)
	{
		this.OutStream.WriteByte(value);
	}
	
	/**
	 * Writes a byte array to the underlying stream.
	 * 
	 * @param buffer
	 * A byte array containing the data to write.
	 */
	public void Write(byte[] buffer)
	{
		if (buffer == null)
			throw new ArgumentNullException("buffer");
		
		this.OutStream.Write(buffer, 0, buffer.length);
	}
	
	/**
	 * Writes a two-byte signed integer to the current stream and advances the stream position by two bytes.
	 * 
	 * @param value
	 * The two-byte signed integer to write.
	 */
	public void Write(short value)
	{
		_buffer[0] = (byte)value;
		_buffer[1] = (byte)(value >> 8);
		this.OutStream.Write(_buffer, 0, 2);
	}
	
	/**
	 * Writes a four-byte signed integer to the current stream and advances the stream position by four bytes.
	 * 
	 * @param value
	 * The four-byte signed integer to write.
	 */
	public void Write(int value)
	{
		_buffer[0] = (byte)value;
		_buffer[1] = (byte)(value >> 8);
		_buffer[2] = (byte)(value >> 16);
		_buffer[3] = (byte)(value >> 24);
		this.OutStream.Write(_buffer, 0, 4);
	}
	
	/**
	 * Writes an eight-byte signed integer to the current stream and advances the stream position by eight bytes.
	 * 
	 * @param value
	 * The eight-byte signed integer to write.
	 */
	public void Write(long value)
	{
		_buffer[0] = (byte)value;
		_buffer[1] = (byte)(value >> 8);
		_buffer[2] = (byte)(value >> 16);
		_buffer[3] = (byte)(value >> 24);
		_buffer[4] = (byte)(value >> 32);
		_buffer[5] = (byte)(value >> 40);
		_buffer[6] = (byte)(value >> 48);
		_buffer[7] = (byte)(value >> 56);
		this.OutStream.Write(_buffer, 0, 8);
	}
	
	/**
	 * Writes a length-prefixed string to this stream in the current encoding of the System.IO.BinaryWriter, and advances the current position of the stream in accordance with the encoding used and the specific characters being written to the stream.
	 * 
	 * @param value
	 * The value to write.
	 */
	public void Write(String value)
	{
		if (value == null)
			throw new ArgumentNullException("value");
		
		ByteBuffer buf = encoding.encode(value);
		this.Write(buf.array().length);
		this.Write(buf.array());
	}
}
