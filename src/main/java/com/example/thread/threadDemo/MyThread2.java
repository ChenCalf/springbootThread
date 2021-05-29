package com.example.thread.threadDemo;

/**
 * 功能描述：implements  runnable  实现线程
 *
 * @Author： cqx
 * @Date: 2021/5/12 14:18
 */
public class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("类名是:" + this.getClass().getSimpleName() + "......当前线程是：  " + Thread.currentThread().getName());


    }
}
