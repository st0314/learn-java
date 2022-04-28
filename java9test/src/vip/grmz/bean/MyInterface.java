package vip.grmz.bean;

public interface MyInterface {
    void methodAbstract();

    static void methodStatic(){
        System.out.println("this is static method!");
    }

    default void methodDefault(){
        System.out.println("this is interface's default method");
        this.methodPrivate();
    }

    //Private methods can be defined in jdk9  jdk9中可以定义私有的方法
    private void methodPrivate(){
        System.out.println("this is private method in interface");
    }
}
