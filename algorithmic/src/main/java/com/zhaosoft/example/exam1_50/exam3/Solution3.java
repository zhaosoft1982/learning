package com.zhaosoft.example.exam1_50.exam3;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    /**
     * 空间换时间
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < len & j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }
}