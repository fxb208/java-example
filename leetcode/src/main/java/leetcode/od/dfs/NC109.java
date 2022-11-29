package leetcode.od.dfs;

/**
 * NC109 岛屿数量
 *
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 */
public class NC109 {
    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve (char[][] grid) {
        // write code here
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid,int i, int j){
        grid[i][j]=0;
        if(i>0 && grid[i-1][j]=='1'){
            bfs(grid,i-1,j);
        }
        if(j>0 && grid[i][j-1]=='1'){
            bfs(grid,i,j-1);
        }
        if(i<grid.length-1 && grid[i+1][j]=='1'){
            bfs(grid,i+1,j);
        }
        if(j<grid[0].length-1 && grid[i][j+1]=='1'){
            bfs(grid,i,j+1);
        }
    }
}
