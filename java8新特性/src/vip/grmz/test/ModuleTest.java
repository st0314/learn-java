package vip.grmz.test;

import vip.grmz.bean.MyInterface;
import vip.grmz.bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

public class ModuleTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Person p = new Person("tom",18);
        System.out.println(p);

        // A static method in an interface can only be called by itself
        // 接口中的静态方法只能由自己调用
        MyInterface.methodStatic();
        MyInterface m = new MyInterface() {
            @Override
            public void methodAbstract() {
                System.out.println("this is interface's abstract method");
            }

            @Override
            public void methodDefault() {
                MyInterface.super.methodDefault();
            }
        };
        m.methodDefault();

        // Class clazz = MyInterface.class;
        // Constructor cons = clazz.getConstructor();
        // MyInterface inter = (MyInterface) cons.newInstance();
        // System.out.println(inter.toString());

    }
}
