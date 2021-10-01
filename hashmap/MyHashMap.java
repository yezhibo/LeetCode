package com.yezhibo.leetcode.hashmap;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 * https://leetcode-cn.com/problems/design-hashmap/
 *
 * 题目描述：
 * 不使用任何内建的哈希表库，设计一个哈希映射
 *
 * 解题思路：
 * 采用数组+链表的形式来实现
 */
public class MyHashMap {
    private final int base;
    private final LinkedList<Pair>[] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
        base = 769;
        data = new LinkedList[base];
        for (int i = 0; i < base; i++) {
            data[i] = new LinkedList<>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        for (Pair pair : data[index]) {
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[index].add(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        for (Pair pair : data[index]) {
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        Iterator<Pair> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                iterator.remove();
                return;
            }
        }
    }

    private int hash(int key) {
        return key % base;
    }

    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
