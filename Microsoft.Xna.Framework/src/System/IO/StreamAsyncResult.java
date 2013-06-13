package System.IO;

import System.IAsyncResult;

class StreamAsyncResult implements IAsyncResult
{
	private Object m_state;
	
	StreamAsyncResult()
	{
		
	}
	
	@Override
	public Object AsyncState()
	{
		return m_state;
	}

	@Override
	public boolean CompletedSynchronously()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean IsCompleted()
	{
		// TODO Auto-generated method stub
		return false;
	}
}
