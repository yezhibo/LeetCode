package com.yezhibo.leetcode.string;

/**
 * 最长回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        String ans = "";
        for(int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    isPalindrome[i][j] = true;
                } else if (l == 1 && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                } else {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1];
                }
                if (isPalindrome[i][j] && l+1 > ans.length()) {
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;

    }
}
