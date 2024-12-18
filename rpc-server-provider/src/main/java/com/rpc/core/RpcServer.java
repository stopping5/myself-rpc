package com.rpc.core;

import com.rpc.annotation.RpcService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class RpcServer implements ApplicationContextAware, InitializingBean {

    private int port;

    public RpcServer(int port) {
        this.port = port;
    }

    /**
     * Bean映射
     */
    private final Map<String,Object> handlerBean = new HashMap<>();


    Executor threadPool = Executors.newCachedThreadPool();

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            //不断接收请求
            while (true){
                threadPool.execute(new ProcessorHandler(serverSocket.accept(),handlerBean));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭serverSocket
            if (Objects.nonNull(serverSocket)){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获取RpcService注解的Bean - 该Bean是接口实现类，参数是接口
        Map<String, Object> beanMapping = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!beanMapping.isEmpty()){
            for (Object o : beanMapping.values()){
                RpcService annotation = o.getClass().getAnnotation(RpcService.class);
                //key=接口名，val=实现Bean
                handlerBean.put(annotation.interfaceClass().getName(),o);
            }
        }


    }
}
