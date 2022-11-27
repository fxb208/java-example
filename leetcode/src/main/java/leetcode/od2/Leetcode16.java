package leetcode.od2;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 *  假定每组输入只存在恰好一个解。
 */
public class Leetcode16 {
    public static void main(String[] args) {
        Leetcode16 yb = new Leetcode16();
        //
        int[] nums = new int[]{0,0,0};
        //int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(yb.threeSumClosest(nums,target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int subtract = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<subtract){
                    subtract = Math.abs(sum-target);
                    res = sum;               }

                if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
