package Microsoft.Xna.Framework.Graphics;

/**
 * Specifies special usage of the buffer contents.
 * 
 * @author Halofreak1990
 */
public enum BufferUsage
{
	/**
	 * None.
	 */
    None,
    /**
     * Indicates that the application only writes to the vertex buffer. If specified, the driver chooses the best memory location for efficient writing and rendering. Attempts to read from a write-only vertex buffer fail.
     */
    WriteOnly
}
