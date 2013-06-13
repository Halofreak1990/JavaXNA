package Microsoft.Xna.Framework.Graphics;

/**
 * Defines filtering types during texture sampling.
 * 
 * @author Halofreak1990
 */
public enum TextureFilter
{
	/**
	 * Use linear filtering.
	 */
	Linear,
	/**
	 * Use point filtering.
	 */
    Point,
    /**
     * Use anisotropic filtering.
     */
    Anisotropic,
    /**
     * Use linear filtering to shrink or expand, and point filtering between mipmap levels (mip).
     */
    LinearMipPoint,
    /**
     * Use point filtering to shrink (minify) or expand (magnify), and linear filtering between mipmap levels.
     */
    PointMipLinear,
    /**
     * Use linear filtering to shrink, point filtering to expand, and linear filtering between mipmap levels.
     */
    MinLinearMagPointMipLinear,
    /**
     * Use linear filtering to shrink, point filtering to expand, and point filtering between mipmap levels.
     */
    MinLinearMagPointMipPoint,
    /**
     * Use point filtering to shrink, linear filtering to expand, and linear filtering between mipmap levels.
     */
    MinPointMagLinearMipLinear,
    /**
     * Use point filtering to shrink, linear filtering to expand, and point filtering between mipmap levels.
     */
    MinPointMagLinearMipPoint
}
