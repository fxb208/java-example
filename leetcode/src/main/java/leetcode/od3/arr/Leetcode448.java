package leetcode.od3.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class Leetcode448 {
    public static void main(String[] args) {
        Leetcode448 yb = new Leetcode448();
        System.out.println(yb.findDisappearedNumbers_copy(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            while(nums[i] !=nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=0;i< nums.length;i++){
            if(nums[i] != i+1){
                res.add(i+1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers_copy(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] arr = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            arr[nums[i]-1]=nums[i];
        }
        for(int i=0;i< arr.length;i++){
            if(arr[i] != i+1){
                res.add(i+1);
            }
        }
        return res;
    }
}
