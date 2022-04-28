package vip.grmz.stram;

import org.junit.Test;
import vip.grmz.lambda2.Employee;
import vip.grmz.lambda2.EmployeeData;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的 终止操作
 */
public class StreamTest2 {

    //1.匹配与查找
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        //allMatch(Predicate p)   检查是否匹配所有元素
        boolean b = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
        //gong zi dou da yu 10000
        boolean b1 = list.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);

        //shi fou cun zai xin lei de yuan gong
        boolean lz = list.stream().noneMatch(e -> e.getName().startsWith("lz"));
        System.out.println(lz);

        //di yi ge
        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first);

        //ref yi de yi ge
        Optional<Employee> any = list.stream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2(){
        List<Employee> list = EmployeeData.getEmployees();

        //count()  fan hui liu zhong yuan su de zong ge shu
        long count = list.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        //max(Comparator c)  fan hui liu zhong de zui da zhi
        //exer: fan hui zui gao de gong zi
        Stream<Double> salary = list.stream().map(e -> e.getSalary());
        Optional<Double> max = salary.max(Double::compare);
        System.out.println(max);
        //min(Comparator c)   fj hv lq vs de zv xc vi
        //fan hui gong zi zui di de yuan gong
        Optional<Employee> employee = list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);
        System.out.println();

        //forEach(Consumer c)   nei bu die dai
        list.stream().forEach(System.out::println);
        //ui ys ji he de bm li ck zo
        list.forEach(System.out::println);



    }

    //hv yt
    @Test
    public void test3(){
        //reduce(T identity, BinaryOperator)   ke yi jd lq vs yr su fj fu jx he qi ll, de dk yi ge vi, fj hv
        // ji sr ji he vs so yb uu de he
        List<Integer> list = Arrays.asList(1,2,3,34,4,5,6,7,7,8);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //reduce(BinaryOperator)  ke yi jd lq vs yr su fj fu jx he  qi ll,de dk yi ge vi ,fj hv Optional<T>
        //exer2: 计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        System.out.println(reduce1);

    }

    //3. shou ji
    @Test
    public void test4(){
        //collect(Collector c)

        List<Employee> list = EmployeeData.getEmployees();
        List<Employee> collect = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        System.out.println(collect1);

    }
    @Test
    public void test5() throws InterruptedException, ExecutionException {
        //
        Thread th = new Thread(() -> {
            System.out.println("duoxianchen");
        });
        th.start();
        ExecutorService service = Executors.newCachedThreadPool();
        Future<?> future = service.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "Hello World!" + Thread.currentThread().getName();
            }
        });

        //使用Lambda表达式
        Future<String> future1 = service.submit(() -> "Hello World" + Thread.currentThread().getName());


    }

    @Test
    public void test6(){
        int a = 1;
        int b = ++a + ++a;
        System.out.printf("%d, %d\n", a, b);
        System.out.printf("%d\n",1);

        int m = 5;
        //m = m << -2;
        System.out.println(m);
        System.out.printf("m = %d, m+=m-=m*m = %d, m = %d\n", m, m+=m-=m*m, m);
    }

    @Test
    public void test7(){
        int a = 2100000000;
        short s = 32767;
        byte i = 127;
        int c = 'c';
        long l = 9223372036854775807L;
        BigInteger b = BigInteger.valueOf(4892709447523499098L);
        //System.out.println(a*l);

    }
    public static void process(Runnable r){
        r.run();
    }
    public static void process1(Callable<String> c) throws Exception {
        c.call();
    }

}
