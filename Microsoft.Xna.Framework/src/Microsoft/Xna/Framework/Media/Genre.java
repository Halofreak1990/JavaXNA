package Microsoft.Xna.Framework.Media;

import System.*;

/**
 * 
 * @author Halofreak1990
 */
public final class Genre implements IEquatable<Genre>, IDisposable
{
	/**
	 * 
	 */
	@Override
	public void Dispose()
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	@Override
	public boolean Equals(Genre other)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 
	 */
	public boolean equals(Object obj)
	{
		return (obj instanceof Genre) ? Equals((Genre)obj) : false; 
	}

	/**
	 * 
	 */
	public String toString()
	{
		
	}
}
