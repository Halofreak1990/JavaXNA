package Microsoft.Xna.Framework.Graphics;

import System.*;

/**
 * Binds an array of render targets.
 * 
 * @author Halofreak1990
 */
public final class RenderTargetBinding extends ValueType
{
	Texture _renderTarget;
	CubeMapFace _cubeMapFace;
	
	/**
	 * Gets one face of a CubeMap.
	 */
	public CubeMapFace getCubeMapFace()
	{
		return this._cubeMapFace;
	}
	
	/**
	 * Gets a 2D texture.
	 */
	public Texture getRenderTarget()
	{
		return this._renderTarget;
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param renderTarget
	 * Identifies a CubeMap render target.
	 * 
	 * @param cubeMapFace
	 * CubeMap face.
	 * 
	 * @throws ArgumentNullException
	 * renderTarget is null.
	 */
	public RenderTargetBinding(RenderTargetCube renderTarget, CubeMapFace cubeMapFace)
	{
		if (renderTarget == null)
			throw new ArgumentNullException("renderTarget", "This method does not allow null for this parameter.");
		
		this._renderTarget = renderTarget;
		this._cubeMapFace = cubeMapFace;
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param renderTarget
	 * Identifies a 2D render target.
	 * 
	 * @throws ArgumentNullException
	 * renderTarget is null.
	 */
	public RenderTargetBinding(RenderTarget2D renderTarget)
	{
		if (renderTarget == null)
			throw new ArgumentNullException("renderTarget", "This method does not allow null for this parameter.");
		
		this._renderTarget = renderTarget;
		this._cubeMapFace = CubeMapFace.PositiveX;
	}
}
