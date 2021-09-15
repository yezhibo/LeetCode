package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 题目描述：
 * 给定一个整数数组nums，找到一个具有最大和的连续自数组（子数组最少包含一个元素）
 * 返回其最大和
 *
 * 解题思路：
 * 设dp[i]表示以i结尾的最大连续数组和
 * 状态转移方程可表示为：
 *
 * if(dp[i-1]<0) {
 *     dp[i] = nums[i];
 * } else {
 *     dp[i] = dp[i-1] + nums[i]
 * }
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    @Test
    public void test() {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
