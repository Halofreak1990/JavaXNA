package Microsoft.Xna.Framework.Graphics.PackedVector;

public class PackUtils
{
	private static double ClampAndRound(float value, float min, float max)
    {
        if (Float.isNaN(value))
        {
            return 0.0;
        }
        if (Float.isInfinite(value))
        {
            return ((Float.NEGATIVE_INFINITY == value) ? ((double) min) : ((double) max));
        }
        if (value < min)
        {
            return (double) min;
        }
        if (value > max)
        {
            return (double) max;
        }
        return Math.round((double) value);
    }

    public static int PackSigned(int bitmask, float value)
    {
        float max = bitmask >> 1;
        float min = -max - 1f;
        return ((((int) ClampAndRound(value, min, max))) & bitmask);
    }

    public static int PackSNorm(int bitmask, float value)
    {
        float max = bitmask >> 1;
        value *= max;
        return ((((int) ClampAndRound(value, -max, max))) & bitmask);
    }

    public static int PackUNorm(float bitmask, float value)
    {
        value *= bitmask;
        return (int) ClampAndRound(value, 0f, bitmask);
    }

    public static int PackUnsigned(float bitmask, float value)
    {
        return (int) ClampAndRound(value, 0f, bitmask);
    }

    public static float UnpackSNorm(long bitmask, long value)
    {
        long num = (long) ((bitmask + 1) >> 1);
        if ((value & num) != 0)
        {
            if ((value & bitmask) == num)
            {
                return -1f;
            }
            value |= ~bitmask;
        }
        else
        {
            value &= bitmask;
        }
        float num2 = bitmask >> 1;
        return (((float) value) / num2);
    }

    public static float UnpackUNorm(long bitmask, long value)
    {
        value &= bitmask;
        return (((float) value) / ((float) bitmask));
    }
}
