package leetcode.od.general;

public class Leetcode44 {
    public static void main(String[] args) {
        Leetcode44 yb = new Leetcode44();
        String s = "aa";
        String p = "*";
        System.out.println(yb.isMatch(s,p));
    }

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[ss.length+1][pp.length+1];
        for(int j=1;j<=pp.length;j++){
            if(pp[j-1]=='*'){
                dp[0][j]=true;
            }else{
                break;
            }
        }
        dp[0][0]=true;
        for(int i=1;i<=ss.length;i++){
            for(int j=1;j<=pp.length;j++){
                if(pp[j-1]=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }else if(pp[j-1]==ss[i-1] || pp[j-1]=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
