package leetcode.od2.arr;

/**
 * 498. 对角线遍历
 *
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 */
public class Leetcode498 {
    public static void main(String[] args) {
        Leetcode498 yb = new Leetcode498();
//        int[][] mat = new int[][]{
//                {1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = new int[][]{{2,5},{8,4},{0,-1}};
        yb.findDiagonalOrder(mat);
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int k=0;
        for(int i=0;i<m+n-1;i++){
            if(i%2==0){
                int x = i<m ? i:m-1;
                int y = i<m ? 0:i-m+1;
                while(x>=0 && y<n){
                    res[k]=mat[x][y];
                    x--;
                    y++;
                    k++;
                }
            }else{
                int x = i<n ? 0:i-n+1;
                int y = i<n ? i:n-1;
                while(x<m && y>=0){
                    res[k]=mat[x][y];
                    x++;
                    y--;
                    k++;
                }
            }
        }
        return res;
    }
}
