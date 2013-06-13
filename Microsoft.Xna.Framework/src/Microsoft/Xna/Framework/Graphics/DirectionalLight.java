package Microsoft.Xna.Framework.Graphics;

import Microsoft.Xna.Framework.*;

/**
 * 
 * @author Halofreak1990
 */
public final class DirectionalLight
{
	private Vector3 diffuseColor;
	private EffectParameter diffuseColorParameter;
	private EffectParameter directionParameter;
	private EffectParameter specularColorParameter;
	
	/**
	 * Gets or sets the diffuse color of the light.
	 */
	public Vector3 getDiffuseColor()
	{
		return this.diffuseColor;
	}
	
	public void setDiffuseColor(Vector3 value)
	{
		if (this.Enabled && this.diffuseColorParameter != null)
		{
			this.diffuseColorParameter.SetValue(value);
		}
		this.diffuseColor = value;
	}
	
	/**
	 * Gets or sets the light direction. This value must be a unit vector.
	 */
	public Vector3 Direction;
	
	/**
	 * Gets or sets light enable flag.
	 */
	public boolean Enabled;
	
	/**
	 * Gets or sets the specular color of the light.
	 */
	public Vector3 SpecularColor;
	
	/**
	 * Creates a new DirectionalLight instance, with or without a copy of a DirectionalLight instance.
	 * 
	 * @param directionParameter
	 * @param diffuseColorParameter
	 * @param specularColorParameter
	 * @param cloneSource
	 */
	public DirectionalLight(EffectParameter directionParameter, EffectParameter diffuseColorParameter, EffectParameter specularColorParameter, DirectionalLight cloneSource)
	{
		this.diffuseColorParameter = diffuseColorParameter;
		this.directionParameter = directionParameter;
		this.specularColorParameter = specularColorParameter;
		
		if (cloneSource != null)
		{
			this.diffuseColor = cloneSource.diffuseColor;
			this.Direction = cloneSource.Direction;
			this.Enabled = cloneSource.Enabled;
			this.SpecularColor = cloneSource.SpecularColor;
		}
		else
		{
			this.diffuseColor = Vector3.One;
			this.Direction = Vector3.Down;
			this.SpecularColor = Vector3.Zero;
		}
	}
}
