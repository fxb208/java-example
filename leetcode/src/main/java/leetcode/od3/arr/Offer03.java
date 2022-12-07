package leetcode.od3.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Offer03 {
    public static void main(String[] args) {
        Offer03 yb = new Offer03();
        yb.findRepeatNumber(new int[]{3,2,1,2});
    }

    public int findRepeatNumber_map(int[] nums) {
        Set<Integer> set =new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                return nums[i];
            }
        }
        return 0;
    }

    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i] !=nums[nums[i]]){
                int temp = nums[nums[i]];
                nums[nums[i]]=nums[i];
                nums[i]=temp;
            }
            if(nums[i]==nums[nums[i]] && nums[i]!=i){
                return nums[i];
            }
        }
        return -1;
    }


    /**
     * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solutions/96623/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
     * @param nums
     * @return
     */
    public int findRepeatNumber_(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public int findRepeatNumber_arr(int[] nums) {
       for(int i=0;i<nums.length;i++){
           if(nums[i]==i){
               continue;
           }
           if(nums[i]==nums[nums[i]]){
               return nums[i];
           }
           int temp = nums[nums[i]];
           nums[nums[i]]=nums[i];
       }
       return 0;
    }
}
