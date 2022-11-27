package leetcode.od2.dindow;

import java.util.TreeMap;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 *
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
 * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 */
public class Leetcode1438 {
    public static void main(String[] args) {
        System.out.println(Math.abs(-12));
        Leetcode1438 yb = new Leetcode1438();
        //int[] nums = new int[]{10,1,2,4,7,2};
        int[] nums = new int[]{4,2,2,2,4,4,2,2};
        System.out.println(yb.longestSubarray(nums,0));
    }

    public int longestSubarray(int[] nums, int limit) {

        TreeMap<Integer,Integer> map = new TreeMap<>();
        int left =0;
        int right = 0;
        map.put(nums[left],map.getOrDefault(nums[left],0)+1);
        int res = 1;
        while(right<nums.length-1){
            right++;
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.lastKey()-map.firstKey()>limit){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
