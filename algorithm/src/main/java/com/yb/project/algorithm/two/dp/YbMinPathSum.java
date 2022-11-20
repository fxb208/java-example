package com.yb.project.algorithm.two.dp;

/** leetcode 64. 最小路径和 https://leetcode.cn/problems/minimum-path-sum/ */
public class YbMinPathSum {

  public static void main(String[] args) {
    YbMinPathSum yb = new YbMinPathSum();
    int[][] grid = new int[3][3];
    grid[0][0] = 1;
    grid[0][1] = 3;
    grid[0][2] = 1;

    grid[1][0] = 1;
    grid[1][1] = 5;
    grid[1][2] = 1;

    grid[2][0] = 4;
    grid[2][1] = 2;
    grid[2][2] = 1;
    int minPathSum = yb.minPathSum(grid);
    System.out.println(minPathSum);
  }

  public int minPathSum(int[][] grid) {
    int result = 0;
    int[][] dp = new int[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < grid.length; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }
    for (int i = 1; i < grid[0].length; i++) {
      dp[0][i] = grid[0][i] + dp[0][i - 1];
    }
    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }
}
