package com.yezhibo.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid_20 {
    public static boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (pair.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(pair.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
