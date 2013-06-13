package Microsoft.Xna.Framework.Graphics;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Represents a mesh that is part of a Model.
 * 
 * @author Halofreak1990
 */
public final class ModelMesh
{
	private BoundingSphere boundingSphere;
	private ModelEffectCollection effects;
	private ModelMeshPartCollection meshParts;
	private String name;
	private ModelBone parentBone;
	
	/**
	 * Gets the BoundingSphere that contains this mesh.
	 */
	public BoundingSphere getBoundingSphere()
	{
		return boundingSphere;
	}
	
	/**
	 * Gets a collection of effects associated with this mesh.
	 */
	public ModelEffectCollection getEffects()
	{
		return effects;
	}
	
	/**
	 * Gets the ModelMeshPart objects that make up this mesh. Each part of a mesh is composed of a set of primitives that share the same material.
	 */
	public ModelMeshPartCollection MeshParts()
	{
		return meshParts;
	}
	
	/**
	 * Gets the name of this mesh.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the parent bone for this mesh. The parent bone of a mesh contains a transformation matrix that describes how the mesh is located relative to any parent meshes in a model.
	 */
	public ModelBone getParentBone()
	{
		return parentBone;
	}
	
	/**
	 * Gets or sets an object identifying this mesh.
	 */
	public Object Tag;
	
	ModelMesh(String name, ModelBone parentBone, BoundingSphere boundingSphere, ModelMeshPart[] meshParts, Object tag)
	{
		this.boundingSphere = new BoundingSphere();
	    this.effects = new ModelEffectCollection();
	    this.name = name;
	    this.parentBone = parentBone;
	    this.boundingSphere = boundingSphere;
	    this.meshParts = new ModelMeshPartCollection(meshParts);
	    this.Tag = tag;
	    int length = meshParts.length;
	    for (int i = 0; i < length; i++)
	    {
	        ModelMeshPart part = meshParts[i];
	        part.parent = this;
	    }
	}
	
	/**
	 * Draws all of the ModelMeshPart objects in this mesh, using their current Effect settings.
	 */
	public void Draw()
	{
		int count = this.MeshParts().Count();
		
		for (int i = 0; i < count; i++)
	    {
	        ModelMeshPart part = this.MeshParts().get(i);
	        Effect effect = part.getEffect();
	        if (effect == null)
	        {
	            throw new InvalidOperationException("ModelMeshPart has a null Effect.");
	        }
	        int num3 = effect.CurrentTechnique.getPasses().Count();
	        for (int j = 0; j < num3; j++)
	        {
	            effect.CurrentTechnique.getPasses().get(j).Apply();
	            part.Draw();
	        }
	    }
	}
}
