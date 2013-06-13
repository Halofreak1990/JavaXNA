package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Contains blend state for the device.
 * 
 * @author Halofreak1990
 */
public class BlendState extends GraphicsResource
{
	/**
	 * A built-in state object with settings for additive blend, that is adding the destination data to the source data without using alpha.
	 */
	public static final BlendState Additive = new BlendState(Blend.SourceAlpha, Blend.One, "BlendState.Additive");
	/**
	 * A built-in state object with settings for alpha blend, that is blending the source and destination data using alpha.
	 */
    public static final BlendState AlphaBlend = new BlendState(Blend.One, Blend.InverseSourceAlpha, "BlendState.AlphaBlend");
    boolean blendEnable;
    BlendFunction cachedAlphaBlendFunction;
    Blend cachedAlphaDestinationBlend;
    Blend cachedAlphaSourceBlend;
    Color cachedBlendFactor;
    BlendFunction cachedColorBlendFunction;
    Blend cachedColorDestinationBlend;
    Blend cachedColorSourceBlend;
    ColorWriteChannels cachedColorWriteChannels;
    ColorWriteChannels cachedColorWriteChannels1;
    ColorWriteChannels cachedColorWriteChannels2;
    ColorWriteChannels cachedColorWriteChannels3;
    int cachedMultiSampleMask;
    boolean isBound;
    /**
     * 
     */
    public static final BlendState NonPremultiplied = new BlendState(Blend.SourceAlpha, Blend.InverseSourceAlpha, "BlendState.NonPremultiplied");
    /**
     * 
     */
    public static final BlendState Opague = new BlendState(Blend.One, Blend.Zero, "BlendState.Opague");
    boolean separateAlphaBlend;
    
    /**
     * Gets the arithmetic operation when blending alpha values. The default is BlendFunction.Add.
     */
    public BlendFunction getAlphaBlendFunction()
    {
    	return this.cachedAlphaBlendFunction;
    }
    
    /**
     * Sets the arithmetic operation when blending alpha values. The default is BlendFunction.Add.
     */
    public void setAlphaBlendFunction(BlendFunction value)
    {
    	this.ThrowIfBound();
    	this.cachedAlphaBlendFunction = value;
    }
    
    /**
     * Creates an instance of the BlendState class with default values, using additive color and alpha blending.
     */
    public BlendState()
    {
    	try
    	{
    		this.SetDefaults();
    		this.isBound = false;
    	}
    	catch (RuntimeException ex)
    	{
    		super.Dispose(true);
    	}
    }

	private BlendState(Blend sourceBlend, Blend destinationBlend, String name)
    {
		try
		{
			this.SetDefaults();
			this.ThrowIfBound();
			this.cachedColorSourceBlend = sourceBlend;
			this.ThrowIfBound();
			this.cachedColorDestinationBlend = destinationBlend;
			this.ThrowIfBound();
			this.cachedAlphaSourceBlend = sourceBlend;
			this.ThrowIfBound();
			this.cachedAlphaDestinationBlend = destinationBlend;
			super.Name = name;
			this.isBound = true;
		}
		catch (RuntimeException ex)
		{
			super.Dispose(true);
		}
    }
	
	/**
	 * Immediately releases the unmanaged resources used by this object.
	 */
	@Override
	protected void Dispose(boolean disposing)
	{
		if (disposing)
		{
			try
			{
				return;
			}
			finally
			{
				super.Dispose(true);
			}
		}
		super.Dispose(false);
	}
	
	private void SetDefaults()
	{
		this.ThrowIfBound();
		this.cachedColorSourceBlend = Blend.One;
		this.ThrowIfBound();
		this.cachedColorDestinationBlend = Blend.Zero;
		this.ThrowIfBound();
		this.cachedColorBlendFunction = BlendFunction.Add;
		this.ThrowIfBound();
		this.cachedAlphaSourceBlend = Blend.One;
		this.ThrowIfBound();
		this.cachedAlphaDestinationBlend = Blend.Zero;
		this.ThrowIfBound();
		this.cachedAlphaBlendFunction = BlendFunction.Add;
		this.ThrowIfBound();
		this.cachedColorWriteChannels = ColorWriteChannels.All;
		this.ThrowIfBound();
		this.cachedColorWriteChannels1 = ColorWriteChannels.All;
		this.ThrowIfBound();
		this.cachedColorWriteChannels2 = ColorWriteChannels.All;
		this.ThrowIfBound();
		this.cachedColorWriteChannels3 = ColorWriteChannels.All;
		Color white = Color.White;
		this.ThrowIfBound();
		this.cachedBlendFactor = white;
		this.ThrowIfBound();
		this.cachedMultiSampleMask = -1;
	}

	private void ThrowIfBound()
	{
		if (this.isBound)
		{
			throw new InvalidOperationException(String.format(Locale.getDefault(), "Cannot change read-only %s. State objects become read-only the first time they are bound to a GraphicsDevice. To change property values, create a new %s instance.", BlendState.class.getName()));
		}
	}
}
