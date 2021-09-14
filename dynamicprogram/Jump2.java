package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * 题目描述：
 * 给你一个非负整数数组nums，你最初位于数组的第一个位置。数组中的每个元素表示你在该位置可以跳跃的最大长度；
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置，假设你总是可以到达数组的最后一个位置；
 *
 * 解题思路：
 * 采用bfs
 * 将数组的每个坐标看作是图中的点，数组值表示不同点之间的关联关系
 */
public class Jump2 {
    public int jump(int[] nums) {
        int[] minStep = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            minStep[i] = findMinStep(minStep, nums, i);
        }
        return minStep[0];
    }

    private int findMinStep(int[] minStep, int[] nums, int index) {
        int min = nums.length;
        int maxStep = Math.min(nums[index], nums.length - index - 1);
        for (int i = 1; i<=maxStep; i++) {
            min = Math.min(min, minStep[index+i] + 1);
        }
        return min;
    }


    @Test
    public void test() {
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));
    }
}
