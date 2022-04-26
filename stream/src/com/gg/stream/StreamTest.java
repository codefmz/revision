package com.gg.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 33863
 * @create 2021-12-16 10:17
 * @desc 测试 stream
 **/
public class StreamTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
//        //1.测试使用集合
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("王建国");
//        arrayList.add("李建平");
//        arrayList.add("段建京");
//        //返回一个顺序流
//        Stream<String> stream = arrayList.stream();
//        //返回一个并行流
//        Stream<String> stringStream = arrayList.parallelStream();
//
        //2.测试数组
        String[] strings1 = {"杨间", "杨戬", "阳间"};
        Stream<String> stream1 = Arrays.stream(strings1);
        Stream<String> strings11 = Stream.of(strings1);
        //3.创建无限流
//        Stream.iterate(0, t-> t+3).limit(5).forEach(System.out::println);
//        Stream.generate(UUID::randomUUID).limit(5).forEach(System.out::println);


//         中间操作
        int[] ints = new int[1000];
        for (int i = 0; i < 1000; i++) {
            ints[i] = (int) (Math.random() * 1000);
        }
        IntStream intStream = Arrays.stream(ints);
//        Arrays.stream(ints).filter(e -> e % 3== 0).forEach(System.out::println);
//        long count1 = Arrays.stream(ints).skip(3).count();
//        long count = Arrays.stream(ints).limit(30).distinct().count();
//        System.out.println("count1 = " + count1);
//        System.out.println(Arrays.stream(ints).map(t -> t / 1000).distinct().count());

//        Arrays.stream(ints).sorted().forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("王子新");
        list.add("王子旧");
        list.add("王子同");
        list.add("样件");
//        list.stream().sorted((e1, e2) -> - e1.compareTo(e2)).forEach(System.out::println);
        //3. 终端操作
//        boolean b = intStream.allMatch(e -> e > 20);
//        boolean b2 = intStream.anyMatch(e -> e > 20);
//        boolean b3 = intStream.noneMatch(e -> e == 20);

//        OptionalInt reduce1 = intStream.reduce(Integer::sum);
//        int s = 0;
//        //这里 s 只是一个类型的象征， 也只能是int类型，
//        int reduce = intStream.reduce(s, Integer::sum);
//        System.out.println("reduce = " + reduce);
//        System.out.println("s = " + s);
//            intStream.collect()
    }
}
