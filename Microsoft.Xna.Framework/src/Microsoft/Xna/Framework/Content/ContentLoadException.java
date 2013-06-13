package Microsoft.Xna.Framework.Content;

/**
 * Exception used to report errors from the ContentManager.Load method.
 * 
 * @author Halofreak1990
 */
public class ContentLoadException extends RuntimeException
{
	private static final long serialVersionUID = -3558703860616151888L;
	
	/**
	 * Creates a new instance of ContentLoadException.
	 */
	public ContentLoadException()
    {
    }

	/**
	 * Creates a new instance of ContentLoadException.
	 * 
	 * @param message
	 * A message that describes the error.
	 */
    public ContentLoadException(String message)
    {
    	super(message);
    }
    
    /**
     * Creates a new instance of ContentLoadException.
     * 
     * @param message
     * A message that describes the error.
     * 
     * @param innerException
     * The exception that is the cause of the current exception. If the innerException parameter is not a null reference, the current exception is raised in a catch block that
	 * handles the inner exception.
     */
    public ContentLoadException(String message, Exception innerException)
    {
    	super(message, innerException);
    }
}
