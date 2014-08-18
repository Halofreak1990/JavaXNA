package resources;

import java.text.MessageFormat;
import java.util.*;

public final class Resources
{
	private static final String BUNDLE_NAME = "resources.resources"; //$NON-NLS-1$
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private Resources()
	{
	}
	
	public static String GetString(String key)
	{
		try
		{
			return RESOURCE_BUNDLE.getString(key);
		}
		catch (MissingResourceException e)
		{
			return '!' + key + '!';
		}
	}
	
	public static String Format(String key, Object...arguments)
	{
		try
		{
			String p = RESOURCE_BUNDLE.getString(key);
			return MessageFormat.format(p,arguments);
		}
		catch (MissingResourceException e)
		{
			return '!' + key + '!';
		}
	}
}
