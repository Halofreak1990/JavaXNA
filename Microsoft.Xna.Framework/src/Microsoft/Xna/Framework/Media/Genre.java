package Microsoft.Xna.Framework.Media;

import System.*;

/**
 * Provides access to genre information in the media library.
 * 
 * @author Halofreak1990
 */
public final class Genre implements IEquatable<Genre>, IDisposable
{
	/**
	 * Gets the AlbumCollection for the Genre.
	 */
	public AlbumCollection getAlbums()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets a value indicating whether the object is disposed.
	 */
	public boolean IsDisposed()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the name of the Genre.
	 */
	public String getName()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the SongCollection for the Genre.
	 */
	public SongCollection getSongs()
	{
		throw new NotImplementedException();
	}

	protected void finalize()
	{
		// TODO: implement
	}

	/**
	 * Immediately releases the unmanaged resources used by this object.
	 */
	@Override
	public void Dispose()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Determines whether the specified Genre is equal to this Genre.
	 * 
	 * @param other
	 * The Genre to compare with this instance.
	 */
	@Override
	public boolean Equals(Genre other)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Determines whether the specified Object is equal to this Genre.
	 * 
	 * @param obj
	 * The Object to compare with this instance.
	 */
	public boolean equals(Object obj)
	{
		return (obj instanceof Genre) ? Equals((Genre)obj) : false; 
	}

	/**
	 * Returns a String representation of the Genre.
	 */
	public String toString()
	{
		throw new NotImplementedException();
	}
}
