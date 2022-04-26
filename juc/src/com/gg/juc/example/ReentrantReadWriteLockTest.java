package com.gg.juc.example;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 33863
 * @create 2022-02-08 22:13
 * @desc 测试读写锁
 **/
public class ReentrantReadWriteLockTest {
    private static volatile Map<String, Object> map = new HashMap<>();
    private static ReadWriteLock rwLock =  new ReentrantReadWriteLock();
    public static void put(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在执行写操作 " + key);
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写完了 " + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public static Object get(String key) {
        rwLock.readLock().lock();
        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName() + " 正在执行读操作 " + key);
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读完了 " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
        return result;
    }
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            final int m = i;
            new Thread(() -> {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                ReentrantReadWriteLockTest.put(m + "", m);
            }, m + "").start();
        }
        for (int i = 1; i < 6; i++) {
            final int m = i;
            new Thread(() -> {
                Object o = ReentrantReadWriteLockTest.get(m + "");
            }, "" + i).start();
        }
    }
}
