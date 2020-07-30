package com.zhaosoft.test;

import com.zhaosoft.example.exam992.Solution;
import org.junit.Assert;
import org.junit.Test;

public class Solution992Test {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] a = new int[]{1, 2, 1, 2, 3};

        Assert.assertEquals(3, solution.subarraysWithKDistinct(a, 3));
    }

    @Test
    public void test0() {
        Solution solution = new Solution();
        int[] a = new int[]{1, 2, 1, 3, 4};

        Assert.assertEquals(3, solution.subarraysWithKDistinct(a, 3));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] a = new int[]{1, 2, 1, 2, 3};

        Assert.assertEquals(7, solution.subarraysWithKDistinct(a, 2));
    }
}
