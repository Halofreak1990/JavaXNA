package Microsoft.Xna.Framework.Graphics;

import java.nio.IntBuffer;

import org.lwjgl.opengl.GL11;

import System.ArgumentException;

class GraphicsExtensions
{
	public static void CheckGLError()
	{
		int error = GL11.glGetError();

		if (error != GL11.GL_NO_ERROR)
		{
			throw new RuntimeException("GL11.glGetError() returned " + error);
		}
	}

	public static int GetBoundTexture2D()
	{
		IntBuffer prevTexture = IntBuffer.allocate(1);

		GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D, prevTexture);

		return prevTexture.get(0);
	}

	public static int GetSize(SurfaceFormat surfaceFormat)
	{
		switch (surfaceFormat)
		{
		case Dxt1:
			// One texel in DXT1, PVRTC 2bpp and ETC1 is a minimum 4x4 block, which is 8 bytes
			return 8;
		case Dxt3:
		case Dxt5:
			// One texel in DXT3, DXT5 and PVRTC 4bpp is a minimum 4x4 block, which is 16 bytes
			return 16;
		case Alpha8:
			return 1;
		case Bgr565:
		case Bgra4444:
		case Bgra5551:
		case HalfSingle:
		case NormalizedByte2:
			return 2;
		case Color:
		case Single:
		case Rg32:
		case HalfVector2:
		case NormalizedByte4:
		case Rgba1010102:
			return 4;
		case HalfVector4:
		case Rgba64:
		case Vector2:
			return 8;
		case Vector4:
			return 16;
		default:
			throw new ArgumentException();
		}
	}
}
