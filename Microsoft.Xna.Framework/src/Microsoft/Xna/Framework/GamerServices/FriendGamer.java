package Microsoft.Xna.Framework.GamerServices;

import java.util.EnumSet;

/**
 * Provides the presence information of a friend of the local gamer.
 * 
 * @author Halofreak1990
 */
public final class FriendGamer extends Gamer
{
	private EnumSet<FriendState> friendState;
	private FriendCollection parent;
	private String presence;
	
	
	
	FriendGamer(FriendCollection parent, String gamertag, String presence, EnumSet<FriendState> friendState)
	{
		this.friendState = friendState;
		this.parent = parent;
		this.presence = presence;
	}
}
