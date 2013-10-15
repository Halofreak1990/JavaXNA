package Microsoft.Xna.Framework.Graphics;

import java.util.*;

import System.*;
import System.Collections.Generic.*;
import System.Collections.ObjectModel.*;

/**
 * Represents a collection of ModelMesh objects.
 * 
 * @author Halofreak1990
 */
public final class ModelMeshCollection extends ReadOnlyCollection<ModelMesh>
{
	ModelMeshCollection(List<ModelMesh> meshes)
	{
		super(meshes);
	}
	
	/**
	 * Retrieves a ModelMesh from the collection, given the name of the mesh.
	 * 
	 * @param meshName
	 * The name of the mesh to retrieve.
	 */
	public ModelMesh get(String meshName)
	{
		ModelMesh mesh = null;
		if (!TryGetValue(meshName, mesh))
		{
			throw new KeyNotFoundException();
		}
		return mesh;
	}
	
	/**
	 * Returns a ModelMeshCollection.Enumerator that can iterate through a ModelMeshCollection.
	 */
	public ModelMeshCollectionIterator iterator()
	{
		return new ModelMeshCollectionIterator(this);
	}
	
	/**
	 * Finds a mesh with a given name if it exists in the collection.
	 * 
	 * @param meshName
	 * The name of the mesh to find.
	 * 
	 * @param value
	 * [OutAttribute] The mesh named meshName, if found.
	 */
	public boolean TryGetValue(String meshName, ModelMesh value)
	{
		if (meshName == null || meshName.length() == 0)
        {
            throw new ArgumentNullException("meshName");
        }
		
		int count = super.getItems().size();
		for (int i = 0; i < count; i++)
		{
			ModelMesh mesh = super.getItems().get(i);
			if (meshName.compareToIgnoreCase(mesh.getName()) == 0)
			{
				value = mesh;
				return true;
			}
		}
		value = null;
		return false;
	}
	
	/**
	 * Provides the ability to iterate through the bones in an ModelMeshCollection.
	 * 
	 * @author Halofreak1990
	 */
	public final class ModelMeshCollectionIterator implements Iterator<ModelMesh>
	{
		private ModelMeshCollection parent;
		private int position;
		
		ModelMeshCollectionIterator(ModelMeshCollection modelMeshCollection)
		{
			this.parent = modelMeshCollection;
			this.position = -1;
		}
		
		/**
		 * Advances the enumerator to the next element of the ModelMeshCollection.
		 */
		@Override
		public boolean hasNext()
		{
			this.position++;
			if (this.position >= parent.Count())
			{
				this.position = parent.Count() - 1;
				return false;
			}
			return true;
		}

		/**
		 * Gets the current element in the ModelMeshCollection.
		 */
		@Override
		public ModelMesh next()
		{
			return parent.get(this.position);
		}

		@Override
		public void remove()
		{
			// Not supported in C#, so we leave this one empty
		}
	}
}
