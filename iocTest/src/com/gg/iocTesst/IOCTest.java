package com.gg.iocTesst;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author 33863
 * @create 2022-03-04 19:19
 * @desc
 **/
public class IOCTest {

    @Test
    public void test() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter out = new PrintWriter("test.txt", StandardCharsets.UTF_16.toString());
        String name = "王子辛";
        double value = 1200.0;
        out.print(name);
        out.print(" 重达  ");
        out.print(value);
        out.flush();
        out.close();
        Date date = new Date();
    }
}
