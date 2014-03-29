package Microsoft.Xna.Framework;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.Graphics.PackedVector.*;

/**
 * Represents a four-component color using red, green, blue, and alpha data.
 * 
 * @author Halofreak1990
 */
public final class Color extends ValueType implements IEquatable<Color>
{
	private int packedValue;

	/**
	 * Creates a new instance of the class.
	 * 
	 * @param vector
	 * A three-component color.
	 */
	public Color(Vector3 vector)
	{
		this.packedValue = PackHelper(vector.X, vector.Y, vector.Z, 1f);
	}

	/**
	 * Creates a new instance of the class.
	 * 
	 * @param vector
	 * A four-component color.
	 */
	public Color(Vector4 vector)
	{
		this.packedValue = PackHelper(vector.X, vector.Y, vector.Z, vector.W);
	}

	private Color(int packedValue)
	{
		this.packedValue = packedValue;
	}

	/**
	 * Creates a new instance of the class.
	 * 
	 * @param r
	 * Red component.
	 * 
	 * @param g
	 * Green component.
	 * 
	 * @param b
	 * Blue component.
	 */
	public Color(int r, int g, int b)
	{
		if ((((r | g) | b) & -256) != 0)
		{
			r = ClampToByte64((long) r);
			g = ClampToByte64((long) g);
			b = ClampToByte64((long) b);
		}

		g = g << 8;
		b = b << 0x10;

		this.packedValue = (int)(((r | g) | b) | -16777216);
	}

	/**
	 * Creates a new instance of the class.
	 * 
	 * @param r
	 * Red component.
	 * 
	 * @param g
	 * Green component.
	 * 
	 * @param b
	 * Blue component.
	 */
	public Color(float r, float g, float b)
	{
		this.packedValue = PackHelper(r, g, b, 1f);
	}

	/**
	 * Creates a new instance of the class.
	 * 
	 * @param r
	 * Red component.
	 * 
	 * @param g
	 * Green component.
	 * 
	 * @param b
	 * Blue component.
	 * 
	 * @param a
	 * Alpha component.
	 */
	public Color(int r, int g, int b, int a)
	{
		if (((((r | g) | b) | a) & -256) != 0)
		{
			r = ClampToByte32(r);
			g = ClampToByte32(g);
			b = ClampToByte32(b);
			a = ClampToByte32(a);
		}

		g = g << 8;
		b = b << 0x10;
		a = a << 0x18;

		this.packedValue = (int)(((r | g) | b) | a);
	}

	/**
	 * Creates a new instance of the class.
	 * 
	 * @param r
	 * Red component.
	 * 
	 * @param g
	 * Green component.
	 * 
	 * @param b
	 * Blue component.
	 * 
	 * @param a
	 * Alpha component.
	 */
	public Color(float r, float g, float b, float a)
	{
		this.packedValue = PackHelper(r, g, b, a);
	}

	public Color()
	{
		this.packedValue = Transparent.packedValue;
	}

	private static int ClampToByte32(int value)
	{
		if (value < 0)
		{
			return 0;
		}

		if (value > 0xff)
		{
			return 0xff;
		}

		return value;
	}

	private static int ClampToByte64(long value)
	{
		if (value < 0L)
		{
			return 0;
		}

		if (value > 0xffL)
		{
			return 0xff;
		}

		return (int) value;
	}

	/**
	 * 
	 * @param obj
	 */
	public boolean equals(Object obj)
	{
		return ((obj != null) && (obj instanceof Color)) ? (this.packedValue == ((Color)obj).packedValue) : false;
	}

	public boolean Equals(Color other)
	{
		return this.packedValue == other.packedValue;
	}

	/**
	 * Convert a non premultiplied color into color data that contains alpha.
	 * 
	 * @param vector
	 * A four-component Color.
	 */
	public static Color FromNonPremultiplied(Vector4 vector)
	{
		return new Color(PackHelper(vector.X * vector.W, vector.Y * vector.W, vector.Z * vector.W, vector.W));
	}

	/**
	 * Converts a non-premultiplied alpha color to a color that contains premultiplied alpha.
	 * 
	 * @param r
	 * Red component.
	 * 
	 * @param g
	 * Green component.
	 * 
	 * @param b
	 * Blue component.
	 * 
	 * @param a
	 * Alpha component.
	 */
	public static Color FromNonPremultiplied(int r, int g, int b, int a)
	{
		r = ClampToByte64((r * a) / 0xffL);
		g = ClampToByte64((g * a) / 0xffL);
		b = ClampToByte64((b * a) / 0xffL);
		a = ClampToByte32(a);
		g = g << 8;
		b = b << 0x10;
		a = a << 0x18;

		return new Color((int)(((r | g) | b) | a));
	}

	/**
	 * Serves as a hash function for a particular type.
	 */
	@Override
	public int hashCode()
	{
		return this.packedValue;
	}

	/**
	 * Linearly interpolate a color.
	 * 
	 * @param value1
	 * A four-component Color.
	 * 
	 * @param value2
	 * A four-component Color.
	 * 
	 * @param amount
	 * Interpolation factor.
	 */
	public static Color Lerp(Color value1, Color value2, float amount)
	{
		Color color = new Color(Transparent.getPackedValue());
		long packedValue = value1.packedValue;
		long num2 = value2.packedValue;
		int num7 = (byte) packedValue;
		int num6 = (byte) (packedValue >> 8);
		int num5 = (byte) (packedValue >> 0x10);
		int num4 = (byte) (packedValue >> 0x18);
		int num15 = (byte) num2;
		int num14 = (byte) (num2 >> 8);
		int num13 = (byte) (num2 >> 0x10);
		int num12 = (byte) (num2 >> 0x18);
		int num = (int) PackUtils.PackUNorm(65536f, amount);
		int num11 = num7 + (((num15 - num7) * num) >> 0x10);
		int num10 = num6 + (((num14 - num6) * num) >> 0x10);
		int num9 = num5 + (((num13 - num5) * num) >> 0x10);
		int num8 = num4 + (((num12 - num4) * num) >> 0x10);
		color.packedValue = (int)(((num11 | (num10 << 8)) | (num9 << 0x10)) | (num8 << 0x18));
		return color;
	}

	/**
	 * Multiply each color component by the scale factor.
	 * 
	 * @param value
	 * The source, four-component color.
	 * 
	 * @param scale
	 * The scale factor.
	 */
	public static Color Multiply(Color value, float scale)
	{
		int num;
		Color color = new Color(Transparent.getPackedValue());
		int packedValue = value.packedValue;
		int num5 = (byte) packedValue;
		int num4 = (byte) (packedValue >> 8);
		int num3 = (byte) (packedValue >> 0x10);
		int num2 = (byte) (packedValue >> 0x18);
		scale *= 65536f;

		if (scale < 0f)
		{
			num = 0;
		}
		else if (scale > 1.677722E+07f)
		{
			num = 0xffffff;
		}
		else
		{
			num = (int)scale;
		}

		num5 = (num5 * num) >> 0x10;
		num4 = (num4 * num) >> 0x10;
		num3 = (num3 * num) >> 0x10;
		num2 = (num2 * num) >> 0x10;

		if (num5 > 0xff)
		{
			num5 = 0xff;
		}

		if (num4 > 0xff)
		{
			num4 = 0xff;
		}

		if (num3 > 0xff)
		{
			num3 = 0xff;
		}

		if (num2 > 0xff)
		{
			num2 = 0xff;
		}

		color.packedValue = ((num5 | (num4 << 8)) | (num3 << 0x10)) | (num2 << 0x18);
		return color;
	}

	static int InitializeFromArgb(byte a, byte r, byte g, byte b)
	{
		return (int)(a << 24) + (int)(r << 16) + (int)(g << 8) + b;
	}

	private static int PackHelper(float vectorX, float vectorY, float vectorZ, float vectorW)
	{
		int num4 = PackUtils.PackUNorm(255f, vectorX);
		int num3 = PackUtils.PackUNorm(255f, vectorY) << 8;
		int num2 = PackUtils.PackUNorm(255f, vectorZ) << 0x10;
		int num = PackUtils.PackUNorm(255f, vectorW) << 0x18;

		return (((num4 | num3) | num2) | num);
	}

	/**
	 * Gets a string representation of this object.
	 */
	@Override
	public String toString()
	{
		return String.format(Locale.getDefault(), "{R:%d G:%d B:%d A:%d}", this.R(), this.G(), this.B(), this.A());
	}

	/**
	 * Gets a three-component vector representation for this object.
	 */
	public Vector3 ToVector3()
	{
		Vector3 vector = new Vector3();
		vector.X = PackUtils.UnpackUNorm(0xff, this.packedValue);
		vector.Y = PackUtils.UnpackUNorm(0xff, this.packedValue >> 8);
		vector.Z = PackUtils.UnpackUNorm(0xff, this.packedValue >> 0x10);
		return vector;
	}

	/**
	 * Gets a four-component vector representation for this object.
	 */
	public Vector4 ToVector4()
	{
		Vector4 vector = new Vector4();
		vector.X = PackUtils.UnpackUNorm(0xff, this.packedValue);
		vector.Y = PackUtils.UnpackUNorm(0xff, this.packedValue >> 8);
		vector.Z = PackUtils.UnpackUNorm(0xff, this.packedValue >> 0x10);
		vector.W = PackUtils.UnpackUNorm(0xff, this.packedValue >> 0x18);
		return vector;
	}

	/**
	 * Gets the Alpha component of this Color.
	 */
	public short A()
	{
		return (short)((this.packedValue >> 0x18) & 0xFF);
	}
	/**
	 * Gets a system-defined color with the value R:240 G:248 B:255 A:255.
	 */
	public static final Color AliceBlue = new Color(0xfffff8f0);
	/**
	 * Gets a system-defined color with the value R:250 G:235 B:215 A:255.
	 */
	public static final Color AntiqueWhite = new Color(0xffd7ebfa);
	/**
	 * Gets a system-defined color with the value R:0 G:255 B:255 A:255.
	 */
	public static final Color Aqua = new Color(0xffffff00);
	/**
	 * Gets a system-defined color with the value R:127 G:255 B:212 A:255.
	 */
	public static final Color Aquamarine = new Color(0xffd4ff7f);
	/**
	 * Gets a system-defined color with the value R:240 G:255 B:255 A:255.
	 */
	public static final Color Azure = new Color(0xfffffff0);
	/**
	 * Gets the Blue component of this Color.
	 */
	public short B()
	{
		return (short)(this.packedValue & 0xFF);
	}
	/**
	 * Gets a system-defined color with the value R:245 G:245 B:220 A:255.
	 */
	public static final Color Beige = new Color(0xffdcf5f5);
	/**
	 * Gets a system-defined color with the value R:255 G:228 B:196 A:255.
	 */
	public static final Color Bisque = new Color(0xffc4e4ff);
	/**
	 * Gets a system-defined color with the value R:0 G:0 B:0 A:255.
	 */
	public static final Color Black = new Color(0xff000000);
	/**
	 * Gets a system-defined color with the value R:255 G:235 B:205 A:255.
	 */
	public static final Color BlanchedAlmond = new Color(0xffcdebff);
	/**
	 * Gets a system-defined color with the value R:0 G:0 B:255 A:255.
	 */
	public static final Color Blue = new Color(0xffff0000);
	/**
	 * Gets a system-defined color with the value R:138 G:43 B:226 A:255.
	 */
	public static final Color BlueViolet = new Color(0xffe22b8a);
	/**
	 * Gets a system-defined color with the value R:165 G:42 B:42 A:255.
	 */
	public static final Color Brown = new Color(0xffa22aa5);
	/**
	 * Gets a system-defined color with the value R:222 G:184 B:135 A:255.
	 */
	public static final Color BurlyWood = new Color(0xff87b8de);
	/**
	 * Gets a system-defined color with the value R:95 G:158 B:160 A:255.
	 */
	public static final Color CadetBlue = new Color(0xffa09e5f);
	/**
	 * Gets a system-defined color with the value R:127 G:255 B:0 A:255.
	 */
	public static final Color Chartreuse = new Color(0xff00ff7f);
	/**
	 * Gets a system-defined color with the value R:210 G:105 B:30 A:255.
	 */
	public static final Color Chocolate = new Color(0xff1e69d2);
	/**
	 * Gets a system-defined color with the value R:255 G:127 B:80 A:255.
	 */
	public static final Color Coral = new Color(0xff507fff);
	/**
	 * Gets a system-defined color with the value R:100 G:149 B:237 A:255.
	 */
	public static final Color CornflowerBlue = new Color(0xFF6495ED);
	/**
	 * Gets a system-defined color with the value R:255 G:248 B:220 A:255.
	 */
	public static final Color Cornsilk = new Color(0xffdcf8ff);
	/**
	 * Gets a system-defined color with the value R:220 G:20 B:60 A:255.
	 */
	public static final Color Crimson = new Color(0xff3c14dc);
	/**
	 * Gets a system-defined color with the value R:0 G:255 B:255 A:255.
	 */
	public static final Color Cyan = new Color(0xffffff00);
	/**
	 * Gets a system-defined color with the value R:0 G:0 B:139 A:255.
	 */
	public static final Color DarkBlue = new Color(0xff8b0000);
	/**
	 * Gets a system-defined color with the value R:0 G:139 B:139 A:255.
	 */
	public static final Color DarkCyan = new Color(0xff8b8b00);
	/**
	 * Gets a system-defined color with the value R:184 G:134 B:11 A:255.
	 */
	public static final Color DarkGoldenrod = new Color(0xff0b86b8);
	/**
	 * Gets a system-defined color with the value R:169 G:169 B:169 A:255.
	 */
	public static final Color DarkGray = new Color(0xffa9a9a9);
	/**
	 * Gets a system-defined color with the value R:0 G:100 B:0 A:255.
	 */
	public static final Color DarkGreen = new Color(0xff006400);
	/**
	 * Gets a system-defined color with the value R:189 G:183 B:107 A:255.
	 */
	public static final Color DarkKhaki = new Color(0xff6bb7bd);
	/**
	 * Gets a system-defined color with the value R:139 G:0 B:139 A:255.
	 */
	public static final Color DarkMagenta = new Color(0xff8b008b);
	/**
	 * Gets a system-defined color with the value R:85 G:107 B:47 A:255.
	 */
	public static final Color DarkOliveGreen = new Color(0xff2f6b55);
	/**
	 * Gets a system-defined color with the value R:255 G:140 B:0 A:255.
	 */
	public static final Color DarkOrange = new Color(0xff008cff);
	/**
	 * Gets a system-defined color with the value R:153 G:50 B:204 A:255.
	 */
	public static final Color DarkOrchid = new Color(0xffcc3299);
	/**
	 * Gets a system-defined color with the value R:139 G:0 B:0 A:255.
	 */
	public static final Color DarkRed = new Color(0xff00008b);
	/**
	 * Gets a system-defined color with the value R:233 G:150 B:122 A:255.
	 */
	public static final Color DarkSalmon = new Color(0xff7a96e9);
	/**
	 * Gets a system-defined color with the value R:143 G:188 B:139 A:255.
	 */
	public static final Color DarkSeaGreen = new Color(0xff8bbc8f);
	/**
	 * Gets a system-defined color with the value R:72 G:61 B:139 A:255.
	 */
	public static final Color DarkSlateBlue = new Color(0xff8b3d48);
	/**
	 * Gets a system-defined color with the value R:47 G:79 B:79 A:255.
	 */
	public static final Color DarkSlateGray = new Color(0xff4f4f2f);
	/**
	 * Gets a system-defined color with the value R:0 G:206 B:209 A:255.
	 */
	public static final Color DarkTurquoise = new Color(0xffd1ce00);
	/**
	 * Gets a system-defined color with the value R:148 G:0 B:211 A:255.
	 */
	public static final Color DarkViolet = new Color(0xffd30094);
	/**
	 * Gets a system-defined color with the value R:255 G:20 B:147 A:255.
	 */
	public static final Color DeepPink = new Color(0xff9314ff);
	/**
	 * Gets a system-defined color with the value R:0 G:191 B:255 A:255.
	 */
	public static final Color DeepSkyBlue = new Color(0xffffbf00);
	/**
	 * Gets a system-defined color with the value R:105 G:105 B:105 A:255.
	 */
	public static final Color DimGray = new Color(0xff696969);
	/**
	 * Gets a system-defined color with the value R:30 G:144 B:255 A:255.
	 */
	public static final Color DodgerBlue = new Color(0xffff901e);
	/**
	 * Gets a system-defined color with the value R:178 G:34 B:34 A:255.
	 */
	public static final Color Firebrick = new Color(0xff2222b2);
	/**
	 * Gets a system-defined color with the value R:255 G:250 B:240 A:255.
	 */
	public static final Color FloralWhite = new Color(0xfff0faff);
	/**
	 * Gets a system-defined color with the value R:34 G:139 B:34 A:255.
	 */
	public static final Color ForestGreen = new Color(0xff228b22);
	/**
	 * Gets a system-defined color with the value R:255 G:0 B:255 A:255.
	 */
	public static final Color Fuchsia = new Color(0xffff00ff);
	/**
	 * Gets the Green component of this Color.
	 */
	public short G()
	{
		return (short)((this.packedValue >> 8) & 0xFF);
	}
	/**
	 * Gets a system-defined color with the value R:220 G:220 B:220 A:255.
	 */
	public static final Color Gainsboro = new Color(0xffdcdcdc);
	/**
	 * Gets a system-defined color with the value R:248 G:248 B:255 A:255.
	 */
	public static final Color GhostWhite = new Color(0xfff8f8ff);
	/**
	 * Gets a system-defined color with the value R:255 G:215 B:0 A:255.
	 */
	public static final Color Gold = new Color(0xff00d7ff);
	/**
	 * Gets a system-defined color with the value R:218 G:165 B:32 A:255.
	 */
	public static final Color Goldenrod = new Color(0xff20a5da);
	/**
	 * Gets a system-defined color with the value R:128 G:128 B:128 A:255.
	 */
	public static final Color Gray = new Color(0xff808080);
	/**
	 * Gets a system-defined color with the value R:0 G:128 B:0 A:255.
	 */
	public static final Color Green = new Color(0xff008000);
	/**
	 * Gets a system-defined color with the value R:173 G:255 B:47 A:255.
	 */
	public static final Color GreenYellow = new Color(0xff2fffad);
	/**
	 * Gets a system-defined color with the value R:240 G:255 B:240 A:255.
	 */
	public static final Color HoneyDew = new Color(0xfff0fff0);
	/**
	 * Gets a system-defined color with the value R:255 G:105 B:180 A:255.
	 */
	public static final Color HotPink = new Color(0xffb469ff);
	/**
	 * Gets a system-defined color with the value R:205 G:92 B:92 A:255.
	 */
	public static final Color IndianRed = new Color(0xff5c5ccd);
	/**
	 * Gets a system-defined color with the value R:75 G:0 B:130 A:255.
	 */
	public static final Color Indigo = new Color(0xff82004b);
	/**
	 * Gets a system-defined color with the value R:255 G:255 B:240 A:255.
	 */
	public static final Color Ivory = new Color(0xfff0ffff);
	/**
	 * Gets a system-defined color with the value R:240 G:230 B:140 A:255.
	 */
	public static final Color Khaki = new Color(0xff8ce6f0);
	/**
	 * Gets a system-defined color with the value R:230 G:230 B:250 A:255.
	 */
	public static final Color Lavender = new Color(0xfffae6e6);
	/**
	 * Gets a system-defined color with the value R:255 G:240 B:245 A:255.
	 */
	public static final Color LavenderBlush = new Color(0xfff5f0ff);
	/**
	 * Gets a system-defined color with the value R:124 G:252 B:0 A:255.
	 */
	public static final Color LawnGreen = new Color(0xff00fc7c);
	/**
	 * Gets a system-defined color with the value R:255 G:250 B:205 A:255.
	 */
	public static final Color LemonChiffon = new Color(0xffcdfaff);
	/**
	 * Gets a system-defined color with the value R:173 G:216 B:230 A:255.
	 */
	public static final Color LightBlue = new Color(0xffe6d8ad);
	/**
	 * Gets a system-defined color with the value R:240 G:128 B:128 A:255.
	 */
	public static final Color LightCoral = new Color(0xff8080f0);
	/**
	 * Gets a system-defined color with the value R:224 G:255 B:255 A:255.
	 */
	public static final Color LightCyan = new Color(0xffffffe0);
	/**
	 * Gets a system-defined color with the value R:250 G:250 B:210 A:255.
	 */
	public static final Color LightGoldenrodYellow = new Color(0xffd2fafa);
	/**
	 * Gets a system-defined color with the value R:211 G:211 B:211 A:255.
	 */
	public static final Color LightGray = new Color(0xffd3d3d3);
	/**
	 * Gets a system-defined color with the value R:144 G:238 B:144 A:255.
	 */
	public static final Color LightGreen = new Color(0xff90ee90);
	/**
	 * Gets a system-defined color with the value R:255 G:182 B:193 A:255.
	 */
	public static final Color LightPink = new Color(0xffc1b6ff);
	/**
	 * Gets a system-defined color with the value R:255 G:160 B:122 A:255.
	 */
	public static final Color LightSalmon = new Color(0xff7aa0ff);
	/**
	 * Gets a system-defined color with the value R:32 G:178 B:170 A:255.
	 */
	public static final Color LightSeaGreen = new Color(0xffaab220);
	/**
	 * Gets a system-defined color with the value R:135 G:206 B:250 A:255.
	 */
	public static final Color LightSkyBlue = new Color(0xffface87);
	/**
	 * Gets a system-defined color with the value R:119 G:136 B:153 A:255.
	 */
	public static final Color LightSlateBlue = new Color(0xff998877);
	/**
	 * Gets a system-defined color with the value R:176 G:196 B:222 A:255.
	 */
	public static final Color LightSteelBlue = new Color(0xffdec4b0);
	/**
	 * Gets a system-defined color with the value R:255 G:255 B:224 A:255.
	 */
	public static final Color LightYellow = new Color(0xffe0ffff);
	/**
	 * Gets a system-defined color with the value R:0 G:255 B:0 A:255.
	 */
	public static final Color Lime = new Color(0xff00ff00);
	/**
	 * Gets a system-defined color with the value R:50 G:205 B:50 A:255.
	 */
	public static final Color LimeGreen = new Color(0xff32cd32);
	/**
	 * Gets a system-defined color with the value R:250 G:240 B:230 A:255.
	 */
	public static final Color Linen = new Color(0xffe6f0fa);
	/**
	 * Gets a system-defined color with the value R:255 G:0 B:255 A:255.
	 */
	public static final Color Magenta = new Color(0xffff00ff);
	/**
	 * Gets a system-defined color with the value R:128 G:0 B:0 A:255.
	 */
	public static final Color Maroon = new Color(0xff000080);
	/**
	 * Gets a system-defined color with the value R:102 G:205 B:170 A:255.
	 */
	public static final Color MediumAquamarine = new Color(0xffaacd66);
	/**
	 * Gets a system-defined color with the value R:0 G:0 B:205 A:255.
	 */
	public static final Color MediumBlue = new Color(0xffcd0000);
	/**
	 * Gets a system-defined color with the value R:186 G:85 B:211 A:255.
	 */
	public static final Color MediumOrchid = new Color(0xffd355ba);
	/**
	 * Gets a system-defined color with the value R:147 G:112 B:219 A:255.
	 */
	public static final Color MediumPurple = new Color(0xffdb7093);
	/**
	 * Gets a system-defined color with the value R:60 G:179 B:113 A:255.
	 */
	public static final Color MediumSeaGreen = new Color(0xff71b33c);
	/**
	 * Gets a system-defined color with the value R:123 G:104 B:238 A:255.
	 */
	public static final Color MediumSlateBlue = new Color(0xffee687b);
	/**
	 * Gets a system-defined color with the value R:0 G:250 B:154 A:255.
	 */
	public static final Color MediumSpringGreen = new Color(0xff9afa00);
	/**
	 * Gets a system-defined color with the value R:72 G:209 B:204 A:255.
	 */
	public static final Color MediumTurquoise = new Color(0xffccd148);
	/**
	 * Gets a system-defined color with the value R:199 G:21 B:133 A:255.
	 */
	public static final Color MediumVioletRed = new Color(0xff8515c7);
	/**
	 * Gets a system-defined color with the value R:25 G:25 B:112 A:255.
	 */
	public static final Color MidnightBlue = new Color(0xff701919);
	/**
	 * Gets a system-defined color with the value R:245 G:255 B:250 A:255.
	 */
	public static final Color MintCream = new Color(0xfffafff5);
	/**
	 * Gets a system-defined color with the value R:255 G:228 B:225 A:255.
	 */
	public static final Color MistyRose = new Color(0xffe1e4ff);
	/**
	 * Gets a system-defined color with the value R:255 G:228 B:181 A:255.
	 */
	public static final Color Moccasin = new Color(0xffb5e4ff);
	/**
	 * Gets a system-defined color with the value R:255 G:222 B:173 A:255.
	 */
	public static final Color NavajoWhite = new Color(0xffaddeff);
	/**
	 * Gets a system-defined color R:0 G:0 B:128 A:255.
	 */
	public static final Color Navy = new Color(0xff800000);
	/**
	 * Gets a system-defined color with the value R:253 G:245 B:230 A:255.
	 */
	public static final Color OldLace = new Color(0xffe6f5fd);
	/**
	 * Gets a system-defined color with the value R:128 G:128 B:0 A:255.
	 */
	public static final Color Olive = new Color(0xff008080);
	/**
	 * Gets a system-defined color with the value R:107 G:142 B:35 A:255.
	 */
	public static final Color OliveDrab = new Color(0xff238e6b);
	/**
	 * Gets a system-defined color with the value R:255 G:165 B:0 A:255.
	 */
	public static final Color Orange = new Color(0xff00a5ff);
	/**
	 * Gets a system-defined color with the value R:255 G:69 B:0 A:255.
	 */
	public static final Color OrangeRed = new Color(0xff0045ff);
	/**
	 * Gets a system-defined color with the value R:218 G:112 B:214 A:255.
	 */
	public static final Color Orchid = new Color(0xffd670da);
	/**
	 * 
	 * @return
	 */
	public int getPackedValue()
	{
		return this.packedValue;
	}
	/**
	 * Gets a system-defined color with the value R:238 G:232 B:170 A:255.
	 */
	public static final Color PaleGoldenrod = new Color(0xffaae8ee);
	/**
	 * Gets a system-defined color with the value R:152 G:251 B:152 A:255.
	 */
	public static final Color PaleGreen = new Color(0xff98fb98);
	/**
	 * Gets a system-defined color with the value R:175 G:238 B:238 A:255.
	 */
	public static final Color PaleTurquoise = new Color(0xffeeeeaf);
	/**
	 * Gets a system-defined color with the value R:219 G:112 B:147 A:255.
	 */
	public static final Color PaleVioletRed = new Color(0xff9370db);
	/**
	 * Gets a system-defined color with the value R:255 G:239 B:213 A:255.
	 */
	public static final Color PapayaWhip = new Color(0xffd5efff);
	/**
	 * Gets a system-defined color with the value R:255 G:218 B:185 A:255.
	 */
	public static final Color PeachPuff = new Color(0xffb9daff);
	/**
	 * Gets a system-defined color with the value R:205 G:133 B:63 A:255.
	 */
	public static final Color Peru = new Color(0xff3f85cd);
	/**
	 * Gets a system-defined color with the value R:255 G:192 B:203 A:255.
	 */
	public static final Color Pink = new Color(0xffcbc0ff);
	/**
	 * Gets a system-defined color with the value R:221 G:160 B:221 A:255.
	 */
	public static final Color Plum = new Color(0xffdda0dd);
	/**
	 * Gets a system-defined color with the value R:176 G:224 B:230 A:255.
	 */
	public static final Color PowderBlue = new Color(0xffe6e0b0);
	/**
	 * Gets a system-defined color with the value R:128 G:0 B:128 A:255.
	 */
	public static final Color Purple = new Color(0xff800080);
	/**
	 * Gets the Red component of this Color.
	 */
	public short R()
	{
		return (short)((this.packedValue >> 16) & 0xFF);
	}
	/**
	 * Gets a system-defined color with the value R:255 G:0 B:0 A:255.
	 */
	public static final Color Red = new Color(0xff0000ff);
	/**
	 * Gets a system-defined color with the value R:188 G:143 B:143 A:255.
	 */
	public static final Color RosyBrown = new Color(0xff8f8fbc);
	/**
	 * Gets a system-defined color with the value R:65 G:105 B:225 A:255.
	 */
	public static final Color RoyalBlue = new Color(0xffe16941);
	/**
	 * Gets a system-defined color with the value R:139 G:69 B:19 A:255.
	 */
	public static final Color SaddleBrown = new Color(0xff13458b);
	/**
	 * Gets a system-defined color with the value R:250 G:128 B:114 A:255.
	 */
	public static final Color Salmon = new Color(0xff7280fa);
	/**
	 * Gets a system-defined color with the value R:244 G:164 B:96 A:255.
	 */
	public static final Color SandyBrown = new Color(0xff60a4f4);
	/**
	 * Gets a system-defined color with the value R:46 G:139 B:87 A:255.
	 */
	public static final Color SeaGreen = new Color(0xff578b2e);
	/**
	 * Gets a system-defined color with the value R:255 G:245 B:238 A:255.
	 */
	public static final Color SeaShell = new Color(0xffeef5ff);
	/**
	 * Gets a system-defined color with the value R:160 G:82 B:45 A:255.
	 */
	public static final Color Sienna = new Color(0xff2d52a0);
	/**
	 * Gets a system-defined color with the value R:192 G:192 B:192 A:255.
	 */
	public static final Color Silver = new Color(0xffc0c0c0);
	/**
	 * Gets a system-defined color with the value R:135 G:206 B:235 A:255.
	 */
	public static final Color SkyBlue = new Color(0xffebce87);
	/**
	 * Gets a system-defined color with the value R:106 G:90 B:205 A:255.
	 */
	public static final Color SlateBlue = new Color(0xffcd5a6a);
	/**
	 * Gets a system-defined color with the value R:112 G:128 B:144 A:255.
	 */
	public static final Color SlateGray = new Color(0xff908070);
	/**
	 * Gets a system-defined color with the value R:255 G:250 B:250 A:255.
	 */
	public static final Color Snow = new Color(0xfffafaff);
	/**
	 * Gets a system-defined color with the value R:0 G:255 B:127 A:255.
	 */
	public static final Color SpringGreen = new Color(0xff7fff00);
	/**
	 * Gets a system-defined color with the value R:70 G:130 B:180 A:255.
	 */
	public static final Color SteelBlue = new Color(0xffb48246);
	/**
	 * Gets a system-defined color with the value R:210 G:180 B:140 A:255.
	 */
	public static final Color Tan = new Color(0xff8cb4d2);
	/**
	 * Gets a system-defined color with the value R:0 G:128 B:128 A:255.
	 */
	public static final Color Teal = new Color(0xff808000);
	/**
	 * Gets a system-defined color with the value R:216 G:191 B:216 A:255.
	 */
	public static final Color Thistle = new Color(0xffd8bfd8);
	/**
	 * Gets a system-defined color with the value R:255 G:99 B:71 A:255.
	 */
	public static final Color Tomato = new Color(0xff4763ff);
	/**
	 * Gets a system-defined color with the value R:0 G:0 B:0 A:0.
	 */
	public static final Color Transparent = new Color(0);
	/**
	 * Gets a system-defined color with the value R:64 G:224 B:208 A:255.
	 */
	public static final Color Turquoise = new Color(0xffd0e040);
	/**
	 * Gets a system-defined color with the value R:238 G:130 B:238 A:255.
	 */
	public static final Color Violet = new Color(0xffee82ee);
	/**
	 * Gets a system-defined color with the value R:245 G:222 B:179 A:255.
	 */
	public static final Color Wheat = new Color(0xffb3def5);
	/**
	 * Gets a system-defined color with the value R:255 G:255 B:255 A:255.
	 */
	public static final Color White = new Color(0xffffffff);
	/**
	 * Gets a system-defined color with the value R:245 G:245 B:245 A:255.
	 */
	public static final Color WhiteSmoke = new Color(0xfff5f5f5);
	/**
	 * Gets a system-defined color with the value R:255 G:255 B:0 A:255.
	 */
	public static final Color Yellow = new Color(0xff00ffff);
	/**
	 * Gets a system-defined color with the value R:154 G:205 B:50 A:255.
	 */
	public static final Color YellowGreen = new Color(0xff32cd9a);

	public void setPackedValue(int packedValue)
	{
		this.packedValue = packedValue;
	}
}
