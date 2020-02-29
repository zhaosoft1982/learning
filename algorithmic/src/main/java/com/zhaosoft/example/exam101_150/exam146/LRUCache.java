package com.zhaosoft.example.exam101_150.exam146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.get(key);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.removeEldestEntry(eldest);
    }
}
