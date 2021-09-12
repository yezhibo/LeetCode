package com.yezhibo.leetcode.dfs;

import org.junit.Test;

import java.util.Arrays;

/**
 * 求一段数字的全排列
 *
 */
public class FullArrangement {
    int N = 3;
    boolean[] used = new boolean[N+1];
    int[] result = new int[N];
    void make(int level) {
        for (int i = 1; i<=N; i++) {
            if (!used[i]) {
                used[i] = true;
                result[level] = i;
                make(level+1);
                used[i] = false;
            }
        }

        if (level == N-1) {
            System.out.println(Arrays.toString(result));
        }
    }

    @Test
    public void test() {
        make(0);
    }
}
