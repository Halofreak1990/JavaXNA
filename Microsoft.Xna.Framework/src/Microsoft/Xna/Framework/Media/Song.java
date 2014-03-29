package Microsoft.Xna.Framework.Media;

import System.*;

/**
 * Provides access to a song in the song library.
 *
 * @author Halofreak1990
 */
public final class Song implements IEquatable<Song>, IDisposable
{
	private Album album;
	private Artist artist;
	private boolean isDisposed;

	/**
	 * Gets the Album on which the Song appears.
	 */
	public Album getAlbum()
	{
		return this.album;
	}

	/**
	 * Gets the Artist of the Song.
	 */
	public Artist getArtist()
	{
		return this.artist;
	}

	/**
	 * Gets a value indicating whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		return this.isDisposed;
	}

	private Song()
	{
	}

	Song(String name, String fileName, int duration)
	{
		
	}

	private void Dispose(boolean disposing)
	{
		
	}

	@Override
	public void Dispose()
	{
		this.Dispose(true);
	}

	/**
	 * 
	 * 
	 * @param obj
	 * 
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj != null && obj instanceof Song) ? this.Equals((Song)obj) : false;
	}

	/**
	 * 
	 * 
	 * @param other
	 * 
	 */
	@Override
	public boolean Equals(Song other)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	protected void finalize()
	{
		this.Dispose(false);
	}

	/**
	 * 
	 * @param name
	 * @param uri
	 * @return
	 */
	public static Song FromUri(String name, Uri uri)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public int hashCode()
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	private void ThrowIfDisposed()
	{
		if (this.isDisposed)
		{
			throw new ObjectDisposedException(this.getClass().toString(), "This object has already been disposed.");
		}
	}

	/**
	 * 
	 */
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}
}
