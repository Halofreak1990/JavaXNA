package Microsoft.Xna.Framework.Graphics;

import java.util.Iterator;

import System.*;

/**
 * Manipulates a collection of EffectParameter objects.
 * 
 * @author Halofreak1990
 */
public final class EffectParameterCollection implements Iterable<EffectParameter>
{
	/**
	 * Gets a specific EffectParameter object by using an index value.
	 * 
	 * @param index
	 * Index of the EffectParameter to get.
	 */
	public EffectParameter get(int index)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets a specific EffectParameter by name.
	 * @param name
	 * The name of the EffectParameter to retrieve.
	 */
	public EffectParameter get(String name)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the number of EffectParameter objects in this EffectParameterCollection.
	 */
	public int Count()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets an iterator that can iterate through EffectParameterCollection.
	 */
	@Override
	public Iterator<EffectParameter> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param semantic
	 * @return
	 */
	public EffectParameter GetParameterBySemantic(String semantic)
	{
		throw new NotImplementedException();
	}
}
