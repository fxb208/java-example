package com.margo.project.map;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;




public class TreeMapDemo {
	
	TreeMap<Integer,String> map;
	
	@Before
	public void init() {
		map=new TreeMap<Integer,String>();
	}
	
	@Test
	public void putTest() {
		map.put(31,"f");
		map.put(32,"x");
		map.put(33,"b");
		map.put(34,"fxb");
		System.out.println(map);
		map.remove(31);
	}
	
	
}
