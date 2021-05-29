package com.example.thread.threadDemo;

/**
 * 功能描述：继承Thread 实现线程
 *
 * @Author： cqx
 * @Date: 2021/5/12 14:18
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("类名是:"+this.getClass().getSimpleName()+"......当前线程是：  "+Thread.currentThread().getName());
    }
}
