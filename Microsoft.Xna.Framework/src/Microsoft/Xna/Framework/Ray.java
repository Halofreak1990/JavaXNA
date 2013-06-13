package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a ray.
 * 
 * @author Halofreak1990
 */
public final class Ray extends ValueType implements IEquatable<Ray>
{
	/**
	 * Specifies the starting point of the Ray.
	 */
	public Vector3 Position;
	/**
	 * Unit vector specifying the direction the Ray is pointing.
	 */
	public Vector3 Direction;
	
	/**
	 * Creates a new instance of Ray.
	 * 
	 * @param position
	 * The starting point of the Ray.
	 * 
	 * @param direction
	 * Unit vector describing the direction of the Ray.
	 */
	public Ray(Vector3 position, Vector3 direction)
	{
	    this.Position = position;
	    this.Direction = direction;
	}
	
	/**
	 * Creates a new instance of Ray.
	 */
	public Ray()
	{
		this.Position = Vector3.Zero;
		this.Direction = Vector3.Zero;
	}
	
	/**
	 * Determines whether two instances of Ray are equal.
	 * 
	 * @param obj
	 * The Object to compare with the current Ray.
	 * 
	 * @return
	 * true if the specified System.Object is equal to the current Ray; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Ray) ? this.Equals((Ray)obj) : false;
	}
	
	/**
	 * Determines whether the specified Ray is equal to the current Ray.
	 * 
	 * @param other
	 * The Ray to compare with the current Ray.
	 * 
	 * @return
	 * true if the specified Ray is equal to the current Ray; false otherwise.
	 */
	public boolean Equals(Ray other)
	{
		return (this.Position.Equals(other.Position) && this.Direction.Equals(other.Direction));
	}
	
	/**
	 * Gets the hash code for this instance.
	 * 
	 * @return
	 * A hash code for the current Ray.
	 */
	@Override
	public int hashCode()
	{
	    return (this.Position.hashCode() + this.Direction.hashCode());
	}
	
	/**
	 * Checks whether the Ray intersects a specified BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to check for intersection with the Ray.
	 * 
	 * @return
	 * Distance at which the ray intersects the BoundingBox or null if there is no intersection.
	 */
	public Float Intersects(BoundingBox box)
	{
	    return box.Intersects(this);
	}
	
	/**
	 * Checks whether the Ray intersects a specified BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to check for intersection with the Ray.
	 * 
	 * @return
	 * Distance at which the ray intersects the BoundingSphere or null if there is no intersection.
	 */
	public Float Intersects(BoundingSphere sphere)
	{
	    float num5 = sphere.Center.X - this.Position.X;
	    float num4 = sphere.Center.Y - this.Position.Y;
	    float num3 = sphere.Center.Z - this.Position.Z;
	    float num7 = ((num5 * num5) + (num4 * num4)) + (num3 * num3);
	    float num2 = sphere.Radius * sphere.Radius;
	    if (num7 <= num2)
	    {
	        return 0f;
	    }
	    float num = ((num5 * this.Direction.X) + (num4 * this.Direction.Y)) + (num3 * this.Direction.Z);
	    if (num < 0f)
	    {
	        return null;
	    }
	    float num6 = num7 - (num * num);
	    if (num6 > num2)
	    {
	        return null;
	    }
	    float num8 = (float) Math.sqrt((double) (num2 - num6));
	    return new Float(num - num8);
	}
	
	/**
	 * Determines whether this Ray intersects a specified Plane.
	 * 
	 * @param plane
	 * The Plane with which to calculate this Ray's intersection.
	 * 
	 * @return
	 * The distance at which this Ray intersects the specified Plane, or null if there is no intersection.
	 */
	public Float Intersects(Plane plane)
	{
	    float num2 = ((plane.Normal.X * this.Direction.X) + (plane.Normal.Y * this.Direction.Y)) + (plane.Normal.Z * this.Direction.Z);
	    if (Math.abs(num2) < 1E-05f)
	    {
	        return null;
	    }
	    float num3 = ((plane.Normal.X * this.Position.X) + (plane.Normal.Y * this.Position.Y)) + (plane.Normal.Z * this.Position.Z);
	    float num = (-plane.D - num3) / num2;
	    if (num < 0f)
	    {
	        if (num < -1E-05f)
	        {
	            return null;
	        }
	        num = 0f;
	    }
	    return new Float(num);
	}
	
	/**
	 * Checks whether the current Ray intersects a BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to check for intersection with.
	 * 
	 * @param result
	 * [OutAttribute] Distance at which the ray intersects the BoundingBox or null if there is no intersection.
	 */
	public void Intersects(BoundingBox box, Float result)
	{
	    box.Intersects(this, result);
	}
	
	/**
	 * Checks whether the current Ray intersects a BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to check for intersection with.
	 * 
	 * @param result
	 * [OutAttribute] Distance at which the ray intersects the BoundingSphere or null if there is no intersection.
	 */
	public void Intersects(BoundingSphere sphere, Float result)
	{
	    float num5 = sphere.Center.X - this.Position.X;
	    float num4 = sphere.Center.Y - this.Position.Y;
	    float num3 = sphere.Center.Z - this.Position.Z;
	    float num7 = ((num5 * num5) + (num4 * num4)) + (num3 * num3);
	    float num2 = sphere.Radius * sphere.Radius;
	    if (num7 <= num2)
	    {
	        result = 0f;
	    }
	    else
	    {
	        result = 0f;
	        float num = ((num5 * this.Direction.X) + (num4 * this.Direction.Y)) + (num3 * this.Direction.Z);
	        if (num >= 0f)
	        {
	            float num6 = num7 - (num * num);
	            if (num6 <= num2)
	            {
	                float num8 = (float) Math.sqrt((double) (num2 - num6));
	                result = new Float(num - num8);
	            }
	        }
	    }
	}
	
	/**
	 * Determines whether this Ray intersects a specified Plane.
	 * 
	 * @param plane
	 * The Plane with which to calculate this Ray's intersection.
	 * 
	 * @param result
	 * [OutAttribute] The distance at which this Ray intersects the specified Plane, or null if there is no intersection.
	 */
	public void Intersects(Plane plane, Float result)
	{
	    float num2 = ((plane.Normal.X * this.Direction.X) + (plane.Normal.Y * this.Direction.Y)) + (plane.Normal.Z * this.Direction.Z);
	    if (Math.abs(num2) < 1E-05f)
	    {
	        result = 0f;
	    }
	    else
	    {
	        float num3 = ((plane.Normal.X * this.Position.X) + (plane.Normal.Y * this.Position.Y)) + (plane.Normal.Z * this.Position.Z);
	        float num = (-plane.D - num3) / num2;
	        if (num < 0f)
	        {
	            if (num < -1E-05f)
	            {
	                result = 0f;
	                return;
	            }
	            result = 0f;
	        }
	        result = new Float(num);
	    }
	}
	
	/**
	 * Returns a String that represents the current Ray.
	 * 
	 * @return
	 * String representation of the current Ray.
	 */
	@Override
	public String toString()
	{
	    return String.format(Locale.getDefault(), "{Position:%s Direction:%s}", this.Position, this.Direction);
	}
}
