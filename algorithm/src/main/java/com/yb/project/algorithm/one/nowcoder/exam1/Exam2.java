package com.yb.project.algorithm.one.nowcoder.exam1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串分割，每个字符之和为水仙花数   结果集不唯一返回-1，
 * @author fxb208
 *                                        字符串
 *         153                  370                371                 407
 *  153，370，371，407    153，370，371，407    153，370，371，407    153，370，371，407
 */
public class Exam2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()) {
			String str=sc.nextLine();
			List<Integer> nums=narcissisticNumber();
			List<List<Integer>> lst=new LinkedList<List<Integer>>();
			Deque<Integer> path=new LinkedList<Integer>();
			dfs(nums,lst,path,str);
			if(lst.size()>0) {
				System.out.println(0);
			}else if(lst.size()>1){
				System.out.println(-1);
			}else {
				System.out.println(lst.get(0).size());
			}
		}
		sc.close();
	}
	
	public static void dfs(List<Integer> nums,List<List<Integer>> lst,Deque<Integer> path,String str) {
		if(path.peekLast()==str.length()-1) {
			lst.add(new LinkedList<Integer>(path));
			return;
		}
		int number=0;
		for(int i=0;i<nums.size();i++) {
			for(int j=path.peekLast()+1;j<str.length();j++) {
				number+=str.charAt(i);
				if(number==nums.get(i)) {
					path.addLast(j);
					dfs(nums,lst,path,str);
					path.removeLast();
				}else if(number>nums.get(nums.size()-1)) {
					break;
				}
			}	
		}
	}
	
	public static List<Integer> narcissisticNumber() {
		ArrayList<Integer> lst=new ArrayList<Integer>();
		for(int i=100;i<1000;i++) {
			int j=i/100;
			int k=(i/10)%10;
			int l=i%10;
			if(j*j*j+k*k*k+l*l*l==i) {
				lst.add(i);
			}
		}
		return lst;
	}
}
