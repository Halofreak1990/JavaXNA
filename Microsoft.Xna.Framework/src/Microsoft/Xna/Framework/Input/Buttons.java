package Microsoft.Xna.Framework.Input;

/**
 * Enumerates input device buttons.
 * 
 * @author Halofreak1990
 */
public enum Buttons
{
	/**
	 * A button
	 */
	A (0x1000),
	/**
	 * B button
	 */
	B (0x2000),
	/**
	 * Back button
	 */
	Back (0x20),
	/**
	 * Big Button
	 */
	BigButton (0x200),
	/**
	 * Directional pad down
	 */
	DPadDown (2),
	/**
	 * Directional pad left
	 */
	DPadLeft (4),
	/**
	 * Directional pad right
	 */
	DPadRight (8),
	/**
	 * Directional pad up
	 */
	DPadUp (1),
	/**
	 * Left bumper (shoulder) button
	 */
	LeftShoulder (0x100),
	/**
	 * Left stick button (pressing the left stick)
	 */
	LeftStick (0x40),
	/**
	 * Left stick is toward down
	 */
	LeftThumbstickDown (0x20000000),
	/**
	 * Left stick is towards the left
	 */
	LeftThumbstickLeft (0x200000),
	/**
	 * Left stick is towards the right
	 */
	LeftThumbstickRight (0x40000000),
	/**
	 * Left stick is towards up
	 */
	LeftThumbstickUp (0x1000000),
	/**
	 * Left trigger
	 */
	LeftTrigger (0x800000),
	/**
	 * Right bumper (shoulder) button
	 */
	RightShoulder (0x200),
	/**
	 * Right stick button (pressing the right stick)
	 */
	RightStick (0x80),
	/**
	 * Right stick is towards down
	 */
	RightThumbstickDown (0x2000000),
	/**
	 * Right stick is towards the left
	 */
	RightThumbstickLeft (0x8000000),
	/**
	 * Right stick is towards the right
	 */
	RightThumbstickRight (0x4000000),
	/**
	 * Right stick is towards up
	 */
	RightThumbstickUp (0x1000000),
	/**
	 * Right trigger
	 */
	RightTrigger (0x400000),
	/**
	 * START button
	 */
	Start (0x10),
	/**
	 * X button
	 */
	X (0x4000),
	/**
	 * Y button
	 */
	Y (0x8000);
	
	private final int value;
	Buttons(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
