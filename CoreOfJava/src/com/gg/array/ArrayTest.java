package com.gg.array;

import java.util.Arrays;

/**
 * @author 33863
 * @create 2022-02-18 20:01
 * @desc
 **/
public class ArrayTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = Arrays.copyOf(a, 2 * a.length);
        for (int i : b) {
            System.out.println("i = " + i);
        }
        System.out.println("b.length = " + b.length);


    }
}
