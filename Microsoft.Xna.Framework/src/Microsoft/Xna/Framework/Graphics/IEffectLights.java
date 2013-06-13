package Microsoft.Xna.Framework.Graphics;

import Microsoft.Xna.Framework.*;

/**
 * Gets or sets lighting parameters for the current effect.
 * 
 * @author Halofreak1990
 */
public interface IEffectLights
{
	/**
	 * Gets the ambient light color for the current effect.
	 */
	Vector3 getAmbientLightColor();
	
	/**
	 * Sets the ambient light color for the current effect.
	 */
	void setAmbientLightColor(Vector3 value);
	
	/**
	 * Gets the first directional light for the current effect.
	 */
	DirectionalLight getDirectionalLight0();
	
	/**
	 * Gets the second directional light for the current effect.
	 */
	DirectionalLight getDirectionalLight1();
	
	/**
	 * Gets the third directional light for the current effect.
	 */
	DirectionalLight getDirectionalLight2();
	
	public boolean LightingEnabled();
	
	/**
	 * Enables or disables lighting in an IEffectLights.
	 */
	void setLightingEnabled(boolean value);
	
	/**
	 * Enables default lighting for the current effect.
	 */
	void EnableDefaultLighting();
}
