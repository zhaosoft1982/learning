package com.zhaosoft.example.exam1_50.exam3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author zhaosoft
 */
public class Solution {
    /**
     * 不引入任何空间，只循环给定的字符串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        int i = 0;
        for (int j = 0; j < len; j++) {
            char c = s.charAt(j);
            int pos = s.indexOf(c, i);
            if (pos < j) {
                maxLen = Math.max(maxLen, j - i);
                i = pos + 1;
            } else {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}
