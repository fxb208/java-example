package leetcode.od2.arr;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Leetcode35 {
    public static void main(String[] args) {
        Leetcode35 yb = new Leetcode35();
        int[] nums = new int[]{1,3,5,6};
        System.out.println(yb.searchInsert(nums,7));

    }

    public int searchInsert(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]>target){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return left;
    }

    // 递归
    public int searchInsert_(int[] nums, int target) {
        return searchInsert(nums,0,nums.length-1,target);
    }

    public int searchInsert(int[] nums,int begin,int end,int target){
        if(begin > end){
            return begin;
        }
        int middle = (begin+end)/2;
        if(nums[middle]==target){
            return middle;
        }else if(nums[middle]>target){
            return searchInsert(nums,begin,middle-1,target);
        }else{
            return searchInsert(nums,middle+1,end,target);
        }
    }
}
