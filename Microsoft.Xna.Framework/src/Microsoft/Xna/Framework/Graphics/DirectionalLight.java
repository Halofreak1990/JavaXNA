package Microsoft.Xna.Framework.Graphics;

import Microsoft.Xna.Framework.*;

/**
 * Represents a DirectionalLight object.
 * 
 * @author Halofreak1990
 */
public final class DirectionalLight
{
	private EffectParameter diffuseColorParameter;
	private EffectParameter directionParameter;
	private EffectParameter specularColorParameter;
	
	/**
	 * Gets or sets the diffuse color of the light.
	 * 
	 * @return
	 * The diffuse color of the light.
	 */
	public Vector3 getDiffuseColor()
	{
		return this.diffuseColorParameter.GetValueVector3();
	}
	
	/**
	 * Sets the diffuse color of the light.
	 * 
	 * @param value
	 * The new diffuse color of the light.
	 */
	public void setDiffuseColor(Vector3 value)
	{
		if (this.Enabled && this.diffuseColorParameter != null)
		{
			this.diffuseColorParameter.SetValue(value);
		}
	}
	
	/**
	 * Gets the light direction.
	 * 
	 * @return
	 * The light direction.
	 */
	public Vector3 getDirection()
	{
		return directionParameter.GetValueVector3();
	}
	
	/**
	 * Sets the light direction. This value must be a unit vector.
	 * 
	 * @param value
	 * The new direction of the light.
	 */
	public void setDirection(Vector3 value)
	{
		directionParameter.SetValue(value);
	}
	
	/**
	 * Gets or sets light enable flag.
	 */
	public boolean Enabled;
	
	/**
	 * Gets the specular color of the light.
	 * 
	 * @return
	 * The specular color of the light.
	 */
	public Vector3 getSpecularColor()
	{
		return specularColorParameter.GetValueVector3();
	}
	
	/**
	 * Sets the specular color of the light.
	 * 
	 * @param value
	 * The new specular color of the light.
	 */
	public void setSpecularColor(Vector3 value)
	{
		specularColorParameter.SetValue(value);
	}
	
	/**
	 * Creates a new DirectionalLight instance, with or without a copy of a DirectionalLight instance.
	 * 
	 * @param directionParameter
	 * The light direction.
	 * 
	 * @param diffuseColorParameter
	 * The diffuse color.
	 * 
	 * @param specularColorParameter
	 * The specular color.
	 * 
	 * @param cloneSource
	 * The cloned instance to copy from.
	 */
	public DirectionalLight(EffectParameter directionParameter, EffectParameter diffuseColorParameter, EffectParameter specularColorParameter, DirectionalLight cloneSource)
	{
		this.diffuseColorParameter = diffuseColorParameter;
		this.directionParameter = directionParameter;
		this.specularColorParameter = specularColorParameter;
		
		if (cloneSource != null)
		{
			this.diffuseColorParameter.SetValue(cloneSource.getDiffuseColor());
			this.directionParameter.SetValue(cloneSource.getDirection());
			this.Enabled = cloneSource.Enabled;
			this.specularColorParameter.SetValue(cloneSource.getSpecularColor());
		}
		else
		{
			this.diffuseColorParameter.SetValue(Vector3.One);
			this.directionParameter.SetValue(Vector3.Down);
			this.Enabled = true;
			this.specularColorParameter.SetValue(Vector3.Zero);
		}
	}
}
