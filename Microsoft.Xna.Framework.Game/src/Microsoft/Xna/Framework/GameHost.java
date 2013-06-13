package Microsoft.Xna.Framework;

import org.lwjgl.opengl.*;

class GameHost implements IGameHost
{
	private boolean isExiting;
	private Game game;    
	private JavaGameWindow window;
	
	@Override
	public GameWindow getWindow()
	{
		return this.window;
	}
	
	public GameHost(Game game)
	{
		this.game = game;
		this.isExiting = false;
	}

	@Override
	public void EnsureHost()
	{
		this.game.StartTime = System.nanoTime();
		
		this.window = new JavaGameWindow(this.game);
	}

	@Override
	public void Initialize()
	{
		GraphicsDeviceManager graphicsManager = (GraphicsDeviceManager)game.getServices().GetService(IGraphicsDeviceManager.class);
		
		this.window.Create("", graphicsManager.BackBufferWidth, graphicsManager.BackBufferHeight, graphicsManager.IsFullScreen);
		
		// Sdl.SDL_ShowCursor(game.IsMouseVisible ? Sdl.SDL_ENABLE : Sdl.SDL_DISABLE); 
	}

	@Override
	public void Run()
	{
		while(!isExiting)
		{
			// maybe poll some events
			
			if (!Display.isCloseRequested())
				game.Tick();
			else
				break;
		}
	}

	@Override
	public void Exit()
	{
		isExiting = true;
	}
}
