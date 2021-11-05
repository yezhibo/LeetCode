package com.yezhibo.leetcode.bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2059.转换数字的最小操作数
 * https://leetcode-cn.com/problems/minimum-operations-to-convert-number/
 *
 * 解题思路：
 * 采用BFS从一开始，遍历数组中所有数，记录每个数的操作次数
 * 如果计算结果不在[0,1000]范围内，则终止
 */
public class MinimumOperation {
    int goal;
    boolean[] visited;
    Queue<int[]> queue;
    public int minimumOperations(int[] nums, int start, int goal) {
        queue = new LinkedList<>();
        visited = new boolean[1001];
        this.goal = goal;
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int num = pair[0];
            int time = pair[1];
            if (num == goal) {
                return time;
            }
            for (int j : nums) {
                int add = num + j;
                int del = num - j;
                int xor = num ^ j;
                if (isFinished(add, time) || isFinished(del, time) || isFinished(xor, time)) {
                    return time + 1;
                }
            }
        }
        return -1;
    }

    private boolean isFinished(int num, int time) {
        if (num == goal) {
            return true;
        }
        if (num >= 0 && num <= 1000 && !visited[num]) {
            visited[num] = true;
            queue.add(new int[]{num, time + 1});
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(minimumOperations(new int[]{1,3}, 6, 4));
        System.out.println(minimumOperations(new int[]{2,4,12}, 2, 12));
    }
}
