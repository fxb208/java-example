package leetcode.jianzhi;

import java.util.Stack;

/**
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 *
 */
public class offer09 {
    public static void main(String[] args) {
        //
        CQueue queue = new CQueue();
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    static class CQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            if(!temp.isEmpty()){
                int val = temp.pop();
                while(!temp.isEmpty()){
                    stack.push(temp.pop());
                }
                return val;
            }else{
                return -1;
            }

        }
    }

}
