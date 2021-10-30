package com.yezhibo.leetcode.tree;

import org.junit.Test;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * 路径：任意一个节点出发到达任意节点的序列
 */
public class MaxPathSum {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        int max = Math.max(root.val, Math.max(root.val + leftMax, root.val + rightMax));
        maxSum = Math.max(maxSum, Math.max(max, root.val + leftMax + rightMax));
        return max;
    }

    @Test
    public void test() {
        /*TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));*/

        TreeNode root1 = new TreeNode(-2);
        root1.left = new TreeNode(1);
        System.out.println(maxPathSum(root1));
    }
}
