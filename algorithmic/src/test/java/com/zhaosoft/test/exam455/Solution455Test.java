package com.zhaosoft.test.exam455;

import com.zhaosoft.example.exam455.Solution;
import org.junit.Assert;
import org.junit.Test;

public class Solution455Test {
    @Test
    public void findContentChildrenTest0() {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.findContentChildren(g, s));
    }

    @Test
    public void findContentChildrenTest1() {
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findContentChildren(g, s));
    }
}
