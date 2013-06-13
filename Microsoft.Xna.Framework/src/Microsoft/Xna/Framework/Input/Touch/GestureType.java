package Microsoft.Xna.Framework.Input.Touch;

/**
 * Contains values that represent different multitouch gestures that can be detected by TouchPanel.ReadGesture. Reference page contains links to related code samples.
 *
 * @author Halofreak1990
 */
public enum GestureType
{
	/**
	 * The user tapped the screen twice in quick succession. This always is preceded by a Tap gesture. If the time between taps is too great to be considered a DoubleTap, two Tap gestures will be generated instead.
	 */
    DoubleTap(2),
    /**
     * A drag gesture (VerticalDrag, HorizontalDrag, or FreeDrag) was completed. This signals only completion. No position or delta data is valid for this sample.
     */
    DragComplete(0x100),
    /**
     * The user performed a touch combined with a quick swipe of the screen. Flicks are position-less. The velocity of the flick can be retrieved by reading the Delta member of GestureSample.
     */
    Flick(0x80),
    /**
     * The user touched the screen, and then performed a free-form drag gesture.
     */
    FreeDrag(0x20),
    /**
     * The user touched a single point on the screen for approximately one second. This is a single event, and not continuously generated while the user is holding the touchpoint.
     */
    Hold(4),
    /**
     * The user touched the screen, and then performed a horizontal (left to right or right to left) gesture.
     */
    HorizontalDrag(8),
    /**
     * Represents no gestures.
     */
    None(0),
    /**
     * The user touched two points on the screen, and then converged or diverged them. Pinch behaves like a two-finger drag. When this gesture is enabled, it takes precedence over drag gestures while two fingers are down.
     */
    Pinch(0x40),
    /**
     * A pinch operation was completed. This signals only completion. No position or delta data is valid for this sample.
     */
    PinchComplete(0x200),
    /**
     * The user briefly touched a single point on the screen.
     */
    Tap(1),
    /**
     * The user touched the screen, and then performed a vertical (top to bottom or bottom to top) gesture.
     */
    VerticalDrag(0x10);
    
    private final int value;
    private GestureType(int value)
    {
    	this.value = value;
    }

    public int getValue()
    {
    	return this.value;
    }
}
