package Microsoft.Xna.Framework.Graphics;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Represents bone data for a model.
 * 
 * @author Halofreak1990
 */
public final class ModelBone
{
	/**
	 * Gets a collection of bones that are children of this bone.
	 */
	public ModelBoneCollection getChildren()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the index of this bone in the Bones collection.
	 */
	public int getIndex()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the name of this bone.
	 */
	public String getName()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the parent of this bone.
	 */
	public ModelBone getParent()
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Gets or sets the matrix used to transform this bone relative to its parent bone.
	 */
	public Matrix Transform;
}
