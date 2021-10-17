package com.yezhibo.leetcode.tree;

/**
 * 112.路径总和
 * https://leetcode-cn.com/problems/path-sum/
 *
 * 题目描述：
 * 给你二叉树的根节点root，
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum- root.val);
    }
}
