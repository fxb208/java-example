package com.yb.project.algorithm.one.enterprise.embccc.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author fxb20
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
    	for(int i=0;i< nums.length;i++){
            if(nums[i]>0){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums[nums.length-1];
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[left+1]){
                        right++;
                    }
                }else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum_backTrack(int[] nums) {
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
            path.add(nums[i]);
            backTrack(res,path,target-nums[i],nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
