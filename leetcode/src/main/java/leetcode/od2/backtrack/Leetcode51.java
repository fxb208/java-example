package leetcode.od2.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Leetcode51 {
    public static void main(String[] args) {
        Leetcode51 yb = new Leetcode51();
        yb.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backTrack(res,board,0,n);
        return res;
    }

    public void backTrack(List<List<String>> res,char[][] board,int idx,int n){
        if(idx==n){
            List<String> path = new ArrayList<>();
            for (char[] ch : board) {
                path.add(new String(ch));
            }
            res.add(path);
            return;
        }
        for(int i=0;i<n;i++){
            if(idx==0 || check(board,idx,i,n)){
                board[idx][i]='Q';
                backTrack(res,board,idx+1,n);
                board[idx][i]='.';
            }
        }
    }

    public boolean check(char[][] board,int row,int col,int n){
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j= col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j= col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

}
