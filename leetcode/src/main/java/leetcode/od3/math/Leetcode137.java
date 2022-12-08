package leetcode.od3.math;

/**
 * 137. 只出现一次的数字 II
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
 */
public class Leetcode137 {
    public static void main(String[] args) {
        Leetcode137 yb = new Leetcode137();
        System.out.println(yb.singleNumber(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<32;i++){
            int count = 0;
            for(int num:nums){
                count += (num>>i & 1);
            }
            count = count%3;
            if(count >0){
                res |=(count<<i);
            }
        }
        return res;
    }
}
