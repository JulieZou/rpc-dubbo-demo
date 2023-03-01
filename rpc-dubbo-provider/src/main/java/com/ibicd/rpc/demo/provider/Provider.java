package com.ibicd.rpc.demo.provider;

import com.ibicd.rpc.demo.framework.protocol.HttpServer;
import com.ibicd.rpc.demo.framework.register.LocalRegister;
import com.ibicd.rpc.demo.framework.service.HelloService;

public class Provider {

    public static void main(String[] args) {
        //接收网络请求（Tomcat,Jetty,Netty,ServerSocket）

        LocalRegister.regist(HelloService.class.getName(),HelloService.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8089);


    }
}
