package com.margo.project.map;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Test;

public class ConcurrentHashMapDemo {
	
	private ConcurrentHashMap<Integer, String> map;
	
	@Before
	public void init() {
		map=new ConcurrentHashMap<Integer, String>();
	}
	
	@Test
	public void put() {
		map.put(1, "东方不败");

	}
}
