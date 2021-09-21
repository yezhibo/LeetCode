package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.*;

/**
 * 554.砖墙
 * https://leetcode-cn.com/problems/brick-wall/
 *
 * 题目描述：
 * 假设你面前有一堵矩形的，由n行砖块组成的墙。这些砖块的高度相同，但宽度不同。每一行砖块
 * 的宽度和相等。
 * 你现在要画一条自顶向下的、穿过最少砖块的垂线。如果你画的线只是从砖块的边缘经过就不算穿过
 * 这块砖。你不能沿着墙的两个垂直边缘之一画线。
 * 给你一个二维数组wall，该数组包含这堵墙的相关信息。其中，wall[i]是代表一个从左至右每块
 * 砖的宽度的数组。你需要找出怎样画才能使这条线穿过的砖块数量最少，并返回穿过的砖块的数量
 *
 * 解题思路：
 * 题目要求从上往下穿过的最少砖块数量，也即穿过最多的缝隙数量
 * 由于砖块的高度是确定的，并且每行砖块的总长度也是确定的
 * 因此只需要统计每个位置出现的缝隙的次数，从出现缝隙次数最多的那个位置画线即穿过的砖块数量最少
 *
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> gapIndex2Count = new HashMap<>();
        int lineLength = 0;
        for (List<Integer> line : wall) {
            int index = 0;
            for (int length : line) {
                index += length;
                gapIndex2Count.put(index, gapIndex2Count.getOrDefault(index, 0) + 1);
            }
            lineLength = index;
        }
        gapIndex2Count.remove(lineLength);
        int maxGapCount = gapIndex2Count.size() == 0 ? 0 : gapIndex2Count.values().stream().max(Comparator.comparingInt(v -> v)).get();
        return wall.size() - maxGapCount;
    }

    @Test
    public void test() {
        List<Integer> line1 = Arrays.asList(1,2,2,1);
        List<Integer> line2 = Arrays.asList(3,1,2);
        List<Integer> line3 = Arrays.asList(1,3,2);
        List<Integer> line4 = Arrays.asList(2,4);
        List<Integer> line5 = Arrays.asList(3,1,2);
        List<Integer> line6 = Arrays.asList(1,3,1,1);
        List<List<Integer>> wall = Arrays.asList(line1,line2,line3,line4,line5,line6);
        System.out.println(leastBricks(wall));

        line1 = Arrays.asList(1);
        line2 = Arrays.asList(1);
        line3 = Arrays.asList(1);
        wall = Arrays.asList(line1,line2,line3);
        System.out.println(leastBricks(wall));
    }
}
