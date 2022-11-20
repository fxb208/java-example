package com.yb.project.algorithm.one.dynamicprogramming;


/**
 * leecode 300. 最长递增子序列
 * @author fxb20
 *	给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *	子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 *	例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *示例 1：
 *输入：nums = [10,9,2,5,3,7,101,18]
 *输出：4
 *解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 *示例 2：
 *输入：nums = [0,1,0,3,2,3]
 *输出：4
 *
 *示例 3：
 *输入：nums = [7,7,7,7,7,7,7]
 *输出：1
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbLengthOfLIS {
	public static void main(String[] args) {
		//int[] nums=new int[] {0,1,0,3,2,3};
		int[] nums=new int[] {1,3,6,7,9,4,10,5,6};
		int result=YbLengthOfLIS.lengthOfLIS(nums);
		System.out.println(result);
	}
	
	public static int lengthOfLIS(int[] nums) {
		int[] dp=new int[nums.length];
		dp[0]=1;
		for(int i=1;i<nums.length;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(nums[j]<nums[i]) {
					dp[i]=Math.max(dp[j]+1, dp[i]);	
				}
			}
		}
		int max=1;
		for(int i=1;i<dp.length;i++) {
			if(dp[i]>max) {
				max=dp[i];
			}
		}
		return max;
    }
}
