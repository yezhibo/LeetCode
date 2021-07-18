package com.yezhibo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
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


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
