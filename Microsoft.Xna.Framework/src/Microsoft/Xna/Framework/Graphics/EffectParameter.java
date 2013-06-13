package Microsoft.Xna.Framework.Graphics;

import System.*;

import Microsoft.Xna.Framework.*;

/**
 * 
 * 
 * @author Halofreak1990
 */
public final class EffectParameter
{
	int _index;
	EffectParameterClass _parameterClass;
	EffectParameterCollection _elementCollection;
	Effect _parent;
	
	EffectParameter(Effect effect, int index)
	{
		this._index = index;
		this._parent = effect;
	}
	
	/**
	 * Gets the value of the EffectParameter as a Boolean.
	 */
	public boolean GetValueBoolean()
	{
		if ((_parameterClass != EffectParameterClass.Scalar) && (this._elementCollection.Count() == 0))
		{
			throw new ClassCastException();
		}
		
		throw new NotImplementedException();
	}
	
	/**
	 * Gets the value of the EffectParameter as an Int32.
	 */
	public int GetValueInt32()
	{
		if ((_parameterClass != EffectParameterClass.Scalar) && (this._elementCollection.Count() == 0))
		{
			throw new ClassCastException();
		}
		
		throw new NotImplementedException();
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Matrix[] value)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Quaternion[] value)
	{
		throw new NotImplementedException();
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Texture value)
	{
		if (value != null)
		{
			// TODO: check if value is disposed
			
			if (value.IsActiveRenderTarget())
			{
				throw new InvalidOperationException("The render target must not be set on the device when it is used as a texture.");
			}
		}
		
		// TODO: implement 		
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Matrix value)
	{
		if ((this._parameterClass != EffectParameterClass.Matrix) || (this._elementCollection.Count() != 0))
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Quaternion value)
	{
		if (this._elementCollection.Count() != 0)
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Vector2 value)
	{
		if (this._elementCollection.Count() != 0)
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Vector3 value)
	{
		if (this._elementCollection.Count() != 0)
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Vector4 value)
	{
		if (this._elementCollection.Count() != 0)
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(boolean value)
	{
		if (this._elementCollection.Count() != 0)
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(int value)
	{
		if (this._elementCollection.Count() != 0)
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(float value)
	{
		if (this._elementCollection.Count() != 0)
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Vector2[] value)
	{
		if ((this._parameterClass != EffectParameterClass.Vector) ||
			(this._elementCollection.Count() != 0))
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Vector3[] value)
	{
		if ((this._parameterClass != EffectParameterClass.Vector) ||
			(this._elementCollection.Count() != 0))
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(Vector4[] value)
	{
		if ((this._parameterClass != EffectParameterClass.Vector) ||
			(this._elementCollection.Count() != 0))
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(String value)
	{
		if ((this._parameterClass != EffectParameterClass.Struct) ||
			(this._elementCollection.Count() != 0))
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(boolean[] value)
	{
		if ((this._parameterClass != EffectParameterClass.Scalar) || 
			(this._parameterClass != EffectParameterClass.Vector) ||
			(this._parameterClass != EffectParameterClass.Matrix) ||
			(this._elementCollection.Count() != 0))
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(int[] value)
	{
		if ((this._parameterClass != EffectParameterClass.Scalar) || 
				(this._parameterClass != EffectParameterClass.Vector) ||
				(this._parameterClass != EffectParameterClass.Matrix) ||
				(this._elementCollection.Count() != 0))
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
	
	/**
	 * Sets the value of the EffectParameter.
	 * 
	 * @param value
	 * The value to assign to the EffectParameter.
	 */
	public void SetValue(float[] value)
	{
		if ((this._parameterClass != EffectParameterClass.Scalar) || 
				(this._parameterClass != EffectParameterClass.Vector) ||
				(this._parameterClass != EffectParameterClass.Matrix) ||
				(this._elementCollection.Count() != 0))
		{
			throw new ClassCastException();
		}
		
		// TODO: implement
	}
}
