package leetcode.fabu.day1;

/**
 * 421. 数组中两个数的最大异或值
 * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class YbFindMaximumXOR {

    public int findMaximumXOR(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                max = Math.max(nums[i]^nums[j],max);
            }
        }
        return max;
    }


    public int findMaximumXOR_(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                max = Math.max(nums[i]^nums[j],max);
            }
        }
        return max;
    }
}
