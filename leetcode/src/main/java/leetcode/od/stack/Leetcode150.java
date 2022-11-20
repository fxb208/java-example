package leetcode.od.stack;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意 两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class Leetcode150 {
    public static void main(String[] args) {
        Leetcode150 yb = new Leetcode150();
        System.out.println(yb.evalRPN(new String[]{"2","1","+","3","*"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< tokens.length;i++){
            String str = tokens[i];
            if("+".equals(str)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            }else if("-".equals(str)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }else if("*".equals(str)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            }else if("/".equals(str)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else{
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}
