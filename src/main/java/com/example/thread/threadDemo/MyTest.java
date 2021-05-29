package com.example.thread.threadDemo;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 功能描述：
 *
 * @Author： cqx
 * @Date: 2021/5/12 14:21
 */
public class MyTest {

    private int num = 0;

    void incrNum() {
        num++;
    }


    @Test
    public void t1() {
        incrNum();
        System.out.println(num);
    }

    public static void main(String[] args) {
        int a = -16;

       // 源码： 1000 0000  0000 0000   0000 0000  0001 0000

        //a >>>4   1111 1000 0000  0000 0000   0000 0000  0001
        System.out.println("a>>4 = " + (a >> 4));
        System.out.println("a >>> 4 = " +(a >>> 4));

        //  MyThread4 myThread4 = new MyThread4();
        //  myThread4.start();
        // // System.out.println("=====");
        //  try {
        //       Thread.sleep(3000);
        //  } catch (InterruptedException e) {
        //      e.printStackTrace();
        //  }
        //  myThread4.interrupt();


    }


    private static void method() {
        Thread t1 = new Thread(new MyThread1(), "t1");
        Thread t2 = new Thread(new MyThread2(), "t2");

        t1.start();
        t2.start();


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> submit = executorService.submit(new MyThread3());

        try {
            System.out.println("submit.get() = " + submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main========end");
    }

}
