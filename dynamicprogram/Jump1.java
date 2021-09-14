package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 题目描述：
 * 给定一个非负整数数组nums，你最初位于数组的第一个下标；数组中的每个元素表示你在该位置可以跳跃的最大长度
 * 判断你是否能够到达最后一个下标；
 *
 * 解题思路：
 * 能否达到的问题一般使用dfs
 *
 * 遍历每个点和点对应的最大跳跃距离，维护一个最远具体的值，如果当前遍历下标超出最远距离，就说明有达不到的点，否则证明可以达到
 *
 */
public class Jump1 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
    }
}
