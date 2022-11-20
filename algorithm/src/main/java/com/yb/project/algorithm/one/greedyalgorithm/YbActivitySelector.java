package com.yb.project.algorithm.one.greedyalgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 活动选择问题
 * @author fxb20
 *
 */
public class YbActivitySelector {
	
	public static void main(String[] args) {
		int[] s=new int[] {0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
		int[] f=new int[] {0, 4, 5, 6, 7, 9, 9, 10,11,12,14,16};
		
		YbActivitySelector activitySelector=new YbActivitySelector();
		
		List<Integer> result=new LinkedList<Integer>();
		activitySelector.recursiveActivitySelector(s, f, 0, 11, result);
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
		
		List<Integer> result2=activitySelector.greedyActivitySelector(s, f);
		for(int i=0;i<result2.size();i++) {
			System.out.println(result2.get(i));
		}
	}
	
	/**
	 * 递归调用
	 * @param s
	 * @param f
	 * @param k
	 * @param n
	 * @param result
	 */
	public void recursiveActivitySelector(int[] s,int[] f,int k,int n,List<Integer> result) {
		int m=k+1;
		while(m<=n && s[m]<f[k]) {
			m=m+1;
		}
		if(m<=n) {
			result.add(m);
			recursiveActivitySelector(s,f,m,n,result);
		}
	}
	
	public List<Integer> greedyActivitySelector(int[] s,int[] f){
		List<Integer> result=new LinkedList<Integer>();
		result.add(1);
		int k=1;
		for(int i=1;i<f.length;i++) {
			if(s[i]>f[k]) {
				k=i;
				result.add(i);
			}
		}
		return result;
	}

}
