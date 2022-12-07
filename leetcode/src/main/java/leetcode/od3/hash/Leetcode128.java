package leetcode.od3.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res= 0;
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int k = num;
                while(set.contains(k+1)){
                    k++;
                }
                res = Math.max(k-num+1,res);
            }
        }
        return res;
    }
}
