package Microsoft.Xna.Framework.Graphics;

import java.util.Iterator;

import System.*;

/**
 * Manipulates a collection of EffectTechnique objects.
 * 
 * @author Halofreak1990
 */
public final class EffectTechniqueCollection implements	Iterable<EffectTechnique>
{
	/**
	 * Gets a specific element in the collection by using an index value.
	 * @param index
	 * Index of the EffectTechnique to get.
	 */
	public EffectTechnique get(int index)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets a specific element in the collection by using a name.
	 * 
	 * @param name
	 * Name of the EffectTechnique to get.
	 */
	public EffectTechnique get(String name)
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
	 * Gets an iterator that can iterate through the EffectTechniqueCollection.
	 */
	@Override
	public Iterator<EffectTechnique> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
