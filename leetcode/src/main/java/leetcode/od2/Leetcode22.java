package leetcode.od2;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Leetcode22 {
    public static void main(String[] args) {
        //
        Leetcode22 yb = new Leetcode22();
        yb.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,new StringBuilder(),0,0,n);
        return res;
    }

    public void backtrack(List<String> res,StringBuilder sb,int start,int close,int n){
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }
        if(start<n){
            sb.append("(");
            backtrack(res,sb,start+1,close,n);
            sb.delete(sb.length()-1,sb.length());
        }
        if(close<start){
            sb.append(")");
            backtrack(res,sb,start,close+1,n);
            sb.delete(sb.length()-1,sb.length());
        }
    }
}
