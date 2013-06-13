package Microsoft.Xna.Framework.Graphics;

/**
 * Contains sampler state, which determines how to sample texture data.
 * 
 * @author Halofreak1990
 */
public class SamplerState extends GraphicsResource
{
	public static final SamplerState AnisotropicClamp = new SamplerState(TextureFilter.Anisotropic, TextureAddressMode.Clamp, "SamplerState.AnisotropicClamp");
    public static final SamplerState AnisotropicWrap = new SamplerState(TextureFilter.Anisotropic, TextureAddressMode.Wrap, "SamplerState.AnisotropicWrap");
    public static final SamplerState LinearClamp = new SamplerState(TextureFilter.Linear, TextureAddressMode.Clamp, "SamplerState.LinearClamp");
    public static final SamplerState LinearWrap = new SamplerState(TextureFilter.Linear, TextureAddressMode.Wrap, "SamplerState.LinearWrap");
    public static final SamplerState PointClamp = new SamplerState(TextureFilter.Point, TextureAddressMode.Clamp, "SamplerState.PointClamp");
    public static final SamplerState PointWrap = new SamplerState(TextureFilter.Point, TextureAddressMode.Wrap, "SamplerState.PointWrap");
    
    public SamplerState()
    {
    	
    }
    
    private SamplerState(TextureFilter filter, TextureAddressMode address, String name)
    {
    	super.Name = name;
    }
}
