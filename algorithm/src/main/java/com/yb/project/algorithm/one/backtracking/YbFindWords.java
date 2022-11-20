package com.yb.project.algorithm.one.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 212. 单词搜索 II
 * @author fxb20
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbFindWords {
    public List<String> findWords(char[][] board, String[] words) {
    	List<String> res=new LinkedList<String>();
    	for(int k=0;k<words.length;k++) {
    		if(exist(board,words[k])) {
    			res.add(words[k]);
    		}
    	}
    	return res;
    }
    
    public boolean exist(char[][] board, String word) {
        int h = board.length; 
        int w = board[0].length;
        boolean[][] use=new boolean[h][w];
        for(int i=0;i<h;i++) {
        	for(int j=0;j<w;j++) {
        		if(backtrack(board,word,i,j,use,0)) {
        			return true;
        		}
        	}
        }
        return false;
    }

	private boolean backtrack(char[][] board, String word, int i, int j, boolean[][] use, int idx) {
		if(word.charAt(idx) !=board[i][j]) {
			return false;
		}
		if(idx==word.length()-1) {
			return true;
		}
		use[i][j]=true;
		if(i>0 && !use[i-1][j] && backtrack(board,word,i-1,j,use,idx+1)) {
			return true;
		}
		if(j>0 && !use[i][j-1] && backtrack(board,word,i,j-1,use,idx+1)) {
			return true;
		}
		if(i<board.length && !use[i+1][j] && backtrack(board,word,i+1,j,use,idx+1)) {
			return true;
		}
		if(j<board[0].length && !use[i][j+1] && backtrack(board,word,i,j+1,use,idx+1)) {
			return true;
		}
		use[i][j]=false;
		return false;
	}
}
