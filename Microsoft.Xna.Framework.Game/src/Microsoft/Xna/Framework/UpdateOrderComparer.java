package Microsoft.Xna.Framework;

class UpdateOrderComparer implements java.util.Comparator<IUpdateable>
{
	public static final UpdateOrderComparer Default = new UpdateOrderComparer();
	
	public int compare(IUpdateable x, IUpdateable y)
	{
		if (x == null && y == null)
			return 0;
		
		if (x != null)
		{
			if (y == null)
				return -1;
			
			if (x.equals(y))
				return 0;
			
			if (x.getUpdateOrder() < y.getUpdateOrder())
				return -1;
		}
		return 1;
	}
}

