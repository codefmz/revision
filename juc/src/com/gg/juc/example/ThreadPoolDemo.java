package com.gg.juc.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 33863
 * @create 2022-02-09 12:08
 * @desc
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2, 5, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy()
        );
        //10个顾客请求
        try {
            for (int i = 1; i <=10; i++) {
                //执行
                poolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务");
                });
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭
            poolExecutor.shutdown();
        }
    }
}
