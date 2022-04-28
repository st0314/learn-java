package vip.grmz.test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java9Test {
    @Test
    public void test(){

        try {
            URL url = new URL("https://www.google.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    // java9特性5： 钻石操作符的升级
    // java9 feature 5: upgrade of diamond operator
    @Test
    public void test2(){

        // 钻石操作符与匿名内部类在java8中不能共存，在java9中可以
        // The diamond operator and anonymous inner classes cannot coexist in java8, but can in java9
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o, Object t1) {
                return 0;
            }
        };
    }

    // Java9 feature six: upgrade of try operation
    // java9 特性六： try操作的升级
    public static void main(String[] args) {

        // java 8 zhi qian
        /* InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);

            char[] c = new char[20];
            int len;
            if ((len = reader.read(c)) != -1){
                String str = new String(c,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //java 8 zhong zi yuan guan bi cao zuo
        // zi dong guan bi zi yuan
        try(InputStreamReader reader = new InputStreamReader(System.in)){

        char[] c = new char[20];
        int len;
        if ((len = reader.read(c)) != -1){
            String str = new String(c,0,len);
            System.out.println(str);
        }
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */


        // java 9 zhong zi yuan guan bi cao zuo
        // java9中关闭资源的操作： 需要自动关闭的资源的实例化可以放在try的一对小括号的外面
        InputStreamReader reader = new InputStreamReader(System.in);
        try(reader){
            char[] c = new char[20];
            int len;
            if ((len = reader.read(c)) != -1){
                String str = new String(c,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

