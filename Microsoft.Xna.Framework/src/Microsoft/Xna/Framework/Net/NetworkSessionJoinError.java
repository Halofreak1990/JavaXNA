package Microsoft.Xna.Framework.Net;

/**
 * Contains additional data about a NetworkSessionJoinException.
 *
 * @author Halofreak1990
 */
public enum NetworkSessionJoinError
{
	/**
	 * The session could not be found. Occurs if the session has ended after the matchmaking query but before the client joined, of if there is no network connectivity between the client and session host machines.
	 */
	SessionNotFound,
	/**
	 * The session exists but is not joinable. Occurs if the session is in progress but does not allow gamers to join a session in progress.
	 */
    SessionNotJoinable,
    /**
     * The session exists but does not have any open slots for local signed-in gamers.
     */
    SessionFull
}
