package Microsoft.Xna.Framework;

public interface IGameHost
{
	public GameWindow getWindow();
	
	public void EnsureHost();
	public void Initialize();
	public void Run();
	public void Exit();
}
