package Microsoft.Xna.Framework.GamerServices;

import System.EventArgs;

/**
 * 
 * 
 * @author Halofreak1990
 */
public class SignedInEventArgs extends EventArgs
{
	private SignedInGamer gamer;
	
	/**
	 * Gets the gamer that just signed in.
	 */
	public SignedInGamer getSignedInGamer()
	{
		return gamer;
	}
	
	/**
	 * Creates a new instance of SignedInEventArgs.
	 * 
	 * @param gamer
	 * The gamer that just signed in.
	 */
	public SignedInEventArgs(SignedInGamer gamer)
	{
		this.gamer = gamer;
	}
}
