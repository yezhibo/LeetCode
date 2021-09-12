package com.yezhibo.leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述：
 * 给定一个数字n，求出n对括号所有有效组合
 *
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 当前括号对是否有效：
 *
 *
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        step(new char[2*n], 0, result);
        return result;
    }

    public void step(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
            return;
        }
        current[pos] = '(';
        step(current, pos +1, result);
        current[pos] = ')';
        step(current, pos + 1, result);
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance ++;
            } else {
                balance--;
            }
            if (balance <0) {
                return false;
            }
        }
        return balance == 0;
    }

    @Test
    public void test() {
        List<String> result = generateParenthesis(10);
        System.out.println(result.size());
    }
}
