package com.yezhibo.leetcode.dfs;

import org.junit.Test;

/**
 * 2044.统计按位或能得到最大值的子集数目
 * https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 */
public class NumbersOfMaxSubset {
    int max;
    int result;
    int size;
    int[] nums;
    public int countMaxOrSubsets(int[] nums) {
        max = getMaxOrNum(nums);
        this.size = nums.length;
        this.nums = nums;
        dfs(0, 0);
        return result;
    }

    public int getMaxOrNum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum |= num;
        }
        return sum;
    }

    public void dfs(int idx, int cur) {
        if (cur >= max) {
            result += 1 << (size - idx);
            return;
        }
        if (idx == size) {
            return;
        }
        dfs(idx+1, cur | nums[idx]);
        dfs(idx+1, cur);
    }

    @Test
    public void test() {
        System.out.println(countMaxOrSubsets(new int[]{3,2,1,5}));
    }
}
