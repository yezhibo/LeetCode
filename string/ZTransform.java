package com.yezhibo.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 6.z字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * 题目描述：
 * 将一个给定字符串s根据给定的行数numRows，以从上往下、从左到右进行Z字形排列
 * 比如输入字符串为"PAYPALISHIRING"行数为3时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生一个新的字符串，比如："PAHNAPLSIIGYIR"
 * 请你实现将这个字符串进行指定行数变换的函数
 *
 * 解题思路：
 * 题目其实就是对输入的字符串按指定规则重新排序
 * 可以定义一个List<StringBuilder>来表示不同行的字符串
 * 则遍历过程其实就是从上到下，从下到上，依次往不同行里加字符的过程
 * 最终将所有行数据拼凑起来就是输出结果
 */
public class ZTransform {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rowList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rowList.add(new StringBuilder());
        }
        boolean goingDown = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            rowList.get(curRow).append(c);
            goingDown = (curRow == 0 || curRow == numRows - 1) != goingDown;
            curRow += goingDown ? 1 : -1;
        }
        return String.join("", rowList);
    }

    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
