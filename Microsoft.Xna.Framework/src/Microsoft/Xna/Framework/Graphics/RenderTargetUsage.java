package Microsoft.Xna.Framework.Graphics;

/**
 * Determines how render target data is used once a new render target is set.
 * 
 * @author Halofreak1990
 */
public enum RenderTargetUsage
{
	/**
	 * Always clears the render target data.
	 */
	DiscardContents,
	/**
	 * Always keeps the render target data.
	 */
	PreserveContents,
	/**
	 * Either clears or keeps the data, depending on the current platform. On Xbox 360, the render target will discard contents. On PC, the render target will discard if
	 * multisampling is enabled, and preserve the contents if not.
	 */
	PlatformContents,
}
