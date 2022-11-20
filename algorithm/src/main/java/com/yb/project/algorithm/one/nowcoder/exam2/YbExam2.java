package com.yb.project.algorithm.one.nowcoder.exam2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class YbExam2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while (sc.hasNext()) {
			String str =sc.nextLine();
			Set<Character> set=new HashSet<Character>();
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<str.length();i++) {
				char c=str.charAt(i);
				if(!set.contains(c)) {
					set.add(c);
					sb.append(c);
				}
			}
			System.out.println(sb.toString());	
		}
		sc.close();
	}
}
