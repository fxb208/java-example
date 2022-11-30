package leetcode.od2.dp;

/**
 * 63. 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class Leetcode63 {
    public static void main(String[] args) {
        Leetcode63 yb = new Leetcode63();
        int[][] grid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(yb.uniquePathsWithObstacles(grid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<dp.length;i++){
            if(obstacleGrid[i][0]==1){
                break;
            }else{
                dp[i][0]=1;
            }
        }
        for(int j=0;j<dp[0].length;j++){
            if(obstacleGrid[0][j]==1){
                break;
            }else{
                dp[0][j]=1;
            }
        }
        for(int i=1;i< dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
