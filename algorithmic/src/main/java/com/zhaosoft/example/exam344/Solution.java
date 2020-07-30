package com.zhaosoft.example.exam344;

public class Solution {
    /**
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
