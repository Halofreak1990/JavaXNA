package Microsoft.Xna.Framework.Media;

import System.*;

/**
 * Provides access to an album in the media library.
 *
 * @author Halofreak1990
 */
public final class Album implements IEquatable<Album>, IDisposable
{
	private Artist artist;
	private TimeSpan duration;
	static Album Empty;
	private Genre genre;
	//private uint handle;
	private boolean hasArt;
	private int hashcode;
	private boolean isDisposed;
	private String name;
	private SongCollection songs;

	/**
	 * Gets the Artist of the Album.
	 */
	public Artist getArtist()
	{
		if (this.artist == Artist.Empty)
		{
			
		}

		return this.artist;
	}

	/**
	 * Gets the duration of the Album.
	 */
	public TimeSpan getDuration()
	{
		return this.duration;
	}

	/**
	 * Gets the Genre of the Album.
	 */
	public Genre getGenre()
	{
		return this.genre;
	}

	/**
	 * Gets a value indicating whether the Album has associated album art.
	 */
	public boolean HasArt()
	{
		ThrowIfDisposed();
		return this.hasArt;
	}

	/**
	 * Gets a value indicating whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		return this.isDisposed;
	}

	/**
	 * Gets the name of the Album.
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Gets a SongCollection that contains the songs on the album.
	 */
	public SongCollection getSongs()
	{
		return this.songs;
	}

	private Album()
	{
		this.name = "";
		this.artist = Artist.Empty;
		this.genre = Genre.Empty;
		this.songs = SongCollection.Empty;
		this.duration = TimeSpan.Zero;
	}

	/*
	Album(uint handle)
	{
		this.name = string.Empty;
		this.artist = Artist.Empty;
		this.genre = Genre.Empty;
		this.songs = SongCollection.Empty;
		this.duration = TimeSpan.Zero;
	}*/

	protected void finalize()
	{
		this.Dispose(false);
	}

	/**
	 * Immediately releases the unmanaged resources used by this object.
	 */
	@Override
	public void Dispose()
	{
		this.Dispose(true);
	}

	private void Dispose(boolean disposing)
	{
		if (!isDisposed)
		{
			this.isDisposed = true;

			// TODO: implement

			songs = SongCollection.Empty;
		}
	}

	private void ThrowIfDisposed()
	{
		if (this.isDisposed)
		{
			throw new ObjectDisposedException(this.getClass().toString(), "This object has already been disposed.");
		}
	}

	/**
	 * Determines whether the specified Object is equal to this Album.
	 * 
	 * @param obj
	 * Object to compare with this instance.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Album) ? this.Equals((Album)obj) : false;
	}

	/**
	 * Determines whether the specified Album is equal to this Album.
	 * 
	 * @param other
	 * Album to compare with this instance.
	 */
	@Override
	public boolean Equals(Album other)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Gets the hash code for this instance.
	 */
	@Override
	public int hashCode()
	{
		ThrowIfDisposed();

		if (this.hashcode == -1)
		{
			this.hashcode = this.name.hashCode();
		}

		return this.hashcode;
	}

	/**
	 * Returns a String representation of this Album.
	 */
	public String toString()
	{
		ThrowIfDisposed();

		return this.name;
	}
}
