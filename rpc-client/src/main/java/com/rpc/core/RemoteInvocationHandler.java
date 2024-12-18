package com.rpc.core;

import com.rpc.common.RpcRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Data
@AllArgsConstructor
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;

    private Integer port;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest(method.getDeclaringClass().getName(),method.getName(),args);
        Object o = new RpcNetTransport(host,port).send(request);
        return o;
    }
}
