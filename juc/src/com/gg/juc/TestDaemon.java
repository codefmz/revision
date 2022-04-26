package com.gg.juc;

/**
 * @author 33863
 * @create 2022-01-30 16:57
 * @desc 测试是否是主线程
 **/
public class TestDaemon {

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " :: " + Thread.currentThread().isDaemon());
            while(true){

            }
        }, "a");
        a.setDaemon(true);
        a.start();
        System.out.println(Thread.currentThread().getName() + " is over!");
    }
}
