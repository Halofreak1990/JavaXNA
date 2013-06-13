package Microsoft.Xna.Framework.Net;

/**
 * Defines the different states of a multiplayer session.
 *
 * @author Halofreak1990
 */
public enum NetworkSessionState
{
	/**
	 * The local machine joins the session, waiting in the pregame lobby. The GameStarted event is raised when gameplay begins.
	 */
    Lobby,
    /**
     * The local machine joins the session, currently in the middle of gameplay. The GameEnded event is raised when the session returns to the lobby.
     */
    Playing,
    /**
     * The local machine has left the current session or the session has ended. The SessionEnded event is raised at this time. The event's arguments describe the reason for the session ending.
     */
    Ended
}
