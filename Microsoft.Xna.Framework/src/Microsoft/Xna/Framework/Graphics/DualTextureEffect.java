package Microsoft.Xna.Framework.Graphics;

import Microsoft.Xna.Framework.*;

/**
 * 
 * @author Halofreak1990
 */
public class DualTextureEffect extends Effect implements IEffectMatrices, IEffectFog
{
	private Vector3 diffuseColor;
	private EffectParameter diffuseColorParam;
	private Matrix view;
	private Matrix world;

	@Override
	public Vector3 getFogColor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFogColor(Vector3 value)
	{
		// TODO Auto-generated method stub

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

	@Override
	public Matrix getView()
	{
		return view;
	}

	@Override
	public void setView(Matrix value)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Matrix getWorld()
	{
		return world;
	}

	@Override
	public void setWorld(Matrix value)
	{
		// TODO Auto-generated method stub

	}
	
	protected DualTextureEffect(DualTextureEffect cloneSource)
	{
		super(cloneSource);
		
		this.diffuseColor = Vector3.One;
		this.world = cloneSource.world;
		this.view = cloneSource.view;
	}
	
	/**
	 * 
	 * @param device
	 */
	public DualTextureEffect(GraphicsDevice device)
	{
		super(device, null);
	}
	
	/**
	 * Computes derived parameter values immediately before applying the effect.
	 */
	@Override
	protected void OnApply()
	{
		
	}
	
	/**
	 * 
	 */
	@Override
	public Effect Clone()
	{
		return new DualTextureEffect(this);
	}
}
