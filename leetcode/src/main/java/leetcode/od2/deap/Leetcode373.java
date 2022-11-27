package leetcode.od2.deap;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的 K 对数字 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数 k。 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自
 * nums2。 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
 */
public class Leetcode373 {
    public static void main(String[] args) {
        //
//        int[] nums1 = new int[]{1,7,11};
//        int[] nums2 = new int[]{2,4,6};
        int[] nums1 = new int[]{1,4,11};
        int[] nums2 = new int[]{2,4,6};
        Leetcode373 yb = new Leetcode373();
        yb.kSmallestPairs(nums1,nums2,5);
    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> {
//            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
//        });
//        for(int i=0;i<Math.min(nums1.length,k);i++){
//            queue.add(new int[]{i,0});
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        while (!queue.isEmpty() && k>0) {
//            int[] pair = queue.poll();
//            res.add(List.of(nums1[pair[0]],nums2[pair[1]]));
//            if(pair[1]<nums2.length-1){
//                queue.add(new int[]{pair[0],pair[1]+1});
//            }
//            k--;
//        }
//        return res;
//    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue =
                new PriorityQueue<int[]>(
                        (o1, o2) -> {
                            return nums1[o1[0]] + nums2[o1[1]]- nums1[o2[0]]-nums2[o2[1]];
                        });
        queue.add(new int[]{0,0});
        boolean[][] visited = new boolean[nums1.length][nums2.length];

        LinkedList<List<Integer>> res = new LinkedList<>();
        while(k>0 && queue.size()>0){
            int[] pair = queue.poll();
            int i=pair[0];
            int j=pair[1];
            res.add(List.of(nums1[i],nums2[j]));
            k--;
            if (i + 1 < nums1.length && !visited[i+1][j]){
                queue.add(new int[]{i+1,j});
                visited[i+1][j] = true;
            }
            if(j+1<nums2.length && !visited[i][j+1]){
                queue.add(new int[]{i,j+1});
                visited[i][j+1] = true;
            }

        }
        return res;
    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        // 优先级队列，保存 [index1, index2]
//        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
//
//        // 把 nums1 的所有索引入队，nums2 的索引初始时都是 0
//        // 优化：最多入队 k 个就可以了，因为提示中 k 的范围较小，这样可以提高效率
//        for (int i = 0; i < Math.min(k, nums1.length); i++) {
//            heap.offer(new int[] {i, 0});
//        }
//
//        List<List<Integer>> ans = new ArrayList<>();
//
//        // 最多弹出 k 次
//        while (k-- > 0 && !heap.isEmpty()) {
//            int[] pos = heap.poll();
//
//            ans.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));
//
//            // 将 index2 加 1 之后继续入队
//            if (++pos[1] < nums2.length) {
//                heap.offer(pos);
//            }
//        }
//
//        return ans;
//    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<List<Integer>> queue =
//            new PriorityQueue<List<Integer>>(
//                (o1, o2) -> {
//                  return o2.get(0)+o2.get(1) - o1.get(0)-o1.get(1);
//                });
//        for(int i=0;i<Math.min(nums1.length,k);i++){
//            for(int j=0;j<Math.min(nums2.length,k);j++){
//                if(queue.size()>=k){
//                    List<Integer> arr = queue.peek();
//                    if(arr.get(0)+arr.get(1) > nums1[i]+nums2[j]){
//                        queue.poll();
//                        List<Integer> lst = new ArrayList<>();
//                        lst.add(nums1[i]);
//                        lst.add(nums2[j]);
//                        queue.add(lst);
//                    }
//                }else{
//                    List<Integer> lst = new ArrayList<>();
//                    lst.add(nums1[i]);
//                    lst.add(nums2[j]);
//                    queue.add(lst);
//                }
//            }
//        }
//        LinkedList<List<Integer>> res = new LinkedList<>(queue);
//        return res;
//    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<List<Integer>> queue =
//            new PriorityQueue<List<Integer>>(
//                (o1, o2) -> {
//                  return o2.get(0)+o2.get(1) - o1.get(0)-o1.get(1);
//                });
//        List<int[]> data = new ArrayList<>();
//        data.add(nums1);
//        data.add(nums2);
//        dfs(queue,new ArrayList<>(),data,k,0);
//        LinkedList<List<Integer>> res = new LinkedList<>(queue);
//        return res;
//    }
//
//    public void dfs(PriorityQueue<List<Integer>> queue, List<Integer> path, List<int[]> lst, int k, int idx){
//        if(path.size()==2){
//            if(queue.size()>=k){
//                List<Integer> arr = queue.peek();
//                if(arr.get(0)+arr.get(1) > path.get(0)+path.get(1)){
//                    queue.poll();
//                    queue.add(new ArrayList<>(path));
//                }
//            }else{
//                queue.add(new ArrayList<>(path));
//            }
//        }
//        for(int i=idx;i<lst.size();i++){
//            for(int j=0;j<lst.get(i).length;j++){
//                path.add(lst.get(i)[j]);
//                dfs(queue, path, lst, k, i+1);
//                path.remove(path.size()-1);
//            }
//        }
//    }

//    public void dfs(PriorityQueue<int[]> queue, List<Integer> path, List<int[]> lst, int k, int idx){
//        if(path.size()==2){
//            if(queue.size()>=k){
//                int[] arr = queue.peek();
//                if(arr[0]+arr[1] > path.get(0)+path.get(1)){
//                    queue.poll();
//                    queue.add(new int[]{path.get(0),path.get(1)});
//                }
//            }else{
//                queue.add(new int[]{path.get(0),path.get(1)});
//            }
//            return;
//        }
//        for(int i=idx;i<lst.size();i++){
//            for(int j=0;j<lst.get(i).length;j++){
//                path.add(lst.get(i)[j]);
//                dfs(queue, path, lst, k, idx+1);
//                path.remove(path.size()-1);
//            }
//        }
//    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        int i=0;
//        int j=0;
//        List<Integer> lst = new LinkedList<>();
//        lst.add(nums1[i]);
//        lst.add(nums2[j]);
//        res.add(lst);
//        i++;
//        j++;
//        while (res.size() < k && i < nums1.length && j < nums2.length) {
//            List<Integer> temp = new LinkedList<>();
//            if(nums1[i-1]+nums2[j]>nums1[i]+nums2[j-1]){
//                temp.add(nums1[i]);
//                temp.add(nums2[j-1]);
//                i++;
//                res.add(temp);
//            }else if(nums1[i-1]+nums2[j]==nums1[i]+nums2[j-1]){
//                List<Integer> temp1 = new LinkedList<>();
//                temp1.add(nums1[i]);
//                temp1.add(nums2[j-1]);
//                res.add(temp1);
//
//                List<Integer> temp2 = new LinkedList<>();
//                temp2.add(nums1[i-1]);
//                temp2.add(nums2[j]);
//                res.add(temp2);
//
//                List<Integer> temp3 = new LinkedList<>();
//                temp3.add(nums1[i]);
//                temp3.add(nums2[j]);
//                res.add(temp3);
//                i++;
//                j++;
//            }else{
//                temp.add(nums1[i-1]);
//                temp.add(nums2[j]);
//                j++;
//                res.add(temp);
//            }
//        }
//        while(res.size()< k && i == nums1.length && j < nums2.length){
//            List<Integer> temp = new LinkedList<>();
//            temp.add(nums1[i-1]);
//            temp.add(nums2[j]);
//            res.add(temp);
//            j++;
//        }
//        while(res.size()< k && j == nums2.length && i < nums1.length){
//            List<Integer> temp = new LinkedList<>();
//            temp.add(nums1[i]);
//            temp.add(nums2[j-1]);
//            res.add(temp);
//            i++;
//        }
//        while(res.size()>k){
//            res.remove(res.size()-1);
//        }
//        return res;
//    }
}
