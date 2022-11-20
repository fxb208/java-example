package com.yb.project.algorithm.one.dynamicprogramming.day05;

/**
 * leecode 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class MargoMaxSubArray {
	
	public static void main(String[] args) {
		MargoMaxSubArray margoMaxSubArray=new MargoMaxSubArray();
		//int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int[] nums=new int[]{5,4,-1,7,8};
		int maxNum=margoMaxSubArray.maxSubArray(nums);
		System.out.println(maxNum);
	}
	
	public int maxSubArray(int[] nums) {
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		int maxNum=nums[0];
		for(int i=1;i<nums.length;i++) {
			dp[i]=max(dp[i-1]+nums[i],nums[i]);
			if(dp[i]>maxNum) {
				maxNum=dp[i];
			}
		}
		return maxNum;
	}
	
	public int max(int a,int b){
        if(a>b){
            return a;
        }else {
            return b;
        }
    }
}
