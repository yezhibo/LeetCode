package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 2050.并行课程3
 * https://leetcode-cn.com/problems/parallel-courses-iii/
 *
 * 利用动态规划，设dp[i]表示完成第i+1门课程需要花费的时间，则
 * dp[i+1] = max(dp[i]) + time[i+1];  i为 i+1 依赖的前置课程
 *
 * 最终求出dp中最大值极为所有课程修完花费的时间
 */
public class ParallelCourses {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // 1、将课程依赖关系转储为List<Integer>[]，并统计每个点的入度
        Map<Integer, List<Integer>> nextNodeMap = new HashMap<>();
        int[] inDegree = new int[n];
        for (int[] edge : relations) {
            int preNode = edge[0] - 1;
            int nextNode = edge[1] - 1;
            nextNodeMap.computeIfAbsent(preNode, key -> new ArrayList<>()).add(nextNode);
            inDegree[nextNode]++;
        }
        // 2、将入度为0的点选出来，并初始化对应的dp值，作为第一层遍历的点
        int[] dp = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                dp[i] = time[i];
                queue.add(i);
            }
        }
        // 3、开始遍历，每遍历完一个点，需要把它后置点入度减1，当点的入度为0时，表示其前置节点已遍历完，可以开始进入下一层
        int ans = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans = Math.max(ans, dp[node]);
            List<Integer> nextNodes = nextNodeMap.getOrDefault(node, new ArrayList<>());
            for (Integer nextNode : nextNodes) {
                dp[nextNode] = Math.max(dp[nextNode], dp[node] + time[nextNode]);
                ans = Math.max(ans, dp[nextNode]);
                if (--inDegree[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(minimumTime(1, new int[][]{}, new int[]{1}));
    }
}
