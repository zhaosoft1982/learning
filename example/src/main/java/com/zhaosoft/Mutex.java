package com.zhaosoft;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Mutex implements Lock, java.io.Serializable {
    // Our internal helper class
    // 静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * Reports whether in locked state
         * 是否处于占用状态
         * @return
         */
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * Acquires the lock if state is zero
         * 当状态为0时获取锁
         * 尝试获取资源，立即返回。成功则返回true，否则false。
         * @param acquires
         * @return
         */
        public boolean tryAcquire(int acquires) {
            assert acquires == 1; // Otherwise unused 这里限定只能为1个量
            if (compareAndSetState(0, 1)) {   //state为0才设置为1，不可重入！
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * Releases the lock by setting state to zero
         * 尝试释放资源，立即返回。成功则为true，否则false。
         * @param releases
         * @return
         */
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            if (getState() == 0)  //既然来释放，那肯定就是已占有状态了。只是为了保险，多层判断！
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0); //释放资源，放弃占有状态
            return true;
        }

        // Provides a Condition
        Condition newCondition() {
            return new AbstractQueuedSynchronizer.ConditionObject();
        }

        // Deserializes properly
        private void readObject(ObjectInputStream s)
                throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }

    /**
     * The sync object does all the hard work. We just forward to it.
     * 真正同步类的实现都依赖继承于AQS的自定义同步器！
     */
    private final Sync sync = new Sync();

    /**
     * 获取资源，即便等待，直到成功才返回。
     */
    public void lock() {
        sync.acquire(1);
    }

    /**
     * 尝试获取资源，要求立即返回。成功则为true，失败则为false。
     * @return
     */
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    /**
     * 释放资源。
     */
    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    /**
     * 锁是否占有状态
     * @return
     */
    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit)
            throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
}
