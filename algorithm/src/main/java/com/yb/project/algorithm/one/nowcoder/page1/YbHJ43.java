package com.yb.project.algorithm.one.nowcoder.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 迷宫问题
 * @author fxb20
 *
 */
public class YbHJ43 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		int length=sc.nextInt();
//		int col=sc.nextInt();
		//int[][] maze=new int[length][col];
		int[][] maze=new int[][] {
			{0, 1, 0, 0, 0},
			{0, 1, 1, 1, 0},
			{0, 0, 0, 0, 0},
			{0, 1, 1, 1, 0},
			{0, 0, 0, 1, 0}
		};
		System.out.println(maze[4][4]);
		List<String> list=new ArrayList<String>();
		YbHJ43 yb=new YbHJ43();
		yb.dfs2(maze,0,0,0,list);
		for(int i=list.size()-1;i>=0;i--) {
			System.out.println(list.get(i));
		}
		sc.close();
	}
	
	/**
	 * type=1;  right;
	 * type=2;  down;
	 * type=3;  up;
	 * type=4;  left;
	 * 
	 * @param maze
	 * @param type
	 * @param i
	 * @param j
	 * @param list
	 * @return
	 */
	public boolean dfs2(int[][] maze,int type,int i,int j,List<String> list) {
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
				right=this.dfs2(maze,1,i,j+1,list);
			}
			//向下走
			if(i+1<maze.length && type !=3) {
				down=this.dfs2(maze,2,i+1,j,list);
			}
			//向上走
			if(i-1>=0 && type !=2) {
				up=this.dfs2(maze,3,i-1,j,list);
			}
			//向左走
			if(j-1>=0 && type !=1) {
				left=this.dfs2(maze,4,i,j-1,list);
			}
			if(down || right || up || left) {
				list.add("("+i+","+j+")");
				return true;
			}
		}
		return false;
	}
}
