package com.yb.project.algorithm.one.prefixsum;

import java.util.Arrays;

/**
 * leecode209 长度最小的子数组
 * @author fxb20
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * 
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class YbMinSubArrayLen {
	public static void main(String[] args) {
		int[] nums=new int[] {2,3,1,2,4,3};
		//int result=Arrays.binarySearch(nums, 3);
		YbMinSubArrayLen yb=new YbMinSubArrayLen();
		int result=yb.minSubArrayLen1(7, nums);
		System.out.println(result);
	}

	
	/**
	 * 太抽象了，看不懂
	 * @param s
	 * @param nums
	 * @return
	 */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1]; 
        // 为了方便计算，令 size = n + 1 
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    	
    }
    
	/**
	 * 暴力算法
	 * 2,3,1,2,4,3
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen1(int s, int[] nums) {
		int result = Integer.MAX_VALUE;
		int n = nums.length;
		if (n == 0) {
			return result;
		}
		for(int i=0;i<nums.length;i++) {
			int sum=0;
			for(int j=0;i+j<nums.length;j++) {
				sum+=nums[i+j];
				if(sum>=s) {
					result=Math.min(result, j+1);
					break;
				}
			}
		}
		return result==Integer.MAX_VALUE ? 0 :result;
	}
}
