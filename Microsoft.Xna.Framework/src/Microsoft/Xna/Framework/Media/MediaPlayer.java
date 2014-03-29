package Microsoft.Xna.Framework.Media;

import System.*;

/**
 * Provides methods and properties to play, pause, resume, and stop songs. MediaPlayer also exposes shuffle, repeat, volume, play position, and visualization capabilities. Reference page contains links to related code samples.
 * 
 * @author Halofreak1990
 */
public class MediaPlayer
{
	private static boolean repeat;
	private static boolean shuffle;
	private static MediaQueue queue;

	/**
	 * Gets the media playback queue, MediaQueue.
	 */
	public static MediaQueue getQueue()
	{
		return queue;
	}

	/**
	 * Gets the media playback state.
	 */
	public MediaState getState()
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * Raised when the active song changes due to active playback or due to explicit calls to the MoveNext or MovePrevious methods.
	 */
	public static final Event<EventArgs> ActiveSongChanged = new Event<EventArgs>();

	/**
	 * Raised when the media player play state changes.
	 */
	public static final Event<EventArgs> MediaStateChanged = new Event<EventArgs>();

	static
	{
		repeat = false;
		shuffle = false;
		queue = new MediaQueue();
	}

	private MediaPlayer()
	{
	}

	/**
	 * 
	 */
	public static void MoveNext()
	{
		if (!ActiveSongChanged.hasHandlers())
		{
			ActiveSongChanged.raise(null, EventArgs.Empty);
		}

		// TODO: implement
	}

	/**
	 * 
	 */
	public static void MovePrevious()
	{
		if (!ActiveSongChanged.hasHandlers())
		{
			ActiveSongChanged.raise(null, EventArgs.Empty);
		}

		// TODO: implement
	}

	/**
	 * 
	 */
	public static void Pause()
	{
		if (!MediaStateChanged.hasHandlers())
		{
			MediaStateChanged.raise(null, EventArgs.Empty);
		}

		// TODO: implement
	}

	/**
	 * 
	 * @param song
	 */
	public static void Play(Song song)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * 
	 * @param songs
	 */
	public static void Play(SongCollection songs)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * 
	 * @param songs
	 * @param index
	 */
	public static void Play(SongCollection songs, int index)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	public static void Resume()
	{
		if (!MediaStateChanged.hasHandlers())
		{
			MediaStateChanged.raise(null, EventArgs.Empty);
		}

		// TODO: implement
	}

	/**
	 * 
	 */
	public static void Stop()
	{
		if (!MediaStateChanged.hasHandlers())
		{
			MediaStateChanged.raise(null, EventArgs.Empty);
		}

		// TODO: implement
	}
}
