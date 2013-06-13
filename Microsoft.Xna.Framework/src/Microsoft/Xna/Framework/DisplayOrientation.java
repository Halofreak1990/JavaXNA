package Microsoft.Xna.Framework;
/**
 * Defines the display orientation.
 * 
 * @author Halofreak1990
 */
public enum DisplayOrientation
{
	/**
	 * The default display orientation.
	 */
    Default(0),
    /**
     * The display is rotated counterclockwise 90 degrees into a landscape orientation, where the width is greater than the height.
     */
    LandscapeLeft(1),
    /**
     * The display is rotated clockwise 90 degrees into a landscape orientation, where the width is greater than the height.
     */
    LandscapeRight(2),
    /**
     * The orientation is a portrait, where the height is greater than the width.
     */
    Portrait(4);
    
    private final int value;
    private DisplayOrientation(int value)
    {
    	this.value = value;
    }
    
    public int getValue()
    {
    	return this.value;
    }
}
