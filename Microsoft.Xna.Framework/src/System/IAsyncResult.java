package System;

/**
 * Represents the status of an asynchronous operation.
 * 
 * @author Halofreak1990
 */
public interface IAsyncResult
{
	/**
	 * Gets a user-defined object that qualifies or contains information about an asynchronous operation.
	 * 
	 * @return
	 * A user-defined object that qualifies or contains information about an asynchronous operation.
	 */
	public Object AsyncState();
	
	/**
	 * Gets an indication of whether the asynchronous operation completed synchronously.
	 * 
	 * @return
	 * true if the asynchronous operation completed synchronously; otherwise, false.
	 */
	public boolean CompletedSynchronously();
	
	/**
	 * Gets an indication whether the asynchronous operation has completed.
	 * 
	 * @return
	 * true if the operation is complete; otherwise, false.
	 */
	public boolean IsCompleted();
}
