package com.hit.algorithm;

import org.junit.Assert;
import org.junit.Test;

import com.hit.algorithm.IAlgoCache;
import com.hit.algorithm.LRUAlgoCacheImpl;

public class IAlgoCacheTest {

	@Test
	public void testInsertValue() {
	   IAlgoCache<Integer, Integer> lru = new LRUAlgoCacheImpl<>(5);
	   lru.putElement(0, 5);
	   Integer val = lru.getElement(0);
	   Assert.assertEquals((Integer)5, val);
	}
	
	@Test
	public void testRemoveElement(){
		IAlgoCache<Integer, Integer> lru = new LRUAlgoCacheImpl<>(5);
		lru.putElement(1, 8);
		lru.removeElement(1);
		Integer val = lru.getElement(0);
		Assert.assertEquals(null, val);
	}
}