package Microsoft.Xna.Framework;

class DrawOrderComparer implements java.util.Comparator<IDrawable>
{
	public static final DrawOrderComparer Default = new DrawOrderComparer();
	
	public int compare(IDrawable x, IDrawable y)
	{
		if (x == null && y == null)
			return 0;
		
		if (x != null)
		{
			if (y == null)
				return -1;
			
			if (x.equals(y))
				return 0;
			
			if (x.getDrawOrder() < y.getDrawOrder())
				return -1;
		}
		return 1;
	}
}
