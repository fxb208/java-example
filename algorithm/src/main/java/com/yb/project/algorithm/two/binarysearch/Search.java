package com.yb.project.algorithm.two.binarysearch;

/**
 * leecode 704 https://leetcode.cn/problems/binary-search/
 *
 * <p>给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9 输出: 4 解释: 9 出现在 nums 中并且下标为 4
 */
public class Search {

  public static void main(String[] args) {
    System.out.println(0 / 1);
    Search yb = new Search();
    //
    int[] nums = new int[] {-1, 0, 3, 5, 9, 12};
    System.out.println(yb.search(nums, 9));

    nums = new int[] {-1, 0, 3, 5, 9, 12};
    System.out.println(yb.search(nums, 13));
  }

  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  public int search(int[] nums, int target, int begin, int end) {
    if (begin > end) {
      return -1;
    }
    int result = (begin + end) / 2;
    if (nums[result] == target) {
      return result;
    } else if (nums[result] > target) {
      return search(nums, target, begin, result - 1);
    } else {
      return search(nums, target, result + 1, end);
    }
  }
}
