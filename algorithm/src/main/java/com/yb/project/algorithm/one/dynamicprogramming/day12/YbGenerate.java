package com.yb.project.algorithm.one.dynamicprogramming.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 118. 杨辉三角
 * @author fxb20
 *
 */
public class YbGenerate {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	List<Integer> first=new ArrayList<Integer>();
    	first.add(1);
    	res.add(first);
    	for(int i=1;i<numRows;i++) {
    		 List<Integer> pre=res.get(i-1);
    		 List<Integer> lst=new ArrayList<Integer>(first);
    		 for(int j=0;j<pre.size()-1;j++) {
    			 lst.add(pre.get(j)+pre.get(j+1));
    		 }
    		 lst.add(pre.get(pre.size()-1));
    		 res.add(lst);
    	}
    	return res;
    }
}
