package leetcode.od.other;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Leetcode200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }

    public void dfs(int i,int j,char[][] grid){
        if(i>0 && grid[i-1][j]=='1'){
            grid[i-1][j]='0';
            dfs(i-1,j,grid);
        }
        if(j>0 && grid[i][j-1]=='1'){
            grid[i][j-1]='0';
            dfs(i,j-1,grid);
        }
        if(i<grid.length-1 && grid[i+1][j]=='1'){
            grid[i+1][j]='0';
            dfs(i+1,j,grid);
        }
        if(j<grid[0].length-1 && grid[i][j+1]=='1'){
            grid[i][j+1]='0';
            dfs(i,j+1,grid);
        }
    }
}
