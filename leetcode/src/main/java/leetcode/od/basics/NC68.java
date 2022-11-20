package leetcode.od.basics;

/**
 * JZ69 跳台阶
 */
public class NC68 {
    public int jumpFloor(int target) {
        if(target==1){
            return 1;
        }
        int[] dp = new int[target+1];
        dp[1]=1;
        dp[2]=2;
        int idx=3;
        while(idx>2 && idx <=target){
            dp[idx]=dp[idx-1]+dp[idx-2];
            idx++;
        }
        return dp[target];
    }
}
