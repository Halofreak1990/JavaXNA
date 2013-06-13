package Microsoft.Xna.Framework.GamerServices;

import Microsoft.Xna.Framework.*;

/**
 * Wraps the functionality of the GamerServicesDispatcher.
 *
 * @author Halofreak1990
 */
public class GamerServicesComponent extends GameComponent
{
	/**
	 * Creates a new GamerServicesComponent.
	 * 
	 * @param game
	 * The game that will be associated with this component.
	 */
	public GamerServicesComponent(Game game)
	{
		super(game);
	}
	
	/**
	 * Initializes the GamerServicesDispatcher.
	 */
	@Override
	public void Initialize()
	{
		GamerServicesDispatcher.Initialize(super.getGame().getServices());
		super.Initialize();
	}
	
	/**
	 * Updates the GamerServicesDispatcher.
	 * 
	 * @param gameTime
	 * The game timing state.
	 */
	@Override
	public void Update(GameTime gameTime)
	{
		GamerServicesDispatcher.Update();
		super.Update(gameTime);
	}
}
