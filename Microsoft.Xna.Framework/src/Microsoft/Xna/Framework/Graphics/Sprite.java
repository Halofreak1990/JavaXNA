package Microsoft.Xna.Framework.Graphics;

import Microsoft.Xna.Framework.*;

class Sprite
{
	public Color Color;
	public Rectangle DestinationRectangle;
	public SpriteEffects Effects;
	public float LayerDepth;
	public Vector2 Origin;
	public float Rotation;
	public Rectangle SourceRectangle;
	public Texture2D Texture;
	
	public Sprite(Texture2D texture, Rectangle sourceRectangle, Rectangle destinationRectangle, Color color, float rotation, Vector2 origin, SpriteEffects effects, float layerDepth)
	{
		this.Texture = texture;
		this.SourceRectangle = sourceRectangle;
		this.DestinationRectangle = destinationRectangle;
		this.Color = color;
		this.Origin = origin;
		this.Rotation = rotation;
		this.Effects = effects;
		this.LayerDepth = layerDepth;
	}

}
