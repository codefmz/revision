package com.gg.array.object;

import java.util.*;

/**
 * @author 33863
 * @create 2022-02-19 18:24
 * @desc
 **/
public  class ClassTest {
    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTest classTest = (ClassTest) o;
        return name.equals(classTest.name) && age.equals(classTest.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(null,null);
        for (Map.Entry<String, String> entry : stringStringHashMap.entrySet()) {
            System.out.println(entry.getKey() + "==" + entry.getValue());
        }

    }
}

enum Session{
    Spring("春天","鸟语花香！"),Summer("夏天","酷暑难耐！");
    private String name;
    private String desc;

    Session(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static void main(String[] args) {
    }
}

class A{
    private Integer i;

    public A(Integer i) {
        this.i = i;
    }


    @Override
    public int hashCode() {
        return 100;
    }
}
