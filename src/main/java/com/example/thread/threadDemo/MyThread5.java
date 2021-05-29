package com.example.thread.threadDemo;

import java.util.concurrent.*;

/**
 * 功能描述： 演示多线程的情况下，对同一个共享变量操作
 *
 * @Author： cqx
 * @Date: 2021/5/12 14:18
 */
public class MyThread5 implements Runnable {
    public volatile static int num = 0;


    public synchronized    static int incrNum() {
        // synchronized (MyThread5.class) {
            //
            // try {
            //     TimeUnit.SECONDS.sleep(20);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

            num++;
            System.out.println("incrNum() = " + num);
        // }
        return num;
    }
    @Override
    public void run() {
        incrNum();
    }


    public static void main(String[] args) {
     /*   MyThread5 myThread5 = new MyThread5();
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        executorService.execute(myThread5);*/


        for (int i = 0; i < 1000; i++) {

            // new Thread(new MyThread5()).start();
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                incrNum();

            }).start();
            System.out.println("num = " + num);
        }

    }



}
