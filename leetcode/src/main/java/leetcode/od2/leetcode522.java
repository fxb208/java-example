package leetcode.od2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 522. 最长特殊序列 II
 *
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 */
public class leetcode522 {

    public static void main(String[] args) {
        leetcode522 yb = new leetcode522();
        System.out.println(yb.findLUSlength(new String[]{"abcabc","abcabc","abcabc","abc","abc","cca"}));
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs,(o1, o2) -> {return o2.length()-o1.length();});
        int res = -1;
        for(int i=0;i<strs.length;i++){
            boolean check = true;
            for(int j=0;j< strs.length && strs[j].length()>=strs[i].length();j++){
                if(j!=i && check(strs[j],strs[i])){
                    check = false;
                    break;
                }
            }
            if(check){
                return strs[i].length();
            }
        }
        return -1;
    }

    public boolean check(String text1,String text2){
        int j=0;
        for(int i=0;i<text1.length();i++){
            if(text2.charAt(j)==text1.charAt(i)){
                j++;
                if(j==text2.length()){
                    return true;
                }
            }
        }
        return false;
    }


}
