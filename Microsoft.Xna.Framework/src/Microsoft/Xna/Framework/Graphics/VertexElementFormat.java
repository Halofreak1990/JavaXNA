package Microsoft.Xna.Framework.Graphics;

/**
 * Defines vertex element formats.
 * 
 * @author Halofreak1990
 */
public enum VertexElementFormat
{
	/**
	 * Single-component, 32-bit floating-point, expanded to (float, 0, 0, 1).
	 */
	Single,
	/**
	 * Two-component, 32-bit floating-point, expanded to (float, Float32 value, 0, 1).
	 */
	Vector2,
	/**
	 * Three-component, 32-bit floating point, expanded to (float, float, float, 1).
	 */
	Vector3,
	/**
	 * Four-component, 32-bit floating point, expanded to (float, float, float, float).
	 */
	Vector4,
	/**
	 * Four-component, packed, unsigned byte, mapped to 0 to 1 range. Input is in Int32 format (ARGB) expanded to (R, G, B, A).
	 */
	Color,
	/**
	 * Four-component, unsigned byte.
	 */
	Byte4,
	/**
	 * Two-component, signed short expanded to (value, value, 0, 1).
	 */
	Short2,
	/**
	 * Four-component, signed short expanded to (value, value, value, value).
	 */
	Short4,
	/**
	 * Normalized, two-component, signed short, expanded to (first short/32767.0, second short/32767.0, 0, 1). This type is valid for vertex shader version 2.0 or higher.
	 */
	NormalizedShort2,
	/**
	 * Normalized, four-component, signed short, expanded to (first short/32767.0, second short/32767.0, third short/32767.0, fourth short/32767.0). This type is valid for
	 * vertex shader version 2.0 or higher.
	 */
	NormalizedShort4,
	/**
	 * Two-component, 16-bit floating point expanded to (value, value, value, value). This type is valid for vertex shader version 2.0 or higher.
	 */
	HalfVector2,
	/**
	 * Four-component, 16-bit floating-point expanded to (value, value, value, value). This type is valid for vertex shader version 2.0 or higher.
	 */
	HalfVector4
}
