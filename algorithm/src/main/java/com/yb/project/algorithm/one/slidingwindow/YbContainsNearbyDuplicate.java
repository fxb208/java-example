package com.yb.project.algorithm.one.slidingwindow;

import java.util.TreeSet;

/**
 * leecode 219. 存在重复元素 II
 * @author fxb20
 * 
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 *
 */
public class YbContainsNearbyDuplicate {
	
	/**
	 * [1,2,3,1,2,3]
	 *  2
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums=new int[]{1,2,3,1,2,3};
		YbContainsNearbyDuplicate yb=new YbContainsNearbyDuplicate();
		boolean result=yb.containsNearbyDuplicate(nums, 2);
		System.out.println(result);
	}
	
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	
    	TreeSet<Integer> set=new TreeSet<Integer>();
    	for(int i=0;i<nums.length;i++) {
    		if(set.contains(nums[i])) {	
    			return true;
    		}
    		set.add(nums[i]);
    		if(i>=k) {
    			set.remove(nums[i-k]);
    		}
    	}
    	return false;
    }
}
