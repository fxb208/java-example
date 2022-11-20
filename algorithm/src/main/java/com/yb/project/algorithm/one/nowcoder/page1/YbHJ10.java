package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ZIFU
 * @author fxb20
 *
 */
public class YbHJ10 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++) {
			char key=str.charAt(i);
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}else {
				map.put(key, 1);
			}
		}
		System.out.println(map.size());
		sc.close();
	}
}
