package leetcode.od2.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 */
public class Leetcode946 {

    public static void main(String[] args) {
        //
        Leetcode946 yb = new Leetcode946();
//        int[] pushed=new int[]{6,13,4,14,0,12,10,8,5,7,3,2,9,1,11};
//        int[] popped=new int[]{9,10,6,11,14,13,2,0,3,5,4,8,1,7,12};
        int[] pushed=new int[]{1,2,3,4,5};
        int[] popped=new int[]{4,5,3,2,1};
        System.out.println(yb.validateStackSequences(pushed,popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0, j=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(stack.size()>0 && stack.peek().equals(popped[j])){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences_timeout(int[] pushed, int[] popped) {
        return backtrack(new ArrayList<>(), new Stack<>(), pushed, popped, 0);
    }

    public boolean backtrack(List<Integer> lst, Stack<Integer> stack, int[] pushed,int[] popped,  int idx){
        if(lst.size()==pushed.length){
            boolean res = true;
            for(int i=0;i<lst.size();i++){
                if(!lst.get(i).equals(popped[i])){
                    res = false;
                    break;
                }
            }
            if(res){
                return res;
            }
        }
        if(!stack.isEmpty()){
            int temp = stack.pop();
            lst.add(temp);
            boolean pop = backtrack(lst,stack,pushed,popped,idx);
            if(pop){
                return pop;
            }
            lst.remove(lst.size()-1);
            stack.push(temp);
        }
        if(idx<pushed.length){
            stack.push(pushed[idx]);
            boolean push = backtrack(lst,stack,pushed,popped,idx+1);
            if(push){
                return push;
            }
            stack.pop();
        }
        return false;
    }

//    public void backtrack(List<List<Integer>> res,List<Integer> lst, Stack<Integer> stack, int[] pushed,int[] popped,  int idx){
//        if(lst.size()==pushed.length){
//            boolean bool = true;
//            for(int i=0;i<lst.size();i++){
//                if(!lst.get(i).equals(popped[i])){
//                    bool = false;
//                    break;
//                }
//            }
//            if(bool){
//                res.add(lst);
//            }
//        }
//        if(!stack.isEmpty()){
//            int temp = stack.pop();
//            lst.add(temp);
//            backtrack(res,lst,stack,pushed,popped,idx);
//            lst.remove(lst.size()-1);
//            stack.push(temp);
//        }
//        if(idx<pushed.length){
//            stack.push(pushed[idx]);
//            backtrack(res,lst,stack,pushed,popped,idx+1);
//            stack.pop();
//        }
//    }
}
