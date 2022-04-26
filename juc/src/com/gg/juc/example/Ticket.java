package com.gg.juc.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 33863
 * @create 2022-01-31 19:30
 * @desc 卖票的例子
 **/
public class Ticket {
    private static final Lock LOCK = new ReentrantLock();
    private int number = 30;
    public   void  sell(){
        LOCK.lock();
        try {
            if(number > 0){
                number--;
                System.out.println(Thread.currentThread().getName() +" 卖出一张，还剩 " + number);
            }
        } finally {  // 防止有异常时，不能释放锁
            LOCK.unlock();
        }
    }
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
           do{
               ticket.sell();
           }while (ticket.number > 0);
        },"A").start();
        new Thread(()->{
            do{
                ticket.sell();
            }while (ticket.number > 0);
        },"B").start();
        new Thread(()->{
            do{
                ticket.sell();
            }while (ticket.number > 0);
        },"C").start();
    }
}
