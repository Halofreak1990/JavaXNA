package Microsoft.Xna.Framework.GamerServices;

import java.util.EnumSet;

import System.*;

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

	/**
	 * Gets whether the local gamer who requested the friends list has received a friend request from this gamer.
	 */
	public boolean FriendRequestReceivedFrom()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets whether the local gamer who requested the friends list has sent a friend request to this gamer.
	 */
	public boolean FriendRequestSentTo()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets a title-defined presence string describing what this friend is currently doing.
	 */
	public String getPresence()
	{
		return presence;
	}

	FriendGamer(FriendCollection parent, String gamertag, String presence, EnumSet<FriendState> friendState)
	{
		this.friendState = friendState;
		this.parent = parent;
		this.presence = presence;
	}
}
