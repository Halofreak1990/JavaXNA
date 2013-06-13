package Microsoft.Xna.Framework.Graphics;

import System.*;

/**
 * Used to set and query effects, and to choose techniques.
 * 
 * @author Halofreak1990
 */
public class Effect extends GraphicsResource
{
	private byte[] byteCode;
	
	/**
	 * Gets or sets the active technique.
	 */
	public EffectTechnique CurrentTechnique;
	
	/**
	 * Gets a collection of parameters used for this effect.
	 */
	public EffectParameterCollection getParameters()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets a collection of techniques that are defined for this effect.
	 */
	public EffectTechniqueCollection getTechniques()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param cloneSource
	 * An object to copy.
	 */
	protected Effect(Effect cloneSource)
	{
		
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param graphicsDevice
	 * The device.
	 * 
	 * @param byteCode
	 * The effect code.
	 */
	public Effect(GraphicsDevice graphicsDevice, byte[] byteCode)
	{
		super._parent = graphicsDevice;
	}
	
	/**
	 * Releases the unmanaged resources used by the Effect and optionally releases the managed resources.
	 */
	@Override
	protected void Dispose(boolean disposing)
	{
		
	}
	
	/**
	 * Applies the effect state just prior to rendering the effect.
	 */
	protected void OnApply()
	{
		
	}
	
	/**
	 * Copies data from an existing object to this object.
	 */
	public Effect Clone()
	{
		return new Effect(this);
	}
}
