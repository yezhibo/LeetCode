package com.yezhibo.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 5899.两个最好的不重叠活动
 * https://leetcode-cn.com/problems/two-best-non-overlapping-events/
 */
public class MaxValEvents {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int ans = 0;
        int max = 0;
        for(int[] e : events){
            int start = e[0];
            int end = e[1];
            int val = e[2];
            while(que.size() > 0 && que.peek()[1] < start){
                max = Math.max(max, que.poll()[2]);
            }
            ans = Math.max(ans, max + val);
            que.offer(e);
        }
        return ans;
    }
}
