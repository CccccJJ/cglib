package com.cc;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.MessageFormat;

public class DaoAnotherProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(MessageFormat.format("StartTime[{0}]", System.currentTimeMillis()));
        methodProxy.invokeSuper(o,objects);
        System.out.println(MessageFormat.format("EndTime[{0}]", System.currentTimeMillis()));

        return o;
    }
}
