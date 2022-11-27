package leetcode.od2.dp;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class Leetcode10 {
    public static void main(String[] args) {
        Leetcode10 yb = new Leetcode10();
        System.out.println(yb.isMatch("bbc","bba*c"));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int j=1; j<=p.length(); j++)
        {
            if(p.charAt(j-1)=='*') dp[0][j] = dp[0][j-2];//按题意p第一个元素不可能为'*'所以不必担心j越界
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
//                if(p.charAt(j-1) !='*'){
//                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
//                        dp[i][j]=dp[i-1][j-1];
//                    }
//                }else{
//                    if(p.charAt(j-2)!='.' && p.charAt(j-2) !=s.charAt(i-1)){
//                        dp[i][j]=dp[i][j-2];
//                    }else{
//                        dp[i][j]=dp[i-1][j-2] || dp[i-1][j] ;
//                    }
//                }
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                {
                    if(s.charAt(i-1)!=p.charAt(j-2) && p.charAt(j-2)!='.')
                    {
                        dp[i][j] = dp[i][j-2];
                    }
                    else
                    {
                        dp[i][j] = dp[i][j-2] | dp[i-1][j];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
