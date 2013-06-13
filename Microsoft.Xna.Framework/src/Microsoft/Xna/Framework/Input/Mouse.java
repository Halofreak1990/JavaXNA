package Microsoft.Xna.Framework.Input;

import org.lwjgl.LWJGLException;

/**
 * Allows retrieval of position and button clicks from a mouse input device.
 * 
 * @author Halofreak1990
 */
public class Mouse
{
	/**
	 * Gets the current state of the mouse, including mouse position and buttons pressed.
	 * 
	 * @return
	 * Current state of the mouse.
	 */
	public static MouseState GetState()
	{
		if (!org.lwjgl.input.Mouse.isCreated())
		{
			try
			{
				org.lwjgl.input.Mouse.create();
			}
			catch (LWJGLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int x = 0, y = 0, wheel = 0;
		ButtonState leftButton = ButtonState.Released;
		ButtonState middleButton = ButtonState.Released;
		ButtonState rightButton = ButtonState.Released;
		ButtonState xButton1 = ButtonState.Released;
		ButtonState xButton2 = ButtonState.Released;
		
		if (org.lwjgl.input.Mouse.isInsideWindow())
		{
			x = org.lwjgl.input.Mouse.getX();
			y = org.lwjgl.input.Mouse.getY();
			
			// set wheel only if the mouse actually has one
			if (org.lwjgl.input.Mouse.hasWheel())
			{
				wheel = org.lwjgl.input.Mouse.getDWheel();
			}
			
			switch(org.lwjgl.input.Mouse.getButtonCount())
			{
			case 1:
				leftButton = (org.lwjgl.input.Mouse.isButtonDown(0)) ? ButtonState.Pressed : ButtonState.Released;
				break;
			case 2:
				leftButton = (org.lwjgl.input.Mouse.isButtonDown(0)) ? ButtonState.Pressed : ButtonState.Released;
				rightButton = (org.lwjgl.input.Mouse.isButtonDown(1)) ? ButtonState.Pressed : ButtonState.Released;
				break;
			case 3:
				leftButton = (org.lwjgl.input.Mouse.isButtonDown(0)) ? ButtonState.Pressed : ButtonState.Released;
				middleButton = (org.lwjgl.input.Mouse.isButtonDown(2)) ? ButtonState.Pressed : ButtonState.Released;
				rightButton = (org.lwjgl.input.Mouse.isButtonDown(1)) ? ButtonState.Pressed : ButtonState.Released;
				break;
			case 4:
				leftButton = (org.lwjgl.input.Mouse.isButtonDown(0)) ? ButtonState.Pressed : ButtonState.Released;
				middleButton = (org.lwjgl.input.Mouse.isButtonDown(2)) ? ButtonState.Pressed : ButtonState.Released;
				rightButton = (org.lwjgl.input.Mouse.isButtonDown(1)) ? ButtonState.Pressed : ButtonState.Released;
				xButton1 = (org.lwjgl.input.Mouse.isButtonDown(3)) ? ButtonState.Pressed : ButtonState.Released;
				break;
			case 5:
				leftButton = (org.lwjgl.input.Mouse.isButtonDown(0)) ? ButtonState.Pressed : ButtonState.Released;
				middleButton = (org.lwjgl.input.Mouse.isButtonDown(2)) ? ButtonState.Pressed : ButtonState.Released;
				rightButton = (org.lwjgl.input.Mouse.isButtonDown(1)) ? ButtonState.Pressed : ButtonState.Released;
				xButton1 = (org.lwjgl.input.Mouse.isButtonDown(3)) ? ButtonState.Pressed : ButtonState.Released;
				xButton2 = (org.lwjgl.input.Mouse.isButtonDown(4)) ? ButtonState.Pressed : ButtonState.Released;
				break;
			} 
		}
		return new MouseState(x, y, wheel, leftButton, middleButton, rightButton, xButton1, xButton2);
	}
	
	/**
	 * Sets the position of the mouse cursor relative to the upper-left corner of the window.
	 * 
	 * @param x
	 * The horizontal position of the mouse cursor, relative to the left edge of the game window.
	 * 
	 * @param y
	 * The vertical position of the mouse cursor, relative to the upper edge of the game window.
	 */
	public static void SetPosition(int x, int y)
	{
		/*if (!org.lwjgl.input.Mouse.isCreated())
			try
			{
				org.lwjgl.input.Mouse.create();
			}
			catch (LWJGLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
		org.lwjgl.input.Mouse.setCursorPosition(x, y);
	}
}
