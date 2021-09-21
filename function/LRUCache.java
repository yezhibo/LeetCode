package com.yezhibo.leetcode.function;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题16.25 LRU缓存
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 *
 * 题目描述：
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 解题思路：
 *
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> catchMap;
    private Map<Integer, Long> catchUseMap;
    private long curTime;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        catchMap = new HashMap<>();
        catchUseMap = new HashMap<>();
        curTime = 0;
    }

    public int get(int key) {
        if (catchMap.containsKey(key)) {
            curTime++;
            catchUseMap.put(key, curTime);
            return catchMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!catchMap.containsKey(key) && catchMap.size()>=capacity) {
            Integer minKey = getMinKey();
            catchMap.remove(minKey);
            catchUseMap.remove(minKey);
        }
        catchMap.put(key, value);
        curTime++;
        catchUseMap.put(key, curTime);
    }

    private Integer getMinKey(){
        long min = Long.MAX_VALUE;
        int minKey = 0;
        for(Map.Entry<Integer, Long> map : catchUseMap.entrySet()) {
            if (map.getValue() < min) {
                min = map.getValue();
                minKey = map.getKey();
            }
        }
        return minKey;
    }

    @Test
    public void test() {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        /*cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废

        System.out.println(cache.get(2));     // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));      // 返回  4*/

        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));



    }
}
