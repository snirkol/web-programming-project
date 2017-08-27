package com.hit.algorithm;

import static org.junit.Assert.*;
import com.hit.algorithm.IAlgoCache;
import com.hit.algorithm.NFUAlgoCacheImpl;

import org.junit.Assert;

import org.junit.Test;

public class IAlgoCacheTest {

@	Test
	public void test()
	{
		//fail("Not yet implemented");
		NFUTest();
	}

public void NFUTest()
{
	//check putElement
	IAlgoCache<Integer, Integer> nfu = new NFUAlgoCacheImpl<>(5);
	nfu.putElement(0,4);
	Integer actual = nfu.getElement(0);
	Assert.assertEquals((Integer)4,actual);
	
	nfu.putElement(0,4);
	actual = nfu.getElement(0);
	Assert.assertEquals((Integer)4,actual);
	
	//check removeElement
	nfu.removeElement(0);
	actual = nfu.getElement(0);
	assertEquals(null, actual);
}

}