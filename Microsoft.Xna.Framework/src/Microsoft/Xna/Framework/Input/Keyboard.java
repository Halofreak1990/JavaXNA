package Microsoft.Xna.Framework.Input;

import java.util.*;

/**
 * Allows retrieval of keystrokes from a keyboard input device. Reference page contains links to related code samples.
 * 
 * @author Halofreak1990
 */
public class Keyboard
{
	/**
	 * Returns the current keyboard state. Reference page contains links to related code samples.
	 */
	public static KeyboardState GetState()
	{
		org.lwjgl.input.Keyboard.poll();
		
		List<Keys> keys = new ArrayList<Keys>();
		
		while(org.lwjgl.input.Keyboard.next())
		{
			for (Keys k : Keys.values())
			{
				if ((k.getValue() == org.lwjgl.input.Keyboard.getEventKey()) && (org.lwjgl.input.Keyboard.getEventKeyState()))
				{
					keys.add(k);
				}
			}
		}
		Keys[] array = new Keys[keys.size()];
		keys.toArray(array);
		return new KeyboardState(array);
	}
}
