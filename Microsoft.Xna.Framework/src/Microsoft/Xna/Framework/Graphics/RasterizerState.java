package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

/**
 * Contains Rasterizer State, which determines how to convert vector data (shapes) into raster data (pixels).
 * 
 * @author Halofreak1990
 */
public class RasterizerState extends GraphicsResource
{
	CullMode cachedCullMode;
	float cachedDepthBias;
	private FillMode cachedFillMode;
	private boolean cachedScissorTestEnable;
	private boolean cachedMultiSampleAntiAlias;
	private float cachedSlopeScaleDepthBias;
	/**
	 * A built-in state object with settings for culling primitives with clockwise winding order.
	 */
	public static final RasterizerState CullClockwise;
	/**
	 * A built-in state object with settings for culling primitives with counter-clockwise winding order.
	 */
	public static final RasterizerState CullCounterClockwise;
	/**
	 * A built-in state object with settings for not culling any primitives.
	 */
	public static final RasterizerState CullNone;
	boolean isBound;
	
	public CullMode getCullMode()
	{
		return this.cachedCullMode;
	}
	
	/**
	 * Specifies the conditions for culling or removing triangles. The default value is CullMode.CounterClockwise.
	 * @param value
	 */
	public void setCullMode(CullMode value)
	{
		this.ThrowIfBound();
		this.cachedCullMode = value;
	}
	
	/**
	 * Retrieves the depth bias for polygons, which is the amount of bias to apply  to the depth of a primitive to alleviate depth testing problems for primitives of similar
	 * depth.
	 */
	public float getDepthBias()
	{
		return this.cachedDepthBias;
	}
	
	/**
	 * Sets the depth bias for polygons, which is the amount of bias to apply  to the depth of a primitive to alleviate depth testing problems for primitives of similar
	 * depth. The default value is 0.
	 */
	public void setDepthBias(float value)
	{
		this.ThrowIfBound();
		this.cachedDepthBias = value;
	}
	
	public FillMode getFillMode()
	{
		return this.cachedFillMode;
	}
	
	/**
	 * The fill mode, which defines how a triangle is filled during rendering. The default is FillMode.Solid.
	 */
	public void setFillMode(FillMode value)
	{
		this.ThrowIfBound();
		this.cachedFillMode = value;
	}
	
	public boolean getMultiSampleAntiAlias()
	{
		return this.cachedMultiSampleAntiAlias;
	}
	
	/**
	 * Enables or disables multisample antialiasing. The default is true.
	 */
	public void setMultiSampleAntiAlias(boolean value)
	{
		this.ThrowIfBound();
		this.cachedMultiSampleAntiAlias = value;
	}
	
	public boolean getScissorTestEnable()
	{
		return this.cachedScissorTestEnable;
	}
	
	/**
	 * Enables or disables scissor testing. The default is false.
	 */
	public void setScissorTestEnable(boolean value)
	{
		this.ThrowIfBound();
		this.cachedScissorTestEnable = value;
	}
	
	/**
	 * Gets a bias value that takes into account the slope of a polygon. This bias value is applied to coplanar primitives to reduce aliasing and other rendering artifacts
	 * caused by z-fighting.
	 */
	public float getSlopeScaleDepthBias()
	{
		return this.cachedSlopeScaleDepthBias;
	}
	
	/**
	 * Sets a bias value that takes into account the slope of a polygon. This bias value is applied to coplanar primitives to reduce aliasing and other rendering artifacts
	 * caused by z-fighting. The default is 0.
	 */
	public void setSlopeScaleDepthBias(float value)
	{
		this.ThrowIfBound();
		this.cachedSlopeScaleDepthBias = value;
	}
	
	private RasterizerState(CullMode cullMode, String name)
	{
		try
		{
			this.SetDefaults();
			this.ThrowIfBound();
			this.cachedCullMode = cullMode;
			super.Name = name;
			this.isBound = true;
		}
		finally
		{
			super.Dispose(true);
		}
	}
	
	private void SetDefaults()
	{
		this.ThrowIfBound();
		this.cachedCullMode = CullMode.CullCounterClockwiseFace;
		this.ThrowIfBound();
		this.cachedFillMode = FillMode.Solid;
		this.ThrowIfBound();
		this.cachedScissorTestEnable = false;
		this.ThrowIfBound();
		this.cachedMultiSampleAntiAlias = true;
		this.ThrowIfBound();
		this.cachedDepthBias = 0f;
		this.ThrowIfBound();
		this.cachedSlopeScaleDepthBias = 0f;
	}

	void ThrowIfBound()
	{
		if (this.isBound)
		{
			Object[] args = new Object[] { RasterizerState.class };
			throw new IllegalStateException(String.format(Locale.getDefault(), "Cannot change readonly %s. State objects become read-only the first time they are bound to a GraphicsDevice. To change property values, create a new %s instance", args));
		}
	}

	static
	{
		CullNone = new RasterizerState(CullMode.None, "RasterizerState.CullNone");
		CullClockwise = new RasterizerState(CullMode.CullClockwiseFace, "RasterizerState.CullClockwise");
		CullCounterClockwise = new RasterizerState(CullMode.CullCounterClockwiseFace, "RasterizerState.CullCounterClockwise");
	}
}
