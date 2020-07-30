package com.zhaosoft.test;

import com.zhaosoft.Same;
import org.junit.Assert;
import org.junit.Test;

public class SameTest {
    @Test
    public void sameTest() {
        String a = "This is nowcoder";
        String b = "is This nowcoder";
        Same s = new Same();

        Assert.assertEquals(true, s.checkSam(a, b));
    }
}
