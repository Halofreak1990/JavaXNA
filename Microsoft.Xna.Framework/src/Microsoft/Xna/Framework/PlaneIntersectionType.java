package Microsoft.Xna.Framework;

/**
 * Describes the intersection between a plane and a bounding volume.
 * 
 * @author Halofreak1990
 */
public enum PlaneIntersectionType
{
	/**
	 * There is no intersection, and the bounding volume is in the positive half-space of the Plane.
	 */
	Front,
	/**
	 * There is no intersection, and the bounding volume is in the negative half-space of the Plane.
	 */
	Back,
	/**
	 * The Plane is intersected.
	 */
	Intersecting
}
