package leetcode.od3.arr;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class Leetcode48 {
    public static void main(String[] args) {
        Leetcode48 yb = new Leetcode48();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        yb.rotate(matrix);
        System.out.println(matrix);
    }

    public void rotate(int[][] matrix) {
        for(int times = matrix.length-1;times>0;times--){
            int left = 0;
            int top = 0;
            int right = matrix[0].length-1;
            int bottom = matrix.length-1;
            int k = 0;
            while(left<=right && top<=bottom && times>k*2){
                Queue<Integer> queue=new LinkedList<>();
                for(int i=left;i<=right;i++){
                    queue.offer(matrix[top][i]);
                    if(queue.size()==2){
                        matrix[top][i]=queue.poll();
                    }
                }
                for(int i=top+1;i<=bottom;i++){
                    queue.offer(matrix[i][right]);
                    if(queue.size()==2){
                        matrix[i][right]=queue.poll();
                    }
                }
                if(left<right && top<bottom){
                    for(int i=right-1;i>=left;i--){
                        queue.offer(matrix[bottom][i]);
                        if(queue.size()==2){
                            matrix[bottom][i]=queue.poll();
                        }
                    }
                    for(int i=bottom-1;i>=top;i--){
                        if(i>top){
                            queue.offer(matrix[i][left]);
                            if(queue.size()==2){
                                matrix[i][left]=queue.poll();
                            }
                        }else{
                            matrix[i][left]=queue.poll();
                        }
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
                k++;
            }
        }
    }
}
