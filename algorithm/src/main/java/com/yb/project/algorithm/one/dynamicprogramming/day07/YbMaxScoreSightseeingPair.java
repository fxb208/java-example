package com.yb.project.algorithm.one.dynamicprogramming.day07;

/**
 * leecode 1014. 最佳观光组合
 * @author fxb20
 *
 * 给你一个正整数数组 values，其中 values[i]表示第 i 个观光景点的评分，并且两个景点i 和j之间的 距离 为j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 * 
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbMaxScoreSightseeingPair {
	public static void main(String[] args) {
		int[] values = new int[] {8,1,5,2,6};
		YbMaxScoreSightseeingPair yb=new YbMaxScoreSightseeingPair();
		System.out.println(yb.maxScoreSightseeingPair(values));
	}
	
    public int maxScoreSightseeingPair(int[] values) {
    	int[] dp=new int[values.length];  // values[i]+i 的最大值
    	dp[0]=values[0];
    	int result=values[0]+values[1]-1;
    	for(int i=1;i<values.length;i++) {
    		dp[i]=Math.max(dp[i-1], values[i]+i);
    		result=Math.max(dp[i-1]+values[i]-i, result);
    	}
    	return result;
    }
}
