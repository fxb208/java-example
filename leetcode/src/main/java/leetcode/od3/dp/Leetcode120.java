package leetcode.od3.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class Leetcode120 {
    public static void main(String[] args) {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        Leetcode120 yb = new Leetcode120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));
        System.out.println(yb.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[triangle.size()][len];
        int res = Integer.MAX_VALUE;
        dp[0][0]=triangle.get(0).get(0);
        if(len==1){
            return dp[0][0];
        }
        for(int i=1;i<triangle.size();i++){
            List<Integer> rows = triangle.get(i);
            for(int j=0;j<rows.size();j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+ rows.get(j);
                }else if(j==rows.size()-1){
                    dp[i][j]=dp[i-1][j-1]+ rows.get(j);
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+ rows.get(j);
                }
                if(rows.size()==len){
                    res = Math.min(res,dp[i][j]);
                }
            }
        }
        return res;
    }
}
