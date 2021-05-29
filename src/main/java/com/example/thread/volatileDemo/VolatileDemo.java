package com.example.thread.volatileDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：
 *
 * @Author： cqx
 * @Date: 2021/5/15 13:21
 */
public class VolatileDemo implements Runnable {
    private volatile static boolean flag=false;

    @Override
    public void run() {

        while (!flag) {
            System.out.println("====");
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new VolatileDemo());
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        flag=true;

    }

}
