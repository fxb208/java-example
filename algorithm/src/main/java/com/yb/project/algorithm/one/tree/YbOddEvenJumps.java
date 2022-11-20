package com.yb.project.algorithm.one.tree;

import java.util.TreeMap;

/**
 * leetcode 975. 奇偶跳
 * @author fxb20
 * 给定一个整数数组 A，你可以从某一起始索引出发，跳跃一定次数。
 * 在你跳跃的过程中，第 1、3、5... 次跳跃称为奇数跳跃，而第 2、4、6... 次跳跃称为偶数跳跃。
 * 你可以按以下方式从索引 i 向后跳转到索引 j（其中 i < j）：
 * 	在进行奇数跳跃时（如，第 1，3，5... 次跳跃），你将会跳到索引 j，使得 A[i] <= A[j]，A[j] 是可能的最小值。
 * 如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 *  在进行偶数跳跃时（如，第 2，4，6... 次跳跃），你将会跳到索引 j，使得 A[i] >= A[j]，A[j] 是可能的最大值。
 * 如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 * 
 * （对于某些索引 i，可能无法进行合乎要求的跳跃。）
 * 如果从某一索引开始跳跃一定次数（可能是 0 次或多次），就可以到达数组的末尾（索引 A.length - 1），
 * 那么该索引就会被认为是好的起始索引。
 * 返回好的起始索引的数量。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/odd-even-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbOddEvenJumps {
	
	public static void main(String[] args) {
		YbOddEvenJumps yb=new YbOddEvenJumps();
		int[] arr=new int[] {10,13,12,14,15};
		yb.oddEvenJumps(arr);
	}
	
	/**
	 * 输入：[10,13,12,14,15]
	 * 输出：2
	 * 解释： 
	 * 	从起始索引 i = 0 出发，我们可以跳到 i = 2，（因为 A[2] 是 A[1]，A[2]，A[3]，A[4] 中大于或等于 A[0] 的最小值），然后我们就无法继续跳下去了。
	 * 从起始索引 i = 1 和 i = 2 出发，我们可以跳到 i = 3，然后我们就无法继续跳下去了。
	 * 从起始索引 i = 3 出发，我们可以跳到 i = 4，到达数组末尾。
	 * 从起始索引 i = 4 出发，我们已经到达数组末尾。
	 * 总之，我们可以从 2 个不同的起始索引（i = 3, i = 4）出发，通过一定数量的跳跃到达数组末尾。
	 * @param arr
	 * @return
	 */
    public int oddEvenJumps(int[] arr) {
        int N = arr.length;
        if (N <= 1) return N;
        //奇数跳
        boolean[] odd = new boolean[N]; 
        //偶数跳
        boolean[] even = new boolean[N];
        odd[N-1] = even[N-1] = true;

        TreeMap<Integer, Integer> vals = new TreeMap<Integer, Integer>();
        vals.put(arr[N-1], N-1);
        for (int i = N-2; i >= 0; --i) {
            int v = arr[i];
            if (vals.containsKey(v)) {
                odd[i] = even[vals.get(v)];
                even[i] = odd[vals.get(v)];
            } else {
                Integer lower = vals.lowerKey(v);
                Integer higher = vals.higherKey(v);

                if (lower != null)
                    even[i] = odd[vals.get(lower)];
                if (higher != null) {
                    odd[i] = even[vals.get(higher)];
                }
            }
            vals.put(v, i);
        }

        int ans = 0;
        for (boolean b: odd)
            if (b) ans++;
        return ans;

    }
}
