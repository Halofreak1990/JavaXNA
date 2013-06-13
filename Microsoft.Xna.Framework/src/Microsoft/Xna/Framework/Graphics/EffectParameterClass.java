package Microsoft.Xna.Framework.Graphics;

/**
 * Defines classes that can be used for effect parameters or shader constants.
 * 
 * @author Halofreak1990
 */
public enum EffectParameterClass
{	
	/**
	 * Constant is either a texture, a shader, or a string.
	 */
	Object (3),
	/**
	 * Constant is a matrix.
	 */
	Matrix (2),
	/**
	 * Constant is a scalar.
	 */
	Scalar (0),
	/**
	 * Constant is a structure.
	 */
	Struct (4),
	/**
	 * Constant is a vector.
	 */
	Vector (1);
	
	private final int value;
	EffectParameterClass(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
