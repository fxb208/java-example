package com.yb.project.algorithm.one.dynamicprogramming.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 119. 杨辉三角
 * @author fxb20
 *
 */
public class YbGetRow {
	
	public static void main(String[] args) {
		YbGetRow yb=new YbGetRow();
		yb.getRow(3);
	}
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
		for (int i = 0; i < rowIndex; i++) {
			List<Integer> pre = new ArrayList<Integer>();
			pre.add(1);
			for (int j = 0; j < res.size()-1; j++) {
				pre.add(res.get(j) + res.get(j + 1));
			}
			pre.add(1);
			res=pre;
		}
		return res;
	}
	
    public List<Integer> getRow0(int rowIndex) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	List<Integer> first=new ArrayList<Integer>();
    	first.add(1);
    	res.add(first);
    	for(int i=1;i<=rowIndex;i++) {
    		 List<Integer> pre=res.get(i-1);
    		 List<Integer> lst=new ArrayList<Integer>(first);
    		 for(int j=0;j<pre.size()-1;j++) {
    			 lst.add(pre.get(j)+pre.get(j+1));
    		 }
    		 lst.add(pre.get(pre.size()-1));
    		 res.add(lst);
    	}
    	return res.get(rowIndex);
    }
}
