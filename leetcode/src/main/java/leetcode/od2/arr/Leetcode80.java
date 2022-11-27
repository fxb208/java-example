package leetcode.od2.arr;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 */
public class Leetcode80 {
    public static void main(String[] args) {
        Leetcode80 yb = new Leetcode80();
        int[] nums = new int[]{1,1,2,3,3,3,4};
        System.out.println(yb.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int times = 1;
        int idx = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[idx]){
                times=1;
            }else{
                times+=1;
            }
            if(times<=2){
                idx++;
                nums[idx]=nums[i];
            }
        }
        return idx+1;
    }
}
