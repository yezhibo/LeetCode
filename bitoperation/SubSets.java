package com.yezhibo.leetcode.bitoperation;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result.size());
    }
}
