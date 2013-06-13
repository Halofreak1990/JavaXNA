package Microsoft.Xna.Framework.Graphics;

/**
 * Identifies the set of supported devices for the game based on device capabilities.
 * 
 * @author Halofreak1990
 */
public enum GraphicsProfile
{
	/**
	 * Use a limited set of graphic features and capabilities, allowing the game to support the widest variety of devices, including all Windows-based computers and
	 * Windows Phone.
	 */
	Reach,
	/**
	 * Use the largest available set of graphic features and capabilities to target devices, such as an Xbox 360 console and a Windows-based computer, that have more
	 * enhanced graphics capabilities.
	 */
	HiDef
}
