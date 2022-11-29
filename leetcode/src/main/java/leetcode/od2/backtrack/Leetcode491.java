package leetcode.od2.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class Leetcode491 {
    public static void main(String[] args) {
        Leetcode491 yb = new Leetcode491();
        // System.out.println(yb.findSubsequences(new int[]{4,4,3,3,2,1}));
        System.out.println(yb.findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        backTrack(res,path,nums,0);
        return res;
    }

    public void backTrack(List<List<Integer>> res,Deque<Integer> path,int[] nums,int idx){
        if(idx==nums.length){
            if(path.size()>1){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if(path.size()>1){
            res.add(new ArrayList<>(path));
        }
        boolean[] used = new boolean[201];
        for(int i=idx;i< nums.length;i++){
            if(used[nums[i]+100]){
                continue;
            }
            if(path.size()==0 || (path.size() >0 && nums[i]>= path.peekLast())){
                used[nums[i]+100] = true;
                path.add(nums[i]);
                backTrack(res,path,nums,i+1);
                path.pollLast();
            }
        }
    }
}
