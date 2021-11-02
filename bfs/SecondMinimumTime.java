package com.yezhibo.leetcode.bfs;

import org.junit.Test;

import java.util.*;

/**
 * 2045.到达目的的第二短时间
 * https://leetcode-cn.com/problems/second-minimum-time-to-reach-destination/
 *
 * 解题思路：
 * 先利用bfs求出第二短路径，然后在计算时间
 */
public class SecondMinimumTime {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int min = 0;
    int secondMin = 0;
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
        }
        bfs(n);
        return calculateTime(time, change);
    }

    public void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int step = 0;
        int breadLength = 1;
        while (!queue.isEmpty()) {
            step++;
            int tmp = 0;
            for (int i = 0; i < breadLength; i++) {
                List<Integer> nextSteps = map.get(queue.poll());
                if (nextSteps == null) {
                    continue;
                }
                for (int val : nextSteps) {
                    queue.add(val);
                    tmp++;
                    if (val == n) {
                        if (min == 0) {
                            min = step;
                        } else if (min < step) {
                            secondMin = step;
                        }
                    }
                    if (secondMin != 0) {
                        return;
                    }
                }
            }
            breadLength = tmp;
        }
    }

    public int calculateTime(int time, int change) {
        if (secondMin == 0) {
            secondMin = min + 2;
        }
        if (time * secondMin < change) {
            return time * secondMin;
        }
        int remain = 0;
        int step = 1;
        if(time < change) {
            step = (int)Math.ceil((double)change / time);
        }
        remain = time*step % change == 0 ? 0 : change - (time*step % change);
        int n = (int)Math.ceil((double)secondMin / step) - 1;
        return time * secondMin + n * remain;
    }

    @Test
    public void test() {
        //System.out.println(secondMinimum(5, new int[][]{{1,2},{1,3},{1,4},{3,4},{4,5}}, 3, 5));
        //System.out.println(secondMinimum(6, new int[][]{{1,2},{1,3},{2,4},{3,5},{5,4},{4,6}}, 3, 100));
        System.out.println(secondMinimum(2, new int[][]{{1,2}}, 2, 1));
    }
}
