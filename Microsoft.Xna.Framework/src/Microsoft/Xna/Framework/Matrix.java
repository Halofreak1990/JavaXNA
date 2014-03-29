package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a matrix.
 *
 * @author Halofreak1990
 */
public final class Matrix extends ValueType implements IEquatable<Matrix>
{
	/**
	 * Gets the backward vector of the Matrix.
	 */
	public Vector3 getBackward()
	{
		return new Vector3(this.M31, this.M32, this.M33);
	}

	/**
	 * Sets the backward vector of the Matrix.
	 */
	public void setBackward(Vector3 value)
	{
		this.M31 = value.X;
		this.M32 = value.Y;
		this.M33 = value.Z;
	}

	/**
	 * Gets the down vector of the Matrix.
	 */
	public Vector3 getDown()
	{
		return new Vector3(-this.M21, -this.M22, -this.M23);
	}

	/**
	 * Sets the down vector of the Matrix.
	 */
	public void setDown(Vector3 value)
	{
		this.M21 = -value.X;
		this.M22 = -value.Y;
		this.M23 = -value.Z;
	}

	/**
	 * Gets the forward vector of the Matrix.
	 */
	public Vector3 getForward()
	{
		return new Vector3(-this.M31, -this.M32, -this.M33);
	}

	/**
	 * Sets the forward vector of the Matrix.
	 */
	public void setForward(Vector3 value)
	{
		this.M31 = -value.X;
		this.M32 = -value.Y;
		this.M33 = -value.Z;
	}

	/**
	 * Returns an instance of the identity matrix.
	 */
	public static final Matrix getIdentity()
	{
		return new Matrix(1f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1f);
	}

	/**
	 * Gets the left vector of the Matrix.
	 */
	public Vector3 getLeft()
	{
		return new Vector3(-this.M11, -this.M12, -this.M13);
	}

	/**
	 * Sets the left vector of the Matrix.
	 */
	public void setLeft(Vector3 value)
	{
		this.M11 = -value.X;
		this.M12 = -value.Y;
		this.M13 = -value.Z;
	}

	/**
	 * Gets the right vector of the Matrix.
	 */
	public Vector3 getRight()
	{
		return new Vector3(this.M11, this.M12, this.M13);
	}

	/**
	 * Sets the right vector of the Matrix.
	 */
	public void setRight(Vector3 value)
	{
		this.M11 = value.X;
		this.M12 = value.Y;
		this.M13 = value.Z;
	}

	/**
	 * Gets the translation vector of the Matrix.
	 */
	public Vector3 getTranslation()
	{
		return new Vector3(this.M41, this.M42, this.M43);
	}

	/**
	 * Sets the translation vector of the Matrix.
	 */
	public void setTranslation(Vector3 value)
	{
		this.M41 = value.X;
		this.M42 = value.Y;
		this.M43 = value.Z;
	}

	/**
	 * Gets the up vector of this Matrix.
	 */
	public Vector3 getUp()
	{
		return new Vector3(this.M21, this.M22, this.M23);
	}

	/**
	 * Sets the up vector of this Matrix.
	 */
	public void setUp(Vector3 value)
	{
		this.M21 = value.X;
		this.M22 = value.Y;
		this.M23 = value.Z;
	}

	/**
	 * Value at row 1 column 1 of the matrix.
	 */
	public float M11;
	/**
	 * Value at row 1 column 2 of the matrix.
	 */
	public float M12;
	/**
	 * Value at row 1 column 3 of the matrix.
	 */
	public float M13;
	/**
	 * Value at row 1 column 4 of the matrix.
	 */
	public float M14;
	/**
	 * Value at row 2 column 1 of the matrix.
	 */
	public float M21;
	/**
	 * Value at row 2 column 2 of the matrix.
	 */
	public float M22;
	/**
	 * Value at row 2 column 3 of the matrix.
	 */
	public float M23;
	/**
	 * Value at row 2 column 4 of the matrix.
	 */
	public float M24;
	/**
	 * Value at row 3 column 1 of the matrix.
	 */
	public float M31;
	/**
	 * Value at row 3 column 2 of the matrix.
	 */
	public float M32;
	/**
	 * Value at row 3 column 3 of the matrix.
	 */
	public float M33;
	/**
	 * Value at row 3 column 4 of the matrix.
	 */
	public float M34;
	/**
	 * Value at row 4 column 1 of the matrix.
	 */
	public float M41;
	/**
	 * Value at row 4 column 2 of the matrix.
	 */
	public float M42;
	/**
	 * Value at row 4 column 3 of the matrix.
	 */
	public float M43;
	/**
	 * Value at row 4 column 4 of the matrix.
	 */
	public float M44;

	/**
	 * Initializes a new instance of Matrix.
	 */
	public Matrix()
	{
		M11 = 0.0f;
		M12 = 0.0f;
		M13 = 0.0f;
		M14 = 0.0f;
		M21 = 0.0f;
		M22 = 0.0f;
		M23 = 0.0f;
		M24 = 0.0f;
		M31 = 0.0f;
		M32 = 0.0f;
		M33 = 0.0f;
		M34 = 0.0f;
		M41 = 0.0f;
		M42 = 0.0f;
		M43 = 0.0f;
		M44 = 0.0f;
	}

	/**
	 * Initializes a new instance of Matrix.
	 * 
	 * @param m11
	 * Value to initialize m11 to.
	 * 
	 * @param m12
	 * Value to initialize m12 to.
	 * 
	 * @param m13
	 * Value to initialize m13 to.
	 * 
	 * @param m14
	 * Value to initialize m14 to.
	 * 
	 * @param m21
	 * Value to initialize m21 to.
	 * 
	 * @param m22
	 * Value to initialize m22 to.
	 * 
	 * @param m23
	 * Value to initialize m23 to.
	 * 
	 * @param m24
	 * Value to initialize m24 to.
	 * 
	 * @param m31
	 * Value to initialize m31 to.
	 * 
	 * @param m32
	 * Value to initialize m32 to.
	 * 
	 * @param m33
	 * Value to initialize m33 to.
	 * 
	 * @param m34
	 * Value to initialize m34 to.
	 * 
	 * @param m41
	 * Value to initialize m41 to.
	 * 
	 * @param m42
	 * Value to initialize m42 to.
	 * 
	 * @param m43
	 * Value to initialize m43 to.
	 * 
	 * @param m44
	 * Value to initialize m44 to.
	 */
	public Matrix(float m11, float m12, float m13, float m14, float m21, float m22, float m23, float m24, float m31, float m32, float m33, float m34, float m41, float m42, float m43, float m44)
	{
		this.M11 = m11;
		this.M12 = m12;
		this.M13 = m13;
		this.M14 = m14;
		this.M21 = m21;
		this.M22 = m22;
		this.M23 = m23;
		this.M24 = m24;
		this.M31 = m31;
		this.M32 = m32;
		this.M33 = m33;
		this.M34 = m34;
		this.M41 = m41;
		this.M42 = m42;
		this.M43 = m43;
		this.M44 = m44;
	}

	/**
	 * Adds the current matrix to another matrix.
	 * 
	 * @param other
	 * Source matrix.
	 */
	public void Add(Matrix other)
	{
		Add(this, other, this);
	}

	/**
	 * Adds a matrix to another matrix.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * Source matrix.
	 */
	public static Matrix Add(Matrix matrix1, Matrix matrix2)
	{
		Matrix result = new Matrix();
		Add(matrix1, matrix2, result);
		return result;
	}

	/**
	 * Adds a matrix to another matrix.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * Source matrix.
	 * 
	 * @param result
	 * [OutAttribute] Resulting matrix.
	 */
	public static void Add(Matrix matrix1, Matrix matrix2, Matrix result)
	{
		result.M11 = matrix1.M11 + matrix2.M11;
		result.M12 = matrix1.M12 + matrix2.M12;
		result.M13 = matrix1.M13 + matrix2.M13;
		result.M14 = matrix1.M14 + matrix2.M14;
		result.M21 = matrix1.M21 + matrix2.M21;
		result.M22 = matrix1.M22 + matrix2.M22;
		result.M23 = matrix1.M23 + matrix2.M23;
		result.M24 = matrix1.M24 + matrix2.M24;
		result.M31 = matrix1.M31 + matrix2.M31;
		result.M32 = matrix1.M32 + matrix2.M32;
		result.M33 = matrix1.M33 + matrix2.M33;
		result.M34 = matrix1.M34 + matrix2.M34;
		result.M41 = matrix1.M41 + matrix2.M41;
		result.M42 = matrix1.M42 + matrix2.M42;
		result.M43 = matrix1.M43 + matrix2.M43;
		result.M44 = matrix1.M44 + matrix2.M44;
	}

	/**
	 * Creates a spherical billboard that rotates around a specified object position.
	 * 
	 * @param objectPosition
	 * Position of the object the billboard will rotate around.
	 * 
	 * @param cameraPosition
	 * Position of the camera.
	 * 
	 * @param cameraUpVector
	 * The up vector of the camera.
	 * 
	 * @param cameraForwardVector
	 * Optional forward vector of the camera.
	 */
	public static Matrix CreateBillboard(Vector3 objectPosition, Vector3 cameraPosition, Vector3 cameraUpVector, Vector3 cameraForwardVector)
	{
		Matrix result = new Matrix();
		CreateBillboard(objectPosition, cameraPosition, cameraUpVector, cameraForwardVector, result);
		return result;
	}

	/**
	 * Creates a spherical billboard that rotates around a specified object position.
	 * 
	 * @param objectPosition
	 * Position of the object the billboard will rotate around.
	 * 
	 * @param cameraPosition
	 * Position of the camera.
	 * 
	 * @param cameraUpVector
	 * The up vector of the camera.
	 * 
	 * @param cameraForwardVector
	 * Optional forward vector of the camera.
	 * 
	 * @param result
	 * [OutAttribute] The created billboard matrix.
	 */
	public static void CreateBillboard(Vector3 objectPosition, Vector3 cameraPosition, Vector3 cameraUpVector, Vector3 cameraForwardVector, Matrix result)
	{
		Vector3 vector = Vector3.Zero;
		Vector3 vector2 = Vector3.Zero;
		Vector3 vector3 = Vector3.Zero;
		vector.X = objectPosition.X - cameraPosition.X;
		vector.Y = objectPosition.Y - cameraPosition.Y;
		vector.Z = objectPosition.Z - cameraPosition.Z;
		float num = vector.LengthSquared();

		if (num < 0.0001f)
		{
			vector = (cameraForwardVector != null) ? Vector3.Negate(cameraForwardVector) : Vector3.Forward;
		}
		else
		{
			Vector3.Multiply(vector, (float) (1f / ((float) Math.sqrt((double) num))), vector);
		}

		Vector3.Cross(cameraUpVector, vector, vector3);
		vector3.Normalize();
		Vector3.Cross(vector, vector3, vector2);
		result.M11 = vector3.X;
		result.M12 = vector3.Y;
		result.M13 = vector3.Z;
		result.M14 = 0f;
		result.M21 = vector2.X;
		result.M22 = vector2.Y;
		result.M23 = vector2.Z;
		result.M24 = 0f;
		result.M31 = vector.X;
		result.M32 = vector.Y;
		result.M33 = vector.Z;
		result.M34 = 0f;
		result.M41 = objectPosition.X;
		result.M42 = objectPosition.Y;
		result.M43 = objectPosition.Z;
		result.M44 = 1f;
	}

	/**
	 * Creates a cylindrical billboard that rotates around a specified axis.
	 * 
	 * @param objectPosition
	 * Position of the object the billboard will rotate around.
	 * 
	 * @param cameraPosition
	 * Position of the camera.
	 * 
	 * @param rotateAxis
	 * Axis to rotate the billboard around.
	 * 
	 * @param cameraForwardVector
	 * Optional forward vector of the camera.
	 * 
	 * @param objectForwardVector
	 * Optional forward vector of the object.
	 */
	public static Matrix CreateConstrainedBillboard(Vector3 objectPosition, Vector3 cameraPosition, Vector3 rotateAxis, Vector3 cameraForwardVector, Vector3 objectForwardVector)
	{
		Matrix result = new Matrix();
		CreateConstrainedBillboard(objectPosition, cameraPosition, rotateAxis, cameraForwardVector, objectForwardVector, result);
		return result;
	}

	/**
	 * Creates a cylindrical billboard that rotates around a specified axis.
	 * 
	 * @param objectPosition
	 * Position of the object the billboard will rotate around.
	 * 
	 * @param cameraPosition
	 * Position of the camera.
	 * 
	 * @param rotateAxis
	 * Axis to rotate the billboard around.
	 * 
	 * @param cameraForwardVector
	 * Optional forward vector of the camera.
	 * 
	 * @param objectForwardVector
	 * Optional forward vector of the object.
	 * 
	 * @param result
	 * [OutAttribute] The created billboard matrix.
	 */
	public static void CreateConstrainedBillboard(Vector3 objectPosition, Vector3 cameraPosition, Vector3 rotateAxis, Vector3 cameraForwardVector, Vector3 objectForwardVector, Matrix result)
	{
		float num = 0f;
		Vector3 vector = Vector3.Zero;
		Vector3 vector2 = Vector3.Zero;
		Vector3 vector3 = Vector3.Zero;
		vector2.X = objectPosition.X - cameraPosition.X;
		vector2.Y = objectPosition.Y - cameraPosition.Y;
		vector2.Z = objectPosition.Z - cameraPosition.Z;
		float num2 = vector2.LengthSquared();

		if (num2 < 0.0001f)
		{
			vector2 = (cameraForwardVector != null) ? Vector3.Negate(cameraForwardVector) : Vector3.Forward;
		}
		else
		{
			Vector3.Multiply(vector2, (float) (1f / ((float) Math.sqrt((double) num2))), vector2);
		}

		Vector3 vector4 = rotateAxis;

		num = Vector3.Dot(rotateAxis, vector2);

		if (Math.abs(num) > 0.9982547f)
		{
			if (objectForwardVector != null)
			{
				vector = objectForwardVector;

				num = Vector3.Dot(rotateAxis, vector);

				if (Math.abs(num) > 0.9982547f)
				{
					num = ((rotateAxis.X * Vector3.Forward.X) + (rotateAxis.Y * Vector3.Forward.Y)) + (rotateAxis.Z * Vector3.Forward.Z);
					vector = (Math.abs(num) > 0.9982547f) ? Vector3.Right : Vector3.Forward;
				}
			}
			else
			{
				num = ((rotateAxis.X * Vector3.Forward.X) + (rotateAxis.Y * Vector3.Forward.Y)) + (rotateAxis.Z * Vector3.Forward.Z);
				vector = (Math.abs(num) > 0.9982547f) ? Vector3.Right : Vector3.Forward;
			}

			Vector3.Cross(rotateAxis, vector, vector3);
			vector3.Normalize();
			Vector3.Cross(vector3, rotateAxis, vector);
			vector.Normalize();
		}
		else
		{
			Vector3.Cross(rotateAxis, vector2, vector3);
			vector3.Normalize();
			Vector3.Cross(vector3, vector4, vector);
			vector.Normalize();
		}

		result.M11 = vector3.X;
		result.M12 = vector3.Y;
		result.M13 = vector3.Z;
		result.M14 = 0f;
		result.M21 = vector4.X;
		result.M22 = vector4.Y;
		result.M23 = vector4.Z;
		result.M24 = 0f;
		result.M31 = vector.X;
		result.M32 = vector.Y;
		result.M33 = vector.Z;
		result.M34 = 0f;
		result.M41 = objectPosition.X;
		result.M42 = objectPosition.Y;
		result.M43 = objectPosition.Z;
		result.M44 = 1f;
	}

	/**
	 * Creates a new Matrix that rotates around an arbitrary vector.
	 * 
	 * @param axis
	 * The axis to rotate around.
	 * 
	 * @param angle
	 * The angle to rotate around the vector.
	 */
	public static Matrix CreateFromAxisAngle(Vector3 axis, float angle)
	{
		Matrix result = new Matrix();
		CreateFromAxisAngle(axis, angle, result);
		return result;
	}

	/**
	 * Creates a new Matrix that rotates around an arbitrary vector.
	 * 
	 * @param axis
	 * The axis to rotate around.
	 * 
	 * @param angle
	 * The angle to rotate around the vector.
	 * 
	 * @param result
	 * [OutAttribute] The created Matrix.
	 */
	public static void CreateFromAxisAngle(Vector3 axis, float angle, Matrix result)
	{
		float x = axis.X;
		float y = axis.Y;
		float z = axis.Z;
		float num2 = (float) Math.sin((double) angle);
		float num = (float) Math.cos((double) angle);
		float num11 = x * x;
		float num10 = y * y;
		float num9 = z * z;
		float num8 = x * y;
		float num7 = x * z;
		float num6 = y * z;
		result.M11 = num11 + (num * (1f - num11));
		result.M12 = (num8 - (num * num8)) + (num2 * z);
		result.M13 = (num7 - (num * num7)) - (num2 * y);
		result.M14 = 0f;
		result.M21 = (num8 - (num * num8)) - (num2 * z);
		result.M22 = num10 + (num * (1f - num10));
		result.M23 = (num6 - (num * num6)) + (num2 * x);
		result.M24 = 0f;
		result.M31 = (num7 - (num * num7)) + (num2 * y);
		result.M32 = (num6 - (num * num6)) - (num2 * x);
		result.M33 = num9 + (num * (1f - num9));
		result.M34 = 0f;
		result.M41 = 0f;
		result.M42 = 0f;
		result.M43 = 0f;
		result.M44 = 1f;
	}

	/**
	 * Creates a rotation Matrix from a Quaternion.
	 * 
	 * @param quaternion
	 * Quaternion to create the Matrix from.
	 */
	public static Matrix CreateFromQuaternion(Quaternion quaternion)
	{
		Matrix result = new Matrix();
		CreateFromQuaternion(quaternion, result);
		return result;
	}

	/**
	 * Creates a rotation Matrix from a Quaternion.
	 * 
	 * @param quaternion
	 * Quaternion to create the Matrix from.
	 * 
	 * @param result
	 * [OutAttribute] The created Matrix.
	 */
	public static void CreateFromQuaternion(Quaternion quaternion, Matrix result)
	{
		float num9 = quaternion.X * quaternion.X;
		float num8 = quaternion.Y * quaternion.Y;
		float num7 = quaternion.Z * quaternion.Z;
		float num6 = quaternion.X * quaternion.Y;
		float num5 = quaternion.Z * quaternion.W;
		float num4 = quaternion.Z * quaternion.X;
		float num3 = quaternion.Y * quaternion.W;
		float num2 = quaternion.Y * quaternion.Z;
		float num = quaternion.X * quaternion.W;
		result.M11 = 1f - (2f * (num8 + num7));
		result.M12 = 2f * (num6 + num5);
		result.M13 = 2f * (num4 - num3);
		result.M14 = 0f;
		result.M21 = 2f * (num6 - num5);
		result.M22 = 1f - (2f * (num7 + num9));
		result.M23 = 2f * (num2 + num);
		result.M24 = 0f;
		result.M31 = 2f * (num4 + num3);
		result.M32 = 2f * (num2 - num);
		result.M33 = 1f - (2f * (num8 + num9));
		result.M34 = 0f;
		result.M41 = 0f;
		result.M42 = 0f;
		result.M43 = 0f;
		result.M44 = 1f;
	}

	/**
	 * Creates a new rotation matrix from a specified yaw, pitch, and roll.
	 * 
	 * @param yaw
	 * Angle of rotation, in radians, around the y-axis.
	 * 
	 * @param pitch
	 * Angle of rotation, in radians, around the x-axis.
	 * 
	 * @param roll
	 * Angle of rotation, in radians, around the z-axis.
	 */
	public static Matrix CreateFromYawPitchRoll(float yaw, float pitch, float roll)
	{
		Matrix matrix = new Matrix();
		Quaternion quaternion = new Quaternion();
		Quaternion.CreateFromYawPitchRoll(yaw, pitch, roll, quaternion);
		CreateFromQuaternion(quaternion, matrix);
		return matrix;
	}

	/**
	 * Creates a new rotation matrix from a specified yaw, pitch, and roll.
	 * 
	 * @param yaw
	 * Angle of rotation, in radians, around the y-axis.
	 * 
	 * @param pitch
	 * Angle of rotation, in radians, around the x-axis.
	 * 
	 * @param roll
	 * Angle of rotation, in radians, around the z-axis.
	 * 
	 * @param result
	 * [OutAttribute] An existing matrix filled in to represent the specified yaw, pitch, and roll.
	 */
	public static void CreateFromYawPitchRoll(float yaw, float pitch, float roll, Matrix result)
	{
		Quaternion quaternion = new Quaternion();
		Quaternion.CreateFromYawPitchRoll(yaw, pitch, roll, quaternion);
		CreateFromQuaternion(quaternion, result);
	}

	/**
	 * Creates a view matrix.
	 * 
	 * @param cameraPosition
	 * The position of the camera.
	 * 
	 * @param cameraTarget
	 * The target towards which the camera is pointing.
	 * 
	 * @param cameraUpVector
	 * The direction that is "up" from the camera's point of view.
	 */
	public static Matrix CreateLookAt(Vector3 cameraPosition, Vector3 cameraTarget, Vector3 cameraUpVector)
	{
		Matrix result = new Matrix();
		CreateLookAt(cameraPosition, cameraTarget, cameraUpVector, result);
		return result;
	}

	/**
	 * Creates a view matrix.
	 * 
	 * @param cameraPosition
	 * The position of the camera.
	 * 
	 * @param cameraTarget
	 * The target towards which the camera is pointing.
	 * 
	 * @param cameraUpVector
	 * The direction that is "up" from the camera's point of view.
	 * 
	 * @param result
	 * [OutAttribute] The created view matrix.
	 */
	public static void CreateLookAt(Vector3 cameraPosition, Vector3 cameraTarget, Vector3 cameraUpVector, Matrix result)
	{
		Vector3 vector = Vector3.Normalize(Vector3.Subtract(cameraPosition, cameraTarget));
		Vector3 vector2 = Vector3.Normalize(Vector3.Cross(cameraUpVector, vector));
		Vector3 vector3 = Vector3.Cross(vector, vector2);
		result.M11 = vector2.X;
		result.M12 = vector3.X;
		result.M13 = vector.X;
		result.M14 = 0f;
		result.M21 = vector2.Y;
		result.M22 = vector3.Y;
		result.M23 = vector.Y;
		result.M24 = 0f;
		result.M31 = vector2.Z;
		result.M32 = vector3.Z;
		result.M33 = vector.Z;
		result.M34 = 0f;
		result.M41 = -Vector3.Dot(vector2, cameraPosition);
		result.M42 = -Vector3.Dot(vector3, cameraPosition);
		result.M43 = -Vector3.Dot(vector, cameraPosition);
		result.M44 = 1f;
	}

	/**
	 * Builds an orthogonal projection matrix.
	 * 
	 * @param width
	 * Width of the view volume.
	 * 
	 * @param height
	 * Height of the view volume.
	 * 
	 * @param zNearPlane
	 * Minimum z-value of the view volume.
	 * 
	 * @param zFarPlane
	 * Maximum z-value of the view volume.
	 */
	public static Matrix CreateOrthographic(float width, float height, float zNearPlane, float zFarPlane)
	{
		Matrix result = new Matrix();
		CreateOrthographic(width, height, zNearPlane, zFarPlane, result);
		return result;
	}

	/**
	 * Builds an orthogonal projection matrix.
	 * 
	 * @param width
	 * Width of the view volume.
	 * 
	 * @param height
	 * Height of the view volume.
	 * 
	 * @param zNearPlane
	 * Minimum z-value of the view volume.
	 * 
	 * @param zFarPlane
	 * Maximum z-value of the view volume.
	 * 
	 * @param result
	 * [OutAttribute] The projection matrix.
	 */
	public static void CreateOrthographic(float width, float height, float zNearPlane, float zFarPlane, Matrix result)
	{
		result.M11 = 2f / width;
		result.M12 = result.M13 = result.M14 = 0f;
		result.M22 = 2f / height;
		result.M21 = result.M23 = result.M24 = 0f;
		result.M33 = 1f / (zNearPlane - zFarPlane);
		result.M31 = result.M32 = result.M34 = 0f;
		result.M41 = result.M42 = 0f;
		result.M43 = zNearPlane / (zNearPlane - zFarPlane);
		result.M44 = 1f;
	}

	/**
	 * Builds a customized, orthogonal projection matrix.
	 * 
	 * @param left
	 * Minimum x-value of the view volume.
	 * 
	 * @param right
	 * Maximum x-value of the view volume.
	 * 
	 * @param bottom
	 * Minimum y-value of the view volume.
	 * 
	 * @param top
	 * Maximum y-value of the view volume.
	 * 
	 * @param zNearPlane
	 * Minimum z-value of the view volume.
	 * 
	 * @param zFarPlane
	 * Maximum z-value of the view volume.
	 */
	public static Matrix CreateOrthographicOffCenter(float left, float right, float bottom, float top, float zNearPlane, float zFarPlane)
	{
		Matrix result = new Matrix();
		CreateOrthographicOffCenter(left, right, bottom, top, zNearPlane, zFarPlane, result);
		return result;
	}

	/**
	 * Builds a customized, orthogonal projection matrix.
	 * 
	 * @param left
	 * Minimum x-value of the view volume.
	 * 
	 * @param right
	 * Maximum x-value of the view volume.
	 * 
	 * @param bottom
	 * Minimum y-value of the view volume.
	 * 
	 * @param top
	 * Maximum y-value of the view volume.
	 * 
	 * @param zNearPlane
	 * Minimum z-value of the view volume.
	 * 
	 * @param zFarPlane
	 * Maximum z-value of the view volume.
	 * 
	 * @param result
	 * [OutAttribute] The projection matrix.
	 */
	public static void CreateOrthographicOffCenter(float left, float right, float bottom, float top, float zNearPlane, float zFarPlane, Matrix result)
	{
		result.M11 = 2f / (right - left);
		result.M12 = result.M13 = result.M14 = 0f;
		result.M22 = 2f / (top - bottom);
		result.M21 = result.M23 = result.M24 = 0f;
		result.M33 = 1f / (zNearPlane - zFarPlane);
		result.M31 = result.M32 = result.M34 = 0f;
		result.M41 = (left + right) / (left - right);
		result.M42 = (top + bottom) / (bottom - top);
		result.M43 = zNearPlane / (zNearPlane - zFarPlane);
		result.M44 = 1f;
	}

	/**
	 * Builds a perspective projection matrix and returns the result by value.
	 * 
	 * @param width
	 * Width of the view volume at the near view plane.
	 * 
	 * @param height
	 * Height of the view volume at the near view plane.
	 * 
	 * @param nearPlaneDistance
	 * Distance to the near view plane.
	 * 
	 * @param farPlaneDistance
	 * Distance to the far view plane.
	 */
	public static Matrix CreatePerspective(float width, float height, float nearPlaneDistance, float farPlaneDistance)
	{
		Matrix result = new Matrix();
		CreatePerspective(width, height, nearPlaneDistance, farPlaneDistance, result);
		return result;
	}

	/**
	 * Builds a perspective projection matrix and returns the result by reference.
	 * 
	 * @param width
	 * Width of the view volume at the near view plane.
	 * 
	 * @param height
	 * Height of the view volume at the near view plane.
	 * 
	 * @param nearPlaneDistance
	 * Distance to the near view plane.
	 * 
	 * @param farPlaneDistance
	 * Distance to the far view plane.
	 * 
	 * @param result
	 * [OutAttribute] The projection matrix.
	 */
	public static void CreatePerspective(float width, float height, float nearPlaneDistance, float farPlaneDistance, Matrix result)
	{
		if (nearPlaneDistance <= 0f)
		{
			throw new ArgumentException(String.format(Locale.getDefault(), "You should specify positive value for %s", "nearPlaneDistance"));
		}

		if (farPlaneDistance <= 0f)
		{
			throw new ArgumentException(String.format(Locale.getDefault(), "You should specify positive value for %s", "farPlaneDistance"));
		}

		if (nearPlaneDistance >= farPlaneDistance)
		{
			throw new ArgumentException("Near plane distance is larger than Far plane distance. Near plane distance must be smaller than Far plane distance.");
		}

		result.M11 = (2f * nearPlaneDistance) / width;
		result.M12 = result.M13 = result.M14 = 0f;
		result.M22 = (2f * nearPlaneDistance) / height;
		result.M21 = result.M23 = result.M24 = 0f;
		result.M33 = farPlaneDistance / (nearPlaneDistance - farPlaneDistance);
		result.M31 = result.M32 = 0f;
		result.M34 = -1f;
		result.M41 = result.M42 = result.M44 = 0f;
		result.M43 = (nearPlaneDistance * farPlaneDistance) / (nearPlaneDistance - farPlaneDistance);
	}

	/**
	 * Builds a perspective projection matrix based on a field of view and returns by value.
	 * 
	 * @param fieldOfView
	 * Field of view in the y direction, in radians.
	 * 
	 * @param aspectRatio
	 * Aspect ratio, defined as view space width divided by height. To match the aspect ratio of the viewport, the property AspectRatio.
	 * 
	 * @param nearPlaneDistance
	 * Distance to the near view plane.
	 * 
	 * @param farPlaneDistance
	 * Distance to the far view plane.
	 */
	public static Matrix CreatePerspectiveFieldOfView(float fieldOfView, float aspectRatio, float nearPlaneDistance, float farPlaneDistance)
	{
		Matrix result = new Matrix();
		CreatePerspectiveFieldOfView(fieldOfView, aspectRatio, nearPlaneDistance, farPlaneDistance, result);
		return result;
	}

	/**
	 * Builds a perspective projection matrix based on a field of view and returns by reference.
	 * 
	 * @param fieldOfView
	 * Field of view in the y direction, in radians.
	 * 
	 * @param aspectRatio
	 * Aspect ratio, defined as view space width divided by height. To match the aspect ratio of the viewport, the property AspectRatio.
	 * 
	 * @param nearPlaneDistance
	 * Distance to the near view plane.
	 * 
	 * @param farPlaneDistance
	 * Distance to the far view plane.
	 * 
	 * @param result
	 * [OutAttribute] The perspective projection matrix.
	 */
	public static void CreatePerspectiveFieldOfView(float fieldOfView, float aspectRatio, float nearPlaneDistance, float farPlaneDistance, Matrix result)
	{
		if ((fieldOfView <= 0f) || (fieldOfView >= 3.141593f))
		{
			throw new ArgumentException(String.format(Locale.getDefault(), "%s takes a value between 0 and Pi (180 degrees) in radians.", "fieldOfView"));
		}

		if (nearPlaneDistance <= 0f)
		{
			throw new ArgumentException(String.format(Locale.getDefault(), "You should specify positive value for %s", "nearPlaneDistance"));
		}

		if (farPlaneDistance <= 0f)
		{
			throw new ArgumentException(String.format(Locale.getDefault(), "You should specify positive value for %s", "farPlaneDistance"));
		}

		if (nearPlaneDistance >= farPlaneDistance)
		{
			throw new ArgumentException("Near plane distance is larger than Far plane distance. Near plane distance must be smaller than Far plane distance.");
		}

		float num = 1f / ((float) Math.tan((double) (fieldOfView * 0.5f)));
		float num9 = num / aspectRatio;
		result.M11 = num9;
		result.M12 = result.M13 = result.M14 = 0f;
		result.M22 = num;
		result.M21 = result.M23 = result.M24 = 0f;
		result.M31 = result.M32 = 0f;
		result.M33 = farPlaneDistance / (nearPlaneDistance - farPlaneDistance);
		result.M34 = -1f;
		result.M41 = result.M42 = result.M44 = 0f;
		result.M43 = (nearPlaneDistance * farPlaneDistance) / (nearPlaneDistance - farPlaneDistance);
	}

	/**
	 * Builds a customized, perspective projection matrix.
	 * 
	 * @param left
	 * Minimum x-value of the view volume at the near view plane.
	 * 
	 * @param right
	 * Maximum x-value of the view volume at the near view plane.
	 * 
	 * @param bottom
	 * Minimum y-value of the view volume at the near view plane.
	 * 
	 * @param top
	 * Maximum y-value of the view volume at the near view plane.
	 * 
	 * @param nearPlaneDistance
	 * Distance to the near view plane.
	 * 
	 * @param farPlaneDistance
	 * Distance to of the far view plane.
	 */
	public static Matrix CreatePerspectiveOffCenter(float left, float right, float bottom, float top, float nearPlaneDistance, float farPlaneDistance)
	{
		Matrix result = new Matrix();
		CreatePerspectiveOffCenter(left, right, bottom, top, nearPlaneDistance, farPlaneDistance, result);
		return result;
	}

	/**
	 * Builds a customized, perspective projection matrix.
	 * 
	 * @param left
	 * Minimum x-value of the view volume at the near view plane.
	 * 
	 * @param right
	 * Maximum x-value of the view volume at the near view plane.
	 * 
	 * @param bottom
	 * Minimum y-value of the view volume at the near view plane.
	 * 
	 * @param top
	 * Maximum y-value of the view volume at the near view plane.
	 * 
	 * @param nearPlaneDistance
	 * Distance to the near view plane.
	 * 
	 * @param farPlaneDistance
	 * Distance to of the far view plane.
	 * 
	 * @param result
	 * [OutAttribute] The created projection matrix.
	 */
	public static void CreatePerspectiveOffCenter(float left, float right, float bottom, float top, float nearPlaneDistance, float farPlaneDistance, Matrix result)
	{
		if (nearPlaneDistance <= 0f)
		{
			throw new ArgumentException(String.format(Locale.getDefault(), "You should specify positive value for %s", "nearPlaneDistance"));
		}

		if (farPlaneDistance <= 0f)
		{
			throw new ArgumentException(String.format(Locale.getDefault(), "You should specify positive value for %s", "farPlaneDistance"));
		}

		if (nearPlaneDistance >= farPlaneDistance)
		{
			throw new ArgumentException("Near plane distance is larger than Far plane distance. Near plane distance must be smaller than Far plane distance.");
		}

		result.M11 = (2f * nearPlaneDistance) / (right - left);
		result.M12 = result.M13 = result.M14 = 0f;
		result.M22 = (2f * nearPlaneDistance) / (top - bottom);
		result.M21 = result.M23 = result.M24 = 0f;
		result.M31 = (left + right) / (right - left);
		result.M32 = (top + bottom) / (top - bottom);
		result.M33 = farPlaneDistance / (nearPlaneDistance - farPlaneDistance);
		result.M34 = -1f;
		result.M43 = (nearPlaneDistance * farPlaneDistance) / (nearPlaneDistance - farPlaneDistance);
		result.M41 = result.M42 = result.M44 = 0f;
	}

	/**
	 * Creates a Matrix that reflects the coordinate system about a specified Plane.
	 * 
	 * @param value
	 * The Plane about which to create a reflection.
	 */
	public static Matrix CreateReflection(Plane value)
	{
		Matrix result = new Matrix();
		CreateReflection(value, result);
		return result;
	}

	/**
	 * Creates a Matrix that reflects the coordinate system about a specified Plane.
	 * 
	 * @param value
	 * The Plane about which to create a reflection.
	 * 
	 * @param result
	 * [OutAttribute] A Matrix that creates the reflection.
	 */
	public static void CreateReflection(Plane value, Matrix result)
	{
		Plane plane = new Plane();
		Plane.Normalize(value, plane);
		float x = plane.Normal.X;
		float y = plane.Normal.Y;
		float z = plane.Normal.Z;
		float num3 = -2f * x;
		float num2 = -2f * y;
		float num = -2f * z;
		result.M11 = (num3 * x) + 1f;
		result.M12 = num2 * x;
		result.M13 = num * x;
		result.M14 = 0f;
		result.M21 = num3 * y;
		result.M22 = (num2 * y) + 1f;
		result.M23 = num * y;
		result.M24 = 0f;
		result.M31 = num3 * z;
		result.M32 = num2 * z;
		result.M33 = (num * z) + 1f;
		result.M34 = 0f;
		result.M41 = num3 * plane.D;
		result.M42 = num2 * plane.D;
		result.M43 = num * plane.D;
		result.M44 = 1f;
	}

	/**
	 * Returns a matrix that can be used to rotate a set of vertices around the x-axis.
	 * 
	 * @param radians
	 * The amount, in radians, in which to rotate around the x-axis. Note that you can use ToRadians to convert degrees to radians.
	 */
	public static Matrix CreateRotationX(float radians)
	{
		Matrix result = new Matrix();
		CreateRotationX(radians, result);
		return result;
	}

	/**
	 * Populates data into a user-specified matrix that can be used to rotate a set of vertices around the x-axis.
	 * 
	 * @param radians
	 * The amount, in radians, in which to rotate around the x-axis. Note that you can use ToRadians to convert degrees to radians.
	 * 
	 * @param result
	 * [OutAttribute] The matrix in which to place the calculated data.
	 */
	public static void CreateRotationX(float radians, Matrix result)
	{
		float num2 = (float) Math.cos((double) radians);
		float num = (float) Math.sin((double) radians);
		result.M11 = 1f;
		result.M12 = 0f;
		result.M13 = 0f;
		result.M14 = 0f;
		result.M21 = 0f;
		result.M22 = num2;
		result.M23 = num;
		result.M24 = 0f;
		result.M31 = 0f;
		result.M32 = -num;
		result.M33 = num2;
		result.M34 = 0f;
		result.M41 = 0f;
		result.M42 = 0f;
		result.M43 = 0f;
		result.M44 = 1f;
	}

	/**
	 * Returns a matrix that can be used to rotate a set of vertices around the y-axis.
	 * 
	 * @param radians
	 * The amount, in radians, in which to rotate around the y-axis. Note that you can use ToRadians to convert degrees to radians.
	 */
	public static Matrix CreateRotationY(float radians)
	{
		Matrix result = new Matrix();
		CreateRotationY(radians, result);
		return result;
	}

	/**
	 * Populates data into a user-specified matrix that can be used to rotate a set of vertices around the y-axis.
	 * 
	 * @param radians
	 * The amount, in radians, in which to rotate around the y-axis. Note that you can use ToRadians to convert degrees to radians.
	 * 
	 * @param result
	 * [OutAttribute] The matrix in which to place the calculated data.
	 */
	public static void CreateRotationY(float radians, Matrix result)
	{
		float num2 = (float) Math.cos((double) radians);
		float num = (float) Math.sin((double) radians);
		result.M11 = num2;
		result.M12 = 0f;
		result.M13 = -num;
		result.M14 = 0f;
		result.M21 = 0f;
		result.M22 = 1f;
		result.M23 = 0f;
		result.M24 = 0f;
		result.M31 = num;
		result.M32 = 0f;
		result.M33 = num2;
		result.M34 = 0f;
		result.M41 = 0f;
		result.M42 = 0f;
		result.M43 = 0f;
		result.M44 = 1f;
	}

	/**
	 * Returns a matrix that can be used to rotate a set of vertices around the z-axis.
	 * 
	 * @param radians
	 * The amount, in radians, in which to rotate around the z-axis. Note that you can use ToRadians to convert degrees to radians.
	 */
	public static Matrix CreateRotationZ(float radians)
	{
		Matrix result = new Matrix();
		CreateRotationZ(radians, result);
		return result;
	}

	/**
	 * Populates data into a user-specified matrix that can be used to rotate a set of vertices around the z-axis.
	 * 
	 * @param radians
	 * The amount, in radians, in which to rotate around the z-axis. Note that you can use ToRadians to convert degrees to radians.
	 * 
	 * @param Matrix
	 * [OutAttribute] The rotation matrix.
	 */
	public static void CreateRotationZ(float radians, Matrix result)
	{
		float num2 = (float) Math.cos((double) radians);
		float num = (float) Math.sin((double) radians);
		result.M11 = num2;
		result.M12 = num;
		result.M13 = 0f;
		result.M14 = 0f;
		result.M21 = -num;
		result.M22 = num2;
		result.M23 = 0f;
		result.M24 = 0f;
		result.M31 = 0f;
		result.M32 = 0f;
		result.M33 = 1f;
		result.M34 = 0f;
		result.M41 = 0f;
		result.M42 = 0f;
		result.M43 = 0f;
		result.M44 = 1f;
	}

	/**
	 * Creates a scaling Matrix.
	 * 
	 * @param scales
	 * Amounts to scale by on the x, y, and z axes.
	 */
	public static Matrix CreateScale(Vector3 scales)
	{
		Matrix result = new Matrix();
		CreateScale(scales, result);
		return result;
	}

	/**
	 * Creates a scaling Matrix.
	 * 
	 * @param scale
	 * Amount to scale by.
	 */
	public static Matrix CreateScale(float scale)
	{
		Matrix result = new Matrix();
		CreateScale(scale, result);
		return result;
	}

	/**
	 * Creates a scaling Matrix.
	 * 
	 * @param scales
	 * Amounts to scale by on the x, y, and z axes.
	 * 
	 * @param result
	 * [OutAttribute] The created scaling Matrix.
	 */
	public static void CreateScale(Vector3 scales, Matrix result)
	{
		float x = scales.X;
		float y = scales.Y;
		float z = scales.Z;
		result.M11 = x;
		result.M12 = 0f;
		result.M13 = 0f;
		result.M14 = 0f;
		result.M21 = 0f;
		result.M22 = y;
		result.M23 = 0f;
		result.M24 = 0f;
		result.M31 = 0f;
		result.M32 = 0f;
		result.M33 = z;
		result.M34 = 0f;
		result.M41 = 0f;
		result.M42 = 0f;
		result.M43 = 0f;
		result.M44 = 1f;
	}

	/**
	 * Creates a scaling Matrix.
	 * 
	 * @param scale
	 * Value to scale by.
	 * 
	 * @param result
	 * [OutAttribute] The created scaling Matrix.
	 */
	public static void CreateScale(float scale, Matrix result)
	{
		float num = scale;
		result.M11 = num;
		result.M12 = 0f;
		result.M13 = 0f;
		result.M14 = 0f;
		result.M21 = 0f;
		result.M22 = num;
		result.M23 = 0f;
		result.M24 = 0f;
		result.M31 = 0f;
		result.M32 = 0f;
		result.M33 = num;
		result.M34 = 0f;
		result.M41 = 0f;
		result.M42 = 0f;
		result.M43 = 0f;
		result.M44 = 1f;
	}

	/**
	 * Creates a scaling Matrix.
	 * 
	 * @param xScale
	 * Value to scale by on the x-axis.
	 * 
	 * @param yScale
	 * Value to scale by on the y-axis.
	 * 
	 * @param zScale
	 * Value to scale by on the z-axis.
	 */
	public static Matrix CreateScale(float xScale, float yScale, float zScale)
	{
		Matrix result = new Matrix();
		CreateScale(xScale, yScale, zScale, result);
		return result;
	}

	/**
	 * Creates a scaling Matrix.
	 * 
	 * @param xScale
	 * Value to scale by on the x-axis.
	 * 
	 * @param yScale
	 * Value to scale by on the y-axis.
	 * 
	 * @param zScale
	 * Value to scale by on the z-axis.
	 * 
	 * @param result
	 * [OutAttribute] The created scaling Matrix.
	 */
	public static void CreateScale(float xScale, float yScale, float zScale, Matrix result)
	{
		float num3 = xScale;
		float num2 = yScale;
		float num = zScale;
		result.M11 = num3;
		result.M12 = 0f;
		result.M13 = 0f;
		result.M14 = 0f;
		result.M21 = 0f;
		result.M22 = num2;
		result.M23 = 0f;
		result.M24 = 0f;
		result.M31 = 0f;
		result.M32 = 0f;
		result.M33 = num;
		result.M34 = 0f;
		result.M41 = 0f;
		result.M42 = 0f;
		result.M43 = 0f;
		result.M44 = 1f;
	}

	/**
	 * Creates a Matrix that flattens geometry into a specified Plane as if casting a shadow from a specified light source.
	 * 
	 * @param lightDirection
	 * A Vector3 specifying the direction from which the light that will cast the shadow is coming.
	 * 
	 * @param plane
	 * The Plane onto which the new matrix should flatten geometry so as to cast a shadow.
	 */
	public static Matrix CreateShadow(Vector3 lightDirection, Plane plane)
	{
		Matrix result = new Matrix();
		CreateShadow(lightDirection, plane, result);
		return result;
	}

	/**
	 * Fills in a Matrix to flatten geometry into a specified Plane as if casting a shadow from a specified light source.
	 * 
	 * @param lightDirection
	 * A Vector3 specifying the direction from which the light that will cast the shadow is coming.
	 * 
	 * @param plane
	 * The Plane onto which the new matrix should flatten geometry so as to cast a shadow.
	 * 
	 * @param result
	 * [OutAttribute] A Matrix that can be used to flatten geometry onto the specified plane from the specified direction.
	 */
	public static void CreateShadow(Vector3 lightDirection, Plane plane, Matrix result)
	{
		Plane plane2 = new Plane();
		Plane.Normalize(plane, plane2);
		float num = ((plane2.Normal.X * lightDirection.X) + (plane2.Normal.Y * lightDirection.Y)) + (plane2.Normal.Z * lightDirection.Z);
		float num5 = -plane2.Normal.X;
		float num4 = -plane2.Normal.Y;
		float num3 = -plane2.Normal.Z;
		float num2 = -plane2.D;
		result.M11 = (num5 * lightDirection.X) + num;
		result.M21 = num4 * lightDirection.X;
		result.M31 = num3 * lightDirection.X;
		result.M41 = num2 * lightDirection.X;
		result.M12 = num5 * lightDirection.Y;
		result.M22 = (num4 * lightDirection.Y) + num;
		result.M32 = num3 * lightDirection.Y;
		result.M42 = num2 * lightDirection.Y;
		result.M13 = num5 * lightDirection.Z;
		result.M23 = num4 * lightDirection.Z;
		result.M33 = (num3 * lightDirection.Z) + num;
		result.M43 = num2 * lightDirection.Z;
		result.M14 = 0f;
		result.M24 = 0f;
		result.M34 = 0f;
		result.M44 = num;
	}

	/**
	 * Creates a translation Matrix.
	 * 
	 * @param position
	 * Amounts to translate by on the x, y, and z axes.
	 */
	public static Matrix CreateTranslation(Vector3 position)
	{
		Matrix result = new Matrix();
		CreateTranslation(position, result);
		return result;
	}

	/**
	 * Creates a translation Matrix.
	 * 
	 * @param position
	 * Amounts to translate by on the x, y, and z axes.
	 * 
	 * @param result
	 * [OutAttribute] The created translation Matrix.
	 */
	public static void CreateTranslation(Vector3 position, Matrix result)
	{
		result.M11 = 1f;
		result.M12 = 0f;
		result.M13 = 0f;
		result.M14 = 0f;
		result.M21 = 0f;
		result.M22 = 1f;
		result.M23 = 0f;
		result.M24 = 0f;
		result.M31 = 0f;
		result.M32 = 0f;
		result.M33 = 1f;
		result.M34 = 0f;
		result.M41 = position.X;
		result.M42 = position.Y;
		result.M43 = position.Z;
		result.M44 = 1f;
	}

	/**
	 * Creates a translation Matrix.
	 * 
	 * @param xPosition
	 * Value to translate by on the x-axis.
	 * 
	 * @param yPosition
	 * Value to translate by on the y-axis.
	 * 
	 * @param zPosition
	 * Value to translate by on the z-axis.
	 */
	public static Matrix CreateTranslation(float xPosition, float yPosition, float zPosition)
	{
		Matrix result = new Matrix();
		CreateTranslation(xPosition, yPosition, zPosition, result);
		return result;
	}

	/**
	 * Creates a translation Matrix.
	 * 
	 * @param xPosition
	 * Value to translate by on the x-axis.
	 * 
	 * @param yPosition
	 * Value to translate by on the y-axis.
	 * 
	 * @param zPosition
	 * Value to translate by on the z-axis.
	 * 
	 * @param result
	 * [OutAttribute] The created translation Matrix.
	 */
	public static void CreateTranslation(float xPosition, float yPosition, float zPosition, Matrix result)
	{
		result.M11 = 1f;
		result.M12 = 0f;
		result.M13 = 0f;
		result.M14 = 0f;
		result.M21 = 0f;
		result.M22 = 1f;
		result.M23 = 0f;
		result.M24 = 0f;
		result.M31 = 0f;
		result.M32 = 0f;
		result.M33 = 1f;
		result.M34 = 0f;
		result.M41 = xPosition;
		result.M42 = yPosition;
		result.M43 = zPosition;
		result.M44 = 1f;
	}

	/**
	 * Creates a world matrix with the specified parameters.
	 * 
	 * @param position
	 * Position of the object. This value is used in translation operations.
	 * 
	 * @param forward
	 * Forward direction of the object.
	 * 
	 * @param up
	 * Upward direction of the object; usually [0, 1, 0].
	 */
	public static Matrix CreateWorld(Vector3 position, Vector3 forward, Vector3 up)
	{
		Matrix result = new Matrix();
		CreateWorld(position, forward, up, result);
		return result;
	}

	/**
	 * Creates a world matrix with the specified parameters.
	 * 
	 * @param position
	 * Position of the object. This value is used in translation operations.
	 * 
	 * @param forward
	 * Forward direction of the object.
	 * 
	 * @param up
	 * Upward direction of the object; usually [0, 1, 0].
	 * 
	 * @param result
	 * [OutAttribute] The created world matrix.
	 */
	public static void CreateWorld(Vector3 position, Vector3 forward, Vector3 up, Matrix result)
	{
		Vector3 vector = Vector3.Normalize(Vector3.Negate(forward));
		Vector3 vector2 = Vector3.Normalize(Vector3.Cross(up, vector));
		Vector3 vector3 = Vector3.Cross(vector, vector2);
		result.M11 = vector2.X;
		result.M12 = vector2.Y;
		result.M13 = vector2.Z;
		result.M14 = 0f;
		result.M21 = vector3.X;
		result.M22 = vector3.Y;
		result.M23 = vector3.Z;
		result.M24 = 0f;
		result.M31 = vector.X;
		result.M32 = vector.Y;
		result.M33 = vector.Z;
		result.M34 = 0f;
		result.M41 = position.X;
		result.M42 = position.Y;
		result.M43 = position.Z;
		result.M44 = 1f;
	}

	/**
	 * Calculates the determinant of the matrix.
	 */
	public float Determinant()
	{
		float num22 = this.M11;
		float num21 = this.M12;
		float num20 = this.M13;
		float num19 = this.M14;
		float num12 = this.M21;
		float num11 = this.M22;
		float num10 = this.M23;
		float num9 = this.M24;
		float num8 = this.M31;
		float num7 = this.M32;
		float num6 = this.M33;
		float num5 = this.M34;
		float num4 = this.M41;
		float num3 = this.M42;
		float num2 = this.M43;
		float num = this.M44;
		float num18 = (num6 * num) - (num5 * num2);
		float num17 = (num7 * num) - (num5 * num3);
		float num16 = (num7 * num2) - (num6 * num3);
		float num15 = (num8 * num) - (num5 * num4);
		float num14 = (num8 * num2) - (num6 * num4);
		float num13 = (num8 * num3) - (num7 * num4);
		return ((((num22 * (((num11 * num18) - (num10 * num17)) + (num9 * num16))) - (num21 * (((num12 * num18) - (num10 * num15)) + (num9 * num14)))) + (num20 * (((num12 * num17) - (num11 * num15)) + (num9 * num13)))) - (num19 * (((num12 * num16) - (num11 * num14)) + (num10 * num13))));
	}

	/**
	 * Divides the components of the current matrix by the corresponding components of another matrix.
	 * 
	 * @param other
	 * The divisor.
	 */
	public void Divide(Matrix other)
	{
		Divide(this, other, this);
	}

	/**
	 * Divides the components of a matrix by the corresponding components of another matrix.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * The divisor.
	 */
	public static Matrix Divide(Matrix matrix1, Matrix matrix2)
	{
		Matrix matrix = new Matrix();
		matrix.M11 = matrix1.M11 / matrix2.M11;
		matrix.M12 = matrix1.M12 / matrix2.M12;
		matrix.M13 = matrix1.M13 / matrix2.M13;
		matrix.M14 = matrix1.M14 / matrix2.M14;
		matrix.M21 = matrix1.M21 / matrix2.M21;
		matrix.M22 = matrix1.M22 / matrix2.M22;
		matrix.M23 = matrix1.M23 / matrix2.M23;
		matrix.M24 = matrix1.M24 / matrix2.M24;
		matrix.M31 = matrix1.M31 / matrix2.M31;
		matrix.M32 = matrix1.M32 / matrix2.M32;
		matrix.M33 = matrix1.M33 / matrix2.M33;
		matrix.M34 = matrix1.M34 / matrix2.M34;
		matrix.M41 = matrix1.M41 / matrix2.M41;
		matrix.M42 = matrix1.M42 / matrix2.M42;
		matrix.M43 = matrix1.M43 / matrix2.M43;
		matrix.M44 = matrix1.M44 / matrix2.M44;
		return matrix;
	}

	/**
	 * Divides the components of the current matrix by a scalar.
	 * 
	 * @param divider
	 * The divisor.
	 */
	public void Divide(float divider)
	{
		Divide(this, divider, this);
	}

	/**
	 * Divides the components of a matrix by a scalar.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param divider
	 * The divisor.
	 */
	public static Matrix Divide(Matrix matrix1, float divider)
	{
		Matrix matrix = new Matrix();
		float num = 1f / divider;
		matrix.M11 = matrix1.M11 * num;
		matrix.M12 = matrix1.M12 * num;
		matrix.M13 = matrix1.M13 * num;
		matrix.M14 = matrix1.M14 * num;
		matrix.M21 = matrix1.M21 * num;
		matrix.M22 = matrix1.M22 * num;
		matrix.M23 = matrix1.M23 * num;
		matrix.M24 = matrix1.M24 * num;
		matrix.M31 = matrix1.M31 * num;
		matrix.M32 = matrix1.M32 * num;
		matrix.M33 = matrix1.M33 * num;
		matrix.M34 = matrix1.M34 * num;
		matrix.M41 = matrix1.M41 * num;
		matrix.M42 = matrix1.M42 * num;
		matrix.M43 = matrix1.M43 * num;
		matrix.M44 = matrix1.M44 * num;
		return matrix;
	}

	/**
	 * Divides the components of a matrix by a scalar.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param divider
	 * The divisor.
	 * 
	 * @param result
	 * [OutAttribute] Result of the division.
	 */
	public static void Divide(Matrix matrix1, float divider, Matrix result)
	{
		float num = 1f / divider;
		result.M11 = matrix1.M11 * num;
		result.M12 = matrix1.M12 * num;
		result.M13 = matrix1.M13 * num;
		result.M14 = matrix1.M14 * num;
		result.M21 = matrix1.M21 * num;
		result.M22 = matrix1.M22 * num;
		result.M23 = matrix1.M23 * num;
		result.M24 = matrix1.M24 * num;
		result.M31 = matrix1.M31 * num;
		result.M32 = matrix1.M32 * num;
		result.M33 = matrix1.M33 * num;
		result.M34 = matrix1.M34 * num;
		result.M41 = matrix1.M41 * num;
		result.M42 = matrix1.M42 * num;
		result.M43 = matrix1.M43 * num;
		result.M44 = matrix1.M44 * num;
	}

	/**
	 * Divides the components of a matrix by the corresponding components of another matrix.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * The divisor.
	 * 
	 * @param result
	 * [OutAttribute] Result of the division.
	 */
	public static void Divide(Matrix matrix1, Matrix matrix2, Matrix result)
	{
		result.M11 = matrix1.M11 / matrix2.M11;
		result.M12 = matrix1.M12 / matrix2.M12;
		result.M13 = matrix1.M13 / matrix2.M13;
		result.M14 = matrix1.M14 / matrix2.M14;
		result.M21 = matrix1.M21 / matrix2.M21;
		result.M22 = matrix1.M22 / matrix2.M22;
		result.M23 = matrix1.M23 / matrix2.M23;
		result.M24 = matrix1.M24 / matrix2.M24;
		result.M31 = matrix1.M31 / matrix2.M31;
		result.M32 = matrix1.M32 / matrix2.M32;
		result.M33 = matrix1.M33 / matrix2.M33;
		result.M34 = matrix1.M34 / matrix2.M34;
		result.M41 = matrix1.M41 / matrix2.M41;
		result.M42 = matrix1.M42 / matrix2.M42;
		result.M43 = matrix1.M43 / matrix2.M43;
		result.M44 = matrix1.M44 / matrix2.M44;
	}

	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * Object with which to make the comparison.
	 * 
	 * @return
	 * true if the current instance is equal to the specified object; false otherwise.
	 */
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Matrix) ? this.Equals((Matrix)obj) : false;
	}

	/**
	 * Determines whether the specified Object is equal to the Matrix.
	 * 
	 * @param other
	 * The Object to compare with the current Matrix.
	 */
	public boolean Equals(Matrix other)
	{
		return ((((((this.M11 == other.M11) && (this.M22 == other.M22)) && ((this.M33 == other.M33) && (this.M44 == other.M44))) && (((this.M12 == other.M12) && (this.M13 == other.M13)) && ((this.M14 == other.M14) && (this.M21 == other.M21)))) && ((((this.M23 == other.M23) && (this.M24 == other.M24)) && ((this.M31 == other.M31) && (this.M32 == other.M32))) && (((this.M34 == other.M34) && (this.M41 == other.M41)) && (this.M42 == other.M42)))) && (this.M43 == other.M43));
	}

	/**
	 * Gets the hash code of this object.
	 */
	@Override
	public int hashCode()
	{
		return ((((((((((((((((int)this.M11 ^ (int)this.M12) ^ (int)this.M13) ^ (int)this.M14) ^ (int)this.M21) ^ (int)this.M22) ^ (int)this.M23) ^ (int)this.M24) ^ (int)this.M31) ^ (int)this.M32) ^ (int)this.M33) ^ (int)this.M34) ^ (int)this.M41) ^ (int)this.M42) ^ (int)this.M43) ^ (int)this.M44);
	}

	/**
	 * Calculates the inverse of a matrix.
	 * 
	 * @param matrix
	 * Source matrix.
	 */
	public static Matrix Invert(Matrix matrix)
	{
		Matrix result = new Matrix();
		Invert(matrix, result);
		return result;
	}

	/**
	 * Calculates the inverse of a matrix.
	 * 
	 * @param matrix
	 * The source matrix;
	 * 
	 * @param result
	 * [OutAttribute] The inverse of matrix. The same matrix can be used for both arguments.
	 */
	public static void Invert(Matrix matrix, Matrix result)
	{
		float num5 = matrix.M11;
		float num4 = matrix.M12;
		float num3 = matrix.M13;
		float num2 = matrix.M14;
		float num9 = matrix.M21;
		float num8 = matrix.M22;
		float num7 = matrix.M23;
		float num6 = matrix.M24;
		float num17 = matrix.M31;
		float num16 = matrix.M32;
		float num15 = matrix.M33;
		float num14 = matrix.M34;
		float num13 = matrix.M41;
		float num12 = matrix.M42;
		float num11 = matrix.M43;
		float num10 = matrix.M44;
		float num23 = (num15 * num10) - (num14 * num11);
		float num22 = (num16 * num10) - (num14 * num12);
		float num21 = (num16 * num11) - (num15 * num12);
		float num20 = (num17 * num10) - (num14 * num13);
		float num19 = (num17 * num11) - (num15 * num13);
		float num18 = (num17 * num12) - (num16 * num13);
		float num39 = ((num8 * num23) - (num7 * num22)) + (num6 * num21);
		float num38 = -(((num9 * num23) - (num7 * num20)) + (num6 * num19));
		float num37 = ((num9 * num22) - (num8 * num20)) + (num6 * num18);
		float num36 = -(((num9 * num21) - (num8 * num19)) + (num7 * num18));
		float num = 1f / ((((num5 * num39) + (num4 * num38)) + (num3 * num37)) + (num2 * num36));
		result.M11 = num39 * num;
		result.M21 = num38 * num;
		result.M31 = num37 * num;
		result.M41 = num36 * num;
		result.M12 = -(((num4 * num23) - (num3 * num22)) + (num2 * num21)) * num;
		result.M22 = (((num5 * num23) - (num3 * num20)) + (num2 * num19)) * num;
		result.M32 = -(((num5 * num22) - (num4 * num20)) + (num2 * num18)) * num;
		result.M42 = (((num5 * num21) - (num4 * num19)) + (num3 * num18)) * num;
		float num35 = (num7 * num10) - (num6 * num11);
		float num34 = (num8 * num10) - (num6 * num12);
		float num33 = (num8 * num11) - (num7 * num12);
		float num32 = (num9 * num10) - (num6 * num13);
		float num31 = (num9 * num11) - (num7 * num13);
		float num30 = (num9 * num12) - (num8 * num13);
		result.M13 = (((num4 * num35) - (num3 * num34)) + (num2 * num33)) * num;
		result.M23 = -(((num5 * num35) - (num3 * num32)) + (num2 * num31)) * num;
		result.M33 = (((num5 * num34) - (num4 * num32)) + (num2 * num30)) * num;
		result.M43 = -(((num5 * num33) - (num4 * num31)) + (num3 * num30)) * num;
		float num29 = (num7 * num14) - (num6 * num15);
		float num28 = (num8 * num14) - (num6 * num16);
		float num27 = (num8 * num15) - (num7 * num16);
		float num26 = (num9 * num14) - (num6 * num17);
		float num25 = (num9 * num15) - (num7 * num17);
		float num24 = (num9 * num16) - (num8 * num17);
		result.M14 = -(((num4 * num29) - (num3 * num28)) + (num2 * num27)) * num;
		result.M24 = (((num5 * num29) - (num3 * num26)) + (num2 * num25)) * num;
		result.M34 = -(((num5 * num28) - (num4 * num26)) + (num2 * num24)) * num;
		result.M44 = (((num5 * num27) - (num4 * num25)) + (num3 * num24)) * num;
	}

	/**
	 * Linearly interpolates between the corresponding values of two matrices.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * Source matrix.
	 * 
	 * @param amount
	 * Interpolation value.
	 */
	public static Matrix Lerp(Matrix matrix1, Matrix matrix2, float amount)
	{
		Matrix result = new Matrix();
		Lerp(matrix1, matrix2, amount, result);
		return result;
	}

	/**
	 * Linearly interpolates between the corresponding values of two matrices.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * Source matrix.
	 * 
	 * @param amount
	 * Interpolation value.
	 * 
	 * @param result
	 * [OutAttribute] Resulting matrix.
	 */
	public static void Lerp(Matrix matrix1, Matrix matrix2, float amount, Matrix result)
	{
		result.M11 = matrix1.M11 + ((matrix2.M11 - matrix1.M11) * amount);
		result.M12 = matrix1.M12 + ((matrix2.M12 - matrix1.M12) * amount);
		result.M13 = matrix1.M13 + ((matrix2.M13 - matrix1.M13) * amount);
		result.M14 = matrix1.M14 + ((matrix2.M14 - matrix1.M14) * amount);
		result.M21 = matrix1.M21 + ((matrix2.M21 - matrix1.M21) * amount);
		result.M22 = matrix1.M22 + ((matrix2.M22 - matrix1.M22) * amount);
		result.M23 = matrix1.M23 + ((matrix2.M23 - matrix1.M23) * amount);
		result.M24 = matrix1.M24 + ((matrix2.M24 - matrix1.M24) * amount);
		result.M31 = matrix1.M31 + ((matrix2.M31 - matrix1.M31) * amount);
		result.M32 = matrix1.M32 + ((matrix2.M32 - matrix1.M32) * amount);
		result.M33 = matrix1.M33 + ((matrix2.M33 - matrix1.M33) * amount);
		result.M34 = matrix1.M34 + ((matrix2.M34 - matrix1.M34) * amount);
		result.M41 = matrix1.M41 + ((matrix2.M41 - matrix1.M41) * amount);
		result.M42 = matrix1.M42 + ((matrix2.M42 - matrix1.M42) * amount);
		result.M43 = matrix1.M43 + ((matrix2.M43 - matrix1.M43) * amount);
		result.M44 = matrix1.M44 + ((matrix2.M44 - matrix1.M44) * amount);
	}

	/**
	 * Multiplies the current matrix by another matrix.
	 * 
	 * @param other
	 * Source matrix.
	 */
	public void Multiply(Matrix other)
	{
		Multiply(this, other, this);
	}

	/**
	 * Multiplies a matrix by another matrix.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * Source matrix.
	 */
	public static Matrix Multiply(Matrix matrix1, Matrix matrix2)
	{
		Matrix result = new Matrix();
		Multiply(matrix1, matrix2, result);
		return result;
	}

	/**
	 * Multiplies the current matrix by a scalar value.
	 * 
	 * @param scaleFactor
	 * Scalar value.
	 */
	public void Multiply(float scaleFactor)
	{
		Multiply(this, scaleFactor, this);
	}

	/**
	 * Multiplies a matrix by a scalar value.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param scaleFactor
	 * Scalar value.
	 */
	public static Matrix Multiply(Matrix matrix1, float scaleFactor)
	{
		Matrix result = new Matrix();
		Multiply(matrix1, scaleFactor, result);
		return result;
	}

	/**
	 * Multiplies a matrix by another matrix.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * Source matrix.
	 * 
	 * @param result
	 * [OutAttribute] Result of the multiplication.
	 */
	public static void Multiply(Matrix matrix1, Matrix matrix2, Matrix result)
	{
		float num16 = (((matrix1.M11 * matrix2.M11) + (matrix1.M12 * matrix2.M21)) + (matrix1.M13 * matrix2.M31)) + (matrix1.M14 * matrix2.M41);
		float num15 = (((matrix1.M11 * matrix2.M12) + (matrix1.M12 * matrix2.M22)) + (matrix1.M13 * matrix2.M32)) + (matrix1.M14 * matrix2.M42);
		float num14 = (((matrix1.M11 * matrix2.M13) + (matrix1.M12 * matrix2.M23)) + (matrix1.M13 * matrix2.M33)) + (matrix1.M14 * matrix2.M43);
		float num13 = (((matrix1.M11 * matrix2.M14) + (matrix1.M12 * matrix2.M24)) + (matrix1.M13 * matrix2.M34)) + (matrix1.M14 * matrix2.M44);
		float num12 = (((matrix1.M21 * matrix2.M11) + (matrix1.M22 * matrix2.M21)) + (matrix1.M23 * matrix2.M31)) + (matrix1.M24 * matrix2.M41);
		float num11 = (((matrix1.M21 * matrix2.M12) + (matrix1.M22 * matrix2.M22)) + (matrix1.M23 * matrix2.M32)) + (matrix1.M24 * matrix2.M42);
		float num10 = (((matrix1.M21 * matrix2.M13) + (matrix1.M22 * matrix2.M23)) + (matrix1.M23 * matrix2.M33)) + (matrix1.M24 * matrix2.M43);
		float num9 = (((matrix1.M21 * matrix2.M14) + (matrix1.M22 * matrix2.M24)) + (matrix1.M23 * matrix2.M34)) + (matrix1.M24 * matrix2.M44);
		float num8 = (((matrix1.M31 * matrix2.M11) + (matrix1.M32 * matrix2.M21)) + (matrix1.M33 * matrix2.M31)) + (matrix1.M34 * matrix2.M41);
		float num7 = (((matrix1.M31 * matrix2.M12) + (matrix1.M32 * matrix2.M22)) + (matrix1.M33 * matrix2.M32)) + (matrix1.M34 * matrix2.M42);
		float num6 = (((matrix1.M31 * matrix2.M13) + (matrix1.M32 * matrix2.M23)) + (matrix1.M33 * matrix2.M33)) + (matrix1.M34 * matrix2.M43);
		float num5 = (((matrix1.M31 * matrix2.M14) + (matrix1.M32 * matrix2.M24)) + (matrix1.M33 * matrix2.M34)) + (matrix1.M34 * matrix2.M44);
		float num4 = (((matrix1.M41 * matrix2.M11) + (matrix1.M42 * matrix2.M21)) + (matrix1.M43 * matrix2.M31)) + (matrix1.M44 * matrix2.M41);
		float num3 = (((matrix1.M41 * matrix2.M12) + (matrix1.M42 * matrix2.M22)) + (matrix1.M43 * matrix2.M32)) + (matrix1.M44 * matrix2.M42);
		float num2 = (((matrix1.M41 * matrix2.M13) + (matrix1.M42 * matrix2.M23)) + (matrix1.M43 * matrix2.M33)) + (matrix1.M44 * matrix2.M43);
		float num = (((matrix1.M41 * matrix2.M14) + (matrix1.M42 * matrix2.M24)) + (matrix1.M43 * matrix2.M34)) + (matrix1.M44 * matrix2.M44);
		result.M11 = num16;
		result.M12 = num15;
		result.M13 = num14;
		result.M14 = num13;
		result.M21 = num12;
		result.M22 = num11;
		result.M23 = num10;
		result.M24 = num9;
		result.M31 = num8;
		result.M32 = num7;
		result.M33 = num6;
		result.M34 = num5;
		result.M41 = num4;
		result.M42 = num3;
		result.M43 = num2;
		result.M44 = num;
	}

	/**
	 * Multiplies a matrix by a scalar value.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param scaleFactor
	 * Scalar value.
	 * 
	 * @param result
	 * [OutAttribute] The result of the multiplication.
	 */
	public static void Multiply(Matrix matrix1, float scaleFactor, Matrix result)
	{
		float num = scaleFactor;
		result.M11 = matrix1.M11 * num;
		result.M12 = matrix1.M12 * num;
		result.M13 = matrix1.M13 * num;
		result.M14 = matrix1.M14 * num;
		result.M21 = matrix1.M21 * num;
		result.M22 = matrix1.M22 * num;
		result.M23 = matrix1.M23 * num;
		result.M24 = matrix1.M24 * num;
		result.M31 = matrix1.M31 * num;
		result.M32 = matrix1.M32 * num;
		result.M33 = matrix1.M33 * num;
		result.M34 = matrix1.M34 * num;
		result.M41 = matrix1.M41 * num;
		result.M42 = matrix1.M42 * num;
		result.M43 = matrix1.M43 * num;
		result.M44 = matrix1.M44 * num;
	}

	/**
	 * Negates individual elements of the current matrix.
	 */
	public void Negate()
	{
		Negate(this, this);
	}

	/**
	 * Negates individual elements of a matrix.
	 * 
	 * @param matrix
	 * Source matrix.
	 */
	public static Matrix Negate(Matrix matrix)
	{
		Matrix result = new Matrix();
		Negate(matrix, result);
		return result;
	}

	/**
	 * Negates individual elements of a matrix.
	 * 
	 * @param matrix
	 * Source matrix.
	 * 
	 * @param result
	 * [OutAttribute] Negated matrix.
	 */
	public static void Negate(Matrix matrix, Matrix result)
	{
		result.M11 = -matrix.M11;
		result.M12 = -matrix.M12;
		result.M13 = -matrix.M13;
		result.M14 = -matrix.M14;
		result.M21 = -matrix.M21;
		result.M22 = -matrix.M22;
		result.M23 = -matrix.M23;
		result.M24 = -matrix.M24;
		result.M31 = -matrix.M31;
		result.M32 = -matrix.M32;
		result.M33 = -matrix.M33;
		result.M34 = -matrix.M34;
		result.M41 = -matrix.M41;
		result.M42 = -matrix.M42;
		result.M43 = -matrix.M43;
		result.M44 = -matrix.M44;
	}

	/**
	 * Subtracts the specified matrix from the current matrix.
	 * 
	 * @param other
	 * Source matrix.
	 */
	public void Subtract(Matrix other)
	{
		Subtract(this, other, this);
	}

	/**
	 * Subtracts matrices.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * Source matrix.
	 */
	public static Matrix Subtract(Matrix matrix1, Matrix matrix2)
	{
		Matrix result = new Matrix();
		Subtract(matrix1, matrix2, result);
		return result;
	}

	/**
	 * Subtracts matrices.
	 * 
	 * @param matrix1
	 * Source matrix.
	 * 
	 * @param matrix2
	 * Source matrix.
	 * 
	 * @param result
	 * [OutAttribute] Result of the subtraction.
	 */
	public static void Subtract(Matrix matrix1, Matrix matrix2, Matrix result)
	{
		result.M11 = matrix1.M11 - matrix2.M11;
		result.M12 = matrix1.M12 - matrix2.M12;
		result.M13 = matrix1.M13 - matrix2.M13;
		result.M14 = matrix1.M14 - matrix2.M14;
		result.M21 = matrix1.M21 - matrix2.M21;
		result.M22 = matrix1.M22 - matrix2.M22;
		result.M23 = matrix1.M23 - matrix2.M23;
		result.M24 = matrix1.M24 - matrix2.M24;
		result.M31 = matrix1.M31 - matrix2.M31;
		result.M32 = matrix1.M32 - matrix2.M32;
		result.M33 = matrix1.M33 - matrix2.M33;
		result.M34 = matrix1.M34 - matrix2.M34;
		result.M41 = matrix1.M41 - matrix2.M41;
		result.M42 = matrix1.M42 - matrix2.M42;
		result.M43 = matrix1.M43 - matrix2.M43;
		result.M44 = matrix1.M44 - matrix2.M44;
	}

	/**
	 * Retrieves a string representation of the current object.
	 * 
	 * @return
	 * String that represents the object.
	 */
	@Override
	public String toString()
	{
		return ("{ " + String.format(Locale.getDefault(), "{M11:%f M12:%f M13:%f M14:%f} ", this.M11, this.M12, this.M13, this.M14) + String.format(Locale.getDefault(), "{M21:%f M22:%f M23:%f M24:%f} ", this.M21, this.M22, this.M23, this.M24) + String.format(Locale.getDefault(), "{M31:%f M32:%f M33:%f M34:%f} ", this.M31, this.M32, this.M33, this.M34) + String.format(Locale.getDefault(), "{M41:%f M42:%f M43:%f M44:%f} ", this.M41, this.M42, this.M43, this.M44) + "}");
	}

	/**
	 * Transforms a Matrix by applying a Quaternion rotation.
	 * 
	 * @param value
	 * The Matrix to transform.
	 * 
	 * @param rotation
	 * The rotation to apply, expressed as a Quaternion.
	 */
	public static Matrix Transform(Matrix value, Quaternion rotation)
	{
		Matrix result = new Matrix();
		Transform(value, rotation, result);
		return result;
	}

	/**
	 * Transforms a Matrix by applying a Quaternion rotation.
	 * 
	 * @param value
	 * The Matrix to transform.
	 * 
	 * @param rotation
	 * The rotation to apply, expressed as a Quaternion.
	 * 
	 * @param result
	 * [OutAttribute] An existing Matrix filled in with the result of the transform.
	 */
	public static void Transform(Matrix value, Quaternion rotation, Matrix result)
	{
		float num21 = rotation.X + rotation.X;
		float num11 = rotation.Y + rotation.Y;
		float num10 = rotation.Z + rotation.Z;
		float num20 = rotation.W * num21;
		float num19 = rotation.W * num11;
		float num18 = rotation.W * num10;
		float num17 = rotation.X * num21;
		float num16 = rotation.X * num11;
		float num15 = rotation.X * num10;
		float num14 = rotation.Y * num11;
		float num13 = rotation.Y * num10;
		float num12 = rotation.Z * num10;
		float num9 = (1f - num14) - num12;
		float num8 = num16 - num18;
		float num7 = num15 + num19;
		float num6 = num16 + num18;
		float num5 = (1f - num17) - num12;
		float num4 = num13 - num20;
		float num3 = num15 - num19;
		float num2 = num13 + num20;
		float num = (1f - num17) - num14;
		float num37 = ((value.M11 * num9) + (value.M12 * num8)) + (value.M13 * num7);
		float num36 = ((value.M11 * num6) + (value.M12 * num5)) + (value.M13 * num4);
		float num35 = ((value.M11 * num3) + (value.M12 * num2)) + (value.M13 * num);
		float num34 = value.M14;
		float num33 = ((value.M21 * num9) + (value.M22 * num8)) + (value.M23 * num7);
		float num32 = ((value.M21 * num6) + (value.M22 * num5)) + (value.M23 * num4);
		float num31 = ((value.M21 * num3) + (value.M22 * num2)) + (value.M23 * num);
		float num30 = value.M24;
		float num29 = ((value.M31 * num9) + (value.M32 * num8)) + (value.M33 * num7);
		float num28 = ((value.M31 * num6) + (value.M32 * num5)) + (value.M33 * num4);
		float num27 = ((value.M31 * num3) + (value.M32 * num2)) + (value.M33 * num);
		float num26 = value.M34;
		float num25 = ((value.M41 * num9) + (value.M42 * num8)) + (value.M43 * num7);
		float num24 = ((value.M41 * num6) + (value.M42 * num5)) + (value.M43 * num4);
		float num23 = ((value.M41 * num3) + (value.M42 * num2)) + (value.M43 * num);
		float num22 = value.M44;
		result.M11 = num37;
		result.M12 = num36;
		result.M13 = num35;
		result.M14 = num34;
		result.M21 = num33;
		result.M22 = num32;
		result.M23 = num31;
		result.M24 = num30;
		result.M31 = num29;
		result.M32 = num28;
		result.M33 = num27;
		result.M34 = num26;
		result.M41 = num25;
		result.M42 = num24;
		result.M43 = num23;
		result.M44 = num22;
	}

	/**
	 * Transposes the rows and columns of a matrix.
	 * 
	 * @param matrix
	 * Source matrix.
	 */
	public static Matrix Transpose(Matrix matrix)
	{
		Matrix result = new Matrix();
		Transpose(matrix, result);
		return result;
	}

	/**
	 * Transposes the rows and columns of a matrix.
	 * 
	 * @param matrix
	 * Source matrix.
	 * 
	 * @param result
	 * [OutAttribute] Transposed matrix.
	 */
	public static void Transpose(Matrix matrix, Matrix result)
	{
		result.M11 = matrix.M11;
		result.M12 = matrix.M21;
		result.M13 = matrix.M31;
		result.M14 = matrix.M41;
		result.M21 = matrix.M12;
		result.M22 = matrix.M22;
		result.M23 = matrix.M32;
		result.M24 = matrix.M42;
		result.M31 = matrix.M13;
		result.M32 = matrix.M23;
		result.M33 = matrix.M33;
		result.M34 = matrix.M43;
		result.M41 = matrix.M14;
		result.M42 = matrix.M24;
		result.M43 = matrix.M34;
		result.M44 = matrix.M44;
	}
}
