package System;

/**
 * Controls how URI information is escaped.
 * 
 * @author Halofreak1990
 */
public enum UriFormat
{
	/**
	 * Escaping is performed according to the rules in RFC 2396.
	 */
	UriEscaped,
	/**
	 * No escaping is performed.
	 */
	Unescaped,
	/**
	 * Characters that have a reserved meaning in the requested URI components remain escaped. All others are not escaped. See Remarks.
	 */
	SafeUnescaped
}
