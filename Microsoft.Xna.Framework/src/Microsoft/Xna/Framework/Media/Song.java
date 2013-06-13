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

	private Song()
	{
		
	}
	
	Song(String name, String fileName, int duration)
	{
		
	}
	
	@Override
	public void Dispose()
	{
		this.Dispose(true);
	}
	
	private void Dispose(boolean disposing)
	{
		
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof Song) ? Equals((Song)obj) : false;
	}
	
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
		
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public int hashCode()
	{
		
	}
	
	private void ThrowIfDisposed()
	{
		if (this.isDisposed)
			throw new ObjectDisposedException(this.toString(), "This object has already been disposed.");
	}
	
	@Override
	public String toString()
	{
		
	}
}
