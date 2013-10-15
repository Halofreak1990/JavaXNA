package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;

import System.*;

/**
 * A vertex declaration, which defines per-vertex data.
 * 
 * @author Halofreak1990
 */
public class VertexDeclaration extends GraphicsResource
{
	DeclarationBinding _binding;
	VertexElement[] _elements;
	int _vertexStride;
	
	public int getVertexStride()
	{
		return this._vertexStride;
	}
	
	/**
	 * Creates an instance of this object.
	 * 
	 * @param elements
	 * An array of per-vertex elements.
	 */
	public VertexDeclaration(VertexElement... elements)
    {
        try
        {
            if ((elements == null) || (elements.length == 0))
            {
                try
                {
                    throw new ArgumentNullException("elements", "This method does not accept null for this parameter.");
                }
                catch(Throwable thr)
                {
                    super.Dispose(true);
                }
            }
            else
            {
                VertexElement[] elementArray = (VertexElement[]) elements.clone();
                this._elements = elementArray;
                int vertexStride = VertexElementValidator.GetVertexStride(elementArray);
                this._vertexStride = vertexStride;
                VertexElementValidator.Validate(vertexStride, this._elements);
            }
        }
        catch(Throwable thr)
        {
            super.Dispose(true);
        }
        try
        {
        }
        catch(Throwable thr)
        {
            super.Dispose(true);
        }
    }

	/**
	 * Creates an instance of this object.
	 * 
	 * @param vertexStride
	 * The number of bytes per element.
	 * 
	 * @param elements
	 * An array of per-vertex elements.
	 */
    public VertexDeclaration(int vertexStride, VertexElement... elements)
    {
        try
        {
            if ((elements == null) || (elements.length == 0))
            {
                try
                {
                    throw new ArgumentNullException("elements", "This method does not accept null for this parameter.");
                }
                catch(Throwable thr)
                {
                    super.Dispose(true);
                }
            }
            else
            {
                VertexElement[] elementArray = (VertexElement[]) elements.clone();
                this._elements = elementArray;
                this._vertexStride = vertexStride;
                VertexElementValidator.Validate(vertexStride, elementArray);
            }
        }
        catch(Throwable thr)
        {
            super.Dispose(true);
        }
    }
    
    void Bind(GraphicsDevice device)
    {
        if (super.IsDisposed())
        {
            throw new ObjectDisposedException(VertexDeclaration.class.getName());
        }
        VertexElementValidator.Validate(this._vertexStride, this._elements, device._profileCapabilities);
        DeclarationBinding binding = this._binding;
        if (binding != null)
        {
            //super._parent.vertexDeclarationManager.ReleaseBinding(binding);
            this._binding = null;
        }
        //this._binding = device.vertexDeclarationManager.CreateBinding(this);
        super._parent = device;
    }

    @SuppressWarnings("rawtypes")
	static VertexDeclaration FromType(Class vertexType)
	{
    	if (vertexType == null)
    	{
    		throw new ArgumentNullException("vertexType", "This method does not allow null for this parameter.");
    	}
    	
		if (!(vertexType.isPrimitive()))
		{
			throw new ArgumentException(String.format(Locale.getDefault(), "Invalid vertex type. %s is not a value type.", vertexType.toString()));
		}
		
		return null;
	}
}
