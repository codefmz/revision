package com.gg.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 33863
 * @create 2022-02-09 14:39
 * @desc
 **/
public class ForkJoinTest extends RecursiveTask<Long> {

    private int begin;
    private int end;
    private long sum;

    public ForkJoinTest(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {
        System.out.println("从 " + begin + " 加到" + end);
        if (end - begin <= 10) {
            for (int i = begin; i <= end; i++) {
                sum += i;
            }
        }else {
            int middle = (begin + end)/2;
            ForkJoinTest forkJoinTest = new ForkJoinTest(begin, middle);
            ForkJoinTest forkJoinTest2 = new ForkJoinTest(middle + 1, end);
            forkJoinTest.fork();
            forkJoinTest2.fork();
            sum = forkJoinTest.join() + forkJoinTest2.join();
        }

        return sum;
    }

    public static void main(String[] args) {
        //定义任务
        ForkJoinTest forkJoinTest = new ForkJoinTest(0, 100);
        //定义执行对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //加入任务执行
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinTest);
        try {
            Long aLong = submit.get();
            System.out.println("aLong = " + aLong);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            forkJoinPool.shutdown();//关闭线程池
        }
    }
}
