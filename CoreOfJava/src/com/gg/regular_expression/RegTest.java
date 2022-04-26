package com.gg.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 33863
 * @create 2022-02-20 20:47
 * @desc
 **/
public class RegTest {
    public static void main(String[] args) {
        String reg = "(\\d\\d)(\\d\\d)";
        Pattern pattern = Pattern.compile(reg);
        String str = "Java(英式发音[ˈʤɑːvə],美式发音[ˈʤɑvə])是一种广泛使用的计算机编程语言，拥有跨平台、面向对象、泛型编程的特性，广泛应用于企业级Web应用开发和移动应用开发。\n" +
                "\n" +
                "任职于Sun微系统的詹姆斯·高斯林等人于1990年代初开发Java语言的雏形，最初被命名为Oak，目标设置在家用电器等小型系统的编程语言，应用在电视机、电话、闹钟、烤面包机等家用电器的控制和通信。由于这些智能化家电的市场需求没有预期的高，太阳计算机系统（Sun公司）放弃了该项计划。随着1990年代互联网的发展，Sun公司看见Oak在互联网上应用的前景，于是改造了Oak，于1995年5月以Java的名称正式发布。Java伴随着互联网的迅猛发展而发展，逐渐成为重要的网络编程语言。\n" +
                "\n" +
                "Java编程语言的风格十1111分接近C++语言。继承了C++语言面向对象技术的核心，舍弃了容易引起错误的指针，以引用取代；移除了C++中的运算符重载和多重继承特性，用接口取代；增加垃圾回收器功能。在Java SE 1.5版本中引入了泛型编程、类型安全的枚举、不定长参数和自动装/拆箱特性。Sun微系统对Java语言的解释是：“Java编程语言是个简单、面向对象、分布式、解释性、健壮、安全、与系统无关、可移植、高性能、多线程和动态的语言”。";
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println("found  = "  + matcher.group(2));
        }
    }
}
