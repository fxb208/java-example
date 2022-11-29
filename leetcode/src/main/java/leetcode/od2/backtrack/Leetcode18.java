package leetcode.od2.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 */
public class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res,path,target,nums,0);
        return res;
    }

    public void backTrack(List<List<Integer>> res,List<Integer> path,long target,int[] nums,int idx){
        if(path.size()==4){
            if(target==0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            if(target<0 && nums[i]>0){
                continue;
            }
            path.add(nums[i]);
            backTrack(res,path,target-nums[i],nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
