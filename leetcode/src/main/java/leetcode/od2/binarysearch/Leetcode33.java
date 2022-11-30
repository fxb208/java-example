package leetcode.od2.binarysearch;

/**
 * 33. 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Leetcode33 {
    public static void main(String[] args) {
        Leetcode33 yb = new Leetcode33();
        System.out.println(yb.search(new int[]{3,1},1));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int middle = left+(right-left)/2;
            if(target==nums[middle]){
                return middle;
            }
            // left sort;
            if(nums[left]<=nums[middle]){
                if(target>=nums[left] && target<nums[middle]){
                    right = middle-1;
                }else{
                    left = middle+1;
                }
            }else{
                // right sort;
                if(target>nums[middle] && target<=nums[right]){
                    left =middle+1;
                }else {
                    right = middle -1;
                }

            }
        }
        return -1;
    }

    public int search_(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
