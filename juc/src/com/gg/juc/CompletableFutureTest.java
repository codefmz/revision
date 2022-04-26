package com.gg.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * @author 33863
 * @create 2022-02-09 15:53
 * @desc
 **/
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "子线程开始干活");
                //子线程睡 5 秒
                Thread.sleep(5000);
                //在子线程中完成主线程
                future.complete("success");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        //主线程调用 get 方法阻塞
        System.out.println("主线程调用 get 方法获取结果为: " + future.get());
        System.out.println("主线程完成,阻塞结束!!!!!!");
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        //运行一个没有返回值的异步任务
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("子线程启动干活");
                Thread.sleep(5000);
                System.out.println("子线程完成");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //主线程阻塞
        future.get();
        System.out.println("主线程结束");
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("子线程启动干活");
                Thread.sleep(5000);
                System.out.println("子线程完成");
                return "ssss";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
        String s = completableFuture.get();
        System.out.println("主线程结束了，返回的结果  s = " + s);
    }

    @Test
    public void test4() {
        System.out.println("主线程开始！！！！");
        CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("子线程启动干活");
                        Thread.sleep(5000);
                        System.out.println("子线程完成");
                        return "ssss";
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "bbbb";
                }).thenApply(String::toUpperCase)
                .thenAccept(System.out::println);
    }
}
