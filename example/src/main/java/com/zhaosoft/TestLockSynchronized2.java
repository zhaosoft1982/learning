package com.zhaosoft;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoleizhao
 * @create 2019-12-13 18:06
 **/
@Slf4j
public class TestLockSynchronized2 {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        int N = 10;
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; ++i) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    lock.lock();
                    log.info(Thread.currentThread().getName() + " get synch lock!");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            });
        }
        lock.lock();
        for (int i = 0; i < N; ++i) {
            threads[i].start();
            Thread.sleep(200);
        }
        lock.unlock();
        for (int i = 0; i < N; ++i) {
            threads[i].join();
        }

    }
}

