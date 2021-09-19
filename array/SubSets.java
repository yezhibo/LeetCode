package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集
 * https://leetcode-cn.com/problems/subsets/
 *
 * 题目描述：
 * 给你一个整数数组nums，数组中的元素互不相同。放回数组所有可能的子集
 *
 * 解题思路：
 * 记原序列中元素的总数为n，原序列中每个数字的状态可能有两种：在子集中和不在子集中；
 * 用1表示在子集中，0表示不在子集中，那么每个子集可以对应一个长度为n的0/1序列；
 * 可以发现n个数字的二进制数正好从0 - 2^n-1，枚举完所有的掩码即可构造所有子集
 */
public class SubSets {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < 1 << n; mask++) {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    subList.add(nums[i]);
                }
            }
            result.add(subList);
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result.size());
    }
}
