package Microsoft.Xna.Framework;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.DisplayMode;

import Microsoft.Xna.Framework.Graphics.*;

class JavaGameWindow extends GameWindow
{
	private boolean willBeFullScreen;
	private boolean inTransition;
	private String screenDeviceName;
	private Rectangle clientBounds;
	private Game game;
	
	@Override
	public Rectangle getClientBounds()
	{
		return clientBounds;
	}
	
	@Override
	public DisplayOrientation getCurrentOrientation()
	{
		// TODO Auto-generated method stub
		return DisplayOrientation.Default;
	}

	@Override
	boolean IsMinimized()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getScreenDeviceName()
	{
		return this.screenDeviceName;
	}
	
	public JavaGameWindow(Game game)
	{
		super();
		this.game = game;
		this.screenDeviceName = "";
		this.clientBounds = new Rectangle(0, 0, DefaultClientWidth, DefaultClientHeight);
	}

	@Override
	protected void SetTitle(String title)
	{
		Display.setTitle(title);
	}

	@Override
	public void BeginScreenDeviceChange(boolean willBeFullScreen)
	{
		inTransition = true;
		this.willBeFullScreen = willBeFullScreen;
	}

	@Override
	public void EndScreenDeviceChange(String screenDeviceName, int clientWidth, int clientHeight)
	{
		this.screenDeviceName = screenDeviceName;
		int bitsPerPixel = 0;
		SurfaceFormat format;
		if (game.getGraphicsDevice() == null)
		{
			GraphicsDeviceManager graphicsManager = (GraphicsDeviceManager)game.getServices().GetService(IGraphicsDeviceManager.class);
			format = graphicsManager.PreferredBackBufferFormat;
		}
		else
			format = game.getGraphicsDevice().getPresentationParameters().BackBufferFormat;
		
		if (format == SurfaceFormat.Color)
			bitsPerPixel = 32;
		try
		{
			Display.setDisplayMode(new DisplayMode(clientWidth, clientHeight));
			Display.setFullscreen(willBeFullScreen);
			this.clientBounds.Width = clientWidth;
			this.clientBounds.Height = clientHeight;
		}
		catch (LWJGLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inTransition = false;
	}

	void Create(String screenDeviceName, int backBufferWidth, int backBufferHeight, boolean isFullScreen)
	{
		BeginScreenDeviceChange(isFullScreen);
		EndScreenDeviceChange("", backBufferWidth, backBufferHeight); 
	}
}
