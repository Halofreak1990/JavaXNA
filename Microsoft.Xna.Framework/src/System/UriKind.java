package System;

/**
 * Defines the kinds of System.Uris for the System.Uri.IsWellFormedUriString(String,System.UriKind) and several Overload:System.Uri.#ctor methods.
 * 
 * @author Halofreak1990
 *
 */
public enum UriKind
{
	/**
	 * The kind of the Uri is indeterminate.
	 */
	RelativeOrAbsolute,
	/**
	 * The Uri is an absolute Uri.
	 */
	Absolute,
	/**
	 * The Uri is a relative Uri.
	 */
	Relative
}
