package com.margo.project.map;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class HashMapDemo {
	
	private HashMap<Integer, String> map;
	
	private HashMap<Integer, String> initialCapacityMap;
	
	static final int MAXIMUM_CAPACITY = 1 << 30;

	@Before
	public void init() {
		map=new HashMap<Integer, String>();
		initialCapacityMap=new HashMap<Integer, String>(3);
	}
	
	//@Test
	public void put() {
		map.put(1, "东方不败");
		map.put(2, "东方不败");
		map.put(3, "东方不败");
		map.put(4, "东方不败");
		map.put(5, "东方不败");
		map.put(6, "东方不败");
		map.put(7, "东方不败");
		map.put(8, "东方不败");
		map.put(9, "东方不败");
		map.put(10, "东方不败");
		map.put(11, "东方不败");
		map.put(12, "东方不败");
		map.put(13, "东方不败");  //扩容

	}
	
	@Test
	public void initialCapacity() {
		initialCapacityMap.put(1, "东方不败");
		initialCapacityMap.put(2, "东方不败");
		initialCapacityMap.put(3, "东方不败");
		initialCapacityMap.put(4, "东方不败");
		initialCapacityMap.put(5, "东方不败");
		initialCapacityMap.put(6, "东方不败");
		initialCapacityMap.put(7, "东方不败");
		initialCapacityMap.put(8, "东方不败");
		initialCapacityMap.put(9, "东方不败");
		initialCapacityMap.put(10, "东方不败");
		initialCapacityMap.put(11, "东方不败");
		initialCapacityMap.put(12, "东方不败");
		initialCapacityMap.put(13, "东方不败");  //扩容
		System.out.println("hello world!!!");
	}
	
	/**
	 * hash扩容
	 */
	//@Test
    public void tableSizeFor() {
		int cap=3;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int result= (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(result);
    }
    
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
