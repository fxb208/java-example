package leetcode.od.dp;


/**
 * HJ85 最长回文子串
 */
public class HJ85 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNext()) { // 注意 while 处理多个 case
//            String text = in.next();
//        }
        dp("abbba");
    }

    public static void dp(String text){
        char[] arr = text.toCharArray();
        int len = arr.length;
        boolean[][] dp = new boolean[len][len];
        int res=0;
        for(int i=0;i<len;i++){
            dp[i][i]=true;
            res=1;
        }
        for(int i=0;i+1<len;i++){
            if(arr[i]==arr[i+1]){
                dp[i][i+1]=true;
                res=2;
            }
        }
        for(int i=2;i<len;i++){
            for(int j=0;i+j<len;j++){
                if(arr[j]==arr[i+j] && dp[j+1][i+j-1]){
                    dp[j][i+j]=true;
                    res=Math.max(res,i+1);
                }
            }
        }
        System.out.println(res);
    }
}
