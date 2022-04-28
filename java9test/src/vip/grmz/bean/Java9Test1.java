package vip.grmz.bean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Java9Test1 {

    //java9新特性10： Stream API的加强
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5,32432,23,43,3,5435,98);
        //takeWhile() 返回从头开始的按照指定规则尽量多的元素
        //list.stream().takeWhile(x -> x < 60).forEach(System.out::println);

        //dropWhile(): 与takeWhile 相反。 返回剩余的元素
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
    }

    @Test
    public void test1(){
        //of() 参数中的多个元素，可以包含null值
        Stream<Integer> stream = Stream.of(1, 2, 3, null);
        stream.forEach(System.out::println);

        //of() 参数不能存储单个null值, 否则报异常
        //Stream<Integer> stream1 = Stream.of(null);
        //stream1.forEach(System.out::println);

        //ofNullable(): 形参变量可以是null值得单个元素
        Stream<Integer> stream2 = Stream.ofNullable(null);
        long count = stream2.count();
        System.out.println(count);
    }

    //
    @Test
    public void test2(){

        // 创建无限流
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);


        //java9 中的重载方法
        Stream.iterate(0, x -> x < 100, x -> x + 1).forEach(System.out::println);
    }

    // java9新特性11： Optional提供新的方法stream()
    @Test
    public void test3(){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Optional<List<Integer>> optional = Optional.ofNullable(list);
        //
        Stream<List<Integer>> stream = optional.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
    }


}
