package com.yb.project.algorithm.one.backtracking.subset;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 90. 子集 II
 * @author fxb20
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbSubsetsWithDup {
	
	public static void main(String[] args) {
		YbSubsetsWithDup yb=new YbSubsetsWithDup();
		int[] nums=new int[] {4,4,4,1,4};
		yb.subsetsWithDup(nums);
	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	Deque<Integer> deque=new LinkedList<Integer>();
    	Arrays.sort(nums);
    	dfs(nums,0,res,deque);
    	return res;
    }
    
    public void dfs(int[] nums,int idx,List<List<Integer>> res,Deque<Integer> deque) {
    	res.add(new LinkedList<Integer>(deque));
    	for(int i=idx;i<nums.length;i++) {
    		if(i>idx && nums[i]==nums[i-1]) {
    			continue;
    		}
    		deque.addLast(nums[i]);
    		dfs(nums,i+1,res,deque);
    		deque.removeLast();
    	}
    }
}
