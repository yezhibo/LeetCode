package com.yezhibo.leetcode.tree;

import org.junit.Test;

/**
 * 99.恢复二叉搜索树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 解法2：
 * 采用一个辅助节点来存储遍历过程中前一个节点
 *
 * 可以在第一次遍历树的过程中就把有问题的节点找出来
 *
 */
public class RecoverBFS2 {
    TreeNode x;
    TreeNode y;
    TreeNode pre;

    public void recoverTree(TreeNode root) {
        bfs(root);
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    public void bfs(TreeNode node) {
        if (node == null) {
            return;
        }
        bfs(node.left);
        if (pre != null && pre.val > node.val) {
            x = node;
            if (y == null) {
                y = pre;
            }
        }
        pre = node;
        bfs(node.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recoverTree(root);
        System.out.println("end");
    }
}
