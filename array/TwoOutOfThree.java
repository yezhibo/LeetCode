package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.*;

/**
 * 2032.至少在两个数组中出现的值
 * https://leetcode-cn.com/problems/two-out-of-three/
 *
 */
public class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[][] numFreq = new int[105][3];
        count(0, nums1, numFreq);
        count(1, nums2, numFreq);
        count(2, nums3, numFreq);
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (numFreq[i][0] + numFreq[i][1] + numFreq[i][2] >= 2) {
                result.add(i);
            }
        }
        return result;
    }

    private void count(int index, int[] nums, int[][] numFreq) {
        for (int num : nums) {
            numFreq[num][index] = 1;
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(twoOutOfThree(new int[]{1,1,3,2}, new int[]{2,3}, new int[]{3}).toArray()));
    }
}
