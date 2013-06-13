package Microsoft.Xna.Framework.Graphics;

import java.util.*;

/**
 * Manipulates a collection of DisplayMode structures.
 * 
 * @author Halofreak1990
 */
public class DisplayModeCollection implements Iterable<DisplayMode>
{
	private List<DisplayMode> displayModes;

	DisplayModeCollection(ArrayList<DisplayMode> displayModes)
	{
		this.displayModes = displayModes;
	}
	
	/**
	 * Retrieves the DisplayMode structure with the specified format.
	 * 
	 * @param format
	 * The format of the DisplayMode to retrieve.
	 */
	public Iterable<DisplayMode> get(SurfaceFormat format)
	{
		List<DisplayMode> list = new ArrayList<DisplayMode>();
		for (DisplayMode mode : displayModes)
		{
			if (mode.getFormat() == format)
				list.add(mode);
		}
		return list;
	}
	
	/**
	 * Gets an iterator that can iterate through the DisplayModeCollection.
	 */
	@Override
	public Iterator<DisplayMode> iterator()
	{
		return displayModes.iterator();
	}
}
