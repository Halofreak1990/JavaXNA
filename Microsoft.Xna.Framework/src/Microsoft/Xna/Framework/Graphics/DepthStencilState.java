package Microsoft.Xna.Framework.Graphics;

import java.util.Locale;
import System.*;

/**
 * Contains depth-stencil state for the device.
 * 
 * @author Halofreak1990
 */
public class DepthStencilState extends GraphicsResource
{
	/**
	 * A built-in state object with default settings for using a depth stencil buffer.
	 */
	public static final DepthStencilState Default;
	/**
	 * A built-in state object with settings for enabling a read-only depth stencil buffer.
	 */
    public static final DepthStencilState DepthRead;
    /**
     * A built-in state object with settings for not using a depth stencil buffer.
     */
    public static final DepthStencilState None;
    
    boolean isBound;
    
	boolean cachedDepthBufferEnable;
	boolean cachedDepthBufferWriteEnable;
	CompareFunction cachedDepthBufferFunction;
	boolean cachedStencilEnable;
	CompareFunction cachedStencilFunction;
	StencilOperation cachedStencilPass;
	StencilOperation cachedStencilFail;
	StencilOperation cachedStencilDepthBufferFail;
	boolean cachedTwoSidedStencilMode;
	CompareFunction cachedCounterClockwiseStencilFunction;
	StencilOperation cachedCounterClockwiseStencilPass;
	StencilOperation cachedCounterClockwiseStencilFail;
	StencilOperation cachedCounterClockwiseStencilDepthBufferFail;
	int cachedStencilMask;
	int cachedStencilWriteMask;
	int cachedReferenceStencil;
    
	public boolean getDepthBufferEnable()
	{
		return cachedDepthBufferEnable;
	}
	
	/**
	 * Enables or disables depth buffering. The default is true.
	 */
	public void setDepthBufferEnable(boolean value)
	{
		this.ThrowIfBound();
		this.cachedDepthBufferEnable = value;
	}
	
    /**
     * Creates an instance of DepthStencilState with default values.
     */
    public DepthStencilState()
    {
        try
        {
            this.SetDefaults();
            this.isBound = false;
        }
        catch (RuntimeException ex)
        {
            super.Dispose(true);
        }
    }
    
    private DepthStencilState(boolean depthEnable, boolean depthWriteEnable, String name)
    {
        try
        {
            this.SetDefaults();
            this.ThrowIfBound();
            this.cachedDepthBufferEnable = depthEnable;
            this.ThrowIfBound();
            this.cachedDepthBufferWriteEnable = depthWriteEnable;
            super.Name = name;
            this.isBound = true;
        }
        catch (RuntimeException ex)
        {
            super.Dispose(true);
        }
    }
    
    void Apply(GraphicsDevice device)
    {
    	if (super.IsDisposed())
    	{
    		throw new ObjectDisposedException(DepthStencilState.class.getName());
    	}
    	if (super._parent != device)
    	{
    		super._parent = device;
    		this.isBound = true;
    	}
    	if (this.cachedStencilEnable)
    	{
    		if (this.cachedTwoSidedStencilMode)
    		{
    			
    		}
    	}
    }
    
    private void SetDefaults()
    {
        this.ThrowIfBound();
        this.cachedDepthBufferEnable = true;
        this.ThrowIfBound();
        this.cachedDepthBufferWriteEnable = true;
        this.ThrowIfBound();
        this.cachedDepthBufferFunction = CompareFunction.LessEqual;
        this.ThrowIfBound();
        this.cachedStencilEnable = false;
        this.ThrowIfBound();
        this.cachedStencilFunction = CompareFunction.Always;
        this.ThrowIfBound();
        this.cachedStencilPass = StencilOperation.Keep;
        this.ThrowIfBound();
        this.cachedStencilFail = StencilOperation.Keep;
        this.ThrowIfBound();
        this.cachedStencilDepthBufferFail = StencilOperation.Keep;
        this.ThrowIfBound();
        this.cachedTwoSidedStencilMode = false;
        this.ThrowIfBound();
        this.cachedCounterClockwiseStencilFunction = CompareFunction.Always;
        this.ThrowIfBound();
        this.cachedCounterClockwiseStencilPass = StencilOperation.Keep;
        this.ThrowIfBound();
        this.cachedCounterClockwiseStencilFail = StencilOperation.Keep;
        this.ThrowIfBound();
        this.cachedCounterClockwiseStencilDepthBufferFail = StencilOperation.Keep;
        this.ThrowIfBound();
        this.cachedStencilMask = -1;
        this.ThrowIfBound();
        this.cachedStencilWriteMask = -1;
        this.ThrowIfBound();
        this.cachedReferenceStencil = 0;
    }
    
    void ThrowIfBound()
    {
        if (this.isBound)
        {
            Object[] args = new Object[] { DepthStencilState.class };
            throw new IllegalStateException(String.format(Locale.getDefault(), "Cannot change readonly %s. State objects become read-only the first time they are bound to a GraphicsDevice. To change property values, create a new %s instance", args));
        }
    }
    
    static
    {
    	None = new DepthStencilState(false, false, "DepthStencilState.None");
    	Default = new DepthStencilState(true, true, "DepthStencilState.Default");
        DepthRead = new DepthStencilState(true, false, "DepthStencilState.DepthRead");
    }
}
