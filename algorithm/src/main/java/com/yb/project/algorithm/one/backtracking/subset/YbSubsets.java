package com.yb.project.algorithm.one.backtracking.subset;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 78. 子集
 * @author fxb20
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 */
public class YbSubsets {
	public static void main(String[] args) {
		YbSubsets yb=new YbSubsets();
		int[] nums=new int[] {1,2,3};
		yb.subsets(nums);
	}
	
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	Deque<Integer> deque=new LinkedList<Integer>();
    	dfs(nums,0,res,deque);
    	return res;
    }
    
    public void dfs(int[] nums,int idx,List<List<Integer>> res,Deque<Integer> deque) {
    	res.add(new LinkedList<Integer>(deque));
    	for(int i=idx;i<nums.length;i++) {
    		deque.addLast(nums[i]);
    		dfs(nums,i+1,res,deque);
    		deque.removeLast();
    	}
    }
}
