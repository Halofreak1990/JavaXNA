
public class Program
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Game1 game = null;

		try
		{
			game = new Game1();

			game.Run();
		}
		finally
		{
			if (game != null)
			{
				game.Dispose();
			}
		}
	}
}
