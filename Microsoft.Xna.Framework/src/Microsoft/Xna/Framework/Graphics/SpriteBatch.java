package Microsoft.Xna.Framework.Graphics;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.*;
import org.lwjgl.opengl.*;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Enables a group of Sprites to be drawn using the same settings.
 * 
 * @author Halofreak1990
 */
public class SpriteBatch extends GraphicsResource
{
	private BlendState blendState;
    private Effect customEffect;
    private DepthStencilState depthStencilState;
	private boolean disposed;
	private final int MaxBatchSize = 0x800;
	private List<Sprite> spriteList = new ArrayList<Sprite>();
	private SpriteSortMode sortMode;
	private boolean isRunning = false;
	//private SaveStateMode stateMode;
	//private StateBlock saveState;
	
	/**
	 * 
	 * @param graphics
	 * 
	 * @throws System.ArgumentNullException
	 * graphics is null.
	 */
	public SpriteBatch(GraphicsDevice graphics)
	{
		if (graphics == null)
		{
			throw new ArgumentNullException("graphics");
		}
		
		this._parent = graphics;
	}
	
	protected void finalize()
	{
		Dispose(false);
	}
	
	public GraphicsDevice getGraphicsDevice()
	{
		return this._parent;
	}
	
	public boolean IsDisposed()
	{
		return disposed;
	}
	
	public String Name;
	public Object Tag;
	
	private void applyGraphicsDeviceSettings()
	{
		// Set the blend mode
		if (blendState == BlendState.AlphaBlend)
		{
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		}
		else if (blendState == BlendState.Additive)
		{
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		}
		else
		{
			throw new NotSupportedException("The given blend mode isn't yet supported.");
		}
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		IntBuffer viewport = ByteBuffer.allocateDirect(64).asIntBuffer();
		GL11.glGetInteger(GL11.GL_VIEWPORT, viewport);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glOrtho(0, viewport.get(2), viewport.get(3), 0, -1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
	}
	
	/**
	 * Begins a sprite batch operation using deferred sort and default state objects (BlendState.AlphaBlend, SamplerState.LinearClamp, DepthStencilState.None, RasterizerState.CullCounterClockwise).
	 */
	public void Begin()
	{
		this.Begin(
			SpriteSortMode.Deferred, 
			BlendState.AlphaBlend, 
			SamplerState.LinearClamp, 
			DepthStencilState.None, 
			RasterizerState.CullCounterClockwise, 
			null, 
			Matrix.getIdentity()
		);
	}
	
	/**
	 * Begins a sprite batch operation using the specified sort and blend state object and default state objects (DepthStencilState.None, SamplerState.LinearClamp, RasterizerState.CullCounterClockwise). If you pass a null blend state, the default is BlendState.AlphaBlend.
	 * 
	 * @param sortMode
	 * Sprite drawing order.
	 * 
	 * @param blendState
	 * Blending options.
	 */
	public void Begin(SpriteSortMode sortMode, BlendState blendState)
	{
		this.Begin(
			sortMode,
			blendState,
			SamplerState.LinearClamp,
			DepthStencilState.None,
			RasterizerState.CullCounterClockwise,
			null,
			Matrix.getIdentity()
		);
	}
	
	/**
	 * Begins a sprite batch operation using the specified sort, blend, sampler, depth stencil and rasterizer state objects. Passing null for any of the state objects selects the default default state objects (BlendState.AlphaBlend, SamplerState.LinearClamp, DepthStencilState.None, RasterizerState.CullCounterClockwise).
	 * 
	 * @param sortMode
	 * Sprite drawing order.
	 * 
	 * @param blendState
	 * Blending options.
	 * 
	 * @param samplerState
	 * Texture sampling options.
	 * 
	 * @param depthStencilState
	 * Depth and stencil options.
	 * 
	 * @param rasterizerState
	 * Rasterization options.
	 */
	public void Begin(SpriteSortMode sortMode, BlendState blendState, SamplerState samplerState, DepthStencilState depthStencilState, RasterizerState rasterizerState)
	{
		this.Begin(
			sortMode, 
			blendState,
			samplerState == null ? SamplerState.LinearClamp : samplerState,
			depthStencilState,
			rasterizerState == null ? RasterizerState.CullCounterClockwise : rasterizerState,
			null,
			Matrix.getIdentity()
		);
	}
	
	/**
	 * Begins a sprite batch operation using the specified sort, blend, sampler, depth stencil and rasterizer state objects, plus a custom effect. Passing null for any of the state objects selects the default default state objects (BlendState.AlphaBlend, DepthStencilState.None, RasterizerState.CullCounterClockwise, SamplerState.LinearClamp). Passing a null effect selects the default SpriteBatch Class shader.
	 * 
	 * @param sortMode
	 * Sprite drawing order.
	 * 
	 * @param blendState
	 * Blending options.
	 * 
	 * @param samplerState
	 * Texture sampling options.
	 * 
	 * @param depthStencilState
	 * Depth and stencil options.
	 * 
	 * @param rasterizerState
	 * Rasterization options.
	 * 
	 * @param effect
	 * Effect state options.
	 */
	public void Begin(SpriteSortMode sortMode, BlendState blendState, SamplerState samplerState, DepthStencilState depthStencilState, RasterizerState rasterizerState, Effect effect)
	{
		this.Begin(
			sortMode, 
			blendState, 
			samplerState == null ? SamplerState.LinearClamp : samplerState, 
			depthStencilState, 
			rasterizerState == null ? RasterizerState.CullCounterClockwise : rasterizerState, 
			effect, 
			Matrix.getIdentity()
		);
	}
	
	/**
	 * Begins a sprite batch operation using the specified sort, blend, sampler, depth stencil, rasterizer state objects, plus a custom effect and a 2D transformation matrix. Passing null for any of the state objects selects the default default state objects (BlendState.AlphaBlend, DepthStencilState.None, RasterizerState.CullCounterClockwise, SamplerState.LinearClamp). Passing a null effect selects the default SpriteBatch Class shader.
	 * 
	 * @param sortMode
	 * Sprite drawing order.
	 * 
	 * @param blendState
	 * Blending options.
	 * 
	 * @param samplerState
	 * Texture sampling options.
	 * 
	 * @param depthStencilState
	 * Depth and stencil options.
	 * 
	 * @param rasterizerState
	 * Rasterization options.
	 * 
	 * @param effect
	 * Effect state options.
	 * 
	 * @param transformMatrix
	 * Transformation matrix for scale, rotate, translate options.
	 */
	public void Begin(SpriteSortMode sortMode, BlendState blendState, SamplerState samplerState, DepthStencilState depthStencilState, RasterizerState rasterizerState, Effect effect, Matrix transformMatrix)
	{
		if (isRunning)
		{
			throw new InvalidOperationException("Begin cannot be called again until End has been successfully called.");
		}
		
		this.sortMode = sortMode;
		this.blendState = blendState == null ? BlendState.AlphaBlend : blendState;
		this.customEffect = effect;
		this.depthStencilState = depthStencilState == null ? DepthStencilState.None : depthStencilState;
		
		if (sortMode == SpriteSortMode.Immediate)
		{
			applyGraphicsDeviceSettings();
		}
		
		isRunning = true;
	}
	
	@Override
	protected void Dispose(boolean disposing)
	{
		if (!disposed)
		{
			if (Disposing.hasHandlers())
			{
				Disposing.raise(this, EventArgs.Empty);
			}
			
			if (disposing)
			{
				// Release any managed components
			}
			disposed = true;
			
			// Release any unmanaged components
		}
	}
	
	/**
	 * Adds a sprite to a batch of sprites for rendering using the specified texture, destination rectangle, and color.
	 * 
	 * @param texture
	 * A texture. 
	 * 
	 * @param destinationRectangle
	 * A rectangle that specifies (in screen coordinates) the destination for drawing the sprite.
	 * 
	 * @param color
	 * The color to tint a sprite. Use Color.White for full color with no tinting.
	 */
	public void Draw(Texture2D texture, Rectangle destinationRectangle, Color color)
	{
		Draw(texture, destinationRectangle, null, color, 0f, Vector2.Zero, SpriteEffects.None, 0f);
	}
	
	/**
	 * Adds a sprite to a batch of sprites for rendering using the specified texture, position and color.
	 * 
	 * @param texture
	 * A texture.
	 * 
	 * @param position
	 * The location (in screen coordinates) to draw the sprite.
	 * 
	 * @param color
	 * The color to tint a sprite. Use Color.White for full color with no tinting.
	 */
	public void Draw(Texture2D texture, Vector2 position, Color color)
	{
		Draw(texture, position, null, color);
	}
	
	/**
	 * Adds a sprite to a batch of sprites for rendering using the specified texture, destination rectangle, source rectangle, and color.
	 * 
	 * @param texture
	 * A texture.
	 * 
	 * @param destinationRectangle
	 * A rectangle that specifies (in screen coordinates) the destination for drawing the sprite. If this rectangle is not the same size as the source rectangle, the sprite
	 * will be scaled to fit.
	 * 
	 * @param sourceRectangle
	 * A rectangle that specifies (in texels) the source texels from a texture. Use null to draw the entire texture.
	 * 
	 * @param color
	 * The color to tint a sprite. Use Color.White for full color with no tinting.
	 */
	public void Draw(Texture2D texture, Rectangle destinationRectangle, Rectangle sourceRectangle, Color color)
	{
		Draw(texture, destinationRectangle, sourceRectangle, color, 0f, Vector2.Zero, SpriteEffects.None, 0f);
	}
	
	/**
	 * Adds a sprite to a batch of sprites for rendering using the specified texture, position, source rectangle, and color.
	 * 
	 * @param texture
	 * A texture.
	 * 
	 * @param position
	 * The location (in screen coordinates) to draw the sprite.
	 * 
	 * @param sourceRectangle
	 * A rectangle that specifies (in texels) the source texels from a texture. Use null to draw the entire texture.
	 * 
	 * @param color
	 * The color to tint a sprite. Use Color.White for full color with no tinting.
	 */
	public void Draw(Texture2D texture, Vector2 position, Rectangle sourceRectangle, Color color)
	{
		Rectangle destination = new Rectangle((int)position.X, (int)position.Y, texture.Width(), texture.Height());
		Draw(texture, destination, sourceRectangle, color, 0f, Vector2.Zero, SpriteEffects.None, 0f);
	}
	
	/**
	 * 
	 * @param texture
	 * @param destinationRectangle
	 * @param sourceRectangle
	 * @param color
	 * @param rotation
	 * @param origin
	 * @param effects
	 * @param layerDepth
	 */
	public void Draw(Texture2D texture, Rectangle destinationRectangle, Rectangle sourceRectangle, Color color, float rotation, Vector2 origin, SpriteEffects effects, float layerDepth)
	{
		if (!isRunning)
		{
			throw new InvalidOperationException("Begin must be called successfully before a Draw can be called.");
		}

		Sprite sprite = new Sprite(texture, sourceRectangle != null ? sourceRectangle : new Rectangle(0, 0, texture.Width(), texture.Height()), destinationRectangle, color, rotation, origin, effects, layerDepth);
		spriteList.add(sprite);
		
		if (sortMode == SpriteSortMode.Immediate)
		{
			flush();
		}
	}
	
	/**
	 * 
	 * @param texture
	 * @param position
	 * @param sourceRectangle
	 * @param color
	 * @param rotation
	 * @param origin
	 * @param scale
	 * @param effects
	 * @param layerDepth
	 */
	public void Draw(Texture2D texture, Vector2 position, Rectangle sourceRectangle, Color color, float rotation, Vector2 origin, Vector2 scale, SpriteEffects effects, float layerDepth)
	{
		int width;
		int height;
		if (sourceRectangle != null)
		{
			width = (int)(sourceRectangle.Width * scale.X);
			height = (int)(sourceRectangle.Height * scale.Y);
		}
		else
		{
			width = (int)(texture.Width() * scale.X);
			height = (int)(texture.Height() * scale.Y);
		}
		Rectangle destination = new Rectangle((int)position.X, (int)position.Y, width, height);
		Draw(texture, destination, sourceRectangle, color, rotation, origin, effects, layerDepth);
	}
	
	/**
	 * Adds a sprite to a batch of sprites for rendering using the specified texture, destination rectangle, source rectangle, color, rotation, origin, effects and layer.
	 * 
	 * @param texture
	 * A texture.
	 * 
	 * @param position
	 * The location (in screen coordinates) to draw the sprite.
	 * 
	 * @param sourceRectangle
	 * A rectangle that specifies (in texels) the source texels from a texture. Use null to draw the entire texture.
	 * 
	 * @param color
	 * The color to tint a sprite. Use Color.White for full color with no tinting.
	 * 
	 * @param rotation
	 * Specifies the angle (in radians) to rotate the sprite about its center.
	 * 
	 * @param origin
	 * The sprite origin; the default is (0,0) which represents the upper-left corner.
	 * 
	 * @param scale
	 * Scale factor.
	 * 
	 * @param effects
	 * Effects to apply.
	 * 
	 * @param layerDepth
	 * The depth of a layer. By default, 0 represents the front layer and 1 represents a back layer. Use SpriteSortMode if you want sprites to be sorted during drawing.
	 */
	public void Draw(Texture2D texture, Vector2 position, Rectangle sourceRectangle, Color color, float rotation, Vector2 origin, float scale, SpriteEffects effects, float layerDepth)
	{
		int width;
		int height;
		
		if (sourceRectangle != null)
		{
			width = (int)(sourceRectangle.Width * scale);
			height = (int)(sourceRectangle.Height * scale);
		}
		else
		{
			width = (int)(texture.Width() * scale);
			height = (int)(texture.Height() * scale);
		}

		Rectangle destination = new Rectangle((int)position.X, (int)position.Y, width, height);
		Draw(texture, destination, sourceRectangle, color, rotation, origin, effects, layerDepth);
	}
	
	/**
	 * Adds a string to a batch of sprites for rendering using the specified font, text, position, and color.
	 * 
	 * @param spriteFont
	 * A font for displaying text.
	 * 
	 * @param text
	 * A text string.
	 * 
	 * @param position
	 * The location (in screen coordinates) to draw the sprite.
	 * 
	 * @param color
	 * The color to tint a sprite. Use Color.White for full color with no tinting.
	 */
	public void DrawString(SpriteFont spriteFont, String text, Vector2 position, Color color)
	{
		if (spriteFont == null)
		{
			throw new ArgumentNullException("spriteFont");
		}
		if (text == null)
		{
			throw new ArgumentNullException("text");
		}
		Vector2 one = Vector2.One;
		spriteFont.Draw(text, this, position, color, 0f, Vector2.Zero, one, SpriteEffects.None, 0f);
	}
	
	/**
	 * Adds a string to a batch of sprites for rendering using the specified font, text, position, color, rotation, origin, scale, effects and layer.
	 * 
	 * @param spriteFont
	 * A font for displaying text.
	 * 
	 * @param text
	 * A text string.
	 * 
	 * @param position
	 * The location (in screen coordinates) to draw the sprite.
	 * 
	 * @param color
	 * The color to tint a sprite. Use Color.White for full color with no tinting.
	 * 
	 * @param rotation
	 * Specifies the angle (in radians) to rotate the sprite about its center.
	 * 
	 * @param origin
	 * The sprite origin; the default is (0,0) which represents the upper-left corner.
	 * 
	 * @param scale
	 * Scale factor.
	 * 
	 * @param effects
	 * Effects to apply.
	 * 
	 * @param layerDepth
	 * The depth of a layer. By default, 0 represents the front layer and 1 represents a back layer. Use SpriteSortMode if you want sprites to be sorted during drawing.
	 */
	public void DrawString(SpriteFont spriteFont, String text, Vector2 position, Color color, float rotation, Vector2 origin, float scale, SpriteEffects effects, float layerDepth)
	{
		Vector2 vector = Vector2.Zero;
		if (spriteFont == null)
		{
			throw new ArgumentNullException("spriteFont");
		}
			
		if (text == null)
		{
			throw new ArgumentNullException("text");
		}
		
		vector.X = scale;
		vector.Y = scale;
		spriteFont.Draw(text, this, position, color, rotation, origin, vector, effects, layerDepth);
	}
	
	/**
	 * Flushes the sprite batch and restores the device state to how it was before Begin was called.
	 */
	public void End()
	{
		if (!isRunning)
		{
			throw new InvalidOperationException("Begin must be called successfully before End can be called.");
		}
		
		if (sortMode != SpriteSortMode.Immediate)
		{
			applyGraphicsDeviceSettings();
			flush();
		}
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		
		restoreRenderState();
		isRunning = false;
	}
	
    private void flush()
    {
    	switch (sortMode)
    	{
		case BackToFront:
			Collections.sort(spriteList, new BackToFrontSpriteComparer());
			break;
		case FrontToBack:
			Collections.sort(spriteList, new FrontToBackSpriteComparer());
			break;
		case Texture:
			// nothing here?
			break;
    	}

    	for (Sprite sprite : spriteList)
    	{
    		// Set the color, bind the texture for drawing and prepare the texture source
    		if (sprite.Color.A() <= 0) continue;
    		GL11.glColor4f((float)sprite.Color.R() / 255f, (float)sprite.Color.G() / 255f, (float)sprite.Color.B() / 255f, (float)sprite.Color.A() / 255f);
    		GL11.glBindTexture(GL11.GL_TEXTURE_2D, sprite.Texture.textureId);
    		
    		// Setup the matrix
    		GL11.glPushMatrix();
    		if ((sprite.DestinationRectangle.X != 0) || (sprite.DestinationRectangle.Y != 0))
    		{
    			GL11.glTranslatef(sprite.DestinationRectangle.X, sprite.DestinationRectangle.Y, 0f);
    		}
    		
    		// Position
    		if (sprite.Rotation != 0)
    		{
    			GL11.glRotatef(MathHelper.ToDegrees(sprite.Rotation), 0f, 0f, 1f);
    		}
    		
    		// Rotation
    		if ((sprite.DestinationRectangle.Width != 0 && sprite.Origin.X != 0) || (sprite.DestinationRectangle.Height != 0 && sprite.Origin.Y != 0))
    			GL11.glTranslatef(
    				// Orientation
    				-sprite.Origin.X * (float)sprite.DestinationRectangle.Width / (float)sprite.SourceRectangle.Width,
    				-sprite.Origin.Y * (float)sprite.DestinationRectangle.Height / (float)sprite.SourceRectangle.Height, 0f);
    		
    		// Calculate the points on the texture
    		float x = (float)sprite.SourceRectangle.X / (float)sprite.Texture.Width();
    		float y = (float)sprite.SourceRectangle.Y / (float)sprite.Texture.Height();
    		float twidth = (float)sprite.SourceRectangle.Width / (float)sprite.Texture.Width();
    		float theight = (float)sprite.SourceRectangle.Height / (float)sprite.Texture.Height();

    		// Draw
    		GL11.glBegin(GL11.GL_QUADS);
    		{
    			GL11.glTexCoord2f(x, y + theight);
    			GL11.glVertex2f(0f, sprite.DestinationRectangle.Height);
    			GL11.glTexCoord2f(x + twidth, y + theight);
    			GL11.glVertex2f(sprite.DestinationRectangle.Width, sprite.DestinationRectangle.Height);
    			GL11.glTexCoord2f(x + twidth,y);
    			GL11.glVertex2f(sprite.DestinationRectangle.Width, 0f);
    			GL11.glTexCoord2f(x, y);
    			GL11.glVertex2f(0f, 0f);
    		}
    		GL11.glEnd();
    		GL11.glPopMatrix();

    		// Finish with the matrix
    	}
    	spriteList.clear();
    }
	
	private void restoreRenderState()
	{
		/*if (this.stateMode == SaveStateMode.SaveState)
			saveState.Apply();*/
	}
	
	private class BackToFrontSpriteComparer implements java.util.Comparator<Sprite>
	{
		@Override
		public int compare(Sprite x, Sprite y)
		{
			if (x.LayerDepth > y.LayerDepth)
				return -1;
			if (x.LayerDepth < y.LayerDepth)
				return 1;
			return 0;  
		}
	}
	
	private class FrontToBackSpriteComparer implements java.util.Comparator<Sprite>
	{
		@Override
		public int compare(Sprite x, Sprite y)
		{
			if (x.LayerDepth < y.LayerDepth)
				return -1;
			if (x.LayerDepth > y.LayerDepth)
				return 1;
			return 0;  
		}
	}
}
