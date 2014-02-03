package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;

/**
 * Defines a rectangle.
 * 
 * @author Halofreak1990
 */
public final class Rectangle extends ValueType implements IEquatable<Rectangle>
{
	/**
	 * Returns the y-coordinate of the bottom of the rectangle.
	 */
	public int Bottom()
	{
		return (this.Y + this.Height);
	}

	/**
	 * Gets the Point that specifies the center of the rectangle.
	 */
	public Point Center()
	{
		return new Point(this.X + (this.Width / 2), this.Y + (this.Height / 2));
	}

	/**
	 * Returns a Rectangle with all of its values set to zero.
	 */
	public static final Rectangle Empty = new Rectangle();

	/**
	 * Specifies the height of the rectangle.
	 */
	public int Height;

	/**
	 * Gets a value that indicates whether the Rectangle is empty.
	 */
	public boolean IsEmpty()
	{
		return ((((this.Width == 0) && (this.Height == 0)) && (this.X == 0)) && (this.Y == 0));
	}

	/**
	 * Returns the x-coordinate of the left side of the rectangle.
	 */
	public int Left()
	{
		return this.X;
	}

	/**
	 * Gets the upper-left value of the Rectangle.
	 */
	public Point getLocation()
	{
		return new Point(this.X, this.Y);
	}

	/**
	 * Sets the upper-left value of the Rectangle.
	 * 
	 * @param newLocation
	 * The new location of the upper-left value of the Rectangle.
	 */
	public void setLocation(Point newLocation)
	{
		this.X = newLocation.X;
		this.Y = newLocation.Y;
	}

	/**
	 * Returns the x-coordinate of the right side of the rectangle.
	 */
	public int Right()
	{
		return (this.X + this.Width);
	}

	/**
	 * Returns the y-coordinate of the top of the rectangle.
	 */
	public int Top()
	{
		return this.Y;
	}

	/**
	 * Specifies the width of the rectangle.
	 */
	public int Width;

	/**
	 * Specifies the x-coordinate of the rectangle.
	 */
	public int X;

	/**
	 * Specifies the y-coordinate of the rectangle.
	 */
	public int Y;

	/**
	 * Initializes a new instance of Rectangle.
	 * 
	 * @param x
	 * The x-coordinate of the rectangle.
	 * 
	 * @param y
	 * The y-coordinate of the rectangle.
	 * 
	 * @param width
	 * Width of the rectangle.
	 * 
	 * @param height
	 * Height of the rectangle.
	 */
	public Rectangle(int x, int y, int width, int height)
	{
		this.X = x;
		this.Y = y;
		this.Width = width;
		this.Height = height;
	}

	/**
	 * Initializes a new instance of Rectangle.
	 */
	public Rectangle()
	{
		this.X = 0;
		this.Y = 0;
		this.Width = 0;
		this.Height = 0;
	}

	/**
	 * Determines whether this Rectangle contains a specified Point.
	 * 
	 * @param value
	 * The Point to evaluate.
	 */
	public boolean Contains(Point value)
	{
		return ((((this.X <= value.X) && (value.X < (this.X + this.Width))) && (this.Y <= value.Y)) && (value.Y < (this.Y + this.Height)));
	}

	/**
	 * Determines whether this Rectangle entirely contains a specified Rectangle.
	 * 
	 * @param value
	 * The Rectangle to evaluate.
	 */
	public boolean Contains(Rectangle value)
	{
		return ((((this.X <= value.X) && ((value.X + value.Width) <= (this.X + this.Width))) && (this.Y <= value.Y)) && ((value.Y + value.Height) <= (this.Y + this.Height)));
	}

	/**
	 * Determines whether this Rectangle entirely contains a specified Rectangle.
	 * 
	 * @param value
	 * The Rectangle to evaluate.
	 * 
	 * @param result
	 * [OutAttribute] On exit, is true if this Rectangle entirely contains the specified Rectangle, or false if not.
	 */
	public void Contains(Rectangle value, boolean result)
	{
		result = (((this.X <= value.X) && ((value.X + value.Width) <= (this.X + this.Width))) && (this.Y <= value.Y)) && ((value.Y + value.Height) <= (this.Y + this.Height));
	}

	/**
	 * Determines whether this Rectangle contains a specified point represented by its x- and y-coordinates.
	 * 
	 * @param x
	 * The x-coordinate of the specified point.
	 * 
	 * @param y
	 * The y-coordinate of the specified point.
	 */
	public boolean Contains(int x, int y)
	{
		return ((((this.X <= x) && (x < (this.X + this.Width))) && (this.Y <= y)) && (y < (this.Y + this.Height)));
	}

	/**
	 * Determines whether this Rectangle contains a specified Point.
	 * 
	 * @param value
	 * The Point to evaluate.
	 * 
	 * @param result
	 * [OutAttribute] true if the specified Point is contained within this Rectangle; false otherwise.
	 */
	public void Contains(Point value, boolean result)
	{
		result = (((this.X <= value.X) && (value.X < (this.X + this.Width))) && (this.Y <= value.Y)) && (value.Y < (this.Y + this.Height));
	}

	/**
	 * Determines whether the specified Object is equal to the current instance.
	 * 
	 * @param obj
	 * The Object to compare with the current Ray.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Rectangle) ? this.Equals((Rectangle)obj) : false;
	}

	/**
	 * Determines whether the specified Object is equal to the Rectangle.
	 * 
	 * @param other
	 * The Object to compare with the current Rectangle.
	 */
	public boolean Equals(Rectangle other)
	{
		return ((((this.X == other.X) && (this.Y == other.Y)) && (this.Width == other.Width)) && (this.Height == other.Height));
	}

	/**
	 * Gets the hash code for this object.
	 */
	public int GetHashCode()
	{
		return (this.X ^ this.Y ^ this.Width ^ this.Height);
	}

	/**
	 * Pushes the edges of the Rectangle out by the horizontal and vertical values specified.
	 * 
	 * @param horizontalAmount
	 * Value to push the sides out by.
	 * 
	 * @param verticalAmount
	 * Value to push the top and bottom out by.
	 */
	public void Inflate(int horizontalAmount, int verticalAmount)
	{
		this.X -= horizontalAmount;
		this.Y -= verticalAmount;
		this.Width += horizontalAmount * 2;
		this.Height += verticalAmount * 2;
	}

	/**
	 * Creates a Rectangle defining the area where one rectangle overlaps with another rectangle.
	 * 
	 * @param value1
	 * The first Rectangle to compare.
	 * 
	 * @param value2
	 * The second Rectangle to compare.
	 * 
	 * @return
	 * 
	 */
	public static Rectangle Intersect(Rectangle value1, Rectangle value2)
	{
		Rectangle rectangle = Rectangle.Empty;
		int num8 = value1.X + value1.Width;
		int num7 = value2.X + value2.Width;
		int num6 = value1.Y + value1.Height;
		int num5 = value2.Y + value2.Height;
		int num2 = (value1.X > value2.X) ? value1.X : value2.X;
		int num = (value1.Y > value2.Y) ? value1.Y : value2.Y;
		int num4 = (num8 < num7) ? num8 : num7;
		int num3 = (num6 < num5) ? num6 : num5;
		if ((num4 > num2) && (num3 > num))
		{
			rectangle.X = num2;
			rectangle.Y = num;
			rectangle.Width = num4 - num2;
			rectangle.Height = num3 - num;
			return rectangle;
		}
		rectangle.X = 0;
		rectangle.Y = 0;
		rectangle.Width = 0;
		rectangle.Height = 0;
		return rectangle;
	}

	/**
	 * Creates a Rectangle defining the area where one rectangle overlaps with another rectangle.
	 * 
	 * @param value1
	 * The first Rectangle to compare.
	 * 
	 * @param value2
	 * The second Rectangle to compare.
	 * 
	 * @param result
	 * [OutAttribute] The area where the two first parameters overlap.
	 */
	public static void Intersect(Rectangle value1, Rectangle value2, Rectangle result)
	{
		int num8 = value1.X + value1.Width;
		int num7 = value2.X + value2.Width;
		int num6 = value1.Y + value1.Height;
		int num5 = value2.Y + value2.Height;
		int num2 = (value1.X > value2.X) ? value1.X : value2.X;
		int num = (value1.Y > value2.Y) ? value1.Y : value2.Y;
		int num4 = (num8 < num7) ? num8 : num7;
		int num3 = (num6 < num5) ? num6 : num5;
		if ((num4 > num2) && (num3 > num))
		{
			result.X = num2;
			result.Y = num;
			result.Width = num4 - num2;
			result.Height = num3 - num;
		}
		else
		{
			result.X = 0;
			result.Y = 0;
			result.Width = 0;
			result.Height = 0;
		}
	}

	/**
	 * Determines whether a specified Rectangle intersects with this Rectangle.
	 * 
	 * @param value
	 * The Rectangle to evaluate.
	 * 
	 * @return
	 * true if the specified Rectangle intersects with this one; false otherwise.
	 */
	public boolean Intersects(Rectangle value)
	{
		return ((((value.X < (this.X + this.Width)) && (this.X < (value.X + value.Width))) && (value.Y < (this.Y + this.Height))) && (this.Y < (value.Y + value.Height)));
	}

	/**
	 * Determines whether a specified Rectangle intersects with this Rectangle.
	 * 
	 * @param value
	 * The Rectangle to evaluate
	 * 
	 * @param result
	 * [OutAttribute] true if the specified Rectangle intersects with this one; false otherwise.
	 */
	public void Intersects(Rectangle value, boolean result)
	{
		result = (((value.X < (this.X + this.Width)) && (this.X < (value.X + value.Width))) && (value.Y < (this.Y + this.Height))) && (this.Y < (value.Y + value.Height));
	}

	/**
	 * Changes the position of the Rectangle.
	 * 
	 * @param amount
	 * The values to adjust the position of the Rectangle by.
	 */
	public void Offset(Point amount)
	{
		this.X += amount.X;
		this.Y += amount.Y;
	}

	/**
	 * Changes the position of the Rectangle.
	 * 
	 * @param offsetX
	 * Change in the x-position.
	 * 
	 * @param offsetY
	 * Change in the y-position.
	 */
	public void Offset(int offsetX, int offsetY)
	{
		this.X += offsetX;
		this.Y += offsetY;
	}

	/**
	 * Retrieves a string representation of the current object.
	 * 
	 * @return
	 * String that represents the object.
	 */
	public String toString()
	{
		return String.format(Locale.getDefault(), "{{X:%i Y:%i Width:%i Height:%i}}", this.X, this.Y, this.Width, this.Height);
	}

	/**
	 * Creates a new Rectangle that exactly contains two other rectangles.
	 * 
	 * @param value1
	 * The first Rectangle to contain.
	 * 
	 * @param value2
	 * The second Rectangle to contain.
	 */
	public static Rectangle Union(Rectangle value1, Rectangle value2)
	{
		Rectangle rectangle = Rectangle.Empty;
		int num6 = value1.X + value1.Width;
		int num5 = value2.X + value2.Width;
		int num4 = value1.Y + value1.Height;
		int num3 = value2.Y + value2.Height;
		int num2 = (value1.X < value2.X) ? value1.X : value2.X;
		int num = (value1.Y < value2.Y) ? value1.Y : value2.Y;
		int num8 = (num6 > num5) ? num6 : num5;
		int num7 = (num4 > num3) ? num4 : num3;
		rectangle.X = num2;
		rectangle.Y = num;
		rectangle.Width = num8 - num2;
		rectangle.Height = num7 - num;
		return rectangle;
	}

	/**
	 * Creates a new Rectangle that exactly contains two other rectangles.
	 * 
	 * @param value1
	 * The first Rectangle to contain.
	 * 
	 * @param value2
	 * The second Rectangle to contain.
	 * 
	 * @param result
	 * [OutAttribute] The Rectangle that must be the union of the first two rectangles.
	 */
	public static void Union(Rectangle value1, Rectangle value2, Rectangle result)
	{
		int num6 = value1.X + value1.Width;
		int num5 = value2.X + value2.Width;
		int num4 = value1.Y + value1.Height;
		int num3 = value2.Y + value2.Height;
		int num2 = (value1.X < value2.X) ? value1.X : value2.X;
		int num = (value1.Y < value2.Y) ? value1.Y : value2.Y;
		int num8 = (num6 > num5) ? num6 : num5;
		int num7 = (num4 > num3) ? num4 : num3;
		result.X = num2;
		result.Y = num;
		result.Width = num8 - num2;
		result.Height = num7 - num;
	}
}
