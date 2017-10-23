package 单例模式;

/**
 * @author hjy
 * @create 2017/10/23
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 懒汉式单例，在第一次调用getInstance()时实例化自己
 * 在类加载时并不执行实例化，延迟加载技术（Lazy Load）
 * 避免多线程同时调用，使用synchronized线程锁保证线程安全
 *
 * 但是每次调用getInstance()时都需要进行线程锁定判断，
 * 在多线程高并发访问环境中，将会导致系统性能大大降低。
 */
class Singleton1{
    private static Singleton1 instance=null;
    public static synchronized Singleton1 getInstance(){
        if(instance==null) {
            instance = new Singleton1();
        }
        return instance;
    }

    private Singleton1(){
    }
}

/**
 * 改进，只对instance = new Singleton2();进行加锁
 * 但多线程还是会存在单例对象不唯一
 */
class Singleton2 {
    private static Singleton2 instance=null;
    public static Singleton2 getInstance(){
        if(instance==null){
            //全局锁，锁住了这个类对于的Class对象
            synchronized (Singleton1.class) {
                instance = new Singleton2();
            }
        }
        return instance;
    }
    private Singleton2(){
    }
}

/**
 * 改进，双重检查锁的形式
 * 被volatile修饰的成员变量可以确保多个线程都能够正确处理
 * volatile关键字会屏蔽Java虚拟机所做的一些代码优化，
 * 可能会导致系统运行效率降低
 */
class Singleton3{
    private static volatile Singleton3 instance=null;
    private Singleton3(){
    }
    public static  Singleton3 getInstance(){
        //第一重判断
        if(instance==null){
            //锁定代码块
            synchronized(Singleton3.class){
                //第二重判断
                if(instance==null){
                    //创建单例实例
                    instance=new Singleton3();
                }
            }
        }
        return instance;
    }
}



/**
 * 饿汉式
 */
class Singleton4{
    //在自己内部定义自己的一个实例，只供内部调用
    private static final Singleton4 instance = new Singleton4();
    private Singleton4(){
        //do something
    }
    //这里提供了一个供外部访问本class的静态方法，可以直接访问
    public static Singleton4 getInstance(){
        return instance;
    }
}

/**
 * IoDH
 */
class Singleton5 {
    private Singleton5() { }
    //静态内部类
    private static class HolderClass {
        private final static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return HolderClass.instance;
    }
}

class Singleton {
    private Singleton() {
    }

    private static class HolderClass {
        private final static Singleton instance1 = new Singleton();
        private final static Singleton instance2 = new Singleton();
        private final static Singleton instance3 = new Singleton();
        private final static Singleton instance4 = new Singleton();
    }

    public static Singleton getInstance() {
        Random random = new Random();
        int i = random.nextInt(4);
        if(i == 1) {
            return HolderClass.instance1;
        } else if (i == 2) {
            return HolderClass.instance2;
        } else if (i ==3) {
            return HolderClass.instance3;
        } else {
            return HolderClass.instance4;
        }
    }
}

public class Test {
}
