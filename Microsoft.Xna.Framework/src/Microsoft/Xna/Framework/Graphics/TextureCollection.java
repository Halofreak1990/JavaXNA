package Microsoft.Xna.Framework.Graphics;

import java.util.*;

/**
 * Represents a collection of Texture objects.
 * 
 * @author Halofreak1990
 */
public final class TextureCollection
{
	List<Texture> textures = new ArrayList<Texture>();
	private boolean disposed;
	
	TextureCollection()
	{
	}
	
	/**
	 * Gets the Texture at the specified sampler number.
	 * 
	 * @param index
	 * Zero-based sampler number. Textures are bound to samplers; samplers define sampling state such as the filtering mode and the address wrapping mode. Programmable shaders reference textures using this sampler number.
	 */
	public Texture get(int index)
	{
		return textures.get(index);
	}
	
	/**
	 * Sets the Texture at the specified sampler number.
	 * 
	 * @param index
	 * Zero-based sampler number. Textures are bound to samplers; samplers define sampling state such as the filtering mode and the address wrapping mode. Programmable shaders reference textures using this sampler number.
	 */
	public void set(int index, Texture value)
	{
		textures.set(index, value);
	}
	
	void Dispose()
	{
		this.Dispose(true);
	}
	
	void Dispose(boolean disposing)
	{
		if (!disposed)
		{
			if (disposing)
			{
				Texture[] textureArray = (Texture[]) textures.toArray();
				for (Texture texture : textureArray)
				{
					texture.Dispose();
				}
				textures.clear();
			}
		}
	}
	
	protected void finalize()
	{
		this.Dispose(false);
	}
}
