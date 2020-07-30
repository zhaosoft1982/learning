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
     * "abcabcbb"
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring0(String s) {
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

    public int lengthOfLongestSubstring1(String s) {
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

    public int lengthOfLongestSubstring2(String s) {
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

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        int i = 0;
        for (int j = 0; j < len; j++) {
            int pos = s.indexOf(s.charAt(j), i);
            if (pos < j) {
                maxLen = Math.max(maxLen, j - i);
                i = pos + 1;
            }else{
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int i = 0;
//        int flag = 0;
//        int length = 0;
//        int result = 0;
//        while (i < s.length()) {
//            int pos = s.indexOf(s.charAt(i),flag);
//            if (pos < i) {
//                if (length > result) {
//                    result = length;
//                }
//                if (result >= s.length() - pos - 1) {
//                    return result;
//                }
//                length = i - pos - 1;
//                flag = pos + 1;
//            }
//            length++;
//            i++;
//        }
//        return length;
//    }
}
