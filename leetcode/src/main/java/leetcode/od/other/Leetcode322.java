package leetcode.od.other;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class Leetcode322 {

    public static void main(String[] args) {
        Leetcode322 yb = new Leetcode322();
        int[] coins = new int[]{1, 2, 5}; int amount = 11;
        yb.coinChange(coins,11);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                dp[coins[i]]=1;
            }

        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>0 && dp[i-coins[j]]>0){
                    if(dp[i]>0){
                        dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                    }else{
                        dp[i]=dp[i-coins[j]]+1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
