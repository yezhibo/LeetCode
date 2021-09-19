package com.yezhibo.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，输出无重复字符的最长字串
 * 思路：利用滑动窗口的方法
 */
public class LongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int maxLength = 0;
        int rl = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i>0){
                occ.remove(s.charAt(i-1));
            }
            while (rl < n && !occ.contains(s.charAt(rl))) {
                occ.add(s.charAt(rl));
                rl++;
            }
            maxLength = Math.max(maxLength, occ.size());
        }
        return maxLength; 
    }
    
}
