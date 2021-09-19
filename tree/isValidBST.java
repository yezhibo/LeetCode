package com.yezhibo.leetcode.tree;

/**
 * 98.验证二叉树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 题目描述：
 * 给你一个二叉树的根节点root，判断其是否是一个有效的二叉树
 * 有效二叉搜索树定义如下：
 * 1、节点的左子树只包含小于当前节点的数
 * 2、节点的右子树只包含大于当前节点的数
 * 3、所有左子树和右子树自身也必须是二叉搜索数
 *
 * 解题思路：
 * 通过递归的方法，
 */
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidNode(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidNode(node.left, lower, node.val) && isValidNode(node.right, node.val, upper);
    }
}
