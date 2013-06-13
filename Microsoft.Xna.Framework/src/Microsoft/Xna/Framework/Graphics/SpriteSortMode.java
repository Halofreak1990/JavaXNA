package Microsoft.Xna.Framework.Graphics;

/**
 * Defines sprite sort-rendering options.
 * 
 * @author Halofreak1990
 */
public enum SpriteSortMode
{
	/**
	 * Sprites are not drawn until End is called. End will apply graphics device settings and draw all the sprites in one batch, in the same order calls to Draw were received. This mode allows Draw calls to two or more instances of SpriteBatch without introducing conflicting graphics device settings. SpriteBatch defaults to Deferred mode.
	 */
	Deferred,
	/**
	 * Begin will apply new graphics device settings, and sprites will be drawn within each Draw call. In Immediate mode there can only be one active SpriteBatch instance without introducing conflicting device settings.
	 */
    Immediate,
    /**
     * Same as Deferred mode, except sprites are sorted by texture prior to drawing. This can improve performance when drawing non-overlapping sprites of uniform depth.
     */
    Texture,
    /**
     * Same as Deferred mode, except sprites are sorted by depth in back-to-front order prior to drawing. This procedure is recommended when drawing transparent sprites of varying depths.
     */
    BackToFront,
    /**
     * Same as Deferred mode, except sprites are sorted by depth in front-to-back order prior to drawing. This procedure is recommended when drawing opaque sprites of varying depths.
     */
    FrontToBack
}
