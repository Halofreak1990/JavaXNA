package Microsoft.Xna.Framework;

import System.*;
import Microsoft.Xna.Framework.Graphics.*;

/**
 * Holds the settings for creating a graphics device on Windows.
 * 
 * @author Halofreak1990 
 */
public class GraphicsDeviceInformation
{
	private GraphicsAdapter adapter;
	
	/**
	 * Gets the graphics profile, which determines the graphics feature set.
	 */
	public GraphicsProfile GraphicsProfile;
	/**
	 * Specifies the presentation parameters to use when creating a graphics device.
	 */
	public PresentationParameters PresentationParameters = new PresentationParameters();
	
	/**
	 * Specifies which graphics adapter to create the device on.
	 */
	public GraphicsAdapter getAdapter()
	{
		return adapter;
	}
	
	/**
	 * Specifies which graphics adapter to create the device on.
	 */
	public void setAdapter(GraphicsAdapter value)
	{
		if (this.adapter == null)
		{
			throw new ArgumentNullException("Adapter cannot be null. Try using GraphicsAdapter.getDefaultAdapter() instead.");
		}
		this.adapter = value;
	}
	
	/**
	 * Initializes a new instance of this class.
	 */
	public GraphicsDeviceInformation()
	{
		this.PresentationParameters = new PresentationParameters();
		this.adapter = GraphicsAdapter.getDefaultAdapter();
	}
	
	/**
	 * Creates a clone of this object.
	 */
	public GraphicsDeviceInformation Clone()
	{
		GraphicsDeviceInformation gdi = new GraphicsDeviceInformation();
		gdi.adapter = adapter;
		gdi.PresentationParameters = PresentationParameters;
		return gdi;
	}
	
	/**
	 * Returns a value that indicates whether the current instance is equal to a specified object.
	 * 
	 * @param obj
	 * The object to compare with the current GraphicsDeviceInformation.
	 */
	public boolean Equals(Object obj)
	{
		GraphicsDeviceInformation gdi = (GraphicsDeviceInformation)obj;
		if (gdi == null)
		{
			return false;
		}
		if (!gdi.adapter.equals(this.adapter))
		{
			return false;
		}
		if (!gdi.GraphicsProfile.equals(this.GraphicsProfile))
		{
			return false;
		}
		
		return ((((gdi.PresentationParameters.BackBufferWidth == this.PresentationParameters.BackBufferWidth) && (gdi.PresentationParameters.BackBufferHeight == this.PresentationParameters.BackBufferHeight) && (gdi.PresentationParameters.BackBufferFormat == this.PresentationParameters.BackBufferFormat) && (gdi.PresentationParameters.DepthStencilFormat == this.PresentationParameters.DepthStencilFormat))) && ((((gdi.PresentationParameters.MultiSampleCount == this.PresentationParameters.MultiSampleCount) && (gdi.PresentationParameters.DisplayOrientation == this.PresentationParameters.DisplayOrientation)) && ((gdi.PresentationParameters.PresentationInterval == this.PresentationParameters.PresentationInterval) && (gdi.PresentationParameters.RenderTargetUsage == this.PresentationParameters.RenderTargetUsage))) && (gdi.PresentationParameters.IsFullScreen == this.PresentationParameters.IsFullScreen)));
	}
	
	/**
	 * Gets the hash code for this object.
	 */
	public int GetHashCode()
	{
		return (((((((((this.GraphicsProfile.hashCode() ^ this.adapter.hashCode()) ^ this.PresentationParameters.BackBufferWidth) ^ this.PresentationParameters.BackBufferHeight) ^ this.PresentationParameters.BackBufferFormat.hashCode()) ^ this.PresentationParameters.DepthStencilFormat.hashCode()) ^ this.PresentationParameters.MultiSampleCount) ^ this.PresentationParameters.DisplayOrientation.hashCode()) ^ this.PresentationParameters.PresentationInterval.hashCode()) ^ this.PresentationParameters.RenderTargetUsage.hashCode());
	}
}
