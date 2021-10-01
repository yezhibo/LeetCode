package com.yezhibo.leetcode.string;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 71.简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 *
 * 题目描述：
 * 给你一个字符串path，表示指向某一文件或目录的unix风格的绝对路径（以'/'开头）
 * 请你将其转化为更加简洁的规范路径。
 * 返回路径必须遵循如下格式
 * 1、始终以'/'开头
 * 2、两个目录名之间必须只有一个斜杠'/'
 * 3、最后一个目录名（如果存在）不能以'/'结尾
 * 4、路径仅包含从根目录到目标文件或目录的路径上的目录，即不含'.'或'..'
 *
 * 解题思路：
 * 采用双端队列的形式
 * 1、将输入字符串按'/'分割成数组，然后遍历数组
 * 2、对于 '.',''直接忽略
 * 3、对于 '..' 将队尾元素移除
 */
public class SimplyPath {
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        LinkedList<String> queue = new LinkedList<>();
        for (String str : pathArr) {
            if (str.isEmpty() || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str)) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
                continue;
            }
            queue.add(str);
        }
        return "/" + String.join("/", queue);
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
