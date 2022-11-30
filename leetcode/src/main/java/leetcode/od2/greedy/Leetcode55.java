package leetcode.od2.greedy;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class Leetcode55 {
    public static void main(String[] args) {
        Leetcode55 yb = new Leetcode55();
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(yb.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int right=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i<=right){
                right = Math.max(right,i+nums[i]);
            }
            if(right>=nums.length-1){
                return true;
            }

        }
        return false;
    }
}
