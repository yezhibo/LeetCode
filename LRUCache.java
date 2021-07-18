package com.yezhibo.leetcode;

import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
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
