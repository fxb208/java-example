package leetcode.od2;

/**
 * 521. 最长特殊序列
 * 给你两个字符串 a 和 b，请返回 这两个字符串中 最长的特殊序列  的长度。如果不存在，则返回 -1 。
 * 最长特殊序列 定义如下：该序列为 某字符串独有的最长子序列（即不能是其他字符串的子序列） 。
 * 字符串 s 的子序列是在从 s 中删除任意数量的字符后可以获得的字符串。
 * 例如，"abc" 是 "aebdc" 的子序列，因为删除 "aebdc" 中斜体加粗的字符可以得到 "abc" 。
 * "aebdc" 的子序列还包括 "aebdc" 、 "aeb" 和 "" (空字符串)。
 */
public class Leetcode521 {
    public static void main(String[] args) {
        Leetcode521 yb = new Leetcode521();
        System.out.println(yb.findLUSlength("aefeaf","a"));
    }

    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        int length = longestCommonSubsequence(a,b);
        if(length<=a.length() && length<=b.length()){
            return Math.max(a.length(),b.length());
        }
        return -1;
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
