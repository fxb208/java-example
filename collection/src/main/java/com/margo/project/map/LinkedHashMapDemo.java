package com.margo.project.map;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * LinkedHashMap
 * @author fxb20
 *
 */
public class LinkedHashMapDemo {
	
	private LinkedHashMap<Integer,String> map;
	
	private LRULinkedHashMap<String, Integer> testCache;
	
	@Before
	public void init() {
		map=new LinkedHashMap<Integer,String>(3);
		testCache=new LRULinkedHashMap<String, Integer>(3);
	}
	
	@Test
	public void put() {
		map.put(1, "东方不败");
		map.put(2, "风清扬");
		map.put(4, "方丈大师");
		map.put(3, "令狐冲");
		System.out.println(map.get(1));
	}
	
	//@Test
    public void lruMap(){
        testCache.put("A", 1);
        testCache.put("B", 2);
        testCache.put("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.put("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));	
    }
}
