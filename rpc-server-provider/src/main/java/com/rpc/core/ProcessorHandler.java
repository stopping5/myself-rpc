package com.rpc.core;

import com.rpc.common.RpcRequest;
import lombok.AllArgsConstructor;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 异步处理socket请求接入
 */
@AllArgsConstructor
public class ProcessorHandler implements Runnable{

    private Socket socket;

    private Map<String,Object> handlerBean = new HashMap<>();


    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest request = (RpcRequest)objectInputStream.readObject();
            Object result = invoke(request);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {

            if(Objects.nonNull(objectInputStream)){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (Objects.nonNull(objectOutputStream)){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }


    private Object invoke(RpcRequest request){
        String className = request.getClassName();
        String methodName = request.getMethodName();

        Object service = handlerBean.get(className);
        if (Objects.isNull(service)){
            throw new RuntimeException("service is null = " + className);
        }


        Object[] param = request.getParam();
        Class<?>[] types = new Class[param.length];
        for (int i = 0; i < param.length; i++) {
            types[i] = param[i].getClass();
        }
        try {
            Class<?> clazz = Class.forName(className);
            //通过反射机制调用本地方法
            return clazz.getMethod(methodName, types).invoke(service, param);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
