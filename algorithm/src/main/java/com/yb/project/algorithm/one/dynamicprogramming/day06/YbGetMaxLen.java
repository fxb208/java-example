package com.yb.project.algorithm.one.dynamicprogramming.day06;

/**
 * 1567. 乘积为正数的最长子数组长度
 * @author fxb20
 *
 *给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 *一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。请你返回乘积为正数的最长子数组长度。
 *
 *示例  1：
 *输入：nums = [1,-2,-3,4]
 *输出：4
 *解释：数组本身乘积就是正数，值为 24 。
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbGetMaxLen {
	
	public static void main(String[] args) {
		int[] nums=new int[] {0,1,-2,-3,-4};
		YbGetMaxLen yb=new YbGetMaxLen();
		System.out.println(yb.getMaxLen(nums));
	}
	
	
    public int getMaxLen(int[] nums) {    
    	int result=0;
    	int[] positive =new int[nums.length];  //positive[i] i结尾乘积为正的数组长度
    	int[] negative =new int[nums.length];  //negative[i] i结尾乘积为负的数组长度
    	if(nums[0]>0) {
    		positive[0]=1;
    	}else if(nums[0]<0) {
    		negative[0]=1;
    	}
    	for(int i=1;i<nums.length;i++) {
    		if(nums[i]>0) {
    			positive[i]=positive[i-1]+1;
    			negative[i]=negative[i-1]>0 ? negative[i-1]+1:0;    //
    		}else if(nums[i]<0) {
    			positive[i]=negative[i-1]>0 ? negative[i-1]+1:0;
    			negative[i]=positive[i-1]+1;
    		}else {
    			positive[i]=0;
    			negative[i]=0;
    		}
    		result=Math.max(result, positive[i]);
    	}
    	return result;
    }
    
//    public int getMaxLen(int[] nums) {    	
//    	int max=Integer.MIN_VALUE;
//    	int length=0;
//    	int[] dp=new int[nums.length];  //dp[i]的值为下标i结尾的乘积
//    	dp[0]=nums[0];
//    	int[] len=new int[nums.length]; //len[i]的值为下标i结尾的长度
//    	if(nums[0]>0) {
//    		len[0]=1;
//    	}else{
//    		len[0]=0;
//    	}
//    	for(int i=1;i<nums.length;i++) {
//    		if(nums[i]>0) {
//    			if(dp[i-1]>0) {
//    				len[i]=len[i-1]+1;
//    				dp[i]=1;
//    			}else if(dp[i-1]==0) {
//    				len[i]=1;
//    				dp[i]=1;
//    			}else {
//    				len[i]=Math.max(1, len[i-1]);
//    				dp[i]=-1;
//    			}
//    		}else if(nums[i]<0){
//    			if(dp[i-1]>0) {
//    				len[i]=len[i-1];
//    				dp[i]=-1;
//    			}else if(dp[i-1]==0) {
//    				len[i]=0;
//    				dp[i]=-1;
//    			}else {
//    				len[i]=len[i-1]+2;
//    				dp[i]=1;
//    			}
//    		}else {
//    			len[i]=0;
//    			dp[i]=0;
//    		}
//    	}
//    	for(int i=0;i<len.length;i++) {
//    		max=Math.max(max, len[i]);
//    	}
//    	return max;
//    }
}
