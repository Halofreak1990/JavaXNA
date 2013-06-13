package Microsoft.Xna.Framework.Graphics;

/**
 * Defines usage for vertex elements.
 * 
 * @author Halofreak1990
 */
public enum VertexElementUsage
{
	/**
	 * Position data. (Position with UsageIndex = 0 ) specifies the nontransformed position in fixed-function vertex processing and the N-patch tessellator. (Position with
	 * UsageIndex = 1) specifies the nontransformed position in the fixed-function vertex shader for skinning.
	 */
	Position,
	/**
	 * Vertex data contains diffuse or specular color. (Color with UsageIndex = 0) specifies the diffuse color in the fixed-function vertex shader and in pixel shaders prior to
	 * ps_3_0. (Color with UsageIndex = 1) specifies the specular color in the fixed-function vertex shader and in pixel shaders prior to ps_3_0.
	 */
	Color,
	/**
	 * Texture coordinate data. (TextureCoordinate, n) specifies texture coordinates in fixed-function vertex processing and in pixel shaders prior to ps_3_0. These coordinates
	 * can be used to pass user-defined data.
	 */
	TextureCoordinate,
	/**
	 * Vertex normal data. (Normal with UsageIndex = 0) specifies vertex normals for fixed-function vertex processing and the N-patch tessellator. (Normal with UsageIndex = 1)
	 * specifies vertex normals for fixed-function vertex processing for skinning.
	 */
	Normal,
	/**
	 * Vertex binormal data.
	 */
	Binormal,
	/**
	 * Vertex tangent data.
	 */
	Tangent,
	/**
	 * Blending indices data. (BlendIndices with UsageIndex = 0) specifies matrix indices for fixed-function vertex processing using indexed paletted skinning.
	 */
	BlendIndices,
	/**
	 * Blending weight data. (BlendWeight with UsageIndex = 0) specifies the blend weights in fixed-function vertex processing.
	 */
	BlendWeight,
	/**
	 * Vertex data contains depth data.
	 */
	Depth,
	/**
	 * Vertex data contains fog data. (Fog with UsageIndex = 0) specifies a fog blend value to use after pixel shading is finished. This flag applies to pixel shaders prior to
	 * version ps_3_0.
	 */
	Fog,
	/**
	 * Point size data. (PointSize with UsageIndex = 0) specifies the point-size attribute used by the setup engine of the rasterizer to expand a point into a quad for the point-
	 * sprite functionality.
	 */
	PointSize,
	/**
	 * Vertex data contains sampler data. (Sample with UsageIndex = 0) specifies the displacement value to look up.
	 */
	Sample,
	/**
	 * Single, positive floating-point value. (TessellateFactor with UsageIndex = 0) specifies a tessellation factor used in the tessellation unit to control the rate of tessellation.
	 */
	TessellateFactor,
}
