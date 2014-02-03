package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a point in 2D space.
 * 
 * @author Halofreak1990
 */
public final class Point extends ValueType implements IEquatable<Point>
{
	/**
	 * Specifies the x-coordinate of the Point.
	 */
	public int X;
	/**
	 * Specifies the y-coordinate of the Point.
	 */
	public int Y;
	/**
	 * Returns the point (0,0).
	 */
	public static final Point Zero = new Point(0, 0);

	/**
	 * Initializes a new instance of Point.
	 */
	public Point()
	{
		X = 0;
		Y = 0;
	}

	/**
	 * Initializes a new instance of Point.
	 * 
	 * @param x
	 * The x-coordinate of the Point.
	 * 
	 * @param y
	 * The y-coordinate of the Point.
	 */
	public Point(int x, int y)
	{
		X = x;
		Y = y;
	}

	/**
	 * Determines whether the specified Object is equal to this instance.
	 * 
	 * @param
	 * The object to compare this instance to.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Point) ? this.Equals((Point)obj) : false;
	}

	/**
	 * Determines whether two Point instances are equal.
	 * 
	 * @param other
	 * The Point to compare this instance to.
	 */
	public boolean Equals(Point other)
	{
		return ((this.X == other.X) && (this.Y == other.Y));
	}

	/**
	 * Gets the hash code for this object.
	 */
	@Override
	public int hashCode()
	{
		return (this.X ^ this.Y);
	}

	/**
	 * Returns a String that represents the current Point.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{X:%i Y:%i}", this.X, this.Y);
	}
}
