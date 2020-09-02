package com.home.application;

import com.home.common.Calculator;
import com.home.common.CalculatorImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AppDynamicProxy {
    public static void main(String[] args) throws Throwable {

//        test01();
        test02();

    }

    /**
     * 动态代理简单实现，需要手动new被代理的对象
     * @throws Throwable
     */
    public static void test01() throws Throwable {
        Class calculatorProxyClazz = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
        // 得到有参构造器
        Constructor constructor = calculatorProxyClazz.getConstructor(InvocationHandler.class);
        // 反射创建实例
        Calculator calculatorProxyImpl = (Calculator)constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 手动new一个对象（被代理的对象）
                CalculatorImpl calculatorImpl = new CalculatorImpl();
                System.out.println("方法开始执行...");
                // 反射执行目标对象的方法
                Object result = method.invoke(calculatorImpl, args);
                System.out.println("方法执行结束...");
                // 返回目标对象执行结果（被代理后的对象）
                return result;
            }
        });

        calculatorProxyImpl.add(1,2);
        calculatorProxyImpl.add(2,2);
    }

    public static void test02() throws Throwable{
        // 被代理对象
        CalculatorImpl target = new CalculatorImpl();
        // 被代理后的对象
        Calculator calculatorProxy = (Calculator)getProxy(target);
        // 被代理后的对象具有了额外的功能
        calculatorProxy.add(1,2);
        calculatorProxy.add(3,4);
    }

    /**
     * 动态代理，给代理对象添加额外的功能
     * @param target 被代理的对象
     * @return 被代理后的对象
     * @throws Exception
     */
    private static Object getProxy(final Object target) throws Exception{
        //参数1：随便找个类加载器给它， 参数2：目标对象实现的接口，让代理对象实现相同接口
        Class proxyClazz = Proxy.getProxyClass(target.getClass().getClassLoader(),target.getClass().getInterfaces());
        // 得到有参构造器
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        Object proxy = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + ("方法前添加代理功能"));
                Object result = method.invoke(target, args);
                System.out.println(result);
                System.out.println(method.getName() + ("方法后添加代理功能"));
                return result;
            }
        });
        return proxy;
    }

    /**
     * 动态代理，给代理对象添加额外的功能（简化版本）
     * @param target 被代理的对象
     * @return 被代理后的对象
     * @throws Exception
     */
    private static Object getProxy2(final Object target) throws Exception{
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName() + ("方法前添加代理功能"));
                        Object result = method.invoke(target, args);
                        System.out.println(result);
                        System.out.println(method.getName() + ("方法后添加代理功能"));
                        return result;
                    }
                });
        return proxy;
    }


}
