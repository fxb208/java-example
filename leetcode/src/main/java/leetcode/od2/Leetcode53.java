package leetcode.od2;

import java.util.Map;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  子数组 是数组中的一个连续部分。
 */
public class Leetcode53 {
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
