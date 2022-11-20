package leetcode.od.string;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class Leetcode28 {

    public static void main(String[] args) {
        Leetcode28 yb = new Leetcode28();
        //System.out.println(yb.strStr("adcadcaddcadde","adcadde"));
        //System.out.println(yb.strStr2("haystack","hay"));
        System.out.println(yb.next("adcadde"));
    }

    public int strStr(String haystack, String needle) {
        int res = -1;
        int[] next = next(needle);
        int i=0;
        int j=0;
        while(i<haystack.length()){
            while (i<haystack.length() && j<needle.length() && haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            if(j==needle.length()){
                res=i-j;
                break;
            }else{
                if(j==0){
                    i++;
                }else{
                    j=next[j-1];
                }
            }
        }
        return res;
    }

    public int[] next(String needle){
        int[] res = new int[needle.length()];
        res[0]=0;
        for(int i=1;i<res.length;i++){
            int j=res[i-1];
            while(j>0 && needle.charAt(i)!=needle.charAt(j)){
                //j=res[j-1];
                j--;
            }
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            res[i]=j;
        }
        return res;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
