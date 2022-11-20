package leetcode.od.arr;

import java.util.Scanner;

/**
 * HJ69 矩阵乘法
 * 描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。
 *
 * 这个矩阵的每个元素是由下面的公式决定的
 * 矩阵的大小不超过100*100
 */
public class HJ69 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ii = in.nextInt();
        int col = in.nextInt();
        int jj = in.nextInt();
        int[][] arr1 = new int[ii][col];
        int[][] arr2 = new int[col][jj];
        for(int i=0;i<ii;i++){
            for(int j=0;j<col;j++){
                arr1[i][j]=in.nextInt();
            }
        }
        for(int i=0;i<col;i++){
            for(int j=0;j<jj;j++){
                arr2[i][j]=in.nextInt();
            }
        }

        int[][] res=new int[ii][jj];
        for(int i=0;i<ii;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<jj;j++){
                for(int m=0;m<col;m++){
                    res[i][j]+=arr1[i][m]*arr2[m][j];
                }
                sb.append(res[i][j]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
