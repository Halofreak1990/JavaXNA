package Microsoft.Xna.Framework.Content;

import System.*;
import System.IO.*;

import Microsoft.Xna.Framework.*;

/**
 * A worker object that implements most of ContentManager.Load. A new ContentReader is constructed for each asset loaded.
 * 
 * @author Halofreak1990
 */
public final class ContentReader extends BinaryReader
{
	private String assetName;
	private ContentManager contentManager;
	private Action<IDisposable> recordDisposableObject;
	
	public String getAssetName()
	{
		return assetName;	
	}
	
	public ContentManager getContentmanager()
	{
		return contentManager;
	}
	
	ContentReader(ContentManager contentManager, Stream input, String assetName, Action<IDisposable> recordDisposableObject)
	{
		// TODO: implement
		super(input);
		this.assetName = assetName;
		this.contentManager = contentManager;
		this.recordDisposableObject = recordDisposableObject;
	}
	
	/**
	 * Reads a Color value from the currently open stream.
	 */
	public Color ReadColor()
	{
		Color result = new Color();
		result.setPackedValue(this.ReadInt32());
		return result;
	}
	
	/**
	 * Reads a Matrix value from the currently open stream.
	 */
	public Matrix ReadMatrix()
	{
		Matrix result = new Matrix();
		result.M11 = ReadSingle();
		result.M12 = ReadSingle();
		result.M13 = ReadSingle();
		result.M14 = ReadSingle();
		result.M21 = ReadSingle();
		result.M22 = ReadSingle();
		result.M23 = ReadSingle();
		result.M24 = ReadSingle();
		result.M31 = ReadSingle();
		result.M32 = ReadSingle();
		result.M33 = ReadSingle();
		result.M34 = ReadSingle();
		result.M41 = ReadSingle();
		result.M42 = ReadSingle();
		result.M43 = ReadSingle();
		result.M44 = ReadSingle();
		return result;
	}
	
	/**
	 * Reads a Quaternion value from the current stream.
	 */
	public Quaternion ReadQuaternion()
	{
		Quaternion result = new Quaternion();
		result.X = ReadSingle();
		result.Y = ReadSingle();
		result.Z = ReadSingle();
		result.W = ReadSingle();
		return result;
	}
	
	/**
	 * Reads a Vector2 value from the current stream.
	 */
	public Vector2 ReadVector2()
	{
		Vector2 result = new Vector2();
		result.X = ReadSingle();
		result.Y = ReadSingle();
		return result; 
	}
	
	/**
	 * Reads a Vector3 value from the current stream.
	 */
	public Vector3 ReadVector3()
	{
		Vector3 result = new Vector3();
		result.X = ReadSingle();
		result.Y = ReadSingle();
		result.Z = ReadSingle();
		return result; 
	}
	
	/**
	 * Reads a Vector4 value from the current stream.
	 */
	public Vector4 ReadVector4()
	{
		Vector4 result = new Vector4();
		result.X = ReadSingle();
		result.Y = ReadSingle();
		result.Z = ReadSingle();
		result.W = ReadSingle();
		return result; 
	}
}
