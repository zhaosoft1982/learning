package com.zhaosoft;

/**
 * @author xiaoleizhao
 * @create 2019-11-27 15:27
 **/
public class SynchronizedTest {
    public static void sync(String tips) {
        synchronized (SynchronizedTest.class) {
            System.out.println(tips);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->sync("线程1")).start();
        Thread.sleep(100);
        new Thread(()->sync("线程2")).start();
        Thread.sleep(100);
        new Thread(()->sync("线程3")).start();
        Thread.sleep(100);
        new Thread(()->sync("线程4")).start();
    }
}

