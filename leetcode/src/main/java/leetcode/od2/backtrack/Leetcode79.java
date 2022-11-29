package leetcode.od2.backtrack;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class Leetcode79 {
    public static void main(String[] args) {
        Leetcode79 yb = new Leetcode79();
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(yb.exist(board,"SEE"));

//        char[][] board = new char[][]{
//                {'a','a'}
//        };
//        System.out.println(yb.exist(board,"aaa"));
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] used = new boolean[board.length][board[0].length];
                    if(backTrack(word,board,i,j,0,used)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backTrack(String word,char[][] board,int i,int j,int idx,boolean[][] used){
        if(board[i][j] != word.charAt(idx)){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }

        used[i][j]=true;
        if(i>0 && !used[i-1][j] && backTrack(word,board,i-1,j,idx+1,used)){
            return true;
        }
        if(i<board.length-1 && !used[i+1][j] && backTrack(word,board,i+1,j,idx+1,used)){
            return true;
        }
        if(j>0 && !used[i][j-1] && backTrack(word,board,i,j-1,idx+1,used)){
            return true;
        }
        if(j<board[0].length-1 && !used[i][j+1] && backTrack(word,board,i,j+1,idx+1,used)){
            return true;
        }
        used[i][j]=false;
        return false;
    }


    /**
     * low
     * @param board
     * @param word
     * @return
     */
    public boolean exist_low(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    StringBuilder sb = new StringBuilder();
                    boolean[][] used = new boolean[board.length][board[0].length];
                    used[i][j]=true;
                    if(backTrack(sb.append(word.charAt(0)),word,board,i,j,0,used)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backTrack(StringBuilder sb,String word,char[][] board,int i,int j,int idx,boolean[][] used){
        if(word.equals(sb.toString())){
            return true;
        }
        if(idx==word.length()-1){
            return false;
        }
        if(board[i][j] !=word.charAt(idx)){
            return false;
        }
        boolean up = false;
        boolean down =false;
        boolean left = false;
        boolean right = false;
        if(i>0){
            if(!used[i-1][j]){
                used[i-1][j]=true;
                sb.append(board[i-1][j]);
                up = backTrack(sb,word,board,i-1,j,idx+1,used);
                sb.delete(sb.length()-1,sb.length());
                used[i-1][j]=false;
            }

        }
        if(i<board.length-1){
            if(!used[i+1][j]){
                used[i+1][j]=true;
                sb.append(board[i+1][j]);
                down = backTrack(sb,word,board,i+1,j,idx+1,used);
                sb.delete(sb.length()-1,sb.length());
                used[i+1][j]=false;
            }

        }
        if(j>0){
            if(!used[i][j-1]){
                used[i][j-1]=true;
                sb.append(board[i][j-1]);
                left = backTrack(sb,word,board,i,j-1,idx+1,used);
                sb.delete(sb.length()-1,sb.length());
                used[i][j-1]=false;
            }

        }
        if(j<board[0].length-1){
            if(!used[i][j+1]){
                used[i][j+1]=true;
                sb.append(board[i][j+1]);
                right = backTrack(sb,word,board,i,j+1,idx+1,used);
                sb.delete(sb.length()-1,sb.length());
                used[i][j+1]=false;
            }
        }
        return up || down || left || right;
    }

}
