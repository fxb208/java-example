package leetcode.od.string;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        int index = 0;
        for(int i=0;i<str.length();i++){
            boolean prefix = true;
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i || str.charAt(i) != strs[j].charAt(i)){
                    prefix = false;
                    break;
                }
            }
            if(prefix){
                index++;
            }else{
                break;
            }
        }
        return str.substring(0,index);
    }
}
