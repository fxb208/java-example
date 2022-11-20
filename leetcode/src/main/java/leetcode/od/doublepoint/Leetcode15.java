package leetcode.od.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class Leetcode15 {
    public static void main(String[] args) {
        System.out.println(Math.abs(-26));
        Leetcode15 yb = new Leetcode15();
        //int[] nums = new int[]{-1,0,1,2,-1,-4};
        //int[] nums = new int[]{1,-1,-1,0};
        //int[] nums = new int[]{3,0,-2,-1,1,2};
        int[] nums = new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        List<List<Integer>> lst = yb.threeSum(nums);
        System.out.println(lst);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right= nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[left]);
                    lst.add(nums[right]);
                    res.add(lst);
                    left++;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    right--;
                    while(right>left && nums[right]==nums[right+1]){
                        right--;
                    }
                }else if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }

            }

        }
        return res;
    }

    /**
     * [-2,0,1,1,2] error
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum0(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left=0;
        int right= nums.length-1;
        int point = 0;
        boolean valid = true;
        int temp=0;
        while(left<right){
            if(nums[left]+nums[right]>0){
                point=left;
                point ++;
                while(point<right){
                    if(nums[left]+nums[point]+nums[right]==0){
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[left]);
                        lst.add(nums[right]);
                        lst.add(nums[point]);
                        res.add(lst);
                        break;
                    }
                    point++;
                }
                right--;
                while(right>left && nums[right]==nums[right+1]){
                    right--;
                }
            }else{
                point=right;
                point --;
                while (point>left){
                    if(nums[left]+nums[point]+nums[right]==0){
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[left]);
                        lst.add(nums[right]);
                        lst.add(nums[point]);
                        res.add(lst);
                        break;
                    }
                    point--;
                }
                left++;
                while(left <right && nums[left]==nums[left-1]){
                    left++;
                }
            }
        }
        return res;
    }
}
