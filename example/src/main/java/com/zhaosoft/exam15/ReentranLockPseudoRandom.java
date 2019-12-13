package com.zhaosoft.exam15;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 *
 *
 * @author zhaosoft
 */
@ThreadSafe
public class ReentranLockPseudoRandom extends PseudoRandom {
    private final Lock lock=new ReentrantLock(false);
    private int seed;

    public ReentranLockPseudoRandom(int seed) {
        this.seed = seed;
    }

    public int newInt(int n){
        lock.lock();
        try {
            int s=seed;
            seed=calculateNext(s);
            int remainder=s%n;
            return remainder>0?remainder:remainder+n;
        }finally {
            lock.unlock();
        }
    }
}
