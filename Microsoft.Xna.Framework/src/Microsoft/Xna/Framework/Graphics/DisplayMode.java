package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;
import Microsoft.Xna.Framework.*;

/**
 * Describes the display mode.
 *
 * @author Halofreak1990
 */
public class DisplayMode
{
	SurfaceFormat _format;
	int _height;
	int _width;
	
	/**
	 * Gets the aspect ratio used by the graphics device.
	 */
	public float getAspectRatio()
	{
		if (this._width != 0 && this._height != 0)
		{
			return (((float) this._width) / ((float) this._height));
		}
		return 0f;
	}
	
	/**
	 * Gets a value indicating the surface format of the display mode.
	 */
	public SurfaceFormat getFormat()
	{
		return this._format;
	}
	
	/**
	 * Gets a value indicating the screen height, in pixels.
	 */
	public int getHeight()
	{
		return this._height;
	}
	
	/**
	 * Returns the title safe area of the display.
	 */
	public Rectangle getTitleSafeArea()
	{
		return new Rectangle(0, 0, this._width, this._height);
	}
	
	/**
	 * Gets a value indicating the screen width, in pixels.
	 */
	public int getWidth()
	{
		return this._width;
	}
	
	DisplayMode(int width, int height, SurfaceFormat format)
	{
		this._width = width;
		this._height = height;
		this._format = format;
	}
	
	/**
	 * Retrieves a string representation of this object.
	 */
	public String toString()
	{
		return String.format(Locale.getDefault(), "{Width:%1$ Height:%2$ Format:%3$ AspectRatio:%4$}", new Object[] { this._width, this._height, this._format, this.getAspectRatio() });
	}
}
