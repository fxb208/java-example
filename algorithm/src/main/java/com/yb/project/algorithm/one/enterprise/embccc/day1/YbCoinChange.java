package com.yb.project.algorithm.one.enterprise.embccc.day1;

/**
 * leecode 322. 零钱兑换
 * @author fxb20
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 *
 */
public class YbCoinChange {
	public static void main(String[] args) {
		YbCoinChange yb=new YbCoinChange();
		int[] coins=new int[] {2};
		System.out.println(yb.coinChange(coins, 3));
	}
	
    public int coinChange(int[] coins, int amount) {
    	int[] dp=new int[amount+1]; //dp[i] 存储最少的硬币个数
    	dp[0]=0;
    	for(int i=1;i<=amount;i++) {
    		dp[i]=-1;
    	}
    	for(int i=1;i<=amount;i++) {
    		for(int j=0;j<coins.length;j++) {
    			if(i-coins[j]>0 && dp[i-coins[j]]>0) {
        			if(dp[i]>0) {
    					dp[i]=Math.min(dp[i-coins[j]]+1, dp[i]);	
    				}else {
    					dp[i]=dp[i-coins[j]]+1;
    				}
    				//dp[i]=Math.min(dp[i-coins[j]]+1, dp[i]>0?dp[i]:Integer.MAX_VALUE);
    			}else if(i==coins[j]){
    				dp[i]=1;
    			}
    		}
    	}
    	return dp[amount];
    }
}
