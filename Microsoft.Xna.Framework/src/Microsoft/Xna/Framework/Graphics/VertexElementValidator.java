package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

import System.*;

class VertexElementValidator
{
	static int GetTypeSize(VertexElementFormat format)
    {
        switch (format)
        {
            case Single:
                return 4;

            case Vector2:
                return 8;

            case Vector3:
                return 12;

            case Vector4:
                return 0x10;

            case Color:
                return 4;

            case Byte4:
                return 4;

            case Short2:
                return 4;

            case Short4:
                return 8;

            case NormalizedShort2:
                return 4;

            case NormalizedShort4:
                return 8;

            case HalfVector2:
                return 4;

            case HalfVector4:
                return 8;
        }
        return 0;
    }
	
	static int GetVertexStride(VertexElement[] elements)
    {
        int num2 = 0;
        for (int i = 0; i < elements.length; i++)
        {
            int num3 = elements[i].getOffset() + GetTypeSize(elements[i].getVertexElementFormat());
            if (num2 < num3)
            {
                num2 = num3;
            }
        }
        return num2;
    }
	
	static void Validate(int vertexStride, VertexElement[] elements)
    {
        if (vertexStride <= 0)
        {
            throw new ArgumentOutOfRangeException("vertexStride");
        }
        if ((vertexStride & 3) != 0)
        {
            throw new ArgumentException("Invalid VertexDeclaration. Vertex stride and VertexElement.Offset must be multiples of four.");
        }
        int[] numArray = new int[vertexStride];
        for (int i = 0; i < vertexStride; i++)
        {
            numArray[i] = -1;
        }
        for (int j = 0; j < elements.length; j++)
        {
            int offset = elements[j].getOffset();
            int typeSize = GetTypeSize(elements[j].getVertexElementFormat());
            if ((elements[j].getVertexElementUsage().ordinal() < VertexElementUsage.Position.ordinal()) || (elements[j].getVertexElementUsage().ordinal() > VertexElementUsage.TessellateFactor.ordinal()))
            {
                throw new ArgumentException(String.format(Locale.getDefault(), "Invalid VertexDeclaration. Usage %1$%2$ is out of range.", new Object[] { elements[j].getVertexElementUsage(), "" }));
            }
            if ((offset < 0) || ((offset + typeSize) > vertexStride))
            {
                throw new ArgumentException(String.format(Locale.getDefault(), "Invalid VertexDeclaration. Element %1$%2$ does not fit within the specified vertex stride.", new Object[] { elements[j].getVertexElementUsage(), elements[j].getUsageIndex() }));
            }
            if ((offset & 3) != 0)
            {
                throw new ArgumentException("Invalid VertexDeclaration. Vertex stride and VertexElement.Offset must be multiples of four.");
            }
            for (int k = 0; k < j; k++)
            {
                if ((elements[j].getVertexElementUsage() == elements[k].getVertexElementUsage()) && (elements[j].getUsageIndex() == elements[k].getUsageIndex()))
                {
                    throw new ArgumentException(String.format(Locale.getDefault(), "Invalid VertexDeclaration. Element %1$%2$ does not fit within the specified vertex stride.", new Object[] { elements[j].getVertexElementUsage(), elements[j].getUsageIndex() }));
                }
            }
            for (int m = offset; m < (offset + typeSize); m++)
            {
                if (numArray[m] >= 0)
                {
                    throw new ArgumentException(String.format(Locale.getDefault(), "Invalid VertexDeclaration. Elements %1$%2$ and %3$%4$ are overlapping.", new Object[] { elements[numArray[m]].getVertexElementUsage(), elements[numArray[m]].getUsageIndex(), elements[j].getVertexElementUsage(), elements[j].getUsageIndex() }));
                }
                numArray[m] = j;
            }
        }
    }
	
	static void Validate(int vertexStride, VertexElement[] elements, ProfileCapabilities profile)
	{
		Validate(vertexStride, elements);
		if (vertexStride > profile.MaxStreamStride)
		{
			profile.ThrowNotSupportedException("JavaXNA Framework %1$ profile supports a maximum vertex stride of %2$.", profile.MaxStreamStride);
		}
		if (elements.length > profile.MaxVertexStreams)
		{
			profile.ThrowNotSupportedException("JavaXNA Framework %1$ profile supports a maximum of %2$ simultaneous vertex elements.", profile.MaxVertexStreams);
		}
		for (int i = 0; i < elements.length; i++)
		{
			if (!profile.ValidVertexFormats.contains(elements[i].getVertexElementFormat()))
			{
				profile.ThrowNotSupportedException("JavaXNA Framework %1$ profile does not support %2$ format %3$%.", VertexElement.class.getName(), elements[i].getVertexElementFormat());
			}
			if ((elements[i].getUsageIndex() < 0) || (elements[i].getUsageIndex() > profile.MaxVertexStreams))
			{
				throw new ArgumentException(String.format(Locale.getDefault(), "Invalid VertexDeclaration. Usage %1$%2$ is out of range.", new Object[] { elements[i].getVertexElementUsage(), elements[i].getUsageIndex() }));
			}
		}
	}
}
