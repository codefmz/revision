package com.gg.juc.example;

import java.util.concurrent.CountDownLatch;

/**
 * @author 33863
 * @create 2022-02-05 13:10
 * @desc
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 10 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 号同学走出了教室！");
                countDownLatch.countDown();
            },i+"").start();
        }
        countDownLatch.await();
        System.out.println("锁门了！");
    }
}
