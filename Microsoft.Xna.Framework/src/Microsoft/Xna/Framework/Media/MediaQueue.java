package Microsoft.Xna.Framework.Media;

import java.util.Random;

import System.*;

/**
 * Provides methods and properties to access and control the queue of playing songs.
 * 
 * @author Halofreak1990
 */
public final class MediaQueue
{
	private int activeSongIndex = -1;
	private Random random = new Random();

	/**
	 * Gets the current Song in the queue of playing songs.
	 * 
	 * @return
	 * The current Song in the queue of playing songs.
	 */
	public Song getActiveSong()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the index of the current (active) song in the queue of playing songs.
	 * 
	 * @return
	 * The index of the current (active) song in the queue of playing songs.
	 */
	public int getActiveSongIndex()
	{
		return activeSongIndex;
	}

	/**
	 * Sets the index of the current (active) song in the queue of playing songs.
	 * 
	 * @param value
	 */
	public void setActiveSongIndex(int value)
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the amount of songs in the MediaQueue.
	 * 
	 * @return
	 * The amount of songs in the MediaQueue.
	 */
	public int getCount()
	{
		throw new NotImplementedException();
	}

	MediaQueue()
	{
	}

	/**
	 * Gets the Song at the specified index in the MediaQueue.
	 * 
	 * @param index
	 * 
	 * @return
	 */
	public Song get(int index)
	{
		throw new NotImplementedException();
	}
}
