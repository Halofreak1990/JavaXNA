package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a four-dimensional vector (x,y,z,w), which is used to efficiently rotate an object about the (x, y, z) vector by the angle theta, where w = cos(theta/2).
 * 
 * @author Halofreak1990
 */
public final class Quaternion extends ValueType implements IEquatable<Quaternion>
{
	/**
	 * Returns a Quaternion representing no rotation.
	 */
	public final Quaternion Identity = new Quaternion(0f, 0f, 0f, 1f);
	/**
	 * Specifies the x-value of the vector component of the quaternion.
	 */
	public float X;
	/**
	 * Specifies the y-value of the vector component of the quaternion.
	 */
    public float Y;
    /**
     * Specifies the z-value of the vector component of the quaternion.
     */
    public float Z;
    /**
     * Specifies the rotation component of the quaternion.
     */
    public float W;
    
    /**
     * Initializes a new instance of Quaternion.
     * 
     * @param vectorPart
     * The vector component of the quaternion.
     * 
     * @param scalarPart
     * The rotation component of the quaternion.
     */
    public Quaternion(Vector3 vectorPart, float scalarPart)
    {
        this.X = vectorPart.X;
        this.Y = vectorPart.Y;
        this.Z = vectorPart.Z;
        this.W = scalarPart;
    }
    
    /**
     * Initializes a new instance of Quaternion.
     * 
     * @param x
     * The x-value of the quaternion.
     * 
     * @param y
     * The y-value of the quaternion.
     * 
     * @param z
     * The z-value of the quaternion.
     * 
     * @param w
     * The w-value of the quaternion.
     */
    public Quaternion(float x, float y, float z, float w)
    {
        this.X = x;
        this.Y = y;
        this.Z = z;
        this.W = w;
    }
    
    /**
     * Initializes a new instance of Quaternion.
     */
    public Quaternion()
    {
    	this.X = 0;
    	this.Y = 0;
    	this.Z = 0;
    	this.W = 0;
    }
    
    /**
     * Adds the specified quaternion to the current quaternion.
     * 
     * @param other
     * Source quaternion.
     */
    public void Add(Quaternion other)
    {
    	this.X += other.X;
    	this.Y += other.Y;
    	this.Z += other.Z;
    	this.W += other.W;
    }
    
    /**
     * Adds two Quaternions.
     * 
     * @param quaternion1
     * Quaternion to add.
     * 
     * @param quaternion2
     * Quaternion to add.
     */
    public static Quaternion Add(Quaternion quaternion1, Quaternion quaternion2)
    {
        Quaternion quaternion = new Quaternion();
        quaternion.X = quaternion1.X + quaternion2.X;
        quaternion.Y = quaternion1.Y + quaternion2.Y;
        quaternion.Z = quaternion1.Z + quaternion2.Z;
        quaternion.W = quaternion1.W + quaternion2.W;
        return quaternion;
    }
    
    /**
     * Adds two Quaternions.
     * 
     * @param quaternion1
     * Quaternion to add.
     * 
     * @param quaternion2
     * Quaternion to add.
     * 
     * @param result
     * [OutAttribute] Result of adding the Quaternions.
     */
    public static void Add(Quaternion quaternion1, Quaternion quaternion2, Quaternion result)
    {
        result.X = quaternion1.X + quaternion2.X;
        result.Y = quaternion1.Y + quaternion2.Y;
        result.Z = quaternion1.Z + quaternion2.Z;
        result.W = quaternion1.W + quaternion2.W;
    }
    
    /**
     * Concatenates two Quaternions; the result represents the value1 rotation followed by the value2 rotation.
     * 
     * @param value1
     * The first Quaternion rotation in the series.
     * 
     * @param value2
     * The second Quaternion rotation in the series.
     */
    public static Quaternion Concatenate(Quaternion value1, Quaternion value2)
    {
        Quaternion result = new Quaternion();
        Concatenate(value1, value2, result);
        return result;
    }
    
    /**
     * Concatenates two Quaternions; the result represents the value1 rotation followed by the value2 rotation.
     * 
     * @param value1
     * The first Quaternion rotation in the series.
     * 
     * @param value2
     * The second Quaternion rotation in the series.
     * 
     * @param result
     * [OutAttribute] The Quaternion rotation representing the concatenation of value1 followed by value2.
     */
    public static void Concatenate(Quaternion value1, Quaternion value2, Quaternion result)
    {
        float x = value2.X;
        float y = value2.Y;
        float z = value2.Z;
        float w = value2.W;
        float num4 = value1.X;
        float num3 = value1.Y;
        float num2 = value1.Z;
        float num = value1.W;
        float num12 = (y * num2) - (z * num3);
        float num11 = (z * num4) - (x * num2);
        float num10 = (x * num3) - (y * num4);
        float num9 = ((x * num4) + (y * num3)) + (z * num2);
        result.X = ((x * num) + (num4 * w)) + num12;
        result.Y = ((y * num) + (num3 * w)) + num11;
        result.Z = ((z * num) + (num2 * w)) + num10;
        result.W = (w * num) - num9;
    }
    
    /**
     * Transforms this Quaternion into its conjugate.
     */
    public void Conjugate()
    {
        this.X = -this.X;
        this.Y = -this.Y;
        this.Z = -this.Z;
    }
    
    /**
     * Returns the conjugate of a specified Quaternion.
     * 
     * @param value
     * The Quaternion of which to return the conjugate.
     */
    public static Quaternion Conjugate(Quaternion value)
    {
        Quaternion quaternion = new Quaternion();
        quaternion.X = -value.X;
        quaternion.Y = -value.Y;
        quaternion.Z = -value.Z;
        quaternion.W = value.W;
        return quaternion;
    }
    
    /**
     * Returns the conjugate of a specified Quaternion.
     * 
     * @param value
     * The Quaternion of which to return the conjugate.
     * 
     * @param result
     * [OutAttribute] An existing Quaternion filled in to be the conjugate of the specified one.
     */
    public static void Conjugate(Quaternion value, Quaternion result)
    {
        result.X = -value.X;
        result.Y = -value.Y;
        result.Z = -value.Z;
        result.W = value.W;
    }
    
    /**
     * Creates a Quaternion from a vector and an angle to rotate about the vector.
     * 
     * @param axis
     * The vector to rotate around.
     * 
     * @param angle
     * The angle to rotate around the vector.
     */
    public static Quaternion CreateFromAxisAngle(Vector3 axis, float angle)
    {
        Quaternion result = new Quaternion();
        CreateFromAxisAngle(axis, angle, result);
        return result;
    }
    
    /**
     * Creates a Quaternion from a vector and an angle to rotate about the vector.
     * 
     * @param axis
     * The vector to rotate around.
     * 
     * @param angle
     * The angle to rotate around the vector.
     * 
     * @param result
     * [OutAttribute] The created Quaternion.
     */
    public static void CreateFromAxisAngle(Vector3 axis, float angle, Quaternion result)
    {
        float num2 = angle * 0.5f;
        float num = (float) Math.sin((double) num2);
        float num3 = (float) Math.cos((double) num2);
        result.X = axis.X * num;
        result.Y = axis.Y * num;
        result.Z = axis.Z * num;
        result.W = num3;
    }
    
    /**
     * Creates a Quaternion from a rotation Matrix.
     * 
     * @param matrix
     * The rotation Matrix to create the Quaternion from.
     */
    public static Quaternion CreateFromRotationMatrix(Matrix matrix)
    {
    	Quaternion result = new Quaternion();
    	CreateFromRotationMatrix(matrix, result);
        return result;
    }
    
    /**
     * Creates a Quaternion from a rotation Matrix.
     * 
     * @param matrix
     * The rotation Matrix to create the Quaternion from.
     * 
     * @param result
     * [OutAttribute] The created Quaternion.
     */
    public static void CreateFromRotationMatrix(Matrix matrix, Quaternion result)
    {
        float num8 = (matrix.M11 + matrix.M22) + matrix.M33;
        if (num8 > 0f)
        {
            float num = (float) Math.sqrt((double) (num8 + 1f));
            result.W = num * 0.5f;
            num = 0.5f / num;
            result.X = (matrix.M23 - matrix.M32) * num;
            result.Y = (matrix.M31 - matrix.M13) * num;
            result.Z = (matrix.M12 - matrix.M21) * num;
        }
        else if ((matrix.M11 >= matrix.M22) && (matrix.M11 >= matrix.M33))
        {
            float num7 = (float) Math.sqrt((double) (((1f + matrix.M11) - matrix.M22) - matrix.M33));
            float num4 = 0.5f / num7;
            result.X = 0.5f * num7;
            result.Y = (matrix.M12 + matrix.M21) * num4;
            result.Z = (matrix.M13 + matrix.M31) * num4;
            result.W = (matrix.M23 - matrix.M32) * num4;
        }
        else if (matrix.M22 > matrix.M33)
        {
            float num6 = (float) Math.sqrt((double) (((1f + matrix.M22) - matrix.M11) - matrix.M33));
            float num3 = 0.5f / num6;
            result.X = (matrix.M21 + matrix.M12) * num3;
            result.Y = 0.5f * num6;
            result.Z = (matrix.M32 + matrix.M23) * num3;
            result.W = (matrix.M31 - matrix.M13) * num3;
        }
        else
        {
            float num5 = (float) Math.sqrt((double) (((1f + matrix.M33) - matrix.M11) - matrix.M22));
            float num2 = 0.5f / num5;
            result.X = (matrix.M31 + matrix.M13) * num2;
            result.Y = (matrix.M32 + matrix.M23) * num2;
            result.Z = 0.5f * num5;
            result.W = (matrix.M12 - matrix.M21) * num2;
        }
    }
    
    /**
     * Creates a new Quaternion from specified yaw, pitch, and roll angles.
     * 
     * @param yaw
     * The yaw angle, in radians, around the y-axis.
     * 
     * @param pitch
     * The pitch angle, in radians, around the x-axis.
     * 
     * @param roll
     * The roll angle, in radians, around the z-axis.
     */
    public static Quaternion CreateFromYawPitchRoll(float yaw, float pitch, float roll)
    {
    	Quaternion result = new Quaternion();
    	CreateFromYawPitchRoll(yaw, pitch, roll, result);
        return result;
    }
    
    /**
     * Creates a new Quaternion from specified yaw, pitch, and roll angles.
     * 
     * @param yaw
     * The yaw angle, in radians, around the y-axis.
     * 
     * @param pitch
     * The pitch angle, in radians, around the x-axis.
     * 
     * @param roll
     * The roll angle, in radians, around the z-axis.
     * 
     * @param result
     * [OutAttribute] An existing Quaternion filled in to express the specified yaw, pitch, and roll angles.
     */
    public static void CreateFromYawPitchRoll(float yaw, float pitch, float roll, Quaternion result)
    {
        float num9 = roll * 0.5f;
        float num6 = (float) Math.sin((double) num9);
        float num5 = (float) Math.cos((double) num9);
        float num8 = pitch * 0.5f;
        float num4 = (float) Math.sin((double) num8);
        float num3 = (float) Math.cos((double) num8);
        float num7 = yaw * 0.5f;
        float num2 = (float) Math.sin((double) num7);
        float num = (float) Math.cos((double) num7);
        result.X = ((num * num4) * num5) + ((num2 * num3) * num6);
        result.Y = ((num2 * num3) * num5) - ((num * num4) * num6);
        result.Z = ((num * num3) * num6) - ((num2 * num4) * num5);
        result.W = ((num * num3) * num5) + ((num2 * num4) * num6);
    }
    
    /**
     * Divides the current quaternion by the specified quaternion.
     * 
     * @param other
     * Source quaternion.
     */
    public void Divide(Quaternion other)
    {
    	Divide(this, other, this); 
    }
    
    /**
     * Divides a Quaternion by another Quaternion.
     * 
     * @param quaternion1
     * Source Quaternion.
     * 
     * @param quaternion2
     * The divisor.
     */
    public static Quaternion Divide(Quaternion quaternion1, Quaternion quaternion2)
    {
        Quaternion result = new Quaternion();
        Divide(quaternion1, quaternion2, result);
        return result;
    }
    
    /**
     * Divides a Quaternion by another Quaternion.
     * 
     * @param quaternion1
     * Source Quaternion.
     * 
     * @param quaternion2
     * The divisor.
     * 
     * @param result
     * [OutAttribute] Result of the division.
     */
    public static void Divide(Quaternion quaternion1, Quaternion quaternion2, Quaternion result)
    {
        float x = quaternion1.X;
        float y = quaternion1.Y;
        float z = quaternion1.Z;
        float w = quaternion1.W;
        float num14 = (((quaternion2.X * quaternion2.X) + (quaternion2.Y * quaternion2.Y)) + (quaternion2.Z * quaternion2.Z)) + (quaternion2.W * quaternion2.W);
        float num5 = 1f / num14;
        float num4 = -quaternion2.X * num5;
        float num3 = -quaternion2.Y * num5;
        float num2 = -quaternion2.Z * num5;
        float num = quaternion2.W * num5;
        float num13 = (y * num2) - (z * num3);
        float num12 = (z * num4) - (x * num2);
        float num11 = (x * num3) - (y * num4);
        float num10 = ((x * num4) + (y * num3)) + (z * num2);
        result.X = ((x * num) + (num4 * w)) + num13;
        result.Y = ((y * num) + (num3 * w)) + num12;
        result.Z = ((z * num) + (num2 * w)) + num11;
        result.W = (w * num) - num10;
    }
    
    /**
     * Calculates the dot product of two Quaternions.
     * 
     * @param quaternion1
     * Source Quaternion.
     * 
     * @param quaternion2
     * Source Quaternion.
     */
    public static float Dot(Quaternion quaternion1, Quaternion quaternion2)
    {
        return ((((quaternion1.X * quaternion2.X) + (quaternion1.Y * quaternion2.Y)) + (quaternion1.Z * quaternion2.Z)) + (quaternion1.W * quaternion2.W));
    }
    
    /**
     * Calculates the dot product of two Quaternions.
     * 
     * @param quaternion1
     * Source Quaternion.
     * 
     * @param quaternion2
     * Source Quaternion.
     * 
     * @param result
     * [OutAttribute] Dot product of the Quaternions.
     */
    public static void Dot(Quaternion quaternion1, Quaternion quaternion2, float result)
    {
        result = (((quaternion1.X * quaternion2.X) + (quaternion1.Y * quaternion2.Y)) + (quaternion1.Z * quaternion2.Z)) + (quaternion1.W * quaternion2.W);
    }
    
    /**
     * Returns a value that indicates whether the current instance is equal to a specified object.
     * 
     * @param obj
     * to make the comparison with.
     */
    @Override
    public boolean equals(Object obj)
    {
    	return (obj != null && obj instanceof Quaternion) ? this.Equals((Quaternion)obj) : false;
    }
    
    /**
     * Determines whether the specified Object is equal to the Quaternion.
     * 
     * @param other
     * The Quaternion to compare with the current Quaternion.
     */
    public boolean Equals(Quaternion other)
    {
        return ((((this.X == other.X) && (this.Y == other.Y)) && (this.Z == other.Z)) && (this.W == other.W));
    }
    
    /**
     * Get the hash code of this object.
     */
    @Override
    public int hashCode()
    {
        return ((int)this.X ^ (int)this.Y ^ (int)this.Z ^ (int)this.W);
    }
    
    /**
     * Returns the inverse of a Quaternion.
     * 
     * @param quaternion
     * Source Quaternion.
     */
    public static Quaternion Inverse(Quaternion quaternion)
    {
        Quaternion quaternion2 = new Quaternion();
        float num2 = (((quaternion.X * quaternion.X) + (quaternion.Y * quaternion.Y)) + (quaternion.Z * quaternion.Z)) + (quaternion.W * quaternion.W);
        float num = 1f / num2;
        quaternion2.X = -quaternion.X * num;
        quaternion2.Y = -quaternion.Y * num;
        quaternion2.Z = -quaternion.Z * num;
        quaternion2.W = quaternion.W * num;
        return quaternion2;
    }
    
    /**
     * Returns the inverse of a Quaternion.
     * 
     * @param quaternion
     * Source Quaternion.
     * 
     * @param result
     * [OutAttribute] The inverse of the Quaternion.
     */
    public static void Inverse(Quaternion quaternion, Quaternion result)
    {
        float num2 = (((quaternion.X * quaternion.X) + (quaternion.Y * quaternion.Y)) + (quaternion.Z * quaternion.Z)) + (quaternion.W * quaternion.W);
        float num = 1f / num2;
        result.X = -quaternion.X * num;
        result.Y = -quaternion.Y * num;
        result.Z = -quaternion.Z * num;
        result.W = quaternion.W * num;
    }
    
    /**
     * Calculates the length of a Quaternion.
     */
    public float Length()
    {
        float num = (((this.X * this.X) + (this.Y * this.Y)) + (this.Z * this.Z)) + (this.W * this.W);
        return (float) Math.sqrt((double) num);
    }
    
    /**
     * Calculates the length squared of a Quaternion.
     */
    public float LengthSquared()
    {
        return ((((this.X * this.X) + (this.Y * this.Y)) + (this.Z * this.Z)) + (this.W * this.W));
    }
    
    /**
     * Linearly interpolates between two quaternions.
     * 
     * @param quaternion1
     * Source quaternion.
     * 
     * @param quaternion2
     * Source quaternion.
     * 
     * @param amount
     * Value indicating how far to interpolate between the quaternions.
     */
    public static Quaternion Lerp(Quaternion quaternion1, Quaternion quaternion2, float amount)
    {
    	Quaternion result = new Quaternion();
    	Lerp(quaternion1, quaternion2, amount, result);
    	return result;
    }
    
    /**
     * Linearly interpolates between two quaternions.
     * 
     * @param quaternion1
     * Source quaternion.
     * 
     * @param quaternion2
     * Source quaternion.
     * 
     * @param amount
     * Value indicating how far to interpolate between the quaternions.
     * 
     * @param result
     * [OutAttribute] The resulting quaternion.
     */
    public static void Lerp(Quaternion quaternion1, Quaternion quaternion2, float amount, Quaternion result)
    {
        float num = amount;
        float num2 = 1f - num;
        float num5 = (((quaternion1.X * quaternion2.X) + (quaternion1.Y * quaternion2.Y)) + (quaternion1.Z * quaternion2.Z)) + (quaternion1.W * quaternion2.W);
        if (num5 >= 0f)
        {
            result.X = (num2 * quaternion1.X) + (num * quaternion2.X);
            result.Y = (num2 * quaternion1.Y) + (num * quaternion2.Y);
            result.Z = (num2 * quaternion1.Z) + (num * quaternion2.Z);
            result.W = (num2 * quaternion1.W) + (num * quaternion2.W);
        }
        else
        {
            result.X = (num2 * quaternion1.X) - (num * quaternion2.X);
            result.Y = (num2 * quaternion1.Y) - (num * quaternion2.Y);
            result.Z = (num2 * quaternion1.Z) - (num * quaternion2.Z);
            result.W = (num2 * quaternion1.W) - (num * quaternion2.W);
        }
        float num4 = (((result.X * result.X) + (result.Y * result.Y)) + (result.Z * result.Z)) + (result.W * result.W);
        float num3 = 1f / ((float) Math.sqrt((double) num4));
        result.X *= num3;
        result.Y *= num3;
        result.Z *= num3;
        result.W *= num3;
    }
    
    /**
     * Multiplies the current quaternion by the specified quaternion.
     * 
     * @param other
     * Source quaternion.
     */
    public void Multiply(Quaternion other)
    {
    	Multiply(this, other, this);
    }
    
    /**
     * Multiplies the current quaternion by the specified scalar value.
     * @param scaleFactor
     * Scalar value.
     */
    public void Multiply(float scaleFactor)
    {
    	Multiply(this, scaleFactor, this);
    }
    
    /**
     * Multiplies two quaternions.
     * 
     * @param quaternion1
     * The quaternion on the left of the multiplication.
     * 
     * @param quaternion2
     * The quaternion on the right of the multiplication.
     */
    public static Quaternion Multiply(Quaternion quaternion1, Quaternion quaternion2)
    {
        Quaternion result = new Quaternion();
        Multiply(quaternion1, quaternion2, result);
        return result;
    }
    
    /**
     * Multiplies a quaternion by a scalar value.
     * 
     * @param quaternion1
     * Source quaternion.
     * 
     * @param scaleFactor
     * Scalar value.
     */
    public static Quaternion Multiply(Quaternion quaternion1, float scaleFactor)
    {
        Quaternion quaternion = new Quaternion();
        quaternion.X = quaternion1.X * scaleFactor;
        quaternion.Y = quaternion1.Y * scaleFactor;
        quaternion.Z = quaternion1.Z * scaleFactor;
        quaternion.W = quaternion1.W * scaleFactor;
        return quaternion;
    }
    
    /**
     * Multiplies two quaternions.
     * 
     * @param quaternion1
     * The quaternion on the left of the multiplication.
     * 
     * @param quaternion2
     * The quaternion on the right of the multiplication.
     * 
     * @param result
     * [OutAttribute] The result of the multiplication.
     */
    public static void Multiply(Quaternion quaternion1, Quaternion quaternion2, Quaternion result)
    {
        float x = quaternion1.X;
        float y = quaternion1.Y;
        float z = quaternion1.Z;
        float w = quaternion1.W;
        float num4 = quaternion2.X;
        float num3 = quaternion2.Y;
        float num2 = quaternion2.Z;
        float num = quaternion2.W;
        float num12 = (y * num2) - (z * num3);
        float num11 = (z * num4) - (x * num2);
        float num10 = (x * num3) - (y * num4);
        float num9 = ((x * num4) + (y * num3)) + (z * num2);
        result.X = ((x * num) + (num4 * w)) + num12;
        result.Y = ((y * num) + (num3 * w)) + num11;
        result.Z = ((z * num) + (num2 * w)) + num10;
        result.W = (w * num) - num9;
    }
    
    /**
     * Multiplies a quaternion by a scalar value.
     * 
     * @param quaternion1
     * Source quaternion.
     * 
     * @param scaleFactor
     * Scalar value.
     * 
     * @param result
     * [OutAttribute] The result of the multiplication.
     */
    public static void Multiply(Quaternion quaternion1, float scaleFactor, Quaternion result)
    {
        result.X = quaternion1.X * scaleFactor;
        result.Y = quaternion1.Y * scaleFactor;
        result.Z = quaternion1.Z * scaleFactor;
        result.W = quaternion1.W * scaleFactor;
    }
    
    /**
     * Flips the sign of each component of the quaternion.
     * 
     * @param quaternion
     * Source quaternion.
     */
    public static Quaternion Negate(Quaternion quaternion)
    {
        Quaternion quaternion2 = new Quaternion();
        quaternion2.X = -quaternion.X;
        quaternion2.Y = -quaternion.Y;
        quaternion2.Z = -quaternion.Z;
        quaternion2.W = -quaternion.W;
        return quaternion2;
    }
    
    /**
     * Flips the sign of each component of the quaternion.
     * 
     * @param quaternion
     * Source quaternion.
     * 
     * @param result
     * [OutAttribute] Negated quaternion.
     */
    public static void Negate(Quaternion quaternion, Quaternion result)
    {
        result.X = -quaternion.X;
        result.Y = -quaternion.Y;
        result.Z = -quaternion.Z;
        result.W = -quaternion.W;
    }
    
    /**
     * Divides each component of the quaternion by the length of the quaternion.
     */
    public void Normalize()
    {
        float num2 = (((this.X * this.X) + (this.Y * this.Y)) + (this.Z * this.Z)) + (this.W * this.W);
        float num = 1f / ((float) Math.sqrt((double) num2));
        this.X *= num;
        this.Y *= num;
        this.Z *= num;
        this.W *= num;
    }
    
    /**
     * Divides each component of the quaternion by the length of the quaternion.
     * 
     * @param quaternion
     * Source quaternion.
     */
    public static Quaternion Normalize(Quaternion quaternion)
    {
        Quaternion quaternion2 = new Quaternion();
        float num2 = (((quaternion.X * quaternion.X) + (quaternion.Y * quaternion.Y)) + (quaternion.Z * quaternion.Z)) + (quaternion.W * quaternion.W);
        float num = 1f / ((float) Math.sqrt((double) num2));
        quaternion2.X = quaternion.X * num;
        quaternion2.Y = quaternion.Y * num;
        quaternion2.Z = quaternion.Z * num;
        quaternion2.W = quaternion.W * num;
        return quaternion2;
    }
    
    /**
     * Divides each component of the quaternion by the length of the quaternion.
     * 
     * @param quaternion
     * Source quaternion.
     * 
     * @param result
     * [OutAttribute] Normalized quaternion.
     */
    public static void Normalize(Quaternion quaternion, Quaternion result)
    {
        float num2 = (((quaternion.X * quaternion.X) + (quaternion.Y * quaternion.Y)) + (quaternion.Z * quaternion.Z)) + (quaternion.W * quaternion.W);
        float num = 1f / ((float) Math.sqrt((double) num2));
        result.X = quaternion.X * num;
        result.Y = quaternion.Y * num;
        result.Z = quaternion.Z * num;
        result.W = quaternion.W * num;
    }
    
    /**
     * Interpolates between two quaternions, using spherical linear interpolation.
     * 
     * @param quaternion1
     * Source quaternion.
     * 
     * @param quaternion2
     * Source quaternion.
     * 
     * @param amount
     * Value that indicates how far to interpolate between the quaternions.
     */
    public static Quaternion Slerp(Quaternion quaternion1, Quaternion quaternion2, float amount)
    {
    	Quaternion result = new Quaternion();
    	Slerp(quaternion1, quaternion2, amount, result);
    	return result;
    }
    
    /**
     * Interpolates between two quaternions, using spherical linear interpolation.
     * 
     * @param quaternion1
     * Source quaternion.
     * 
     * @param quaternion2
     * Source quaternion.
     * 
     * @param amount
     * Value that indicates how far to interpolate between the quaternions.
     * 
     * @param result
     * [OutAttribute] Result of the interpolation.
     */
    public static void Slerp(Quaternion quaternion1, Quaternion quaternion2, float amount, Quaternion result)
    {
        float num2 = 0;
        float num3 = 0;
        float num = amount;
        float num4 = (((quaternion1.X * quaternion2.X) + (quaternion1.Y * quaternion2.Y)) + (quaternion1.Z * quaternion2.Z)) + (quaternion1.W * quaternion2.W);
        boolean flag = false;
        if (num4 < 0f)
        {
            flag = true;
            num4 = -num4;
        }
        if (num4 > 0.999999f)
        {
            num3 = 1f - num;
            num2 = flag ? -num : num;
        }
        else
        {
            float num5 = (float) Math.acos((double) num4);
            float num6 = (float) (1.0 / Math.sin((double) num5));
            num3 = ((float) Math.sin((double) ((1f - num) * num5))) * num6;
            num2 = flag ? (((float) -Math.sin((double) (num * num5))) * num6) : (((float) Math.sin((double) (num * num5))) * num6);
        }
        result.X = (num3 * quaternion1.X) + (num2 * quaternion2.X);
        result.Y = (num3 * quaternion1.Y) + (num2 * quaternion2.Y);
        result.Z = (num3 * quaternion1.Z) + (num2 * quaternion2.Z);
        result.W = (num3 * quaternion1.W) + (num2 * quaternion2.W);
    }
    
    /**
     * Subtracts the specified Quaternion from the current quaternion.
     * 
     * @param other
     * Source Quaternion.
     */
    public void Subtract(Quaternion other)
    {
    	Subtract(this, other, this);
    }
    
    /**
     * Subtracts a quaternion from another quaternion.
     * 
     * @param quaternion1
     * Source quaternion.
     * 
     * @param quaternion2
     * Source quaternion.
     */
    public static Quaternion Subtract(Quaternion quaternion1, Quaternion quaternion2)
    {
        Quaternion quaternion = new Quaternion();
        quaternion.X = quaternion1.X - quaternion2.X;
        quaternion.Y = quaternion1.Y - quaternion2.Y;
        quaternion.Z = quaternion1.Z - quaternion2.Z;
        quaternion.W = quaternion1.W - quaternion2.W;
        return quaternion;
    }
    
    /**
     * Subtracts a quaternion from another quaternion.
     * 
     * @param quaternion1
     * Source quaternion.
     * 
     * @param quaternion2
     * Source quaternion.
     * 
     * @param result
     * [OutAttribute] Result of the subtraction.
     */
    public static void Subtract(Quaternion quaternion1, Quaternion quaternion2, Quaternion result)
    {
        result.X = quaternion1.X - quaternion2.X;
        result.Y = quaternion1.Y - quaternion2.Y;
        result.Z = quaternion1.Z - quaternion2.Z;
        result.W = quaternion1.W - quaternion2.W;
    }
    
    /**
     * Retrieves a string representation of the current object.
     */
    @Override
    public String toString()
    {
        return String.format(Locale.getDefault(), "{X:%f Y:%f Z:%f W:%f}", this.X, this.Y, this.Z, this.W);
    }
}
