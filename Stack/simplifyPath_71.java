package com.yezhibo.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class simplifyPath_71 {
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        List<String> invalidPath = Arrays.asList("",".","..");
        Deque<String> stack = new ArrayDeque<String>();
        for (String str : paths) {
            if ("..".equals(str) && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            if (!invalidPath.contains(str)) {
                stack.push(str);
            }
        }
        StringBuilder result = new StringBuilder("/");
        if (stack.size() == 0) {
            return result.toString();
        }
        while (stack.size() > 0) {
            String item = stack.pollLast();
            result.append(item).append("/");
        }
        return result.substring(0, result.length()-1);
    }

    public static void main(String[] args) {
        String input = "/../a/b/";
        System.out.println(simplifyPath(input));
    }
}
