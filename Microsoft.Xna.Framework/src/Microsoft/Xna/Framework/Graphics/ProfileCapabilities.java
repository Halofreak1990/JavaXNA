package Microsoft.Xna.Framework.Graphics;

import java.util.*;
import System.*;

class ProfileCapabilities
{
	boolean DestBlendSrcAlphaSat;
	boolean GetBackBufferData;
	static final ProfileCapabilities HiDef;
	boolean IndexElementSize32;
	ArrayList<SurfaceFormat> InvalidBlendFormats = new ArrayList<SurfaceFormat>();
	ArrayList<SurfaceFormat> InvalidFilterFormats = new ArrayList<SurfaceFormat>();
	int MaxCubeSize;
	int MaxIndexBufferSize;
	int MaxPrimitiveCount;
	int MaxRenderTargets;
	int MaxSamplers;
	int MaxStreamStride;
	int MaxTextureAspectRatio;
	int MaxTextureSize;
	int MaxVertexBufferSize;
	int MaxVertexSamplers;
	int MaxVertexStreams;
	int MaxVolumeExtent;
	boolean MinMaxSrcDestBlend;
	boolean NonPow2Cube;
	boolean NonPow2Unconditional;
	boolean NonPow2Volume;
	boolean OcclusionQuery;
	int PixelShaderVersion;
	GraphicsProfile Profile;
	static final ProfileCapabilities Reach;
	boolean SeparateAlphaBlend;
	ArrayList<SurfaceFormat> ValidCubeFormats = new ArrayList<SurfaceFormat>();
	ArrayList<DepthFormat> ValidDepthFormats = new ArrayList<DepthFormat>();
	ArrayList<SurfaceFormat> ValidTextureFormats = new ArrayList<SurfaceFormat>();
	ArrayList<VertexElementFormat> ValidVertexFormats = new ArrayList<VertexElementFormat>();
	ArrayList<SurfaceFormat> ValidVertexTextureFormats = new ArrayList<SurfaceFormat>();
	ArrayList<SurfaceFormat> ValidVolumeFormats = new ArrayList<SurfaceFormat>();
	int VertexShaderVersion;
	
	static
	{
		ProfileCapabilities capabilities2 = new ProfileCapabilities();
		capabilities2.Profile = GraphicsProfile.Reach;
		capabilities2.VertexShaderVersion = 0x200;
		capabilities2.PixelShaderVersion = 0x200;
		capabilities2.OcclusionQuery = false;
		capabilities2.GetBackBufferData = false;
		capabilities2.SeparateAlphaBlend = false;
		capabilities2.DestBlendSrcAlphaSat = false;
		capabilities2.MinMaxSrcDestBlend = false;
		capabilities2.MaxPrimitiveCount = 0xffff;
		capabilities2.IndexElementSize32 = false;
		capabilities2.MaxVertexStreams = 0x10;
		capabilities2.MaxStreamStride = 0xff;
		capabilities2.MaxVertexBufferSize = 0x3ffffff;
		capabilities2.MaxIndexBufferSize = 0x3ffffff;
		capabilities2.MaxTextureSize = 0x800;
		capabilities2.MaxCubeSize = 0x200;
		capabilities2.MaxVolumeExtent = 0;
		capabilities2.MaxTextureAspectRatio = 0x800;
		capabilities2.MaxSamplers = 0x10;
		capabilities2.MaxVertexSamplers = 0;
		capabilities2.MaxRenderTargets = 1;
		capabilities2.NonPow2Unconditional = false;
		capabilities2.NonPow2Cube = false;
		capabilities2.NonPow2Volume = false;
		capabilities2.ValidTextureFormats.add(SurfaceFormat.Color);
		capabilities2.ValidTextureFormats.add(SurfaceFormat.Bgr565);
		capabilities2.ValidTextureFormats.add(SurfaceFormat.Bgra5551);
		capabilities2.ValidTextureFormats.add(SurfaceFormat.Bgra4444);
		capabilities2.ValidTextureFormats.add(SurfaceFormat.Dxt1);
		capabilities2.ValidTextureFormats.add(SurfaceFormat.Dxt3);
		capabilities2.ValidTextureFormats.add(SurfaceFormat.Dxt5);
		capabilities2.ValidTextureFormats.add(SurfaceFormat.NormalizedByte2);
		capabilities2.ValidTextureFormats.add(SurfaceFormat.NormalizedByte4);
		capabilities2.ValidCubeFormats.add(SurfaceFormat.Color);
		capabilities2.ValidCubeFormats.add(SurfaceFormat.Bgr565);
		capabilities2.ValidCubeFormats.add(SurfaceFormat.Bgra5551);
		capabilities2.ValidCubeFormats.add(SurfaceFormat.Bgra4444);
		capabilities2.ValidCubeFormats.add(SurfaceFormat.Dxt1);
		capabilities2.ValidCubeFormats.add(SurfaceFormat.Dxt3);
		capabilities2.ValidCubeFormats.add(SurfaceFormat.Dxt5);
		capabilities2.ValidDepthFormats.add(DepthFormat.Depth16);
		capabilities2.ValidDepthFormats.add(DepthFormat.Depth24);
		capabilities2.ValidDepthFormats.add(DepthFormat.Depth24Stencil8);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.Color);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.Single);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.Vector2);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.Vector3);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.Vector4);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.Byte4);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.Short2);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.Short4);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.NormalizedShort2);
		capabilities2.ValidVertexFormats.add(VertexElementFormat.NormalizedShort4);
		Reach = capabilities2;
		ProfileCapabilities capabilities = new ProfileCapabilities();
		capabilities.Profile = GraphicsProfile.HiDef;
		capabilities.VertexShaderVersion = 0x300;
		capabilities.PixelShaderVersion = 0x300;
		capabilities.OcclusionQuery = true;
		capabilities.GetBackBufferData = true;
		capabilities.SeparateAlphaBlend = true;
		capabilities.DestBlendSrcAlphaSat = true;
		capabilities.MinMaxSrcDestBlend = false;
		capabilities.MaxPrimitiveCount = 0xffff;
		capabilities.IndexElementSize32 = true;
		capabilities.MaxVertexStreams = 0x10;
		capabilities.MaxStreamStride = 0xff;
		capabilities.MaxVertexBufferSize = 0x3ffffff;
		capabilities.MaxIndexBufferSize = 0xffffff;
		capabilities.MaxTextureSize = 0x1000;
		capabilities.MaxCubeSize = 0x1000;
		capabilities.MaxVolumeExtent = 0x100;
		capabilities.MaxTextureAspectRatio = 0x800;
		capabilities.MaxSamplers = 0x10;
		capabilities.MaxVertexSamplers = 4;
		capabilities.MaxRenderTargets = 4;
		capabilities.NonPow2Unconditional = true;
		capabilities.NonPow2Cube = true;
		capabilities.NonPow2Volume = true;
		capabilities.ValidTextureFormats.add(SurfaceFormat.Color);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Bgr565);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Bgra5551);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Bgra4444);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Dxt1);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Dxt3);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Dxt5);
		capabilities.ValidTextureFormats.add(SurfaceFormat.NormalizedByte2);
		capabilities.ValidTextureFormats.add(SurfaceFormat.NormalizedByte4);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Rgba1010102);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Rg32);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Rgba64);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Alpha8);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Single);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Vector2);
		capabilities.ValidTextureFormats.add(SurfaceFormat.Vector4);
		capabilities.ValidTextureFormats.add(SurfaceFormat.HalfSingle);
		capabilities.ValidTextureFormats.add(SurfaceFormat.HalfVector2);
		capabilities.ValidTextureFormats.add(SurfaceFormat.HalfVector4);
		capabilities.ValidTextureFormats.add(SurfaceFormat.HdrBlendable);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Color);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Bgr565);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Bgra5551);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Bgra4444);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Dxt1);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Dxt3);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Dxt5);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Rgba1010102);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Rg32);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Rgba64);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Alpha8);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Single);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Vector2);
		capabilities.ValidCubeFormats.add(SurfaceFormat.Vector4);
		capabilities.ValidCubeFormats.add(SurfaceFormat.HalfSingle);
		capabilities.ValidCubeFormats.add(SurfaceFormat.HalfVector2);
		capabilities.ValidCubeFormats.add(SurfaceFormat.HalfVector4);
		capabilities.ValidCubeFormats.add(SurfaceFormat.HdrBlendable);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Color);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Bgr565);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Bgra5551);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Bgra4444);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Rgba1010102);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Rg32);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Rgba64);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Alpha8);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Single);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Vector2);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.Vector4);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.HalfSingle);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.HalfVector2);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.HalfVector4);
		capabilities.ValidVolumeFormats.add(SurfaceFormat.HdrBlendable);
		capabilities.ValidVertexTextureFormats.add(SurfaceFormat.Single);
		capabilities.ValidVertexTextureFormats.add(SurfaceFormat.Vector2);
		capabilities.ValidVertexTextureFormats.add(SurfaceFormat.Vector4);
		capabilities.ValidVertexTextureFormats.add(SurfaceFormat.HalfSingle);
		capabilities.ValidVertexTextureFormats.add(SurfaceFormat.HalfVector2);
		capabilities.ValidVertexTextureFormats.add(SurfaceFormat.HalfVector4);
		capabilities.ValidVertexTextureFormats.add(SurfaceFormat.HdrBlendable);
		capabilities.InvalidFilterFormats.add(SurfaceFormat.Single);
		capabilities.InvalidFilterFormats.add(SurfaceFormat.Vector2);
		capabilities.InvalidFilterFormats.add(SurfaceFormat.Vector4);
		capabilities.InvalidFilterFormats.add(SurfaceFormat.HalfSingle);
		capabilities.InvalidFilterFormats.add(SurfaceFormat.HalfVector2);
		capabilities.InvalidFilterFormats.add(SurfaceFormat.HalfVector4);
		capabilities.InvalidFilterFormats.add(SurfaceFormat.HdrBlendable);
		capabilities.InvalidBlendFormats.add(SurfaceFormat.Single);
		capabilities.InvalidBlendFormats.add(SurfaceFormat.Vector2);
		capabilities.InvalidBlendFormats.add(SurfaceFormat.Vector4);
		capabilities.InvalidBlendFormats.add(SurfaceFormat.HalfSingle);
		capabilities.InvalidBlendFormats.add(SurfaceFormat.HalfVector2);
		capabilities.InvalidBlendFormats.add(SurfaceFormat.HalfVector4);
		capabilities.ValidDepthFormats.add(DepthFormat.Depth16);
		capabilities.ValidDepthFormats.add(DepthFormat.Depth24);
		capabilities.ValidDepthFormats.add(DepthFormat.Depth24Stencil8);
		capabilities.ValidVertexFormats.add(VertexElementFormat.Color);
		capabilities.ValidVertexFormats.add(VertexElementFormat.Single);
		capabilities.ValidVertexFormats.add(VertexElementFormat.Vector2);
		capabilities.ValidVertexFormats.add(VertexElementFormat.Vector3);
		capabilities.ValidVertexFormats.add(VertexElementFormat.Vector4);
		capabilities.ValidVertexFormats.add(VertexElementFormat.Byte4);
		capabilities.ValidVertexFormats.add(VertexElementFormat.Short2);
		capabilities.ValidVertexFormats.add(VertexElementFormat.Short4);
		capabilities.ValidVertexFormats.add(VertexElementFormat.NormalizedShort2);
		capabilities.ValidVertexFormats.add(VertexElementFormat.NormalizedShort4);
		capabilities.ValidVertexFormats.add(VertexElementFormat.HalfVector2);
		capabilities.ValidVertexFormats.add(VertexElementFormat.HalfVector4);
		HiDef = capabilities;
	}
	
	static ProfileCapabilities GetInstance(GraphicsProfile graphicsProfile)
	{
		switch(graphicsProfile)
		{
		case Reach:
			return Reach;
		case HiDef:
			return HiDef;
		}
		throw new ArgumentOutOfRangeException("graphicsProfile");
	}
	
	void ThrowNotSupportedException(String message)
	{
		throw new NotSupportedException(String.format(Locale.getDefault(), message, new Object[] { this.Profile }));
	}
	
	void ThrowNotSupportedException(String message, Object arg1)
	{
		throw new NotSupportedException(String.format(Locale.getDefault(), message, new Object[] { this.Profile, arg1 }));
	}
	
	void ThrowNotSupportedException(String message, Object arg1, Object arg2)
	{
		throw new NotSupportedException(String.format(Locale.getDefault(), message, new Object[] { this.Profile, arg1, arg2 }));
	}
}
