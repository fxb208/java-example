package com.yb.project.algorithm.one.unionfind;

/**
 * leecode 547. 省份数量
 * @author fxb20
 * 
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。
 * 如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。返回矩阵中 省份 的数量。
 * 
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 
 * 
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 */
public class YbFindCircleNum {
	
	public static void main(String[] args) {
		YbFindCircleNum yb=new YbFindCircleNum();
		int[][] isConnected=new int[][] {{1,1,0},{1,1,0},{0,0,1}};
		int result=yb.findCircleNum(isConnected);
		System.out.println(result);
	}
	
    public int findCircleNum(int[][] isConnected) {
    	int n=isConnected.length;
    	UnionFind unionFind=new UnionFind(n);
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			if(isConnected[i][j]==1) {
    				unionFind.union(i, j);
    			}
    		}
    	}
    	return unionFind.size;
    }
    
    class UnionFind{
    	int[] parent;
    	volatile int size;
		public UnionFind(int n) {
			super();
			this.parent=new int[n];
			for(int i=0;i<n;i++) {
				parent[i]=i;
			}
			this.size = parent.length;
		}
		
		public int find(int p) {
			while(parent[p] !=p) {
				p=parent[p];
			}
			return p;
		}
		
		
		public boolean union(int a, int b) {
			int rootA=find(a);
			int rootB=find(b);
			if(rootA==rootB) {
				return false;
			}
			parent[rootA] = rootB;
			size--;
	        return true;
		}
    	
    }
}
