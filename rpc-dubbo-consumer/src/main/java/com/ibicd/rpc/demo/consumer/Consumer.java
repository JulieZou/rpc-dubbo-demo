package com.ibicd.rpc.demo.consumer;

import com.ibicd.rpc.demo.framework.register.ProxyFactory;
import com.ibicd.rpc.demo.framework.service.HelloService;

public class Consumer {

    public static void main(String[] args) {
        HelloService helloService =  ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("Julie");
        System.out.println("调用结果：" + result);
    }
}
