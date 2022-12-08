package leetcode.od3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 310. 最小高度树
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。
 * 给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。
 * 在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 */
public class Leetcode310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return List.of(0);
        }
        int[] degree = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==1){
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int len = queue.size();
            for(int k=0;k<len;k++){
                int num = queue.poll();
                res.add(num);
                List<Integer> lst = map.get(num);
                for(int i=0;i<lst.size();i++){
                    degree[lst.get(i)]--;
                    if(degree[lst.get(i)]==1){
                        queue.offer(lst.get(i));
                    }
                }
            }
        }
        return res;
    }
}
