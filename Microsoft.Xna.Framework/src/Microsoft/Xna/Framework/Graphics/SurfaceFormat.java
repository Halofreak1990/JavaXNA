package Microsoft.Xna.Framework.Graphics;

/**
 * Defines various types of surface formats.
 * 
 * @author Halofreak1990
 */
public enum SurfaceFormat
{
	/**
	 * (Unsigned format) 32-bit ARGB pixel format with alpha, using 8 bits per channel.
	 */
	Color,
	/**
	 * (Unsigned format) 16-bit BGR pixel format with 5 bits for blue, 6 bits for green, and 5 bits for red.
	 */
	Bgr565,
	/**
	 * (Unsigned format) 16-bit BGRA pixel format where 5 bits are reserved for each color and 1 bit is reserved for alpha.
	 */
	Bgra5551,
	/**
	 * (Unsigned format) 16-bit BGRA pixel format with 4 bits for each channel.
	 */
	Bgra4444,
	/**
	 * DXT1 compression texture format. The runtime will not allow an application to create a surface using a DXTn format unless the surface dimensions are multiples
	 * of 4. This applies to offscreen-plain surfaces, render targets, 2D textures, cube textures, and volume textures.
	 */
	Dxt1,
	/**
	 * DXT3 compression texture format. The runtime will not allow an application to create a surface using a DXTn format unless the surface dimensions are multiples
	 * of 4. This applies to offscreen-plain surfaces, render targets, 2D textures, cube textures, and volume textures.
	 */
	Dxt3,
	/**
	 * DXT5 compression texture format. The runtime will not allow an application to create a surface using a DXTn format unless the surface dimensions are multiples
	 * of 4. This applies to offscreen-plain surfaces, render targets, 2D textures, cube textures, and volume textures.
	 */
	Dxt5,
	/**
	 * (Signed format) 16-bit bump-map format using 8 bits each for u and v data.
	 */
	NormalizedByte2,
	/**
	 * (Signed format) 32-bit bump-map format using 8 bits for each channel.
	 */
	NormalizedByte4,
	/**
	 * (Unsigned format) 32-bit RGBA pixel format using 10 bits for each color and 2 bits for alpha.(Unsigned format) 32-bit RGBA pixel format using 10 bits for each color and 2 bits for alpha.
	 */
	Rgba1010102,
	/**
	 * (Unsigned format) 32-bit pixel format using 16 bits each for red and green.
	 */
	Rg32,
	/**
	 * (Unsigned format) 64-bit RGBA pixel format using 16 bits for each component.
	 */
	Rgba64,
	/**
	 * (Unsigned format) 8-bit alpha only.
	 */
	Alpha8,
	/**
	 * (IEEE format) 32-bit float format using 32 bits for the red channel.
	 */
	Single,
	/**
	 * (IEEE format) 64-bit float format using 32 bits for the red channel and 32 bits for the green channel.
	 */
	Vector2,
	/**
	 * (IEEE format) 128-bit float format using 32 bits for each channel (alpha, blue, green, red).
	 */
	Vector4,
	/**
	 * (Floating-point format) 16-bit float format using 16 bits for the red channel.
	 */
	HalfSingle,
	/**
	 * (Floating-point format) 32-bit float format using 16 bits for the red channel and 16 bits for the green channel.
	 */
	HalfVector2,
	/**
	 * (Floating-point format) 64-bit float format using 16 bits for each channel (alpha, blue, green, red).
	 */
	HalfVector4,
	/**
	 * (Floating-point format) for high dynamic range data.
	 */
	HdrBlendable,
}
