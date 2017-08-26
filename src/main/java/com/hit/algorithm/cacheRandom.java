package com.hit.algorithm;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cacheRandom<K,V> extends AbstractAlgoCache<K, V>{
	private HashMap<K, V> map;
	
	public cacheRandom(int capacity) {
		super(capacity);
		this.map=new HashMap<K,V>();
	}

	@Override
	public V getElement(K key) {
		if(map.containsKey(key)){
			return map.get(key);
		}
		return null;

	}

	@Override
	public V putElement(K key, V value) {
        if(map.containsKey(key)){
        	V oldValue=map.get(key);
            map.put(key, value);
            return oldValue;
        }else{
        	if(map.size()>=getCapacity()){
        		Random random=new Random();
        		List<K> keys = new ArrayList<K>(map.keySet());
        		K randomKey = keys.get(random.nextInt(keys.size()));
        		removeElement(randomKey);
        		map.put(key, value);
        	}else{
        		map.put(key, value);
        	}
        }
        
        return null;
	}

	@Override
	public void removeElement(K key) {
		map.remove(key);
	}
	
}
