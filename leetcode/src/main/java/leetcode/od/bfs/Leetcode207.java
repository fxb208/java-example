package leetcode.od.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class Leetcode207 {
    public static void main(String[] args) {
        // numCourses = 2, prerequisites = [[1,0],[0,1]]
        Leetcode207 yb = new Leetcode207();
        //yb.canFinish(2,new int[][]{{1,0},{0,1}});
        yb.canFinish(2,new int[][]{{0,1}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int visit=0;
        while(!queue.isEmpty()){
            visit++;
            int idx = queue.poll();
            List<Integer> integers = lst.get(idx);
            for(Integer integer: integers){
                degree[integer]-=1;
                if(degree[integer]==0){
                    queue.add(integer);
                }
            }
        }
        return visit==numCourses;
    }
}
