package leetcode.od.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。
 * 如果不可能完成所有课程，返回 一个空数组 。
 */
public class Leetcode210 {
    public static void main(String[] args) {
        Leetcode210 yb = new Leetcode210();
        //numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        yb.findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> lst = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            lst.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for(int[] arr:prerequisites){
            lst.get(arr[1]).add(arr[0]);
            degree[arr[0]]+=1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int idx = queue.poll();
            result[index]= idx;
            index++;
            List<Integer> integers = lst.get(idx);
            for(Integer numCourse: integers){
                degree[numCourse]-=1;
                if(degree[numCourse]==0){
                    queue.add(numCourse);
                }
            }
        }
        if(index==numCourses){
            return result;
        }
        return new int[]{};
    }
}
