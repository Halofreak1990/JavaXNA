package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a plane.
 * 
 * @author Halofreak1990
 */
public final class Plane extends ValueType implements IEquatable<Plane>
{
	/**
	 * The normal vector of the Plane.
	 */
	public Vector3 Normal;
	/**
	 * The distance of the Plane along its normal from the origin.
	 */
    public float D;
    
    /**
     * Creates a new instance of Plane.
     * 
     * @param a
     * X component of the normal defining the Plane.
     * 
     * @param b
     * Y component of the normal defining the Plane.
     * 
     * @param c
     * Z component of the normal defining the Plane.
     * 
     * @param d
     * Distance of the Plane along its normal from the origin.
     */
    public Plane(float a, float b, float c, float d)
    {
    	this.Normal = new Vector3(a, b, c);
        this.D = d;
    }

    /**
     * Creates a new instance of Plane.
     * 
     * @param normal
     * The normal vector to the Plane.
     * 
     * @param d
     * The Plane's distance along its normal from the origin.
     */
    public Plane(Vector3 normal, float d)
    {
        this.Normal = new Vector3(normal.X, normal.Y, normal.Z);
        this.D = d;
    }

    /**
     * Creates a new instance of Plane.
     * 
     * @param value
     * Vector4 with X, Y, and Z components defining the normal of the Plane. The W component defines the distance of the Plane along the normal from the origin.
     */
    public Plane(Vector4 value)
    {
    	this.Normal = new Vector3(value.X, value.Y, value.Z);
        this.D = value.W;
    }

    /**
     * Creates a new instance of Plane.
     * 
     * @param point1
     * One point of a triangle defining the Plane.
     * 
     * @param point2
     * One point of a triangle defining the Plane.
     * 
     * @param point3
     * One point of a triangle defining the Plane.
     */
    public Plane(Vector3 point1, Vector3 point2, Vector3 point3)
    {
        float num10 = point2.X - point1.X;
        float num9 = point2.Y - point1.Y;
        float num8 = point2.Z - point1.Z;
        float num7 = point3.X - point1.X;
        float num6 = point3.Y - point1.Y;
        float num5 = point3.Z - point1.Z;
        float num4 = (num9 * num5) - (num8 * num6);
        float num3 = (num8 * num7) - (num10 * num5);
        float num2 = (num10 * num6) - (num9 * num7);
        float num11 = ((num4 * num4) + (num3 * num3)) + (num2 * num2);
        float num = 1f / ((float) Math.sqrt((double) num11));
        this.Normal.X = num4 * num;
        this.Normal.Y = num3 * num;
        this.Normal.Z = num2 * num;
        this.D = -(((this.Normal.X * point1.X) + (this.Normal.Y * point1.Y)) + (this.Normal.Z * point1.Z));
    }
    
    /**
     * Creates a new instance of Plane.
     */
    public Plane()
    {
		Normal = new Vector3();
		D = 0;
	}

	/**
     * Calculates the dot product of a specified Vector4 and this Plane.
     * 
     * @param value
     * The Vector4 to multiply this Plane by.
     */
    public float Dot(Vector4 value)
    {
        return ((((this.Normal.X * value.X) + (this.Normal.Y * value.Y)) + (this.Normal.Z * value.Z)) + (this.D * value.W));
    }
    
    /**
     * Calculates the dot product of a specified Vector4 and this Plane.
     * 
     * @param value
     * The Vector4 to multiply this Plane by.
     * 
     * @param result
     * [OutAttribute] The dot product of the specified Vector4 and this Plane.
     */
    public void Dot(Vector4 value, float result)
    {
        result = (((this.Normal.X * value.X) + (this.Normal.Y * value.Y)) + (this.Normal.Z * value.Z)) + (this.D * value.W);
    }
    
    /**
     * Returns the dot product of a specified Vector3 and the Normal vector of this Plane plus the distance (D) value of the Plane.
     * 
     * @param value
     * The Vector3 to multiply by.
     */
    public float DotCoordinate(Vector3 value)
    {
        return ((((this.Normal.X * value.X) + (this.Normal.Y * value.Y)) + (this.Normal.Z * value.Z)) + this.D);
    }
    
    /**
     * Returns the dot product of a specified Vector3 and the Normal vector of this Plane plus the distance (D) value of the Plane.
     * 
     * @param value
     * The Vector3 to multiply by.
     * 
     * @param result
     * [OutAttribute] The resulting value.
     */
    public void DotCoordinate(Vector3 value, float result)
    {
        result = (((this.Normal.X * value.X) + (this.Normal.Y * value.Y)) + (this.Normal.Z * value.Z)) + this.D;
    }
    
    /**
     * Returns the dot product of a specified Vector3 and the Normal vector of this Plane.
     * 
     * @param value
     * The Vector3 to multiply by.
     */
    public float DotNormal(Vector3 value)
    {
        return (((this.Normal.X * value.X) + (this.Normal.Y * value.Y)) + (this.Normal.Z * value.Z));
    }
    
    /**
     * Returns the dot product of a specified Vector3 and the Normal vector of this Plane.
     * 
     * @param value
     * The Vector3 to multiply by.
     * 
     * @param result
     * [OutAttribute] The resulting dot product.
     */
    public void DotNormal(Vector3 value, float result)
    {
        result = ((this.Normal.X * value.X) + (this.Normal.Y * value.Y)) + (this.Normal.Z * value.Z);
    }
    
    /**
     * Determines whether the specified Object is equal to the Plane.
     * 
     * @param obj
     * The Object to compare with the current Plane.
     */
    @Override
    public boolean equals(Object obj)
    {
    	return (obj != null && obj instanceof Plane) ? this.Equals((Plane)obj) : false;
    }
    
    /**
     * Determines whether the specified Plane is equal to the Plane.
     * 
     * @param other
     * The Plane to compare with the current Plane.
     */
    public boolean Equals(Plane other)
    {
        return (this.Normal.Equals(other.Normal) && this.D == other.D);
    }
    
    /**
     * Gets the hash code for this object.
     */
    @Override
    public int hashCode()
    {
        return (this.Normal.hashCode() ^ (int)this.D);
    }
    
    /**
     * Checks whether the current Plane intersects a specified BoundingBox.
     * 
     * @param box
     * The BoundingBox to test for intersection with.
     */
    public PlaneIntersectionType Intersects(BoundingBox box)
    {
    	PlaneIntersectionType result = PlaneIntersectionType.Front;
    	Intersects(box, result);
    	return result;
    }

    /**
     * Checks whether the current Plane intersects a specified BoundingSphere.
     * 
     * @param sphere
     * The BoundingSphere to check for intersection with.
     */
    public PlaneIntersectionType Intersects(BoundingSphere sphere)
    {
        float num2 = ((sphere.Center.X * this.Normal.X) + (sphere.Center.Y * this.Normal.Y)) + (sphere.Center.Z * this.Normal.Z);
        float num = num2 + this.D;
        if (num > sphere.Radius)
        {
            return PlaneIntersectionType.Front;
        }
        if (num < -sphere.Radius)
        {
            return PlaneIntersectionType.Back;
        }
        return PlaneIntersectionType.Intersecting;
    }
    
    /**
     * Checks whether the current Plane intersects a BoundingBox.
     * 
     * @param box
     * The BoundingBox to check for intersection with.
     * 
     * @param result
     * [OutAttribute] An enumeration indicating whether the Plane intersects the BoundingBox.
     */
    public void Intersects(BoundingBox box, PlaneIntersectionType result)
    {
        Vector3 vector = Vector3.Zero;
        Vector3 vector2 = Vector3.Zero;
        vector2.X = (this.Normal.X >= 0f) ? box.Min.X : box.Max.X;
        vector2.Y = (this.Normal.Y >= 0f) ? box.Min.Y : box.Max.Y;
        vector2.Z = (this.Normal.Z >= 0f) ? box.Min.Z : box.Max.Z;
        vector.X = (this.Normal.X >= 0f) ? box.Max.X : box.Min.X;
        vector.Y = (this.Normal.Y >= 0f) ? box.Max.Y : box.Min.Y;
        vector.Z = (this.Normal.Z >= 0f) ? box.Max.Z : box.Min.Z;
        float num = ((this.Normal.X * vector2.X) + (this.Normal.Y * vector2.Y)) + (this.Normal.Z * vector2.Z);
        if ((num + this.D) > 0f)
        {
            result = PlaneIntersectionType.Front;
        }
        else
        {
            num = ((this.Normal.X * vector.X) + (this.Normal.Y * vector.Y)) + (this.Normal.Z * vector.Z);
            if ((num + this.D) < 0f)
            {
                result = PlaneIntersectionType.Back;
            }
            else
            {
                result = PlaneIntersectionType.Intersecting;
            }
        }
    }
    
    /**
     * Checks whether the current Plane intersects a BoundingSphere.
     * 
     * @param sphere
     * The BoundingSphere to check for intersection with.
     * 
     * @param result
     * [OutAttribute] An enumeration indicating whether the Plane intersects the BoundingSphere.
     */
    public void Intersects(BoundingSphere sphere, PlaneIntersectionType result)
    {
        float num2 = ((sphere.Center.X * this.Normal.X) + (sphere.Center.Y * this.Normal.Y)) + (sphere.Center.Z * this.Normal.Z);
        float num = num2 + this.D;
        if (num > sphere.Radius)
        {
            result = PlaneIntersectionType.Front;
        }
        else if (num < -sphere.Radius)
        {
            result = PlaneIntersectionType.Back;
        }
        else
        {
            result = PlaneIntersectionType.Intersecting;
        }
    }
    
    /**
     * Changes the coefficients of the Normal vector of this Plane to make it of unit length.
     */
    public void Normalize()
    {
        float num2 = ((this.Normal.X * this.Normal.X) + (this.Normal.Y * this.Normal.Y)) + (this.Normal.Z * this.Normal.Z);
        if (Math.abs((float) (num2 - 1f)) >= 1.192093E-07f)
        {
            float num = 1f / ((float) Math.sqrt((double) num2));
            this.Normal.X *= num;
            this.Normal.Y *= num;
            this.Normal.Z *= num;
            this.D *= num;
        }
    }
    
    /**
     * Changes the coefficients of the Normal vector of a Plane to make it of unit length.
     * 
     * @param value
     * The Plane to normalize.
     */
    public static Plane Normalize(Plane value)
    {
        Plane plane = new Plane();
        float num2 = ((value.Normal.X * value.Normal.X) + (value.Normal.Y * value.Normal.Y)) + (value.Normal.Z * value.Normal.Z);
        if (Math.abs((float) (num2 - 1f)) < 1.192093E-07f)
        {
            plane.Normal = value.Normal;
            plane.D = value.D;
            return plane;
        }
        float num = 1f / ((float) Math.sqrt((double) num2));
        plane.Normal.X = value.Normal.X * num;
        plane.Normal.Y = value.Normal.Y * num;
        plane.Normal.Z = value.Normal.Z * num;
        plane.D = value.D * num;
        return plane;
    }
    
    /**
     * Changes the coefficients of the Normal vector of a Plane to make it of unit length.
     * 
     * @param value
     * The Plane to normalize.
     * 
     * @param result
     * [OutAttribute] An existing plane Plane filled in with a normalized version of the specified plane.
     */
    public static void Normalize(Plane value, Plane result)
    {
        float num2 = ((value.Normal.X * value.Normal.X) + (value.Normal.Y * value.Normal.Y)) + (value.Normal.Z * value.Normal.Z);
        if (Math.abs((float) (num2 - 1f)) < 1.192093E-07f)
        {
            result.Normal = value.Normal;
            result.D = value.D;
        }
        else
        {
            float num = 1f / ((float) Math.sqrt((double) num2));
            result.Normal.X = value.Normal.X * num;
            result.Normal.Y = value.Normal.Y * num;
            result.Normal.Z = value.Normal.Z * num;
            result.D = value.D * num;
        }
    }
    
    /**
     * Returns a String that represents the current Plane.
     */
    @Override
    public String toString()
    {
        return String.format(Locale.getDefault(), "{Normal:%s D:%f}", this.Normal, this.D);
    }
    
    /**
     * Transforms a normalized Plane by a Matrix.
     * 
     * @param plane
     * The normalized Plane to transform. This Plane must already be normalized, so that its Normal vector is of unit length, before this method is called.
     * 
     * @param matrix
     * The transform Matrix to apply to the Plane.
     */
    public static Plane Transform(Plane plane, Matrix matrix)
    {
        Plane result = new Plane();
        Transform(plane, matrix, result);
        return result;
    }
    
    /**
     * Transforms a normalized Plane by a Quaternion rotation.
     * 
     * @param plane
     * The normalized Plane to transform. This Plane must already be normalized, so that its Normal vector is of unit length, before this method is called.
     * 
     * @param rotation
     * The Quaternion rotation to apply to the Plane.
     */
    public static Plane Transform(Plane plane, Quaternion rotation)
    {
    	Plane result = new Plane();
    	Transform(plane, rotation, result);
    	return result;
    }
    
    /**
     * Transforms a normalized Plane by a Matrix.
     * 
     * @param plane
     * The normalized Plane to transform. This Plane must already be normalized, so that its Normal vector is of unit length, before this method is called.
     * 
     * @param matrix
     * The transform Matrix to apply to the Plane.
     * 
     * @param result
     * [OutAttribute] An existing Plane filled in with the results of applying the transform.
     */
    public static void Transform(Plane plane, Matrix matrix, Plane result)
    {
        Matrix matrix2 = new Matrix();
        Matrix.Invert(matrix, matrix2);
        float x = plane.Normal.X;
        float y = plane.Normal.Y;
        float z = plane.Normal.Z;
        float d = plane.D;
        result.Normal.X = (((x * matrix2.M11) + (y * matrix2.M12)) + (z * matrix2.M13)) + (d * matrix2.M14);
        result.Normal.Y = (((x * matrix2.M21) + (y * matrix2.M22)) + (z * matrix2.M23)) + (d * matrix2.M24);
        result.Normal.Z = (((x * matrix2.M31) + (y * matrix2.M32)) + (z * matrix2.M33)) + (d * matrix2.M34);
        result.D = (((x * matrix2.M41) + (y * matrix2.M42)) + (z * matrix2.M43)) + (d * matrix2.M44);
    }
    
    /**
     * Transforms a normalized Plane by a Quaternion rotation.
     * 
     * @param plane
     * The normalized Plane to transform. This Plane must already be normalized, so that its Normal vector is of unit length, before this method is called.
     * 
     * @param rotation
     * The Quaternion rotation to apply to the Plane.
     * 
     * @param result
     * [OutAttribute] An existing Plane filled in with the results of applying the rotation.
     */
    public static void Transform(Plane plane, Quaternion rotation, Plane result)
    {
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
        float x = plane.Normal.X;
        float y = plane.Normal.Y;
        float z = plane.Normal.Z;
        result.Normal.X = ((x * num24) + (y * num23)) + (z * num22);
        result.Normal.Y = ((x * num21) + (y * num20)) + (z * num19);
        result.Normal.Z = ((x * num18) + (y * num17)) + (z * num16);
        result.D = plane.D;
    }
}
