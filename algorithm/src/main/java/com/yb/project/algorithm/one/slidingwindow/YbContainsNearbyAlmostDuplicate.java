package com.yb.project.algorithm.one.slidingwindow;

import java.util.TreeSet;

/**
 * leecode 220. 存在重复元素 III
 * @author fxb20
 * 
 * 给你一个整数数组 nums 和两个整数 k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false
 *
 */
public class YbContainsNearbyAlmostDuplicate {
	
	/**
	 * floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
	 * ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		// 滑动窗口结合查找表，此时滑动窗口即为查找表本身（控制查找表的大小即可控制窗口大小）
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			// 边添加边查找
			// 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
			Long ceiling = set.ceiling((long) nums[i] - (long) t);
			if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
				return true;
			}
			// 添加后，控制查找表（窗口）大小，移除窗口最左边元素
			set.add((long) nums[i]);
			if (set.size() == k + 1) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;
	}
	
	/**
	 * https://blog.csdn.net/weixin_43314519/article/details/106952373
	 */
	public boolean ss(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; ++i) {
			// Find the successor of current element
			Integer s = set.ceiling(nums[i]);
			if (s != null && s <= nums[i] + t)
				return true;

			// Find the predecessor of current element
			Integer g = set.floor(nums[i]);
			if (g != null && nums[i] <= g + t)
				return true;

			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}
