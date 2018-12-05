package com.example.ableqing.androidkeyboardviewdemo;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        Pattern p =  Pattern.compile("f{4,5}");

        Matcher matcher = p.matcher("fff");
        boolean b = matcher.find();
//        String group = matcher.group();
//        String replaceAll = matcher.replaceAll( "r");


        //String group1 = matcher.group("5");
        System.out.println("matcher.find() ==  "+b);
    }
}