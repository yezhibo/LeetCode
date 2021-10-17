package com.yezhibo.leetcode.dfs;

import org.junit.Test;

import java.util.Arrays;

/**
 * 130.被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * 题目描述：
 * 找出被围绕的区域，并将该区域内元素变为x
 *
 *
 */
public class SurroundedRegions {
    boolean[][] flag;
    int m;
    int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        flag = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (board[i][j] == 'O' && !flag[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0|| j >= n) {
            return;
        }
        if (board[i][j] != 'O' || flag[i][j]) {
            return;
        }
        flag[i][j] = true;
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }

    @Test
    public void test() {
        /*char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for (char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }*/
        char[][] board1 = new char[][]{{'O','O'},{'O','O'}};
        solve(board1);
        for (char[] arr : board1) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
