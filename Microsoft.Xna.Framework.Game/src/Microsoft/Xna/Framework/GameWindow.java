package Microsoft.Xna.Framework;

import System.*;

/**
 * The system window associated with a Game.
 * 
 * @author Halofreak1990
 */
public abstract class GameWindow
{
	private String title;
	static final int DefaultClientHeight = 600;
    static final int DefaultClientWidth = 800;

    /**
     * The screen dimensions of the game window's client rectangle.
     */
	public abstract Rectangle getClientBounds();
	
	/**
	 * 
	 */
	public abstract DisplayOrientation getCurrentOrientation();
	
	abstract boolean IsMinimized();
	
	/**
	 * Gets the device name of the screen the window is currently in.
	 */
	public abstract String getScreenDeviceName();
	
	/**
	 * Gets the title of the system window.
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * Sets the title of the system window.
	 */
	public void setTitle(String title)
	{
		if (title == null)
		{
			throw new ArgumentNullException("title", "The title name cannot be null.  Use an empty string instead.");
		}
		if (this.title != title)
        {
            this.title = title;
            this.SetTitle(this.title);
        }
	}

	GameWindow()
	{
		this.title = "";
	}
	
	/**
	 * Sets the title of the GameWindow.
	 * 
	 * @param title
	 * The new title of the GameWindow.
	 */
	protected abstract void SetTitle(String title);

	/**
	 * Starts a device transition (windowed to full screen or vice versa).
	 * 
	 * @param willBeFullScreen
	 * Specifies whether the device will be in full-screen mode upon completion of the change.
	 */
	public abstract void BeginScreenDeviceChange(boolean willBeFullScreen);

	/**
	 * Completes a device transition.
	 * 
	 * @param screenDeviceName
	 * The desktop screen to move the window to. This should be the screen device name of the graphics device that has transitioned to full screen.
	 */
	public void EndScreenDeviceChange(String screenDeviceName)
	{
	    this.EndScreenDeviceChange(screenDeviceName, this.getClientBounds().Width, this.getClientBounds().Height);
	}

	/**
	 * Completes a device transition.
	 * 
	 * @param screenDeviceName
	 * The desktop screen to move the window to. This should be the screen device name of the graphics device that has transitioned to full screen.
	 * 
	 * @param clientWidth
	 * The new width of the game's client window.
	 * 
	 * @param clientHeight
	 * The new height of the game's client window.
	 */
	public abstract void EndScreenDeviceChange(String screenDeviceName, int clientWidth, int clientHeight);
}
