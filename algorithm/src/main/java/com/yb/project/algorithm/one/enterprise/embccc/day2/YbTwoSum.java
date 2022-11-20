package com.yb.project.algorithm.one.enterprise.embccc.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1. 两数之和
 * @author fxb20
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbTwoSum {
	
	/**
	 * hash
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] twoSum(int[] nums, int target) {
    	int[] result=new int[2];
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	for(int i=0;i<nums.length;i++) {
    		if(map.containsKey(target-nums[i])) {
    			result[0]=map.get(target-nums[i]);
    			result[1]=i;
    			break;
    		}else {
    			map.put(nums[i], i);
    		}
    	}
    	return result;
    }
	
	
	/**
	 * 暴力算法
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] twoSum0(int[] nums, int target) {
    	int[] result=new int[2];
    	for(int i=0;i<nums.length;i++) {
    		for(int j=i+1;j<nums.length;j++) {
    			if(nums[i]+nums[j]==target) {
    				result[0]=i;
    				result[1]=j;
    				return result;
    			}
    		}
    	}
    	return result;
    }
}
