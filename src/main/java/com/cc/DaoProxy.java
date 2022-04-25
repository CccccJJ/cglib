package com.cc;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DaoProxy implements MethodInterceptor {

    /**
     * @param o           要增强的对象
     * @param method      要拦截的方法
     * @param objects     参数列表，基本类型需要传入其包装类型 int -> Integer, long -> Long, double -> Double
     * @param methodProxy 对方法的代理，invokeSuper 方法表示对被代理对象方法的调用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before method invoke");
        methodProxy.invokeSuper(o, objects);
        System.out.println("After method invoke");
        return o;
    }
}
