package com.yb.project.algorithm.one.graph.day2;

/**
 * leecode 1254. 统计封闭岛屿的数目
 * @author fxb20
 * 二维矩阵 grid由 0（土地）和 1（水）组成。
 * 岛是由最大的4个方向连通的 0组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * 请返回 封闭岛屿 的数目。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-closed-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbClosedIsland {
	public static void main(String[] args) {
		YbClosedIsland yb=new YbClosedIsland();
		int[][] grid=new int[][] {
			{0,0,1,1,0,1,0,0,1,0},
			{1,1,0,1,1,0,1,1,1,0},
			{1,0,1,1,1,0,0,1,1,0},
			{0,1,1,0,0,0,0,1,0,1},
			{0,0,0,0,0,0,1,1,1,0},
			{0,1,0,1,0,1,0,1,1,1},
			{1,0,1,0,1,1,0,0,0,1},
			{1,1,1,1,1,1,0,0,0,0},
			{1,1,1,0,0,1,0,1,0,1},
			{1,1,1,0,1,1,0,1,1,0}
		};
		System.out.println(yb.closedIsland(grid));
	}
	
	private int m,n;
    public int closedIsland(int[][] grid) {
    	m=grid.length;
    	n=grid[0].length;
        int ans=0;  //保存 最终答案
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(grid[i][j]==0 && dfs(grid,i,j)){
        			ans++;
        		}
        	}
        }
        return ans;
    }
    
    public boolean dfs(int[][] grid,int i,int j) {
    	if(grid[i][j]==1) {
    		return true;
    	}
    	if(i==0 || i==m-1 || j==0 || j==n-1) {
    		return false;
    	}
    	grid[i][j]=1;
    	boolean result=true;
    	if(i>0) {
    		result=result && dfs(grid,i-1,j);
    	}
    	if(i+1<m) {
    		result=dfs(grid,i+1,j) && result;
    	}
    	if(j>0) {
    		result=dfs(grid,i,j-1) && result;
    	}
    	if(j+1<n) {
    		result=dfs(grid,i,j+1) && result;
    	}
    	return result;
    }
}
