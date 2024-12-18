package com.rpc;

import com.rpc.core.RpcProxyServer;
import com.rpc.service.impl.UserServiceImpl;

/**
 * Hello world!
 */
public class Server {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        RpcProxyServer proxyServer = new RpcProxyServer();
        proxyServer.publish(userService,8080);

        System.out.println("Hello World!");
    }
}
