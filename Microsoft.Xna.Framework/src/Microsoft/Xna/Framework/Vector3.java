package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a vector with three components.
 * 
 * @author Halofreak1990
 */
public final class Vector3 extends ValueType implements IEquatable<Vector3>
{
	/**
	 * Returns a unit Vector3 designating backward in a right-handed coordinate system (0, 0, 1).
	 */
	public static final Vector3 Backward = new Vector3(0, 0, 1);
	/**
	 * Returns a unit Vector3 designating down (0, −1, 0).
	 */
	public static final Vector3 Down = new Vector3(0, -1, 0);
	/**
	 * Returns a unit Vector3 designating forward in a right-handed coordinate system(0, 0, −1).
	 */
	public static final Vector3 Forward = new Vector3(0, 0, -1);
	/**
	 * Returns a unit Vector3 designating left (−1, 0, 0).
	 */
	public static final Vector3 Left = new Vector3(-1, 0, 0);
	/**
	 * Returns a Vector3 with ones in all of its components.
	 */
	public static final Vector3 One = new Vector3(1, 1, 1);
	/**
	 * Returns a unit Vector3 pointing to the right (1, 0, 0).
	 */
	public static final Vector3 Right = new Vector3(1, 0, 0);
	/**
	 * Returns the x unit Vector3 (1, 0, 0).
	 */
	public static final Vector3 UnitX = new Vector3(1, 0, 0);
	/**
	 * Returns the y unit Vector3 (0, 1, 0).
	 */
	public static final Vector3 UnitY = new Vector3(0, 1, 0);
	/**
	 * Returns the z unit Vector3 (0, 0, 1).
	 */
	public static final Vector3 UnitZ = new Vector3(0, 0, 1);
	/**
	 * Gets or sets the x-component of the vector.
	 */
	public float X;
	/**
	 * Gets or sets the y-component of the vector.
	 */
	public float Y;
	/**
	 * Gets or sets the z-component of the vector.
	 */
	public float Z;
	/**
	 * Returns a Vector3 with all of its components set to zero.
	 */
	public static final Vector3 Zero = new Vector3(0, 0, 0);
	
	/**
	 * Creates a new instance of Vector3.
	 * 
	 * @param value
	 * Value to initialize each component to.
	 */
	public Vector3(float value)
	{
		this.X = this.Y = this.Z = value;
	}
	
	/**
	 * Initializes a new instance of Vector3.
	 * 
	 * @param value
	 * A vector containing the values to initialize x and y components with.
	 * 
	 * @param z
	 * Initial value for the z-component of the vector.
	 */
	public Vector3(Vector2 value, float z)
	{
		this.X = value.X;
	    this.Y = value.Y;
	    this.Z = z;
	}
	
	/**
	 * Creates a new instance of Vector3.
	 * 
	 * @param x
	 * Initial value for the x-component of the vector.
	 * 
	 * @param y
	 * Initial value for the y-component of the vector.
	 * 
	 * @param z
	 * Initial value for the z-component of the vector.
	 */
	public Vector3(float x, float y, float z)
	{
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	
	/**
	 * Creates a new instance of Vector3.
	 */
	public Vector3()
	{
		this.X = 0;
		this.Y = 0;
		this.Z = 0;
	}
	
	/**
	 * Adds the specified vector to the current vector.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Add(Vector3 other)
	{
		Add(this, other, this);
	}
	
	/**
	 * Adds two vectors.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static Vector3 Add(Vector3 value1, Vector3 value2)
	{
	    Vector3 result = new Vector3();
	    Add(value1, value2, result);
	    return result;
	}
	
	/**
	 * Adds two vectors.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] Sum of the source vectors.
	 */
	public static void Add(Vector3 value1, Vector3 value2, Vector3 result)
	{
	    result.X = value1.X + value2.X;
	    result.Y = value1.Y + value2.Y;
	    result.Z = value1.Z + value2.Z;
	}
	
	/**
	 * Returns a Vector3 containing the 3D Cartesian coordinates of a point specified in Barycentric coordinates relative to a 3D triangle.
	 * 
	 * @param value1
	 * A Vector3 containing the 3D Cartesian coordinates of vertex 1 of the triangle.
	 * 
	 * @param value2
	 * A Vector3 containing the 3D Cartesian coordinates of vertex 2 of the triangle.
	 * 
	 * @param value3
	 * A Vector3 containing the 3D Cartesian coordinates of vertex 3 of the triangle.
	 * 
	 * @param amount1
	 * Barycentric coordinate b2, which expresses the weighting factor toward vertex 2 (specified in value2).
	 * 
	 * @param amount2
	 * Barycentric coordinate b3, which expresses the weighting factor toward vertex 3 (specified in value3).
	 */
	public static Vector3 Barycentric(Vector3 value1, Vector3 value2, Vector3 value3, float amount1, float amount2)
	{
	    Vector3 result = new Vector3();
	    Barycentric(value1, value2, value3, amount1, amount2, result);
	    return result;
	}
	
	/**
	 * Returns a Vector3 containing the 3D Cartesian coordinates of a point specified in Barycentric coordinates relative to a 3D triangle.
	 * 
	 * @param value1
	 * A Vector3 containing the 3D Cartesian coordinates of vertex 1 of the triangle.
	 * 
	 * @param value2
	 * A Vector3 containing the 3D Cartesian coordinates of vertex 2 of the triangle.
	 * 
	 * @param value3
	 * A Vector3 containing the 3D Cartesian coordinates of vertex 3 of the triangle.
	 * 
	 * @param amount1
	 * Barycentric coordinate b2, which expresses the weighting factor toward vertex 2 (specified in value2).
	 * 
	 * @param amount2
	 * Barycentric coordinate b3, which expresses the weighting factor toward vertex 3 (specified in value3).
	 * 
	 * @param result
	 * [OutAttribute] The 3D Cartesian coordinates of the specified point are placed in this Vector3 on exit.
	 */
	public static void Barycentric(Vector3 value1, Vector3 value2, Vector3 value3, float amount1, float amount2, Vector3 result)
	{
	    result.X = (value1.X + (amount1 * (value2.X - value1.X))) + (amount2 * (value3.X - value1.X));
	    result.Y = (value1.Y + (amount1 * (value2.Y - value1.Y))) + (amount2 * (value3.Y - value1.Y));
	    result.Z = (value1.Z + (amount1 * (value2.Z - value1.Z))) + (amount2 * (value3.Z - value1.Z));
	}
	
	/**
	 * Performs a Catmull-Rom interpolation using the specified positions.
	 * 
	 * @param value1
	 * The first position in the interpolation.
	 * 
	 * @param value2
	 * The second position in the interpolation.
	 * 
	 * @param value3
	 * The third position in the interpolation.
	 * 
	 * @param value4
	 * The fourth position in the interpolation.
	 * 
	 * @param amount
	 * Weighting factor.
	 */
	public static Vector3 CatmullRom(Vector3 value1, Vector3 value2, Vector3 value3, Vector3 value4, float amount)
	{
	    Vector3 result = new Vector3();
	    CatmullRom(value1, value2, value3, value4, amount, result);
	    return result;
	}
	
	/**
	 * Performs a Catmull-Rom interpolation using the specified positions.
	 * 
	 * @param value1
	 * The first position in the interpolation.
	 * 
	 * @param value2
	 * The second position in the interpolation.
	 * 
	 * @param value3
	 * The third position in the interpolation.
	 * 
	 * @param value4
	 * The fourth position in the interpolation.
	 * 
	 * @param amount
	 * Weighting factor.
	 * 
	 * @param result
	 * [OutAttribute] A vector that is the result of the Catmull-Rom interpolation.
	 */
	public static void CatmullRom(Vector3 value1, Vector3 value2, Vector3 value3, Vector3 value4, float amount, Vector3 result)
	{
	    float num = amount * amount;
	    float num2 = amount * num;
	    result.X = 0.5f * ((((2f * value2.X) + ((-value1.X + value3.X) * amount)) + (((((2f * value1.X) - (5f * value2.X)) + (4f * value3.X)) - value4.X) * num)) + ((((-value1.X + (3f * value2.X)) - (3f * value3.X)) + value4.X) * num2));
	    result.Y = 0.5f * ((((2f * value2.Y) + ((-value1.Y + value3.Y) * amount)) + (((((2f * value1.Y) - (5f * value2.Y)) + (4f * value3.Y)) - value4.Y) * num)) + ((((-value1.Y + (3f * value2.Y)) - (3f * value3.Y)) + value4.Y) * num2));
	    result.Z = 0.5f * ((((2f * value2.Z) + ((-value1.Z + value3.Z) * amount)) + (((((2f * value1.Z) - (5f * value2.Z)) + (4f * value3.Z)) - value4.Z) * num)) + ((((-value1.Z + (3f * value2.Z)) - (3f * value3.Z)) + value4.Z) * num2));
	}
	
	/**
	 * Restricts a value to be within a specified range.
	 * 
	 * @param value1
	 * The value to clamp.
	 * 
	 * @param min
	 * The minimum value.
	 * 
	 * @param max
	 * The maximum value.
	 */
	public static Vector3 Clamp(Vector3 value1, Vector3 min, Vector3 max)
	{
	    Vector3 result = new Vector3();
	    Clamp(value1, min, max, result);
	    return result;
	}
	
	/**
	 * Restricts a value to be within a specified range.
	 * 
	 * @param value1
	 * The value to clamp.
	 * 
	 * @param min
	 * The minimum value.
	 * 
	 * @param max
	 * The maximum value.
	 * 
	 * @param result
	 * [OutAttribute] The clamped value.
	 */
	public static void Clamp(Vector3 value1, Vector3 min, Vector3 max, Vector3 result)
	{
	    float x = value1.X;
	    x = (x > max.X) ? max.X : x;
	    x = (x < min.X) ? min.X : x;
	    float y = value1.Y;
	    y = (y > max.Y) ? max.Y : y;
	    y = (y < min.Y) ? min.Y : y;
	    float z = value1.Z;
	    z = (z > max.Z) ? max.Z : z;
	    z = (z < min.Z) ? min.Z : z;
	    result.X = x;
	    result.Y = y;
	    result.Z = z;
	}
	
	/**
	 * Calculates the cross product of two vectors.
	 * 
	 * @param vector1
	 * Source vector.
	 * 
	 * @param vector2
	 * Source vector.
	 */
	public static Vector3 Cross(Vector3 vector1, Vector3 vector2)
	{
	    Vector3 result = new Vector3();
	    Cross(vector1, vector2, result);
	    return result;
	}
	
	/**
	 * Calculates the cross product of two vectors.
	 * 
	 * @param vector1
	 * Source vector.
	 * 
	 * @param vector2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The cross product of the vectors.
	 */
	public static void Cross(Vector3 vector1, Vector3 vector2, Vector3 result)
	{
	    float num3 = (vector1.Y * vector2.Z) - (vector1.Z * vector2.Y);
	    float num2 = (vector1.Z * vector2.X) - (vector1.X * vector2.Z);
	    float num = (vector1.X * vector2.Y) - (vector1.Y * vector2.X);
	    result.X = num3;
	    result.Y = num2;
	    result.Z = num;
	}
	
	/**
	 * Calculates the distance between two vectors.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static float Distance(Vector3 value1, Vector3 value2)
	{
	    float result = 0;
	    Distance(value1, value2, result);
	    return result;
	}
	
	/**
	 * Calculates the distance between two vectors.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The distance between the vectors.
	 */
	public static void Distance(Vector3 value1, Vector3 value2, float result)
	{
	    float num3 = value1.X - value2.X;
	    float num2 = value1.Y - value2.Y;
	    float num = value1.Z - value2.Z;
	    float num4 = ((num3 * num3) + (num2 * num2)) + (num * num);
	    result = (float) Math.sqrt((double) num4);
	}
	
	/**
	 * Calculates the distance between two vectors squared.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static float DistanceSquared(Vector3 value1, Vector3 value2)
	{
	    float num3 = value1.X - value2.X;
	    float num2 = value1.Y - value2.Y;
	    float num = value1.Z - value2.Z;
	    return (((num3 * num3) + (num2 * num2)) + (num * num));
	}
	
	/**
	 * Calculates the distance between two vectors squared.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The distance between the two vectors squared.
	 */
	public static void DistanceSquared(Vector3 value1, Vector3 value2, float result)
	{
	    float num3 = value1.X - value2.X;
	    float num2 = value1.Y - value2.Y;
	    float num = value1.Z - value2.Z;
	    result = ((num3 * num3) + (num2 * num2)) + (num * num);
	}
	
	/**
	 * Divides the components of the current vector by the components of another vector.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Divide(Vector3 other)
	{
		Divide(this, other, this);
	}
	
	/**
	 * Divides the components of a vector by the components of another vector.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static Vector3 Divide(Vector3 value1, Vector3 value2)
	{
	    Vector3 result = new Vector3();
	    Divide(value1, value2, result);
	    return result;
	}
	
	/**
	 * Divides the current vector by a scalar value.
	 * 
	 * @param value
	 * The divisor.
	 */
	public void Divide(float value)
	{
		Divide(this, value, this);
	}
	
	/**
	 * Divides a vector by a scalar value.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * The divisor.
	 */
	public static Vector3 Divide(Vector3 value1, float value2)
	{
	    Vector3 result = new Vector3();
	    Divide(value1, value2, result);
	    return result;
	}
	
	/**
	 * Divides the components of a vector by the components of another vector.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * The divisor.
	 * 
	 * @param result
	 * [OutAttribute] The result of the division.
	 */
	public static void Divide(Vector3 value1, Vector3 value2, Vector3 result)
	{
	    result.X = value1.X / value2.X;
	    result.Y = value1.Y / value2.Y;
	    result.Z = value1.Z / value2.Z;
	}
	
	/**
	 * Divides a vector by a scalar value.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * The divisor.
	 * 
	 * @param result
	 * [OutAttribute] The result of the division.
	 */
	public static void Divide(Vector3 value1, float value2, Vector3 result)
	{
	    float num = 1f / value2;
	    result.X = value1.X * num;
	    result.Y = value1.Y * num;
	    result.Z = value1.Z * num;
	}
	
	/**
	 * Calculates the dot product of two vectors. If the two vectors are unit vectors, the dot product returns a floating point value between -1 and 1 that can be used to
	 * determine some properties of the angle between two vectors. For example, it can show whether the vectors are orthogonal, parallel, or have an acute or obtuse
	 * angle between them.
	 * 
	 * @param vector1
	 * Source vector.
	 * 
	 * @param vector2
	 * Source vector.
	 */
	public static float Dot(Vector3 vector1, Vector3 vector2)
	{
	    return (((vector1.X * vector2.X) + (vector1.Y * vector2.Y)) + (vector1.Z * vector2.Z));
	}
	
	/**
	 * Calculates the dot product of two vectors. If the two vectors are unit vectors, the dot product returns a floating point value between -1 and 1 that can be used to
	 * determine some properties of the angle between two vectors. For example, it can show whether the vectors are orthogonal, parallel, or have an acute or obtuse
	 * angle between them.
	 * 
	 * @param vector1
	 * Source vector.
	 * 
	 * @param vector2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The dot product of the two vectors.
	 */
	public static void Dot(Vector3 vector1, Vector3 vector2, float result)
	{
	    result = ((vector1.X * vector2.X) + (vector1.Y * vector2.Y)) + (vector1.Z * vector2.Z);
	}
	
	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * Object to make the comparison with.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		
		return (obj instanceof Vector3) ? this.Equals((Vector3)obj) : false;
	}
	
	/**
	 * Determines whether the specified Object is equal to the Vector3.
	 * 
	 * @param other
	 * The Vector3 to compare with the current Vector3.
	 */
	public boolean Equals(Vector3 other)
	{
		return ((this.X == other.X) && (this.Y == other.Y) && (this.Z == other.Z));
	}

	/**
	 * Gets the hash code of the vector object.
	 */
	@Override
	public int hashCode()
	{
		return ((int)X ^ (int)Y ^ (int)Z);
	}
	
	/**
	 * Performs a Hermite spline interpolation.
	 * 
	 * @param value1
	 * Source position vector.
	 * 
	 * @param tangent1
	 * Source tangent vector.
	 * 
	 * @param value2
	 * Source position vector.
	 * 
	 * @param tangent2
	 * Source tangent vector.
	 * 
	 * @param amount
	 * Weighting factor.
	 */
	public static Vector3 Hermite(Vector3 value1, Vector3 tangent1, Vector3 value2, Vector3 tangent2, float amount)
	{
	    Vector3 result = new Vector3();
	    Hermite(value1, tangent1, value2, tangent2, amount, result);
	    return result;
	}
	
	/**
	 * Performs a Hermite spline interpolation.
	 * 
	 * @param value1
	 * Source position vector.
	 * 
	 * @param tangent1
	 * Source tangent vector.
	 * 
	 * @param value2
	 * Source position vector.
	 * 
	 * @param tangent2
	 * Source tangent vector.
	 * 
	 * @param amount
	 * Weighting factor.
	 * 
	 * @param result
	 * [OutAttribute] The result of the Hermite spline interpolation.
	 */
	public static void Hermite(Vector3 value1, Vector3 tangent1, Vector3 value2, Vector3 tangent2, float amount, Vector3 result)
	{
	    float num = amount * amount;
	    float num2 = amount * num;
	    float num6 = ((2f * num2) - (3f * num)) + 1f;
	    float num5 = (-2f * num2) + (3f * num);
	    float num4 = (num2 - (2f * num)) + amount;
	    float num3 = num2 - num;
	    result.X = (((value1.X * num6) + (value2.X * num5)) + (tangent1.X * num4)) + (tangent2.X * num3);
	    result.Y = (((value1.Y * num6) + (value2.Y * num5)) + (tangent1.Y * num4)) + (tangent2.Y * num3);
	    result.Z = (((value1.Z * num6) + (value2.Z * num5)) + (tangent1.Z * num4)) + (tangent2.Z * num3);
	}
	
	/**
	 * Calculates the length of the vector.
	 */
	public float Length()
	{
		float num = ((this.X * this.X) + (this.Y * this.Y)) + (this.Z * this.Z);
		return (float) Math.sqrt((double) num);
	}
	
	/**
	 * Calculates the length of the vector squared.
	 */
	public float LengthSquared()
	{
	    return (((this.X * this.X) + (this.Y * this.Y)) + (this.Z * this.Z));
	}
	
	/**
	 * Performs a linear interpolation between two vectors.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param amount
	 * Value between 0 and 1 indicating the weight of value2.
	 */
	public static Vector3 Lerp(Vector3 value1, Vector3 value2, float amount)
	{
	    Vector3 result = new Vector3();
	    Lerp(value1, value2, amount, result);
	    return result;
	}

	/**
	 * Performs a linear interpolation between two vectors.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param amount
	 * Value between 0 and 1 indicating the weight of value2.
	 * 
	 * @param result
	 * [OutAttribute] The result of the interpolation.
	 */
	public static void Lerp(Vector3 value1, Vector3 value2, float amount, Vector3 result)
	{
	    result.X = value1.X + ((value2.X - value1.X) * amount);
	    result.Y = value1.Y + ((value2.Y - value1.Y) * amount);
	    result.Z = value1.Z + ((value2.Z - value1.Z) * amount);
	}
	
	/**
	 * Returns a vector that contains the highest value from each matching pair of components.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static Vector3 Max(Vector3 value1, Vector3 value2)
	{
	    Vector3 result = new Vector3();
	    Max(value1, value2, result);
	    return result;
	}
	
	/**
	 * Returns a vector that contains the highest value from each matching pair of components.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The maximized vector.
	 */
	public static void Max(Vector3 value1, Vector3 value2, Vector3 result)
	{
	    result.X = (value1.X > value2.X) ? value1.X : value2.X;
	    result.Y = (value1.Y > value2.Y) ? value1.Y : value2.Y;
	    result.Z = (value1.Z > value2.Z) ? value1.Z : value2.Z;
	}
	
	/**
	 * Returns a vector that contains the lowest value from each matching pair of components.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static Vector3 Min(Vector3 value1, Vector3 value2)
	{
	    Vector3 result = new Vector3();
	    Min(value1, value2, result);
	    return result;
	}
	
	/**
	 * Returns a vector that contains the lowest value from each matching pair of components.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The minimized vector.
	 */
	public static void Min(Vector3 value1, Vector3 value2, Vector3 result)
	{
	    result.X = (value1.X < value2.X) ? value1.X : value2.X;
	    result.Y = (value1.Y < value2.Y) ? value1.Y : value2.Y;
	    result.Z = (value1.Z < value2.Z) ? value1.Z : value2.Z;
	}
	
	/**
	 * Multiplies the components of the current vector by the components of another vector.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Multiply(Vector3 other)
	{
		Multiply(this, other, this);
	}
	
	/**
	 * Multiplies the components of two vectors by each other.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static Vector3 Multiply(Vector3 value1, Vector3 value2)
	{
	    Vector3 result = new Vector3();
	    Multiply(value1, value2, result);
	    return result;
	}
	
	/**
	 * Multiplies the current vector by a scalar value.
	 * 
	 * @param scaleFactor
	 * Scalar value.
	 */
	public void Multiply(float scaleFactor)
	{
		Multiply(this, scaleFactor, this);
	}
	
	/**
	 * Multiplies a vector by a scalar value.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param scaleFactor
	 * Scalar value.
	 */
	public static Vector3 Multiply(Vector3 value1, float scaleFactor)
	{
	    Vector3 result = new Vector3();
	    Multiply(value1, scaleFactor, result);
	    return result;
	}
	
	/**
	 * Multiplies a vector by a scalar value.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param scaleFactor
	 * Scalar value.
	 * 
	 * @param result
	 * [OutAttribute] The result of the multiplication.
	 */
	public static void Multiply(Vector3 value1, float scaleFactor, Vector3 result)
	{
	    result.X = value1.X * scaleFactor;
	    result.Y = value1.Y * scaleFactor;
	    result.Z = value1.Z * scaleFactor;
	}
	
	/**
	 * Multiplies the components of two vectors by each other.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The result of the multiplication.
	 */
	public static void Multiply(Vector3 value1, Vector3 value2, Vector3 result)
	{
	    result.X = value1.X * value2.X;
	    result.Y = value1.Y * value2.Y;
	    result.Z = value1.Z * value2.Z;
	}
	
	/**
	 * Returns the current vector pointing in the opposite direction.
	 */
	public void Negate()
	{
		Negate(this, this);
	}
	
	/**
	 * Returns a vector pointing in the opposite direction.
	 * 
	 * @param value
	 * Source vector.
	 */
	public static Vector3 Negate(Vector3 value)
	{
	    Vector3 result = new Vector3();
	    Negate(value, result);
	    return result;
	}
	
	/**
	 * Returns a vector pointing in the opposite direction.
	 * 
	 * @param value
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] Vector pointing in the opposite direction.
	 */
	public static void Negate(Vector3 value, Vector3 result)
	{
	    result.X = -value.X;
	    result.Y = -value.Y;
	    result.Z = -value.Z;
	}
	
	/**
	 * Turns the current vector into a unit vector. The result is a vector one unit in length pointing in the same direction as the original vector.
	 */
	public void Normalize()
	{
	    float num2 = ((this.X * this.X) + (this.Y * this.Y)) + (this.Z * this.Z);
	    float num = 1f / ((float) Math.sqrt((double) num2));
	    this.X *= num;
	    this.Y *= num;
	    this.Z *= num;
	}
	
	/**
	 * Creates a unit vector from the specified vector. The result is a vector one unit in length pointing in the same direction as the original vector.
	 * 
	 * @param value
	 * Source vector.
	 */
	public static Vector3 Normalize(Vector3 value)
	{
	    Vector3 result = new Vector3();
	    Normalize(value, result);
	    return result;
	}
	
	/**
	 * Creates a unit vector from the specified vector, writing the result to a user-specified variable. The result is a vector one unit in length pointing in the same direction
	 * as the original vector.
	 * 
	 * @param value
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The normalized vector.
	 */
	public static void Normalize(Vector3 value, Vector3 result)
	{
	    float num2 = ((value.X * value.X) + (value.Y * value.Y)) + (value.Z * value.Z);
	    float num = 1f / ((float) Math.sqrt((double) num2));
	    result.X = value.X * num;
	    result.Y = value.Y * num;
	    result.Z = value.Z * num;
	}
	
	/**
	 * Returns the reflection of a vector off a surface that has the specified normal.
	 * 
	 * @param vector
	 * Source vector.
	 * 
	 * @param normal
	 * Normal of the surface.
	 */
	public static Vector3 Reflect(Vector3 vector, Vector3 normal)
	{
	    Vector3 result = new Vector3();
	    Reflect(vector, normal, result);
	    return result;
	}
	
	/**
	 * Returns the reflection of a vector off a surface that has the specified normal.
	 * 
	 * @param vector
	 * Source vector.
	 * 
	 * @param normal
	 * Normal of the surface.
	 * 
	 * @param result
	 * [OutAttribute] The reflected vector.
	 */
	public static void Reflect(Vector3 vector, Vector3 normal, Vector3 result)
	{
	    float num = ((vector.X * normal.X) + (vector.Y * normal.Y)) + (vector.Z * normal.Z);
	    result.X = vector.X - ((2f * num) * normal.X);
	    result.Y = vector.Y - ((2f * num) * normal.Y);
	    result.Z = vector.Z - ((2f * num) * normal.Z);
	}
	
	/**
	 * Interpolates between two values using a cubic equation.
	 * 
	 * @param value1
	 * Source value.
	 * 
	 * @param value2
	 * Source value.
	 * 
	 * @param amount
	 * Weighting value.
	 */
	public static Vector3 SmoothStep(Vector3 value1, Vector3 value2, float amount)
	{
	    Vector3 result = new Vector3();
	    SmoothStep(value1, value2, amount, result);
	    return result;
	}
	
	/**
	 * Interpolates between two values using a cubic equation.
	 * 
	 * @param value1
	 * Source value.
	 * 
	 * @param value2
	 * Source value.
	 * 
	 * @param amount
	 * Weighting value.
	 * 
	 * @param result
	 * [OutAttribute] The interpolated value.
	 */
	public static void SmoothStep(Vector3 value1, Vector3 value2, float amount, Vector3 result)
	{
	    amount = (amount > 1f) ? 1f : ((amount < 0f) ? 0f : amount);
	    amount = (amount * amount) * (3f - (2f * amount));
	    result.X = value1.X + ((value2.X - value1.X) * amount);
	    result.Y = value1.Y + ((value2.Y - value1.Y) * amount);
	    result.Z = value1.Z + ((value2.Z - value1.Z) * amount);
	}
	
	/**
	 * Subtracts the specified vector from the current vector.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Subtract(Vector3 other)
	{
		Subtract(this, other, this);
	}
	
	/**
	 * Subtracts a vector from a vector.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static Vector3 Subtract(Vector3 value1, Vector3 value2)
	{
	    Vector3 result = new Vector3();
	    Subtract(value1, value2, result);
	    return result;
	}
	
	/**
	 * Subtracts a vector from a vector.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The result of the subtraction.
	 */
	public static void Subtract(Vector3 value1, Vector3 value2, Vector3 result)
	{
	    result.X = value1.X - value2.X;
	    result.Y = value1.Y - value2.Y;
	    result.Z = value1.Z - value2.Z;
	}

	/**
	 * Retrieves a string representation of the current object.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{X:%f Y:%f Z:%f}", X, Y, Z);
	}

	/**
	 * Transforms a 3D vector by the given matrix.
	 * 
	 * @param position
	 * The source vector.
	 * 
	 * @param matrix
	 * The transformation matrix.
	 */
	public static Vector3 Transform(Vector3 position, Matrix matrix)
	{
	    Vector3 result = new Vector3();
	    Transform(position, matrix, result);
	    return result;
	}
	
	/**
	 * Transforms a Vector3 by a specified Quaternion rotation.
	 * 
	 * @param value
	 * The Vector3 to rotate.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 */
	public static Vector3 Transform(Vector3 value, Quaternion rotation)
	{
	    Vector3 result = new Vector3();
	    Transform(value, rotation, result);
	    return result;
	}
	
	/**
	 * Transforms a source array of Vector3s by a specified Matrix and writes the results to an existing destination array.
	 * 
	 * @param sourceArray
	 * The source array.
	 * 
	 * @param matrix
	 * The transform Matrix to apply.
	 * 
	 * @param destinationArray
	 * An existing destination array into which the transformed Vector3s are written.
	 */
	public static void Transform(Vector3[] sourceArray, Matrix matrix, Vector3[] destinationArray)
	{
		Transform(sourceArray, 0, matrix, destinationArray, 0, sourceArray.length);
	}
	
	/**
	 * Transforms a source array of Vector3s by a specified Quaternion rotation and writes the results to an existing destination array.
	 * 
	 * @param sourceArray
	 * The source array.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param destinationArray
	 * An existing destination array into which the transformed Vector3s are written.
	 */
	public static void Transform(Vector3[] sourceArray, Quaternion rotation, Vector3[] destinationArray)
	{
		Transform(sourceArray, 0, rotation, destinationArray, 0, sourceArray.length);
	}
	
	/**
	 * Transforms a Vector3 by the given Matrix.
	 * 
	 * @param position
	 * The source Vector3.
	 * 
	 * @param matrix
	 * The transformation Matrix.
	 * 
	 * @param result
	 * [OutAttribute] The transformed vector.
	 */
	public static void Transform(Vector3 position, Matrix matrix, Vector3 result)
	{
	    float num3 = (((position.X * matrix.M11) + (position.Y * matrix.M21)) + (position.Z * matrix.M31)) + matrix.M41;
	    float num2 = (((position.X * matrix.M12) + (position.Y * matrix.M22)) + (position.Z * matrix.M32)) + matrix.M42;
	    float num = (((position.X * matrix.M13) + (position.Y * matrix.M23)) + (position.Z * matrix.M33)) + matrix.M43;
	    result.X = num3;
	    result.Y = num2;
	    result.Z = num;
	}
	
	/**
	 * Transforms a Vector3 by a specified Quaternion rotation.
	 * 
	 * @param value
	 * The Vector3 to rotate.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param result
	 * [OutAttribute] An existing Vector3 filled in with the results of the rotation.
	 */
	public static void Transform(Vector3 value, Quaternion rotation, Vector3 result)
	{
	    float num12 = rotation.X + rotation.X;
	    float num2 = rotation.Y + rotation.Y;
	    float num = rotation.Z + rotation.Z;
	    float num11 = rotation.W * num12;
	    float num10 = rotation.W * num2;
	    float num9 = rotation.W * num;
	    float num8 = rotation.X * num12;
	    float num7 = rotation.X * num2;
	    float num6 = rotation.X * num;
	    float num5 = rotation.Y * num2;
	    float num4 = rotation.Y * num;
	    float num3 = rotation.Z * num;
	    float num15 = ((value.X * ((1f - num5) - num3)) + (value.Y * (num7 - num9))) + (value.Z * (num6 + num10));
	    float num14 = ((value.X * (num7 + num9)) + (value.Y * ((1f - num8) - num3))) + (value.Z * (num4 - num11));
	    float num13 = ((value.X * (num6 - num10)) + (value.Y * (num4 + num11))) + (value.Z * ((1f - num8) - num5));
	    result.X = num15;
	    result.Y = num14;
	    result.Z = num13;
	}
	
	/**
	 * Applies a specified transform Matrix to a specified range of an array of Vector3s and writes the results into a specified range of a destination array.
	 * 
	 * @param sourceArray
	 * The source array.
	 * 
	 * @param sourceIndex
	 * The index in the source array at which to start.
	 * 
	 * @param matrix
	 * The transform Matrix to apply.
	 * 
	 * @param destinationArray
	 * The existing destination array.
	 * 
	 * @param destinationIndex
	 * The index in the destination array at which to start.
	 * 
	 * @param length
	 * The number of Vector3s to transform.
	 */
	public static void Transform(Vector3[] sourceArray, int sourceIndex, Matrix matrix, Vector3[] destinationArray, int destinationIndex, int length)
	{
	    if (sourceArray == null)
	    {
	        throw new ArgumentNullException("sourceArray");
	    }
	    if (destinationArray == null)
	    {
	        throw new ArgumentNullException("destinationArray");
	    }
	    if (sourceArray.length < (sourceIndex + length))
	    {
	        throw new ArgumentException("Source array must be equal or bigger than requested length.");
	    }
	    if (destinationArray.length < (destinationIndex + length))
	    {
	        throw new ArgumentException("Target array size must be equal or bigger than source array size.");
	    }
	    while (length > 0)
	    {
	        float x = sourceArray[sourceIndex].X;
	        float y = sourceArray[sourceIndex].Y;
	        float z = sourceArray[sourceIndex].Z;
	        destinationArray[destinationIndex].X = (((x * matrix.M11) + (y * matrix.M21)) + (z * matrix.M31)) + matrix.M41;
	        destinationArray[destinationIndex].Y = (((x * matrix.M12) + (y * matrix.M22)) + (z * matrix.M32)) + matrix.M42;
	        destinationArray[destinationIndex].Z = (((x * matrix.M13) + (y * matrix.M23)) + (z * matrix.M33)) + matrix.M43;
	        sourceIndex++;
	        destinationIndex++;
	        length--;
	    }
	}
	
	/**
	 * Applies a specified Quaternion rotation to a specified range of an array of Vector3s and writes the results into a specified range of a destination array.
	 * 
	 * @param sourceArray
	 * The source array.
	 * 
	 * @param sourceIndex
	 * The index in the source array at which to start.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param destinationArray
	 * The existing destination array.
	 * 
	 * @param destinationIndex
	 * The index in the destination array at which to start.
	 * 
	 * @param length
	 * The number of Vector3s to transform.
	 */
	public static void Transform(Vector3[] sourceArray, int sourceIndex, Quaternion rotation, Vector3[] destinationArray, int destinationIndex, int length)
	{
	    if (sourceArray == null)
	    {
	        throw new ArgumentNullException("sourceArray");
	    }
	    if (destinationArray == null)
	    {
	        throw new ArgumentNullException("destinationArray");
	    }
	    if (sourceArray.length < (sourceIndex + length))
	    {
	        throw new ArgumentException("Source array must be equal or bigger than requested length.");
	    }
	    if (destinationArray.length < (destinationIndex + length))
	    {
	        throw new ArgumentException("Target array size must be equal to, or bigger than source array size.");
	    }
	    float num15 = rotation.X + rotation.X;
	    float num5 = rotation.Y + rotation.Y;
	    float num = rotation.Z + rotation.Z;
	    float num14 = rotation.W * num15;
	    float num13 = rotation.W * num5;
	    float num12 = rotation.W * num;
	    float num11 = rotation.X * num15;
	    float num10 = rotation.X * num5;
	    float num9 = rotation.X * num;
	    float num8 = rotation.Y * num5;
	    float num7 = rotation.Y * num;
	    float num6 = rotation.Z * num;
	    float num24 = (1f - num8) - num6;
	    float num23 = num10 - num12;
	    float num22 = num9 + num13;
	    float num21 = num10 + num12;
	    float num20 = (1f - num11) - num6;
	    float num19 = num7 - num14;
	    float num18 = num9 - num13;
	    float num17 = num7 + num14;
	    float num16 = (1f - num11) - num8;
	    while (length > 0)
	    {
	        float x = sourceArray[sourceIndex].X;
	        float y = sourceArray[sourceIndex].Y;
	        float z = sourceArray[sourceIndex].Z;
	        destinationArray[destinationIndex].X = ((x * num24) + (y * num23)) + (z * num22);
	        destinationArray[destinationIndex].Y = ((x * num21) + (y * num20)) + (z * num19);
	        destinationArray[destinationIndex].Z = ((x * num18) + (y * num17)) + (z * num16);
	        sourceIndex++;
	        destinationIndex++;
	        length--;
	    }
	}
	
	/**
	 * Transforms a 3D vector normal by a matrix.
	 * 
	 * @param normal
	 * The source vector.
	 * 
	 * @param matrix
	 * The transformation matrix.
	 */
	public static Vector3 TransformNormal(Vector3 normal, Matrix matrix)
	{
	    Vector3 result = new Vector3();
	    TransformNormal(normal, matrix, result);
	    return result;
	}
	
	/**
	 * Transforms an array of 3D vector normals by a specified Matrix.
	 * 
	 * @param sourceArray
	 * The array of Vector3 normals to transform.
	 * 
	 * @param matrix
	 * The transform matrix to apply.
	 * 
	 * @param destinationArray
	 * An existing Vector3 array into which the results of the transforms are written.
	 */
	public static void TransformNormal(Vector3[] sourceArray, Matrix matrix, Vector3[] destinationArray)
	{
	    TransformNormal(sourceArray, 0, matrix, destinationArray, 0, sourceArray.length);
	}
	
	/**
	 * Transforms a vector normal by a matrix.
	 * 
	 * @param normal
	 * The source vector.
	 * 
	 * @param matrix
	 * The transformation Matrix.
	 * 
	 * @param result
	 * [OutAttribute] The Vector3 resulting from the transformation.
	 */
	public static void TransformNormal(Vector3 normal, Matrix matrix, Vector3 result)
	{
	    float num3 = ((normal.X * matrix.M11) + (normal.Y * matrix.M21)) + (normal.Z * matrix.M31);
	    float num2 = ((normal.X * matrix.M12) + (normal.Y * matrix.M22)) + (normal.Z * matrix.M32);
	    float num = ((normal.X * matrix.M13) + (normal.Y * matrix.M23)) + (normal.Z * matrix.M33);
	    result.X = num3;
	    result.Y = num2;
	    result.Z = num;
	}
	
	/**
	 * Transforms a specified range in an array of 3D vector normals by a specified Matrix and writes the results to a specified range in a destination array.
	 * 
	 * @param sourceArray
	 * The source array of Vector3 normals.
	 * 
	 * @param sourceIndex
	 * The starting index in the source array.
	 * 
	 * @param matrix
	 * The transform Matrix to apply.
	 * 
	 * @param destinationArray
	 * The destination Vector3 array.
	 * 
	 * @param destinationIndex
	 * The starting index in the destination array.
	 * 
	 * @param length
	 * The number of vectors to transform.
	 */
	public static void TransformNormal(Vector3[] sourceArray, int sourceIndex, Matrix matrix, Vector3[] destinationArray, int destinationIndex, int length)
	{
	    if (sourceArray == null)
	    {
	        throw new ArgumentNullException("sourceArray");
	    }
	    if (destinationArray == null)
	    {
	        throw new ArgumentNullException("destinationArray");
	    }
	    if (sourceArray.length < (sourceIndex + length))
	    {
	        throw new ArgumentException("Source array must be equal or bigger than requested length.");
	    }
	    if (destinationArray.length < (destinationIndex + length))
	    {
	        throw new ArgumentException("Target array size must be equal to, or bigger than source array size.");
	    }
	    while (length > 0)
	    {
	        float x = sourceArray[sourceIndex].X;
	        float y = sourceArray[sourceIndex].Y;
	        float z = sourceArray[sourceIndex].Z;
	        destinationArray[destinationIndex].X = ((x * matrix.M11) + (y * matrix.M21)) + (z * matrix.M31);
	        destinationArray[destinationIndex].Y = ((x * matrix.M12) + (y * matrix.M22)) + (z * matrix.M32);
	        destinationArray[destinationIndex].Z = ((x * matrix.M13) + (y * matrix.M23)) + (z * matrix.M33);
	        sourceIndex++;
	        destinationIndex++;
	        length--;
	    }
	}
}
