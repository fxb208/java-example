package com.yb.project.algorithm.two.enterprise.fabu.day1;

import java.util.Arrays;

/**
 * 322. 零钱兑换 https://leetcode.cn/problems/coin-change/
 */
public class YbCoinChange {
    public static void main(String[] args) {
        YbCoinChange yb = new YbCoinChange();
        int[] coins = new int[]{474, 83, 404, 3};
        System.out.println(yb.coinChange(coins, 264));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < coins.length && coins[i] <= amount; i++) {
            dp[coins[i]] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            int min = dp[i] > -1 ? dp[i] : Integer.MAX_VALUE;
            for (int k = 0; k < coins.length && coins[k] < i; k++) {
                if (dp[i - coins[k]] > -1) {
                    min = Math.min(dp[i - coins[k]] + 1, min);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }
}
