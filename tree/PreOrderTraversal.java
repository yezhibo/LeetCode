package com.yezhibo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144.二叉树前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * 题目描述：
 * 给你二叉树的根节点root，返回它节点值的前序遍历
 *
 * 解题思路：
 *
 *
 */
public class PreOrderTraversal {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
