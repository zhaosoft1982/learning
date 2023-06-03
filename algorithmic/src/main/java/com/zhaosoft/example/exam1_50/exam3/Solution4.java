package com.zhaosoft.example.exam1_50.exam3;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(hashMap.get(s.charAt(j)), i);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);
        }
        return maxLen;
    }
}