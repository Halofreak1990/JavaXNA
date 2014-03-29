package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines an axis-aligned box-shaped 3D volume.
 * 
 * @author Halofreak1990
 */
public final class BoundingBox extends ValueType implements IEquatable<BoundingBox>
{
	/**
	 * Specifies the total number of corners (8) in the BoundingBox.
	 */
	public final int CornerCount = 8;

	/**
	 * The maximum point the BoundingBox contains.
	 */
	public Vector3 Max;

	/**
	 * The minimum point the BoundingBox contains.
	 */
	public Vector3 Min;

	/**
	 * Creates an instance of BoundingBox.
	 * @param min
	 * The minimum point the BoundingBox includes.
	 * @param max
	 * The maximum point the BoundingBox includes.
	 */
	public BoundingBox(Vector3 min, Vector3 max)
	{
		Min = min;
		Max = max;
	}

	/**
	 * Creates an instance of BoundingBox.
	 */
	public BoundingBox()
	{
		Min = Vector3.Zero;
		Max = Vector3.Zero;
	}

	/**
	 * Tests whether the BoundingBox contains another BoundingBox.
	 * @param box
	 * The BoundingBox to test for overlap.
	 */
	public ContainmentType Contains(BoundingBox box)
	{
		if ((this.Max.X < box.Min.X) || (this.Min.X > box.Max.X))
		{
			return ContainmentType.Disjoint;
		}

		if ((this.Max.Y < box.Min.Y) || (this.Min.Y > box.Max.Y))
		{
			return ContainmentType.Disjoint;
		}

		if ((this.Max.Z < box.Min.Z) || (this.Min.Z > box.Max.Z))
		{
			return ContainmentType.Disjoint;
		}

		if ((((this.Min.X <= box.Min.X) && (box.Max.X <= this.Max.X)) && ((this.Min.Y <= box.Min.Y) && (box.Max.Y <= this.Max.Y))) && ((this.Min.Z <= box.Min.Z) && (box.Max.Z <= this.Max.Z)))
		{
			return ContainmentType.Contains;
		}

		return ContainmentType.Intersects;
	}

	/**
	 * Tests whether the BoundingBox contains a BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to test for overlap.
	 */
	public ContainmentType Contains(BoundingSphere sphere)
	{
		Vector3 vector = Vector3.Zero;
		Vector3.Clamp(sphere.Center, this.Min, this.Max, vector);
		float num2 = Vector3.DistanceSquared(sphere.Center, vector);
		float radius = sphere.Radius;

		if (num2 > (radius * radius))
		{
			return ContainmentType.Disjoint;
		}

		if (((((this.Min.X + radius) <= sphere.Center.X) && (sphere.Center.X <= (this.Max.X - radius))) && (((this.Max.X - this.Min.X) > radius) && ((this.Min.Y + radius) <= sphere.Center.Y))) && (((sphere.Center.Y <= (this.Max.Y - radius)) && ((this.Max.Y - this.Min.Y) > radius)) && ((((this.Min.Z + radius) <= sphere.Center.Z) && (sphere.Center.Z <= (this.Max.Z - radius))) && ((this.Max.X - this.Min.X) > radius))))
		{
			return ContainmentType.Contains;
		}

		return ContainmentType.Intersects;
	}

	/**
	 * Tests whether the BoundingBox contains a point.
	 * 
	 * @param point
	 * The point to test for overlap.
	 */
	public ContainmentType Contains(Vector3 point)
	{
		if ((((this.Min.X <= point.X) && (point.X <= this.Max.X)) && ((this.Min.Y <= point.Y) && (point.Y <= this.Max.Y))) && ((this.Min.Z <= point.Z) && (point.Z <= this.Max.Z)))
		{
			return ContainmentType.Contains;
		}

		return ContainmentType.Disjoint;
	}

	/**
	 * Creates the smallest BoundingBox that will contain the specified BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to contain.
	 */
	public static BoundingBox CreateFromSphere(BoundingSphere sphere)
	{
		BoundingBox box = new BoundingBox();
		box.Min.X = sphere.Center.X - sphere.Radius;
		box.Min.Y = sphere.Center.Y - sphere.Radius;
		box.Min.Z = sphere.Center.Z - sphere.Radius;
		box.Max.X = sphere.Center.X + sphere.Radius;
		box.Max.Y = sphere.Center.Y + sphere.Radius;
		box.Max.Z = sphere.Center.Z + sphere.Radius;
		return box;
	}

	/**
	 * Creates the smallest BoundingBox that will contain the specified BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to contain.
	 * 
	 * @param result
	 * [OutAttribute] The created BoundingBox.
	 */
	public static void CreateFromSphere(BoundingSphere sphere, BoundingBox result)
	{
		result.Min.X = sphere.Center.X - sphere.Radius;
		result.Min.Y = sphere.Center.Y - sphere.Radius;
		result.Min.Z = sphere.Center.Z - sphere.Radius;
		result.Max.X = sphere.Center.X + sphere.Radius;
		result.Max.Y = sphere.Center.Y + sphere.Radius;
		result.Max.Z = sphere.Center.Z + sphere.Radius;
	}

	/**
	 * Creates the smallest BoundingBox that contains the two specified BoundingBox instances.
	 * 
	 * @param original
	 * One of the BoundingBoxs to contain.
	 * 
	 * @param additional
	 * One of the BoundingBoxs to contain.
	 */
	public static BoundingBox CreateMerged(BoundingBox original, BoundingBox additional)
	{
		BoundingBox box = new BoundingBox();
		Vector3.Min(original.Min, additional.Min, box.Min);
		Vector3.Max(original.Max, additional.Max, box.Max);
		return box;
	}

	/**
	 * Creates the smallest BoundingBox that contains the two specified BoundingBox instances.
	 * 
	 * @param original
	 * One of the BoundingBoxs to contain.
	 * 
	 * @param additional
	 * One of the BoundingBoxs to contain.
	 * 
	 * @param result
	 * [OutAttribute] The created BoundingBox.
	 */
	public static void CreateMerged(BoundingBox original, BoundingBox additional, BoundingBox result)
	{
		Vector3 vector = Vector3.Zero;
		Vector3 vector2 = Vector3.Zero;
		Vector3.Min(original.Min, additional.Min, vector2);
		Vector3.Max(original.Max, additional.Max, vector);
		result.Min = vector2;
		result.Max = vector;
	}

	/**
	 * Determines whether two instances of BoundingBox are equal.
	 * 
	 * @param obj
	 * The Object to compare with the current BoundingBox.
	 * 
	 * @return
	 * true if the specified Object is equal to the current BoundingBox; false otherwise.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof BoundingBox) ? this.Equals((BoundingBox)obj) : false;
	}

	/**
	 * Determines whether two instances of BoundingBox are equal.
	 * 
	 * @param other
	 * The BoundingBox to compare with the current BoundingBox.
	 * 
	 * @return
	 * true if the specified BoundingBox is equal to the current BoundingBox; false otherwise.
	 */
	public boolean Equals(BoundingBox other)
	{
		return (this.Min.Equals(other.Min) && this.Max.Equals(other.Max));
	}

	/**
	 * Gets an array of points that make up the corners of the BoundingBox.
	 * 
	 * @return
	 * An array of Vector3 points that represent the corners of the BoundingBox.
	 */
	public Vector3[] GetCorners()
	{
		return new Vector3[] { 
			new Vector3(this.Min.X, this.Max.Y, this.Max.Z),
			new Vector3(this.Max.X, this.Max.Y, this.Max.Z),
			new Vector3(this.Max.X, this.Min.Y, this.Max.Z), 
			new Vector3(this.Min.X, this.Min.Y, this.Max.Z), 
			new Vector3(this.Min.X, this.Max.Y, this.Min.Z), 
			new Vector3(this.Max.X, this.Max.Y, this.Min.Z), 
			new Vector3(this.Max.X, this.Min.Y, this.Min.Z), 
			new Vector3(this.Min.X, this.Min.Y, this.Min.Z)
		};
	}

	/**
	 * Defines an axis-aligned box-shaped 3D volume.
	 * 
	 * @param corners
	 * An existing array of at least 8 Vector3 points where the corners of the BoundingBox are written.
	 * 
	 * @throws ArgumentNullException
	 * @throws ArgumentOutOfRangeException
	 */
	public void GetCorners(Vector3[] corners)
	{
		if (corners == null)
		{
			throw new ArgumentNullException("corners");
		}

		if (corners.length < 8)
		{
			throw new ArgumentOutOfRangeException("corners", "You have to have at least 8 elements to copy corners.");
		}

		corners[0].X = this.Min.X;
		corners[0].Y = this.Max.Y;
		corners[0].Z = this.Max.Z;
		corners[1].X = this.Max.X;
		corners[1].Y = this.Max.Y;
		corners[1].Z = this.Max.Z;
		corners[2].X = this.Max.X;
		corners[2].Y = this.Min.Y;
		corners[2].Z = this.Max.Z;
		corners[3].X = this.Min.X;
		corners[3].Y = this.Min.Y;
		corners[3].Z = this.Max.Z;
		corners[4].X = this.Min.X;
		corners[4].Y = this.Max.Y;
		corners[4].Z = this.Min.Z;
		corners[5].X = this.Max.X;
		corners[5].Y = this.Max.Y;
		corners[5].Z = this.Min.Z;
		corners[6].X = this.Max.X;
		corners[6].Y = this.Min.Y;
		corners[6].Z = this.Min.Z;
		corners[7].X = this.Min.X;
		corners[7].Y = this.Min.Y;
		corners[7].Z = this.Min.Z;
	}

	/**
	 * Gets the hash code for this instance.
	 * 
	 * @return
	 * A hash code for the current BoundingBox.
	 */
	@Override
	public int hashCode()
	{
		return (this.Min.hashCode() ^ this.Max.hashCode());
	}

	/**
	 * Checks whether the current BoundingBox intersects another BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to check for intersection with.
	 * 
	 * @return
	 * true if the BoundingBoxs intersect; false otherwise.
	 */
	public boolean Intersects(BoundingBox box)
	{
		if ((this.Max.X < box.Min.X) || (this.Min.X > box.Max.X))
		{
			return false;
		}

		if ((this.Max.Y < box.Min.Y) || (this.Min.Y > box.Max.Y))
		{
			return false;
		}

		return ((this.Max.Z >= box.Min.Z) && (this.Min.Z <= box.Max.Z));
	}

	/**
	 * Checks whether the current BoundingBox intersects a BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to check for intersection with.
	 * 
	 * @return
	 * true if the BoundingBox and BoundingSphere intersect; false otherwise.
	 */
	public boolean Intersects(BoundingSphere sphere)
	{
		Vector3 vector = Vector3.Zero;
		Vector3.Clamp(sphere.Center, this.Min, this.Max, vector);
		float num = Vector3.DistanceSquared(sphere.Center, vector);
		return (num <= (sphere.Radius * sphere.Radius));
	}

	/**
	 * Checks whether the current BoundingBox intersects a Plane.
	 * 
	 * @param plane
	 * The Plane to check for intersection with.
	 * 
	 * @return
	 * An enumeration indicating whether the BoundingBox intersects the Plane.
	 */
	public PlaneIntersectionType Intersects(Plane plane)
	{
		Vector3 vector = Vector3.Zero;
		Vector3 vector2 = Vector3.Zero;
		vector2.X = (plane.Normal.X >= 0f) ? this.Min.X : this.Max.X;
		vector2.Y = (plane.Normal.Y >= 0f) ? this.Min.Y : this.Max.Y;
		vector2.Z = (plane.Normal.Z >= 0f) ? this.Min.Z : this.Max.Z;
		vector.X = (plane.Normal.X >= 0f) ? this.Max.X : this.Min.X;
		vector.Y = (plane.Normal.Y >= 0f) ? this.Max.Y : this.Min.Y;
		vector.Z = (plane.Normal.Z >= 0f) ? this.Max.Z : this.Min.Z;
		float num = ((plane.Normal.X * vector2.X) + (plane.Normal.Y * vector2.Y)) + (plane.Normal.Z * vector2.Z);

		if ((num + plane.D) > 0f)
		{
			return PlaneIntersectionType.Front;
		}

		num = ((plane.Normal.X * vector.X) + (plane.Normal.Y * vector.Y)) + (plane.Normal.Z * vector.Z);

		if ((num + plane.D) < 0f)
		{
			return PlaneIntersectionType.Back;
		}

		return PlaneIntersectionType.Intersecting;
	}

	/**
	 * Checks whether the current BoundingBox intersects a Ray.
	 * 
	 * @param ray
	 * The Ray to check for intersection with.
	 * 
	 * @return
	 * Distance at which the ray intersects the BoundingBox, or null if there is no intersection.
	 */
	public Float Intersects(Ray ray)
	{
		float num = 0f;
		float maxValue = Float.MAX_VALUE;

		if (Math.abs(ray.Direction.X) < 1E-06f)
		{
			if ((ray.Position.X < this.Min.X) || (ray.Position.X > this.Max.X))
			{
				return null;
			}
		}
		else
		{
			float num11 = 1f / ray.Direction.X;
			float num8 = (this.Min.X - ray.Position.X) * num11;
			float num7 = (this.Max.X - ray.Position.X) * num11;

			if (num8 > num7)
			{
				float num14 = num8;
				num8 = num7;
				num7 = num14;
			}

			num = MathHelper.Max(num8, num);
			maxValue = MathHelper.Min(num7, maxValue);

			if (num > maxValue)
			{
				return null;
			}
		}

		if (Math.abs(ray.Direction.Y) < 1E-06f)
		{
			if ((ray.Position.Y < this.Min.Y) || (ray.Position.Y > this.Max.Y))
			{
				return null;
			}
		}
		else
		{
			float num10 = 1f / ray.Direction.Y;
			float num6 = (this.Min.Y - ray.Position.Y) * num10;
			float num5 = (this.Max.Y - ray.Position.Y) * num10;

			if (num6 > num5)
			{
				float num13 = num6;
				num6 = num5;
				num5 = num13;
			}

			num = MathHelper.Max(num6, num);
			maxValue = MathHelper.Min(num5, maxValue);

			if (num > maxValue)
			{
				return null;
			}
		}

		if (Math.abs(ray.Direction.Z) < 1E-06f)
		{
			if ((ray.Position.Z < this.Min.Z) || (ray.Position.Z > this.Max.Z))
			{
				return null;
			}
		}
		else
		{
			float num9 = 1f / ray.Direction.Z;
			float num4 = (this.Min.Z - ray.Position.Z) * num9;
			float num3 = (this.Max.Z - ray.Position.Z) * num9;

			if (num4 > num3)
			{
				float num12 = num4;
				num4 = num3;
				num3 = num12;
			}

			num = MathHelper.Max(num4, num);
			maxValue = MathHelper.Min(num3, maxValue);

			if (num > maxValue)
			{
				return null;
			}
		}

		return new Float(num);
	}

	/**
	 * Returns a String that represents the current BoundingBox.
	 * 
	 * @return
	 * String representation of the current BoundingBox.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{Min:%s Max:%s}", this.Min, this.Max);
	}
}
