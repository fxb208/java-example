package com.yb.project.algorithm.one.backtracking;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 剑指 Offer II 007. 数组中和为 0 的三个数
 * @author fxb20
 * 
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？
 * 请找出所有和为 0 且 不重复 的三元组。
 * 
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/1fGaJU
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbThreeSum {
	
	public static void main(String[] args) {
		YbThreeSum yb=new YbThreeSum();
		int[] nums=new int[] {-1,0,1,2};
		List<List<Integer>> result=yb.threeSum(nums);
		System.out.println(result);
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result=new LinkedList<List<Integer>>();
    	Deque<Integer> path=new LinkedList<Integer>();
    	boolean[] arr=new boolean[nums.length];
    	dfs(result,path,arr,nums,0,0);
    	return result;
    }
    
    public void dfs(List<List<Integer>> result,Deque<Integer> path,boolean[] arr,int[] nums,int sum,int idx) {
    	if(path.size()==3) {
    		if(sum==0) {
    			result.add(new LinkedList<Integer>(path));
    		}
    		return;
    	}
    	if(idx==nums.length || arr[idx]) {
    		return;
    	}
    	for(int i=idx;i<nums.length;i++) {
    		path.add(nums[i]);
    		sum+=nums[i];
    		dfs(result,path,arr,nums,sum,i+1);
    		sum-=nums[i];
    		path.removeLast();
    	}
    	arr[idx]=true;
    }
   
}
