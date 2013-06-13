package Microsoft.Xna.Framework.Media;

import System.*;

/**
 * Provides access to artist information in the media library.
 *
 * @author Halofreak1990
 */
public final class Artist implements IEquatable<Artist>, IDisposable
{
	private AlbumCollection albums;
    static Artist Empty;
    //private uint handle;
    private int hashcode;
    private boolean isDisposed;
    private String name;
    private SongCollection songs;

    /**
     * Gets a value indicating whether the object is disposed.
     */
    public boolean IsDisposed()
    {
    	return this.isDisposed;
    }
    
    /**
     * Gets the name of the Artist.
     */
    public String getName()
    {
    	ThrowIfDisposed();
    	return this.name;
    }
    
    private Artist()
    {
        //this.handle = uint.MaxValue;
        this.hashcode = -1;
        this.name = "";
        this.songs = SongCollection.Empty;
        this.albums = AlbumCollection.Empty;
    }
    
    /*Artist(uint handle)
    {
        this.handle = uint.MaxValue;
        this.hashcode = -1;
        this.name = "";
        this.songs = SongCollection.Empty;
        this.albums = AlbumCollection.Empty;
        this.handle = handle;
        if (this.IsValidHandle)
        {
            StringBuilder sbName = new StringBuilder(260);
            if (Helpers.Succeeded(UnsafeNativeMethods.MediaItem_GetName(handle, sbName, 260)))
            {
                this.name = sbName.ToString();
            }
        }
    }*/
    
	@Override
	public void Dispose()
	{
		this.Dispose(true);
	}
	
	private void Dispose(boolean disposing)
	{
		if (!this.isDisposed)
	    {
	        this.isDisposed = true;
	        // TODO: implement
	        /*if (this.IsValidHandle)
	        {
	            UnsafeNativeMethods.MediaItem_Release(this.handle);
	            this.handle = uint.MaxValue;
	        }*/
	    }
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof Artist) ? (this == (Artist)obj) : false;
	}
	
	@Override
	public boolean Equals(Artist other)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void finalize()
	{
		this.Dispose(false);
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
	
	private void ThrowIfDisposed()
	{
		if (this.isDisposed)
    		throw new ObjectDisposedException(super.toString(), "This object has already been disposed.");
	}
	
	/**
	 * Returns a String representation of the Artist.
	 */
	@Override
	public String toString()
	{
		ThrowIfDisposed();
		return this.name;
	}
	
	static
	{
		Empty = new Artist();
	}
}
