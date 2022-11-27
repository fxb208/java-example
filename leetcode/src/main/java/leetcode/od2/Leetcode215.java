package leetcode.od2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Leetcode215 {

    public  static void main(String[] args) {
        // [3,2,1,5,6,4], k = 2
        Leetcode215 yb = new Leetcode215();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k=2;
        yb.findKthLargest(nums,2);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            queue.offer(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];
//    }
}
