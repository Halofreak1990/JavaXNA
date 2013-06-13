package Microsoft.Xna.Framework.Graphics;

/**
 * Defines types that can be used for effect parameters or shader constants.
 * 
 * @author Halofreak1990
 */
public enum EffectParameterType
{
	/**
	 * Parameter is a Boolean. Any nonzero value passed in will be mapped to 1 (TRUE) before being written into the constant table; otherwise, the value will be set to 0 in the constant table.
	 */
	Bool (1),
	/**
	 * Parameter is an integer. Any floating-point values passed in will be rounded off (to zero decimal places) before being written into the constant table.
	 */
	Int32 (2),
	/**
	 * Parameter is a floating-point number.
	 */
	Single (3),
	/**
	 * Parameter is a string.
	 */
	String (4),
	/**
	 * Parameter is a texture.
	 */
	Texture(5),
	/**
	 * Parameter is a 1D texture.
	 */
	Texture1D (6),
	/**
	 * Parameter is a 2D texture.
	 */
	Texture2D (7),
	/**
	 * Parameter is a 3D texture.
	 */
	Texture3D (8),
	/**
	 * Parameter is a cube texture.
	 */
	TextureCube (9),
	/**
	 * Parameter is a void pointer.
	 */
	Void (0);
	
	private final int value;
	EffectParameterType(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
