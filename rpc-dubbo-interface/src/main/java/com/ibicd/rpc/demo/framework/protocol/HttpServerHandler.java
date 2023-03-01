package com.ibicd.rpc.demo.framework.protocol;

import com.ibicd.rpc.demo.framework.register.Invocation;
import com.ibicd.rpc.demo.framework.register.LocalRegister;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){

        // 反序列化 JSON,Hession gRPC,protobuf
        try {
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();
            String interfaceName = invocation.getInterfaceName();
            Class implClass = LocalRegister.get(interfaceName);
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamType());

            // implClass.newInstance() 已经过期，使用 implClass.getDeclaredConstructor(paramTypes).newInstance(params);
            Object instance = implClass.getDeclaredConstructor(invocation.getParamType()).newInstance(invocation.getParams());
            // 执行的结果
            String result = (String) method.invoke(instance,invocation.getParams());
            IOUtils.write(result,resp.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
