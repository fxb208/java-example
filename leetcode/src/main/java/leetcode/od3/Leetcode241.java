package leetcode.od3;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，
 * 计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 */
public class Leetcode241 {
    public static void main(String[] args) {
        Leetcode241 yb = new Leetcode241();
        List<Integer> res = yb.diffWaysToCompute("2-1-1");
        System.out.println(res);
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        int begin = 0;
        while(begin<expression.length()){
            if(Character.isDigit(expression.charAt(begin))){
                begin++;
            }else{
                break;
            }
        }
        if(begin==expression.length()){
            res.add(Integer.valueOf(expression));
            return res;
        }
        for(int i=begin;i<expression.length();i++){
            if(!Character.isDigit(expression.charAt(i))){
                char operate=expression.charAt(i);
                List<Integer> lefts = diffWaysToCompute(expression.substring(0,i));
                List<Integer> rights = diffWaysToCompute(expression.substring(i+1));
                for(Integer left :lefts){
                    for(Integer right: rights){
                        if(operate=='+'){
                            res.add(left+right);
                        }else if(operate=='-'){
                            res.add(left-right);
                        }else{
                            res.add(left*right);
                        }
                    }
                }
            }
        }
        return res;
    }
}
