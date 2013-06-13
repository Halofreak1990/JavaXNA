package System;

/**
 * Encapsulates a method that takes a single parameter and does not return a value.
 * 
 * @author Halofreak1990
 *
 * @param <T>
 * The type of the parameter of the method that this delegate encapsulates.
 */
public abstract class Action<T>
{
	public abstract void Invoke(T obj);
}
