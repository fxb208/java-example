package leetcode.od2.dp;

/**
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并
 * 返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 */
public class Leetcode152 {
    public static void main(String[] args) {
        Leetcode152 yb = new Leetcode152();
        System.out.println(yb.maxProduct(new int[]{2,3,-2,-4}));
    }

    public int maxProduct(int[] nums) {
        int max = nums[0]; //
        int min = nums[0]; //
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = max;
            max = Math.max(Math.max(nums[i]*max,nums[i]*min),nums[i]);
            min = Math.min(Math.min(nums[i]*temp,nums[i]*min),nums[i]);
            res = Math.max(max,res);
        }
        return res;
    }
}
