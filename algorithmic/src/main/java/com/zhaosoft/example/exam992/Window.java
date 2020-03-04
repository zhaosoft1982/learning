package com.zhaosoft.example.exam992;

import java.util.HashMap;
import java.util.Map;

public class Window {
    private Map<Integer, Integer> cache;
    private int count;

    public Window() {
        cache = new HashMap<>();
        count = 0;
    }

    public void add(Integer value) {
        cache.put(value, cache.getOrDefault(value, 0) + 1);
        if (cache.get(value) == 1)
            count++;
    }

    public void remove(Integer value) {
        cache.put(value, cache.get(value) - 1);
        if (cache.get(value) == 0) {
            count--;
        }

    }

    public int getCount() {
        return count;
    }

}