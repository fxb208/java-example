package leetcode.fabu.day1;

import java.util.LinkedList;

/**
 * 735. 行星碰撞
 * https://leetcode.cn/problems/asteroid-collision/
 */
public class YbAsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            while(stack.peekLast() != null && stack.peekLast()>0 && asteroids[i] < 0 && Math.abs(stack.peekLast()) < Math.abs(asteroids[i])){
                stack.pollLast();
            }
            if(stack.peekLast() != null && asteroids[i]<0 && stack.peekLast() + asteroids[i] == 0 ){
                stack.pollLast();
            } else if(stack.peekLast() == null || stack.peekLast()<0 || asteroids[i]>0 ){
                stack.add(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while(stack.size()>0){
            result[index]=stack.pollFirst();
            index++;
        }
        return result;
    }
}
