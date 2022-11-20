package com.yb.project.algorithm.one.dynamicprogramming.day06;

/**
 * 152. 乘积最大子数组
 * @author fxb20
 *
 *给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *测试用例的答案是一个 32-位 整数。
 *子数组 是数组的连续子序列。
 *
 *输入: nums = [2,3,-2,4]
 *输出: 6
 *解释: 子数组 [2,3] 有最大乘积 6。	
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/maximum-product-subarray
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbMaxProduct {
	public static void main(String[] args) {
		YbMaxProduct yb=new YbMaxProduct();
		int[] nums=new int[]{-1,-2,-9,-6};
		System.out.println(yb.maxProduct2(nums));
	}
	
    public int maxProduct(int[] nums) {
//    	int[] dp=new int[nums.length];
//    	dp[0]=nums[0];
//    	int max=nums[0];
//    	for(int i=1;i<nums.length;i++) {
//    		dp[i]=Math.max(dp[i-1]*nums[i], nums[i]);
//    		if(dp[i]>max) {
//    			max=dp[i];
//    		}
//    	}
//    	return max;
    	
    	int[] max=new int[nums.length];
    	int[] min=new int[nums.length];
    	int result=nums[0];
    	max[0]=nums[0];
    	min[0]=nums[0];
    	for(int i=1;i<nums.length;i++) {
    		max[i]=Math.max(Math.max(max[i-1]*nums[i],min[i-1]*nums[i]), nums[i]);
    		min[i]=Math.min(Math.min(max[i-1]*nums[i],min[i-1]*nums[i]), nums[i]);
    		result=Math.max(max[i], result);
    	}
    	return result;
    }
    
    /**
     * 优化版本  滚动数组
     * @param nums
     * @return
     */
	public int maxProduct2(int[] nums) {
    	int result=nums[0];
    	int max=nums[0];
    	int min=nums[0];
    	for(int i=1;i<nums.length;i++) {
    		int mx = Math.max(Math.max(max*nums[i],min*nums[i]), nums[i]);
    		int mn = Math.min(Math.min(max*nums[i],min*nums[i]), nums[i]);
    		max=mx;
    		min=mn;
    		result=Math.max(max, result);
    	}
    	return result;
	}

	/**
	 * 内存溢出
	 * 
	 * @param nums
	 * @return
	 */
	public int maxProduct3(int[] nums) {
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i][i] = nums[i];
			max = Math.max(max, dp[i][i]);
		}
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; i + j < nums.length; j++) {
				dp[j][i + j] = dp[j][i + j - 1] * nums[i + j];
				max = Math.max(max, dp[j][i + j]);
			}
		}
		return max;
	}
}
