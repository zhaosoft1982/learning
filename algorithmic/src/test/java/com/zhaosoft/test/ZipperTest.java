package com.zhaosoft.test;

import com.zhaosoft.Zipper;
import org.junit.Assert;
import org.junit.Test;

public class ZipperTest {
    @Test
    public void test() {
        Zipper zipper = new Zipper();
        String temp = zipper.zipString("aabcccccaaa");
        Assert.assertEquals("a2b1c5a3", temp);
        temp = zipper.zipString("welcometonowcoderrrrr");
        Assert.assertEquals("welcometonowcoderrrrr", temp);
    }
}
