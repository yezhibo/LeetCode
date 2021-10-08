package com.yezhibo.leetcode.tree;

/**
 * 101.对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 题目描述：给定一个二叉树，检查它是否是镜像对称的
 *
 * 解题思路：
 * 一个树对称的条件：左子树对称，右子树对称
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root, root);
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && isSameTree(node1.left, node2.right) && isSameTree(node1.right, node2.left);
    }
}
