package com.gg.juc.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 33863
 * @create 2022-02-05 14:04
 * @desc 循环栅栏
 **/
public class CyclicBarrierDemo {
    private static final int Num = 7;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(Num, () -> {
            System.out.println("已经集" + Num + "颗小龙珠，可以召唤神龙了！");
        });
        for (int i = 1; i <8 ; i++) {
            new Thread(() -> {
                System.out.println("收集到第'" + Thread.currentThread().getName() + "'颗龙珠");
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "执行后序操作");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },i+ "").start();
        }
    }
}
