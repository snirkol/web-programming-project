package com.hit.algorithm;

import static org.junit.Assert.*;
import com.hit.algorithm.IAlgoCache;
import com.hit.algorithm.NFUAlgoCacheImpl;

import org.junit.Assert;
import org.junit.Test;

import com.hit.algorithm.LRUAlgoCacheImpl;

public class IAlgoCacheTest {
	@Test
	public void testLRUGetElement() {
	   IAlgoCache<Integer, Integer> lru = new LRUAlgoCacheImpl<>(5);
	   lru.putElement(0, 5);
	   Integer val = lru.getElement(0);
	   Assert.assertEquals((Integer)5, val);
	}
	
	@Test
	public void testLRUPutElement() {
	   IAlgoCache<Integer, Integer> lru = new LRUAlgoCacheImpl<>(2);
	   Integer val1=lru.putElement(0, 1);
	   Assert.assertEquals(null, val1);
	   Integer val2=lru.putElement(1, 2);
	   Assert.assertEquals(null, val2);
	   Integer val3=lru.putElement(2, 3);
	   Assert.assertEquals((Integer)1, val3);
	   Integer val4=lru.putElement(1, 2);
	   Assert.assertEquals(null, val4);
	   Integer val5 = lru.getElement(0);
	   Assert.assertEquals(null, val5);
	   
	}
	
	@Test
	public void testLRURemoveElement(){
		IAlgoCache<Integer, Integer> lru = new LRUAlgoCacheImpl<>(5);
		lru.putElement(1, 8);
		lru.removeElement(1);
		Integer val = lru.getElement(0);
		Assert.assertEquals(null, val);
	}
	
	@Test
	public void testNFUPutElement(){
		IAlgoCache<Integer, Integer> nfu = new NFUAlgoCacheImpl<>(5);
		nfu.putElement(0,4);
		Integer actual = nfu.getElement(0);
		Assert.assertEquals((Integer)4,actual);
	}
	@Test
	public void testNFURemoveElement(){
		IAlgoCache<Integer, Integer> nfu = new NFUAlgoCacheImpl<>(5);
		nfu.putElement(0,4);
		nfu.removeElement(0);
		Integer actual = nfu.getElement(0);
		assertEquals(null, actual);
	}
	
	@Test
	public void testNFPutElementOverCapacity()
	{
		IAlgoCache<Integer,Integer> nfu = new NFUAlgoCacheImpl<>(2);
		nfu.putElement(0, 4);
		Integer actual = nfu.getElement(0);
		assertEquals((Integer)4, actual);
		nfu.putElement(1, 5);
		
		nfu.putElement(2, 6);
		actual = nfu.getElement(0);
		assertEquals((Integer)4, actual);
		actual = nfu.getElement(1);
		assertEquals(null, actual);
		actual = nfu.getElement(2);
		assertEquals((Integer)6, actual);
	}

}