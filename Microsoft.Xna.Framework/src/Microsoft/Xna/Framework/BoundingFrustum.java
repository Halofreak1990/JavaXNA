package Microsoft.Xna.Framework;

import System.*;

/**
 * Defines a frustum and helps determine whether forms intersect with it.
 * 
 * @author Halofreak1990
 */
public class BoundingFrustum implements IEquatable<BoundingFrustum>
{
	private final Vector3[] cornerArray = new Vector3[CornerCount];
	private Matrix matrix;
	private static final int PlaneCount = 6;
	private final Plane[] planes = new Plane[PlaneCount];

	/**
	 * Specifies the total number of corners (8) in the BoundingFrustum.
	 */
	public static final int CornerCount = 8;

	/**
	 * Gets the bottom plane of the BoundingFrustum.
	 * 
	 * @return
	 * The bottom plane of the BoundingFrustum.
	 */
	public Plane getBottom()
	{
		return planes[5];
	}

	/**
	 * Gets the far plane of the BoundingFrustum.
	 * 
	 * @return
	 * The far plane of the BoundingFrustum.
	 */
	public Plane getFar()
	{
		return this.planes[1];
	}

	/**
	 * Gets the left plane of the BoundingFrustum.
	 * 
	 * @return
	 * The left plane of the BoundingFrustum.
	 */
	public Plane getLeft()
	{
		return this.planes[2];
	}

	/**
	 * Gets the Matrix that describes this bounding frustum.
	 * 
	 * @return
	 * The Matrix that describes this bounding frustum.
	 */
	public Matrix getMatrix()
	{
		return this.matrix;
	}

	/**
	 * Sets the Matrix that describes this bounding frustum.
	 * 
	 * @param value
	 * 
	 */
	public void setMatrix(Matrix value)
	{
		matrix = value;
		planes[2].Normal.X = -value.M14 - value.M11;
		planes[2].Normal.Y = -value.M24 - value.M21;
		planes[2].Normal.Z = -value.M34 - value.M31;
		planes[2].D = -value.M44 - value.M41;
		planes[3].Normal.X = -value.M14 + value.M11;
		planes[3].Normal.Y = -value.M24 + value.M21;
		planes[3].Normal.Z = -value.M34 + value.M31;
		planes[3].D = -value.M44 + value.M41;
		planes[4].Normal.X = -value.M14 + value.M12;
		planes[4].Normal.Y = -value.M24 + value.M22;
		planes[4].Normal.Z = -value.M34 + value.M32;
		planes[4].D = -value.M44 + value.M42;
		planes[5].Normal.X = -value.M14 - value.M12;
		planes[5].Normal.Y = -value.M24 - value.M22;
		planes[5].Normal.Z = -value.M34 - value.M32;
		planes[5].D = -value.M44 - value.M42;
		planes[0].Normal.X = -value.M13;
		planes[0].Normal.Y = -value.M23;
		planes[0].Normal.Z = -value.M33;
		planes[0].D = -value.M43;
		planes[1].Normal.X = -value.M14 + value.M13;
		planes[1].Normal.Y = -value.M24 + value.M23;
		planes[1].Normal.Z = -value.M34 + value.M33;
		planes[1].D = -value.M44 + value.M43;

		for (int i = 0; i < 6; i++)
		{
			float num2 = planes[i].Normal.Length();
			planes[i].Normal = Vector3.Divide(planes[i].Normal, num2);
			planes[i].D /= num2;
		}

		Ray ray = ComputeIntersectionLine(planes[0], planes[2]);
		cornerArray[0] = ComputeIntersection(planes[4], ray);
		cornerArray[3] = ComputeIntersection(planes[5], ray);
		ray = ComputeIntersectionLine(planes[3], planes[0]);
		cornerArray[1] = ComputeIntersection(planes[4], ray);
		cornerArray[2] = ComputeIntersection(planes[5], ray);
		ray = ComputeIntersectionLine(planes[2], planes[1]);
		cornerArray[4] = ComputeIntersection(planes[4], ray);
		cornerArray[7] = ComputeIntersection(planes[5], ray);
		ray = ComputeIntersectionLine(planes[1], planes[3]);
		cornerArray[5] = ComputeIntersection(planes[4], ray);
		cornerArray[6] = ComputeIntersection(planes[5], ray);
	}

	/**
	 * Gets the near plane of the BoundingFrustum.
	 * 
	 * @return
	 * The near plane of the BoundingFrustum.
	 */
	public Plane getNear()
	{
		return this.planes[0];
	}

	/**
	 * Gets the right plane of the BoundingFrustum.
	 * 
	 * @return
	 * The right plane of the BoundingFrustum.
	 */
	public Plane getRight()
	{
		return this.planes[3];
	}

	/**
	 * 
	 * @return
	 */
	public Plane getTop()
	{
		return this.planes[4];
	}


	/**
	 * Creates a new instance of BoundingFrustum.
	 *
	 * @param value
	 * Combined matrix that usually takes view × projection matrix.
	 */
	public BoundingFrustum(Matrix value)
	{
		planes[0] = new Plane();
		planes[1] = new Plane();
		planes[2] = new Plane();
		planes[3] = new Plane();
		planes[4] = new Plane();
		planes[5] = new Plane();
		cornerArray[0] = new Vector3();
		cornerArray[1] = new Vector3();
		cornerArray[2] = new Vector3();
		cornerArray[3] = new Vector3();
		cornerArray[4] = new Vector3();
		cornerArray[5] = new Vector3();
		cornerArray[6] = new Vector3();
		cornerArray[7] = new Vector3();

		setMatrix(value);
	}

	private static Vector3 ComputeIntersection(Plane plane, Ray ray)
	{
		float num = (-plane.D - Vector3.Dot(plane.Normal, ray.Position)) / Vector3.Dot(plane.Normal, ray.Direction);
		
		return Vector3.Add(ray.Position, Vector3.Multiply(ray.Direction, num));
	}

	private Ray ComputeIntersectionLine(Plane p1, Plane p2)
	{
		Ray ray = new Ray();
		ray.Direction = Vector3.Cross(p1.Normal, p2.Normal);
		float num = ray.Direction.LengthSquared();
		ray.Position = Vector3.Divide(
			Vector3.Cross(
				Vector3.Add(Vector3.Multiply(p2.Normal, -p1.D), Vector3.Multiply(p1.Normal, p2.D)),
				ray.Direction
			), num);
		return ray;
	}

	/**
	 * Checks whether the current BoundingFrustum contains the specified BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to check against the current BoundingFrustum.
	 * 
	 * @return
	 */
	@SuppressWarnings("incomplete-switch")
	public ContainmentType Contains(BoundingSphere sphere)
	{
		boolean intersects = false;

		for (int i = 0; i < PlaneCount; ++i) 
		{
			PlaneIntersectionType planeIntersectionType = sphere.Intersects(this.planes[i]);

			switch (planeIntersectionType)
			{
			case Front:
				return ContainmentType.Disjoint; 

			case Intersecting:
				intersects = true;
				break;
			}
		}

		return intersects ? ContainmentType.Intersects : ContainmentType.Contains;
	}

	/**
	 * Checks whether the current BoundingFrustum contains the specified point.
	 * 
	 * @param point
	 * The point to check against the current BoundingFrustum.
	 * 
	 * @return
	 */
	public ContainmentType Contains(Vector3 point)
	{
		for (int i = 0; i < PlaneCount; ++i)
		{
			if (this.planes[i].DotCoordinate(point) > 0)
			{
				return ContainmentType.Disjoint;
			}
		}

		return ContainmentType.Contains;
	}

	/**
	 * Checks whether the current BoundingFrustum contains the specified BoundingFrustum.
	 * 
	 * @param frustrum
	 * The BoundingFrustum to check against the current BoundingFrustum.
	 * 
	 * @return
	 */
	public ContainmentType Contains(BoundingFrustum frustrum)
	{
		ContainmentType disjoint = ContainmentType.Disjoint;

		if (Intersects(frustrum))
		{
			disjoint = ContainmentType.Contains;

			for (int i = 0; i < 8; i++)
			{
				if (Contains(frustrum.cornerArray[i]) == ContainmentType.Disjoint)
				{
					return ContainmentType.Intersects;
				}
			}
		}

		return disjoint;
	}

	/**
	 * Checks whether the current BoundingFrustum contains the specified BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to check against the current BoundingFrustum.
	 * 
	 * @return
	 */
	@SuppressWarnings("incomplete-switch")
	public ContainmentType Contains(BoundingBox box)
	{
		boolean flag = false;

		for(int i = 0; i < 6; i++)
		{
			switch (box.Intersects(planes[i]))
			{
			case Front:
				return ContainmentType.Disjoint;

			case Intersecting:
				flag = true;
				break;
			}
		}

		if (!flag)
		{
			return ContainmentType.Contains;
		}

		return ContainmentType.Intersects;
	}

	/**
	 * Determines whether the specified Object is equal to the BoundingFrustum.
	 * 
	 * @param obj
	 * The Object to compare with the current BoundingFrustum.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof BoundingFrustum) ? this.Equals((BoundingFrustum)obj) : false;
	}

	/**
	 * Determines whether the specified BoundingFrustum is equal to the current BoundingFrustum.
	 * 
	 * @param other
	 * The BoundingFrustum to compare with the current BoundingFrustum.
	 */
	public boolean Equals(BoundingFrustum other)
	{
		return this.matrix.Equals(other.matrix);
	}

	/**
	 * Gets an array of points that make up the corners of the BoundingFrustum.
	 * 
	 * @param corners
	 * An existing array of at least 8 Vector3 points where the corners of the BoundingFrustum are written.
	 */
	public void GetCorners(Vector3[] corners)
	{
		if (corners == null)
		{
			throw new ArgumentNullException("corners");
		}

		if (corners.length < CornerCount)
		{
			throw new ArgumentOutOfRangeException("corners");
		}

		System.arraycopy(this.cornerArray, 0, corners, 0, CornerCount);
	}

	/**
	 * Gets an array of points that make up the corners of the BoundingFrustum.
	 * 
	 * @return
	 * An array of points that make up the corners of the BoundingFrustum.
	 */
	public Vector3[] GetCorners()
	{
		Vector3[] array = new Vector3[CornerCount];

		System.arraycopy(this.cornerArray, 0, array, 0, CornerCount);

		return array;
	}

	/**
	 * Gets the hash code for this instance.
	 */
	@Override
	public int hashCode()
	{
		return matrix.hashCode();
	}

	/**
	 * Checks whether the current BoundingFrustum intersects the specified BoundingBox.
	 * 
	 * @param box
	 * The BoundingBox to check for intersection.
	 * 
	 * @return
	 */
	public boolean Intersects(BoundingBox box)
	{
		return this.Contains(box) != ContainmentType.Disjoint;
	}

	/**
	 * Checks whether the current BoundingFrustum intersects the specified BoundingFrustum.
	 * 
	 * @param frustrum
	 * The BoundingFrustum to check for intersection.
	 * 
	 * @return
	 */
	public boolean Intersects(BoundingFrustum frustrum)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * Checks whether the current BoundingFrustum intersects the specified BoundingSphere.
	 * 
	 * @param sphere
	 * The BoundingSphere to check for intersection.
	 * 
	 * @return
	 */
	public boolean Intersects(BoundingSphere sphere)
	{
		return this.Contains(sphere) != ContainmentType.Disjoint;
	}

	/**
	 * Checks whether the current BoundingFrustum intersects the specified Plane.
	 * 
	 * @param plane
	 * The Plane to check for intersection.
	 * 
	 * @return
	 */
	public PlaneIntersectionType Intersects(Plane plane)
	{
		int num = 0;

		for (int i = 0; i < 8; i++)
		{
			float num3 = Vector3.Dot(cornerArray[i], plane.Normal);

			if ((num3 + plane.D) > 0)
			{
				num |= 1;
			}
			else
			{
				num |= 2;
			}

			if (num == 3)
			{
				return PlaneIntersectionType.Intersecting;
			}
		}

		if (num != 1)
		{
			return PlaneIntersectionType.Back;
		}

		return PlaneIntersectionType.Front;
	}

	/**
	 * Checks whether the current BoundingFrustum intersects the specified Ray.
	 * 
	 * @param ray
	 * The Ray to check for intersection.
	 * 
	 * @return
	 */
	public Float Intersects(Ray ray)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * Returns a String that represents the current BoundingFrustum.
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder(256);
		sb.append("{Near:");
		sb.append(this.planes[0].toString());
		sb.append(" Far:");
		sb.append(this.planes[1].toString());
		sb.append(" Left:");
		sb.append(this.planes[2].toString());
		sb.append(" Right:");
		sb.append(this.planes[3].toString());
		sb.append(" Top:");
		sb.append(this.planes[4].toString());
		sb.append(" Bottom:");
		sb.append(this.planes[5].toString());
		sb.append("}");
		return sb.toString();
	}
}
