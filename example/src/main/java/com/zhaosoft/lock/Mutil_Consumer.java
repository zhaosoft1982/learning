package com.zhaosoft.lock;

/**
 * @author xiaoleizhao
 * @create 2019-12-18 18:43
 **/
public class Mutil_Consumer implements Runnable {
    private ResourceByCondition r;

    Mutil_Consumer(ResourceByCondition r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.consume();
        }
    }
}

