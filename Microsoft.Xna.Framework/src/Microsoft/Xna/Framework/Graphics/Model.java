package Microsoft.Xna.Framework.Graphics;

import java.util.*;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Represents a 3D model composed of multiple ModelMesh objects which may be moved independently.
 * 
 * @author Halofreak1990
 */
public final class Model
{
	List<ModelBone> bones = new ArrayList<ModelBone>();
	List<ModelMesh> meshes = new ArrayList<ModelMesh>();
	
	/**
	 * Gets a collection of ModelBone objects which describe how each mesh in the Meshes collection for this model relates to its parent mesh.
	 */
	public ModelBoneCollection getBones()
	{
		return new ModelBoneCollection(bones);
	}
	
	/**
	 * Gets a collection of ModelMesh objects which compose the model. Each ModelMesh in a model may be moved independently and may be composed of multiple materials identified as ModelMeshPart objects.
	 */
	public ModelMeshCollection getMeshes()
	{
		return new ModelMeshCollection(meshes);
	}
	
	/**
	 * Gets the root bone for this model.
	 */
	public ModelBone getRoot()
	{
		// TODO: implement
		throw new NotImplementedException();
	}
	
	/**
	 * Gets or sets an object identifying this model.
	 */
	public Object Tag;
	
	/**
	 * Copies a transform of each bone in a model relative to all parent bones of the bone into a given array.
	 * 
	 * @param destinationBoneTransforms
	 * The array to receive bone transforms.
	 */
	public void CopyAbsoluteBoneTransformsTo(Matrix[] destinationBoneTransforms)
	{
		// TODO: implement		
	}
	
	/**
	 * Copies an array of transforms into each bone in the model.
	 * 
	 * @param sourceBoneTransforms
	 * An array containing new bone transforms.
	 */
	public void CopyBoneTransformsFrom(Matrix[] sourceBoneTransforms)
	{
		// TODO: implement		
	}
	
	/**
	 * Copies each bone transform relative only to the parent bone of the model to a given array.
	 * 
	 * @param destinationBoneTransforms
	 * The array to receive bone transforms.
	 */
	public void CopyBoneTransformsTo(Matrix[] destinationBoneTransforms)
	{
		// TODO: implement		
	}
	
	/**
	 * Render a model after applying the matrix transformations.
	 * 
	 * @param world
	 * A world transformation matrix.
	 * 
	 * @param view
	 * A view transformation matrix.
	 * 
	 * @param projection
	 * A projection transformation matrix.
	 */
	public void Draw(Matrix world, Matrix view, Matrix projection)
	{
		// TODO: implement
	}
}
