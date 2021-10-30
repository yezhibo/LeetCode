package com.yezhibo.leetcode.tree;

import java.util.*;

/**
 * 129.求根节点到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 */
public class SumRoot2LeafNum {
    List<Integer> pathNumbers = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        int pathSum = 0;
        dfs(root, pathSum);
        return pathNumbers.stream().mapToInt(Integer::valueOf).sum();
    }

    private void dfs(TreeNode root, int pathSum) {
        if (root == null) {
            return;
        }
        int sum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            pathNumbers.add(sum);
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
