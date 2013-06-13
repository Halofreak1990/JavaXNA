package Microsoft.Xna.Framework.Graphics;

import java.util.*;
import System.Collections.Generic.*;

class DeclarationManager implements IEqualityComparer<VertexElement[]>
{
	private HashMap<VertexElement[], DeclarationBinding> bindings;
	private int currentDeclarationCount;
	private DeclarationBinding[] currentDeclarations;
	private GraphicsDevice device;
	
	DeclarationManager(GraphicsDevice device)
	{
		this.device = device;
		this.bindings = new HashMap<VertexElement[], DeclarationBinding>();
		this.currentDeclarations = new DeclarationBinding[device._profileCapabilities.MaxVertexStreams];
	}
	
	private void ClearCurrent()
	{
		int index = 0;
	    if (0 < this.currentDeclarationCount)
	    {
	        do
	        {
	            this.currentDeclarations[index] = null;
	            index++;
	        }
	        while (index < this.currentDeclarationCount);
	    }
	    this.currentDeclarationCount = 0;
	}
	
	DeclarationBinding CreateBinding(VertexDeclaration declaration)
	{
		DeclarationBinding binding = null;
	    synchronized (this)
	    {
	        VertexElement[] key = declaration._elements;
	        if (this.bindings.containsKey(key))
	        {
	        	binding = this.bindings.get(key);
	            binding.referenceCount++;
	            return binding;
	        }
	        binding = new DeclarationBinding(key);
	        this.bindings.put(key, binding);
	        return binding;
	    }
	}
	
	private void CreateNativeDeclaration(DeclarationBinding.BindingNode node)
	{
		int num4 = 0;
	    int index = 0;
	    int currentDeclarationCount = this.currentDeclarationCount;
	    if (0 < currentDeclarationCount)
	    {
	        DeclarationBinding[] currentDeclarations = this.currentDeclarations;
	        do
	        {
	            num4 = currentDeclarations[index].elements.length + num4;
	            index++;
	        }
	        while (index < currentDeclarationCount);
	    }
	    int maxVertexStreams = this.device._profileCapabilities.MaxVertexStreams;
	    if (num4 > maxVertexStreams)
	    {
	        this.device._profileCapabilities.ThrowNotSupportedException("JavaXNA Framework %1$ profile supports a maximum of %2$ simultaneous vertex elements.", maxVertexStreams);
	    }
	    
	    // TODO: either implement, or remove
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(VertexElement[] x, VertexElement[] y)
	{
		return x.equals(y);
	}

	/**
	 * 
	 */
	@Override
	public int hashCode(VertexElement[] obj)
	{
		return obj.hashCode();
	}
	
	void ReleaseBinding(DeclarationBinding binding)
	{
		
	}
}
