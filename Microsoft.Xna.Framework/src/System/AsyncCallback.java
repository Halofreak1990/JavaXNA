package System;

/**
 * References a method to be called when a corresponding asynchronous operation completes.
 * 
 * @author Halofreak1990
 */
public abstract class AsyncCallback
{
	public abstract void Invoke(IAsyncResult ar);
}
