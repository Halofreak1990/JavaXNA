package System;

/**
 * Provides an object representation of a uniform resource identifier (URI) and easy access to the parts of the URI.
 * 
 * @author Halofreak1990
 */
public class Uri
{
	private String uriString;

	/**
	 * Gets a value that indicates whether the System.Uri instance is absolute.
	 * 
	 * @return
	 * A boolean value that is true if the System.Uri instance is absolute; otherwise, false.
	 */
	public boolean IsAbsoluteUri()
	{
		throw new NotImplementedException();
	}

	/**
	 * Gets the original URI string that was passed to the System.Uri constructor.
	 * 
	 * @return
	 * A String containing the exact URI specified when this instance was constructed; otherwise, String.Empty.
	 * 
	 * @exception System.InvalidOperationException
	 * This instance represents a relative URI, and this property is valid only for absolute URIs.
	 */
	public String getOriginalString()
	{
		if (!this.IsAbsoluteUri())
		{
			throw new InvalidOperationException("");
		}
		
		return uriString;
	}
	
	public Uri(String uriString)
	{
		this.uriString = uriString;
	}

	public Uri(String uriString, boolean dontEscape)
	{
		this.uriString = uriString;
	}
	
	public Uri(String uriString, UriKind uriKind)
	{
		
	}
	
	public Uri(Uri baseUri, String relativeUri)
	{
		
	}
	
	public Uri(Uri baseUri, String relativeUri, boolean dontEscape)
	{
		
	}
	
	public Uri(Uri baseUri, Uri relativeUri)
	{
		
	}
}
