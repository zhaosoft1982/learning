package com.zhaosoft.example.exam231;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * @author xiaoleizhao
 * @create 2019-12-17 16:57
 **/
public class Solution {
    public boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isPowerOfTwo(23));
        Assert.assertEquals(true, solution.isPowerOfTwo(32));
        Assert.assertEquals(8, 12 & 11);
    }
}

