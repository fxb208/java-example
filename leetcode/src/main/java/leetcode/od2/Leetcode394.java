package leetcode.od2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
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
