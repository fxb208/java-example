package leetcode.od.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 463. 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。
 * 整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 */
public class Leetcode463 {
    public static void main(String[] args) {
        Leetcode463 yb = new Leetcode463();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        // int[][] grid = {{1,1},{1,1}};
        System.out.println(yb.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=-1;
                    queue.add(new int[]{i,j});
                    break;
                }
            }
            if(!queue.isEmpty()){
                break;
            }
        }
        int res = 0;
        while(!queue.isEmpty()){
            int[] arr=queue.poll();
            int i=arr[0];
            int j=arr[1];

            if(i>0 && grid[i-1][j]==1){
                grid[i-1][j]=-1;
                queue.add(new int[]{i-1,j});
            }else if(i>0 && grid[i-1][j]==0){
                res++;
            }else if(i==0){
                res++;
            }

            if(i< grid.length-1 && grid[i+1][j]==1){
                grid[i+1][j]=-1;
                queue.add(new int[]{i+1,j});
            }else if(i< grid.length-1 && grid[i+1][j]==0){
                res++;
            }else if(i== grid.length-1){
                res++;
            }

            if(j>0 && grid[i][j-1]==1){
                grid[i][j-1]=-1;
                queue.add(new int[]{i,j-1});
            }else if(j>0 && grid[i][j-1]==0){
                res++;
            }else if(j==0){
                res++;
            }

            if(j< grid[0].length-1 && grid[i][j+1]==1){
                grid[i][j+1]=-1;
                queue.add(new int[]{i,j+1});
            }else if(j< grid[0].length-1 && grid[i][j+1]==0){
                res++;
            }else if(j== grid[0].length-1){
                res++;
            }

        }
        return res;
    }
}
