package leetcode.od.string;
import java.util.*;
public class NC149 {
    public static void main(String[] args) {
        NC149 yb = new NC149();
         yb.getNext("ABCDABB");
        //System.out.println(yb.kmp("a","aaaa"));
        //System.out.println(yb.kmp("abab","abacabab"));
    }

    public int kmp (String S, String T) {
        // write code here
        int res=0;
        int i=0;
        int j=0;
        int[] arr = getNext(S);
        while(i<T.length()){
            while(i<T.length() && j<S.length() && T.charAt(i)==S.charAt(j)){
                i++;
                j++;
            }
            if(j==S.length()){
                res++;
                j=arr[j-1];
            }else{
                if(j>0){
                    j=arr[j-1];
                }else if(j==0){
                    i++;
                }

            }
        }
        return res;
    }

    /**
     * ABCDABB
     * @param S
     * @return
     */
    private int[] getNext(String S){
        int m=S.length();
        int[] next=new int[m];
        next[0]=0;
        for(int i=1;i<m;i++){
            if(next[i-1]>0 && S.charAt(i)==S.charAt(next[i-1])){

            }else if(S.charAt(i)==S.charAt(0)){
                next[i]=1;
            }
        }
        return next;
    }

//    public int kmp (String S, String T) {
//        // write code here
//        int res=0;
//        int i=0;
//        int j=0;
//        while(i<T.length()){
//            int temp=i;
//            while(temp<T.length() && j<S.length() && T.charAt(temp)==S.charAt(j)){
//                temp++;
//                j++;
//            }
//            if(j==S.length()){
//                res++;
//                j=0;
//                i++;
//            }else{
//                j=0;
//                i++;
//            }
//        }
//        return res;
//    }

//    public int kmp (String S, String T) {
//        // write code here
//        int res = 0;
//        while(T.indexOf(S)>0){
//            res ++;
//            T=T.substring(T.indexOf(S)+1);
//        }
//        return res;
//    }

    //确定next数组
//    private int[] getNext(String S){
//        int m=S.length();
//        int[] next=new int[m];
//        for(int i=1,j=0;i<m;i++){
//            //只要不相等，回退到next数组记录的下一位
//            while(j>0&&S.charAt(i)!=S.charAt(j)){
//                j=next[j-1];
//            }
//            //前缀索引后移
//            if(S.charAt(i)==S.charAt(j)) j++;
//            //确定应该回退到的下一个索引
//            next[i]=j;
//        }
//        return next;
//    }
}
