package com.zhaosoft.juc.c_001;

/**
 * @author xiaoleizhao
 * @create 2019-12-19 16:55
 **/
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        //任何线程要想执行下面的代码，必须先拿到o的锁
        synchronized(o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}

