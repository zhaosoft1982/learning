package com.zhaosoft.example.exam1_50.exam11;

public class Solution {
    /**
     * [1,8,6,2,5,4,8,3,7]
     *
     * @param height
     * @return
     */
    public int maxArea0(int[] height) {
        int maxResult = 0;
        for (int i = 1; i < height.length; i++) {
            int j = 0;
            while (j < i) {
                int h = Math.min(height[i], height[j]);
                maxResult = Math.max(maxResult, h * (i - j));
                j++;
            }
        }
        return maxResult;
    }

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

    public int maxArea(int[] height) {
        int x = 0, sum = 0, y = height.length - 1;
        while (x < y) {
            if (height[x] > height[y]) {
                sum = Math.max(sum, height[y] * (y - x));
                while (height[y - 1] < height[y]) {
                    y--;
                }
                y--;
            } else {
                sum = Math.max(sum, height[x] * (y - x));
                while (height[x + 1] < height[x]) {
                    x++;
                }
                x++;
            }
        }
        return sum;
    }
}
