package com.zhaosoft.test;

import com.zhaosoft.Replacement;
import org.junit.Assert;
import org.junit.Test;

public class ReplacementTest {
    @Test
    public void test() {
        Replacement r = new Replacement();
        String result = r.replaceSpace("Hello  World", 12);
        Assert.assertEquals("Hello%20%20World", result);
    }
}
