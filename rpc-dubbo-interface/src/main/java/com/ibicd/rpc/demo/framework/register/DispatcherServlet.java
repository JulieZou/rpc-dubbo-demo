package com.ibicd.rpc.demo.framework.register;

import com.ibicd.rpc.demo.framework.protocol.HttpServerHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DispatcherServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 服务调用请求 HttpServerHandler

        // 统计数据的请求，MonitorHanlder

        //回声测试 EchoHanlder

        new HttpServerHandler().handler(req, resp);
    }

}
