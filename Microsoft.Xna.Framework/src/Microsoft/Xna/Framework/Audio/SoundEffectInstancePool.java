package Microsoft.Xna.Framework.Audio;

import java.util.*;

/**
 * 
 * 
 * @author The MonoGame Team
 * @author Halofreak1990
 */
final class SoundEffectInstancePool
{
	private static final int MAX_PLAYING_INSTANCES = Integer.MAX_VALUE;
	
	private static final List<SoundEffectInstance> _playingInstances; 
	private static final List<SoundEffectInstance> _pooledInstances; 
	 
	/**
	 * Gets a value indicating whether the platform has capacity for more sounds to be played at this time.
	 * 
	 * @return
	 * true if more sounds can be played; otherwise, false.
	 */
	static boolean SoundsAvailable()
	{
		return _playingInstances.size() < MAX_PLAYING_INSTANCES;
	}
	
	static 
	{ 
		// Reduce garbage generation by allocating enough capacity for 
		// the maximum playing instances or at least some reasonable value. 
		int maxInstances = MAX_PLAYING_INSTANCES < 1024 ? MAX_PLAYING_INSTANCES : 1024; 
		_playingInstances = new ArrayList<SoundEffectInstance>(maxInstances); 
		_pooledInstances = new ArrayList<SoundEffectInstance>(maxInstances); 
	}
	
	private SoundEffectInstancePool()
	{
	}
	
	/**
	 * Add the specified instance to the pool if it is a pooled instance and removes it from the 
	 * list of playing instances.
	 * 
	 * @param inst
	 * The SoundEffectInstance
	 */
	static void Add(SoundEffectInstance inst)
	{
		if (inst._isPooled)
		{
			_pooledInstances.add(inst);
			inst._effect = null;
		}
		
		_playingInstances.remove(inst);
	}
	
	static SoundEffectInstance GetInstance()
	{
		SoundEffectInstance inst = null;
		int count = _pooledInstances.size();
		
		if (count > 0)
		{
			// Grab the item at the end of the list so the remove doesn't copy all
			// the list items down one slot.
			inst = _pooledInstances.get(count - 1);
			_pooledInstances.remove(count - 1);
			
			// Reset used instance to the "default" state.
			inst._isPooled = true;
			inst.setVolume(1.0f);
			inst.setPan(0.0f);
			inst.setPitch(0.0f);
			inst.IsLooped(false);
		}
		else
		{
			inst = new SoundEffectInstance();
			inst._isPooled = true;
		}
		
		return inst;
	}
	
	/**
	 * Adds the SoundEffectInstance to the list of playing instances.
	 * 
	 * @param inst
	 * The SoundEffectInstance to add to the playing list.
	 */
	static void Remove(SoundEffectInstance inst)
	{
		_playingInstances.add(inst);
	}
	
	static void Update()
	{
		OpenALSoundController.GetInstance().Update();
		
		SoundEffectInstance inst = null;
		
		// Cleanup instances which have finished playing.
		for (int x = 0; x < _playingInstances.size();)
		{
			inst = _playingInstances.get(x);
			
			if (inst.getState() == SoundState.Stopped || inst.IsDisposed() || inst._effect == null)
			{
				 Add(inst);
				 continue;
			}
			else if (inst._effect.IsDisposed())
			{
				Add(inst);
				
				// Instances created through SoundEffect.CreateInstance need to be disposed when
				// their owner SoundEffect is disposed.
				if (!inst._isPooled)
				{
					inst.Dispose();
					continue;
				}
			}
			
			x++;
		}
	}
	
	static void UpdateMasterVolume()
	{
		for (SoundEffectInstance inst : _playingInstances)
		{
			// Re-applying the volume to itself will update 
			// the sound with the current master volume. 
			inst.setVolume(inst.getVolume());
		}
	}
}
