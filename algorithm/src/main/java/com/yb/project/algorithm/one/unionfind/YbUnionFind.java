package com.yb.project.algorithm.one.unionfind;

/**
 * 
 * @author fxb20
 *
 */
public class YbUnionFind {
	public class UnionFind {
	    private int[] parent;
	    private int[] rank;

	    public UnionFind(int n) {
	        this.parent = new int[n];
	        for (int i = 0; i < n; i++) {
	            this.parent[i] = i;
	            this.rank[i] = 1;
	        }
	    }

	    private int find(int p) {
	        if (parent[p] != p) {
	            parent[p] = find(parent[p]);
	        }
	        return parent[p];
	    }

	    public boolean union(int a, int b) {
	        int rootA = find(a);
	        int rootB = find(b);
	        if (rootA == rootB) return false;
	        if (rank[rootA] < rank[rootB])
	        	parent[rootA] = rootB;
	        else {
	            parent[rootB] = rootA;
	            if (rank[rootA] == rank[rootB])
	                rank[rootA]++;
	        }
	        return true;
	    }
	    
	    public boolean connected(int a, int b) {
	        return find(a) == find(b);
	    }
	}

}
