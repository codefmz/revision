package com.gg.juc.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author 33863
 * @create 2022-02-05 11:28
 * @desc 使用callable 创建线程
 **/
public class CallableTest {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " 正在执行");
            return 100;
        });
        new Thread(futureTask,"t1").start();
        while (!futureTask.isDone()){
            System.out.println("主线程在等待，一直在等待！");
        }
        try {
            System.out.println("t1线程执行结束后,返回的结果：" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
