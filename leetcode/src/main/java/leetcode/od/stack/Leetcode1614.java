package leetcode.od.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * 1614. 括号的最大嵌套深度
 * https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class Leetcode1614 {
    public int maxDepth(String s) {
        int result=0;
        int j=0;
        List<Character> lst = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                lst.add(s.charAt(i));
                j++;
                result = Math.max(j,result);
            }
            if(s.charAt(i)==')'){
                lst.remove(lst.size()-1);
                j--;
            }
        }
        return result;
    }
}
