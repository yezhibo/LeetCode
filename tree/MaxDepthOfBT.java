package com.yezhibo.leetcode.tree;

/**
 * 104.二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * 题目描述：
 * 给定一个二叉树，找出其最大深度
 *
 */
public class MaxDepthOfBT {
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }

    public void dfs(TreeNode node, int step) {
        if (node == null) {
            return;
        }
        max = Math.max(max, step);
        dfs(node.left, step + 1);
        dfs(node.right, step + 1);
    }
}
