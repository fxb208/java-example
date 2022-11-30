package com.yb.project.algorithm.one.dynamicprogramming.day04;

/**
 * leecode 55. 跳跃游戏
 * @author fxb20
 * 
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 
 * 
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。
 * 但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 */
public class YbCanJump {
	
	
	public static void main(String[] args) {
		YbCanJump yb=new YbCanJump();
		//int[] nums=new int[] {3,2,1,0,4};
		int[] nums=new int[] {2,3,1,1,4};
		boolean result=yb.canJump(nums);
		System.out.println(result);
	}
	
    public boolean canJump(int[] nums) {
    	boolean[] dp=new boolean[nums.length];
    	dp[0]=true;
    	for(int i=1;i<nums.length;i++) {
    		for(int j=1;i-j>=0;j++) {
    			if(dp[i-j] && nums[i-j]>=j) {
    				dp[i]=true;
    				break;
    			}
    		}
    	}
    	return dp[nums.length-1];
    }

}
