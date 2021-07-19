package com.yezhibo.leetcode.dichotomy;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 题目描述：
 * 输入两个数组，计算数组的中位数
 * 中位数：总树是奇数的化，中间那个，总数是偶数的话取中间两个数的平均值
 *
 */
public class FindMedianSortedArrays {

    /**
     * 方法1：
     *  1、首先计算出中位数的下标
     *  2、通过双指针的方式来同时遍历两个数组，直到拿到指定下标的数据为止
     *
     *  为了更好的让奇数偶数取走相同代码流程，这里定义两个变量 left right 存储两个中间数据 len/2  len/2 + 1
     *  如果是奇数个取第 len/2 + 1个数，偶数个取两个数的平均值
     *
     *  边界条件：如果第一个数组没有越界 并且第一个数值小于第二个 挪动第一个下标 否则挪动第二个下标，当第二个越界是，继续挪动第一个
     *  时间复杂度O(m+n)
     */
    public static double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int left = -1;
        int right = -1;
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int aStart = 0;
        int bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart == n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len&1) == 0) {
            return (double)(left + right) / 2;
        } else {
            return right;
        }
    }

    /**
     * 方法2：
     * 为了达到时间复杂度为O(log(m+n)) 需要采用二分法
     *
     */
    public static double findMedianSortedArrays_2(int[] nums1, int[] nums2) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{4};
        System.out.println(findMedianSortedArrays_1(nums1, nums2));
    }
}
