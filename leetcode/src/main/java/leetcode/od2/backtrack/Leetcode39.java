package leetcode.od2.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class Leetcode39 {
    public static void main(String[] args) {
        Leetcode39 yb = new Leetcode39();
        yb.combinationSum(new int[]{2,3,6,7},7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(res,path,candidates,target,0);
        return res;
    }

    public void backTrack(List<List<Integer>> res,List<Integer> path,int[] candidates,int target,int idx){
        if(target<0){
           return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            path.add(candidates[i]);
            backTrack(res,path,candidates,target-candidates[i],idx);
            path.remove(path.size()-1);
        }
    }
}
