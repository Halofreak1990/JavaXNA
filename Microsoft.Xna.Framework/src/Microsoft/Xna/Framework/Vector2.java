package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a vector with two components.
 * 
 * @author Halofreak1990
 */
public final class Vector2 extends ValueType implements IEquatable<Vector2>
{
	/**
	 * Returns a Vector2 with both of its components set to one.
	 */
	public static final Vector2 One = new Vector2(1f, 1f);
	/**
	 * Returns the unit vector for the x-axis.
	 */
	public static final Vector2 UnitX = new Vector2(1f, 0f);
	/**
	 * Returns the unit vector for the y-axis.
	 */
	public static final Vector2 UnitY = new Vector2(0f, 1f);
	/**
	 * Gets or sets the x-component of the vector.
	 */
	public float X;
	/**
	 * Gets or sets the y-component of the vector.
	 */
	public float Y;
	/**
	 * Returns a Vector2 with all of its components set to zero.
	 */
	public static final Vector2 Zero = new Vector2(0f, 0f);

	/**
	 * Initializes a new instance of Vector2.
	 * 
	 * @param x
	 * Initial value for the x-component of the vector.
	 * 
	 * @param y
	 * Initial value for the y-component of the vector.
	 */
	public Vector2(float x, float y)
	{
		this.X = x;
		this.Y = y;
	}

	/**
	 * Initializes a new instance of Vector2.
	 * 
	 * @param value
	 * Value to initialize both components to.
	 */
	public Vector2(float value)
	{
		this.X = this.Y = value;
	}

	/**
	 * Initializes a new instance of Vector2.
	 */
	public Vector2()
	{
		this.X = this.Y = 0f;
	}

	/**
	 * Adds the specified Vector2 to the current Vector2.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Add(Vector2 other)
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
	public static Vector2 Add(Vector2 value1, Vector2 value2)
	{
		return new Vector2(value1.X + value2.X, value1.Y + value2.Y);
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
	public static void Add(Vector2 value1, Vector2 value2, Vector2 result)
	{
		result.X = value1.X + value2.X;
		result.Y = value1.Y + value2.Y;
	}

	/**
	 * Returns a Vector2 containing the 2D Cartesian coordinates of a point specified in barycentric (areal) coordinates relative to a 2D triangle.
	 * 
	 * @param value1
	 * A Vector2 containing the 2D Cartesian coordinates of vertex 1 of the triangle.
	 * 
	 * @param value2
	 * A Vector2 containing the 2D Cartesian coordinates of vertex 2 of the triangle.
	 * 
	 * @param value3
	 * A Vector2 containing the 2D Cartesian coordinates of vertex 3 of the triangle.
	 * 
	 * @param amount1
	 * Barycentric coordinate b2, which expresses the weighting factor toward vertex 2 (specified in value2).
	 * 
	 * @param amount2
	 * Barycentric coordinate b3, which expresses the weighting factor toward vertex 3 (specified in value3).
	 */
	public static Vector2 Barycentric(Vector2 value1, Vector2 value2, Vector2 value3, float amount1, float amount2)
	{
		return new Vector2(
			(value1.X + (amount1 * (value2.X - value1.X))) + (amount2 * (value3.X - value1.X)),
			(value1.Y + (amount1 * (value2.Y - value1.Y))) + (amount2 * (value3.Y - value1.Y))
		);
	}

	/**
	 * Returns a Vector2 containing the 2D Cartesian coordinates of a point specified in barycentric (areal) coordinates relative to a 2D triangle.
	 * 
	 * @param value1
	 * A Vector2 containing the 2D Cartesian coordinates of vertex 1 of the triangle.
	 * 
	 * @param value2
	 * A Vector2 containing the 2D Cartesian coordinates of vertex 2 of the triangle.
	 * 
	 * @param value3
	 * A Vector2 containing the 2D Cartesian coordinates of vertex 3 of the triangle.
	 * 
	 * @param amount1
	 * Barycentric coordinate b2, which expresses the weighting factor toward vertex 2 (specified in value2).
	 * 
	 * @param amount2
	 * Barycentric coordinate b3, which expresses the weighting factor toward vertex 3 (specified in value3).
	 * 
	 * @param result
	 * [OutAttribute] The 2D Cartesian coordinates of the specified point are placed in this Vector2 on exit.
	 */
	public static void Barycentric(Vector2 value1, Vector2 value2, Vector2 value3, float amount1, float amount2, Vector2 result)
	{
		result.X = (value1.X + (amount1 * (value2.X - value1.X))) + (amount2 * (value3.X - value1.X));
		result.Y = (value1.Y + (amount1 * (value2.Y - value1.Y))) + (amount2 * (value3.Y - value1.Y));
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
	public static Vector2 CatmullRom(Vector2 value1, Vector2 value2, Vector2 value3, Vector2 value4, float amount)
	{
		Vector2 vector = new Vector2();
		float num = amount * amount;
		float num2 = amount * num;
		vector.X = 0.5f * ((((2f * value2.X) + ((-value1.X + value3.X) * amount)) + (((((2f * value1.X) - (5f * value2.X)) + (4f * value3.X)) - value4.X) * num)) + ((((-value1.X + (3f * value2.X)) - (3f * value3.X)) + value4.X) * num2));
		vector.Y = 0.5f * ((((2f * value2.Y) + ((-value1.Y + value3.Y) * amount)) + (((((2f * value1.Y) - (5f * value2.Y)) + (4f * value3.Y)) - value4.Y) * num)) + ((((-value1.Y + (3f * value2.Y)) - (3f * value3.Y)) + value4.Y) * num2));
		return vector;
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
	public static void CatmullRom(Vector2 value1, Vector2 value2, Vector2 value3, Vector2 value4, float amount, Vector2 result)
	{
		float num = amount * amount;
		float num2 = amount * num;
		result.X = 0.5f * ((((2f * value2.X) + ((-value1.X + value3.X) * amount)) + (((((2f * value1.X) - (5f * value2.X)) + (4f * value3.X)) - value4.X) * num)) + ((((-value1.X + (3f * value2.X)) - (3f * value3.X)) + value4.X) * num2));
		result.Y = 0.5f * ((((2f * value2.Y) + ((-value1.Y + value3.Y) * amount)) + (((((2f * value1.Y) - (5f * value2.Y)) + (4f * value3.Y)) - value4.Y) * num)) + ((((-value1.Y + (3f * value2.Y)) - (3f * value3.Y)) + value4.Y) * num2));
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
	public static Vector2 Clamp(Vector2 value1, Vector2 min, Vector2 max)
	{
		float x = value1.X;
		x = (x > max.X) ? max.X : x;
		x = (x < min.X) ? min.X : x;
		float y = value1.Y;
		y = (y > max.Y) ? max.Y : y;
		y = (y < min.Y) ? min.Y : y;

		return new Vector2(x, y);
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
	public static void Clamp(Vector2 value1, Vector2 min, Vector2 max, Vector2 result)
	{
		float x = value1.X;
		x = (x > max.X) ? max.X : x;
		x = (x < min.X) ? min.X : x;
		float y = value1.Y;
		y = (y > max.Y) ? max.Y : y;
		y = (y < min.Y) ? min.Y : y;
		result.X = x;
		result.Y = y;
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
	public static float Distance(Vector2 value1, Vector2 value2)
	{
		float num2 = value1.X - value2.X;
		float num = value1.Y - value2.Y;
		float num3 = (num2 * num2) + (num * num);

		return (float) Math.sqrt((double) num3);
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
	public static float DistanceSquared(Vector2 value1, Vector2 value2)
	{
		float num2 = value1.X - value2.X;
		float num = value1.Y - value2.Y;

		return ((num2 * num2) + (num * num));
	}

	/**
	 * Divides the components of the current vector by the components of another vector.
	 * 
	 * @param other
	 * Divisor vector.
	 */
	public void Divide(Vector2 other)
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
	public static Vector2 Divide(Vector2 value1, Vector2 value2)
	{
		return new Vector2(value1.X / value2.X, value1.Y / value2.Y);
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
	public static Vector2 Divide(Vector2 value1, float divider)
	{
		float num = 1f / divider;

		return new Vector2(value1.X * num, value1.Y * num);
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
	public static void Divide(Vector2 value1, Vector2 value2, Vector2 result)
	{
		result.X = value1.X / value2.X;
		result.Y = value1.Y / value2.Y;
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
	public static void Divide(Vector2 value1, float divider, Vector2 result)
	{
		float num = 1f / divider;
		result.X = value1.X * num;
		result.Y = value1.Y * num;
	}

	/**
	 * Calculates the dot product of two vectors. If the two vectors are unit vectors, the dot product returns a floating point value between -1 and 1 that can be used to
	 * determine some properties of the angle between two vectors. For example, it can show whether the vectors are orthogonal, parallel, or have an acute or obtuse
	 * angle between them.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static float Dot(Vector2 value1, Vector2 value2)
	{
		return ((value1.X * value2.X) + (value1.Y * value2.Y));
	}

	/**
	 * Calculates the dot product of two vectors and writes the result to a user-specified variable. If the two vectors are unit vectors, the dot product returns a floating
	 * point value between -1 and 1 that can be used to determine some properties of the angle between two vectors. For example, it can show whether the vectors are
	 * orthogonal, parallel, or have an acute or obtuse angle between them.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] The dot product of the two vectors.
	 */
	public static void Dot(Vector2 value1, Vector2 value2, float result)
	{
		result = (value1.X * value2.X) + (value1.Y * value2.Y);
	}

	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * Object to make the comparison with.
	 * 
	 * @return
	 * true if the current instance is equal to the specified object; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Vector2) ? this.Equals((Vector2)obj) : false;
	}

	/**
	 * Determines whether the specified Object is equal to the Vector2.
	 * 
	 * @param other
	 * The Object to compare with the current Vector2.
	 */
	public boolean Equals(Vector2 other)
	{
		return ((this.X == other.X) && (this.Y == other.Y));
	}

	/**
	 * Gets the hash code of the vector object.
	 * 
	 * @return
	 * Hash code of the vector object.
	 */
	public int hashCode()
	{
		return ((int)this.X ^ (int)this.Y);
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
	public static Vector2 Hermite(Vector2 value1, Vector2 tangent1, Vector2 value2, Vector2 tangent2, float amount)
	{
		float num = amount * amount;
		float num2 = amount * num;
		float num6 = ((2f * num2) - (3f * num)) + 1f;
		float num5 = (-2f * num2) + (3f * num);
		float num4 = (num2 - (2f * num)) + amount;
		float num3 = num2 - num;

		return new Vector2(
			(((value1.X * num6) + (value2.X * num5)) + (tangent1.X * num4)) + (tangent2.X * num3),
			(((value1.Y * num6) + (value2.Y * num5)) + (tangent1.Y * num4)) + (tangent2.Y * num3)
		);
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
	public static void Hermite(Vector2 value1, Vector2 tangent1, Vector2 value2, Vector2 tangent2, float amount, Vector2 result)
	{
		float num = amount * amount;
		float num2 = amount * num;
		float num6 = ((2f * num2) - (3f * num)) + 1f;
		float num5 = (-2f * num2) + (3f * num);
		float num4 = (num2 - (2f * num)) + amount;
		float num3 = num2 - num;
		result.X = (((value1.X * num6) + (value2.X * num5)) + (tangent1.X * num4)) + (tangent2.X * num3);
		result.Y = (((value1.Y * num6) + (value2.Y * num5)) + (tangent1.Y * num4)) + (tangent2.Y * num3);
	}

	/**
	 * Calculates the length of the vector.
	 */
	public float Length()
	{
		float num = (this.X * this.X) + (this.Y * this.Y);

		return (float) Math.sqrt((double) num);
	}

	/**
	 * Calculates the length of the vector squared.
	 */
	public float LengthSquared()
	{
		return ((this.X * this.X) + (this.Y * this.Y));
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
	public static Vector2 Lerp(Vector2 value1, Vector2 value2, float amount)
	{
		return new Vector2(value1.X + ((value2.X - value1.X) * amount), value1.Y + ((value2.Y - value1.Y) * amount));
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
	public static void Lerp(Vector2 value1, Vector2 value2, float amount, Vector2 result)
	{
		result.X = value1.X + ((value2.X - value1.X) * amount);
		result.Y = value1.Y + ((value2.Y - value1.Y) * amount);
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
	public static Vector2 Max(Vector2 value1, Vector2 value2)
	{
		return new Vector2((value1.X > value2.X) ? value1.X : value2.X, (value1.Y > value2.Y) ? value1.Y : value2.Y);
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
	public static void Max(Vector2 value1, Vector2 value2, Vector2 result)
	{
		result.X = (value1.X > value2.X) ? value1.X : value2.X;
		result.Y = (value1.Y > value2.Y) ? value1.Y : value2.Y;
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
	public static Vector2 Min(Vector2 value1, Vector2 value2)
	{
		return new Vector2((value1.X < value2.X) ? value1.X : value2.X, (value1.Y < value2.Y) ? value1.Y : value2.Y);
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
	public static void Min(Vector2 value1, Vector2 value2, Vector2 result)
	{
		result.X = (value1.X < value2.X) ? value1.X : value2.X;
		result.Y = (value1.Y < value2.Y) ? value1.Y : value2.Y;
	}

	/**
	 * Multiplies the components of the current vector by the components of another vector.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Multiply(Vector2 other)
	{
		Multiply(this, other, this);
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
	 * Multiplies the components of two vectors by each other.
	 * 
	 * @param value1
	 * Source vector.
	 * 
	 * @param value2
	 * Source vector.
	 */
	public static Vector2 Multiply(Vector2 value1, Vector2 value2)
	{
		return new Vector2(value1.X * value2.X, value1.Y * value2.Y);
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
	public static Vector2 Multiply(Vector2 value1, float scaleFactor)
	{
		return new Vector2(value1.X * scaleFactor, value1.Y * scaleFactor);
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
	public static void Multiply(Vector2 value1, Vector2 value2, Vector2 result)
	{
		result.X = value1.X * value2.X;
		result.Y = value1.Y * value2.Y;
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
	public static void Multiply(Vector2 value1, float scaleFactor, Vector2 result)
	{
		result.X = value1.X * scaleFactor;
		result.Y = value1.Y * scaleFactor;
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
	public static Vector2 Negate(Vector2 value)
	{
		return new Vector2(-value.X, -value.Y);
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
	public static void Negate(Vector2 value, Vector2 result)
	{
		result.X = -value.X;
		result.Y = -value.Y;
	}

	/**
	 * Turns the current vector into a unit vector. The result is a vector one unit in length pointing in the same direction as the original vector.
	 */
	public void Normalize()
	{
		float num2 = (this.X * this.X) + (this.Y * this.Y);
		float num = 1f / ((float) Math.sqrt((double) num2));
		this.X *= num;
		this.Y *= num;
	}

	/**
	 * Creates a unit vector from the specified vector. The result is a vector one unit in length pointing in the same direction as the original vector.
	 * 
	 * @param value
	 * Source Vector2.
	 */
	public static Vector2 Normalize(Vector2 value)
	{
		float num2 = (value.X * value.X) + (value.Y * value.Y);
		float num = 1f / ((float) Math.sqrt((double) num2));

		return new Vector2(value.X * num, value.Y * num);
	}

	/**
	 * Creates a unit vector from the specified vector, writing the result to a user-specified variable. The result is a vector one unit in length pointing in the same direction
	 * as the original vector.
	 * 
	 * @param value
	 * Source vector.
	 * 
	 * @param result
	 * [OutAttribute] Normalized vector.
	 */
	public static void Normalize(Vector2 value, Vector2 result)
	{
		float num2 = (value.X * value.X) + (value.Y * value.Y);
		float num = 1f / ((float) Math.sqrt((double) num2));
		result.X = value.X * num;
		result.Y = value.Y * num;
	}

	/**
	 * Determines the reflect vector of the given vector and normal.
	 * 
	 * @param vector
	 * Source vector.
	 * 
	 * @param normal
	 * Normal of vector.
	 */
	public static Vector2 Reflect(Vector2 vector, Vector2 normal)
	{
		float num = (vector.X * normal.X) + (vector.Y * normal.Y);

		return new Vector2(vector.X - ((2f * num) * normal.X), vector.Y - ((2f * num) * normal.Y));
	}

	/**
	 * Determines the reflect vector of the given vector and normal.
	 * 
	 * @param vector
	 * Source vector.
	 * 
	 * @param normal
	 * Normal of vector.
	 * 
	 * @param result
	 * [OutAttribute] The created reflect vector.
	 */
	public static void Reflect(Vector2 vector, Vector2 normal, Vector2 result)
	{
		float num = (vector.X * normal.X) + (vector.Y * normal.Y);
		result.X = vector.X - ((2f * num) * normal.X);
		result.Y = vector.Y - ((2f * num) * normal.Y);
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
	public static Vector2 SmoothStep(Vector2 value1, Vector2 value2, float amount)
	{
		amount = (amount > 1f) ? 1f : ((amount < 0f) ? 0f : amount);
		amount = (amount * amount) * (3f - (2f * amount));

		return new Vector2(value1.X + ((value2.X - value1.X) * amount), value1.Y + ((value2.Y - value1.Y) * amount));
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
	public static void SmoothStep(Vector2 value1, Vector2 value2, float amount, Vector2 result)
	{
		amount = (amount > 1f) ? 1f : ((amount < 0f) ? 0f : amount);
		amount = (amount * amount) * (3f - (2f * amount));
		result.X = value1.X + ((value2.X - value1.X) * amount);
		result.Y = value1.Y + ((value2.Y - value1.Y) * amount);
	}

	/**
	 * Subtracts a vector from the current vector.
	 * 
	 * @param other
	 * Source vector.
	 */
	public void Subtract(Vector2 other)
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
	public static Vector2 Subtract(Vector2 value1, Vector2 value2)
	{
		return new Vector2(value1.X - value2.X, value1.Y - value2.Y);
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
	public static void Subtract(Vector2 value1, Vector2 value2, Vector2 result)
	{
		result.X = value1.X - value2.X;
		result.Y = value1.Y - value2.Y;
	}

	/**
	 * Retrieves a string representation of the current object.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{X:%f Y:%f}", this.X, this.Y);
	}

	/**
	 * Transforms the vector (x, y, 0, 1) by the specified matrix.
	 * 
	 * @param position
	 * The source vector.
	 * 
	 * @param matrix
	 * The transformation matrix.
	 */
	public static Vector2 Transform(Vector2 position, Matrix matrix)
	{
		float num2 = ((position.X * matrix.M11) + (position.Y * matrix.M21)) + matrix.M41;
		float num = ((position.X * matrix.M12) + (position.Y * matrix.M22)) + matrix.M42;

		return new Vector2(num2, num);
	}
	
	/**
	 * Transforms a single Vector2, or the vector normal (x, y, 0, 0), by a specified Quaternion rotation.
	 * 
	 * @param value
	 * The vector to rotate.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 */
	public static Vector2 Transform(Vector2 value, Quaternion rotation)
	{
		float num10 = rotation.X + rotation.X;
		float num5 = rotation.Y + rotation.Y;
		float num4 = rotation.Z + rotation.Z;
		float num3 = rotation.W * num4;
		float num9 = rotation.X * num10;
		float num2 = rotation.X * num5;
		float num8 = rotation.Y * num5;
		float num = rotation.Z * num4;
		float num7 = (value.X * ((1f - num8) - num)) + (value.Y * (num2 - num3));
		float num6 = (value.X * (num2 + num3)) + (value.Y * ((1f - num9) - num));

		return new Vector2(num7, num6);
	}

	/**
	 * Transforms the vector (x, y, 0, 1) by the specified matrix.
	 * 
	 * @param position
	 * The source vector.
	 * 
	 * @param matrix
	 * The transformation matrix.
	 * 
	 * @param result
	 * [OutAttribute] The Vector2 resulting from the transformation.
	 */
	public static void Transform(Vector2 position, Matrix matrix, Vector2 result)
	{
		float num2 = ((position.X * matrix.M11) + (position.Y * matrix.M21)) + matrix.M41;
		float num = ((position.X * matrix.M12) + (position.Y * matrix.M22)) + matrix.M42;
		result.X = num2;
		result.Y = num;
	}

	/**
	 * Transforms an array of Vector2s by a specified Matrix.
	 * 
	 * @param sourceArray
	 * The array of Vector2s to transform.
	 * 
	 * @param matrix
	 * The transform Matrix to apply.
	 * 
	 * @param destinationArray
	 * An existing array into which the transformed Vector2s are written.
	 * 
	 * @throws System.ArgumentNullException
	 * sourceArray or destinationArray is null.
	 * 
	 * @throws System.ArgumentException
	 * destinationArray size is too small.
	 */
	public static void Transform(Vector2[] sourceArray, Matrix matrix, Vector2[] destinationArray)
	{
		if (sourceArray == null)
		{
			throw new ArgumentNullException("sourceArray");
		}

		if (destinationArray == null)
		{
			throw new ArgumentNullException("destinationArray");
		}

		if (destinationArray.length < sourceArray.length)
		{
			throw new ArgumentException("Target array size must be equal to or bigger than source array size.", "destinationArray");
		}

		for (int i = 0; i < sourceArray.length; i++)
		{
			float x = sourceArray[i].X;
			float y = sourceArray[i].Y;
			destinationArray[i].X = ((x * matrix.M11) + (y * matrix.M21)) + matrix.M41;
			destinationArray[i].Y = ((x * matrix.M12) + (y * matrix.M22)) + matrix.M42;
		}
	}

	/**
	 * Transforms an array of Vector2s by a specified Quaternion.
	 * 
	 * @param sourceArray
	 * The array of Vector2s to transform.
	 * 
	 * @param rotation
	 * The transform Matrix to use.
	 * 
	 * @param destinationArray
	 * An existing array into which the transformed Vector2s are written.
	 * 
	 * @throws System.ArgumentNullException
	 * sourceArray or destinationArray is null.
	 * 
	 * @throws System.ArgumentException
	 * destinationArray size is too small.
	 */
	public static void Transform(Vector2[] sourceArray, Quaternion rotation, Vector2[] destinationArray)
	{
		if (sourceArray == null)
		{
			throw new ArgumentNullException("sourceArray");
		}

		if (destinationArray == null)
		{
			throw new ArgumentNullException("destinationArray");
		}

		if (destinationArray.length < sourceArray.length)
		{
			throw new ArgumentException("Target array size must be equal or bigger than source array size.", "destinationArray");
		}

		float num15 = rotation.X + rotation.X;
		float num8 = rotation.Y + rotation.Y;
		float num7 = rotation.Z + rotation.Z;
		float num6 = rotation.W * num7;
		float num14 = rotation.X * num15;
		float num5 = rotation.X * num8;
		float num13 = rotation.Y * num8;
		float num4 = rotation.Z * num7;
		float num12 = (1f - num13) - num4;
		float num11 = num5 - num6;
		float num10 = num5 + num6;
		float num9 = (1f - num14) - num4;

		for (int i = 0; i < sourceArray.length; i++)
		{
			float x = sourceArray[i].X;
			float y = sourceArray[i].Y;
			destinationArray[i].X = (x * num12) + (y * num11);
			destinationArray[i].Y = (x * num10) + (y * num9);
		}
	}

	/**
	 * Transforms a Vector2, or the vector normal (x, y, 0, 0), by a specified Quaternion rotation.
	 * 
	 * @param value
	 * The vector to rotate.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param result
	 * [OutAttribute] An existing Vector2 filled in with the result of the rotation.
	 */
	public static void Transform(Vector2 value, Quaternion rotation, Vector2 result)
	{
		float num10 = rotation.X + rotation.X;
		float num5 = rotation.Y + rotation.Y;
		float num4 = rotation.Z + rotation.Z;
		float num3 = rotation.W * num4;
		float num9 = rotation.X * num10;
		float num2 = rotation.X * num5;
		float num8 = rotation.Y * num5;
		float num = rotation.Z * num4;
		float num7 = (value.X * ((1f - num8) - num)) + (value.Y * (num2 - num3));
		float num6 = (value.X * (num2 + num3)) + (value.Y * ((1f - num9) - num));
		result.X = num7;
		result.Y = num6;
	}

	/**
	 * Transforms a specified range in an array of Vector2s by a specified Matrix and places the results in a specified range in a destination array.
	 * 
	 * @param sourceArray
	 * The source array.
	 * 
	 * @param sourceIndex
	 * The index of the first Vector2 to transform in the source array.
	 * 
	 * @param matrix
	 * The Matrix to transform by.
	 * 
	 * @param destinationArray
	 * The destination array into which the resulting Vector2s will be written.
	 * 
	 * @param destinationIndex
	 * The index of the position in the destination array where the first result Vector2 should be written.
	 * 
	 * @param length
	 * The number of Vector2s to be transformed.
	 */
	public static void Transform(Vector2[] sourceArray, int sourceIndex, Matrix matrix, Vector2[] destinationArray, int destinationIndex, int length)
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
			throw new ArgumentException("Source array must be equal to or bigger than requested length.", "sourceArray");
		}

		if (destinationArray.length < (destinationIndex + length))
		{
			throw new ArgumentException("Target array size must be equal to or bigger than source array size.", "destinationArray");
		}

		while (length > 0)
		{
			float x = sourceArray[sourceIndex].X;
			float y = sourceArray[sourceIndex].Y;
			destinationArray[destinationIndex].X = ((x * matrix.M11) + (y * matrix.M21)) + matrix.M41;
			destinationArray[destinationIndex].Y = ((x * matrix.M12) + (y * matrix.M22)) + matrix.M42;
			sourceIndex++;
			destinationIndex++;
			length--;
		}
	}

	/**
	 * Transforms a specified range in an array of Vector2s by a specified Quaternion and places the results in a specified range in a destination array.
	 * 
	 * @param sourceArray
	 * The source array.
	 * 
	 * @param sourceIndex
	 * The index of the first Vector2 to transform in the source array.
	 * 
	 * @param rotation
	 * The Quaternion rotation to apply.
	 * 
	 * @param destinationArray
	 * The destination array into which the resulting Vector2s are written.
	 * 
	 * @param destinationIndex
	 * The index of the position in the destination array where the first result Vector2 should be written.
	 * 
	 * @param length
	 * The number of Vector2s to be transformed.
	 */
	public static void Transform(Vector2[] sourceArray, int sourceIndex, Quaternion rotation, Vector2[] destinationArray, int destinationIndex, int length)
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
			throw new ArgumentException("Source array must be equal or bigger than requested length.", "sourceArray");
		}

		if (destinationArray.length < (destinationIndex + length))
		{
			throw new ArgumentException("Target array size must be equal or bigger than source array size.", "destinationArray");
		}

		float num14 = rotation.X + rotation.X;
		float num7 = rotation.Y + rotation.Y;
		float num6 = rotation.Z + rotation.Z;
		float num5 = rotation.W * num6;
		float num13 = rotation.X * num14;
		float num4 = rotation.X * num7;
		float num12 = rotation.Y * num7;
		float num3 = rotation.Z * num6;
		float num11 = (1f - num12) - num3;
		float num10 = num4 - num5;
		float num9 = num4 + num5;
		float num8 = (1f - num13) - num3;

		while (length > 0)
		{
			float x = sourceArray[sourceIndex].X;
			float y = sourceArray[sourceIndex].Y;
			destinationArray[destinationIndex].X = (x * num11) + (y * num10);
			destinationArray[destinationIndex].Y = (x * num9) + (y * num8);
			sourceIndex++;
			destinationIndex++;
			length--;
		}
	}

	/**
	 * Transforms a 2D vector normal by a matrix.
	 * 
	 * @param normal
	 * The source vector.
	 * 
	 * @param matrix
	 * The transformation matrix.
	 */
	public static Vector2 TransformNormal(Vector2 normal, Matrix matrix)
	{
		float num2 = (normal.X * matrix.M11) + (normal.Y * matrix.M21);
		float num = (normal.X * matrix.M12) + (normal.Y * matrix.M22);

		return new Vector2(num2, num);
	}

	/**
	 * Transforms a vector normal by a matrix.
	 * 
	 * @param normal
	 * The source vector.
	 * 
	 * @param matrix
	 * The transformation matrix.
	 * 
	 * @param result
	 * [OutAttribute] The Vector2 resulting from the transformation.
	 */
	public static void TransformNormal(Vector2 normal, Matrix matrix, Vector2 result)
	{
		float num2 = (normal.X * matrix.M11) + (normal.Y * matrix.M21);
		float num = (normal.X * matrix.M12) + (normal.Y * matrix.M22);
		result.X = num2;
		result.Y = num;
	}

	/**
	 * Transforms an array of Vector2 vector normals by a specified Matrix.
	 * 
	 * @param sourceArray
	 * The array of vector normals to transform.
	 * 
	 * @param matrix
	 * The transform Matrix to apply.
	 * 
	 * @param destinationArray
	 * An existing array into which the transformed vector normals are written.
	 * 
	 * @throws System.ArgumentNullException
	 * sourceArray or destinationArray is null.
	 * 
	 * @throws System.ArgumentException
	 * destinationArray size is too small.
	 */
	public static void TransformNormal(Vector2[] sourceArray, Matrix matrix, Vector2[] destinationArray)
	{
		if (sourceArray == null)
		{
			throw new ArgumentNullException("sourceArray");
		}

		if (destinationArray == null)
		{
			throw new ArgumentNullException("destinationArray");
		}

		if (destinationArray.length < sourceArray.length)
		{
			throw new ArgumentException("Target array size must be equal or bigger than source array size.", "destinationArray");
		}

		for (int i = 0; i < sourceArray.length; i++)
		{
			TransformNormal(sourceArray[i], matrix, destinationArray[i]);
		}
	}

	/**
	 * Transforms a specified range in an array of Vector2 vector normals by a specified Matrix and places the results in a specified range in a destination array.
	 * 
	 * @param sourceArray
	 * The source array.
	 * 
	 * @param sourceIndex
	 * The index of the first Vector2 to transform in the source array.
	 * 
	 * @param matrix
	 * The Matrix to apply.
	 * 
	 * @param destinationArray
	 * The destination array into which the resulting Vector2s are written.
	 * 
	 * @param destinationIndex
	 * The index of the position in the destination array where the first result Vector2 should be written.
	 * 
	 * @param length
	 * The number of vector normals to be transformed.
	 * 
	 * @throws ArgumentNullException
	 * sourceArray or destinationArray is null
	 */
	public static void TransformNormal(Vector2[] sourceArray, int sourceIndex, Matrix matrix, Vector2[] destinationArray, int destinationIndex, int length)
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
			throw new ArgumentException("Source array must be equal to or bigger than requested length.", "sourceArray");
		}

		if (destinationArray.length < (destinationIndex + length))
		{
			throw new ArgumentException("Target array size must be equal to or bigger than source array size.", "destinationArray");
		}

		while (length > 0)
		{
			float x = sourceArray[sourceIndex].X;
			float y = sourceArray[sourceIndex].Y;
			destinationArray[destinationIndex].X = (x * matrix.M11) + (y * matrix.M21);
			destinationArray[destinationIndex].Y = (x * matrix.M12) + (y * matrix.M22);
			sourceIndex++;
			destinationIndex++;
			length--;
		}
	}
}
