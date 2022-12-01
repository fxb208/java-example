package leetcode.od2.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * 3+2*{1+2*[-4/(8-6)+7]}
 */
public class HJ50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String word = in.nextLine();
        String word = "3*5+8-0*3-6+0+0";
        //String word = "(7+5*4*3+6)";
        Stack<String> stack = new Stack<>();
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch=='{' || ch=='[' || ch=='(' || ch=='*' || ch=='/' || ch=='+'){
                stack.push(ch+"");
            }else if(ch=='-'){
                String peek = stack.peek();
                if("(".equals(peek) || "[".equals(peek) || "{".equals(peek)){
                    String val = "-";
                    while(i<word.length()-1 && Character.isDigit(word.charAt(i+1))){
                        i++;
                        val+=word.charAt(i);
                    }
                    stack.push(val);
                    continue;
                }else{
                    stack.push(ch+"");
                }
            } if(ch==')' || ch==']' || ch=='}'){
                Stack<String> queue = new Stack<String>();
                while(!stack.peek().equals("(") && !stack.peek().equals("[") && !stack.peek().equals("{")){
                    queue.add(stack.pop());
                }
                int res = Integer.valueOf(queue.pop());
                while(!queue.isEmpty()){
                    String operation = queue.pop();
                    int b = Integer.parseInt(queue.pop());
                    if(operation.equals("+")){
                        res+=b;
                    }else if(operation.equals("-")){
                        res-=b;
                    }
                }
                stack.pop();
                if(!stack.isEmpty()){
                    if(stack.peek().equals("*") || stack.peek().equals("/")){
                        String operation = stack.pop();
                        int b = Integer.valueOf(stack.pop());
                        if(operation.equals("*")){
                            res = res*b;
                        }else if(operation.equals("/")){
                            res = b/res;
                        }
                    }
                }
                stack.push(res+"");
            }else if(Character.isDigit(ch)){
                String val = ch+"";
                while(i<word.length()-1 && Character.isDigit(word.charAt(i+1))){
                    i++;
                    val+=word.charAt(i);
                }
                if(!stack.isEmpty() && stack.peek().equals("*")){
                    stack.pop();
                    int a = Integer.parseInt(val);
                    int b = Integer.parseInt(stack.pop());
                    int sum = a*b;
                    stack.push(sum+"");
                }else if(!stack.isEmpty() &&stack.peek().equals("/")){
                    stack.pop();
                    int a = Integer.parseInt(val);
                    int b = Integer.parseInt(stack.pop());
                    int sum = b/a;
                    stack.push(sum+"");
                }else{
                    stack.push(val);
                }
            }
        }
        Stack<String> queue = new Stack<String>();
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        String ch = queue.pop();
        int res = Integer.parseInt(ch);
        while(!queue.isEmpty()){
            String operation = queue.pop();
            int b = Integer.parseInt(queue.pop());
            if(operation.equals("+")){
                res+=b;
            }else if(operation.equals("-")){
                res-=b;
            }
        }
        System.out.println(res);

    }
}
