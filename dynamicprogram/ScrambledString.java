package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 87.扰乱字符串
 * https://leetcode-cn.com/problems/scramble-string/
 *
 * 题目描述：
 * 给你两个长度相等的字符串s1和s2，判断s2是否是s1的扰乱字符串，如果是，返回true,
 * 否则返回false；
 *
 * 扰乱字符串定义：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法
 *
 * 判断：
 * 1、如果s1 = s2那么他们是和谐的
 * 2、如果s1.length != s2.length 那他们一定不是和谐的
 * 3、如果s1中某个字符出现次数于s2不一致，那么他们一定不是和谐的
 *
 * 如果s1和s2和谐，那么一定存在一种分割方法s1 = l(s1)+r(s2); s2=l(s2)+r(s2);
 * l(s1)与l(s2)和谐并且 r(s1)与r(s2)和谐；或 l(s1)与r(s2)和谐并且 r(s1)与l(s2)和谐；
 *
 * 解题思路：
 * 设dp[i][j][l]表示 第一个字符串从i开始，第二个字符串从j开始，长度为l的子字符串是否和谐
 * 1表示和谐，-1表示不和谐，0表示未检测过
 *
 */
public class ScrambledString {
    private String s1;
    private String s2;
    private int[][][] dp;
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        dp = new int[s1.length()][s1.length()][s1.length()+1];
        return dfs(0, 0, s1.length());
    }

    public boolean dfs(int i, int j, int l) {
        if (dp[i][j][l] != 0) {
            return dp[i][j][l] == 1;
        }
        if (s1.substring(i, i+l).equals(s2.substring(j, j+l))) {
            dp[i][j][l] = 1;
            return true;
        }
        if (!isCharSimilar(i, j, l)) {
            dp[i][j][l] = -1;
            return false;
        }
        // 遍历子串
        for (int k = 1; k < l; k++) {
            if (dfs(i,j,k) && dfs(i+k, j+k, l-k)) {
                dp[i][j][l] = 1;
                return true;
            }

            if (dfs(i, j+l-k, k) && dfs(i+k, j, l-k)) {
                dp[i][j][l] = 1;
                return true;
            }
        }
        dp[i][j][l] = -1;
        return false;
    }

    private boolean isCharSimilar(int i, int j, int l) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int k = i; k < i+l; k++) {
            freq.put(s1.charAt(k), freq.getOrDefault(s1.charAt(k), 0) + 1);
        }

        for (int k = j; k < j+l; k++) {
            freq.put(s2.charAt(k), freq.getOrDefault(s2.charAt(k), 0) - 1);
        }

        for (Integer value : freq.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("abcde", "caebd"));
    }

}
