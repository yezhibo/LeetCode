package com.yezhibo.leetcode.tree;

/**
 * 110.平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 题目描述：给定一个二叉树，判断它是否是高度平衡的二叉树
 *
 */
public class BalancedBT {
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (Math.abs(l - r) > 1) {
            result = false;
        }
        return Math.max(l, r) + 1;
    }
}
