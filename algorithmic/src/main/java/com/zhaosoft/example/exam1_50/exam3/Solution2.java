package com.zhaosoft.example.exam1_50.exam3;

/**
 * 无重复字符的最长子串
 */
public class Solution2 {
    /**
     * "abcabcbb"
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();
        int maxLen = Integer.MIN_VALUE;
        for (char c : ss) {
            if (sb.lastIndexOf(c + "") < 0) {
                sb.append(c);
            } else {
                maxLen = Math.max(maxLen, sb.length());
                sb.delete(0, sb.indexOf(c + "") + 1).append(c + "");
            }
        }
        maxLen = Math.max(maxLen, sb.length());
        return maxLen;
    }
}