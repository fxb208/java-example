package leetcode.od2.dp;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  子数组 是数组中的一个连续部分。
 */
public class Leetcode53 {

    public static void main(String[] args) {
        Leetcode53 yb = new Leetcode53();
        System.out.println(yb.maxSubArray_dp(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * Kanade算法
     * @param nums
     * @return
     */
    public int maxSubArray_dp(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int res = nums[0];
        for(int i=1;i< nums.length;i++){
            dp[i]=nums[i]+Math.max(dp[i-1],0);
            res =Math.max(dp[i],res);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int sum = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum>0 && sum+nums[i]>0){
                sum+=nums[i];
            }else{
                sum = nums[i];
            }
            res = Math.max(sum,res);
        }
        return res;
    }
}
