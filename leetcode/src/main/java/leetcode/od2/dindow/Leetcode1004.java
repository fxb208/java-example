package leetcode.od2.dindow;

/**
 * 1004. 最大连续1的个数 III
 *
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class Leetcode1004 {
    public static void main(String[] args) {
        Leetcode1004 yb = new Leetcode1004();
        //System.out.println(yb.longestOnes(new int[]{0,0,1,1,1,0,0},0));
        System.out.println(yb.longestOnes(new int[]{0},1));
    }

    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int right = 0;
        while(right<nums.length){
            if(nums[right]==0){
                k--;
            }
            right++;
            while(left<right && k<0){
                if(nums[left]==0){
                    k++;
                }
                left++;
            }
            if(k>=0){
                res = Math.max(res,right-left);
            }
        }
        return res;
    }
}
