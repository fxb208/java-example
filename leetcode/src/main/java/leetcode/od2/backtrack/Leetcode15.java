package leetcode.od2.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res,path,0,nums,0);
        return res;
    }

    public void backTrack(List<List<Integer>> res,List<Integer> path,int target,int[] nums,int idx){
        if(path.size()==3){
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
