package Microsoft.Xna.Framework.Graphics;

import java.nio.*;
import java.util.*;

import org.lwjgl.*;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.*;

import System.*;
import Microsoft.Xna.Framework.*;

/**
 * Performs primitive-based rendering, creates resources, handles system-level variables, adjusts gamma ramp levels, and creates shaders.
 *
 * @author Halofreak1990
 */
public class GraphicsDevice implements IDisposable
{
	private Color clearColor;
	private GraphicsAdapter adapter;
	GraphicsProfile _graphicsProfile;
	EffectPass activePass;
	Microsoft.Xna.Framework.Graphics.DisplayMode _displayMode;
	Color cachedBlendFactor;
	BlendState cachedBlendState;
	DepthStencilState cachedDepthStencilState;
	ProfileCapabilities _profileCapabilities;
	boolean isDisposed;
    private PresentationParameters pPublicCachedParams;
    private TextureCollection textures;
	DeclarationManager vertexDeclarationManager;
	private Viewport viewport;
	private RenderTargetBinding[] renderTargets;
	private int frameBufferIdentifier;
	private IndexBuffer currentIndexBuffer;
	private int currentRenderTargetCount;
	
	/**
	 * 
	 */
	public final Event<EventArgs> DeviceLost = new Event<EventArgs>();
	
	/**
	 * 
	 */
	public final Event<EventArgs> DeviceReset = new Event<EventArgs>();
	
	/**
	 * 
	 */
	public final Event<EventArgs> DeviceResetting = new Event<EventArgs>();
	
	/**
	 * 
	 */
	public final Event<EventArgs> Disposing = new Event<EventArgs>();
	
	/**
	 * 
	 */
	public final Event<ResourceCreatedEventArgs> ResourceCreated = new Event<ResourceCreatedEventArgs>();

	/**
	 * 
	 */
	public final Event<ResourceDestroyedEventArgs> ResourceDestroyed = new Event<ResourceDestroyedEventArgs>();   
	
	/**
	 * 
	 */
	public GraphicsAdapter getAdapter()
	{
		return this.adapter;
	}
	
	/**
	 * 
	 */
	public Color getBlendFactor()
	{
		return this.cachedBlendFactor;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setBlendFactor(Color value)
	{
		EffectPass activePass = this.activePass;
		if ((activePass != null) && (activePass._stateFlags.contains(EffectStateFlags.Blend)))
		{
			//activePass.EndPass();
			this.activePass = null;
		}
		// TODO: set blend factor
		// TODO: check if this is correct
		GL14.glBlendColor((cachedBlendFactor.R() / 255f), (cachedBlendFactor.G() / 255f), (cachedBlendFactor.B() / 255f), (cachedBlendFactor.A() / 255f));
		
		this.cachedBlendFactor = value;
	}
	
	/**
	 * 
	 */
	public GraphicsProfile getGraphicsProfile()
	{
		return _graphicsProfile;
	}
	
	boolean IsDeviceLost()
	{
		// TODO: implement
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public IndexBuffer getIndices()
	{
		return this.currentIndexBuffer;
	}

	/**
	 * 
	 * @param value
	 */
	public void setIndices(IndexBuffer value)
	{
		// TODO Auto-generated method stub
	}
	
	/**
	 * Gets the presentation parameters associated with this graphics device.
	 */
	public PresentationParameters getPresentationParameters()
	{
		return this.pPublicCachedParams;
	}
	
	private void setPresentationParameters(PresentationParameters presentationParameters)
	{
		if (presentationParameters.BackBufferFormat == SurfaceFormat.Color)
		{
			
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public TextureCollection getTextures()
	{
		return this.textures;
	}
	
	/**
	 * 
	 * @return
	 */
	public Viewport getViewport()
	{
		return viewport;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setViewport(Viewport value)
	{
		viewport = value;
		GL11.glViewport(value.X, value.Y, value.Width, value.Height);
	}
	
	/**
	 * 
	 * @param adapter
	 * @param profile
	 * @param presentationParameters
	 * 
	 * @throws ArgumentNullException
	 * 
	 */
	public GraphicsDevice(GraphicsAdapter adapter, GraphicsProfile profile, PresentationParameters presentationParameters)
	{
		if(presentationParameters == null)
			throw new ArgumentNullException("presentationParameters", "This method does not accept null for this parameter.");
		
		if (adapter == null)
			throw new ArgumentNullException("adapter", "This method does not accept null for this parameter.");
		
		this.adapter = adapter;
		this._graphicsProfile = profile;
		this._profileCapabilities = ProfileCapabilities.GetInstance(profile);
		this.pPublicCachedParams = presentationParameters.Clone();
		this.renderTargets = new RenderTargetBinding[_profileCapabilities.MaxRenderTargets];
		
		this.CreateDevice(adapter, presentationParameters);
		
		this.textures = new TextureCollection();
		this.clearColor = Color.Black;
	}
	
	/**
	 * 
	 * @param color
	 */
	public void Clear(Color color)
	{
		GL11.glClearColor((float)color.R()/255f, (float)color.G()/255f, (float)color.B()/255f, (float)color.A()/255f);
		
		if (color != clearColor)
		{
			clearColor = color;
		}
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glLoadIdentity();
	}
	
	/**
	 * 
	 * @param options
	 * @param color
	 * @param depth
	 * @param stencil
	 */
	public void Clear(EnumSet<ClearOptions> options, Color color, float depth, int stencil)
	{
		GL11.glClearColor((float)color.R()/255f, (float)color.G()/255f, (float)color.B()/255f, (float)color.A()/255f);
		
		if (color != clearColor)
		{
			clearColor = color;
		}
	
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		if (options.contains(ClearOptions.DepthBuffer))
		{
			GL11.glClearDepth(depth);
		}
		if (options.contains(ClearOptions.Stencil))
		{
			GL11.glClearStencil(stencil);
		}
		if (options.contains(ClearOptions.Target))
		{
			// TODO: clear the current render target
		}
		GL11.glLoadIdentity();
	}
	
	/**
	 * 
	 * @param options
	 * @param color
	 * @param depth
	 * @param stencil
	 */
	public void Clear(EnumSet<ClearOptions> options, Vector4 color, float depth, int stencil)
	{
		Color color2 = new Color(color);
		this.Clear(options, color2, depth, stencil);
	}
	
	void ClearBlendState()
	{
		this.cachedBlendState = null;
		this.cachedBlendFactor = BlendState.Opague.cachedBlendFactor;
	}
	
	void ClearDepthStencilState()
	{
		this.cachedDepthStencilState = null;
	}
	
	private void ClearDirtyBuffers()
	{
		
	}
	
	void ClearRasterizerState()
	{
	}
	
	private void CreateDevice(GraphicsAdapter adapter, PresentationParameters presentationParameters)
	{
		try
		{
			this._displayMode = new Microsoft.Xna.Framework.Graphics.DisplayMode(presentationParameters.BackBufferWidth, presentationParameters.BackBufferHeight, presentationParameters.BackBufferFormat);
			Display.setDisplayMode(new DisplayMode(presentationParameters.BackBufferWidth, presentationParameters.BackBufferHeight));
			Display.setFullscreen(presentationParameters.IsFullScreen);
			Display.create();
			
			IntBuffer buffer = ByteBuffer.allocateDirect(1*4).asIntBuffer(); 
			EXTFramebufferObject.glGenFramebuffersEXT(buffer);
			this.frameBufferIdentifier = buffer.get(0);
		}
		catch (LWJGLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public final void Dispose()
	{
		Dispose(true);
	}
	
	/**
	 * 
	 * @param disposing
	 */
	protected void Dispose(boolean disposing)
	{
		EXTFramebufferObject.glDeleteFramebuffersEXT(frameBufferIdentifier);
		
		Display.destroy();
	}
	
	/**
	 * Renders the specified geometric primitive, based on indexing into an array of vertices.
	 * 
	 * @param primitiveType
	 * Describes the type of primitive to render. PrimitiveType.PointList is not supported with this method.
	 * 
	 * @param baseVertex
	 * Offset to add to each vertex index in the index buffer.
	 * 
	 * @param minVertexIndex
	 * Minimum vertex index for vertices used during the call. The minVertexIndex parameter and all of the indices in the index stream are relative to the baseVertex parameter.
	 * 
	 * @param numVertices
	 * Number of vertices used during the call. The first vertex is located at index: baseVertex + minVertexIndex.
	 * 
	 * @param startIndex
	 * Location in the index array at which to start reading vertices.
	 * 
	 * @param primitiveCount
	 * Number of primitives to render. The number of vertices used is a function of primitiveCount and primitiveType.
	 */
	public void DrawIndexedPrimitives(PrimitiveType primitiveType, int baseVertex, int minVertexIndex, int numVertices, int startIndex, int primitiveCount)
	{
		// TODO: implement
	}
	
	/**
	 * Draws a series of instanced models.
	 * 
	 * @param primitiveType
	 * The primitive type.
	 * 
	 * @param baseVertex
	 * Offset to add to each vertex index in the index buffer.
	 * 
	 * @param minVertexIndex
	 * Minimum vertex index for vertices used during the call. The minVertexIndex parameter and all of the indices in the index stream are relative to the baseVertex parameter.
	 * 
	 * @param numVertices
	 * Number of vertices used during the call. The first vertex is located at index: baseVertex + minVertexIndex.
	 * 
	 * @param startIndex
	 * Location in the index array at which to start reading vertices.
	 * 
	 * @param primitiveCount
	 * Number of primitives to render. The number of vertices used is a function of primitiveCount and primitiveType.
	 * 
	 * @param instanceCount
	 * Number of primitives to render.
	 */
	public void DrawInstancedPrimitives(PrimitiveType primitiveType, int baseVertex, int minVertexIndex, int numVertices, int startIndex, int primitiveCount, int instanceCount)
	{
		// TODO: implement
	}
	
	/**
	 * Renders a sequence of non-indexed geometric primitives of the specified type from the current set of data input streams.
	 * 
	 * @param primitiveType
	 * Describes the type of primitive to render.
	 * 
	 * @param startVertex
	 * Index of the first vertex to load. Beginning at startVertex, the correct number of vertices is read out of the vertex buffer.
	 * 
	 * @param primitiveCount
	 * Number of primitives to render. The primitiveCount is the number of primitives as determined by the primitive type. If it is a line list, each primitive has two vertices. If it is a triangle list, each primitive has three vertices.
	 */
	public void DrawPrimitives(PrimitiveType primitiveType, int startVertex, int primitiveCount)
	{
		// TODO: implement
	}
	
	/**
	 * Renders indexed primitives from a 32-bit index buffer and other related input parameters.
	 * 
	 * @param primitiveType
	 * The primitive type.
	 * 
	 * @param vertexData
	 * The vertex data.
	 * 
	 * @param vertexOffset
	 * Offset (in vertices) from the beginning of the vertex buffer to the first vertex to draw.
	 * 
	 * @param numVertices
	 * Number of vertices to draw.
	 * 
	 * @param indexData
	 * The index data.
	 * 
	 * @param indexOffset
	 * Offset (in indices) from the beginning of the index buffer to the first index to use.
	 * 
	 * @param primitiveCount
	 * Number of primitives to render.
	 */
	public <T extends ValueType & IVertexType> void DrawUserIndexedPrimitives(PrimitiveType primitiveType, T[] vertexData, int vertexOffset, int numVertices, int[] indexData, int indexOffset, int primitiveCount)
	{
		// TODO: implement
	}
	
	/**
	 * 
	 * @param <T>
	 * @param primitiveType
	 * @param vertexData
	 * @param vertexOffset
	 * @param numVertices
	 * @param indexData
	 * @param indexOffset
	 * @param primitiveCount
	 * @param vertexDeclaration
	 */
	public <T extends ValueType> void DrawUserIndexedPrimitives(PrimitiveType primitiveType, T[] vertexData, int vertexOffset, int numVertices, int[] indexData, int indexOffset, int primitiveCount, VertexDeclaration vertexDeclaration)
	{
		// TODO: implement
	}
	
	/**
	 * 
	 * @param <T>
	 * @param primitiveType
	 * @param vertexData
	 * @param vertexOffset
	 * @param numVertices
	 * @param indexData
	 * @param indexOffset
	 * @param primitiveCount
	 */
	public <T extends ValueType & IVertexType> void DrawUserIndexedPrimitives(PrimitiveType primitiveType, T[] vertexData, int vertexOffset, int numVertices, short[] indexData, int indexOffset, int primitiveCount)
	{
		// TODO: implement
	}
	
	/**
	 * 
	 * @param <T>
	 * @param primitiveType
	 * @param vertexData
	 * @param vertexOffset
	 * @param numVertices
	 * @param indexData
	 * @param indexOffset
	 * @param primitiveCount
	 * @param vertexDeclaration
	 */
	public <T extends ValueType> void DrawUserIndexedPrimitives(PrimitiveType primitiveType, T[] vertexData, int vertexOffset, int numVertices, short[] indexData, int indexOffset, int primitiveCount, VertexDeclaration vertexDeclaration)
	{
		// TODO: implement
	}
	
	/**
	 * 
	 * @param <T>
	 * @param primitiveType
	 * @param vertexData
	 * @param vertexOffset
	 * @param primitiveCount
	 */
	public <T extends ValueType & IVertexType> void DrawUserPrimitives(PrimitiveType primitiveType, T[] vertexData, int vertexOffset, int primitiveCount)
	{
		// TODO: implement
	}
	
	/**
	 * 
	 * @param <T>
	 * @param primitiveType
	 * @param vertexData
	 * @param vertexOffset
	 * @param primitiveCount
	 * @param vertexDeclaration
	 */
	public <T extends ValueType> void DrawUserPrimitives(PrimitiveType primitiveType, T[] vertexData, int vertexOffset, int primitiveCount, VertexDeclaration vertexDeclaration)
	{
		// TODO: implement
	}
	
	/**
	 * 
	 * @param <T>
	 * @param rect
	 * @param data
	 * @param startIndex
	 * @param offset
	 */
	public <T extends Number> void GetBackBufferData(Rectangle rect, T[] data, int startIndex, int offset)
	{
		if (!this._profileCapabilities.GetBackBufferData)
		{
			this._profileCapabilities.ThrowNotSupportedException("JavaXNA Framework %1$ does not support %2$.", "GetBackBufferData");
		}
		
		// TODO: implement
	}
	
	/**
	 * 
	 * @param <T>
	 * @param data
	 */
	public <T extends Number> void GetBackBufferData(T[] data)
	{
		int length;
		if (data != null)
		{
			length = data.length;
		}
		else
		{
			length = 0;
		}
		Rectangle rect = null;
		this.GetBackBufferData(rect, data, 0, length);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param data
	 * @param startIndex
	 * @param elementCount
	 */
	public <T extends Number> void GetBackBufferData(T[] data, int startIndex, int elementCount)
	{
		GetBackBufferData(null, data, startIndex, elementCount);
	}
	
	private int getColorAttachment(int index)
	{
		if (index < 0 || index > _profileCapabilities.MaxRenderTargets)
			throw new NotSupportedException("The index is out of range.");
		
		if (index == 0)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT;
		else if (index == 1)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT1_EXT;
		else if (index == 2)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT2_EXT;
		else if (index == 3)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT3_EXT;
		else if (index == 4)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT4_EXT;
		else if (index == 5)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT5_EXT;
		else if (index == 6)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT6_EXT;
		else if (index == 7)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT7_EXT;
		else if (index == 8)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT8_EXT;
		else if (index == 9)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT9_EXT;
		else if (index == 10)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT10_EXT;
		else if (index == 11)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT11_EXT;
		else if (index == 12)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT12_EXT;
		else if (index == 13)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT13_EXT;
		else if (index == 14)
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT14_EXT;
		else
			return EXTFramebufferObject.GL_COLOR_ATTACHMENT15_EXT;
	}
	
	/**
	 * 
	 * @return
	 */
	public RenderTargetBinding[] GetRenderTargets()
	{
		int currentRenderTargetCount = this.currentRenderTargetCount;
		RenderTargetBinding[] destinationArray = new RenderTargetBinding[currentRenderTargetCount];
		System.arraycopy(renderTargets, 0, destinationArray, 0, currentRenderTargetCount);
		return destinationArray;
	}

	/**
	 * 
	 */
	public void Present()
	{
		Display.processMessages();
		
		try { Display.swapBuffers(); }
		catch (LWJGLException e) { e.printStackTrace(); }
	}
	
	/**
	 * 
	 */
	public void Reset()
	{
		this.Reset(getPresentationParameters(), getAdapter());
	}
	
	/**
	 * 
	 * @param presentationParameters
	 */
	public void Reset(PresentationParameters presentationParameters)
	{
		this.Reset(presentationParameters, this.getAdapter());
	}
	
	/**
	 * 
	 * @param presentationParameters
	 * @param adapter
	 */
	public void Reset(PresentationParameters presentationParameters, GraphicsAdapter adapter)
	{
		if (DeviceResetting.hasHandlers())
			DeviceResetting.raise(this, EventArgs.Empty);
		
		setPresentationParameters(presentationParameters);
		
		if (DeviceReset.hasHandlers())
			DeviceReset.raise(this, EventArgs.Empty);
	}
	
	/**
	 * Sets a new render target for this GraphicsDevice.
	 * 
	 * @param renderTarget
	 * A new render target for the device, or null to set the device render target to the back buffer of the device.
	 */
	public void SetRenderTarget(RenderTarget2D renderTarget)
	{		
		if (renderTarget == null)
		{
			// TODO: get render target index
			//EXTFramebufferObject.glFramebufferTexture2DEXT(EXTFramebufferObject.GL_FRAMEBUFFER_EXT, getColorAttachment(renderTargetIndex), GL11.GL_TEXTURE_2D, 0, 0);
			EXTFramebufferObject.glFramebufferRenderbufferEXT(EXTFramebufferObject.GL_FRAMEBUFFER_EXT, EXTFramebufferObject.GL_DEPTH_ATTACHMENT_EXT, EXTFramebufferObject.GL_RENDERBUFFER_EXT, 0);
//			
//			if (--numActiveRenderTargets == 0)
//				EXTFramebufferObject.glBindFramebufferEXT(EXTFramebufferObject.GL_FRAMEBUFFER_EXT, 0); 
		}
	
		if (renderTarget.isDisposed)
		{
			throw new ObjectDisposedException(renderTarget.getClass().getName() ,"SetRenderTarget is called after the render target has been disposed.");
		}
	}
	
	/**
	 * 
	 * @param renderTarget
	 * @param cubeMapFace
	 */
	public void SetRenderTarget(RenderTargetCube renderTarget, CubeMapFace cubeMapFace)
	{
		if (renderTarget != null)
		{
			RenderTargetBinding binding = new RenderTargetBinding(renderTarget, cubeMapFace);
			this.SetRenderTargets(new RenderTargetBinding[] { binding }, 1);
		}
		else
		{
			this.SetRenderTargets(null, 0);
		}
	}
	
	/**
	 * Sets an array of RenderTargets.
	 * 
	 * @param renderTargets
	 * An array of RenderTargets.
	 */
	public void SetRenderTargets(RenderTargetBinding... renderTargets)
	{
		if ((renderTargets != null) && (renderTargets.length > 0))
		{
			this.SetRenderTargets(renderTargets, renderTargets.length);
		}
		else
		{
			this.SetRenderTargets(null, 0);
		}
	}
	
	private void SetRenderTargets(RenderTargetBinding[] bindings, int renderTargetCount)
	{
		
	}
	
	/**
	 * Sets or binds a vertex buffer to the device.
	 * 
	 * @param vertexBuffer
	 * A vertex buffer.
	 */
	public void SetVertexBuffer(VertexBuffer vertexBuffer)
	{
		// TODO: implement
	}
	
	/**
	 * 
	 * @param vertexBuffer
	 * @param vertexOffset
	 */
	public void SetVertexBuffer(VertexBuffer vertexBuffer, int vertexOffset)
	{
		// TODO: implement
	}
}
