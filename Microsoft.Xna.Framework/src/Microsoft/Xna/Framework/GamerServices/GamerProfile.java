package Microsoft.Xna.Framework.GamerServices;

import System.*;
import Microsoft.Xna.Framework.Graphics.*;

/**
 * Profile settings describing information about a gamer such as the gamer's motto, reputation, and gamer picture. This data is accessible for both locally signed in profiles and remote gamers that you are playing with in a multiplayer session.
 * 
 * @author Halofreak1990
 */
public final class GamerProfile
{
	private boolean isDisposed = false;
	
	/**
	 * Gets the gamer picture, which will be 64 pixels by 64 pixels.
	 */
	public Texture2D getGamerPicture()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the GamerScore of this gamer.
	 */
	public int getGamerScore()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the GamerZone setting.
	 */
	public GamerZone getGamerZone()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets a value that indicates whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		return isDisposed;
	}
	
	/**
	 * Gets the gamer motto string.
	 */
	public String getMotto()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the gamer reputation, as a number of stars ranging 0 to 5.
	 */
	public float getReputation()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the number of titles this gamer has played.
	 */
	public int getTitlesPlayed()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the total number of achievements this gamer has obtained.
	 */
	public int getTotalAchievements()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Immediately releases the unmanaged resources used by this object.
	 */
	public void Dispose()
	{
		isDisposed = true;
	}
}
