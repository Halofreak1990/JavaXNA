package Microsoft.Xna.Framework.Graphics;

import java.util.*;

import System.Collections.ObjectModel.ReadOnlyCollection;

public final class ModelMeshPartCollection extends ReadOnlyCollection<ModelMeshPart>
{
	ModelMeshPart[] wrappedArray;
	
	ModelMeshPartCollection(ModelMeshPart[] parts)
	{
		super(Arrays.asList(parts));
		
		this.wrappedArray = parts;
	}
	
	/**
	 * 
	 */
	public ModelMeshPartCollectionIterator iterator()
	{
		return new ModelMeshPartCollectionIterator(this);
	}
	
	/**
	 * Provides the ability to iterate through the bones in an ModelMeshPartCollection.
	 * 
	 * @author Halofreak1990
	 */
	public final class ModelMeshPartCollectionIterator implements Iterator<ModelMeshPart>
	{
		private ModelMeshPartCollection parent;
		
		ModelMeshPartCollectionIterator(ModelMeshPartCollection parent)
		{
			this.parent = parent;
		}
		
		@Override
		public boolean hasNext()
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ModelMeshPart next()
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove()
		{
			// Overridden to do nothing. C# doesn't allow modifications while enumerating, so we don't either.
			// We could throw an InvalidOperationException, but instead, we silently fail.
		}
	}
}
