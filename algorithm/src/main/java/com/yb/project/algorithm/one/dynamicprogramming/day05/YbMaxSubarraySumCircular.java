package com.yb.project.algorithm.one.dynamicprogramming.day05;

/**
 * leecode 918. 环形子数组的最大和
 * @author fxb20
 * 
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， 
 * nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
 * 形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，
 * 不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * 
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-circular-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbMaxSubarraySumCircular {
	public static void main(String[] args) {
		YbMaxSubarraySumCircular yb=new YbMaxSubarraySumCircular();
		int[] nums=new int[] {-3,-2,-3};
		System.out.println(yb.maxSubarraySumCircular(nums));
	}
	
	/**
	 * 参考https://blog.nowcoder.net/n/cb82d31fc8bb4d149c4b4bc880baa5e1
	 * @param nums
	 * @return
	 */
	public int maxSubarraySumCircular(int[] nums) {
		if(nums.length==1) {
			return nums[0];
		}
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		int sum=nums[0];
		int max=nums[0];
		for(int i=1;i<nums.length;i++) {
			sum=sum+nums[i];
			dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
			if(dp[i]>max) {
				max=dp[i];
			}
		}
		int min=nums[1];
		dp[1]=nums[1];
		for(int i=2;i<nums.length;i++) {
			dp[i] = Math.min(dp[i-1] + nums[i], nums[i]);
			if(dp[i]<min) {
				min=dp[i];
			}
		}
		return Math.max(max, sum-min);
	}
}
