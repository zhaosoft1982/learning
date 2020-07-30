package com.zhaosoft.test.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * @author xiaoleizhao
 * @create 2019-12-16 13:43
 **/
public class BloomFilterTest {
    @Test
    public void test(){
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                5,
                0.01);
        filter.put(1);
        filter.put(2);
        filter.put(3);
        Assert.assertEquals(true,filter.mightContain(1));
        Assert.assertEquals(true,filter.mightContain(2));
        Assert.assertEquals(true,filter.mightContain(3));
        Assert.assertEquals(false,filter.mightContain(100));
    }
}

