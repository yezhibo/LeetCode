package com.yezhibo.leetcode.integer;

import org.junit.Test;

/**
 * 8.字符串转整数
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * 题目描述：
 * 请你实现一个函数，使其能将一个字符串转成一个32位有符号整数
 *
 *
 * 解题思路：
 * 1、去除前边无用空格
 * 2、检查第一个字符为正号还是负号
 * 3、读入下一个字符，直到到达输入的末尾，剩余的被忽略
 * 4、将前边输入的数字转为整数
 */
public class MyAtoi {
    public static int myAtoi(String s) {
        s = removePreBlanks(s);
        if ( s.isEmpty()) {
            return 0;
        }
        int startIndex = 0;
        boolean isPositive = true;
        if (s.charAt(0) == '+') {
            startIndex = 1;
        } else if (s.charAt(0) == '-') {
            startIndex = 1;
            isPositive = false;
        }

        StringBuilder nums = new StringBuilder();
        for (int i = startIndex; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            nums.append(s.charAt(i));
        }

        if (nums.length() > 10) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        long result = 0;
        for (int i = 0; i < nums.length(); i++) {
            result += Integer.parseInt(String.valueOf(nums.charAt(i))) * Math.pow(10, nums.length()-i-1);
        }

        if (!isPositive) {
            result = -1 * result;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int)result;
    }

    public static String removePreBlanks(String s) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!= ' ' && s.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        return s.substring(start);
    }

    @Test
    public void test() {
        System.out.println(myAtoi("4193 with word"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }
}
