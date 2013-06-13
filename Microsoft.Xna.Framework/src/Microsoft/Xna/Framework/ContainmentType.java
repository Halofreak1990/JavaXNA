package Microsoft.Xna.Framework;

/**
 * Indicates the extent to which bounding volumes intersect or contain one another.
 * 
 * @author Halofreak1990
 */
public enum ContainmentType
{
	/**
	 * Indicates there is no overlap between the bounding volumes.
	 */
	Disjoint,
	/**
	 * Indicates that one bounding volume completely contains the other.
	 */
    Contains,
    /**
     * Indicates that the bounding volumes partially overlap.
     */
    Intersects
}
