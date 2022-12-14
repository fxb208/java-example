package leetcode.od2.dp;

/**
 * 1143. 最长公共子序列
 *
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。
 *  如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class Leetcode1143 {
    public static void main(String[] args) {
        //
        Leetcode1143 yb = new Leetcode1143();
        System.out.println(yb.longestCommonSubsequence("abcd","abed"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        if(text1.charAt(0)==text2.charAt(0)){
            dp[0][0]=1;
        }
        for(int i=1;i< dp.length;i++){
            if(text1.charAt(i)==text2.charAt(0)){
                dp[i][0]=Math.max(dp[i-1][0],1);
            }else{
                dp[i][0]=dp[i-1][0];
            }
        }
        for(int j=1;j< dp[0].length;j++){
            if(text1.charAt(0)==text2.charAt(j)){
                dp[0][j]=Math.max(dp[0][j-1],1);
            }else{
                dp[0][j]=dp[0][j-1];
            }
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
