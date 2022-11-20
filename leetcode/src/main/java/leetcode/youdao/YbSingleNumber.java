package leetcode.youdao;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 */
public class YbSingleNumber {
    public static void main(String[] args) {
        System.out.println(19^19);
    }

    /**
     * sort
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }

    /**
     * sort
     * @param nums
     * @return
     */
    public int singleNumber_sort(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        while(index+1<nums.length && nums[index]==nums[index+1]){
            index+=2;
        }
        return nums[index];
    }
}
