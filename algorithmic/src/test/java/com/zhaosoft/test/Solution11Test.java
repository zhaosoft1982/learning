package com.zhaosoft.test;

import com.zhaosoft.example.exam1_50.exam11.Solution;
import org.junit.Assert;
import org.junit.Test;

public class Solution11Test {
    @Test
    public void test0() {
        Solution solution = new Solution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(height);
        Assert.assertEquals(49, result);
    }
}
