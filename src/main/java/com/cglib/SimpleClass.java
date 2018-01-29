package com.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author FaceFeel
 * @Created 2017-12-17 21:02
 */

public class SimpleClass {

    public void test() {
        System.out.println("test Method !");
    }

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SimpleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("before method run....");

                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("after method run....");
                return result;
            }
        });
        SimpleClass obj= (SimpleClass) enhancer.create();
        obj.test();
    }
}
