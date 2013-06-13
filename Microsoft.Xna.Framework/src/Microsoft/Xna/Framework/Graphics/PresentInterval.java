package Microsoft.Xna.Framework.Graphics;

/**
 * Defines flags that describe the relationship between the adapter refresh rate and the rate at which Present operations are completed.
 * 
 * @author Halofreak1990
 */
public enum PresentInterval
{
	/**
	 * Equivalent to setting One.
	 */
	Default,
	/**
	 * The driver waits for the vertical retrace period (the runtime will beam trace to prevent tearing). Present operations are not affected more frequently than the screen
	 * refresh rate; the runtime completes one Present operation per adapter refresh period, at most. This option is always available for both windowed and full-screen swap
	 * chains.
	 */
	One,
	/**
	 * The driver waits for the vertical retrace period. Present operations are not affected more frequently than every second screen refresh.
	 */
	Two,
	/**
	 * The runtime updates the window client area immediately, and might do so more than once during the adapter refresh period. Present operations might be affected
	 * immediately. This option is always available for both windowed and full-screen swap chains.
	 */
	Immediate
}
