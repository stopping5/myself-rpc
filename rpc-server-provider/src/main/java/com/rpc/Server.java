package com.rpc;

import com.rpc.core.RpcProxyServer;
import com.rpc.core.SpringConfig;
import com.rpc.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class Server {
    public static void main(String[] args) {
        // v2 升级接口实现类由spring容器管理
//        UserServiceImpl userService = new UserServiceImpl();
//
//        RpcProxyServer proxyServer = new RpcProxyServer();
//        proxyServer.publish(userService,8080);
//
//        System.out.println("Hello World!");


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        applicationContext.start();
    }
}
