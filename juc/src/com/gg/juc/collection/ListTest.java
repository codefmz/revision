package com.gg.juc.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 33863
 * @create 2022-02-01 15:43
 * @desc 证明List是线程不安全的
 **/
public class ListTest {
    private static int m = 1;
    public static void main(String[] args) throws InterruptedException {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<String>());
//        Set<String> set = new HashSet<>();
//        Set<String> set = new CopyOnWriteArraySet<>();
        Map<String,String>  map= new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                String key = String.valueOf(ListTest.m++);
                map.put(key,UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName()+": map = " + map);
            }, i + "").start();
        }
        Thread.sleep(2000);
        System.out.println(map.size());
    }
}
