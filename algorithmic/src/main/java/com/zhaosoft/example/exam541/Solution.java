package com.zhaosoft.example.exam541;

import java.util.Arrays;

public class Solution {
    public String reverseStr(String s, int k) {
        int k2 = k * 2;
        int len = s.length();
        char[] array = s.toCharArray();
        for (int start = 0; start < len; start = start + k2) {
            int end = Math.min(start + k - 1, len - 1);
            reverse(array, start, end);
        }
        return new String(array);
    }

    private char[] reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }
}
