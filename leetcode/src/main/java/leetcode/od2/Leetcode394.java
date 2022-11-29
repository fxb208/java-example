package leetcode.od2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class Leetcode394 {
    public static void main(String[] args){
        Leetcode394 yb = new Leetcode394();
        System.out.println(yb.decodeString("100[leetcode]"));
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> countStack = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();
        StringBuilder count = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                count.append(s.charAt(i));
            } else if(s.charAt(i)==']'){
                StringBuilder sb = new StringBuilder();
                Stack<String> temp = new Stack<>();
                while(!stack.peek().equals("[")){
                    temp.push(stack.pop());
                }
                stack.pop();
                while(!temp.isEmpty()){
                    sb.append(temp.pop());
                }
                int times = countStack.pop();
                if(!countStack.isEmpty()){
                    for(int j=0;j<times;j++){
                        stack.push(sb.toString());
                    }
                }else{
                    for(int j=0;j<times;j++){
                        res.append(sb.toString());
                    }
                }
            } else if((s.charAt(i)=='[')){
                countStack.push(Integer.valueOf(count.toString()));
                count.setLength(0);
                stack.push("[");
            } else {
                if(countStack.isEmpty()){
                    res.append(s.charAt(i));
                }else{
                    stack.push(""+s.charAt(i));
                }
            }
        }
        return res.toString();
    }
}
