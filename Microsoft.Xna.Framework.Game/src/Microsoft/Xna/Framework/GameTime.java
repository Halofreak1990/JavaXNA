package Microsoft.Xna.Framework;

import System.*;

/**
 * Snapshot of the game timing state expressed in values that can be used by variable-step (real time) or fixed-step (game time) games.
 * 
 * @author Halofreak1990
 */
public class GameTime
{
	private TimeSpan elapsedGameTime;
	private boolean isRunningSlowly;
	private TimeSpan totalGameTime;
	
	/**
	 * The amount of elapsed game time since the last update.
	 */
	public TimeSpan getElapsedGameTime()
	{
		return elapsedGameTime;
	}
	
	void setElapsedGameTime(TimeSpan value)
	{
		elapsedGameTime = value;
	}
	
	/**
	 * Gets a value indicating that the game loop is taking longer that its TargetElapsedTime. In this case, the game loop can be considered to be running too slowly and should do something to "catch up".
	 */
	public boolean getIsRunningSlowly()
	{
		return isRunningSlowly;
	}
	
	void setIsRunningSlowly(boolean value)
	{
		isRunningSlowly = value;
	}
	
	/**
	 * The amount of game time since the start of the game.
	 */
	public TimeSpan getTotalGameTime()
	{
		return totalGameTime;
	}
	
	void setTotalGameTime(TimeSpan totalGameTime)
	{
		this.totalGameTime = totalGameTime;
	}

	/**
	 * Creates a new instance of GameTime.
	 */
	public GameTime()
	{
		elapsedGameTime = TimeSpan.Zero;
		isRunningSlowly = false;
		totalGameTime = TimeSpan.Zero;
	}
	
	/**
	 * Creates a new instance of GameTime.
	 * 
	 * @param totalGameTime
	 * The amount of game time since the start of the game.
	 * 
	 * @param elapsedGameTime
	 * The amount of elapsed game time since the last update.
	 */
	public GameTime(TimeSpan totalGameTime, TimeSpan elapsedGameTime)
	{
		this(totalGameTime, elapsedGameTime, false);
	}
	
	/**
	 * Creates a new instance of GameTime.
	 * 
	 * @param totalGameTime
	 * The amount of game time since the start of the game.
	 * 
	 * @param elapsedGameTime
	 * The amount of elapsed game time since the last update.
	 * 
	 * @param isRunningSlowly
	 * Whether the game is running multiple updates this frame.
	 */
	public GameTime(TimeSpan totalGameTime, TimeSpan elapsedGameTime, boolean isRunningSlowly)
	{
		this.totalGameTime = totalGameTime;
		this.elapsedGameTime = elapsedGameTime;
		this.isRunningSlowly = isRunningSlowly;
	}
}
