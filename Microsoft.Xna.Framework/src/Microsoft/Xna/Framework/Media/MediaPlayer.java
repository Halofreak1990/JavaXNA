package Microsoft.Xna.Framework.Media;

import System.*;

/**
 * Provides methods and properties to play, pause, resume, and stop songs. MediaPlayer also exposes shuffle, repeat, volume, play position, and visualization capabilities. Reference page contains links to related code samples.
 * 
 * @author Halofreak1990
 */
public class MediaPlayer
{
	private static MediaQueue queue;
	private static boolean repeat;
	private static boolean shuffle;
	private static MediaState state;

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
		return state;
	}

	private static void setState(MediaState value)
	{
		if (state != value)
		{
			state = value;

			if (MediaStateChanged.hasHandlers())
			{
				MediaStateChanged.raise(null, EventArgs.Empty);
			}
		}
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

	private static void NextSong(int direction)
	{
		// TODO: implement

		if (ActiveSongChanged.hasHandlers())
		{
			ActiveSongChanged.raise(null, EventArgs.Empty);
		}
	}

	/**
	 * Moves to the next song in the queue of playing songs.
	 */
	public static void MoveNext()
	{
		NextSong(1);
	}

	/**
	 * Moves to the previous song in the queue of playing songs.
	 */
	public static void MovePrevious()
	{
		NextSong(-1);
	}

	/**
	 * Pauses the currently playing song.
	 */
	public static void Pause()
	{
		if (state != MediaState.Playing || queue.getActiveSong() == null)
		{
			return;
		}

		// TODO: implement
		throw new NotImplementedException();
	}

	/**
	 * Plays a Song.
	 * 
	 * @param song
	 * Song to play.
	 */
	public static void Play(Song song)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * Plays a SongCollection.
	 * 
	 * @param songs
	 * SongCollection to play.
	 */
	public static void Play(SongCollection songs)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * Plays a SongCollection, starting with the Song at the specified index.
	 * 
	 * @param songs
	 * SongCollection to play.
	 * 
	 * @param index
	 * Index of the song in the collection at which playback should begin.
	 */
	public static void Play(SongCollection songs, int index)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * Resumes a paused song.
	 */
	public static void Resume()
	{
		if (state != MediaState.Paused)
		{
			return;
		}

		// TODO: implement
		throw new NotImplementedException();
	}

	/**
	 * Stops playing a song.
	 */
	public static void Stop()
	{
		if (!MediaStateChanged.hasHandlers())
		{
			MediaStateChanged.raise(null, EventArgs.Empty);
		}

		// TODO: implement
		throw new NotImplementedException();
	}
}
