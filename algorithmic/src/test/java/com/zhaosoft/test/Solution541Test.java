package com.zhaosoft.test;

import com.zhaosoft.example.exam541.Solution;
import org.junit.Assert;
import org.junit.Test;

public class Solution541Test {
    @Test
    public void test0() {
        Solution solution = new Solution();
        String result = solution.reverseStr("abcdefg", 2);
        Assert.assertEquals("bacdfeg", result);

    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        String result = solution.reverseStr("abcdefg", 10);
        Assert.assertEquals("abcdefg", result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String result = solution.reverseStr("abcdefg", 8);
        Assert.assertEquals("gfedcba", result);
    }
}
