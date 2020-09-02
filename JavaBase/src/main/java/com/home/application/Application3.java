package com.home.application;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程
 */
public class Application3 {
    public static void main(String[] args) {

//        test01();
//        test02();
//        test03();
//        test04();
        test05();
    }

    public static void test01(){
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();
    }

    public static void test02(){
        Application3 application3 = new Application3();
        // ThreadDemo2实现Runnable接口，并实现run()
        Application3.ThreadDemo2 target = application3.new ThreadDemo2();
        // 调用Thread构造方法，传入TreadDemo2的实例对象，创建线程对象
        Thread t = new Thread(target);
        // 开启线程：t线程得到CPU执行权后会执行run()中的代码
        t.start();
    }

    public static void test03(){
        new Thread(()-> System.out.println("Thread is running")).start();
    }


    // 一、创建多线程的2种方式
    // 1.继承Thread类，重写run()方法
    public static class ThreadDemo1 extends Thread{

        @Override
        public void run() {
            System.out.println("Thread is running");
        }
    }

    // 2.实现Runnable接口，实现run()方法
    public class ThreadDemo2 implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread is running");
        }
    }

    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("我要一个教练");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("教练来了： " +Thread.currentThread().getName());
            System.out.println("教我游泳,交完后，教练回到了游泳池");
        }
    }

    // 二、使用线程池方式
    // 1.Runnable接口
    public static void test04(){
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(2);//包含2个线程对象

        Application3 application3 = new Application3();
        //创建Runnable实例对象
        Application3.MyRunnable r = application3.new MyRunnable();
        //从线程池中获取线程对象,然后调用MyRunnable中的run()
        service.submit(r);
        //再获取个线程对象，调用MyRunnable中的run()
        service.submit(r);
        service.submit(r);
    }

    // 2.Callable接口
    public static void test05() {
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(2);//包含2个线程对象
        //创建Callable对象
        Application3 application3 = new Application3();
        MyCallable c = application3.new MyCallable();
        //从线程池中获取线程对象,然后调用MyRunnable中的run()
        service.submit(c);
        //再获取个教练
        service.submit(c);
        service.submit(c);
        //注意：submit方法调用结束后，程序并不终止，是因为线程池控制了线程的关闭。将使用完的线程又归还到了线程池中

        //关闭线程池，也可以不关闭
        //service.shutdown();
    }

    // Callable接口实现类,call方法可抛出异常、返回线程任务执行完毕后的结果
    public class MyCallable implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("我要一个教练:call");
            Thread.sleep(2000);
            System.out.println("教练来了： " +Thread.currentThread().getName());
            System.out.println("教我游泳,交完后,教练回到了游泳池");
            return null;
        }
    }


}
