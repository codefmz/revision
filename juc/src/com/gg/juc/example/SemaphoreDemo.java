package com.gg.juc.example;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 33863
 * @create 2022-02-05 14:55
 * @desc 信号灯:实现6个车位停靠3辆车的功能
 **/
public class SemaphoreDemo {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000);
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 找到车位！");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName() + " 走了！");
                    semaphore.release();
                }
            }, i + 1 + "").start();
        }
    }
}
