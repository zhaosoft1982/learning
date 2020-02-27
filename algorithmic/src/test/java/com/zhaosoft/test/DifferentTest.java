package com.zhaosoft.test;

import com.zhaosoft.Different;
import org.junit.Assert;
import org.junit.Test;

public class DifferentTest {
    @Test
    public void test() {
        Different d = new Different();
        Assert.assertEquals(true, d.checkDifferent("D-5H0F6T%Z?QM9,\\72:[A8X! ;YJ#"));
    }
}
