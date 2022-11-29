package leetcode.od2;

/**
 * 38. 外观数列
 *
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 */
public class Leetcode38 {
    public static void main(String[] args) {
        Leetcode38 yb = new Leetcode38();
        System.out.println(yb.countAndSay(5));
    }

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String[] dp = new String[n];
        dp[0]="1";
        dp[1]="11";
        for(int i=2;i<n;i++){
            String str = dp[i-1];
            int idx = 1;
            StringBuilder sb = new StringBuilder();
            for(int j=1;j<str.length();j++){
                if(str.charAt(j)==str.charAt(j-1)){
                    idx++;
                }else{
                    sb.append(idx).append(str.charAt(j-1));
                    idx=1;
                }
            }
            sb.append(idx).append(str.charAt(str.length()-1));
            dp[i]=sb.toString();
        }
        return dp[n-1];
    }
}
