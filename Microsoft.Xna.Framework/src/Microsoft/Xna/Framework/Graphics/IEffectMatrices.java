package Microsoft.Xna.Framework.Graphics;

import Microsoft.Xna.Framework.Matrix;

/**
 * Gets or sets transformation matrix parameters for the current effect.
 * 
 * @author Halofreak1990
 */
public interface IEffectMatrices
{
	Matrix getProjection();
	void setProjection(Matrix value);
	
	Matrix getView();
	void setView(Matrix value);
	
	Matrix getWorld();
	void setWorld(Matrix value);
}
