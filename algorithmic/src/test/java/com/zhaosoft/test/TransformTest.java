package com.zhaosoft.test;

import com.zhaosoft.Transform;
import org.junit.Assert;
import org.junit.Test;

public class TransformTest {
    @Test
    public void test() {
        Transform transform = new Transform();
        int[][] old = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] target = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Assert.assertEquals(target, transform.transformImage(old, 3));
    }
}
