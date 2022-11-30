package com.yb.project.algorithm.one.dynamicprogramming.day03;


public class YbRob {

	/**
	 * leecode 198. 打家劫舍
	 * @author fxb20
	 *
	 *	你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
	 *	如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	 *	给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
	 *
	 *	输入：[2,7,9,3,1]
	 *	输出：12
	 *	解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
	 *    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
	 */
	public int rob(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++) {
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		return dp[nums.length-1];	
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,3};
		YbRob yb=new YbRob();
		int result=yb.rob2(nums);
		System.out.println(result);
	}
	
	/**
	 * leecode 213. 打家劫舍 II
	 * @author fxb20
	 *
	 *	你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
	 *	同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
	 *	给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
	 *
	 *	输入：nums = [2,3,2]
	 *	输出：3
	 *
	 *	输入：nums = [1,2,3,1]
	 *	输出：4
	 *	解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
	 * 	偷窃到的最高金额 = 1 + 3 = 4 。	
	 */
	public int rob2(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		if(nums.length==2) {
			return Math.max(nums[0],nums[1]);
		}
		//1,偷窃第一间房间（不可以偷窃最后一件房间）
		int[] f=new int[nums.length];
		int[] g=new int[nums.length];
		for(int i=0;i<nums.length-1;i++) {
			if(i==0 || i==1) {
				f[i]=nums[i];
			}else if(i==2) {
				f[i]=f[i-2]+nums[i];
			}else {
				f[i]=Math.max(f[i-2], f[i-3])+nums[i];
			}
		}
		int fmax=Math.max(f[nums.length-2], f[nums.length-3]);
		
		g[0]=0;
		//2，不偷窃第一间房间（可以偷窃最后一间房间）
		for(int i=1;i<nums.length;i++) {
			if(i==1) {
				g[i]=nums[i];
			}else if(i==2) {
				g[i]=g[i-2]+nums[i];
			}else {
				g[i]=Math.max(g[i-2], g[i-3])+nums[i];
			}
		}
		int gmax=Math.max(g[nums.length-1], f[nums.length-2]);
		return Math.max(fmax, gmax);	
	}
}
