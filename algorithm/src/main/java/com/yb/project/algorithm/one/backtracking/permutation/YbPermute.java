package com.yb.project.algorithm.one.backtracking.permutation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 46 全排列
 * @author fxb20
 * 
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class YbPermute {
	public static void main(String[] args) {
		YbPermute yb=new YbPermute();
		System.out.println(yb.permute(new int[] {1,2,3}));
	}
	
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	Deque<Integer> temp=new LinkedList<Integer>();
    	boolean[] use=new boolean[nums.length];
    	dfs(nums,0,res,temp,use);
    	return res;
    }
    
    public void dfs(int[] nums,int deep,List<List<Integer>> res,Deque<Integer> temp,boolean[] use) {
    	if(deep==nums.length) {
    		res.add(new LinkedList<Integer>(temp));
    		return;
    	}
    	for(int i=0;i<nums.length;i++) {
    		if(!use[i]) {
    			temp.addLast(nums[i]);
    			use[i]=true;
    			dfs(nums,deep+1,res,temp,use);
    			temp.removeLast();
    			use[i]=false;
    		}
    	}
    }
}
