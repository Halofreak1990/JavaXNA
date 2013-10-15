package Microsoft.Xna.Framework.Graphics;

import System.*;

import Microsoft.Xna.Framework.*;

/**
 * Represents an Effect parameter.
 * 
 * @author Halofreak1990
 */
public final class EffectParameter
{
	int _index;
	EffectParameterClass _parameterClass;
	EffectParameterCollection _elementCollection;
	Effect _parent;

	/**
	 * Gets the collection of EffectAnnotation objects for this parameter.
	 * 
	 * @return
	 * The collection of EffectAnnotation objects for this parameter.
	 */
	public EffectAnnotationCollection getAnnotations()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the number of columns in the parameter description.
	 * 
	 * @return
	 * The number of columns in the parameter description.
	 */
	public int getColumnCount()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the collection of effect parameters.
	 * 
	 * @return
	 * The collection of effect parameters.
	 */
	public EffectParameterCollection getElements()
	{
		return _elementCollection;
	}

	/**
	 * Gets the name of the parameter.
	 * 
	 * @return
	 * The name of the parameter.
	 */
	public String getName()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the class of the parameter.
	 * 
	 * @return
	 * The class of the parameter.
	 */
	public EffectParameterClass getParameterClass()
	{
		return _parameterClass;
	}

	/**
	 * Gets the type of the parameter.
	 * 
	 * @return
	 * The type of the parameter.
	 */
	public EffectParameterType getParameterType()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the number of rows in the parameter description.
	 * 
	 * @return
	 * The number of rows in the parameter description.
	 */
	public int getRowCount()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the semantic meaning, or usage, of the parameter.
	 * 
	 * @return
	 * The semantic meaning, or usage, of the parameter.
	 */
	public String getSemantic()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the collection of structure members.
	 * 
	 * @return
	 * The collection of structure members.
	 */
	public EffectParameterCollection getStructureMembers()
	{
		throw new NotImplementedException();
	}

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
	 * Gets the value of the EffectParameter as an array of Boolean.
	 * 
	 * @param count
	 * The number of elements in the array.
	 * 
	 * @return
	 * The value of the EffectParameter as an array of Boolean.
	 */
	public boolean[] GetValueBooleanArray(int count)
	{
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
	 * Gets the value of the EffectParameter as an array of Int32.
	 * 
	 * @param count
	 * The number of elements in the array.
	 * 
	 * @return
	 */
	public int[] GetValueInt32Array(int count)
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a Matrix.
	 * 
	 * @return
	 */
	public Matrix GetValueMatrix()
	{
		if ((_parameterClass != EffectParameterClass.Matrix) && (this._elementCollection.Count() == 0))
		{
			throw new ClassCastException();
		}

		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as an array of Matrix.
	 * 
	 * @param count
	 * The number of elements in the array.
	 * 
	 * @return
	 */
	public Matrix[] GetValueMatrixArray(int count)
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a transposed Matrix.
	 * 
	 * @return
	 */
	public Matrix GetValueMatrixTranspose()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as an array of transposed Matrices.
	 * 
	 * @param count
	 * The number of elements in the array.
	 * 
	 * @return
	 */
	public Matrix[] GetValueMatrixTransposeArray(int count)
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a Quaternion.
	 * 
	 * @return
	 */
	public Quaternion GetValueQuaternion()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as an array of Quaternion.
	 * 
	 * @param count
	 * The number of elements in the array.
	 * 
	 * @return
	 */
	public Quaternion[] GetValueQuaternionArray(int count)
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a Single.
	 * 
	 * @return
	 */
	public float GetValueSingle()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as an array of Single.
	 * @param count
	 * The number of elements in the array.
	 * 
	 * @return
	 */
	public float[] GetValueSingleArray(int count)
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as an String.
	 * 
	 * @return
	 */
	public String GetValueString()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a Texture2D.
	 * 
	 * @return
	 */
	public Texture2D GetValueTexture2D()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a Texture3D.
	 * 
	 * @return
	 */
	public Texture3D GetValueTexture3D()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a TextureCube.
	 * 
	 * @return
	 */
	public TextureCube GetValueTextureCube()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a Vector3.
	 * 
	 * @return
	 */
	public Vector2 GetValueVector2()
	{
		if ((_parameterClass != EffectParameterClass.Vector) && (this._elementCollection.Count() == 0))
		{
			throw new ClassCastException();
		}

		throw new NotImplementedException();
	}

	/**
	 * Gets the value of the EffectParameter as a Vector3.
	 * 
	 * @return
	 */
	public Vector3 GetValueVector3()
	{
		if ((_parameterClass != EffectParameterClass.Vector) && (this._elementCollection.Count() == 0))
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
