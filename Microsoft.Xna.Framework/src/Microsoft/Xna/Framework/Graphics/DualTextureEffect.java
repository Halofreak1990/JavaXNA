package Microsoft.Xna.Framework.Graphics;

import java.util.EnumSet;

import Microsoft.Xna.Framework.*;

/**
 * Contains a configurable effect that supports two-layer multitexturing.
 * 
 * @author Halofreak1990
 */
public class DualTextureEffect extends Effect implements IEffectMatrices, IEffectFog
{
	private float alpha;
	private Vector3 diffuseColor;
	private EnumSet<EffectDirtyFlags> dirtyFlags;
	private EffectParameter diffuseColorParam;
	private EffectParameter fogColorParam;
	private EffectParameter fogVectorParam;
	private EffectParameter texture2Param;
	private EffectParameter textureParam;
	private Matrix view;
	private Matrix world;

	/**
	 * Gets the material alpha which determines its transparency.
	 * 
	 * @return
	 * The material alpha which determines its transparency.
	 */
	public float getAlpha()
	{
		return alpha;
	}

	/**
	 * Sets the material alpha which determines its transparency. Range is between 1 (fully opaque) and 0 (fully transparent).
	 * 
	 * @param value
	 * The new alpha value.
	 */
	public void setAlpha(float value)
	{
		this.alpha = value;
		this.dirtyFlags.add(EffectDirtyFlags.MaterialColor);
	}

	/**
	 * Gets the diffuse color for a material.
	 * 
	 * @return
	 * The diffuse color for a material.
	 */
	public Vector3 getDiffuseColor()
	{
		return this.diffuseColor;
	}

	/**
	 * Sets the diffuse color for a material, the range of color values is from 0 to 1.
	 * 
	 * @param value
	 * The new diffuse color.
	 */
	public void setDiffuseColor(Vector3 value)
	{
		this.diffuseColor = value;
		this.dirtyFlags.add(EffectDirtyFlags.MaterialColor);
	}

	@Override
	public Vector3 getFogColor()
	{
		return this.fogColorParam.GetValueVector3();
	}

	@Override
	public void setFogColor(Vector3 value)
	{
		this.fogColorParam.SetValue(value);
	}

	@Override
	public boolean FogEnabled()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFogEnabled(boolean value)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public float getFogEnd()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFogEnd(float value)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public float getFogStart()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFogStart(float value)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public Matrix getProjection()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProjection(Matrix value)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Gets the current base texture.
	 * 
	 * @return
	 * The current base texture.
	 */
	public Texture2D getTexture()
	{
		return this.textureParam.GetValueTexture2D();
	}

	/**
	 * Sets the current base texture.
	 * 
	 * @param value
	 * The new base texture.
	 */
	public void setTexture(Texture2D value)
	{
		this.textureParam.SetValue(value);
	}

	/**
	 * Gets the current overlay texture.
	 * 
	 * @return
	 * The current base texture.
	 */
	public Texture2D getTexture2()
	{
		return this.texture2Param.GetValueTexture2D();
	}

	/**
	 * Sets the current overlay texture.
	 * 
	 * @param value
	 * The new overlay texture.
	 */
	public void setTexture2(Texture2D value)
	{
		this.texture2Param.SetValue(value);
	}

	/**
	 * Gets the view matrix.
	 * 
	 * @return
	 * The view matrix.
	 */
	@Override
	public Matrix getView()
	{
		return view;
	}

	/**
	 * Sets the view matrix.
	 * 
	 * @param value
	 * The new view matrix.
	 */
	@Override
	public void setView(Matrix value)
	{
		this.view = value;
		this.dirtyFlags.add(EffectDirtyFlags.Fog);
		this.dirtyFlags.add(EffectDirtyFlags.WorldViewProj);
	}

	/**
	 * Gets the world matrix.
	 * 
	 * @return
	 * The world matrix.
	 */
	@Override
	public Matrix getWorld()
	{
		return world;
	}

	/**
	 * Sets the world matrix.
	 * 
	 * @param value
	 * The new world matrix.
	 */
	@Override
	public void setWorld(Matrix value)
	{
		this.world = value;
		this.dirtyFlags.add(EffectDirtyFlags.Fog);
		this.dirtyFlags.add(EffectDirtyFlags.WorldViewProj);
	}

	/**
	 * Creates a new DualTextureEffect by cloning parameter settings from an existing instance.
	 * 
	 * @param cloneSource
	 * The object to clone.
	 */
	protected DualTextureEffect(DualTextureEffect cloneSource)
	{
		super(cloneSource);

		this.diffuseColor = Vector3.One;
		this.world = cloneSource.world;
		this.view = cloneSource.view;
	}

	/**
	 * Creates a new DualTextureEffect with default parameter settings.
	 * 
	 * @param device
	 * The graphics device.
	 */
	public DualTextureEffect(GraphicsDevice device)
	{
		super(device, effectCode);
	}

	/**
	 * Computes derived parameter values immediately before applying the effect.
	 */
	@Override
	protected void OnApply()
	{
		
	}

	/**
	 * Creates a clone of the current DualTextureEffect instance.
	 */
	@Override
	public Effect Clone()
	{
		return new DualTextureEffect(this);
	}

	private static final byte[] effectCode = new byte[0]; // TODO: fill in
}
