package com.yezhibo.leetcode.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 621.任务调度器
 * https://leetcode-cn.com/problems/task-scheduler/
 *
 * 题目描述：
 * 给你一个用字符数组表示的cpu需要执行的任务列表。其中每个字母表示一种
 * 不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在1个单位时间内
 * 执行完。在任何一个单位时间，cpu可以完成一个任务，或者处于待命状态。
 * 要求：两个相同种类的任务之间必须有长度为整数n的冷却时间，因此至少有连续n
 * 个单位时间内cpu在执行不同的任务，或者在待命
 *
 * 解题思路：
 * 1.统计出每个任务的数量
 * 2.找出任务数最多的数量
 * 3.找出与最多任务数相同的任务数量
 * 4.计算耗时
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char c : tasks) {
            taskCounts[c - 'A']++;
        }
        Arrays.sort(taskCounts);
        int maxSum = taskCounts[25];
        int maxTaskNum = 1;
        for (int i = 24; i >= 0; i--) {
            if (taskCounts[i] == maxSum) {
                maxTaskNum++;
            } else {
                break;
            }
        }
        return Math.max((maxSum-1)*(n+1)+maxTaskNum, tasks.length);
    }

    @Test
    public void test() {
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(tasks, 2));
    }
}
