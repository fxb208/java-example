package leetcode.od.bfs;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Leetcode130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','O','X'},
                {'X','O','X','X'}
        };
        Leetcode130 yb = new Leetcode130();
        yb.solve(board);
        System.out.println(board);

//        if(len==4 && col==4){
//            board[1][1]='X';
//            System.out.println(board[1][1]+","+board[1][2]+","+board[2][2]+","+board[3][1]);
//        }
    }


    public void solve(char[][] board) {
        int len=board.length;
        int col=board[0].length;
        char O='O';
        for(int i=0;i<board.length;i++){
            if(board[i][0]==O){
                dbfs(board,i,0,'A',O);
            }
            if(board[i][col-1]==O){
                dbfs(board,i,col-1,'A',O);
            }
        }
        for(int i=0;i<col;i++){
            if(board[0][i]==O){
                dbfs(board,0,i,'A',O);
            }
            if(board[len-1][i]==O){
                dbfs(board,len-1,i,'A',O);
            }
        }
        // real change
        for(int i=0;i<len;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==O){
                    dbfs(board,i,j,'X',O);
                }
            }
        }
        // rollback
        for(int i=0;i<len;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='A'){
                    dbfs(board,i,j,O,'A');
                }
            }
        }

    }

    public void dbfs(char[][] board,int i,int j,char ch,char target){
        board[i][j]=ch;
        if(i>0 && board[i-1][j]==target){
            dbfs(board,i-1,j,ch,target);
        }
        if(j>0 && board[i][j-1]==target){
            dbfs(board,i,j-1,ch,target);
        }
        if(i<board.length-1 && board[i+1][j]==target){
            dbfs(board,i+1,j,ch,target);
        }
        if(j<board[0].length-1 && board[i][j+1]==target){
            dbfs(board,i,j+1,ch,target);
        }
    }
}
