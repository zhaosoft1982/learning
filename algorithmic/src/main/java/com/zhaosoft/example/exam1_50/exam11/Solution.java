package com.zhaosoft.example.exam1_50.exam11;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class Solution {
    /**
     * [1,8,6,2,5,4,8,3,7]
     * 暴力破解，两层循环
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
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
}
