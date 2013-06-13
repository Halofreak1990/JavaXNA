package Microsoft.Xna.Framework.GamerServices;

/**
 * Thrown if an attempt is made to display a component of the Guide user interface when a Guide component is already displayed.
 *
 * @author Halofreak1990
 */
public class GuideAlreadyVisibleException extends RuntimeException
{
	private static final long serialVersionUID = 4849634968285956865L;
	
	/**
	 * Initializes an empty instance of GuideAlreadyVisibleException.
	 */
	public GuideAlreadyVisibleException()
    {
    }

	/**
	 * Initializes an instance of GuideAlreadyVisibleException with the specified error message.
	 * 
	 * @param message
	 * A message describing the error.
	 */
    public GuideAlreadyVisibleException(String message)
    {
    	super(message);
    }
    
    /**
     * Initializes an instance of GuideAlreadyVisibleException with the specified error message and related inner exception.
     * 
     * @param message
     * A message describing the error.
     * 
     * @param innerException
     * The inner exception related to this exception.
     */
    public GuideAlreadyVisibleException(String message, RuntimeException innerException)
    {
    	super(message, innerException);
    }
}
