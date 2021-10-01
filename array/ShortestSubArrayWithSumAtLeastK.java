package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 862.和至少为k的最短子数组
 * https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
 *
 * 题目描述：
 * 返回A的最短的非空连续自数组的长度，该子数组的和至少为K
 * 如果没有和为K的非空子数组，返回-1
 *
 * 解题思路：
 * 设dp[i][j] 表示i到j之间数组的和
 * 则dp[i][j] = dp[i][j-1] + A[j]
 * 占用空间太大
 *
 * 方案2：
 * 采用滑动窗口的方式
 *
 * 1、先算出数组的每个值的前缀和
 * 2、定义一个双端队列来存储递增和，并只存储当前值大于k的，最后遍历出最小的
 */
public class ShortestSubArrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            if (dp[i][i] >= k) {
                return 1;
            }
        }
        for (int l = 1; l < nums.length; l++) {
            for (int i = 0; i+l < nums.length; i++) {
                dp[i][i+l] = dp[i][i+l-1] + nums[i+l];
                if (dp[i][i+l] >= k) {
                    return l+1;
                }
            }
        }
        return -1;
    }

    public int shortSubArray(int[] nums, int k) {
        int[] preSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSums[i+1] = preSums[i] + nums[i];
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int ans = nums.length + 1;
        for (int i = 0; i < preSums.length; i++) {
            while (!queue.isEmpty() && preSums[i] <= preSums[queue.getLast()]) {
                queue.removeLast();
            }
            while (!queue.isEmpty() && preSums[i] - preSums[queue.getFirst()] >= k) {
                ans = Math.min(ans, i - queue.removeFirst());
            }
            queue.add(i);
        }
        return ans > nums.length ? -1 : ans;
    }

    @Test
    public void test() {
        /*System.out.println(shortestSubarray(new int[]{1}, 1));
        System.out.println(shortestSubarray(new int[]{1,2}, 4));
        System.out.println(shortSubArray(new int[]{2,-1,2}, 3));*/
        System.out.println(shortSubArray(new int[]{84,-37,32,40,95},167));
    }
}
