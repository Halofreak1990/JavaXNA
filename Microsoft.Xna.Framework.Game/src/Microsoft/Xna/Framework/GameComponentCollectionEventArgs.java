package Microsoft.Xna.Framework;

import System.*;

/**
 * Arguments used with events from the GameComponentCollection.
 *
 * @author Halofreak1990
 */
public class GameComponentCollectionEventArgs extends EventArgs
{
	private IGameComponent gameComponent;
	
	/**
	 * Creates a new instance of GameComponentCollectionEventArgs.
	 * 
	 * @param gameComponent
	 * The GameComponent affected by the event.
	 */
	public GameComponentCollectionEventArgs(IGameComponent gameComponent)
	{
		this.gameComponent = gameComponent;
	}
	
	/**
	 * Gets the GameComponent affected by the event.
	 */
	public IGameComponent getGameComponent()
	{
		return this.gameComponent;
	}
}
