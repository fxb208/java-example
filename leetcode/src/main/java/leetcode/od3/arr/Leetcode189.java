package leetcode.od3.arr;

/**
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Leetcode189 {
    public static void main(String[] args) {
        Leetcode189 yb = new Leetcode189();
        yb.rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    public void rotate(int[] nums, int k) {
        if(k==0 || nums.length==0){
            return;
        }
        int m = k%nums.length;
        if(m==0){
            return;
        }
        int[] res = new int[nums.length];
        int idx=0;
        for(int i= nums.length-m;i< nums.length;i++){
            res[idx]=nums[i];
            idx++;
        }
        for(int i=0;i<nums.length-m;i++){
            res[idx]=nums[i];
            idx++;
        }
        System.arraycopy(res,0,nums,0,nums.length);
    }
}
