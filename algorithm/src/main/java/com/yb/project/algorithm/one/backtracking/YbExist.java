package com.yb.project.algorithm.one.backtracking;


/**
 * leetcode 79. 单词搜索
 * @author fxb20
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbExist {
	
	public static void main(String[] args) {
		
		YbExist yb=new YbExist();
//		char[][] board=new char[][] {
//			{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
//		};
//		System.out.println(yb.exist(board, "ABCCED"));
		
		char[][] board=new char[][] {
			{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
		};
		System.out.println(yb.exist(board, "SEE"));
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
    
    public boolean backtrack(char[][] board, String word,int i,int j,boolean[][] use,int idx) {
    	if(word.charAt(idx) !=board[i][j]) {
    		return false;
    	}
    	if(idx==word.length()-1) {
    		return true;
    	}
    	use[i][j]=true;
		if(i>0 && !use[i-1][j] && backtrack(board, word,i-1,j,use,idx+1)) {
			return true;
		}
		if(j>0 && !use[i][j-1] && backtrack(board, word,i,j-1,use,idx+1)) {
			return true;
		}
		if(i<board.length-1 && !use[i+1][j] && backtrack(board, word,i+1,j,use,idx+1)) {
			return true;
		}
		if(j<board[0].length-1 && !use[i][j+1] && backtrack(board, word,i,j+1,use,idx+1)) {
			return true;
		}
		use[i][j]=false;
    	return false;
    }

	
//    public boolean exist(char[][] board, String word) { 
//    	HashSet<Coordinate> x=new HashSet<Coordinate>();
//    	boolean res=backtrack(board, word,new StringBuffer(),0,0,-1,x);
//    	return res;
//    }
//
//	/**
//     * type=1;  right;
//	 * type=2;  down;
//	 * type=3;  up;
//	 * type=4;  left;
//     * @param board
//     * @param word
//     * @param path
//     * @param idx
//     * @param idy
//     * @param action
//     * @return
//     */
//    public boolean backtrack(char[][] board, String word, StringBuffer path, int idx, int idy, int type,HashSet<Coordinate> x) {
//    	if(path.length()==word.length() || idx==board.length || idy==board[0].length) {
//    		if(path.toString().equals(word)) {
//    			return true;
//    		}
//    		return false;
//    	}
//    	for(int i=idx;i<board.length;i++) {
//    		for(int j=idy;j<board[0].length;j++) {
//    			Coordinate coordinate=new Coordinate(i,j);
//    			if(!x.contains(coordinate)) {
//    		    	if(path.length()<word.length() && word.charAt(path.length())!=board[i][j] ) {
//    		    		continue;
//    		    	}
//    				x.add(coordinate);
//    				path.append(board[i][j]);
//        			if(type!=3 && backtrack(board, word,path,i+1,j,2,x)) {
//        				return true;
//        			}else if(type!=4 && backtrack(board, word,path,i,j+1,1,x)){
//        				return true;
//        			}else if(type!=2 && i>0 && backtrack(board, word,path,i-1,j,3,x)){
//        				return true;
//        			}else if(type!=1 && j>0 && backtrack(board, word,path,i,j-1,4,x
//        					)){
//        				return true;
//        			}
//        			path.deleteCharAt(path.length()-1);
//        			x.remove(coordinate);
//    			}	
//    		}
//    	}
//    
//    	return false;
//    }
//    
//    class Coordinate{
//    	int x;
//    	int y;
//		public Coordinate(int x, int y) {
//			super();
//			this.x = x;
//			this.y = y;
//		}
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result;
//			result = prime * result + Objects.hash(x, y);
//			return result;
//		}
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Coordinate other = (Coordinate) obj;
//			return x == other.x && y == other.y;
//		}
//    }
}
