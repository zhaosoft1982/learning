package com.zhaosoft.test;

import com.zhaosoft.example.exam1_50.exam3.Solution;
import org.junit.Assert;
import org.junit.Test;

public class Solution3Test {
    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(0, solution.lengthOfLongestSubstring(""));
        Assert.assertEquals(1, solution.lengthOfLongestSubstring(" "));
    }
}
