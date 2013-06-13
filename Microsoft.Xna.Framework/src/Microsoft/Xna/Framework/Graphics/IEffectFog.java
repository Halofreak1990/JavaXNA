package Microsoft.Xna.Framework.Graphics;

import Microsoft.Xna.Framework.Vector3;

/**
 * 
 * @author Halofreak1990
 */
public interface IEffectFog
{
	Vector3 getFogColor();
	void setFogColor(Vector3 value);
	
	boolean FogEnabled();
	void setFogEnabled(boolean value);
	
	float getFogEnd();
	void setFogEnd(float value);
	
	float getFogStart();
	void setFogStart(float value);
}
