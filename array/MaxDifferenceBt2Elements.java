package com.yezhibo.leetcode.array;

/**
 * 2016.增量元素之间的最大差值
 * https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/
 *
 */
public class MaxDifferenceBt2Elements {
    public int maximumDifference(int[] nums) {
        int result = -1;
        int left = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= left) {
                left = nums[i];
                continue;
            }
            result = Math.max(result, nums[i] - left);
        }
        return result;
    }
}
