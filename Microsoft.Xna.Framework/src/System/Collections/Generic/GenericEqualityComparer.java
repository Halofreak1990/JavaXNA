package System.Collections.Generic;

import System.*;

class GenericEqualityComparer<T extends IEquatable<T>> extends EqualityComparer<T>
{
	public GenericEqualityComparer()
	{
	}
	
	@Override
	public boolean equals(Object obj)
	{
		try
		{
			@SuppressWarnings({ "unused", "unchecked" })
			GenericEqualityComparer<T> comparer = (GenericEqualityComparer<T>)obj;
		}
		catch(ClassCastException cce)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(T x, T y)
	{
		if (x != null)
		{
			return ((y != null) && x.Equals(y));
		}
		if (y != null)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode()
	{
		return super.getClass().getName().hashCode();
	}

	@Override
	public int hashCode(T obj)
	{
		if (obj == null)
		{
			return 0;
		}
		return obj.hashCode();
	}
}
