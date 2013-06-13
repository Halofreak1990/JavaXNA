package Microsoft.Xna.Framework;

/**
 * Contains commonly used precalculated values.
 * 
 * @author Halofreak1990
 */
public final class MathHelper
{
	/**
	 * Represents the mathematical constant e.
	 */
	public static final float E = 2.718282f;
	/**
	 * Represents the log base ten of e.
	 */
    public static final float Log10E = 0.4342945f;
    /**
     * Represents the log base two of e.
     */
    public static final float Log2E = 1.442695f;
    /**
     * Represents the value of pi.
     */
    public static final float Pi = 3.141593f;
    /**
     * Represents the value of pi divided by two.
     */
    public static final float PiOver2 = 1.570796f;
    /**
     * Represents the value of pi divided by four.
     */
    public static final float PiOver4 = 0.7853982f;
    /**
     * Represents the value of pi times two.
     */
    public static final float TwoPi = 6.283185f;
    
    /**
     * Private Constructor to prevent instantiation
     */
    private MathHelper() {}

    /**
     * Returns the Cartesian coordinate for one axis of a point that is defined by a given triangle and two normalized barycentric (areal) coordinates.
     * 
     * @param value1
     * The coordinate on one axis of vertex 1 of the defining triangle.
     * 
     * @param value2
     * The coordinate on the same axis of vertex 2 of the defining triangle.
     * 
     * @param value3
     * The coordinate on the same axis of vertex 3 of the defining triangle.
     * 
     * @param amount1
     * The normalized barycentric (areal) coordinate b2, equal to the weighting factor for vertex 2, the coordinate of which is specified in value2.
     * 
     * @param amount2
     * The normalized barycentric (areal) coordinate b3, equal to the weighting factor for vertex 3, the coordinate of which is specified in value3.
     */
    public static float Barycentric(float value1, float value2, float value3, float amount1, float amount2)
    {
        return ((value1 + (amount1 * (value2 - value1))) + (amount2 * (value3 - value1)));
    }

    /**
     * Performs a Catmull-Rom interpolation using the specified positions.
     * 
     * @param value1
     * The first position in the interpolation.
     * 
     * @param value2
     * The second position in the interpolation.
     * 
     * @param value3
     * The third position in the interpolation.
     * 
     * @param value4
     * The fourth position in the interpolation.
     * 
     * @param amount
     * Weighting factor.
     */
    public static float CatmullRom(float value1, float value2, float value3, float value4, float amount)
    {
        float num = amount * amount;
        float num2 = amount * num;
        return (0.5f * ((((2f * value2) + ((-value1 + value3) * amount)) + (((((2f * value1) - (5f * value2)) + (4f * value3)) - value4) * num)) + ((((-value1 + (3f * value2)) - (3f * value3)) + value4) * num2)));
    }

    /**
     * Restricts a value to be within a specified range. Reference page contains links to related code samples.
     * 
     * @param value
     * The value to clamp.
     * 
     * @param min
     * The minimum value. If value is less than min, min will be returned.
     * 
     * @param max
     * The maximum value. If value is greater than max, max will be returned.
     */
    public static float Clamp(float value, float min, float max)
    {
        value = (value > max) ? max : value;
        value = (value < min) ? min : value;
        return value;
    }

    /**
     * Calculates the absolute value of the difference of two values.
     * 
     * @param value1
     * Source value.
     * 
     * @param value2
     * Source value.
     */
    public static float Distance(float value1, float value2)
    {
        return Math.abs((float) (value1 - value2));
    }

    /**
     * Performs a Hermite spline interpolation.
     * 
     * @param value1
     * Source position.
     * 
     * @param tangent1
     * Source tangent.
     * 
     * @param value2
     * Source position.
     * 
     * @param tangent2
     * Source tangent.
     * 
     * @param amount
     * Weighting factor.
     */
    public static float Hermite(float value1, float tangent1, float value2, float tangent2, float amount)
    {
        float num3 = amount;
        float num = num3 * num3;
        float num2 = num3 * num;
        float num7 = ((2f * num2) - (3f * num)) + 1f;
        float num6 = (-2f * num2) + (3f * num);
        float num5 = (num2 - (2f * num)) + num3;
        float num4 = num2 - num;
        return ((((value1 * num7) + (value2 * num6)) + (tangent1 * num5)) + (tangent2 * num4));
    }

    /**
     * Linearly interpolates between two values.
     * 
     * @param value1
     * Source value.
     * 
     * @param value2
     * Source value.
     * 
     * @param amount
     * Value between 0 and 1 indicating the weight of value2.
     */
    public static float Lerp(float value1, float value2, float amount)
    {
        return (value1 + ((value2 - value1) * amount));
    }

    /**
     * Returns the greater of two values.
     * 
     * @param value1
     * Source value.
     * 
     * @param value2
     * Source value.
     */
    public static float Max(float value1, float value2)
    {
        return Math.max(value1, value2);
    }

    /**
     * Returns the lesser of two values.
     * 
     * @param value1
     * Source value.
     * 
     * @param value2
     * Source value.
     */
    public static float Min(float value1, float value2)
    {
        return Math.min(value1, value2);
    }

    /**
     * Interpolates between two values using a cubic equation.
     * 
     * @param value1
     * Source value.
     * 
     * @param value2
     * Source value.
     * 
     * @param amount
     * Weighting value.
     */
    public static float SmoothStep(float value1, float value2, float amount)
    {
        float num = Clamp(amount, 0f, 1f);
        return Lerp(value1, value2, (num * num) * (3f - (2f * num)));
    }

	/**
	 * Converts radians to degrees.
	 */
    public static float ToDegrees(float radians)
    {
        return (radians * 57.29578f);
    }

	/**
	 * Converts degrees to radians.
	 */
    public static float ToRadians(float degrees)
    {
        return (degrees * 0.01745329f);
    }
    
    /**
     * Reduces a given angle to a value between π and -π.
     * 
     * @param angle
     * The angle to reduce, in radians.
     */
    public static float WrapAngle(float angle)
    {
        angle = (float) Math.IEEEremainder((double) angle, 6.2831854820251465);
        if (angle <= -3.141593f)
        {
            angle += 6.283185f;
            return angle;
        }
        if (angle > 3.141593f)
        {
            angle -= 6.283185f;
        }
        return angle;
    }
}
