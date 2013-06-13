package Microsoft.Xna.Framework;

import java.io.*;

import System.*;
import System.IO.FileNotFoundException;

/**
 * Provides file stream access to the title's default storage location.
 * 
 * @author Halofreak1990
 */
public class TitleContainer
{
	private static char[] badCharacters = new char[] { ':', '*', '?', '"', '<', '>', '|' };
	
	private TitleContainer()
	{
		
	}
	
	private static int CollapseParentDirectory(String path, int position, int removeLength)
	{
		int startIndex = path.lastIndexOf('\\', position - 1) + 1;
		StringBuffer s = new StringBuffer(path).delete(startIndex, (position - startIndex) + removeLength);
		path = s.toString();
		return Math.max(startIndex - 1, 1);
	}
	
	static String GetCleanPath(String path)
	{
		path = path.replace('/', '\\');
		path = path.replace("\\.\\", "\\");
		while(path.startsWith(".\\"))
		{
			path = path.substring(".\\".length());
		}
		while(path.endsWith("\\."))
		{
			if (path.length() > "\\.".length())
			{
				path = path.substring(0, path.length() - "\\.".length());
			}
			else
			{
				path = "\\";
			}
		}
		int startIndex = 1;
		while(startIndex < path.length())
		{
			startIndex = path.indexOf("\\..\\", startIndex);
			if (startIndex < 0)
			{
				break;
			}
			startIndex = CollapseParentDirectory(path, startIndex, "\\..\\".length());
		}
		if(path.endsWith("\\"))
		{
			startIndex = path.length() - "\\..".length();
			if (startIndex > 0)
			{
				CollapseParentDirectory(path, startIndex, "\\..".length());
			}
		}
		if (path == ".")
		{
			return "";
		}
		return path;
	}
	
	private static boolean IsCleanPathAbsolute(String path)
	{
		if (indexOfAny(path, badCharacters) < 0)
		{
			if (path.startsWith("\\"))
			{
				return true;
			}
			if ((!path.startsWith("..\\") && !path.contains("\\..\\")) && (!path.endsWith("\\..") && !(path == "..")))
			{
				return false;
			}
		}
		return true;
	}
	
	static boolean IsPathAbsolute(String path)
	{
		path = GetCleanPath(path);
		return IsCleanPathAbsolute(path);
	}
	
	/**
	 * Provides file stream access to the title's default storage location.
	 * 
	 * @param name
	 * 
	 * @throws System.ArgumentNullException
	 * name is null, or an empty string.
	 * 
	 * @throws System.IO.FileNotFoundException
	 * 
	 */
	public static FileInputStream OpenStream(String name)
	{
		FileInputStream stream = null;
		if (name == null || name == "")
		{
			throw new ArgumentNullException("name");
		}
		name = GetCleanPath(name);
		if (IsCleanPathAbsolute(name))
		{
			throw new ArgumentException("name");
		}
		try
		{
			//TODO: create an Uri? I don't know why XNA does it this way.
		}
		catch(Exception exception2)
		{
			throw new IllegalArgumentException("", exception2);
		}
		try
		{
			stream = new FileInputStream(name);
		}
		catch(Exception exception)
		{
			if (exception instanceof java.io.FileNotFoundException)
				throw new FileNotFoundException("", "name", exception);
		}
		return stream;
	}
	
	private static int indexOfAny(String str, char[] searchStrs)
	{
		if ((str == null) || (searchStrs == null))
		{
			return -1;
		}
		int sz = searchStrs.length;

		// String's can't have a MAX_VALUEth index.
		int ret = Integer.MAX_VALUE;

		int tmp = 0;
		for (int i = 0; i < sz; i++)
		{
			char search = searchStrs[i];
			/*if (search == null)
			{
				continue;
			}*/
			tmp = str.indexOf(search);
			if (tmp == -1)
			{
				continue;
			}

			if (tmp < ret)
			{
				ret = tmp;
			}
		}

		return (ret == Integer.MAX_VALUE) ? -1 : ret;
	}
}
