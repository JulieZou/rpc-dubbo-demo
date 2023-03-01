package com.ibicd.rpc.demo.framework.register;

import com.ibicd.rpc.demo.framework.protocol.HttpClient;
import com.ibicd.rpc.demo.framework.service.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory<T> {

    public static <T> T getProxy(final Class interfaceClass){
        Object newProxyInstance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(HelloService.class.getName(), method.getName(), new Class[]{String.class}, args);
                HttpClient client = new HttpClient();
                return  client.send("localhost",8080,invocation);
            }
        });
        return (T)newProxyInstance;
    }

}
