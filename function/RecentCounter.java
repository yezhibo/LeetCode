package com.yezhibo.leetcode.function;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 933.最近的请求次数
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 *
 * 题目描述：
 * 写一个recenter类来计算特定时间范围内最近的请求
 *
 *
 * 解题思路：
 */
public class RecentCounter {
    private final Queue<Integer> recentTimes;

    public RecentCounter() {
        recentTimes = new PriorityQueue<>();
    }

    public int ping(int t) {
        recentTimes.add(t);
        while (!recentTimes.isEmpty() && t - recentTimes.peek() > 3000) {
            recentTimes.poll();
        }
        return recentTimes.size();
    }

    @Test
    public void test() {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

}
