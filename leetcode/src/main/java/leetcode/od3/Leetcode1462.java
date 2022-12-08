package leetcode.od3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 1462. 课程表 IV
 * <p>
 * 你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，
 * 其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
 * 有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
 * 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，
 * 那么课程 a 就是课程 c 的先决条件。
 * 你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，
 * 您应该回答课程 uj 是否是课程 vj 的先决条件。
 * 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 */
public class Leetcode1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] degree = new int[numCourses];
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i=0;i< prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            if(graph.containsKey(prerequisites[i][0])){
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(prerequisites[i][1]);
                graph.put(prerequisites[i][0],set);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            int num = queue.poll();
        }
        return null;
    }
}
