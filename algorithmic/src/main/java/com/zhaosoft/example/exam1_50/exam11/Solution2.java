package com.zhaosoft.example.exam1_50.exam11;

public class Solution2 {
    public int maxArea(int[] height) {
        int x = 0, sum = 0, y = height.length - 1;
        while (x < y) {
            if (height[x] > height[y]) {
                //短板决定桶容量
                sum = Math.max(sum, height[y] * (y - x));
                while (height[y - 1] < height[y]) {
                    y--;
                }
                y--;
            } else {
                //短板决定桶容量
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