package com.yb.project.algorithm.one.dynamicprogramming.day02;

/**
 * leecode 70. 爬楼梯
 * @author fxb20
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbClimbStairs {
	public static void main(String[] args) {
		YbClimbStairs yb=new YbClimbStairs();
		int result=yb.climbStairs(4);
		System.out.println(result);
	}
	
    public int climbStairs(int n) {
    	if(n<3) {
    		return n;
    	}
    	int[] dp=new int[n+1];
    	dp[1]=1;
    	dp[2]=2;
    	for(int i=3;i<=n;i++) {
    		dp[i]=dp[i-1]+dp[i-2];
    	}
    	return dp[n];
    }
}
