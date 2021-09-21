package com.yezhibo.leetcode.queue;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1046.最后一块石头的重量
 * https://leetcode-cn.com/problems/last-stone-weight/
 *
 * 题目描述：
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 *
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 解题思路：
 * 利用优先级队列
 *
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> remainStones = new PriorityQueue<>((a, b) -> b - a);
        for (int weight : stones) {
            remainStones.add(weight);
        }
        while (!remainStones.isEmpty() && remainStones.size() > 1) {
            int firstMax = remainStones.poll();
            int secondMax = remainStones.poll();
            if (firstMax != secondMax) {
                remainStones.add(firstMax - secondMax);
            }
        }
        return remainStones.isEmpty() ? 0 : remainStones.peek();
    }

    @Test
    public void test() {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
