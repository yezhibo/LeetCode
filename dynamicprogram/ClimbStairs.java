package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 70.爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 题目描述：
 * 假设你正在爬楼梯，需要n阶你才能到达楼顶
 * 每次你可以爬1或2个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 解题思路：
 * 设dp[i] 表示爬到第i阶的所有不同方法个数，则
 *
 * dp[i] = dp[i-1] + dp[i-2]
 *
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    @Test
    public void test() {
        System.out.println(climbStairs(3));
    }
}
