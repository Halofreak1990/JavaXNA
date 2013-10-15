package Microsoft.Xna.Framework.Graphics;

import java.util.*;

import System.*;
import System.Collections.Generic.KeyNotFoundException;
import System.Collections.ObjectModel.*;

/**
 * Represents a set of bones associated with a model.
 * 
 * @author Halofreak1990
 */
public final class ModelBoneCollection extends ReadOnlyCollection<ModelBone>
{	
	ModelBoneCollection(List<ModelBone> bones)
	{
		super(bones);
	}
	
	/**
	 * Retrieves a ModelBone from the collection, given the name of the bone.
	 * 
	 * @param boneName
	 * The name of the bone to retrieve.
	 */
	public ModelBone get(String boneName)
	{
		ModelBone bone = null;
		if (!TryGetValue(boneName, bone))
		{
			throw new KeyNotFoundException();
		}
		return bone;
	}
	
	/**
	 * Returns a ModelBoneCollection.Enumerator that can iterate through a ModelBoneCollection.
	 * @return
	 */
	public Iterator<ModelBone> getIterator()
	{
		return new ModelBoneCollectionIterator(this);
	}
	
	/**
	 * Finds a bone with a given name if it exists in the collection.
	 * 
	 * @param boneName
	 * The name of the bone to find.
	 * 
	 * @param value
	 * [OutAttribute] The bone named boneName, if found.
	 */
	public boolean TryGetValue(String boneName, ModelBone value)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Provides the ability to iterate through the bones in an ModelBoneCollection.
	 * 
	 * @author Halofreak1990
	 */
	public final class ModelBoneCollectionIterator implements Iterator<ModelBone>
	{
		ModelBoneCollection _parent;
		
		ModelBoneCollectionIterator(ModelBoneCollection parent)
		{
			this._parent = parent;
		}
		
		@Override
		public boolean hasNext()
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ModelBone next()
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove()
		{
			// TODO Auto-generated method stub
			
		}
	}
}
