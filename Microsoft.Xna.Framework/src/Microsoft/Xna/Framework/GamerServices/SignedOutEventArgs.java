package Microsoft.Xna.Framework.GamerServices;

import System.EventArgs;

/**
 * 
 * 
 * @author Halofreak1990
 */
public class SignedOutEventArgs extends EventArgs
{
	private SignedInGamer gamer;
	
	/**
	 * Gets the gamer that just signed out.
	 */
	public SignedInGamer getSignedInGamer()
	{
		return gamer;
	}
	
	/**
	 * Creates a new instance of SignedInEventArgs.
	 * 
	 * @param gamer
	 * The gamer that just signed out.
	 */
	public SignedOutEventArgs(SignedInGamer gamer)
	{
		this.gamer = gamer;
	}
}
