package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Defines the window dimensions of a render-target surface onto which a 3D volume projects.
 * 
 * @author Halofreak1990
 */
public final class Viewport extends ValueType implements IEquatable<Viewport>
{
	/**
	 * Gets or sets the pixel coordinate of the upper-left corner of the viewport on the render-target surface.
	 */
	public int X;
	/**
	 * Gets or sets the pixel coordinate of the upper-left corner of the viewport on the render-target surface.
	 */
	public int Y;
	/**
	 * Gets or sets the width dimension of the viewport on the render-target surface, in pixels.
	 */
	public int Width;
	/**
	 * Gets or sets the height dimension of the viewport on the render-target surface, in pixels.
	 */
	public int Height;
	/**
	 * Gets or sets the minimum depth of the clip volume.
	 */
	public float MinDepth;
	/**
	 * Gets or sets the maximum depth of the clip volume.
	 */
	public float MaxDepth;

	/**
	 * Gets the aspect ratio used by the viewport.
	 */
	public float getAspectRatio()
	{
		if ((this.Height != 0) && (this.Width != 0))
		{
			return (((float) this.Width) / ((float) this.Height));
		}

		return 0f;
	}

	/**
	 * Gets the size of this resource.
	 */
	public Rectangle getBounds()
	{
		return new Rectangle(X, Y, Width, Height);
	}

	/**
	 * Sets the size of this resource.
	 */
	public void setBounds(Rectangle bounds)
	{
		X = bounds.X;
		Y = bounds.Y;
		Width = bounds.Width;
		Height = bounds.Height;
	}

	/**
	 * Returns the title safe area of the current viewport.
	 */
	public Rectangle TitleSafeArea()
	{
		return new Rectangle(X, Y, Width, Height);
	}

	/**
	 * Creates an instance of this object.
	 * 
	 * @param x
	 * The x coordinate of the upper-left corner of the viewport in pixels.
	 * 
	 * @param y
	 * The y coordinate of the upper-left corner of the viewport in pixels.
	 * 
	 * @param width
	 * The width of the viewport in pixels.
	 * 
	 * @param height
	 * The height of the viewport in pixels.
	 */
	public Viewport(int x, int y, int width, int height)
	{
		X = x;
		Y = y;
		Width = width;
		Height = height;
		MinDepth = 0f;
		MaxDepth = 1f;
	}

	/**
	 * Creates an instance of this object.
	 * 
	 * @param bounds
	 * A bounding box that defines the location and size of the viewport in a render target.
	 */
	public Viewport(Rectangle bounds)
	{
		X = bounds.X;
		Y = bounds.Y;
		Width = bounds.Width;
		Height = bounds.Height;
		MinDepth = 0f;
		MaxDepth = 1f;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof Viewport) ? this.Equals((Viewport)obj) : false;
	}

	/**
	 * 
	 */
	public boolean Equals(Viewport other)
	{
		return ((this.X == other.X) && (this.Y == other.Y) &&
				(this.Width == other.Width) && (this.Height == other.Height) &&
				(this.MaxDepth == other.MaxDepth) && (this.MinDepth == other.MinDepth));
	}

	/**
	 * Retrieves a string representation of this object.
	 */
	public String ToString()
	{
		return String.format(Locale.getDefault(), "{{X:%i Y:%i Width:%i Height:%i MinDepth:%f MaxDepth:%f}}", X, Y, Width, Height, MinDepth, MaxDepth);
	}

	private static boolean WithinEpsilon(float a, float b)
	{
		float num = a - b;

		return ((-1.401298E-45f <= num) && (num <= 1.401298E-45f));
	}

	/**
	 * Projects a 3D vector from object space into screen space.
	 * 
	 * @param source
	 * The vector to project.
	 * 
	 * @param projection
	 * The projection matrix.
	 * 
	 * @param view
	 * The view matrix.
	 * 
	 * @param world
	 * The world matrix.
	 */
	public Vector3 Project(Vector3 source, Matrix projection, Matrix view, Matrix world)
	{
		Matrix matrix = Matrix.Multiply(Matrix.Multiply(world, view), projection);
		Vector3 vector = Vector3.Transform(source, matrix);
		float a = (((source.X * matrix.M14) + (source.Y * matrix.M24)) + (source.Z * matrix.M34)) + matrix.M44;
		if (!WithinEpsilon(a, 1f))
		{
			vector.Divide(a);
		}
		vector.X = (((vector.X + 1f) * 0.5f) * this.Width) + this.X;
		vector.Y = (((-vector.Y + 1f) * 0.5f) * this.Height) + this.Y;
		vector.Z = (vector.Z * (this.MaxDepth - this.MinDepth)) + this.MinDepth;
		return vector;
	}

	/**
	 * Converts a screen space point into a corresponding point in world space.
	 * 
	 * @param source
	 * The vector to project.
	 * 
	 * @param projection
	 * The projection matrix.
	 * 
	 * @param view
	 * The view matrix.
	 * 
	 * @param world
	 * The world matrix.
	 */
	public Vector3 Unproject(Vector3 source, Matrix projection, Matrix view, Matrix world)
	{
		Matrix matrix = Matrix.Invert(Matrix.Multiply(Matrix.Multiply(world, view), projection));
		source.X = (((source.X - this.X) / ((float) this.Width)) * 2f) - 1f;
		source.Y = -((((source.Y - this.Y) / ((float) this.Height)) * 2f) - 1f);
		source.Z = (source.Z - this.MinDepth) / (this.MaxDepth - this.MinDepth);
		Vector3 vector = Vector3.Transform(source, matrix);
		float a = (((source.X * matrix.M14) + (source.Y * matrix.M24)) + (source.Z * matrix.M34)) + matrix.M44;
		if (!WithinEpsilon(a, 1f))
		{
			vector.Divide(a);
		}
		return vector;
	}
}
