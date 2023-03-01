package com.ibicd.rpc.demo.provider.impl;

import com.ibicd.rpc.demo.framework.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
