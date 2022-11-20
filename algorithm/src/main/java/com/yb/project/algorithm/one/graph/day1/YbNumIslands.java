package com.yb.project.algorithm.one.graph.day1;

/**
 * leecode 200. 岛屿数量
 * @author fxb20
 * 
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 输入：grid = [
 * 	["1","1","1","1","0"],
 * 	["1","1","0","1","0"],
 * 	["1","1","0","0","0"],
 * 	["0","0","0","0","0"]
 * ]
 * 输出：1
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbNumIslands {
	
	/**
	 * 参考 https://www.imooc.com/article/291766
	 * @param grid
	 * @return
	 */
    public int numIslands(char[][] grid) {
    	int count=0;
    	int cols=grid[0].length;
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<cols;j++) {
        		if(grid[i][j]=='1') {
        			dfs(grid,i,j);
        			count++;
        		}
        	}
    	}
    	return count;
    }
    
    public void dfs(char[][] grid,int sr,int sc) {
    	if(grid[sr][sc]=='1') {
    		grid[sr][sc]='0';
    		if(sr>0) {
    			dfs(grid,sr-1,sc);
    		}
    		if(sr<grid.length-1) {
    			dfs(grid,sr+1,sc);
    		}
    		if(sc>0) {
    			dfs(grid,sr,sc-1);	
    		}
    		if(sc<grid[0].length-1) {
    			dfs(grid,sr,sc+1);	
    		}
    		
    	}
    }
}
