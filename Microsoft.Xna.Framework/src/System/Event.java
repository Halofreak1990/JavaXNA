package System;

import java.util.*;

/**
 * Base class for all events in JavaXNA.
 *
 * @author Halofreak1990
 * @param <T>
 * The EventArgs instance or subclass to use with this event.
 */
public class Event<T extends EventArgs>
{
	private List<EventHandler<T>> handlers;

	/**
	 * Use this to determine whether you can actually raise the event,
	 * since if the list is empty, you'll get an InvalidOperationException.
	 */
	public synchronized boolean hasHandlers()
	{
		return !handlers.isEmpty();
	}

	/**
	 * Creates a new instance of this Object.
	 */
	public Event()
	{
		handlers = new ArrayList<EventHandler<T>>();
	}

	/**
	 * Adds a handler for this event
	 * 
	 * @param handler
	 * The handler to add to this event.
	 */
	public synchronized void addHandler(EventHandler<T> handler)
	{
		this.handlers.add(handler);
	}

	/**
	 * Removes the specified handler for this event
	 * 
	 * @param handler
	 * 
	 * @throws InvalidOperationException
	 * Thrown when no event handlers have previously been assigned.
	 */
	public synchronized void removeHandler(EventHandler<T> handler)
	{
		if (this.handlers.isEmpty())
		{
			throw new InvalidOperationException("Cannot remove event handler because none have been assigned.");
		}

		this.handlers.remove(handler);
	}

	/**
	 * Raises the event.
	 * 
	 * @param sender
	 * The Object that raised the event.
	 * 
	 * @param e
	 * An instance of {@link System.EventArgs} that provides information about the event.
	 * 
	 * @throws InvalidOperationException
	 * Thrown when the event is raised with no event handlers assigned.
	 */
	public synchronized void raise(Object sender, T e)
	{
		if (this.handlers.isEmpty())
		{
			throw new InvalidOperationException("Trying to raise an event without Event Handlers.");
		}

		for (EventHandler<T> handler : handlers)
		{
			handler.Invoke(sender, e);
		}
	}
}
