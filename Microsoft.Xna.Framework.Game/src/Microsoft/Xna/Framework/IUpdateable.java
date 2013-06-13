package Microsoft.Xna.Framework;

import System.*;

public interface IUpdateable
{
	boolean getEnabled();
	int getUpdateOrder();
	
	void Update(GameTime gameTime);
	
	Event<EventArgs> EnabledChanged = new Event<EventArgs>();
	Event<EventArgs> UpdateOrderChanged = new Event<EventArgs>();
}
