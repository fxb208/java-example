package com.yb.project.algorithm.one.graph.day1;

/**
 * leecode 733. 图像渲染
 * @author fxb20
 * 
 * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
 * 你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。
 * 将所有有记录的像素点的颜色值改为 newColor 。
 * 最后返回 经过上色渲染后的图像 。
 * 
 * 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 
 * 输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * 输出: [[2,2,2],[2,2,2]]
 *
 */
public class YbFloodFill {
	
	public static void main(String[] args) {
		int[][] image= {{1,1,1},{1,1,0},{1,0,1}};
		int sr=	1;
	    int sc=	1;
		int newColor= 2;
		
		YbFloodFill yb=new YbFloodFill();
		yb.floodFill(image, sr, sc, newColor);
	}
	
	/**
	 * 参考https://blog.csdn.net/Sueko/article/details/123256868
	 * @param image
	 * @param sr
	 * @param sc
	 * @param newColor
	 * @return
	 */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	int oldColor=image[sr][sc];
    	if(oldColor !=newColor) {  //这一段判断很重要，如果没有此判断则可能会栈溢出
    		dfs(image,sr,sc,oldColor,newColor);	
    	}
    	return image;
    }
    
    public void dfs(int[][] image,int sr,int sc,int oldColor,int newColor) {
    	if(image[sr][sc]==oldColor) {
    		image[sr][sc]=newColor;
    		if(sr>0) {
    			dfs(image,sr-1,sc,oldColor,newColor);
    		}
    		if(sr<image.length-1) {
    			dfs(image,sr+1,sc,oldColor,newColor);
    		}
    		if(sc>0) {
    			dfs(image,sr,sc-1,oldColor,newColor);	
    		}
    		if(sc<image[0].length-1) {
    			dfs(image,sr,sc+1,oldColor,newColor);	
    		}
    		
    	}
    }
}
