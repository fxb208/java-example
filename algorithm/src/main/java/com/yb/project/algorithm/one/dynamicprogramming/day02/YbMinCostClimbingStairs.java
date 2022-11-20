package com.yb.project.algorithm.one.dynamicprogramming.day02;

/**
 * leecode 746. 使用最小花费爬楼梯
 * @author fxb20
 * 
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 
 * 示例 1：
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbMinCostClimbingStairs {
	
	public static void main(String[] args) {
		int[] cost=new int[] {1,100,1,1,1,100,1,1,100,1};
		//int[] cost=new int[] {0,1,1,1};
		YbMinCostClimbingStairs yb=new YbMinCostClimbingStairs();
		int result=yb.minCostClimbingStairs(cost);
		System.out.println(result);
	}
	
    public int minCostClimbingStairs(int[] cost) {
    	
       	int[] dp=new int[cost.length+1];
    	dp[1]=0;
    	dp[2]=Math.min(cost[0],cost[1]);
    	for(int i=3;i<=cost.length;i++) {
    		dp[i]=Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
    	}
    	return dp[cost.length];
    	
    }
}
