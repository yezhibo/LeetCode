package com.yezhibo.leetcode.integer;

import org.junit.Test;

/**
 * 7.整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * 题目描述：
 * 给你一个32位的有符号整数x，返回将x中的数字部分反转后的结果
 * 如果反转后的整数超过32位的有符号整数的范围，就返回0
 * 假设环境允许存储64位整数
 *
 * 解题思路：
 * 1、反转字符串可以采用求余和整除的方式依次从原数据切分出来数据
 * 2、题目不允许使用超过32位的整数，也即不允许使用long，因此在倒数第二位时就要判断
 * 整数最大值2147483647
 * 整数最小值-2147483648
 */
public class IntegerReverse {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int tmp = x % 10;
            x /= 10;
            if (ans > 214748364 || (ans == 214748364 && tmp > 7)) {
                return 0;
            }
            if (ans < -214748364 || (ans == -214748364 && tmp < -8)) {
                return 0;
            }
            ans = ans * 10 + tmp;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }
}
