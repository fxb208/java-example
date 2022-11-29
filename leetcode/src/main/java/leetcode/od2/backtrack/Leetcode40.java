package leetcode.od2.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */
public class Leetcode40 {

    public static void main(String[] args) {
        Leetcode40 yb = new Leetcode40();
        yb.combinationSum2(new int[]{1,2,2,2,5},5);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(res,path,candidates,target,0);
        return res;
    }

    public void backTrack(List<List<Integer>> res,List<Integer> path,int[] candidates,int target,int idx){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            backTrack(res,path,candidates,target-candidates[i],i+1);
            path.remove(path.size()-1);
        }
    }

    /*****************************************************************************************/

    public List<List<Integer>> combinationSum2_used(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(res,path,candidates,target,0,new boolean[candidates.length]);
        return res;
    }

    public void backTrack(List<List<Integer>> res,List<Integer> path,int[] candidates,int target,int idx,boolean[] used){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
        }
        for(int i=idx;i<candidates.length;i++){
            if(used[i] || (i>idx && candidates[i]==candidates[i-1])){
                continue;
            }
            used[i]=true;
            path.add(candidates[i]);
            backTrack(res,path,candidates,target-candidates[i],i+1,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }

    /*****************************************************************************************/

    public List<List<Integer>> combinationSum2_error(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(res,path,candidates,target,0,new boolean[candidates.length]);
        return res;
    }

    public void backTrack_error(List<List<Integer>> res,List<Integer> path,int[] candidates,int target,int idx,boolean[] used){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
        }
        for(int i=idx;i<candidates.length;i++){
            if(!used[i]){
                used[i]=true;
                path.add(candidates[i]);
                backTrack(res,path,candidates,target-candidates[i],idx+1,used);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }
}
