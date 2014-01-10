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
	 * Raised when the active song changes due to active playback or due to explicit calls to the MoveNext or MovePrevious methods.
	 */
	public static final Event<EventArgs> ActiveSongChanged = new Event<EventArgs>();

	/**
	 * Raised when the media player play state changes.
	 */
	public static final Event<EventArgs> MediaStateChanged = new Event<EventArgs>();

	/**
	 * 
	 */
	public static void MoveNext()
	{
		if (!ActiveSongChanged.hasHandlers())
		{
			ActiveSongChanged.raise(null, EventArgs.Empty);
		}
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
	}

	/**
	 * 
	 * @param song
	 */
	public static void Play(Song song)
	{
		
	}

	/**
	 * 
	 * @param songs
	 */
	public static void Play(SongCollection songs)
	{
		
	}

	/**
	 * 
	 * @param songs
	 * @param index
	 */
	public static void Play(SongCollection songs, int index)
	{
		
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
	}

	static
	{
		repeat = false;
		shuffle = false;
		queue = new MediaQueue();
	}
}
