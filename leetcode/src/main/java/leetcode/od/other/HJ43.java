package leetcode.od.other;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class HJ43 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        int col=sc.nextInt();
        int[][] maze=new int[length][col];
        for(int i=0;i<length;i++){
            for(int j=0;j<col;j++){
                maze[i][j]=sc.nextInt();
            }
        }
        List<String> list=new ArrayList<String>();
        HJ43 yb=new HJ43();
        yb.dfs(maze,0,0,0,list);
        for(int i=list.size()-1;i>=0;i--) {
            System.out.println(list.get(i));
        }

    }

    public boolean dfs(int[][] maze,int type,int i,int j,List<String> list) {
        if(maze[i][j]==0) {
            if(i==maze.length-1 && j==maze[0].length-1) {
                list.add("("+i+","+j+")");
                return true;
            }
            boolean right=false;
            boolean down=false;
            boolean up=false;
            boolean left=false;
            //向右走
            if(j+1<maze[0].length && type !=4) {
                right=this.dfs(maze,1,i,j+1,list);
            }
            //向下走
            if(i+1<maze.length && type !=3) {
                down=this.dfs(maze,2,i+1,j,list);
            }
            //向上走
            if(i-1>=0 && type !=2) {
                up=this.dfs(maze,3,i-1,j,list);
            }
            //向左走
            if(j-1>=0 && type !=1) {
                left=this.dfs(maze,4,i,j-1,list);
            }
            if(down || right || up || left) {
                list.add("("+i+","+j+")");
                return true;
            }
        }
        return false;
    }

}
