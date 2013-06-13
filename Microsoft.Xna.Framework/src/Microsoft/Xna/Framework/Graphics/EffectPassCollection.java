package Microsoft.Xna.Framework.Graphics;

import java.util.Iterator;

import System.*;

/**
 * Manipulates a collection of EffectPass objects.
 * 
 * @author Halofreak1990
 */
public final class EffectPassCollection implements Iterable<EffectPass>
{
	/**
	 * Gets a specific element in the collection by using an index value.
	 * 
	 * @param index
	 * Index of the EffectPass to get.
	 */
	public EffectPass get(int index)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets a specific element in the collection by using a name.
	 * 
	 * @param name
	 * Name of the EffectPass to get.
	 */
	public EffectPass get(String name)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the number of objects in the collection.
	 */
	public int Count()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets an enumerator that can iterate through the EffectPassCollection.
	 */
	@Override
	public Iterator<EffectPass> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
