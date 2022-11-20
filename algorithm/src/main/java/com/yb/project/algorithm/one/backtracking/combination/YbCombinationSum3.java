package com.yb.project.algorithm.one.backtracking.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 216. 组合总和 III
 * @author fxb20
 *
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释: 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 */
public class YbCombinationSum3 {
	
	public static void main(String[] args) {
		YbCombinationSum3 yb=new YbCombinationSum3();
		System.out.println(yb.combinationSum3(3, 7));
	}
	
    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	List<Integer> path=new ArrayList<Integer>();
    	dfs(k, n,res,path,1,0);
    	return res;
    }
    
    public void dfs(int k, int n,List<List<Integer>> res,List<Integer> path,int idx,int sum) {
    	if(path.size()==k) {
    		if(sum==n) {
    			res.add(new ArrayList<Integer>(path));
        	}
    		return;
    	}
    	for(int i=idx;i<=9;i++) {
    		path.add(i);
    		dfs(k, n,res,path,i+1,sum+i);
    		path.remove(path.size()-1);
    	}
    }
}
