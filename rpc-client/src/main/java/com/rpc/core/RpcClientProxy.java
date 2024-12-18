package com.rpc.core;

import com.rpc.service.UserService;

import java.lang.reflect.Proxy;

/**
 * RPC客户端代理
 */
public class RpcClientProxy {

    /**
     * 客户端代理
     * @param interfaceClazz
     * @param host
     * @param port
     * @return
     */
    public <T> T clientProxy(final Class<T> interfaceClazz,String host,int port) {
        return (T) Proxy.newProxyInstance(interfaceClazz.getClassLoader(),new Class<?>[]{interfaceClazz}, new RemoteInvocationHandler(host,port));
    }
}
