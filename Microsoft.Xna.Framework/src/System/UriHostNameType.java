package System;

/**
 * Defines host name types for the System.Uri.CheckHostName(System.String) method.
 * 
 * @author Halofreak1990
 */
public enum UriHostNameType
{
	/**
	 * The type of the host name is not supplied.
	 */
	Unknown,
	/**
	 * The host is set, but the type cannot be determined.
	 */
	Basic,
	/**
	 * The host name is a domain name system (DNS) style host name.
	 */
	Dns,
	/**
	 * The host name is an Internet Protocol (IP) version 4 host address.
	 */
	IPv4,
	/**
	 * The host name is an Internet Protocol (IP) version 6 host address.
	 */
	IPv6
}
