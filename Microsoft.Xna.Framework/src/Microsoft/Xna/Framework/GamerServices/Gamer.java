package Microsoft.Xna.Framework.GamerServices;

import System.*;

/**
 * 
 * @author Halofreak1990
 */
public abstract class Gamer
{
	private String displayName;
    private String gamerTag;
    private boolean isDisposed;
    public Object Tag;
    
    /**
     * 
     * @return
     */
    public String getDisplayName()
    {
    	return this.displayName;
    }
    
    /**
     * 
     * @param value
     */
    void setDisplayName(String value)
    {
    	this.displayName = value;
    }
    
    /**
     * Gets the gamertag string.
     */
    public String getGamerTag()
    {
    	return this.gamerTag;
    }
    
    /**
     * Gets a value indicating whether the object is disposed.
     */
    public boolean IsDisposed()
    {
    	return this.isDisposed;
    }

    /**
     * 
     * @param gamertag
     * @param callback
     * @param asyncState
     * @return
     */
	public static IAsyncResult BeginGetFromGamertag(String gamertag, AsyncCallback callback, Object asyncState)
	{
		throw new NotSupportedException("This feature is only available to registered Xbox LIVE developers.");
	}
	
	/**
	 * 
	 * @param audienceUri
	 * @param callback
	 * @param asyncState
	 * @return
	 */
    public static IAsyncResult BeginGetPartnerToken(String audienceUri, AsyncCallback callback, Object asyncState)
    {
    	throw new NotSupportedException("This feature is only available to registered Xbox LIVE developers.");
    }
    
    /**
     * Starts an asynchronous profile read operation.
     * 
     * @param callback
     * The method to be called once the asynchronous operation has finished.
     * 
     * @param asyncState
     * State of the asynchronous operation.
     */
    public IAsyncResult BeginGetProfile(AsyncCallback callback, Object asyncState)
    {
    	throw new NotImplementedException();
    }
    
    public static Gamer EndGetFromGamertag(IAsyncResult result)
    {
    	throw new NotSupportedException("This feature is only available to registered Xbox LIVE developers.");
    }
    
    public static String EndGetPartnerToken(IAsyncResult result)
    {
    	throw new NotSupportedException("This feature is only available to registered Xbox LIVE developers.");
    }
    
    /**
     * Ends an asynchronous profile read operation.
     * 
     * @param result
     * An IAsyncResult used to track the progress of the operation.
     * 
     * @return
     * 
     */
    public GamerProfile EndGetProfile(IAsyncResult result)
    {
    	if (result == null)
    		throw new ArgumentNullException("result");
    	
    	throw new NotImplementedException();
    }
    
    public static Gamer GetFromGamertag(String gamertag)
    {
    	throw new NotSupportedException("This feature is only available to registered Xbox LIVE developers.");
    }

    public static String GetPartnerToken(String audienceUri)
    {
    	throw new NotSupportedException("This feature is only available to registered Xbox LIVE developers.");
    }
    
    /**
     * Reads profile data for this gamer.
     */
    public GamerProfile GetProfile()
    {
    	return this.EndGetProfile(this.BeginGetProfile(null, null));
    }
    
    /**
     * 
     */
    @Override
    public String toString()
    {
    	return this.gamerTag;
    }
}
