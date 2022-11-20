package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 合并表记录
 * @author fxb20
 *
 */
public class YbHJ08 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int length=sc.nextInt();
		TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
		for(int i=0;i<length;i++) {
			int index=sc.nextInt();
			int value=sc.nextInt();
			if(map.containsKey(index)){
				map.put(index, map.get(index)+value);
			}else {
				map.put(index, value);
			}
		}
		for(Integer key: map.keySet()) {
			System.out.println(key+" "+map.get(key));
		}
		sc.close();
	}
}
