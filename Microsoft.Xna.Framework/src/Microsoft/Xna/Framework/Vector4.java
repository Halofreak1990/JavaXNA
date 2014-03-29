package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a vector with four components.
 *
 * @author Halofreak1990
 */
public final class Vector4 extends ValueType implements IEquatable<Vector4>
{
	/**
	 * Returns a Vector4 with all of its components set to one.
	 */
	public static final Vector4 One = new Vector4(1f, 1f, 1f, 1f);
	/**
	 * Returns the Vector4 (0, 0, 0, 1).
	 */
	public static final Vector4 UnitW = new Vector4(1f, 1f, 1f, 1f);
	/**
	 * Returns the Vector4 (1, 0, 0, 0).
	 */
	public static final Vector4 UnitX = new Vector4(1f, 0f, 0f, 0f);
	/**
	 * Returns the Vector4 (0, 1, 0, 0).
	 */
	public static final Vector4 UnitY = new Vector4(0f, 1f, 0f, 0f);
	/**
	 * Returns the Vector4 (0, 0, 1, 0).
	 */
	public static final Vector4 UnitZ = new Vector4(0f, 0f, 1f, 0f);
	/**
	 * Gets or sets the w-component of the vector.
	 */
	public float W;
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
	 * Returns a Vector4 with all of its components set to zero.
	 */
	public static final Vector4 Zero = new Vector4(0f, 0f, 0f, 0f);

	/**
	 * Creates a new instance of Vector4.
	 * 
	 * @param value
	 * Value to initialize each component to.
	 */
	public Vector4(float value)
	{
		this.X = this.Y = this.Z = this.W = value;
	}

	/**
	 * Creates a new instance of Vector4.
	 * 
	 * @param value
	 * A vector containing the values to initialize x, y, and z components with.
	 * 
	 * @param w
	 * Initial value for the w-component of the vector.
	 */
	public Vector4(Vector3 value, float w)
	{
		this.X = value.X;
		this.Y = value.Y;
		this.Z = value.Z;
		this.W = w;
	}

	/**
	 * Creates a new instance of Vector4.
	 * 
	 * @param value
	 * A vector containing the values to initialize x and y components with.
	 * 
	 * @param z
	 * Initial value for the z-component of the vector.
	 * 
	 * @param w
	 * Initial value for the w-component of the vector.
	 */
	public Vector4(Vector2 value, float z, float w)
	{
		this.X = value.X;
		this.Y = value.Y;
		this.Z = z;
		this.W = w;
	}

	/**
	 * Creates a new instance of Vector4.
	 * 
	 * @param x
	 * Initial value for the x-component of the vector.
	 * @param y
	 * Initial value for the y-component of the vector.
	 * @param z
	 * Initial value for the z-component of the vector.
	 * 
	 * @param w
	 * Initial value for the w-component of the vector.
	 */
	public Vector4(float x, float y, float z, float w)
	{
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.W = w;
	}

	/**
	 * Creates a new instance of Vector4.
	 */
	public Vector4()
	{
		this.X = this.Y = this.Z = this.W = 0f;
	}

	/**
	 * Adds the specified vector to the current vector.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Add(Vector4 other)
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
	public static Vector4 Add(Vector4 value1, Vector4 value2)
	{
		Vector4 result = new Vector4();
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
	public static void Add(Vector4 value1, Vector4 value2, Vector4 result)
	{
		result.X = value1.X + value2.X;
		result.Y = value1.Y + value2.Y;
		result.Z = value1.Z + value2.Z;
		result.W = value1.W + value2.W;
	}

	/**
	 * Returns a Vector4 containing the 4D Cartesian coordinates of a point specified in barycentric (areal) coordinates relative to a 4D triangle.
	 * 
	 * @param value1
	 * A Vector4 containing the 4D Cartesian coordinates of vertex 1 of the triangle.
	 * 
	 * @param value2
	 * A Vector4 containing the 4D Cartesian coordinates of vertex 2 of the triangle.
	 * 
	 * @param value3
	 * A Vector4 containing the 4D Cartesian coordinates of vertex 4 of the triangle.
	 * 
	 * @param amount1
	 * Barycentric coordinate b2, which expresses the weighting factor toward vertex 2 (specified in value2).
	 * 
	 * @param amount2
	 * Barycentric coordinate b3, which expresses the weighting factor toward vertex 3 (specified in value3).
	 */
	public static Vector4 Barycentric(Vector4 value1, Vector4 value2, Vector4 value3, float amount1, float amount2)
	{
		Vector4 result = new Vector4();
		Barycentric(value1, value2, value3, amount1, amount2, result);
		return result;
	}

	/**
	 * Returns a Vector4 containing the 4D Cartesian coordinates of a point specified in barycentric (areal) coordinates relative to a 4D triangle.
	 * 
	 * @param value1
	 * A Vector4 containing the 4D Cartesian coordinates of vertex 1 of the triangle.
	 * 
	 * @param value2
	 * A Vector4 containing the 4D Cartesian coordinates of vertex 2 of the triangle.
	 * 
	 * @param value3
	 * A Vector4 containing the 4D Cartesian coordinates of vertex 4 of the triangle.
	 * 
	 * @param amount1
	 * Barycentric coordinate b2, which expresses the weighting factor toward vertex 2 (specified in value2).
	 * 
	 * @param amount2
	 * Barycentric coordinate b3, which expresses the weighting factor toward vertex 3 (specified in value3).
	 * 
	 * @param result
	 * [OutAttribute] The 4D Cartesian coordinates of the specified point are placed in this Vector4 on exit.
	 */
	public static void Barycentric(Vector4 value1, Vector4 value2, Vector4 value3, float amount1, float amount2, Vector4 result)
	{
		result.X = (value1.X + (amount1 * (value2.X - value1.X))) + (amount2 * (value3.X - value1.X));
		result.Y = (value1.Y + (amount1 * (value2.Y - value1.Y))) + (amount2 * (value3.Y - value1.Y));
		result.Z = (value1.Z + (amount1 * (value2.Z - value1.Z))) + (amount2 * (value3.Z - value1.Z));
		result.W = (value1.W + (amount1 * (value2.W - value1.W))) + (amount2 * (value3.W - value1.W));
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
	public static Vector4 CatmullRom(Vector4 value1, Vector4 value2, Vector4 value3, Vector4 value4, float amount)
	{
		Vector4 result = new Vector4();
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
	public static void CatmullRom(Vector4 value1, Vector4 value2, Vector4 value3, Vector4 value4, float amount, Vector4 result)
	{
		float num = amount * amount;
		float num2 = amount * num;
		result.X = 0.5f * ((((2f * value2.X) + ((-value1.X + value3.X) * amount)) + (((((2f * value1.X) - (5f * value2.X)) + (4f * value3.X)) - value4.X) * num)) + ((((-value1.X + (3f * value2.X)) - (3f * value3.X)) + value4.X) * num2));
		result.Y = 0.5f * ((((2f * value2.Y) + ((-value1.Y + value3.Y) * amount)) + (((((2f * value1.Y) - (5f * value2.Y)) + (4f * value3.Y)) - value4.Y) * num)) + ((((-value1.Y + (3f * value2.Y)) - (3f * value3.Y)) + value4.Y) * num2));
		result.Z = 0.5f * ((((2f * value2.Z) + ((-value1.Z + value3.Z) * amount)) + (((((2f * value1.Z) - (5f * value2.Z)) + (4f * value3.Z)) - value4.Z) * num)) + ((((-value1.Z + (3f * value2.Z)) - (3f * value3.Z)) + value4.Z) * num2));
		result.W = 0.5f * ((((2f * value2.W) + ((-value1.W + value3.W) * amount)) + (((((2f * value1.W) - (5f * value2.W)) + (4f * value3.W)) - value4.W) * num)) + ((((-value1.W + (3f * value2.W)) - (3f * value3.W)) + value4.W) * num2));
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
	public static Vector4 Clamp(Vector4 value1, Vector4 min, Vector4 max)
	{
		Vector4 result = new Vector4();
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
	public static void Clamp(Vector4 value1, Vector4 min, Vector4 max, Vector4 result)
	{
		result.X = MathHelper.Clamp(value1.X, min.X, max.X);
		result.Y = MathHelper.Clamp(value1.Y, min.Y, max.Y);
		result.Z = MathHelper.Clamp(value1.Z, min.Z, max.Z);
		result.W = MathHelper.Clamp(value1.W, min.W, max.W);
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
	public static float Distance(Vector4 value1, Vector4 value2)
	{
		float num4 = value1.X - value2.X;
		float num3 = value1.Y - value2.Y;
		float num2 = value1.Z - value2.Z;
		float num = value1.W - value2.W;
		float num5 = (((num4 * num4) + (num3 * num3)) + (num2 * num2)) + (num * num);

		return (float) Math.sqrt((double) num5);
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
	public static float DistanceSquared(Vector4 value1, Vector4 value2)
	{
		float num4 = value1.X - value2.X;
		float num3 = value1.Y - value2.Y;
		float num2 = value1.Z - value2.Z;
		float num = value1.W - value2.W;

		return ((((num4 * num4) + (num3 * num3)) + (num2 * num2)) + (num * num));
	}

	/**
	 * Divides the components of the current vector by the components of another vector.
	 * 
	 * @param other
	 * Divisor vector.
	 */
	public void Divide(Vector4 other)
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
	 * Divisor vector.
	 */
	public static Vector4 Divide(Vector4 value1, Vector4 value2)
	{
		Vector4 result = new Vector4();
		Divide(value1, value2, result);
		return result;
	}

	/**
	 * Divides the current vector by a scalar value.
	 * 
	 * @param divider
	 * The divisor.
	 */
	public void Divide(float divider)
	{
		Divide(this, divider, this);
	}

	/**
	 * Divides a vector by a scalar value.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param divider
	 * The divisor.
	 */
	public static Vector4 Divide(Vector4 value1, float divider)
	{
		Vector4 result = new Vector4();
		Divide(value1, divider, result);
		return result;
	}

	/**
	 * Divides the components of a vector by the components of another vector.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Divisor vector.
	 * 
	 * @param result
	 * [OutAttribute] The result of the division.
	 */
	public static void Divide(Vector4 value1, Vector4 value2, Vector4 result)
	{
		result.X = value1.X / value2.X;
		result.Y = value1.Y / value2.Y;
		result.Z = value1.Z / value2.Z;
		result.W = value1.W / value2.W;
	}

	/**
	 * Divides a vector by a scalar value.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param divider
	 * The divisor.
	 * 
	 * @param result
	 * [OutAttribute] The result of the division.
	 */
	public static void Divide(Vector4 value1, float divider, Vector4 result)
	{
		float num = 1f / divider;
		result.X = value1.X * num;
		result.Y = value1.Y * num;
		result.Z = value1.Z * num;
		result.W = value1.W * num;
	}

	/**
	 * Calculates the dot product of two vectors.
	 * 
	 * @param vector1
	 * Source vector.
	 * 
	 * @param vector2
	 * Source vector.
	 */
	public static float Dot(Vector4 vector1, Vector4 vector2)
	{
		return ((((vector1.X * vector2.X) + (vector1.Y * vector2.Y)) + (vector1.Z * vector2.Z)) + (vector1.W * vector2.W));
	}

	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * Object with which to make the comparison.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Vector4) ? this.Equals((Vector4)obj) : false;
	}

	/**
	 * Determines whether the specified Object is equal to the Vector4.
	 * 
	 * @param other
	 * The Vector4 to compare with the current Vector4.
	 */
	public boolean Equals(Vector4 other)
	{
		return ((((this.X == other.X) && (this.Y == other.Y)) && (this.Z == other.Z)) && (this.W == other.W));
	}

	/**
	 * Gets the hash code of this object.
	 */
	@Override
	public int hashCode()
	{
		return ((((int)this.X ^ (int)this.Y) ^ (int)this.Z) ^ (int)this.W);
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
	public static Vector4 Hermite(Vector4 value1, Vector4 tangent1, Vector4 value2, Vector4 tangent2, float amount)
	{
		Vector4 result = new Vector4();
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
	public static void Hermite(Vector4 value1, Vector4 tangent1, Vector4 value2, Vector4 tangent2, float amount, Vector4 result)
	{
		float num = amount * amount;
		float num6 = amount * num;
		float num5 = ((2f * num6) - (3f * num)) + 1f;
		float num4 = (-2f * num6) + (3f * num);
		float num3 = (num6 - (2f * num)) + amount;
		float num2 = num6 - num;
		result.X = (((value1.X * num5) + (value2.X * num4)) + (tangent1.X * num3)) + (tangent2.X * num2);
		result.Y = (((value1.Y * num5) + (value2.Y * num4)) + (tangent1.Y * num3)) + (tangent2.Y * num2);
		result.Z = (((value1.Z * num5) + (value2.Z * num4)) + (tangent1.Z * num3)) + (tangent2.Z * num2);
		result.W = (((value1.W * num5) + (value2.W * num4)) + (tangent1.W * num3)) + (tangent2.W * num2);
	}

	/**
	 * Calculates the length of the vector.
	 */
	public float Length()
	{
		float num = (((this.X * this.X) + (this.Y * this.Y)) + (this.Z * this.Z)) + (this.W * this.W);

		return (float) Math.sqrt((double) num);
	}
	
	/**
	 * Calculates the length of the vector squared.
	 */
	public float LengthSquared()
	{
		return ((((this.X * this.X) + (this.Y * this.Y)) + (this.Z * this.Z)) + (this.W * this.W));
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
	public static Vector4 Lerp(Vector4 value1, Vector4 value2, float amount)
	{
		Vector4 result = new Vector4();
		Lerp(value1, value2, amount);
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
	public static void Lerp(Vector4 value1, Vector4 value2, float amount, Vector4 result)
	{
		result.X = value1.X + ((value2.X - value1.X) * amount);
		result.Y = value1.Y + ((value2.Y - value1.Y) * amount);
		result.Z = value1.Z + ((value2.Z - value1.Z) * amount);
		result.W = value1.W + ((value2.W - value1.W) * amount);
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
	public static Vector4 Max(Vector4 value1, Vector4 value2)
	{
		Vector4 result = new Vector4();
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
	public static void Max(Vector4 value1, Vector4 value2, Vector4 result)
	{
		result.X = (value1.X > value2.X) ? value1.X : value2.X;
		result.Y = (value1.Y > value2.Y) ? value1.Y : value2.Y;
		result.Z = (value1.Z > value2.Z) ? value1.Z : value2.Z;
		result.W = (value1.W > value2.W) ? value1.W : value2.W;
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
	public static Vector4 Min(Vector4 value1, Vector4 value2)
	{
		Vector4 result = new Vector4();
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
	public static void Min(Vector4 value1, Vector4 value2, Vector4 result)
	{
		result.X = (value1.X < value2.X) ? value1.X : value2.X;
		result.Y = (value1.Y < value2.Y) ? value1.Y : value2.Y;
		result.Z = (value1.Z < value2.Z) ? value1.Z : value2.Z;
		result.W = (value1.W < value2.W) ? value1.W : value2.W;
	}

	/**
	 * Multiplies the components of the current vector by the components of another vector.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Multiply(Vector4 other)
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
	public static Vector4 Multiply(Vector4 value1, Vector4 value2)
	{
		Vector4 result = new Vector4();
		Multiply(value1, value2, result);
		return result;
	}

	/**
	 * Multiplies the current vector by a scalar.
	 * 
	 * @param scaleFactor
	 * Scalar value.
	 */
	public void Multiply(float scaleFactor)
	{
		Multiply(this, scaleFactor, this);
	}

	/**
	 * Multiplies a vector by a scalar.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param scaleFactor
	 * Scalar value.
	 */
	public static Vector4 Multiply(Vector4 value1, float scaleFactor)
	{
		Vector4 result = new Vector4();
		Multiply(value1, scaleFactor, result);
		return result;
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
	public static void Multiply(Vector4 value1, Vector4 value2, Vector4 result)
	{
		result.X = value1.X * value2.X;
		result.Y = value1.Y * value2.Y;
		result.Z = value1.Z * value2.Z;
		result.W = value1.W * value2.W;
	}

	/**
	 * Multiplies a vector by a scalar.
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
	public static void Multiply(Vector4 value1, float scaleFactor, Vector4 result)
	{
		result.X = value1.X * scaleFactor;
		result.Y = value1.Y * scaleFactor;
		result.Z = value1.Z * scaleFactor;
		result.W = value1.W * scaleFactor;
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
	public static Vector4 Negate(Vector4 value)
	{
		Vector4 result = new Vector4();
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
	public static void Negate(Vector4 value, Vector4 result)
	{
		result.X = -value.X;
		result.Y = -value.Y;
		result.Z = -value.Z;
		result.W = -value.W;
	}

	/**
	 * Turns the current vector into a unit vector.
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
	 * Creates a unit vector from the specified vector.
	 * 
	 * @param vector
	 * Source vector.
	 */
	public static Vector4 Normalize(Vector4 vector)
	{
		Vector4 result = new Vector4();
		Normalize(vector, result);
		return result;
	}

	/**
	 * Returns a normalized version of the specified vector.
	 * 
	 * @param vector
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The normalized vector.
	 */
	public static void Normalize(Vector4 vector, Vector4 result)
	{
		float num2 = (((vector.X * vector.X) + (vector.Y * vector.Y)) + (vector.Z * vector.Z)) + (vector.W * vector.W);
		float num = 1f / ((float) Math.sqrt((double) num2));
		result.X = vector.X * num;
		result.Y = vector.Y * num;
		result.Z = vector.Z * num;
		result.W = vector.W * num;
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
	public static Vector4 SmoothStep(Vector4 value1, Vector4 value2, float amount)
	{
		Vector4 result = new Vector4();
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
	public static void SmoothStep(Vector4 value1, Vector4 value2, float amount, Vector4 result)
	{
		amount = (amount > 1f) ? 1f : ((amount < 0f) ? 0f : amount);
		amount = (amount * amount) * (3f - (2f * amount));
		result.X = value1.X + ((value2.X - value1.X) * amount);
		result.Y = value1.Y + ((value2.Y - value1.Y) * amount);
		result.Z = value1.Z + ((value2.Z - value1.Z) * amount);
		result.W = value1.W + ((value2.W - value1.W) * amount);
	}

	/**
	 * Subtracts a vector from the current vector.
	 * 
	 * @param other
	 */
	public void Subtract(Vector4 other)
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
	public static Vector4 Subtract(Vector4 value1, Vector4 value2)
	{
		Vector4 result = new Vector4();
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
	public static void Subtract(Vector4 value1, Vector4 value2, Vector4 result)
	{
		result.X = value1.X - value2.X;
		result.Y = value1.Y - value2.Y;
		result.Z = value1.Z - value2.Z;
		result.W = value1.W - value2.W;
	}

	/**
	 * Retrieves a string representation of the current object.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{X:%f Y:%f Z:%f W:%f}", this.X, this.Y, this.Z, this.W);
	}

	/**
	 * Transforms a Vector2 by the given Matrix.
	 * 
	 * @param position
	 * The source Vector2.
	 * 
	 * @param matrix
	 * The transformation Matrix.
	 */
	public static Vector4 Transform(Vector2 position, Matrix matrix)
	{
		Vector4 result = new Vector4();
		Transform(position, matrix, result);
		return result;
	}

	/**
	 * Transforms a Vector2 by a specified Quaternion into a Vector4.
	 * 
	 * @param value
	 * The Vector2 to transform.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 */
	public static Vector4 Transform(Vector2 value, Quaternion rotation)
	{
		Vector4 result = new Vector4();
		Transform(value, rotation, result);
		return result;
	}

	/**
	 * Transforms a Vector3 by the given Matrix.
	 * 
	 * @param position
	 * The source Vector3.
	 * 
	 * @param matrix
	 * The transformation Matrix.
	 */
	public static Vector4 Transform(Vector3 position, Matrix matrix)
	{
		Vector4 result = new Vector4();
		Transform(position, matrix, result);
		return result;
	}

	/**
	 * Transforms a Vector3 by a specified Quaternion into a Vector4.
	 * 
	 * @param value
	 * The Vector3 to transform.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 */
	public static Vector4 Transform(Vector3 value, Quaternion rotation)
	{
		Vector4 result = new Vector4();
		Transform(value, rotation, result);
		return result;
	}

	/**
	 * Transforms a Vector4 by the specified Matrix.
	 * 
	 * @param vector
	 * The source Vector4.
	 * 
	 * @param matrix
	 * The transformation Matrix.
	 */
	public static Vector4 Transform(Vector4 vector, Matrix matrix)
	{
		Vector4 result = new Vector4();
		Transform(vector, matrix, result);
		return result;
	}

	/**
	 * Transforms a Vector4 by a specified Quaternion.
	 * 
	 * @param value
	 * The Vector4 to transform.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 */
	public static Vector4 Transform(Vector4 value, Quaternion rotation)
	{
		Vector4 result = new Vector4();
		Transform(value, rotation, result);
		return result;
	}

	/**
	 * Transforms an array of Vector4s by a specified Quaternion.
	 * 
	 * @param sourceArray
	 * The array of Vector4s to transform.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param destinationArray
	 * The existing destination array into which the transformed Vector4s are written.
	 */
	public static void Transform(Vector4[] sourceArray, Quaternion rotation, Vector4[] destinationArray)
	{
		Transform(sourceArray, 0, rotation, destinationArray, 0, sourceArray.length);
	}

	/**
	 * Transforms a Vector2 by the given Matrix.
	 * 
	 * @param position
	 * The source Vector2.
	 * 
	 * @param matrix
	 * The transformation Matrix.
	 * 
	 * @param result
	 * [OutAttribute] The Vector4 resulting from the transformation.
	 */
	public static void Transform(Vector2 position, Matrix matrix, Vector4 result)
	{
		float num4 = ((position.X * matrix.M11) + (position.Y * matrix.M21)) + matrix.M41;
		float num3 = ((position.X * matrix.M12) + (position.Y * matrix.M22)) + matrix.M42;
		float num2 = ((position.X * matrix.M13) + (position.Y * matrix.M23)) + matrix.M43;
		float num = ((position.X * matrix.M14) + (position.Y * matrix.M24)) + matrix.M44;
		result.X = num4;
		result.Y = num3;
		result.Z = num2;
		result.W = num;
	}

	/**
	 * Transforms a Vector2 by a specified Quaternion into a Vector4.
	 * 
	 * @param value
	 * The Vector2 to transform.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param result
	 * [OutAttribute] The Vector4 resulting from the transformation.
	 */
	public static void Transform(Vector2 value, Quaternion rotation, Vector4 result)
	{
		float num6 = rotation.X + rotation.X;
		float num2 = rotation.Y + rotation.Y;
		float num = rotation.Z + rotation.Z;
		float num15 = rotation.W * num6;
		float num14 = rotation.W * num2;
		float num5 = rotation.W * num;
		float num13 = rotation.X * num6;
		float num4 = rotation.X * num2;
		float num12 = rotation.X * num;
		float num11 = rotation.Y * num2;
		float num10 = rotation.Y * num;
		float num3 = rotation.Z * num;
		float num9 = (value.X * ((1f - num11) - num3)) + (value.Y * (num4 - num5));
		float num8 = (value.X * (num4 + num5)) + (value.Y * ((1f - num13) - num3));
		float num7 = (value.X * (num12 - num14)) + (value.Y * (num10 + num15));
		result.X = num9;
		result.Y = num8;
		result.Z = num7;
		result.W = 1f;
	}

	/**
	 * Transforms an array of Vector4s by a specified Matrix.
	 * 
	 * @param sourceArray
	 * The array of Vector4s to transform.
	 * 
	 * @param matrix
	 * The transform Matrix to apply.
	 * 
	 * @param destinationArray
	 * The existing destination array into which the transformed Vector4s are written.
	 */
	public static void Transform(Vector4[] sourceArray, Matrix matrix, Vector4[] destinationArray)
	{
		Transform(sourceArray, 0, matrix, destinationArray, 0, sourceArray.length);
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
	 * [OutAttribute] The Vector4 resulting from the transformation.
	 */
	public static void Transform(Vector3 position, Matrix matrix, Vector4 result)
	{
		float num4 = (((position.X * matrix.M11) + (position.Y * matrix.M21)) + (position.Z * matrix.M31)) + matrix.M41;
		float num3 = (((position.X * matrix.M12) + (position.Y * matrix.M22)) + (position.Z * matrix.M32)) + matrix.M42;
		float num2 = (((position.X * matrix.M13) + (position.Y * matrix.M23)) + (position.Z * matrix.M33)) + matrix.M43;
		float num = (((position.X * matrix.M14) + (position.Y * matrix.M24)) + (position.Z * matrix.M34)) + matrix.M44;
		result.X = num4;
		result.Y = num3;
		result.Z = num2;
		result.W = num;
	}

	/**
	 * Transforms a Vector3 by a specified Quaternion into a Vector4.
	 * 
	 * @param value
	 * The Vector3 to transform.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param result
	 * [OutAttribute] The Vector4 resulting from the transformation.
	 */
	public static void Transform(Vector3 value, Quaternion rotation, Vector4 result)
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
		result.W = 1f;
	}

	/**
	 * Transforms a Vector4 by the given Matrix.
	 * 
	 * @param vector
	 * The source Vector4.
	 * 
	 * @param matrix
	 * The transformation Matrix.
	 * 
	 * @param result
	 * [OutAttribute] The Vector4 resulting from the transformation.
	 */
	public static void Transform(Vector4 vector, Matrix matrix, Vector4 result)
	{
		float num4 = (((vector.X * matrix.M11) + (vector.Y * matrix.M21)) + (vector.Z * matrix.M31)) + (vector.W * matrix.M41);
		float num3 = (((vector.X * matrix.M12) + (vector.Y * matrix.M22)) + (vector.Z * matrix.M32)) + (vector.W * matrix.M42);
		float num2 = (((vector.X * matrix.M13) + (vector.Y * matrix.M23)) + (vector.Z * matrix.M33)) + (vector.W * matrix.M43);
		float num = (((vector.X * matrix.M14) + (vector.Y * matrix.M24)) + (vector.Z * matrix.M34)) + (vector.W * matrix.M44);
		result.X = num4;
		result.Y = num3;
		result.Z = num2;
		result.W = num;
	}

	/**
	 * Transforms a Vector4 by a specified Quaternion.
	 * 
	 * @param value
	 * The Vector4 to transform.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param result
	 * [OutAttribute] The Vector4 resulting from the transformation.
	 */
	public static void Transform(Vector4 value, Quaternion rotation, Vector4 result)
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
		result.W = value.W;
	}

	/**
	 * Transforms a specified range in an array of Vector4s by a specified Matrix into a specified range in a destination array.
	 * 
	 * @param sourceArray
	 * The array of Vector4s containing the range to transform.
	 * 
	 * @param sourceIndex
	 * The index in the source array of the first Vector4 to transform.
	 * 
	 * @param matrix
	 * The transform Matrix to apply.
	 * 
	 * @param destinationArray
	 * The existing destination array of Vector4s into which to write the results.
	 * 
	 * @param destinationIndex
	 * The index in the destination array of the first result Vector4 to write.
	 * 
	 * @param length
	 * The number of Vector4s to transform.
	 */
	public static void Transform(Vector4[] sourceArray, int sourceIndex, Matrix matrix, Vector4[] destinationArray, int destinationIndex, int length)
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
			float w = sourceArray[sourceIndex].W;
			destinationArray[destinationIndex].X = (((x * matrix.M11) + (y * matrix.M21)) + (z * matrix.M31)) + (w * matrix.M41);
			destinationArray[destinationIndex].Y = (((x * matrix.M12) + (y * matrix.M22)) + (z * matrix.M32)) + (w * matrix.M42);
			destinationArray[destinationIndex].Z = (((x * matrix.M13) + (y * matrix.M23)) + (z * matrix.M33)) + (w * matrix.M43);
			destinationArray[destinationIndex].W = (((x * matrix.M14) + (y * matrix.M24)) + (z * matrix.M34)) + (w * matrix.M44);
			sourceIndex++;
			destinationIndex++;
			length--;
		}
	}

	/**
	 * Transforms a specified range in an array of Vector4s by a specified Quaternion into a specified range in a destination array.
	 * 
	 * @param sourceArray
	 * The array of Vector4s containing the range to transform.
	 * 
	 * @param sourceIndex
	 * The index in the source array of the first Vector4 to transform.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param destinationArray
	 * The existing destination array of Vector4s into which to write the results.
	 * 
	 * @param destinationIndex
	 * The index in the destination array of the first result Vector4 to write.
	 * 
	 * @param length
	 * The number of Vector4s to transform.
	 */
	public static void Transform(Vector4[] sourceArray, int sourceIndex, Quaternion rotation, Vector4[] destinationArray, int destinationIndex, int length)
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
			throw new ArgumentException("Source array must be equal to, or bigger than requested length.");
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
		float num25 = (1f - num8) - num6;
		float num24 = num10 - num12;
		float num23 = num9 + num13;
		float num22 = num10 + num12;
		float num21 = (1f - num11) - num6;
		float num20 = num7 - num14;
		float num19 = num9 - num13;
		float num18 = num7 + num14;
		float num17 = (1f - num11) - num8;

		while (length > 0)
		{
			float x = sourceArray[sourceIndex].X;
			float y = sourceArray[sourceIndex].Y;
			float z = sourceArray[sourceIndex].Z;
			float w = sourceArray[sourceIndex].W;
			destinationArray[destinationIndex].X = ((x * num25) + (y * num24)) + (z * num23);
			destinationArray[destinationIndex].Y = ((x * num22) + (y * num21)) + (z * num20);
			destinationArray[destinationIndex].Z = ((x * num19) + (y * num18)) + (z * num17);
			destinationArray[destinationIndex].W = w;
			sourceIndex++;
			destinationIndex++;
			length--;
		}
	}
}
