package Microsoft.Xna.Framework;

import System.*;

/**
 * Defines the interface for a drawable game component.
 * 
 * @author Halofreak1990
 */
public interface IDrawable
{
	/**
	 * The order in which to draw this object relative to other objects. Objects with a lower value are drawn first.
	 */
	int getDrawOrder();
	
	/**
	 * Indicates whether IDrawable.Draw should be called in Game.Draw for this game component.
	 */
	boolean getVisible();
	
	/**
	 * Draws the IDrawable. Reference page contains links to related conceptual articles.
	 * 
	 * @param gameTime
	 * Snapshot of the game's timing state.
	 */
	void Draw(GameTime gameTime);
	
	/**
	 * Raised when the DrawOrder property changes.
	 */
	Event<EventArgs> DrawOrderChanged = new Event<EventArgs>();
	
	/**
	 * Raised when the Visible property changes. 
	 */
	Event<EventArgs> VisibleChanged = new Event<EventArgs>();
}
