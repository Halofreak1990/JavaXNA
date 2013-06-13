package Microsoft.Xna.Framework.Net;

import System.*;

/**
 * Describes the quality of the network connection between this machine and the host of a multiplayer session that was discovered with a matchmaking query.
 *
 * @author Halofreak1990
 */
public final class QualityOfService
{
	private TimeSpan averageRoundtripTime;
    private int bytesPerSecondDownstream;
    private int bytesPerSecondUpstream;
    private boolean isAvailable;
    private TimeSpan minimumRoundtripTime;

    /**
     * Gets the average (median) round trip time of all the network packets that were sent during the quality of service measurement process.
     */
    public TimeSpan getAverageRoundTripTime()
    {
    	return this.averageRoundtripTime;
    }
    
    /**
     * Gets an estimate of the available downstream network bandwidth from the session host to this machine, measured in bytes per second.
     */
    public int getBytesPerSecondDownstream()
    {
    	return this.bytesPerSecondDownstream;
    }
    
    /**
     * Gets an estimate of the available upstream network bandwidth from this machine to the session host, measured in bytes per second.
     */
    public int getBytesPerSecondUpstream()
    {
    	return this.bytesPerSecondUpstream;
    }
    
    /**
     * Checks whether this quality of service operation has completed.
     */
    public boolean IsAvailable()
    {
    	return this.isAvailable;
    }
    
    /**
     * Gets the minimum round trip time of any network packet that was sent during the quality of service measurement process.
     */
    public TimeSpan getMinimumRoundTripTime()
    {
    	return this.minimumRoundtripTime;
    }
    
	QualityOfService()
	{
	}
	
	QualityOfService(int bytesPerSecondUpstream, int bytesPerSecondDownstream, TimeSpan averageRoundtripTime, TimeSpan minimumRoundtripTime)
	{
		this.bytesPerSecondUpstream = bytesPerSecondUpstream;
        this.bytesPerSecondDownstream = bytesPerSecondDownstream;
        this.averageRoundtripTime = averageRoundtripTime;
        this.minimumRoundtripTime = minimumRoundtripTime;
        this.isAvailable = true;
	}
}
