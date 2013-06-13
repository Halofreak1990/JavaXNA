package Microsoft.Xna.Framework.GamerServices;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * 
 * 
 * @author Halofreak1990
 */
public class Guide
{
	private static boolean isVisible;
	private static Object syncObject = new Object();
	
	public static boolean IsVisible()
	{
		return isVisible;
	}
	
	static void setIsVisible(boolean value)
	{
		isVisible = value;
	}
	
	/**
	 * 
	 * @param player
	 * @param title
	 * @param description
	 * @param defaultText
	 * @param callback
	 * @param state
	 * @return
	 */
	public static IAsyncResult BeginShowKeyboardInput(PlayerIndex player, String title, String description, String defaultText, AsyncCallback callback, Object state)
	{		
		return BeginShowKeyboardInput(player, title, description, defaultText, callback, state, false);
	}
	
	/**
	 * 
	 * @param player
	 * @param title
	 * @param description
	 * @param defaultText
	 * @param callback
	 * @param state
	 * @param usePasswordMode
	 * @return
	 */
    public static IAsyncResult BeginShowKeyboardInput(PlayerIndex player, String title, String description, String defaultText, AsyncCallback callback, Object state, boolean usePasswordMode)
    {
    	if (title == null)
    		title = "";
    	
    	if (description == null)
    		description = "";
    	
    	if (defaultText == null)
    		defaultText = "";
    	
    	synchronized(syncObject)
    	{
    		if (isVisible)
        		throw new GuideAlreadyVisibleException();
    		
    		
    	}
    	
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param title
     * @param text
     * @param buttons
     * @param focusButton
     * @param icon
     * @param callback
     * @param state
     * @return
     */
    public static IAsyncResult BeginShowMessageBox(String title, String text, Iterable<String> buttons, int focusButton, MessageBoxIcon icon, AsyncCallback callback, Object state)
    {
    	return BeginShowMessageBox(PlayerIndex.One, title, text, buttons, focusButton, icon, callback, state);
    }
    
    /**
     * 
     * @param player
     * @param title
     * @param text
     * @param buttons
     * @param focusButton
     * @param icon
     * @param callback
     * @param state
     * @return
     */
    public static IAsyncResult BeginShowMessageBox(PlayerIndex player, String title, String text, Iterable<String> buttons, int focusButton, MessageBoxIcon icon, AsyncCallback callback, Object state)
    {
    	if (title == null)
    		title = "";
    	
    	if (text == null)
    		text = "";
    	
    	if (buttons == null)
    		throw new ArgumentNullException("buttons");
    	
    	synchronized(syncObject)
    	{
    		if (isVisible)
        		throw new GuideAlreadyVisibleException();
    		
    		
    	}
    	
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param delay
     */
    public static void DelayNotifications(TimeSpan delay)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param result
     * @return
     * 
     * @throws System.ArgumentNullException
     * 
     */
    public static String EndShowKeyboardInput(IAsyncResult result)
    {
    	if (result == null)
    		throw new ArgumentNullException("result");
    	
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param result
     * @return
     * 
     * @throws System.ArgumentNullException
     * 
     */
    public static Integer EndShowMessageBox(IAsyncResult result)
    {
    	if (result == null)
    		throw new ArgumentNullException("result");
    	
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     * @param text
     * @param recipients
     */
    public static void ShowComposeMessage(PlayerIndex player, String text, Iterable<Gamer> recipients)
    {
    	if (text == null)
    		text = "";
    	
    	if (recipients == null)
    		throw new ArgumentNullException("recipients");
    	
    	synchronized(syncObject)
    	{
    		if (isVisible)
        		throw new GuideAlreadyVisibleException();
    		
    		
    	}
    	
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     * @param gamer
     */
    public static void ShowFriendRequest(PlayerIndex player, Gamer gamer)
    {
    	if (gamer == null)
    		throw new ArgumentNullException("gamer");
    	
    	synchronized(syncObject)
    	{
    		if (isVisible)
        		throw new GuideAlreadyVisibleException();
    		
    		
    	}
    	
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     */
    public static void ShowFriends(PlayerIndex player)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param sessionId
     */
    public static void ShowGameInvite(String sessionId)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     * @param recipients
     */
    public static void ShowGameInvite(PlayerIndex player, Iterable<Gamer> recipients)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     * @param gamer
     */
    public static void ShowGamerCard(PlayerIndex player, Gamer gamer)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     */
    public static void ShowMarketplace(PlayerIndex player)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     */
    public static void ShowMessages(PlayerIndex player)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     */
    public static void ShowParty(PlayerIndex player)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     */
    public static void ShowPartySessions(PlayerIndex player)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     * @param gamer
     */
    public static void ShowPlayerReview(PlayerIndex player, Gamer gamer)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param player
     */
    public static void ShowPlayers(PlayerIndex player)
    {
    	throw new NotImplementedException();
    }
    
    /**
     * 
     * @param paneCount
     * @param onlineOnly
     */
    public static void ShowSignIn(int paneCount, boolean onlineOnly)
    {
    	throw new NotImplementedException();
    }
}
