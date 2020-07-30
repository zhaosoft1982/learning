package com.zhaosoft.thead;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test5 {
    static Thread t1 = null;
    static Thread t2 = null;
    static Lock lock = new ReentrantLock();

    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        char[] c1 = new char[]{'1', '2', '3', '4'};
        char[] c2 = new char[]{'A', 'B', 'C', 'D'};

        t1 = new Thread(() -> {
            try {
                lock.lock();
                for (char c : c1) {
                    System.out.print(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t1");

        t2 = new Thread(() -> {
            try {
                lock.lock();
                for (char c : c2) {
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t2");

        t1.start();
        t2.start();
    }
}
