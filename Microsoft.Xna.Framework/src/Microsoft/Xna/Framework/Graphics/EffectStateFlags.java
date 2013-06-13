package Microsoft.Xna.Framework.Graphics;

enum EffectStateFlags
{
	AllSamples (0x7fff8),
	AllVertexSamples (0x780000),
	Blend (1),
	DepthStencil (2),
	None (0),
	Rasterizer (4),
	Sampler0 (8),
	Sampler1 (0x10),
	Sampler10 (0x2000),
	Sampler11 (0x4000),
	Sampler12 (0x8000),
	Sampler13 (0x10000),
	Sampler14 (0x20000),
	Sampler15 (0x40000),
	Sampler2 (0x20),
	Sampler3 (0x40),
	Sampler4 (0x80),
	Sampler5 (0x100),
	Sampler6 (0x200),
	Sampler7 (0x400),
	Sampler8 (0x800),
	Sampler9 (0x1000),
	VertexSampler0 (0x80000),
	VertexSampler1 (0x100000),
	VertexSampler2 (0x200000),
	VertexSampler3 (0x400000);
	
	private final int value;
	private EffectStateFlags(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}
