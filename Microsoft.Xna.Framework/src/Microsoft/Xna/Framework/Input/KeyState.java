package Microsoft.Xna.Framework.Input;

/**
 * Identifies the state of a keyboard key.
 *
 * @author Halofreak1990
 */
public enum KeyState
{
	/**
	 * The key is pressed.
	 */
	Down(1),
	/**
	 * The key is released.
	 */
	Up(0);
	
	private final int value;
	private KeyState(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}
