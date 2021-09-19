package com.yezhibo.leetcode.integer;

import org.junit.Test;

/**
 * 9.回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * 题目描述：
 * 给你一个整数x，如果x是一个回文数，返回true，否则返回false
 * 回文数是指正序和倒序读都是一样的整数
 *
 * 解题思路：
 * 1、将整数拆分成两半，判断这两个整数是否相等
 *
 * 特殊情况：
 * 1）负数不可能为回文数
 * 2）结尾为0的不可能为回文数
 */
public class PalindromicNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverseNum = 0;
        do {
            int tmp = x % 10;
            x /= 10;
            reverseNum = reverseNum * 10 + tmp;
        } while (x > reverseNum);
        return x == reverseNum || x == reverseNum / 10;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(5));
    }
}
