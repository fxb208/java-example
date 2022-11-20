package com.yb.project.algorithm.one.dynamicprogramming;

/**
 * leecode 64 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 1 3 1
 * 1 5 1
 * 4 2 1
 * 
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 最小路劲和
 * @author fxb20
 *
 */
public class YbMinPathSum {
	
	public static void main(String[] args) {
		YbMinPathSum yb=new YbMinPathSum();
		int[][] grid=new int[3][3];
		grid[0][0]=1;
		grid[0][1]=3;
		grid[0][2]=1;
		
		grid[1][0]=1;
		grid[1][1]=5;
		grid[1][2]=1;
		
		grid[2][0]=4;
		grid[2][1]=2;
		grid[2][2]=1;
		int minPathSum=yb.minPathSum(grid);
		System.out.println("minPathSum:"+minPathSum);
	}

	
	
	/**
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int r=grid.length;   //行数
		int c=grid[0].length; //列数
		int[][] dp=new int[r][c];
		dp[0][0]=grid[0][0];
		for(int i=1;i<c;i++) {
			dp[0][i]=dp[0][i-1]+grid[0][i];  //第一行
		}
		for(int i=1;i<r;i++) {
			dp[i][0]=dp[i-1][0]+grid[i][0];  //第一列
		}
		for(int i=1;i<r;i++) {
			for(int j=1;j<c;j++) {
				dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j];   //
			}
		}
		return dp[r-1][c-1];
	}
	
	public int min(int a,int b){
        if(a>b){
            return b;
        }else {
            return a;
        }
    }
	

}
