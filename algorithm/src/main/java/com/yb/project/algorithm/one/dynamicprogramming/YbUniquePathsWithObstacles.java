package com.yb.project.algorithm.one.dynamicprogramming;

/**
 * leecode 63. 不同路径 II
 * @author fxb20
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 */
public class YbUniquePathsWithObstacles {
	public static void main(String[] args) {
		YbUniquePathsWithObstacles yb=new YbUniquePathsWithObstacles();
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		int result=yb.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(result);
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m=obstacleGrid.length;
		int n=obstacleGrid[0].length;
		int[][] dp=new int[m][n];
		if(obstacleGrid[0][0]==1) {
			dp[0][0]=0;
		}else {
			dp[0][0]=1;
		}
		
		for(int i=1;i<m;i++) {
			if(dp[i-1][0]==0 || obstacleGrid[i][0]==1) {
				dp[i][0]=0;
			}else {
				dp[i][0]=1;
			}
			
		}
		for(int i=1;i<n;i++) {
			if(dp[0][i-1]==0 || obstacleGrid[0][i]==1) {
				dp[0][i]=0;
			}else {
				dp[0][i]=1;
			}
			
		}
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(obstacleGrid[i][j]==1) {
					dp[i][j]=0;
				}else {
					dp[i][j]=dp[i][j-1]+dp[i-1][j];
				}
				
			}
		}
		return dp[m-1][n-1];
	}
}
