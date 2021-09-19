package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 91.解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * 题目描述：
 * 一条包含字母A-Z的消息通过以下映射进行了编码：
 * A -> 1
 * B -> 2
 * .
 * .
 * .
 * Z -> 26
 *
 * 要解码已编码的消息，所有数字必须基于上述映射方法反向映射回字母（可能有多种方法）
 * 给你一个只包含数字的非空字符串s，请你返回解码方法的总数
 *
 * 解题思路：
 * 这个题目有点类似爬楼梯，单次可以走一步，也可以走两步，走两步的前提是数字和小于26，并且不能以0开头
 * 如果第i个字符为0，则前一个字符必须为1，否则不合法
 *
 * 设dp[i] 表示前i个点解码方法的总数，则有递推方程
 * if(s[i] == 0) {
 *     if (s[i-1] != 1) {
 *         return 0;
 *     }
 *     dp[i] = dp[i-1];
 * }
 * if (s[i-1] == 0 || s[i-1]s[i] > 26) {
 *     dp[i] = dp[i-1];
 * }
 *
 * dp[i] = dp[i-2] + dp[i-1];
 *
 *
 * 思路2：官方解法：
 * 设dp[i]表示前i个点解码方法的总数，则有两种情况：
 * 1、使用一个字符
 * if (s[i] != 0) {
 *     dp[i] += dp[i-1];
 * }
 * 2、使用两个字符
 * if (s[i-1] != 0 && s[i-1]s[i] <= 26) {
 *     dp[i] += dp[i-2]
 * }
 *
 * 技巧：实现默认字符前有个空，则前两个数字也可以走正常流程
 * 优点：无需考虑异常情况， 只管当前是否合法
 *
 */
public class DecodeNum {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (s.charAt(1) == '0' && s.charAt(0) != '1'&& s.charAt(0) != '2') {
            return 0;
        }
        dp[1] = s.charAt(1) == '0' || Integer.parseInt(s.substring(0, 2)) > 26 ? 1 : 2;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i-1) != '1'&& s.charAt(i-1) != '2') {
                return 0;
            }
            if (s.charAt(i) == '0') {
                dp[i] = dp[i-2];
                continue;
            }
            if (s.charAt(i-1) == '0' || Integer.parseInt(s.substring(i-1, i+1)) > 26) {
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[s.length()-1];
    }

    public int numDecodings1(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            if (i > 1 && s.charAt(i-2) != '0' && Integer.parseInt(s.substring(i-2, i)) <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test() {
        /*System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("06"));*/
        //System.out.println(numDecodings("2101"));
        //System.out.println(numDecodings("1201234"));
        System.out.println(numDecodings1("1201234"));
    }
}
