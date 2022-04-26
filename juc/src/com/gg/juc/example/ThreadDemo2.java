package com.gg.juc.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 33863
 * @create 2022-02-01 12:53
 * @desc 实现线程之间的定制化通信
 **/
public class ThreadDemo2 {
    public static void main(String[] args) {
        Resource2 resource2 = new Resource2();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource2.print(1, 5, Resource2.CONDITION, Resource2.CONDITION2);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource2.print(2, 10, Resource2.CONDITION2, Resource2.CONDITION3);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource2.print(3, 15, Resource2.CONDITION3, Resource2.CONDITION);
            }
        }, "C").start();
    }
}

class Resource2 {
    private int flag = 1;
    public static final Lock lock = new ReentrantLock();
    public static final Condition CONDITION = lock.newCondition();
    public static final Condition CONDITION2 = lock.newCondition();
    public static final Condition CONDITION3 = lock.newCondition();

    public void print(int _flag, int time, Condition condition1, Condition condition2) {
        lock.lock();
        try {
            while (flag != _flag) { // 判断
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 工作
            for (int i = 0; i < time; i++) {
                System.out.println(Thread.currentThread().getName() + "：打印 " + (i + 1) + " 次");
            }
            if (flag != 3) {
                flag++;
            } else {
                flag = 1;
            }
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }
}