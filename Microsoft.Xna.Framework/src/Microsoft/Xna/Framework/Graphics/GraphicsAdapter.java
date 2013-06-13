package Microsoft.Xna.Framework.Graphics;

import java.util.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 * Provides methods to retrieve and manipulate graphics adapters.
 * 
 * @author Halofreak1990
 */
public final class GraphicsAdapter
{
	private static List<GraphicsAdapter> adapters;
	private DisplayMode currentDisplayMode;
	private DisplayModeCollection supportedDisplayModes;
	
	/**
	 * Collection of available adapters on the system.
	 */
	public static List<GraphicsAdapter> getAdapters()
	{
		if (adapters == null)
		{
			adapters = new ArrayList<GraphicsAdapter>();
			adapters.add(new GraphicsAdapter());
			adapters = Collections.unmodifiableList(adapters);
		}
		
		return adapters;
	}
	
	/**
	 * Gets the current display mode.
	 */
	public DisplayMode getCurrentDisplayMode()
	{
		org.lwjgl.opengl.DisplayMode dm = Display.getDisplayMode();
		currentDisplayMode._width = dm.getWidth();
		currentDisplayMode._height = dm.getHeight();
		return currentDisplayMode;
	}
	
	/**
	 * Gets the default adapter.
	 */
	public static GraphicsAdapter getDefaultAdapter()
	{
		return getAdapters().get(0);
	}

	/**
	 * Retrieves a string that contains the device name for a Microsoft Windows Graphics Device Interface (GDI).
	 */
	public String getDeviceName()
	{
		return Display.getAdapter();
	}
	
	/**
	 * Returns a collection of supported display modes for the current adapter.
	 */
	public DisplayModeCollection getSupportedDisplayModes()
	{
		if (supportedDisplayModes == null)
		{
			List<DisplayMode> list = new ArrayList<DisplayMode>();
			try
			{
				org.lwjgl.opengl.DisplayMode[] modes = Display.getAvailableDisplayModes();
				for (int i = 0; i < modes.length; i++)
				{
					list.add(new DisplayMode(modes[i].getWidth(), modes[i].getHeight(), null));
				}
			}
			catch (LWJGLException e)
			{
				e.printStackTrace();
			}
		}

		return supportedDisplayModes;
	}
	
	/**
	 * Tests to see if the adapter supports the requested profile.
	 * 
	 * @param graphicsProfile
	 * The graphics profile.
	 */
	public boolean IsProfileSupported(GraphicsProfile graphicsProfile)
	{
		return true;
	}
}
