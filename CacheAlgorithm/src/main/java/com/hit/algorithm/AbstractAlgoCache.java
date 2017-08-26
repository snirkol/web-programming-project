package com.hit.algorithm;

public abstract class AbstractAlgoCache<K,V> implements IAlgoCache<K, V>{
	private int capacity;
	
	public AbstractAlgoCache(int capacity){
		this.setCapacity(capacity);
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public abstract V getElement(K key);
	
	public abstract V putElement(K key, V value);
	
	public abstract void removeElement(K key);
		
}
