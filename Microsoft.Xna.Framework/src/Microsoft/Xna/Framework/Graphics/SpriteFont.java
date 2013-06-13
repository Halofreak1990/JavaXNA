package Microsoft.Xna.Framework.Graphics;

import java.util.*;
import Microsoft.Xna.Framework.*;

public final class SpriteFont
{
	private List<Character> charmap = new ArrayList<Character>();
	private Texture2D texture;
	private List<Vector3> kerning = new ArrayList<Vector3>();
	private List<Rectangle> glyphs = new ArrayList<Rectangle>();
	private List<Rectangle> cropping = new ArrayList<Rectangle>();
	private char defaultchar;
	
	public int LineSpacing;
	public float Spacing;
	
	SpriteFont(Texture2D texture, List<Rectangle> glyphs, List<Rectangle> cropping, List<Character> charMap, int lineSpacing, float spacing, List<Vector3> kerning, char defaultchar)
	{
		this.texture = texture;
		this.glyphs = glyphs;
		this.cropping = cropping;
		this.charmap = charMap;
		this.LineSpacing = lineSpacing;
		this.Spacing = spacing;
		this.kerning = kerning;
		this.defaultchar = defaultchar;
	}
	
	private int CharacterIndex(char character)
	{
		int lowindex = 0;
		int highindex = this.charmap.size() - 1;
		while (lowindex <= highindex)
		{
			int index = lowindex + ((highindex - lowindex) >> 1);
			if (this.charmap.get(index) == character)
			{
				return index;
			}
			if (this.charmap.get(index) < character)
			{
				lowindex = index + 1;
			}
			else
			{
				highindex = index - 1;
			}
		}

		if (this.defaultchar != '\0')
		{
			char ch = this.defaultchar;
			if (character != ch)
			{
				return this.CharacterIndex(ch);
			}
		}
		throw new IllegalArgumentException("Character not in Font");
	}
	
	void Draw(String text, SpriteBatch spriteBatch, Vector2 Position, Color color, float rotation, Vector2 origin, Vector2 scale, SpriteEffects spriteEffects, float depth)
	{
		Vector2 pos = Vector2.Zero;
		Matrix matrix = new Matrix();
		Matrix Rotationmatrix = new Matrix();
		Matrix.CreateRotationZ(rotation, Rotationmatrix);
		Matrix.CreateTranslation(-origin.X * scale.X, -origin.Y * scale.Y, 0f, matrix);
		Matrix.Multiply(matrix, Rotationmatrix, Rotationmatrix);
		
		int flip = 1;
		float beginningofline = 0f;
		boolean flag = true;
		if (spriteEffects == SpriteEffects.FlipHorizontally)
		{
			beginningofline = this.Measure(text).X * scale.X;  flip = -1;
		}
		if (spriteEffects == SpriteEffects.FlipVertically)
		{
			pos.Y = (this.Measure(text).Y - this.LineSpacing) * scale.Y;
		}
		else
		{
			pos.Y = 0f;
		}
		pos.X = beginningofline;

		for (int i = 0; i < text.length(); i++)
		{
			char character = text.charAt(i);
			switch (character)
			{
				case '\r':
					break;
				case '\n':
					flag = true;
					pos.X = beginningofline;
					if (spriteEffects == SpriteEffects.FlipVertically)
					{
						pos.Y -= this.LineSpacing * scale.Y;
					}
					else
					{
						pos.Y += this.LineSpacing * scale.Y;
					}
					break;
				default:
				{
					int indexForCharacter = this.CharacterIndex(character);
					Vector3 charkerning = this.kerning.get(indexForCharacter);
					if (flag)
					{
						charkerning.X = Math.max(charkerning.X, 0f);
					}
					else
					{
						pos.X += (this.Spacing * scale.X) * flip;
					}
					pos.X += (charkerning.X * scale.X) * flip;
					Rectangle rectangle = this.glyphs.get(indexForCharacter);
					Rectangle rectangle2 = this.cropping.get(indexForCharacter);
					if (spriteEffects == SpriteEffects.FlipVertically)
					{
						rectangle2.Y = (this.LineSpacing - rectangle.Height) - rectangle2.Y;
					}
					if (spriteEffects == SpriteEffects.FlipHorizontally)
					{
						rectangle2.X -= rectangle2.Width;
					}
					Vector2 position = pos;
					position.X += rectangle2.X * scale.X;
					position.Y += rectangle2.Y * scale.Y;
					Vector2.Transform(position, Rotationmatrix, position);
					position.Add(Position);
					spriteBatch.Draw(this.texture, position, rectangle, color, rotation, Vector2.Zero, scale, spriteEffects, depth);

					flag = false;
					pos.X += ((charkerning.Y + charkerning.Z) * scale.X) * flip;
					break;
				}
			}
		}
	}
	
	private Vector2 Measure(String text)
	{
		if (text.length() == 0)
		{
			return Vector2.Zero;
		}
		Vector2 zero = Vector2.Zero;
		zero.Y = this.LineSpacing;
		float min = 0f;
		int count = 0;
		float z = 0f;
		boolean flag = true;
		
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) != '\r')
			{
				if (text.charAt(i) == '\n')
				{
					zero.X += Math.max(z, 0f);
					z = 0f;
					min = Math.max(zero.X, min);
					zero = Vector2.Zero;
					zero.Y = this.LineSpacing;
					flag = true;
					count++;
				}
				else
				{
					Vector3 vector2 = this.kerning.get(this.CharacterIndex(text.charAt(i)));
					if (flag)
					{
						vector2.X = Math.max(vector2.X, 0f);
					}
					else
					{
						zero.X += this.Spacing + z;
					}
					zero.X += vector2.X + vector2.Y;
					z = vector2.Z;
					Rectangle rectangle = this.cropping.get(this.CharacterIndex(text.charAt(i)));
					zero.Y = Math.max(zero.Y, (float)rectangle.Height);
					flag = false;
				}
			}
		}
		zero.X += Math.max(z, 0f);
		zero.Y += count * this.LineSpacing;
		zero.X = Math.max(zero.X, min);
		return zero;
	}
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	public Vector2 MeasureString(String text)
	{
		return Measure(text);
	}
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	public Vector2 MeasureString(StringBuilder text)
	{
		return Measure(text.toString());
	}
}
