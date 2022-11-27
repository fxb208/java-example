package leetcode.od2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 726. 原子的数量
 *
 * 给你一个字符串化学式 formula ，返回 每种原子的数量 。
 * 原子总是以一个大写字母开始，接着跟随 0 个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。
 * 例如，"H2O" 和 "H2O2" 是可行的，但 "H1O2" 这个表达是不可行的。 两个化学式连在一起可以构成新的化学式。
 * 例如 "H2O2He3Mg4" 也是化学式。 由括号括起的化学式并佐以数字（可选择性添加）也是化学式。
 *
 * 例如 "(H2O2)" 和 "(H2O2)3" 是化学式。
 * 返回所有原子的数量，格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于
 * 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 */
public class Leetcode726 {
    public static void main(String[] args) {
        //
        Leetcode726 yb = new Leetcode726();
        System.out.println(yb.countOfAtoms("K4(ON(SO3)2)2"));
    }

    public String countOfAtoms(String formula) {
        Map<String,Integer> map = new HashMap<>();
        Deque<String> stack = new LinkedList<>();
        int deep = 0;
        for(int i=0;i<formula.length();i++){
            char ch = formula.charAt(i);
            if(ch=='('){
                deep++;
                stack.push("(");
            }else if(ch==')'){
                deep--;
                StringBuilder countTemp = new StringBuilder();
                while(i+1<formula.length() && Character.isDigit(formula.charAt(i+1))){
                    i++;
                    countTemp.append(formula.charAt(i));
                }
                int times = 1;
                if(countTemp.length()>0){
                    times = Integer.valueOf(countTemp.toString());
                }
                if(deep==0){
                    while(!stack.peek().equals("(")){
                        String key = stack.poll();
                        map.put(key,map.getOrDefault(key,0)+times);
                    }
                    stack.poll();
                }else{
                    Deque<String> temp = new LinkedList<>();
                    while(!stack.peek().equals("(")){
                        String key = stack.poll();
                        for(int j=0;j<times;j++){
                            temp.push(key);
                        }
                    }
                    stack.poll();
                    while(!temp.isEmpty()){
                        stack.push(temp.poll());
                    }
                }
            }else if(Character.isUpperCase(ch)){
                StringBuilder temp = new StringBuilder();
                temp.append(ch);
                while(i+1<formula.length() && Character.isLowerCase(formula.charAt(i+1))){
                    i++;
                    temp.append(formula.charAt(i));
                }
                stack.push(temp.toString());

                StringBuilder countTemp = new StringBuilder();
                while(i+1<formula.length() && Character.isDigit(formula.charAt(i+1))){
                    i++;
                    countTemp.append(formula.charAt(i));
                }
                //
                String key = stack.poll();
                int times = 1;
                if(countTemp.length()>0){
                    times = Integer.valueOf(countTemp.toString());
                }
                if(deep==0){
                    map.put(key,map.getOrDefault(key,0)+times);
                }else{
                    for(int j=0;j<times;j++){
                        stack.push(key);
                    }
                }
            }
        }
        Set<String> set = map.keySet();
        List<String> lst = new ArrayList<>(set);
        Collections.sort(lst);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<lst.size();i++){
            sb.append(lst.get(i));
            Integer val = map.get(lst.get(i));
            if(val>1){
                sb.append(val);
            }
        }
        return sb.toString();
    }
}
