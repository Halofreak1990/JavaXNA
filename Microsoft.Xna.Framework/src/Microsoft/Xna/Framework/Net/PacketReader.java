package Microsoft.Xna.Framework.Net;

import System.*;
import System.IO.*;
import Microsoft.Xna.Framework.*;

/**
 * Provides common functionality for efficiently reading incoming network packets. Reference page contains links to related code samples.
 *
 * @author Halofreak1990
 */
public class PacketReader extends BinaryReader
{
	/**
	 * Gets the length of the packet being read.
	 */
	public int Length()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the current packet read position.
	 */
	public int getPosition()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Sets the current packet read position.
	 */
	public void setPosition(int value)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Initializes an empty instance of PacketReader.
	 */
	public PacketReader()
	{
		this(0);
	}
	
	/**
	 * Initializes an empty instance of PacketReader with the specified options.
	 * 
	 * @param capacity
	 * Initial capacity for a received network packet.
	 */
	public PacketReader(int capacity)
	{
		// TODO: fix
		super(null/*new MemoryStream(capacity)*/);
	}
	
	/**
	 * Reads a Color value.
	 */
	public Color ReadColor()
	{
		Color col = new Color();
		col.setPackedValue(ReadInt32());
		return col;
	}
	
	/**
	 * Reads an 8-byte floating point value.
	 */
	public double ReadDouble()
	{
		return Double.longBitsToDouble(ReadInt64());
	}
	
	/**
	 * Reads a Matrix value.
	 */
	public Matrix ReadMatrix()
	{
		Matrix matrix = new Matrix();
        matrix.M11 = this.ReadSingle();
        matrix.M12 = this.ReadSingle();
        matrix.M13 = this.ReadSingle();
        matrix.M14 = this.ReadSingle();
        matrix.M21 = this.ReadSingle();
        matrix.M22 = this.ReadSingle();
        matrix.M23 = this.ReadSingle();
        matrix.M24 = this.ReadSingle();
        matrix.M31 = this.ReadSingle();
        matrix.M32 = this.ReadSingle();
        matrix.M33 = this.ReadSingle();
        matrix.M34 = this.ReadSingle();
        matrix.M41 = this.ReadSingle();
        matrix.M42 = this.ReadSingle();
        matrix.M43 = this.ReadSingle();
        matrix.M44 = this.ReadSingle();
        return matrix;
	}
	
	/**
	 * Reads a Quaternion value.
	 */
	public Quaternion ReadQuaternion()
    {
        Quaternion quaternion = new Quaternion();
        quaternion.X = this.ReadSingle();
        quaternion.Y = this.ReadSingle();
        quaternion.Z = this.ReadSingle();
        quaternion.W = this.ReadSingle();
        return quaternion;
    }
	
	/**
	 * Reads a 4-byte floating point value.
	 */
	public float ReadSingle()
	{
		return Float.intBitsToFloat(this.ReadInt32());
	}
	
	/**
	 * Reads a Vector2 value.
	 */
	public Vector2 ReadVector2()
    {
        Vector2 vector = new Vector2();
        vector.X = this.ReadSingle();
        vector.Y = this.ReadSingle();
        return vector;
    }

	/**
	 * Reads a Vector3 value.
	 */
    public Vector3 ReadVector3()
    {
        Vector3 vector = new Vector3();
        vector.X = this.ReadSingle();
        vector.Y = this.ReadSingle();
        vector.Z = this.ReadSingle();
        return vector;
    }

    /**
     * Reads a Vector4 value.
     */
    public Vector4 ReadVector4()
    {
        Vector4 vector = new Vector4();
        vector.X = this.ReadSingle();
        vector.Y = this.ReadSingle();
        vector.Z = this.ReadSingle();
        vector.W = this.ReadSingle();
        return vector;
    }
}
