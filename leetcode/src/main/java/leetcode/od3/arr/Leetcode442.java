package leetcode.od3.arr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 442. 数组中重复的数据
 *
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 */
public class Leetcode442 {
    public static void main(String[] args) {
        Leetcode442 yb = new Leetcode442();
        System.out.println(yb.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int i=0;i< nums.length;i++){
            while(nums[i] !=nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            if(nums[i] == nums[nums[i]-1] && nums[i] != i+1){
                res.add(nums[i]);
            }
        }
        return new ArrayList<>(res);
    }
}
