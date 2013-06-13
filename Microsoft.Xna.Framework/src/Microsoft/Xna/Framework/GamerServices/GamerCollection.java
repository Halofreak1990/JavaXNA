package Microsoft.Xna.Framework.GamerServices;

import java.util.*;

import System.Collections.ObjectModel.*;

public class GamerCollection<T extends Gamer> extends ReadOnlyCollection<T>
{
	/**
	 * 
	 * @param list
	 */
	public GamerCollection(List<T> list)
	{
		super(list);
		// TODO Auto-generated constructor stub
	}
	
	void Insert(T newGamer)
	{
		
	}

	@Override
	public Iterator<T> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
