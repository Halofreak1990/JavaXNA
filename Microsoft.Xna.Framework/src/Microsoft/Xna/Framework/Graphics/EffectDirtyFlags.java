package Microsoft.Xna.Framework.Graphics;

enum EffectDirtyFlags
{
    All (-1),
    AlphaTest (0x40),
    EyePosition (4),
    Fog (0x10),
    FogEnable (0x20),
    MaterialColor (8),
    ShaderIndex (0x80),
    World (2),
    WorldViewProj (1);
    
    private final int value;
    private EffectDirtyFlags(int value)
    {
    	this.value = value;
    }
    
    int getValue()
    {
    	return value;
    }
}
