package com.zhaosoft.example.exam1_50.exam11;

public class Solution5 {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return result;
    }
}