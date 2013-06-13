package Microsoft.Xna.Framework.Graphics;

import java.util.EnumSet;

import System.NotImplementedException;

/**
 * Contains rendering state for drawing with an effect; an effect can contain one or more passes.
 * 
 * @author Halofreak1990
 */
public final class EffectPass
{
	EnumSet<EffectStateFlags> _stateFlags;

	/**
	 * Gets the set of EffectAnnotation objects for this EffectPass.
	 */
	public EffectAnnotationCollection getAnnotations()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the name of this pass.
	 */
	public String getName()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Begins this pass.
	 */
	public void Apply()
	{
		
	}
}
