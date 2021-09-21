package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 997.找到小镇的法官
 * https://leetcode-cn.com/problems/find-the-town-judge/
 *
 * 题目描述：
 * 在一个小镇里，按从1到n为n个人进行编号。这些人中有一个是法官：
 * 1、法官不相信任何人
 * 2、每个人（除了法官外）都相信小镇的法官
 * 3、只有一个人满足条件1、2
 *
 * 给定数组trust，该数组由信任对trust[i]=[a,b]组成，表示编号为a的人信任编号为b的人。
 *
 * 如果小镇存在法官，返回法官的编号，否则返回-1。
 *
 * 解题思路：
 * 法官的条件：被n-1个人信任，并且只有一个人
 *
 * 定义一个数组inDegree[i] 表示编号为i的人的入度也即受信任的人数
 *
 * 如果自己信任自己，不算
 *
 * 最终对inDegree进行排序，判断最大值是否唯一
 */
public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for (int[] ints : trust) {
            outDegree[ints[0]]++;
            inDegree[ints[1]]++;
        }
        int judgeNum = -1;
        int maxCount = 0;
        for (int i = 1; i < n+1; i++) {
            if (inDegree[i] == n-1 && outDegree[i] == 0) {
                judgeNum = i;
                if (++maxCount > 1) {
                    return -1;
                }
            }
        }
        return judgeNum;
    }

    @Test
    public void test() {
        System.out.println(findJudge(2, new int[][]{{1,2}}));
        System.out.println(findJudge(3, new int[][]{{1,3},{2,3}}));
        System.out.println(findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
    }
}
