package com.zhaosoft.example.exam1_50.exam11;

public class Solution3 {
    public int maxArea1(int[] height) {
        int maxResult = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxResult = Math.max(maxResult, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxResult;
    }
}