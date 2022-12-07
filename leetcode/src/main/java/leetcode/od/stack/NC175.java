package leetcode.od.stack;

import java.util.LinkedList;

/**
 *  NC175 合法的括号字符串
 */
public class NC175 {

    public static void main(String[] args) {
        NC175 yb = new NC175();
        yb.isValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");
    }

    /**
     *
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValidString (String s) {
        if(s.isBlank()){
            return true;
        }
        // write code here
        LinkedList<Integer> lst1= new LinkedList<>();
        LinkedList<Integer> lst2= new LinkedList<>();
        boolean res = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                lst1.add(i);
            }else if(s.charAt(i)=='*'){
                lst2.add(i);
            }else{
                if(lst1.size()>0){
                    lst1.pollLast();
                }else if(lst2.size()>0){
                    lst2.pollLast();
                }else{
                    res = false;
                    break;
                }

            }
        }
        if(res){
            if(lst1.size()>lst2.size()){
                res = false;
            }else{
                while(lst1.size()>0){
                    if(lst1.pollLast()>lst2.pollLast()){
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
