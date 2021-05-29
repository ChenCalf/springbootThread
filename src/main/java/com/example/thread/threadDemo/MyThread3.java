package com.example.thread.threadDemo;

import java.util.concurrent.Callable;

/**
 * 功能描述： 实现  callable/future
 *
 * @Author： cqx
 * @Date: 2021/5/12 14:18
 */
public class MyThread3 implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("类名是:" + this.getClass().getSimpleName() + "......当前线程是：  " + Thread.currentThread().getName());
        return 0;
    }
}
