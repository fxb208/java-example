package leetcode.od.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class Leetcode994 {
    public static void main(String[] args) {
        int[][] grid =new int[][]{{2,1,1},{1,1,1},{0,1,2}};
        Leetcode994 yb = new Leetcode994();
        System.out.println(yb.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int count = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        if(count==0){
            return 0;
        }
        int res = 0;
        while(queue.size()>0){
            int size = queue.size();
            for(int k=0;k<size;k++){
                int[] idx= queue.poll();
                int i=idx[0];
                int j=idx[1];
                if(i>0 && grid[i-1][j]==1){
                    count--;
                    grid[i-1][j]=2;
                    queue.add(new int[]{i-1,j});
                }
                if(j>0 && grid[i][j-1]==1){
                    count--;
                    grid[i][j-1]=2;
                    queue.add(new int[]{i,j-1});
                }
                if(i<grid.length-1  && grid[i+1][j]==1){
                    count--;
                    grid[i+1][j]=2;
                    queue.add(new int[]{i+1,j});
                }
                if(j<grid[0].length-1  && grid[i][j+1]==1){
                    count--;
                    grid[i][j+1]=2;
                    queue.add(new int[]{i,j+1});
                }
            }
            res ++;
        }
        if(count>0){
            return -1;
        }
        return res-1;
    }
}
