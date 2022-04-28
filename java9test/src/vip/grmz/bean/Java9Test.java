package vip.grmz.bean;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class Java9Test {

    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("liming");
        list.add("wangmei");
        list.add("jery");

        // 返回的list是一个只读的集合
        list = Collections.unmodifiableList(list);

        // list.add("xiaowang");
        System.out.println(list);
    }

    @Test
    public void test2(){

        // zhi du ji he
        List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c", "d"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a", "b", "c", "d")));
        // 如下操作不适用于java8及之前的版本，适用于jdk9
        Map<Object, Object> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });

        map.forEach((k,v) -> System.out.println(k + ":" + v));
    }

    // java9 新特性8： 集合工厂方法： 创建只读集合
    @Test
    public void test3(){

        // 此时得到的list也是只读集合
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7);
        Set<Integer> set = Set.of(1, 2, 3, 4);
        Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3);


        //bu neng tian jia
        // map.put("d", 4);
        // set.add(2);
        // list.add(6);
        // list1.add(3);

        System.out.println(map);

        Map<String, Integer> map2 = Map.ofEntries(Map.entry("tom", 3), Map.entry("liming", 4));

        //map2.put("wangmei",5);
        System.out.println(map2);
    }

    //java9新特性9： InputStream的新方法： tranferTo()
    @Test
    public void test5(){
        ClassLoader c1 = this.getClass().getClassLoader();
        try(InputStream is = c1.getResourceAsStream("hello.txt");
        OutputStream os = new FileOutputStream("src/hello1.txt")){
            is.transferTo(os);   //把输入流中的所有数据直接自动复制到输出流中
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void test6(){

    }
}
