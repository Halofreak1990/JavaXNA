package Microsoft.Xna.Framework.Graphics;

import java.util.*;

import System.Collections.ObjectModel.ReadOnlyCollection;

/**
 * Represents a collection of effects associated with a model.
 * 
 * @author Halofreak1990
 */
public final class ModelEffectCollection extends ReadOnlyCollection<Effect>
{
	private ArrayList<Effect> wrappedList;
	
	ModelEffectCollection()
	{
		super(new ArrayList<Effect>());
		
		this.wrappedList = (ArrayList<Effect>)super.getItems();
	}
	
	void Add(Effect effect)
	{
		super.getItems().add(effect);
	}
	
	public Enumerator interator()
	{
		return new Enumerator(wrappedList);
	}
	
	void Remove(Effect effect)
	{
		super.getItems().remove(effect);
	}
	
	public final class Enumerator implements Iterator<Effect>
	{
		private Iterator<Effect> wrappedListIterator;
		
		Enumerator(ArrayList<Effect> wrappedList)
		{
			wrappedListIterator = wrappedList.iterator();
		}
		
		@Override
		public boolean hasNext()
		{
			return wrappedListIterator.hasNext();
		}

		@Override
		public Effect next()
		{
			return wrappedListIterator.next();
		}

		@Override
		public void remove()
		{
			// Overridden to do nothing. C# doesn't allow modifications while enumerating, so we don't either.
			// We could throw an InvalidOperationException, but instead, we silently fail.
		}
	}
}
