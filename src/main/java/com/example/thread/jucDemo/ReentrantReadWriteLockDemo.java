package com.example.thread.jucDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 功能描述：
 *
 * @Author： cqx
 * @Date: 2021/5/27 13:26
 */
public class ReentrantReadWriteLockDemo {

    static volatile int num = 0;

    static ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock rl = rrw.readLock();
    static ReentrantReadWriteLock.WriteLock wl = rrw.writeLock();

    public int getNum() {
        try {
            rl.lock();
            TimeUnit.SECONDS.sleep(3);
            num++;
            return num;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rl.unlock();
        }

        return num;

    }
    // public synchronized int getNum() {
    //
    //     num++;
    //     return num;
    //
    //
    //
    // }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();

        new Thread(()->{
            int num = demo.getNum();

            System.out.println(Thread.currentThread().getName()+"---"+num);
        }).start();
        new Thread(()->{
            int num = demo.getNum();

            System.out.println(Thread.currentThread().getName()+"---"+num);
        }).start();
    }
}
