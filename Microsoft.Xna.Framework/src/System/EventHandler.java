package System;

/**
 * 
 *
 * @author Halofreak1990
 * @param <T>
 * The type of EventArgs to use in this EventHandler.
 */
public interface EventHandler<T>
{
	void Invoke(Object sender, T e);
}

