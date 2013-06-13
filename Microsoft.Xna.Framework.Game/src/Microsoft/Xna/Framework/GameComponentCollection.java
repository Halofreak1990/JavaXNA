package Microsoft.Xna.Framework;

import System.*;
import System.Collections.ObjectModel.*;

/**
 * A collection of game components.
 * 
 * @author Halofreak1990
 */
public final class GameComponentCollection extends Collection<IGameComponent>
{
	/**
	 * Raised when a component is added to the GameComponentCollection.
	 */
	public final Event<GameComponentCollectionEventArgs> ComponentAdded = new Event<GameComponentCollectionEventArgs>();
	
	/**
	 * Raised when a component is removed from the GameComponentCollection.
	 */
	public final Event<GameComponentCollectionEventArgs> ComponentRemoved = new Event<GameComponentCollectionEventArgs>();
	
	/**
	 * Initializes a new instance of this class.
	 */
	public GameComponentCollection()
	{
		
	}
	
	/**
	 * Removes all children from the collection.
	 */
	@Override
	protected void ClearItems()
    {
        for (int i = 0; i < super.Count(); i++)
        {
            this.OnComponentRemoved(new GameComponentCollectionEventArgs(super.get(i)));
        }
        super.ClearItems();
    }
	
	/**
	 * Inserts a child object into the collection at the specified location.
	 * 
	 * @param index
	 * The position in the collection.
	 * 
	 * @param item
	 * The child object being inserted.
	 */
	@Override
	protected void InsertItem(int index, IGameComponent item)
    {
        if (super.IndexOf(item) != -1)
            throw new ArgumentException("Cannot add the same game component to a game component collection multiple times.");

        super.InsertItem(index, item);
        
        if (item != null)
            this.OnComponentAdded(new GameComponentCollectionEventArgs(item));
    }
	
	/**
	 * Removes a child object in the collection.
	 * 
	 * @param index
	 * The index of the item being removed.
	 */
	@Override
	protected void RemoveItem(int index)
    {
        IGameComponent gameComponent = super.get(index);
        
        super.RemoveItem(index);
        
        if (gameComponent != null)
            this.OnComponentRemoved(new GameComponentCollectionEventArgs(gameComponent));
    }

	/**
	 * Modifies the specified child object in the collection.
	 * 
	 * @param index
	 * The position in the collection.
	 * 
	 * @param item
	 * The child object being modified.
	 */
	@Override
    protected void SetItem(int index, IGameComponent item)
    {
        throw new NotSupportedException("Cannot set a value using operator[] on GameComponentCollection. Use Add/Remove instead.");
    }
	
	private void OnComponentAdded(GameComponentCollectionEventArgs e)
	{
		if (ComponentAdded.hasHandlers())
			ComponentAdded.raise(this, e);
	}
	
	private void OnComponentRemoved(GameComponentCollectionEventArgs e)
	{
		if (ComponentRemoved.hasHandlers())
			ComponentRemoved.raise(this, e);
	}
}
