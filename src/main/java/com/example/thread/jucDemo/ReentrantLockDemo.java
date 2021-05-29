package com.example.thread.jucDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @Author： cqx
 * @Date: 2021/5/21 14:44
 */
public class ReentrantLockDemo {


    private volatile static int num = 0;

    private static ReentrantLock rl = new ReentrantLock();

    public static void incrNum () {
        num++;
    }


    public static void main (String[]args){
        for (int i = 0; i < 1000; i++) {

            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    rl.lock();
                    incrNum();
                    System.out.println("num = " + num);
                    rl.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
