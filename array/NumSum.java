package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.24 数对和
 * https://leetcode-cn.com/problems/pairs-with-sum-lcci/
 * 题目描述：
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对，一个数只能属于一个数对
 *
 * 解题思路：
 * 首先将数组数据按从小到大顺序排序，然后从头开始遍历
 *
 */
public class NumSum {
    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || target <= nums[0]) {
            return result;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            int ans = nums[right] + nums[left];
            if(ans < target) {
                left++;
            } else if (ans > target) {
                right--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                left++;
                right--;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] input = new int[]{5,6,5};
        int target = 11;
        System.out.println(pairSums(input, target));
    }
}
