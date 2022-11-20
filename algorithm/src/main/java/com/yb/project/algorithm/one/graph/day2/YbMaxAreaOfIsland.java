package com.yb.project.algorithm.one.graph.day2;

/**
 * leecode 695. 岛屿的最大面积
 * @author fxb20
 * 
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbMaxAreaOfIsland {
	public static void main(String[] args) {
		int[][] image= {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0}//,
//				{0,1,1,0,1,0,0,0,0,0,0,0,0},
//				{0,1,0,0,1,1,0,0,1,0,1,0,0},
//				{0,1,0,0,1,1,0,0,1,1,1,0,0},
//				{0,0,0,0,0,0,0,0,0,0,1,0,0},
//				{0,0,0,0,0,0,0,1,1,1,0,0,0},
//				{0,0,0,0,0,0,0,1,1,0,0,0,0}
				};
//		int[][] image={
//			{1,0,1},
//			{1,1,1},
//			{0,0,1}
//		};
		
		YbMaxAreaOfIsland yb=new YbMaxAreaOfIsland();
		yb.maxAreaOfIsland(image);
		//System.out.println(yb.maxAreaOfIsland(image));
	}
	
	volatile int max=0;
    public int maxAreaOfIsland(int[][] grid) {
    	int temp=0;
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    			if(grid[i][j]==1) {
    				dfs(grid,i,j);
    				System.out.println(max);
    				temp=Math.max(max,temp);
    				max=0;
    			}
    		}
    	}
    	return temp;
    }
    
    public void dfs(int[][] grid,int i,int j) {
    	if(grid[i][j]==1) {
    		max=max+1;
    		grid[i][j]=0;
    		if(i+1<grid.length) {
    			dfs(grid,i+1,j);
    		}
    		if(i>0) {
    			dfs(grid,i-1,j);
    		}
    		if(j+1<grid[0].length) {
    			dfs(grid,i,j+1);
    		}
    		if(j>0) {
    			dfs(grid,i,j-1);
    		}
    	}
    }
}
