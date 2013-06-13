package Microsoft.Xna.Framework.Net;

import System.IO.*;
import Microsoft.Xna.Framework.*;

/**
 * Provides common functionality for efficiently formatting outgoing network packets. Reference page contains links to related code samples.
 *
 * @author Halofreak1990
 */
public class PacketWriter extends BinaryWriter
{
	/**
	 * Gets the length of the packet being written.
	 */
	public int Length()
	{
		return (int)getBaseStream().Length();
	}
	
	/**
	 * Gets the current packet write position.
	 */
	public int getPosition()
	{
		return (int)getBaseStream().getPosition();
	}
	
	/**
	 * Sets the current packet write position.
	 */
	public void setPosition(int value)
	{
		getBaseStream().setPosition(value);
	}
	
	/**
	 * Initializes an empty instance of PacketWriter.
	 */
	public PacketWriter()
	{
		this(0);
	}
	
	/**
	 * Initializes a new instance of PacketWriter with the specified capacity.
	 * 
	 * @param capacity
	 * Capacity for the packet writer.
	 */
	public PacketWriter(int capacity)
	{
		super(new MemoryStream(capacity));
	}
	
	/**
	 * Writes a Color value to an outgoing network packet.
	 * 
	 * @param value
	 * Value to be written.
	 */
	public void Write(Color value)
    {
		this.Write(value.getPackedValue());
    }
	
	void Clear()
	{
		MemoryStream stream = (MemoryStream)getBaseStream();
		stream.SetLength(0);
		stream.setPosition(0);
	}

	/**
	 * Writes a Matrix value to an outgoing network packet. Reference page contains links to related code samples.
	 * 
	 * @param value
	 * Value being written.
	 */
	public void Write(Matrix value)
	{
		this.Write(value.M11);
        this.Write(value.M12);
        this.Write(value.M13);
        this.Write(value.M14);
        this.Write(value.M21);
        this.Write(value.M22);
        this.Write(value.M23);
        this.Write(value.M24);
        this.Write(value.M31);
        this.Write(value.M32);
        this.Write(value.M33);
        this.Write(value.M34);
        this.Write(value.M41);
        this.Write(value.M42);
        this.Write(value.M43);
        this.Write(value.M44);
	}
	
	/**
	 * Writes a Quaternion value to an outgoing network packet. Reference page contains links to related code samples.
	 * 
	 * @param value
	 * Value being written.
	 */
	public void Write(Quaternion value)
	{
		this.Write(value.X);
		this.Write(value.Y);
		this.Write(value.Z);
		this.Write(value.W);
	}
	
	/**
	 * Writes a Vector2 value to an outgoing network packet. Reference page contains links to related code samples.
	 * 
	 * @param value
	 * Value being written.
	 */
	public void Write(Vector2 value)
	{
		this.Write(value.X);
		this.Write(value.Y);
	}
	
	/**
	 * Writes a Vector3 value to an outgoing network packet. Reference page contains links to related code samples.
	 * 
	 * @param value
	 * Value being written.
	 */
	public void Write(Vector3 value)
	{
		this.Write(value.X);
		this.Write(value.Y);
		this.Write(value.Z);
	}
	
	/**
	 * Writes a Vector4 value to an outgoing network packet. Reference page contains links to related code samples.
	 * 
	 * @param value
	 * Value being written.
	 */
	public void Write(Vector4 value)
	{
		this.Write(value.W);
		this.Write(value.X);
		this.Write(value.Y);
		this.Write(value.Z);
	}
	
	/**
	 * Writes a Double value to an outgoing network packet.
	 * 
	 * @param value
	 * Value to be written.
	 */
	public void Write(double value)
	{
		this.Write(Double.doubleToLongBits(value));
	}
	
	/**
	 * Writes a Single value to an outgoing network packet.
	 * 
	 * @param value
	 * Value to be written.
	 */
	public void Write(float value)
	{
		this.Write(Float.floatToIntBits(value));
	}
}
