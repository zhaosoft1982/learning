package com.zhaosoft.test;

import com.zhaosoft.example.exam557.Solution;
import org.junit.Assert;
import org.junit.Test;

public class Solution557Test {
    @Test
    public void test() {
        Solution solution = new Solution();
        String s = "Let's take LeetCode contest";
        String result = solution.reverseWords(s);
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", result);
    }
}
