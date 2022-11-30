package leetcode.od2.math;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */
public class Leetcode67 {
    public static void main(String[] args) {
        Leetcode67 yb = new Leetcode67();
        System.out.println(yb.addBinary("11","1"));
    }

    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int arr[] = new int[Math.max(len1,len2)+1];
        int i=len1-1;
        int j=len2-1;
        int idx = arr.length-1;
        while(i>=0 || j>=0){
            if(i>=0 && j>=0){
                arr[idx]=arr[idx]+a.charAt(i)-'0'+b.charAt(j)-'0';
                i--;
                j--;
            }else if(i>=0){
                arr[idx]=arr[idx]+a.charAt(i)-'0';
                i--;
            }else{
                arr[idx]=arr[idx]+b.charAt(j)-'0';
                j--;
            }
            if(arr[idx]==2){
                arr[idx]=0;
                arr[idx-1]=1;
            }else if(arr[idx]==3){
                arr[idx]=1;
                arr[idx-1]=1;
            }
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        if(arr[0]==1){
            sb.append(arr[0]);
        }
        for(int k = 1;k<arr.length;k++){
            sb.append(arr[k]);
        }
        return sb.toString();
    }
}
