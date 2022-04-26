package com.gg.juc.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 33863
 * @create 2022-02-01 10:34
 * @desc 线程之间的通信
 **/
public class ThreadDemo1 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.asc();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.desc();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.asc();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.desc();
            }
        }, "D").start();
    }
}

class Resource {
    private static final Lock lock = new ReentrantLock(true);
    private static final Condition CONDITION = lock.newCondition();
    private int num = 0;

    public void asc() {
        lock.lock();
        try {
            while (num != 0) {
                //                this.wait();
                try {
                    CONDITION.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhhhhh");  //wait后的线程只是在这里停止了，并没有结束
            }
            System.out.println(Thread.currentThread().getName() + " ：" + (++num));
//        this.notifyAll();
            CONDITION.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void desc() {
        lock.lock();
        try {
            while ( num == 0) {
                //                this.wait();
                try {
                    CONDITION.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhhhhh");  //wait后的线程只是在这里停止了，并没有结束
            }
            System.out.println(Thread.currentThread().getName() + " ：" + (--num));
//        this.notifyAll();
            CONDITION.signalAll();
        } finally {
            lock.unlock();
        }
    }
}