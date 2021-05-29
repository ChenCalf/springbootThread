package com.example.thread.threadDemo;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述：测试interrupt
 *
 * @Author： cqx
 * @Date: 2021/5/12 14:18
 */
public class MyThread4 extends Thread {


    @Override
    public void run() {
        // while (!Thread.currentThread().isInterrupted()){
        while (true){
            // System.out.println("=====");
            try {
                TimeUnit.SECONDS.sleep(1000);
                System.out.println("=====");
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Thread.currentThread().interrupt();
            }
            System.out.println("类名是:" + this.getClass().getSimpleName() + "......当前线程是：  " + Thread.currentThread().getName());
        }


    }
}
