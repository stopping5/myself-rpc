package com.rpc;

import com.rpc.core.RpcClientProxy;
import com.rpc.entity.User;
import com.rpc.service.UserService;

import java.io.IOException;
import java.net.Socket;

/**
 * Hello world!
 */
public class ClientApplication {
    public static void main(String[] args) throws IOException {
        UserService  userService = new RpcClientProxy().clientProxy(UserService.class,"localhost",8080);
        String name = userService.saveUser(new User("name", 18));
        System.out.println("result  = " + name);
    }
}
