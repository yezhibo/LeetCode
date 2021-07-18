package com.yezhibo.LeetCode.tree;

/**
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
