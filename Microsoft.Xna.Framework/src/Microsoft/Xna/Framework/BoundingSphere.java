package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a sphere.
 * 
 * @author Halofreak1990
 */
public final class BoundingSphere extends ValueType implements IEquatable<BoundingSphere>
{
	/**
	 * The center point of the sphere.
	 */
	public Vector3 Center;
	
	/**
	 * The radius of the sphere.
	 */
	public float Radius;
	
	/**
	 * Creates a new instance of BoundingSphere.
	 * 
	 * @param center
	 * Center point of the sphere.
	 * 
	 * @param radius
	 * Radius of the sphere.
	 */
	public BoundingSphere(Vector3 center, float radius)
	{
		if (radius < 0f)
			throw new ArgumentOutOfRangeException("radius", "Radius must be greater than 0.");
		
		Center = center;
		Radius = radius;
	}
	
	/**
	 * Creates a new instance of BoundingSphere.
	 */
	public BoundingSphere()
	{
		Center = Vector3.Zero;
		Radius = 0;
	}

	/**
	 * Checks whether the current BoundingSphere contains the specified BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to check against the current BoundingSphere.
	 * 
	 * @return
	 * An enumeration indicating the relationship of the specified BoundingBox to the current BoundingSphere.
	 */
	public ContainmentType Contains(BoundingBox box)
	{
	    Vector3 vector = Vector3.Zero;
	    if (!box.Intersects(this))
	    {
	        return ContainmentType.Disjoint;
	    }
	    float num = this.Radius * this.Radius;
	    vector.X = this.Center.X - box.Min.X;
	    vector.Y = this.Center.Y - box.Max.Y;
	    vector.Z = this.Center.Z - box.Max.Z;
	    if (vector.LengthSquared() > num)
	    {
	        return ContainmentType.Intersects;
	    }
	    vector.X = this.Center.X - box.Max.X;
	    vector.Y = this.Center.Y - box.Max.Y;
	    vector.Z = this.Center.Z - box.Max.Z;
	    if (vector.LengthSquared() > num)
	    {
	        return ContainmentType.Intersects;
	    }
	    vector.X = this.Center.X - box.Max.X;
	    vector.Y = this.Center.Y - box.Min.Y;
	    vector.Z = this.Center.Z - box.Max.Z;
	    if (vector.LengthSquared() > num)
	    {
	        return ContainmentType.Intersects;
	    }
	    vector.X = this.Center.X - box.Min.X;
	    vector.Y = this.Center.Y - box.Min.Y;
	    vector.Z = this.Center.Z - box.Max.Z;
	    if (vector.LengthSquared() > num)
	    {
	        return ContainmentType.Intersects;
	    }
	    vector.X = this.Center.X - box.Min.X;
	    vector.Y = this.Center.Y - box.Max.Y;
	    vector.Z = this.Center.Z - box.Min.Z;
	    if (vector.LengthSquared() > num)
	    {
	        return ContainmentType.Intersects;
	    }
	    vector.X = this.Center.X - box.Max.X;
	    vector.Y = this.Center.Y - box.Max.Y;
	    vector.Z = this.Center.Z - box.Min.Z;
	    if (vector.LengthSquared() > num)
	    {
	        return ContainmentType.Intersects;
	    }
	    vector.X = this.Center.X - box.Max.X;
	    vector.Y = this.Center.Y - box.Min.Y;
	    vector.Z = this.Center.Z - box.Min.Z;
	    if (vector.LengthSquared() > num)
	    {
	        return ContainmentType.Intersects;
	    }
	    vector.X = this.Center.X - box.Min.X;
	    vector.Y = this.Center.Y - box.Min.Y;
	    vector.Z = this.Center.Z - box.Min.Z;
	    if (vector.LengthSquared() > num)
	    {
	        return ContainmentType.Intersects;
	    }
	    return ContainmentType.Contains;
	}
	
	/**
	 * Checks whether the current BoundingSphere contains the specified BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to check against the current BoundingSphere.
	 * 
	 * @return
	 * An enumeration indicating the relationship of the BoundingSpheres.
	 */
	public ContainmentType Contains(BoundingSphere sphere)
	{
	    float num3 = 0;
	    Vector3.Distance(this.Center, sphere.Center, num3);
	    float radius = this.Radius;
	    float num = sphere.Radius;
	    if ((radius + num) < num3)
	    {
	        return ContainmentType.Disjoint;
	    }
	    if ((radius - num) < num3)
	    {
	        return ContainmentType.Intersects;
	    }
	    return ContainmentType.Contains;
	}
	
	/**
	 * Checks whether the current BoundingSphere contains the specified point.
	 * 
	 * @param point
	 * The point to check against the current BoundingSphere.
	 * 
	 * @return
	 * An enumeration indicating the relationship of the specified point to the current BoundingSphere.
	 */
	public ContainmentType Contains(Vector3 point)
	{
	    if (Vector3.DistanceSquared(point, this.Center) >= (this.Radius * this.Radius))
	    {
	        return ContainmentType.Disjoint;
	    }
	    return ContainmentType.Contains;
	}
	
	/**
	 * Checks whether the current BoundingSphere contains the specified BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to test for overlap.
	 * 
	 * @param result
	 * [OutAttribute] Enumeration indicating the extent of overlap.
	 */
	public void Contains(BoundingBox box, ContainmentType result)
	{
	    boolean flag = false;
	    box.Intersects(this, flag);
	    if (!flag)
	    {
	        result = ContainmentType.Disjoint;
	    }
	    else
	    {
	        Vector3 vector = Vector3.Zero;
	        float num = this.Radius * this.Radius;
	        result = ContainmentType.Intersects;
	        vector.X = this.Center.X - box.Min.X;
	        vector.Y = this.Center.Y - box.Max.Y;
	        vector.Z = this.Center.Z - box.Max.Z;
	        if (vector.LengthSquared() <= num)
	        {
	            vector.X = this.Center.X - box.Max.X;
	            vector.Y = this.Center.Y - box.Max.Y;
	            vector.Z = this.Center.Z - box.Max.Z;
	            if (vector.LengthSquared() <= num)
	            {
	                vector.X = this.Center.X - box.Max.X;
	                vector.Y = this.Center.Y - box.Min.Y;
	                vector.Z = this.Center.Z - box.Max.Z;
	                if (vector.LengthSquared() <= num)
	                {
	                    vector.X = this.Center.X - box.Min.X;
	                    vector.Y = this.Center.Y - box.Min.Y;
	                    vector.Z = this.Center.Z - box.Max.Z;
	                    if (vector.LengthSquared() <= num)
	                    {
	                        vector.X = this.Center.X - box.Min.X;
	                        vector.Y = this.Center.Y - box.Max.Y;
	                        vector.Z = this.Center.Z - box.Min.Z;
	                        if (vector.LengthSquared() <= num)
	                        {
	                            vector.X = this.Center.X - box.Max.X;
	                            vector.Y = this.Center.Y - box.Max.Y;
	                            vector.Z = this.Center.Z - box.Min.Z;
	                            if (vector.LengthSquared() <= num)
	                            {
	                                vector.X = this.Center.X - box.Max.X;
	                                vector.Y = this.Center.Y - box.Min.Y;
	                                vector.Z = this.Center.Z - box.Min.Z;
	                                if (vector.LengthSquared() <= num)
	                                {
	                                    vector.X = this.Center.X - box.Min.X;
	                                    vector.Y = this.Center.Y - box.Min.Y;
	                                    vector.Z = this.Center.Z - box.Min.Z;
	                                    if (vector.LengthSquared() <= num)
	                                    {
	                                        result = ContainmentType.Contains;
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }
	}
	
	/**
	 * Checks whether the current BoundingSphere contains the specified BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to test for overlap.
	 * 
	 * @param result
	 * [OutAttribute] Enumeration indicating the extent of overlap.
	 */
	public void Contains(BoundingSphere sphere, ContainmentType result)
	{
	    float num3 = 0;
	    Vector3.Distance(this.Center, sphere.Center, num3);
	    float radius = this.Radius;
	    float num = sphere.Radius;
	    result = ((radius + num) >= num3) ? (((radius - num) >= num3) ? ContainmentType.Contains : ContainmentType.Intersects) : ContainmentType.Disjoint;
	}
	
	/**
	 * Checks whether the current BoundingSphere contains the specified point.
	 * 
	 * @param point
	 * The point to test for overlap.
	 * 
	 * @param result
	 * [OutAttribute] Enumeration indicating the extent of overlap.
	 */
	public void Contains(Vector3 point, ContainmentType result)
	{
	    float num = 0;
	    Vector3.DistanceSquared(point, this.Center, num);
	    result = (num < (this.Radius * this.Radius)) ? ContainmentType.Contains : ContainmentType.Disjoint;
	}
	
	/**
	 * Creates the smallest BoundingSphere that can contain a specified BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to create the BoundingSphere from.
	 * 
	 * @return
	 * The created BoundingSphere.
	 */
	public static BoundingSphere CreateFromBoundingBox(BoundingBox box)
	{
	    float num = 0;
	    BoundingSphere sphere = new BoundingSphere();
	    Vector3.Lerp(box.Min, box.Max, 0.5f, sphere.Center);
	    Vector3.Distance(box.Min, box.Max, num);
	    sphere.Radius = num * 0.5f;
	    return sphere;
	}
	
	/**
	 * Creates the smallest BoundingSphere that can contain a specified BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to create the BoundingSphere from.
	 * 
	 * @param result
	 * [OutAttribute] The created BoundingSphere.
	 */
	public static void CreateFromBoundingBox(BoundingBox box, BoundingSphere result)
	{
	    float num = 0;
	    Vector3.Lerp(box.Min, box.Max, 0.5f, result.Center);
	    Vector3.Distance(box.Min, box.Max, num);
	    result.Radius = num * 0.5f;
	}
	
	/**
	 * Creates a BoundingSphere that contains the two specified BoundingSphere instances.
	 * 
	 * @param original
	 * BoundingSphere to be merged.
	 * 
	 * @param additional
	 * BoundingSphere to be merged.
	 * 
	 * @return
	 * The created BoundingSphere.
	 */
	public static BoundingSphere CreateMerged(BoundingSphere original, BoundingSphere additional)
	{
	    BoundingSphere sphere = new BoundingSphere();
	    Vector3 vector2 = Vector3.Zero;
	    Vector3.Subtract(additional.Center, original.Center, vector2);
	    float num = vector2.Length();
	    float radius = original.Radius;
	    float num2 = additional.Radius;
	    if ((radius + num2) >= num)
	    {
	        if ((radius - num2) >= num)
	        {
	            return original;
	        }
	        if ((num2 - radius) >= num)
	        {
	            return additional;
	        }
	    }
	    Vector3 vector = Vector3.Multiply(vector2, 1f / num);
	    float num5 = MathHelper.Min(-radius, num - num2);
	    float num4 = (MathHelper.Max(radius, num + num2) - num5) * 0.5f;
	    sphere.Center = Vector3.Add(original.Center, Vector3.Multiply(vector, num4 + num5));
	    sphere.Radius = num4;
	    return sphere;
	}
	
	/**
	 * Creates a BoundingSphere that contains the two specified BoundingSphere instances.
	 * 
	 * @param original
	 * BoundingSphere to be merged.
	 * 
	 * @param additional
	 * BoundingSphere to be merged.
	 * 
	 * @param result
	 * [OutAttribute] The created BoundingSphere.
	 */
	public static void CreateMerged(BoundingSphere original, BoundingSphere additional, BoundingSphere result)
	{
	    Vector3 vector2 = Vector3.Zero;
	    Vector3.Subtract(additional.Center, original.Center, vector2);
	    float num = vector2.Length();
	    float radius = original.Radius;
	    float num2 = additional.Radius;
	    if ((radius + num2) >= num)
	    {
	        if ((radius - num2) >= num)
	        {
	            result = original;
	            return;
	        }
	        if ((num2 - radius) >= num)
	        {
	            result = additional;
	            return;
	        }
	    }
	    Vector3 vector = Vector3.Multiply(vector2, 1f / num);
	    float num5 = MathHelper.Min(-radius, num - num2);
	    float num4 = (MathHelper.Max(radius, num + num2) - num5) * 0.5f;
	    result.Center = Vector3.Add(original.Center, Vector3.Multiply(vector, num4 + num5));
	    result.Radius = num4;
	}
	
	/**
	 * Determines whether the specified Object is equal to the BoundingSphere.
	 * 
	 * @param obj
	 * The Object to compare with the current BoundingSphere.
	 * 
	 * @return
	 * true if the specified System.Object is equal to the current BoundingSphere; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof BoundingSphere) ? this.Equals((BoundingSphere)obj) : false;
	}
	
	/**
	 * Determines whether the specified BoundingSphere is equal to the current BoundingSphere.
	 * 
	 * @param other
	 * The BoundingSphere to compare with the current BoundingSphere.
	 * 
	 * @return
	 * true if the specified BoundingSphere is equal to the current BoundingSphere; false otherwise.
	 */
	public boolean Equals(BoundingSphere other)
	{
		return (this.Center.Equals(other.Center) && this.Radius == other.Radius);
	}
	
	/**
	 * Gets the hash code for this instance.
	 * 
	 * @return
	 * A hash code for the current BoundingSphere.
	 */
	@Override
	public int hashCode()
	{
		return (this.Center.hashCode() ^ (int)Radius);
	}
	
	/**
	 * Checks whether the current BoundingSphere intersects with a specified BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to check for intersection with the current BoundingSphere.
	 * 
	 * @return
	 * true if the BoundingBox and BoundingSphere intersect; false otherwise.
	 */
	public boolean Intersects(BoundingBox box)
	{
	    float num = 0;
	    Vector3 vector = Vector3.Zero;
	    Vector3.Clamp(this.Center, box.Min, box.Max, vector);
	    Vector3.DistanceSquared(this.Center, vector, num);
	    return (num <= (this.Radius * this.Radius));
	}
	
	/**
	 * Checks whether the current BoundingSphere intersects with a specified BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to check for intersection with the current BoundingSphere.
	 * 
	 * @return
	 * true if the BoundingSpheres intersect; false otherwise.
	 */
	public boolean Intersects(BoundingSphere sphere)
	{
	    float num3 = 0;
	    Vector3.DistanceSquared(this.Center, sphere.Center, num3);
	    float radius = this.Radius;
	    float num = sphere.Radius;
	    if ((((radius * radius) + ((2f * radius) * num)) + (num * num)) <= num3)
	    {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Checks whether the current BoundingSphere intersects with a specified Plane.
	 * 
	 * @param plane
	 * The Plane to check for intersection with the current BoundingSphere.
	 * 
	 * @return
	 * An enumeration indicating the relationship between the BoundingSphere and the Plane.
	 */
	public PlaneIntersectionType Intersects(Plane plane)
	{
	    return plane.Intersects(this);
	}
	
	/**
	 * Checks whether the current BoundingSphere intersects with a specified Ray.
	 * 
	 * @param ray
	 * The Ray to check for intersection with the current BoundingSphere.
	 * 
	 * @region
	 * Distance at which the ray intersects the BoundingSphere or null if there is no intersection.
	 */
	public Float Intersects(Ray ray)
	{
	    return ray.Intersects(this);
	}
	
	/**
	 * Checks whether the current BoundingSphere intersects a BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to check for intersection with.
	 * 
	 * @param result
	 * [OutAttribute] true if the BoundingSphere and BoundingBox intersect; false otherwise.
	 */
	public void Intersects(BoundingBox box, boolean result)
	{
	    float num = 0;
	    Vector3 vector = Vector3.Zero;
	    Vector3.Clamp(this.Center, box.Min, box.Max, vector);
	    Vector3.DistanceSquared(this.Center, vector, num);
	    result = num <= (this.Radius * this.Radius);
	}
	
	/**
	 * Checks whether the current BoundingSphere intersects another BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to check for intersection with.
	 * 
	 * @param result
	 * [OutAttribute] true if the BoundingSphere instances intersect; false otherwise.
	 */
	public void Intersects(BoundingSphere sphere, boolean result)
	{
	    float num3 = 0;
	    Vector3.DistanceSquared(this.Center, sphere.Center, num3);
	    float radius = this.Radius;
	    float num = sphere.Radius;
	    result = (((radius * radius) + ((2f * radius) * num)) + (num * num)) > num3;
	}
	
	/**
	 * Checks whether the current BoundingSphere intersects a Plane.
	 * 
	 * @param plane
	 * The Plane to check for intersection with.
	 * 
	 * @param result
	 * [OutAttribute] An enumeration indicating whether the BoundingSphere intersects the Plane.
	 */
	public void Intersects(Plane plane, PlaneIntersectionType result)
	{
	    plane.Intersects(this, result);
	}
	
	/**
	 * Checks whether the current BoundingSphere intersects a Ray.
	 * 
	 * @param ray
	 * The Ray to check for intersection with.
	 * 
	 * @param result
	 * [OutAttribute] Distance at which the ray intersects the BoundingSphere or null if there is no intersection.
	 */
	public void Intersects(Ray ray, Float result)
	{
	    ray.Intersects(this, result);
	}
	
	/**
	 * Returns a String that represents the current BoundingSphere.
	 * 
	 * @return
	 * String representation of the current BoundingSphere.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{Center:%s Radius:%f}", this.Center, Radius);
	}
	
	/**
	 * Translates and scales the BoundingSphere using a given Matrix.
	 * 
	 * @param matrix
	 * A transformation matrix that might include translation, rotation, or uniform scaling. Note that BoundingSphere.Transform will not return correct results if there
	 * are non-uniform scaling, shears, or other unusual transforms in this transformation matrix. This is because there is no way to shear or non-uniformly scale a
	 * sphere. Such an operation would cause the sphere to lose its shape as a sphere.
	 */
	public BoundingSphere Transform(Matrix matrix)
	{
	    BoundingSphere sphere = new BoundingSphere();
	    sphere.Center = Vector3.Transform(this.Center, matrix);
	    float num4 = ((matrix.M11 * matrix.M11) + (matrix.M12 * matrix.M12)) + (matrix.M13 * matrix.M13);
	    float num3 = ((matrix.M21 * matrix.M21) + (matrix.M22 * matrix.M22)) + (matrix.M23 * matrix.M23);
	    float num2 = ((matrix.M31 * matrix.M31) + (matrix.M32 * matrix.M32)) + (matrix.M33 * matrix.M33);
	    float num = Math.max(num4, Math.max(num3, num2));
	    sphere.Radius = this.Radius * ((float) Math.sqrt((double) num));
	    return sphere;
	}
	
	/**
	 * Translates and scales the BoundingSphere using a given Matrix.
	 * 
	 * @param matrix
	 * A transformation matrix that might include translation, rotation, or uniform scaling. Note that BoundingSphere.Transform will not return correct results if there
	 * are non-uniform scaling, shears, or other unusual transforms in this transformation matrix. This is because there is no way to shear or non-uniformly scale a
	 * sphere. Such an operation would cause the sphere to lose its shape as a sphere.
	 * 
	 * @param result
	 * [OutAttribute] The transformed BoundingSphere.
	 */
	public void Transform(Matrix matrix, BoundingSphere result)
	{
	    result.Center = Vector3.Transform(this.Center, matrix);
	    float num4 = ((matrix.M11 * matrix.M11) + (matrix.M12 * matrix.M12)) + (matrix.M13 * matrix.M13);
	    float num3 = ((matrix.M21 * matrix.M21) + (matrix.M22 * matrix.M22)) + (matrix.M23 * matrix.M23);
	    float num2 = ((matrix.M31 * matrix.M31) + (matrix.M32 * matrix.M32)) + (matrix.M33 * matrix.M33);
	    float num = Math.max(num4, Math.max(num3, num2));
	    result.Radius = this.Radius * ((float) Math.sqrt((double) num));
	}
}
