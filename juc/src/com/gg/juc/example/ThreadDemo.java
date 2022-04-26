package com.gg.juc.example;

/**
 * @author 33863
 * @create 2022-02-27 16:32
 * @desc  使用synchronize测试线程间的通信
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        Resource3 resource3 = new Resource3();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                resource3.asc();
            }
        },"A").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                resource3.desc();
            }
        },"B").start();
    }
}
class Resource3 {
    private int num = 0;
    public synchronized void asc()  {
        if(num != 0){
            try {
                this.wait();
//                System.out.println("hhhhhh");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " ：" + (++num));
        this.notifyAll();
    }
    public synchronized void desc()  {
        if(num == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " ：" + (--num));
        this.notifyAll();
    }
}
