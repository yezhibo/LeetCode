package com.yezhibo.leetcode.array;

/**
 * 2057.值相等的最小索引
 * https://leetcode-cn.com/problems/smallest-index-with-equal-value/
 *
 */
public class SmallestIndex {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i%10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
