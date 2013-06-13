package Microsoft.Xna.Framework.Graphics;

import Microsoft.Xna.Framework.*;

/**
 * 
 * 
 * @author Halofreak1990
 */
public class PresentationParameters
{
	public int BackBufferWidth;
	public int BackBufferHeight;
	public SurfaceFormat BackBufferFormat;
	public DepthFormat DepthStencilFormat;
	public int MultiSampleCount;
	public DisplayOrientation DisplayOrientation;
	public PresentInterval PresentationInterval;
	public RenderTargetUsage RenderTargetUsage;
	public boolean IsFullScreen;
	
	public Rectangle getBounds()
	{
		return new Rectangle(0, 0, BackBufferWidth, BackBufferHeight);
	}
	
	public PresentationParameters()
	{
		this.IsFullScreen = true;
	}
	
	public PresentationParameters Clone()
	{
		PresentationParameters parameters = new PresentationParameters();
		parameters.BackBufferFormat = this.BackBufferFormat;
		parameters.BackBufferHeight = this.BackBufferHeight;
		parameters.BackBufferWidth = this.BackBufferWidth;
		parameters.DepthStencilFormat = this.DepthStencilFormat;
		parameters.DisplayOrientation = this.DisplayOrientation;
		parameters.IsFullScreen = this.IsFullScreen;
		parameters.MultiSampleCount = this.MultiSampleCount;
		parameters.PresentationInterval = this.PresentationInterval;
		parameters.RenderTargetUsage = this.RenderTargetUsage;
		return parameters;
	}
}
