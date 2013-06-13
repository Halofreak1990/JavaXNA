package Microsoft.Xna.Framework.GamerServices;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * 
 * @author Halofreak1990
 */
public final class SignedInGamer extends Gamer
{
	private boolean isGuest;
	private PlayerIndex playerIndex;
	
	public static final Event<SignedInEventArgs> SignedIn = new Event<SignedInEventArgs>();
	public static final Event<SignedOutEventArgs> SignedOut = new Event<SignedOutEventArgs>();
	
	/**
	 * 
	 * @return
	 */
	public PlayerIndex getPlayerIndex()
	{
		return playerIndex;
	}
	
	public FriendCollection GetFriends()
	{
		return null;
	}
	
	/**
	 * 
	 * @param gamer
	 * @return
	 */
	public boolean IsFriend(Gamer gamer)
	{
		// TODO: implement
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean IsGuest()
	{
		return isGuest;
	}
}
