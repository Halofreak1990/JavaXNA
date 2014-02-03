import Microsoft.Xna.Framework.*;
import Microsoft.Xna.Framework.Audio.*;
import Microsoft.Xna.Framework.Content.*;
import Microsoft.Xna.Framework.GamerServices.*;
import Microsoft.Xna.Framework.Graphics.*;
import Microsoft.Xna.Framework.Input.*;
import Microsoft.Xna.Framework.Input.Touch.*;
import Microsoft.Xna.Framework.Net.*;

/**
 * This is the main type for your game
 */
public class Game1 extends Game
{
	private GraphicsDeviceManager graphics;
	private SpriteBatch spriteBatch;
	private Texture2D background;
	
	public Game1()
	{
		graphics = new GraphicsDeviceManager(this);
		Content.setRootDirectory("");
	}
	
	/**
	 * Allows the game to perform any initialization it needs to before starting to run.
	 * This is where it can query for any required services and load any non-graphic
	 * related content. Calling base.Initialize will enumerate through any components
	 * and initialize them as well.
	 */
	@Override
	public void Initialize()
	{
		// TODO: Add your initialization logic here
		
		super.Initialize();
	}
	
	/**
	 * LoadContent will be called once per game and is the place to load
	 * all of your content.
	 */
	@Override
	public void LoadContent()
	{
		spriteBatch = new SpriteBatch(getGraphicsDevice());
		
		background = Texture2D.FromStream(getGraphicsDevice(), TitleContainer.OpenStream("test.png"));
		
		//background = Content.Load("test.png");
		
		// TODO: use this.Content to load your game content here
	}
	
	/**
	 * UnloadContent will be called once per game and is the place to unload
	 * all content.
	 */
	@Override
	protected void UnloadContent()
	{
		// TODO: Unload any non ContentManager content here
	}
	
	/**
	 * Allows the game to run logic such as updating the world, 
	 * checking for collisions, gathering input, and playing audio.
	 * 
	 * @param gameTime
	 * Provides a snapshot of timing values.
	 */
	@Override
	protected void Update(GameTime gameTime)
	{
		if (Keyboard.GetState().IsKeyDown(Keys.Escape))
			this.Exit();
		
		/*if (Mouse.GetState().LeftButton == ButtonState.Pressed)
			this.Exit();*/
		
		// TODO: Add your update logic here
		
		super.Update(gameTime);
	}
	
	/**
	 * This is called when the game should draw itself.
	 * 
	 * @param gameTime
	 * Provides a snapshot of timing values.
	 */
	@Override
	protected void Draw(GameTime gameTime)
	{
		getGraphicsDevice().Clear(Color.CornflowerBlue);
		
		spriteBatch.Begin();
		spriteBatch.Draw(background, new Vector2(0,0), Color.White);
		spriteBatch.End();
		
		// TODO: Add your drawing code here
		
		super.Draw(gameTime);
	}
}
